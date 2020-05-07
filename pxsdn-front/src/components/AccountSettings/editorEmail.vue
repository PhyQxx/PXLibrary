<template>
  <el-main>
    <h3>修改邮箱</h3>
    <hr>
    <div class="main" v-if="editorStatus">
      <p>验证码将发送到手机{{mobile}}</p>
      <p class="grey1">如果长时间未收到验证码，请检查是否将运营商拉黑</p>
      <div class="mobile-ver">
        <span>填写验证码：</span>
        <el-input v-model="firstVer" size="mini">
          <template slot="append" class="pointer">获取短信验证码</template>
        </el-input>
      </div>
    </div>
    <div class="main1" v-if="!editorStatus">
      <div class="new-mobile">
        <span>输入新邮箱：</span>
        <el-input v-model="newMobile" size="mini"></el-input>
      </div>
      <div class="ver">
        <span>填写验证码：</span>
        <el-input v-model="ver" size="mini"><template slot="append" class="pointer">获取短信验证码</template></el-input>
      </div>
    </div>
    <el-button style="display:block ; margin: 0 20.4rem" type="info" plain size="mini" v-if="editorStatus" @click="firstNext">下一步</el-button>
    <el-button style="display:block ; margin: 0 20.4rem" type="info" plain size="mini" v-if="!editorStatus" @click="confirmMobile">下一步</el-button>
    <hr style="margin-top: 1.5rem">
  </el-main>
</template>

<script>
  export default {
    name: "editorMobile",
    data() {
      return{
        mobile: JSON.parse(sessionStorage.getItem("userInfo")).mobile,
        editorStatus: true,
        newMobile: '',
        firstVer: '',
        ver: '',
      }
    },
    mounted() {
    },
    methods: {
      firstNext() {
        if (this.firstVer ===  '') {
          this.$message.error("请输入验证码")
        } else if(this.firstVer.length !== 4) {
          this.$message.error("验证码格式不正确")
        } else {
          this.editorStatus = false;
        }
      },
      confirmMobile() {
        let mobileRegular = /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;
        if (this.newMobile === '') {
          this.$message.error("请输入邮箱")
        } else if (!mobileRegular.test(this.newMobile)) {
          this.$message.error("邮箱格式不正确")
        } else if (this.newMobile === this.mobile) {
          this.$message.error("手机号已经存在")
        }else if (this.ver ===  '') {
          this.$message.error("请输入验证码")
        } else if(this.ver.length !== 4) {
          this.$message.error("验证码格式不正确")
        } else {
          this.$ajax.post("/px/editor",{userId:JSON.parse(sessionStorage.getItem("userInfo")).user_id,
            email:this.newMobile},r=>{
            if (r === 1) {
              let userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
              userInfo.mailbox = this.newMobile;
              sessionStorage.setItem("userInfo",JSON.stringify(userInfo));
              this.$message({
                type: 'success',
                message: '修改手机成功'
              });
              // this.$router.back(-1);
              location.reload();
            } else {
              this.$message.error("修改手机失败")
            }
          })
        }
      }
    }

  }
</script>

<style scoped>
  .el-input >>> .el-input-group__append{
    cursor: pointer!important;
  }
  .el-main{
    background: #fff;
  }
  .main, .main1{
    margin: 0 auto;
    padding: 1rem 1rem 0 1rem;
  }
  .main p{
    width: 50%;
    margin: 0 auto;
    padding: 0.5rem 0;
  }
  .el-input-group{
    width: 18rem!important;
  }
  .mobile-ver{
    width: 50%;
    margin: 0 auto;
    padding: 1rem 0;
  }
  .new-mobile .el-input, .ver .el-input{
    width: 18rem!important;
  }
  .new-mobile, .ver{
    margin: 0 auto;
    width: 50%;
    margin-bottom: 1rem;
  }
</style>
