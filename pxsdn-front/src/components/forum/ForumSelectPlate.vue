<template>
  <el-container>
    <el-header>
      <el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom: 0.5rem">
        <el-breadcrumb-item :to="{ path: '/forum/forumhomepage' }">CSDN论坛</el-breadcrumb-item>
        <el-breadcrumb-item v-if="type2">{{type2}}</el-breadcrumb-item>
      </el-breadcrumb>
      <div id="header">
        <div class="headerName">
          <span>{{type2}}论坛</span>
          <span class="special-text span">申请版主</span>
        </div>
        <div class="typeName">
          <span class="span">{{type1}}</span>
          <span class="span">{{type2}}</span>
        </div>
        <div class="moderator">
          <span class="span">版主:</span>
          <span v-for="item in moderator" class="special-text-yellow blue margin">{{item}}</span>
        </div>
      </div>
    </el-header>
    <el-main>
      <div class="tabHeader">
        <div class="status"></div>
        <div class="reward">赏分</div>
        <div class="theme">主题</div>
        <div class="author">作者</div>
        <div class="replyAndView">回复/查看</div>
        <div class="lastPerson">最后发表</div>
        <div class="admin">管理</div>
      </div>
      <div class="list">
        <div class="one" v-for="item in list">
          <div class="status1">
            <span v-if="item.isPay" style="background: #909399;color: #fff;border-radius: 5px">已结</span>
            <span v-if="!item.isPay" style="background: #FFBB66;color: #fff;border-radius: 5px">未结</span>
          </div>
          <div class="reward">{{item.reward}}</div>
          <div class="theme">
            <span v-for="i in item.theme">{{i}}</span>
          </div>
          <div class="author">
            <span class="special-text-yellow blue">{{item.author.author}}</span>
            <span style="margin-top: 0.2rem;display: block; margin-top: 0.3rem;">{{item.author.time}}</span>
          </div>
          <div class="replyAndView">{{item.replyAndView}}</div>
          <div class="lastPerson">
            <span class="special-text-yellow blue">{{item.lastPerson.lastPerson}}</span>
            <span style="margin-top: 0.2rem;display: block; margin-top: 0.3rem;">{{item.lastPerson.time}}</span>
          </div>
          <div class="admin">
            <i class="el-icon-s-tools special-text-blue"></i>
          </div>
        </div>
      </div>
    </el-main>
  </el-container>
</template>

<script>
    export default {
      name: "ForumSelectPlate",

      data() {
          return{
            activeName: 'first',
            type1: "",
            type2: "",
            moderator: ["帅气的布里茨","美丽的AD钙","娃哈哈"],
            list: [
              {
                isPay: true,
                reward: "200",
                theme: ["[置顶]","判断输入数据类型"],
                author: {
                  author: "帅气的布里茨",
                  time: "2020-03-02 11:25",
                },
                replyAndView: "135/4602",
                lastPerson: {
                  lastPerson: "帅气的whh",
                  time: "2020-03-12 11:25",
                },
              },
              {
                isPay: true,
                reward: "200",
                theme: ["[置顶]","判断输入数据类型"],
                author: {
                  author: "帅气的布里茨",
                  time: "2020-03-02 11:25",
                },
                replyAndView: "135/4602",
                lastPerson: {
                  lastPerson: "帅气的whh",
                  time: "2020-03-12 11:25",
                },
              },
            ],
          }
      },
      watch: {
        '$route' (to, from) { //监听路由是否变化
          if(to.query.type2 != from.query.type2){
            this.type1 = this.$route.query.type1;
            this.type2 = this.$route.query.type2;
          }
        }
      },
      created() {
        this.type1 = this.$route.query.type1;
        this.type2 = this.$route.query.type2;
      },
      methods: {

      }
    }
</script>

<style scoped>
  .one{
    margin-top: 1rem;
    font-size: 0.9rem;
  }
  .tabHeader{
    display: flex;
    text-align: center;
  }
  .tabHeader div{
    border-right: 1px solid;
  }
  .one{
    display: flex;
    height: 3rem;
  }
  .one div{
    margin-top: 0.3rem;
  }
  .status{
    border-left: 1px solid;
    flex: 1;
  }
  .status1{
    flex: 1;
    text-align: center;
  }
  .reward{
    flex: 1;
    text-align: center;
  }
  .theme{
    flex: 6;
  }
  .theme span{
    margin-right: 0.2rem;
  }
  .author{
    flex: 2;
  }
  .replyAndView{
    flex: 2;
    text-align: center;
  }
  .lastPerson{
    flex: 2;
  }
  .admin{
    flex: 1;
    text-align: center;
  }
  header{
    height: auto!important;
  }
  .el-main{
    margin-top: 0.5rem;
    background: #fff;
  }
  .el-container{
    padding: 0 20%;
  }
  #header{
    background: #fff;
    padding: 0.5rem 1rem;
  }
  .el-header{
    padding: 0;
  }
  .headerName{
    display: flex;
    height: 3rem;
  }
  .headerName span{
    /*display: inline-block;*/
    height: 3rem;
    line-height: 3rem;
  }
  .headerName span:nth-child(1){
    color: #000;
    font-size: 1.5rem;
    font-weight: bold;
  }
  .headerName span:nth-child(2){
    margin-left: 1rem;;
  }
  .typeName span:nth-child(2){
    margin-left: 0.5rem;
  }
  .margin{
    margin-left: 0.5rem;
  }
  .moderator{
    margin-top: 0.5rem;
  }
</style>
