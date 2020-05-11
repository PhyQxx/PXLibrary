<template>
  <el-container>
    <el-header>
      <el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom: 0.5rem">
        <el-breadcrumb-item :to="{ path: '/forum/forumhomepage' }">CSDN论坛</el-breadcrumb-item>
        <el-breadcrumb-item v-if="type2">{{type2}}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-header>
    <el-container class="content">
      <el-main>
        <div class="forum">
          <div class="title">
            {{postContent.title}}
            <span style="white-space: nowrap;">[问题点数：{{postContent.bonus}}分]</span>
          </div>
          <div class="reply">
            <div class="right">
              <span class="pointer" @click="collection">收藏帖子</span>
              <el-button type="info" size="small" @click="reply">回复</el-button>
            </div>
          </div>
          <div class="post">
            <div class="left">
              <div class="header-photo">{{postContent.header_photo}}</div>
              <div class="name">{{postContent.nick_name}}</div>
              <div class="grade">
                <span>论坛</span>
                <span>{{Math.floor(postContent.forum_score/1000)+1}}</span>
              </div>
            </div>
            <div class="right">
              <p class="content text">{{postContent.content}}</p>
              <div class="bottom">
                <div class="left-b">{{postContent.create_time}}</div>
                <div class="right-b">
                  <div class="reply-b">回复数{{postContent.reply}}</div>
                  <div class="only-landlord" @click="onlyLook">只看楼主</div>
                  <div class="quote" @click="quote">引用</div>
                  <div class="report" @click="report">举报</div>
                  <div class="landlord">楼主</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="floor">
          <div class="one-floor" v-for="(item,index) in postFloorList">
            <div class="post">
              <div class="left">
                <div class="header-photo">{{item.header_photo}}</div>
                <div class="name">{{item.nick_name}}</div>
                <div class="grade">
                  <span>论坛</span>
                  <span>{{Math.floor(item.forum_score/1000)+1}}</span>
                </div>
              </div>
              <div class="right">
                <p class="content text">{{item.content}}</p>
                <div class="bottom">
                  <div class="left-b">{{item.create_time}}</div>
                  <div class="right-b">
                    <div class="box">
                      <div class="editor pointer" v-if="userInfo.user_id === item.create_id" @click="editorPostReply(item.id,item.content)">编辑</div>
                      <div class="delete pointer" v-if="userInfo.user_id === item.create_id" @click="deletePostReply(item.id)">删除</div>
                      <div class="only-landlord" @click="onlyLook">只看TA</div>
                      <div class="quote" @click="quote">引用</div>
                      <div class="report" @click="report">举报</div>
                      <div class="landlord">{{index+1}}楼</div>
                      <div class="landlord">得分{{item.bonus}}</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </el-main>
      <el-aside>
        <footers></footers>
      </el-aside>
    </el-container>

  </el-container>
</template>

<script>
  import footers from "../components/Footer"
  import {getDate} from "../../assets/js/public";
    export default {
        name: "PostContent",
      data() {
          return{
            userInfo: JSON.parse(sessionStorage.getItem('userInfo')),
            type2: "",
            postContent:'',
            postFloorList:''
          }
      },
      mounted() {
          this.getType();
          this.getPostContent();
          this.getPostFloor();
      },
      watch: {
        '$route' (to, from) { //监听路由是否变化
          if(to.query.type2 !== from.query.type2){
            this.getType();
          }
        }
      },
      methods:{
        onlyLook() {
          this.$message({
            type: "info",
            message: "系统正在完善"
          })
        },
        quote() {
          this.$message({
            type: "info",
            message: "系统正在完善"
          })
        },
        report() {
          this.$message({
            type: "info",
            message: "举报系统正在完善"
          })
        },
        editorPostReply(id,content) {
          this.$prompt('请输入回复内容', '提示', {
            inputValue:content,
            confirmButtonText: '提交',
            cancelButtonText: '取消',
            inputPattern: /\S/,
            inputErrorMessage: '内容不能为空'
          }).then(({ value }) => {
            this.$ajax.post("/px/editorPostReply",{content:value,id:id},r=>{
              if (r===1) {
                this.$message({
                  type: 'success',
                  message: '编辑成功'
                });
                this.getPostFloor();
              } else {
                this.$message.error("编辑失败")
              }
            })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '取消输入'
            });
          });
        },
        deletePostReply(id) {
          this.$confirm('此操作将永久删除该条回帖, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
              this.$ajax.post("/px/deletePostReply",{id:id},r=>{
                if (r === 1) {
                  this.$message({
                    type: 'success',
                    message: '删除成功!'
                  });
                  this.getPostFloor();
                } else {
                  this.$message.error("删除失败")
                }
              })

          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        },
        reply() {
          let postId = sessionStorage.getItem("postId");
          this.$prompt('请输入回复内容', '提示', {
            confirmButtonText: '提交',
            cancelButtonText: '取消',
            inputPattern: /\S/,
            inputErrorMessage: '内容不能为空'
          }).then(({ value }) => {
            this.$ajax.post("/px/insertPostReply",{content:value,postId:postId,
              replyId:JSON.parse(sessionStorage.getItem("userInfo")).user_id},r=>{
              if (r===1) {
                this.$message({
                  type: 'success',
                  message: '回复成功'
                });
                this.getPostFloor();
              } else {
                this.$message.error("回复失败")
              }
            })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '取消输入'
            });
          });
        },
        collection() {
          this.$message({
            type: 'success',
            message: "收藏"
          })
        },
        getType() {
          this.type1 = this.$route.query.type1;
          this.type2 = this.$route.query.type2;
        },
        getPostContent() {
          let postId = sessionStorage.getItem("postId");
          this.$ajax.post("/px/getPostContent",{id:postId},r=>{
            this.postContent = r[0];
            this.postContent.header_photo = this.postContent.nick_name.substring(0,1)
          })
        },
        getPostFloor() {
          let postId = sessionStorage.getItem("postId");
          this.$ajax.post("/px/getPostFloor",{postId:postId},r=>{
            this.postFloorList = r;
            for (let i = 0; i < this.postFloorList.length; i++) {
              this.postFloorList[i].header_photo = this.postFloorList[i].nick_name.substring(0,1)
            }
          })
        }
      },
      components:{
          footers
      }

    }
</script>

<style scoped>
  .one-floor{
    border-top: 1px solid #E9E9EA;
  }
  .floor .right-b{
    flex: 7;
  }
  .right-b div{
    float: right;
  }
  .right-b .editor, .right-b .delete{
    padding: 0 0.5rem;

  }
  .right-b .reply-b{
    padding: 0 0.5rem;
  }
  .right-b .landlord{
    padding: 0 0.5rem;
    color: #4F4F4F;
  }
  .right-b .only-landlord{
    padding: 0 0.5rem;
    cursor: pointer;
  }
  .right-b .quote{
    padding: 0 0.5rem;
    cursor: pointer;
  }
  .right-b .report{
    padding: 0 0.5rem;
    cursor: pointer;
  }
  .right-b .only-landlord:hover, .right-b .report:hover, .right-b .quote:hover, .right-b .editor:hover, .right-b .delete:hover{
    background: #F5F5F5;
  }
  .right-b{

    flex: 5;
  }
  .right-b .box{
    display: flex;
  }
  .left-b{
    flex: 7;
  }
  .bottom{
    display: flex;
    font-size: 0.9rem;
    color: #999;
    padding-top: 1rem;
  }
  .post{
    display: flex;
  }
  .post .right{
    padding: 1rem;
    width: 85%;
  }
  .left .name{
    width: 100%;
    text-align: center;
  }
  .left .header-photo{
    font-size: 2rem;
    text-align: center;
    background: #545C64;
    border-radius: 50%;
    width: 4rem;
    height: 4rem;
    line-height: 4rem;
    color: #fff;
  }
  .grade{
    width: 3rem;
    font-size: 0.8rem;
    color: #fff;
    border-radius: 5px;
  }
  .grade span:nth-child(1){
    background: #9DC75F;
    float: left;

  }
  .grade span:nth-child(2){
    background: #2D5315;
    float: left;
    min-width: 1rem;
    text-align: center;

  }
  .left div{
    margin:0 auto;
  }
  .post .left{
    background: #FAFBFC;
    width: 15%;
    padding: 1rem 0;
  }
  .reply .right{
    float: right;
    width: 8rem;
    height: 2rem;
    margin-top: 0.25rem;
  }
  .forum .reply{
    padding: 0.5rem 1rem;
    border-bottom: 1px solid #EFEFEF;
    height: 2.5rem;
  }
  .forum .title{
    font-size: 1.2rem;
    border-bottom: 1px solid #EFEFEF;
    padding: 1rem;
  }
  .content{
    margin: 0!important;
    min-height: 4rem;
  }
  .el-header{
    height: auto!important;
  }
  .el-container{
    margin: 0 20%;
  }
  .el-main{
    background: #fff;
    padding: 0;
  }
  .el-aside{
    margin: -1rem 0 0 1rem;
  }

</style>
