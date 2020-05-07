<template>
  <el-container>
    <el-aside>
      <nav>
        <el-menu
          :default-active="index"
          class="el-menu-vertical-demo">
          <el-menu-item @click="editorPassword" index="1">
            <span slot="title">修改密码</span>
          </el-menu-item>
          <el-menu-item @click="editorMobile" index="2">
            <span slot="title">修改手机</span>
          </el-menu-item>
          <el-menu-item @click="editorEmail" index="3">
            <span slot="title">修改邮箱</span>
          </el-menu-item>
          <!--<el-menu-item @click="goAccountSettings" index="4">
            <span slot="title">账号设置</span>
          </el-menu-item>-->
        </el-menu>
      </nav>
    </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
  export default {
    name: "AccountSetting",
    data() {
      return{
        index: this.$route.params.index,
      }
    },
    watch: {
      $route(to,from){
        this.Index = this.$route.params.index
      }
    },
    mounted() {
      console.log(location)
    },
    methods: {
      editorPassword() {
        this.$router.push({
          name:'editorpassword',
          params: {
            index: "1"
          }
        })
      },
      editorMobile() {
        this.$router.push({
          name:'editormobile',
          params: {
            index: "1"
          }
        })
      },
      editorEmail() {
        this.$router.push({
          name:'editoremail',
          params: {
            index: "3"
          }
        })
      },
    }
  }
</script>

<style lang="scss" scoped>
  .el-aside{
    width: 12rem!important;
  }
  nav{
    width: 100%;
    background: #fff;
  }
  nav li{
    text-align: center;
    margin: 1px 0;
  }
  nav li:hover{
    background: #545C64!important;
    color: #fff!important;
  }
  .el-menu-item{
    height: 2.5rem;
    line-height: 2.5rem;
  }
  .el-menu-item.is-active{
    color: #fff!important;
    background: #545C64!important;
  }
  .el-container{
    padding: 0 20%;
    .el-aside{
      padding-top: 1rem;
    }
  }
</style>
