<template>
  <el-container>
    <el-header>
      <el-menu
        :default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item index="1">首页</el-menu-item>
        <el-menu-item index="2">论坛</el-menu-item>
        <el-menu-item index="3">博客</el-menu-item>
        <el-menu-item index="4">资料</el-menu-item>
        <el-menu-item class="right" index="5" v-if="isLogin">登录</el-menu-item>
        <el-menu-item class="right" index="6" v-if="isLogin">注册</el-menu-item>
        <el-submenu index="7" class="right" v-if="!isLogin">
          <template slot="title">{{userName}}</template>
          <el-menu-item index="2-1">我的收藏</el-menu-item>
          <el-menu-item index="2-2">个人中心</el-menu-item>
          <el-menu-item index="2-3">账号设置</el-menu-item>
          <el-menu-item index="2-4">退出</el-menu-item>
        </el-submenu>
        <el-menu-item class="right" index="8" v-if="!isLogin">
          <i class="el-icon-edit"></i>
          <span>写博客</span>
        </el-menu-item>

      </el-menu>
    </el-header>
    <el-main>

    </el-main>
  </el-container>

</template>

<script>
    export default {
        name: "Index",
      data() {
          return{
            activeIndex: '1',
            activeIndex2: '1',
            isLogin: false,
            userName: "帅气的布里茨",
          }
      },
      methods:{
        handleSelect(key, keyPath) {
          // console.log(key, keyPath);
        },
      },
    }
</script>

<style scoped>
.el-container{
  width: 80%;
  margin: 0 auto;
}
  .right{
    float: right;
  }
</style>
