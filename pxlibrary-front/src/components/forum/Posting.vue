<template>
  <el-container>
    <el-main>
      <div class="title">
        <el-input v-model="title" placeholder="输入文章标题"></el-input>
        <el-select v-model="integral" placeholder="请选择赏分分数">
          <el-option
            v-for="item in integrals"
            :key="item"
            :label="item"
            :value="item">
          </el-option>
        </el-select>
        <div class="integral">
          <img src="../../assets/imgs/score.png" />
          <div>可用积分:{{myIntegral}}</div>
        </div>
      </div>
      <div class="indexContainer">
        <div class="maskContainer" v-if="dilogStatus">
          <div class="contentContainer">
            <div class="closeBtnContainer" @click="closeMaskFn"></div>
            <textarea class="showAreaContainer" v-model="msgShow" readonly></textarea>
          </div>
        </div>
        <div class="editorContainer">
          <markdown
            :mdValuesP="msg.mdValue"
            :fullPageStatusP="false"
            :editStatusP="true"
            :previewStatusP="true"
            :navStatusP="true"
            :icoStatusP="true"
            @childevent="childEventHandler"
          ></markdown>
        </div>
      </div>
      <div class="choice-plate">
        <span>主题板块</span>
        <el-cascader
          v-model="plate"
          :options="plates"
          :props="{ expandTrigger: 'hover' }"
          @change="handleChange"></el-cascader>
      </div>
      <el-button class="" type="info" @click="publish">发 表</el-button>
      <div class="notes">
        <ul>
          <li>可用分不足时扣除全部可用分，欠缺积分由等比例Y币填补，显示的可用分包含原有可用分+Y币折算后的（1Y币=10可用分）。</li>
          <li>请遵守飘雪文库用户行为准则，不得违反国家法律法规。</li>
          <li>转载文章请注明出自“飘雪文库”，如是商业用途请联系原作者。</li>
          <li>为了维护良好的技术讨论环境，请不要讨论政治 相关话题。</li>
        </ul>
      </div>
    </el-main>
  </el-container>
</template>

<script>
    import markdown from '../components/Mdeditor'
    export default {
        name: "Posting",
      data() {
        return {
          title:"",
          myIntegral: "230",
          plate: [],
          plates: [
            {
              value:"移动开发",
              label: "移动开发",
              children: [{
                value: 'Android',
                label: 'Android'
              }, {
                value: 'iOS',
                label: 'iOS'
              }, {
                value: 'Qt',
                label: 'Qt'
              }, {
                value: 'WP',
                label: 'WP'
              }]
            },
            {
              value:"Java技术",
              label: "Java技术",
              children: [{
                value: 'Java SE',
                label: 'Java SE'
              }, {
                value: 'Java Web 开发',
                label: 'Java Web 开发'
              }, {
                value: 'Java EE',
                label: 'Java EE'
              }, {
                value: 'Java其他相关',
                label: 'Java其他相关'
              }]
            },
            {
              value:"Web开发",
              label: "Web开发",
              children: [{
                value: 'PHP',
                label: 'PHP'
              }, {
                value: 'JavaScript',
                label: 'JavaScript'
              }, {
                value: 'ASP',
                label: 'ASP'
              }, {
                value: 'HTML(CSS)',
                label: 'HTML(CSS)'
              },{
                value: 'HTML5',
                label: 'HTML5'
              },{
                value: 'Apache',
                label: 'Apache'
              },]
            },
            {
              value:"数据库开发",
              label: "数据库开发",
              children: [{
                value: 'Oracle',
                label: 'Oracle'
              }, {
                value: 'MS-SQL Server',
                label: 'MS-SQL Server'
              }, {
                value: '其他数据库开发',
                label: '其他数据库开发'
              },]
            },
            {
              value:"硬件/嵌入式开发",
              label: "硬件/嵌入式开发",
              children: [{
                value: '嵌入开发(WinCE)',
                label: '嵌入开发(WinCE)'
              }, {
                value: '驱动开发/核心开发',
                label: '驱动开发/核心开发'
              }, {
                value: '硬件设计',
                label: '硬件设计'
              }, {
                value: '单片机/工控',
                label: '单片机/工控'
              },{
                value: '汇编语言',
                label: '汇编语言'
              }]
            },
            {
              value:"Linux/Unix社区",
              label: "Linux/Unix社区",
              children: [{
                value: '系统维护与使用区',
                label: '系统维护与使用区'
              }, {
                value: '应用程序开发区',
                label: '应用程序开发区'
              }, {
                value: '内核源代码研究区',
                label: '内核源代码研究区'
              }, {
                value: '驱动程序开发区',
                label: '驱动程序开发区'
              },{
                value: 'CPU和硬件区',
                label: 'CPU和硬件区'
              }]
            },
          ],
          integral: '',
          integrals: ["0","100","200","300","400"],
          option:[],
          value:'',
          id:'',
          msgShow:'我要显示的内容',
          dilogStatus:false,
          msg: {
            mdValue:''
          },
          flag:false,
        }
      },
      methods: {
        childEventHandler:function(res){
          // res会传回一个data,包含属性mdValue和htmlValue，具体含义请自行翻译
          this.msg=res;
        },
        closeMaskFn:function(){
          this.msgShow='';
          this.dilogStatus=false;
        },
        handleChange(value) {
          console.log(value);
        },
        publish() {
          if (this.title == '') {
            this.$message({
              message: "文章标题不能为空",
              type: "warning"
            })
          } else if (this.integral == '') {
            this.$message({
              message: "赏分分数不能为空",
              type: "warning"
            })
          } else if (this.msg.mdValue == '') {
            this.$message({
              message: "编辑内容不能为空",
              type: "warning"
            })
          } else if (this.plate == '') {
            this.$message({
              message: "请选择相应版块",
              type: "warning"
            })
          } else {
            this.$message({
              message: '发表成功',
              type: 'success'
            });
            console.log("文章标题",this.title)
            console.log("赏分",this.integral)
            console.log("编辑内容",this.msg.mdValue)
            console.log("板块",this.plate)
            console.log("板块",this.msgShow)
            console.log("板块",this.msg)
          }
        }
      },
      components: {
        markdown
      },
    }
</script>

<style scoped>
  .notes{
    border: 1px dashed #999;
  }
  .el-button--info{
    margin: 1rem;
  }
  .choice-plate{
    padding: 1rem;
  }
  .editorContainer{
    height: 500px;
  }
  .integral img{
    display: inline-block;
    margin: 1rem 0.5rem;
    float: left;
  }
  .integral{
    width: 12rem;
  }
  .integral div{
    line-height: 2.4rem;
  }
  .title{
    display: flex;
  }
  .indexContainer{

  }
  .el-container{
    padding: 0 20%;
  }
  .el-main{
    padding: 1rem;
    background: #fff;
  }
</style>
