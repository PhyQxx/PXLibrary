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
          <div :id="id">
            <textarea class="" name="test-editormd-markdown-doc" v-text="content"></textarea>
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
  </el-container>
</template>

<script>
  import $ from "jquery";
  import uuid from "uuid/v4";
  import footers from '../components/Footer'
  import markdown from "../components/Mdeditor";
    export default {
        name: "Content",
      data() {
          return{
            all: "",
            content: "",
            type: false,
            //最终生成的编辑器
            editor:null,
            //默认选项
            defaultOptions:{
              //width: "90%",
              //height: 740,
              path : "/static/editor.md/lib/",
              theme : "",
              previewTheme : "",
              editorTheme : "pastel-on",
              // markdown : md,   //动态设置的markdown文本
              codeFold : true,
              //syncScrolling : false,
              saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
              searchReplace : true,
              watch : false,                // 关闭实时预览
              htmlDecode : "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启
              toolbar  : false,             //关闭工具栏
              //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
              emoji : true,
              taskList : true,
              tocm            : true,         // Using [TOCM]
              tex : true,                   // 开启科学公式TeX语言支持，默认关闭
              flowChart : true,             // 开启流程图支持，默认关闭
              sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
              //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
              //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
              //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
              //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
              //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
              imageUpload : true,
              imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
              imageUploadURL : "./php/upload.php",
              onload : function(md) {
                // console.log(data.markdown);
                this.fullscreen();
                this.unwatch();
                this.watch().fullscreen();
                // this.setMarkdown("");
                this.width("100%");
                this.height(480);
                this.resize("100%", 640);
              },
            }
          }
      },
      created() {
      },
      mounted() {
        this.$ajax.post("/px/getBlogContent",{id:sessionStorage.getItem("blogId"),authorId:sessionStorage.getItem("authorId")},r=>{
          this.all = r;
          this.type = r.status;
          this.all.label = r.label.split(",");
          this.content = r.content;
          this.all.header_photo = this.all.author.substring(0,1)
        })
        let vm=this;
        //加载editormd
        this.requireEditor(function(){
          vm.editor=editormd(vm.id,vm.getOptions());
        })
      },
      props:{
        /**
         * editormd挂载元素的id
         */
        id:{
          type:String,
          default:uuid()
        },
        /**
         * editormd的选项对象
         */
        options:{
          type:Object
        }
      },
      methods: {
        /**
         * 异步加载editormd
         * callback 成功后的回调函数
         */
        requireEditor(callback){
          let vm=this;
          //设置全局变量，因为editormd依赖jquery
          window.$=window.jQuery=$;
          //异步加载并执行
          $.getScript("/static/editor.md/editormd.min.js",function(script){
            callback();
          });
          //加载css
          $('head').append( $('<link rel="stylesheet" type="text/css" />').attr('href', '/static/editor.md/css/editormd.min.css') );
        },
        /**
         * 得到最终的options，组件属性上获得的选项覆盖此处的默认选项
         */

        getOptions(){
          return Object.assign(this.defaultOptions,this.options);
        },

      },
      components: {
        footers,
        markdown
      },
    }
</script>

<style scoped>
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
    padding: 0 20%;
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
