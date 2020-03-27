<template>
  <el-container>
    <el-aside>
      <div class="person-info">
        <div class="info">
          <div class="name">
            <div class="header-photo">{{all.header_photo}}</div>
            <div class="username">{{all.author}}</div>
            <div class="go-homepage pointer">TA的个人主页 ></div>
          </div>
          <div class="read">
            <div class="original">
              <p>原创</p>
              <p>{{all.original_number}}</p>
            </div>
            <div class="fans">
              <p>粉丝</p>
              <p>{{all.blog_fans}}</p>
            </div>
            <div class="praised">
              <p>获赞</p>
              <p>{{all.all_praise_number}}</p>
            </div>
            <div class="comment">
              <p>评论</p>
              <p>{{all.comment_number+all.reply_number}}</p>
            </div>
            <div class="visit">
              <p>访问</p>
              <p>{{all.read_number}}</p>
            </div>
          </div>
          <div class="grades">
            <div class="grade">
              <span>等级:</span>
              <div class="number">
                <span>博客</span>
                <span>{{Math.floor(all.blog_integral/1000)}}</span>
              </div>
            </div>
            <div class="integral">
              <span>积分: </span>
              <span>{{all.blog_integral}}</span>
            </div>
            <div class="ranking">
              <span>排名: </span>
              <span>{{all.ranking}}</span>
            </div>
          </div>
        </div>
        <hr>
        <div class="operation">
          <el-button type="info">关 注</el-button>
          <el-button type="info" plain>私信</el-button>
        </div>
      </div>
      <footers></footers>
    </el-aside>
    <el-main>
      <div class="content">
        <div class="header">
          <h1>{{all.title}}</h1>
          <span class="original1" v-if="type">原创</span>
          <span class="reprint" v-if="!type">转载</span>
          <span class="blue pointer authorspan">{{all.author}}</span>
          <span>发布时间:{{all.publication_time}}</span>
          <span>阅读数:{{all.read_number}}</span>
          <div class="type">
            <span>分类专栏:</span>
            <span class="special-text-yellow blue">{{all.person_type}}</span>
          </div>
          <div class="label">
            <span>文章标签:</span>
            <span class="special-text-yellow blue" v-for="item in all.label">{{item}}</span>
          </div>
        </div>
        <div class="middle">
          <div class="editorContainer">
            <markdown
              :mdValuesP="msg.mdValue"
              :fullPageStatusP="false"
              :editStatusP="true"
              :previewStatusP="true"
              :navStatusP="true"
              :icoStatusP="true"
              @childevent="childEventHandler"
              ref="markdown"
            ></markdown>
          </div>
        </div>
        <div class="footer">
          <el-row>
            <el-button type="info" icon="el-icon-thumb" plain>点赞</el-button>
            <el-button type="info" icon="el-icon-star-off" plain>收藏</el-button>
            <el-button type="info" icon="el-icon-share" plain>分享</el-button>
          </el-row>
          <hr>
          <div class="person-info">
            <div class="header-photo">{{all.header_photo}}</div>
            <div class="username">{{all.author}}</div>
            <div class="achievement">发布了{{all.original_number}}篇原创文章 · 获赞 {{all.all_praise_number}} · 访问量 {{all.read_number}}</div>
          </div>
          <el-button type="info">关 注</el-button>
          <el-button type="info" plain>私信</el-button>
        </div>
      </div>
      <div class="comment-area">
        <div class="comment-list">
          <div class="comment-one">
            <div class="comment-header">
              <div class="header-photo">吴</div>
              <div class="name">吴勇</div>
              <div class="time">2小时前</div>
              <span class="reply special-text-yellow blue">回复</span>
            </div>
            <div class="comment-content">羡慕你们24岁就毕业五年的人</div>
          </div>
        </div>
      </div>
    </el-main>
    <el-aside class="aside-right">
      <div class="list">
        <div class="title">
          目录
        </div>
        <ul>
          <li class="special-text-blue" v-for="item in typeList" :id="item.id">{{item.name}}</li>
        </ul>
      </div>
    </el-aside>
  </el-container>
</template>

<script>
  import footers from '../components/Footer'
  import markdown from "../components/Mdeditor";
    export default {
      name: "Content",
      data() {
        return {
          all: "",
          type: false,
          id:'',
          msgShow:'我要显示的内容',
          dilogStatus:false,
          msg: {
            mdValue:''
          },
          flag:false,
          typeList: [
            {
              id: "1",
              name: "Java"
            },
            {
              id: "2",
              name: "前端"
            },
            {
              id: "3",
              name: "数据库"
            },
          ]
        }
      },
      created() {
      },
      mounted() {
        this.$ajax.post("/px/getBlogContent", {
          id: sessionStorage.getItem("blogId"),
          authorId: sessionStorage.getItem("authorId")
        }, r => {
          this.all = r;
          this.type = r.status;
          this.all.label = r.label.split(",");
          this.msg.mdValue = r.content;
          this.all.header_photo = this.all.author.substring(0, 1)
          setTimeout(()=>{this.$refs.markdown.addLine()},1)
        })

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
        handleChange(val) {
          console.log(val);
        },
      },
      components: {
        footers,
        markdown
      },
    }
</script>
<style lang="scss" scoped>
  .mdContainer >>> .editContainer,.mdContainer >>> .navContainer{
    display: none!important;
  }
  .list{
    .title{
      padding-left: 1rem;
      height: 3rem;
      line-height: 3rem;
      background: #999;
      color: #fff;
    }
    background: #fff;
    ul{
      margin: 0;
      list-style: none;
      li{
        padding: 0.5rem 0;
        }
      }
  }
  .aside-right{
    margin-left: 1rem;
  }
  .authorspan{
    margin-left: 2.5rem;
  }
  .navContainer{
    display: none!important;
  }
  .comment-content{
    margin: 1rem 1.5rem!important;
  }
  .reply{
    display: inline-block;
    float: right;
    font-size: 0.9rem;
    line-height: 1.5rem;
  }
  .comment-one{
    padding: 1rem;
  }
  .comment-header{
    display: flex;
  }
  .comment-one div{
    margin-right: 0.5rem;
  }
  .comment-one .header-photo{
    height: 1.5rem;
    width: 1.5rem;
    line-height: 1.5rem;
    font-weight: bold;
    border-radius: 50%;
    background: #545C64;
    color: #fff;
    text-align: center;
    float: left;
    font-size: 1rem;
  }
  .comment-area{
    margin-top: 1rem;
    background: #fff;
  }
  .achievement{
    font-size: 0.9rem;
    margin-left: 3.5rem;
    margin-top: 0.5rem;
  }
  .content .middle{
    margin: 1rem 0;
  }
  .type span:nth-child(2){
     background: #F5F6F7;
    font-size: 0.9rem;
   }
  .label span:nth-child(n+2){
    background: #F5F6F7;
    font-size: 0.9rem;
  }
  .original1{
    position: absolute;
    color: #ca0c16;
    background: #f9ecec;
    font-size: 0.9rem;
    margin-right: 1rem;
  }
  .reprint{
    color: #74cf59;
    background: #eaf9e3;
    font-size: 0.9rem;
    margin-right: 1rem;
  }
  .header span:nth-child(-n+4){
    margin-right: 0.5rem;
  }
  .content{
    padding: 1rem;
    background: #fff;
  }
  .operation .el-button:nth-child(1){
    margin-left: 2rem;
  }
  .operation .el-button:nth-child(2){
    margin-right: 2rem;
    float: right;
  }
  .integral span:nth-child(2)，.ranking span:nth-child(2){
    font-weight: bold;
  }
  .number{
    font-size: 0.8rem;
    color: #fff;
    border-radius: 5px;
    position: absolute;
    margin-left: 2.6rem;
    margin-top: -1.1rem!important;
  }
  .number span:nth-child(1){
    background: #9DC75F;
    float: left;
  }
  .number span:nth-child(2){
    background: #2D5315;
    float: left;
    min-width: 1rem;
    text-align: center;

  }
  .grades div{
    margin-top: 0.5rem;
  }
  .read{
    margin: 0.5rem 0;
  }
  .read div{
    flex: 1;
    text-align: center;
    width: 20%;
  }
  .read div p:nth-child(2){
    overflow: hidden;
    text-overflow: ellipsis;
    font-weight: bold;
  }
  .person-info{
    background: #fff;
    padding: 1rem;
  }
  .username{
    margin-left: 3.5rem;
    font-size: 0.9rem;
  }
  .go-homepage{
    font-size: 0.9rem;
    color: #3399ea;
    margin-left: 3.5rem;
    margin-top: 0.5rem;
  }
  .header-photo{
    height: 3rem;
    width: 3rem;
    line-height: 3rem;
    font-weight: bold;
    border-radius: 50%;
    background: #545C64;
    color: #fff;
    text-align: center;
    float: left;
    font-size: 1.5rem;
  }
  .el-container{
    padding: 0 10%;
  }
  .el-aside{
    margin-top: 1rem;
  }
  .el-main{
    padding: 0;
    margin: 1rem 0 0 1rem;
  }
  .read{
    display: flex;
  }
</style>
