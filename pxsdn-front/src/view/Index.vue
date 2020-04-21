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
        <el-menu-item index="1" @click="goHomepage">首页</el-menu-item>
        <el-menu-item index="2" @click="goForum">论坛</el-menu-item>
        <el-menu-item index="3" @click="goBlog">博客</el-menu-item>
        <el-menu-item index="4" @click="goDownload">下载</el-menu-item>
        <el-menu-item class="right" index="5" v-if="!isLogin" @click="login">登录</el-menu-item>
        <el-menu-item class="right" index="6" v-if="!isLogin" @click="register">注册</el-menu-item>
        <el-submenu index="7" class="right" v-if="isLogin">
          <template slot="title">{{userName}}</template>
          <el-menu-item index="2-1" @click="goMyCollection">我的收藏</el-menu-item>
          <el-menu-item index="2-2" @click="goMyBlog">我的博客</el-menu-item>
          <el-menu-item index="2-3" @click="goPersonalData">个人中心</el-menu-item>
          <el-menu-item index="2-4" @click="goAccountSettings">账号设置</el-menu-item>
          <el-menu-item index="2-5" @click="signOut">退出</el-menu-item>
        </el-submenu>
        <el-menu-item class="right" index="8" v-if="isLogin">
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
          <el-form-item label="账号" prop="username">
            <el-input v-model="form.username" type="text" placeholder="请输入用户名或手机号"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="form.password" type="password" placeholder="请输入密码" @keyup.enter.native="submit"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
<!--        <el-button @click="cancel">取 消</el-button>-->
        <el-button type="info" @click="submit">登 录</el-button>
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
            <el-form-item label="手机号" prop="mobile">
              <el-input v-model="form1.mobile" type="text"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input v-model="form1.password" type="password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="againPassword" @keyup.enter.native="registerSubmit">
              <el-input v-model="form1.againPassword" type="password"></el-input>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
<!--        <el-button @click="cancel1">取 消</el-button>-->
        <el-button type="info" @click="registerSubmit">提 交</el-button>
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
        let username;
        let isLogin;
        if (sessionStorage.getItem("userInfo") == '' || sessionStorage.getItem("userInfo") == null) {
          isLogin = false;
        } else {
          let userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
          isLogin = true;
          username = userInfo.nick_name;
        }
        let againPassword = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.form1.password) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        }
          return{
            isRouterAlive: true,
            dialogVisible: false,
            dialogVisible1: false,
            activeIndex: '1',
            isLogin: isLogin,
            userName: username,
            form: {
              username: '',
              password: '',
            },
            rules: {
              username: [
                { required: true, message: '请输入用户名', trigger: 'blur' },
                { min: 6, max: 11, message: '长度在 6 到 11 个字符', trigger: 'blur' }
              ],
              password: [
                { required: true, message: '请输入密码', trigger: 'blur' },
                { min: 6, max: 8, message: '长度在 6 到 8 个字符', trigger: 'blur' }
              ],
            },
            form1: {
              mobile: '',
              username: '',
              password: '',
              againPassword: '',
            },
            rules1: {
              mobile: [
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
        reload () {
          this.isRouterAlive = false;
          this.$nextTick(() => (this.isRouterAlive = true))
        },
        goHomepage() {
          this.$router.push({name:'homepage'})
        },
        goForum() {
          this.$router.push({name:'forumhomepage'})
        },
        goBlog() {
          this.$router.push({name:'blog'})
        },
        goDownload() {
          this.$router.push({name:'download'})
        },
        goMyCollection() {
          let router = this.$router.resolve({
            name:'mycollection',
            params: {
              index: "1"
            }
          })
          window.open(router.href+"?1",'_blank')
        },
        goMyBlog() {
          this.$router.push({
            name:'myblog',
            params: {
              index: "2"
            }
          })
        },
        goPersonalData() {
          this.$router.push({
            name:'personaldata',
            params: {
              index: "3"
            }
          })
        },
        goAccountSettings() {
          this.$router.push({
            name:'accountsettings',
            params: {
              index: "4"
            }
          })
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
        submit() {
          this.$ajax.post('/px/login', {username:this.form.username,password:this.form.password}, r => {
            if (r == ''  || r == null) {
              this.dialogVisible = true;
              this.$message.error('用户名和密码不匹配');
            } else {
              this.$message({
                message: "登录成功",
                type: "success"
              });
              this.$router.push({
                name: "/homepage"
              })
              location.reload();
              this.dialogVisible = false;
              sessionStorage.setItem("userInfo",JSON.stringify(r));
              let userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
              this.userName = userInfo.nick_name;
              this.isLogin = true;
            }
          })
        },
        registerSubmit() {
          console.log("手机号",this.form1.mobile);
          console.log("密码",this.form1.password);
          this.$ajax.post("/px/register",{mobile:this.form1.mobile,password:this.form1.password},r=>{
            if (r == '0') {
              this.$message.error('该手机号已被注册');
            } else {
              this.$message({
                message: "注册成功",
                type: "success"
              });
              this.form1.mobile = '';
              this.form1.password = '';
              this.form1.againPassword = '';
              this.dialogVisible1 = false;
              this.dialogVisible = true;
            }
          })
        },
        signOut() {
          this.$confirm('确认退出?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            sessionStorage.setItem("userInfo","");
            this.$router.push({
              name: "/homepage"
            })
            location.reload()
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消退出'
            });
          });
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
    border-radius: 5px;
  }
  header{
    background-color: rgb(84, 92, 100);
  }
  .right{
    float: right;
  }
  main{
    padding: 0;
    background: #F5F6F7;
  }
</style>
