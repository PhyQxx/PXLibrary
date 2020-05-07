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
            Android Button按钮在线程中setEnable()会抛出异常 [问题点数：50分]
          </div>
          <div class="reply">
            <div class="right">
              <span>收藏帖子</span>
              <el-button type="info" size="small">回复</el-button>
            </div>
          </div>
          <div class="post">
            <div class="left">
              <div class="header-photo">帅</div>
              <div class="name">帅气的娃哈哈</div>
              <div class="grade">
                <span>论坛</span>
                <span>1</span>
              </div>
            </div>
            <div class="right">
              <p class="content">thread = new Thread(new Runnable() {
                @Override
                public void run() {
                for(int i = 0; i < 100; i ++){
                try {
                Thread.sleep(100);
                } catch (InterruptedException e) {
                e.printStackTrace();
                break;
                }
                determinate.setProgress(i);
                }
                load.setEnabled(false);
                }
                });
                thread.start();

                其中load.setEnabled(false);会抛出异常，android.util.AndroidRuntimeException: Animators may only be run on Looper threads
                而如果是load.setEnabled(true);则不会抛出异常
                求解释</p>
              <div class="bottom">
                <div class="left-b">2020-04-26 16:18:19</div>
                <div class="right-b">
                  <div class="reply-b">回复数8</div>
                  <div class="only-landlord">只看楼主</div>
                  <div class="quote">引用</div>
                  <div class="report">举报</div>
                  <div class="landlord">楼主</div>
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
    export default {
        name: "PostContent",
      data() {
          return{
            type2: "",
          }
      },
      mounted() {
          this.getType();
      },
      watch: {
        '$route' (to, from) { //监听路由是否变化
          if(to.query.type2 != from.query.type2){
            this.getType();
          }
        }
      },
      methods:{
        getType() {
          this.type1 = this.$route.query.type1;
          this.type2 = this.$route.query.type2;
        }
      },
      components:{
          footers
      }

    }
</script>

<style scoped>
  .bottom{
    
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
    width: 2.4rem;
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
