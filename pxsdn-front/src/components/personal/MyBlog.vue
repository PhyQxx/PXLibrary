<template>
  <el-container class="out">
    <el-header>
      <p>布里茨的博客</p>
    </el-header>
    <el-container>
      <el-main>
        <div class="main-header">
          <el-checkbox v-model="originalChecked">只看原创</el-checkbox>
          <div class="sort">
            <span>排序：</span>
            <span class="pointer special-text-yellow">默认</span>
            <span class="pointer special-text-yellow">按更新时间</span>
            <span class="pointer special-text-yellow">按访问量</span>
          </div>
        </div>
        <hr>
        <div class="list">
          <div class="one" v-for="item in myBlogList">
            <div class="top">
              <span class="original" v-if="item.status">原创</span>
              <span class="reprint" v-if="!item.status">转载</span>
              <span class="title pointer" @click="getContent(item.id,item.author_id)">{{item.title}}</span>
            </div>
            <div class="bottom">
              <p class="text-over grey1">{{item.content}}</p>
              <p>{{item.create_time}}</p>
            </div>
          </div>
        </div>
      </el-main>
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
                <p>{{all.all_comment_number+all.all_reply_number}}</p>
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
    </el-container>
  </el-container>
</template>

<script>
  import footers from '../components/Footer'
    export default {
        name: "MyBlog",
      data() {
          return{
            originalChecked: false,
            all: '',
            userId: sessionStorage.getItem("userId"),
            myBlogList: '',
          }
      },
      mounted() {
          this.refresh();
          this.getBlogInfo(this.userId)
      },
      methods: {
        /**获取一条博客内容*/
        getContent() {
          this.$router.push({name: "content"})
          sessionStorage.setItem("blogId",id)
          sessionStorage.setItem("authorId",authorId)
        },
        /**获取个人信息*/
        refresh() {
          this.$ajax.post("/px/getBlogContent", {
            authorId: JSON.parse(sessionStorage.getItem("userInfo")).user_id
          }, r => {
            this.all = r;
            this.all.label = r.label.split(",");
            this.all.header_photo = this.all.author.substring(0, 1)
        })
        },
        /**获取个人博客信息*/
        getBlogInfo(id) {
          this.$ajax.post("/px/getBlogList",{userId:id},r=>{
            this.myBlogList = r;
          })
        }
      },
      components: {
          footers
      }
    }
</script>

<style scoped>
  .el-aside{
    margin-left: 1rem;
  }
  .list .one{
    border-bottom: 1px solid #666;
    padding: 0.4rem 0;
  }
  .bottom p:nth-child(1){
    margin: 0.5rem 0 !important;
    width: 100%;
  }
  .bottom p:nth-child(2){
    margin: 0 !important;
  }
  .one .top{
    height: 1.5rem;
  }
  .one .title{
    line-height: 1.5rem;
    height: 100%;
    font-size: 1.2rem;
    margin-left: 2.5rem;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    display: inline-block;
    width: calc(100% - 2.5rem);
  }
  .el-header{
    margin-bottom: 0.5rem;
  }
  .one .original{
    color: #e33e33;
    background: #f9ecec;
    font-size: 0.8rem;
    width: 2rem;
    height: 1.5rem;
    line-height: 1.5rem;
    text-align: center;
    border-radius: 5px;
    display: inline-block;
    position: absolute;
  }
  .one .reprint{
    color: #74cf59;
    background: #eaf9e3;
    font-size: 0.8rem;
    width: 2rem;
    height: 1.5rem;
    line-height: 1.5rem;
    text-align: center;
    border-radius: 5px;
    display: inline-block;
    position: absolute;
  }
  .sort{
    float: right;
    margin-right: 1rem;
  }
  .sort span{
    margin-left: 1rem;
  }
  .el-header p{
    font-size: 1.4rem;
  }
  .out{
    margin: 0 10%;
  }
  .el-main{
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
  .read{
    display: flex;
  }
</style>
