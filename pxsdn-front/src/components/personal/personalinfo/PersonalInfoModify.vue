<template>
  <el-form ref="form" :model="form" label-width="120px" size="small" v-loading="loading">
    <el-form-item label="昵称：">
      <el-input v-model="form.nick_name"></el-input>
    </el-form-item>
    <el-form-item label="姓名：">
      <el-input v-model="form.real_name"></el-input>
    </el-form-item>
    <el-form-item label="性别：">
      <el-radio-group v-model="form.sex">
        <el-radio label="男"></el-radio>
        <el-radio label="女"></el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="生日：">
      <el-col :span="11">
        <el-date-picker type="date" placeholder="选择日期" v-model="form.birthday" style="width: 100%;"></el-date-picker>
      </el-col>
    </el-form-item>
    <el-form-item label="职位：">
      <el-input v-model="form.position"></el-input>
    </el-form-item>
    <el-form-item label="公司：">
      <el-input v-model="form.company"></el-input>
    </el-form-item>
    <el-form-item label="学历：">
      <el-select v-model="form.education" placeholder="请选择">
        <el-option label="初中" value="初中"></el-option>
        <el-option label="高中" value="高中"></el-option>
        <el-option label="专科" value="专科"></el-option>
        <el-option label="本科" value="本科"></el-option>
        <el-option label="硕士" value="硕士"></el-option>
        <el-option label="博士" value="博士"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="学校：">
      <el-input v-model="form.school"></el-input>
    </el-form-item>
    <el-form-item label="行业：">
      <el-input v-model="form.industry"></el-input>
    </el-form-item>
    <el-form-item label="开始工作时间：">
      <el-col :span="11">
        <el-date-picker type="date" placeholder="选择日期" v-model="form.start_working_time" style="width: 100%;"></el-date-picker>
      </el-col>
    </el-form-item>
    <el-form-item label="简介：">
      <el-input type="textarea" :autosize="{ minRows: 4, maxRows: 6}" v-model="form.brief_introduction"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="info" plain @click="cancel"> 取 消 </el-button>
      <el-button type="info" @click="onSubmit"> 确 认 </el-button>
    </el-form-item>
  </el-form>
</template>

<script>
    export default {
        name: "PersonalInfoModify",
      data() {
          return{
            form: {},
            loading: "",
          }
      },
      mounted() {
        let userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
        this.form = userInfo;
      },
      methods: {
        cancel() {
          this.$emit("unModifyInfo",true);
        },
        onSubmit() {
          function addDateZero(num) {
            return (num < 10 ? "0" + num : num);
          }
          let e = new Date(this.form.birthday);
          this.form.birthday = e.getFullYear() + '-' + addDateZero(e.getMonth() + 1) + '-' + addDateZero(e.getDate());
          let d = new Date(this.form.start_working_time);
          this.form.start_working_time = d.getFullYear() + '-' + addDateZero(d.getMonth() + 1) + '-' + addDateZero(d.getDate());
          this.$ajax.post("/px/modifyPersonalInfo",{userInfo:this.form},r=>{
            if (r == 1) {
              this.$message({
                message: '保存成功',
                type: 'success'
              });
              this.$ajax.post('/px/login', {username:this.form.user_name,password:this.form.pass_word}, r => {
                sessionStorage.setItem("userInfo",JSON.stringify(r));
              })
              this.loading = true;
              setTimeout(()=>{this.$emit("unModifyInfo",true);this.loading = false;},1000)
            } else {
              this.$message.error("保存出错，请稍后再试")
            }
          })
        }
      }
    }
</script>

<style scoped>
  .el-input,.el-select,.el-textarea{
    width: 20rem!important;
  }
  .el-button{
    height: 2.5rem;
    width: 6rem;
  }
</style>
