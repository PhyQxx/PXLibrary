<template>
  <el-container>
    <el-header>
      <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item index="1" @click="goForumHomepage">论坛首页</el-menu-item>
        <el-submenu index="2">
          <template slot="title">精选板块</template>
          <el-submenu v-for="(item,index) in selectPlate"
                      :key="index"
                      :index="getIndex(index)"
                      >
            <template slot="title">{{item.name}}</template>
            <el-menu-item v-for="(it,i) in item.type"
                          :index="getIndex1(index,i)"
                          :key="'2-1-'+i"
                          @click="goForumSelectPlate(item,it)">
              {{it}}
            </el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="3" @click="goRanking">排行榜</el-menu-item>
        <el-menu-item index="4" @click="goForumHelp">论坛帮助</el-menu-item>
        <el-menu-item index="5" @click="posting">我要发帖</el-menu-item>
      </el-menu>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
  import footers from "./Footer"
    export default {
      name: "Forum",
        data() {
            return{
              inject:["reload"],
              activeIndex: "1",
              name: "",
              type: "",
              selectPlate: [
                {
                  id:"1",
                  name: "移动开发",
                  type: ["Android","iOS","Qt","WP"]
                },
                {
                  id:"2",
                  name: "Java技术",
                  type: ["Java SE","Java Web 开发","Java EE","Java其他相关"]
                },
                {
                  id:"3",
                  name: "Web开发",
                  type: ["PHP","JavaScript","ASP","HTML(CSS)","HTML5","Apache"]
                },
                {
                  id:"4",
                  name: "数据库开发",
                  type: ["Oracle","MS-SQL Server","其他数据库开发"]
                },
                {
                  id:"5",
                  name: "硬件/嵌入式开发",
                  type: ["嵌入开发(WinCE)","驱动开发/核心开发","硬件设计","单片机/工控","汇编语言"]
                },
                {
                  id:"6",
                  name: "Linux/Unix社区",
                  type: ["系统维护与使用区","应用程序开发区","内核源代码研究区","驱动程序开发区","CPU和硬件区"]
                },
              ],
            }
        },
        methods: {
          getIndex(index) {
            return "2-"+index
          },
          getIndex1(index,i) {
            return "2-"+index+i;
          },
          handleSelect(key,keyPath) {

          },
          goForumHomepage() {
            this.$router.push({
                name: 'forumhomepage'})
          },
          goForumSelectPlate(item,it) {
            this.$router.push({
              path: 'forumselectplate',
              query: {
                type1: item.name,
                type2: it
             },
            })
          },
          goRanking() {
            this.$router.push({name: 'forumranking'})
          },
          goForumHelp() {
            this.$router.push({name: 'forumhelp'})
          },
          posting() {
            this.$router.push({name: 'posting'})
          }
        },
      components: {
        footers
      }
    }
</script>

<style scoped>
 .el-container{
   padding: 0;
 }
 .send{
   margin-top: 0.7rem;
 }
 .el-header{
   padding: 0 20%;
   margin-top: 10px;
   /*background: #545C64;*/
   border-radius: 5px;
 }
  main{
    padding: 1rem 0;
  }
</style>
