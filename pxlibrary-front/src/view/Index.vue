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
        <el-menu-item index="1" @click="goHomepage">首页</el-menu-item>
        <el-menu-item index="2" @click="goForum">论坛</el-menu-item>
        <el-menu-item index="3" @click="goBlog">博客</el-menu-item>
        <el-menu-item index="4" @click="goData">资料</el-menu-item>
        <el-menu-item class="right" index="5" v-if="isLogin" @click="login">登录</el-menu-item>
        <el-menu-item class="right" index="6" v-if="isLogin" @click="register">注册</el-menu-item>
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
      <el-dialog
      title="登录"
      :visible.sync="dialogVisible"
      width="30%">
      <div class="login-info">
        <el-form :model="form"
                 :rules="rules"
                 ref="form"
                 label-width="80px"
                 class="demo-ruleForm"
                 close-on-click-modal=false
                 label-position="left">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="form.username" type="text" placeholder="请输入用户名或手机号"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="form.password" type="password" placeholder="请输入密码"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
<!--        <el-button @click="cancel">取 消</el-button>-->
        <el-button type="info" @click="confirm">登 录</el-button>
        </span>
    </el-dialog>

      <el-dialog
        title="注册"
        :visible.sync="dialogVisible1"
        width="30%">
        <div class="login-info">
          <el-form :model="form1"
                   :rules="rules1"
                   ref="form1"
                   label-width="80px"
                   class="demo-ruleForm"
                   close-on-click-modal=false
                   label-position="left">
            <el-form-item label="手机号" prop="mobil">
              <el-input v-model="form1.mobil" type="text"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input v-model="form1.password" type="password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="againPassword">
              <el-input v-model="form1.againPassword" type="password"></el-input>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
<!--        <el-button @click="cancel1">取 消</el-button>-->
        <el-button type="info" @click="confirm1">提 交</el-button>
        </span>
      </el-dialog>

    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>

</template>

<script>
    export default {
        name: "Index",
      data() {
        let againPassword = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.form.password) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        }
          return{
            dialogVisible: false,
            dialogVisible1: false,
            activeIndex: '1',
            activeIndex2: '1',
            isLogin: true,
            userName: "",
            form: {
              username: '',
              password: '',
            },
            rules: {
              username: [
                { required: true, message: '请输入用户名', trigger: 'blur' },
                { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
              ],
              password: [
                { required: true, message: '请输入密码', trigger: 'blur' },
                { min: 6, max: 8, message: '长度在 6 到 8 个字符', trigger: 'blur' }
              ],
            },
            form1: {
              username: '',
              password: '',
              againPassword: '',
            },
            rules1: {
              mobil: [
                { required: true, message: '请输入手机号', trigger: 'blur' },
                { min: 11, max: 11, message: '手机号格式不正确', trigger: 'blur' }
              ],
              password: [
                { required: true, message: '请输入密码', trigger: 'blur' },
                { min: 6, max: 8, message: '长度在 6 到 8 个字符', trigger: 'blur' }
              ],
              againPassword: [
                { required: true, message: '请确认密码', trigger: 'blur' },
                { validator:againPassword, trigger: 'blur'},
              ],
            }
          }
      },
      methods:{
        goHomepage() {
          this.$router.push({name:'homepage'})
        },
        goForum() {
          this.$router.push({name:'forum'})
        },
        goBlog() {
          this.$router.push({name:'blog'})
        },
        goData() {
          this.$router.push({name:'data'})
        },
        login() {
          this.dialogVisible = true
        },
        register() {
          this.dialogVisible1 = true
        },
        handleSelect(key, keyPath) {
        // console.log(key, keyPath);
        },
        confirm() {
          console.log("登录",this.form);
          if (this.form.username == 'phy0316' && this.form.password == 'phy0316') {
            this.isLogin = false;
            this.dialogVisible = false;
            this.userName = this.form.username;
            this.$message({
              message: "登录成功",
              type: "success"
            });
          } else {
            this.dialogVisible = true;
            this.$message.error('用户名和密码不匹配');
          }
        },
        confirm1() {
          console.log("注册",this.form1);
          this.dialogVisible1 = false;
        }
      },
    }
</script>

<style scoped>
  .el-container{

  }
  .el-header{
    padding: 0 20%;
    width: 100%;
  }
  header{
    background-color: rgb(84, 92, 100);
  }
  .right{
    float: right;
  }
  main{
    padding: 0 20%;
    background: #F5F6F7;
  }
</style>
