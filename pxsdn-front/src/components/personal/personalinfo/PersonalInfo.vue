<template>
  <div class="info" v-loading="loading">
    <p>昵称：{{userInfo.nick_name}}</p>
<!--    <span class="modify blue pointer" @click="modify">修改资料</span>-->
    <p>姓名：{{userInfo.real_name}}</p>
    <p>性别：{{userInfo.sex}}</p>
    <p>生日：{{userInfo.birthday}}</p>
    <p>职位：{{userInfo.position}}</p>
    <p>公司：{{userInfo.company}}</p>
    <p>学历：{{userInfo.education}}</p>
    <p>学校：{{userInfo.school}}</p>
    <p>行业：{{userInfo.industry}}</p>
    <p>开始工作时间：{{userInfo.start_working_time}}</p>
    <p>简介：{{userInfo.brief_introduction}}</p>
  </div>
</template>

<script>
    export default {
        name: "PersonalInfo",
      data() {
          return{
            userInfo: JSON.parse(sessionStorage.getItem("userInfo")),
            loading: false,
          }
      },
      mounted() {
      },
      methods: {

      }
    }
</script>

<style scoped>
  *{
    color: #4d4d4d;
  }
  .modify{
    position: absolute;
    margin: -2rem 0 0 40rem;
    font-size: 0.9rem;
  }
</style>
