<template>
    <el-main>
      <h3>修改密码</h3>
      <hr>
      <el-form :model="editorPasswordForm"
               :rules="editorPasswordRules"
               ref="editorPasswordRef"
               label-position="left"
               label-width="8rem"
               class="editorPasswordForm">
        <el-form-item label="请输入原始密码" prop="oldPassword">
          <el-input v-model="editorPasswordForm.oldPassword" type="password"></el-input>
        </el-form-item>
        <el-form-item label="请输入新密码" prop="newPassword">
          <el-input v-model="editorPasswordForm.newPassword" type="password"></el-input>
        </el-form-item>
        <el-form-item label="请确认密码" prop="againPassword">
          <el-input v-model="editorPasswordForm.againPassword" type="password"></el-input>
        </el-form-item>
        <el-button type="info" style="display: block; margin: 0 auto" @click="submitForm"> 确 认 </el-button>
      </el-form>
    </el-main>
</template>

<script>
    export default {
        name: "editorPassword",
      data() {
          return{
            editorPasswordForm: {
              oldPassword: '',
              newPassword: '',
              againPassword: ''
            },
            editorPasswordRules: {
              oldPassword: [
                { required: true, message: '请输入原始密码', trigger: 'blur' },
                { min: 6, max: 11, message: '长度在 6 到 11 个字符', trigger: 'blur' }
              ],
              newPassword: [
                { required: true, message: '请输入新密码', trigger: 'blur' },
                { min: 6, max: 11, message: '长度在 6 到 11 个字符', trigger: 'blur' }
              ],
              againPassword: [
                { required: true, message: '请确认密码', trigger: 'blur' },
                { min: 6, max: 11, message: '长度在 6 到 11 个字符', trigger: 'blur' }
              ],
            }
          }
      },
      methods: {
        /**提交表单*/
        submitForm() {
          if (this.editorPasswordForm.oldPassword != JSON.parse(sessionStorage.getItem("userInfo")).pass_word) {
            this.$message.error("原始密码不正确")
          } else if (this.editorPasswordForm.newPassword != this.editorPasswordForm.againPassword) {
            this.$message.error("两次密码不一致")
          } else  {
            this.$ajax.post("/px/editor",{userId:JSON.parse(sessionStorage.getItem("userInfo")).user_id,
              password:this.editorPasswordForm.newPassword},r=>{
              if (r === 1) {
                let userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
                userInfo.pass_word = this.editorPasswordForm.newPassword;
                sessionStorage.setItem("userInfo",JSON.stringify(userInfo));
                this.editorPasswordForm.oldPassword = '';
                this.editorPasswordForm.newPassword = '';
                this.editorPasswordForm.againPassword = '';
                this.$message({
                  type: 'success',
                  message: '修改密码成功'
                })
              } else {
                this.$message.error("修改密码失败")
              }
            })
          }
        },
      }

    }
</script>

<style scoped>
  .el-main{
    background: #fff;
  }
  .editorPasswordForm{
    margin-top: 1rem;
  }
</style>
