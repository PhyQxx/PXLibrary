<template>
  <el-container>
    <el-header>
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/forum/forumhomepage' }">CSDN论坛</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/forum/forumranking' }" >排行榜</el-breadcrumb-item>
      </el-breadcrumb>
    </el-header>
    <el-main>
      <div class="title">
        总专家榜
      </div>
      <div class="main-header">
        <div class="ranking">排名</div>
        <div class="expert">专家</div>
        <div class="expert-points">专家分</div>
        <div class="hottest-posts">最热帖子</div>
      </div>
      <div class="rankings">
        <div class="one" v-for="(item,index) in rankingList">
          <div class="ranking cursor-default">
            <span>{{index+1}}</span>
          </div>
          <div class="expert">
            <div class="pointer">{{item.headerPhoto}}</div>
            <span class="special-text-blue">{{item.expert}}</span>
          </div>
          <div class="expert-points">{{item.expertPoints}}</div>
          <div class="hottest-posts special-text-blue">{{item.hottestPosts}}</div>
        </div>
      </div>
    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "ForumRanking",
      data() {
          return{
            rankingList: [
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "帅气的小兜",
                expertPoints: "654",
                hottestPosts: "64位的sql 2000",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "神奇的布里茨",
                expertPoints: "64",
                hottestPosts: "读取树状数据的方法",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "天哪神奇",
                expertPoints: "566",
                hottestPosts: "自创C语言填表式编码风格。欢迎大家用各种语言及其编码风格来PK！",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
              {
                id: "",
                headerPhoto: "",
                expert: "哇咔咔",
                expertPoints: "444",
                hottestPosts: " [总结]ajax问题总结",
              },
            ],
          }
      },
      mounted() {
        for (let i = 0; i < this.rankingList.length; i++) {
          this.rankingList[i].headerPhoto = this.rankingList[i].expert.substring(0,1)
        }
      },
      components: {

        }
      }
</script>

<style scoped>
  .expert div{
    float: left;
    height: 1.5rem;
    width: 1.5rem;
    line-height: 1.5rem;
    text-align: center;
    border-radius: 50%;
    background: #545C64;
    color: #fff;
    margin-top: 0.5rem;
  }
  .expert span{
    margin-left: 1rem;
  }
  .one{
    height: 2.5rem;
    display: flex;
    line-height: 2.5rem;
  }
  .main-header{
    background: #EBEBEB;
    height: 2.5rem;
    display: flex;
    line-height: 2.5rem;
    color: #999;
  }
  .rankings div{
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .ranking{
    text-align: center;
    flex: 1;
  }
  .one:nth-child(1) .ranking span{
    background: #FF9900;
    color: #fff;
  }
  .one:nth-child(2) .ranking span{
    background: #BDC4CA;
    color: #fff;
  }
  .one:nth-child(3) .ranking span{
    background: #B9A558;
    color: #fff;
  }
  .one .ranking{
    font-size: 0.9rem;
    color: #ccc;
  }
  .one .ranking span{
    display: inline-block;
    border-radius: 50%;
    width: 1.5rem;
    height: 1.5rem;
    line-height: 1.5rem;
    text-align: center;
  }
  .expert{
    width: 100%;
    flex: 3;
  }
  .expert-points{
    flex: 2;
  }
  .hottest-posts{
    flex: 10;
  }
  .el-header{
    padding: 0.5rem 0;
    height: 2rem!important;
  }
  .el-container{
    padding: 0 20%;
  }
  .el-container .el-main{
    padding: 0;
    background: #fff;
  }
  .title{
    font-size: 1.2rem;
    padding: 1rem;
  }
</style>
