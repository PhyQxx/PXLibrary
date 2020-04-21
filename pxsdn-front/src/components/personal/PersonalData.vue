<template>
  <el-container>
    <el-main>
      <p class="title">个人资料</p>
      <hr>
      <div class="left">
        <div class="header-photo">帅</div>
      </div>
      <div class="right">
        <div class="top">
          <p>用户名：phy0412</p>
          <span class="go-personal-homepage blue pointer">个人主页 ></span>
          <span>关注 2</span>
          <span>粉丝 3</span>
        </div>
        <hr>
        <div class="bottom">
          <div class="modify blue pointer" v-if="modify" @click="modifyInfo">修改资料</div>
          <info v-if="modify"></info>
          <infomodify v-if="!modify" @unModifyInfo="unModifyInfo"></infomodify>
        </div>
      </div>
    </el-main>
  </el-container>

</template>

<script>
  import info from './personalinfo/PersonalInfo'
  import infomodify from './personalinfo/PersonalInfoModify'
    export default {
        name: "PersonalData",
      data() {
          return{
            modify:true,
          }
      },
      methods: {
        modifyInfo() {
          this.modify = false;
        },
        unModifyInfo(bo) {
          this.modify = bo;
        }
      },
      components: {
        info,
        infomodify
      }
    }
</script>

<style lang="scss" scoped>
  .el-container{
    padding: 0;
    .el-main{
      background: #fff;
      p.title{
        font-size: 1.5rem;
        font-weight: bold;
      }
      .left{
        padding: 1rem;
        float: left;
        .header-photo{
          height: 6rem;
          width: 6rem;
          text-align: center;
          line-height: 6rem;
          font-size: 3rem;
          background: #545C64;
          color: #fff;
          border-radius: 50%;
        }
      }
      .right{
        float: left;
        width: calc(100% - 8rem);
        hr{
          display: block;
          margin: 2rem 0;
        }
        p{
          color: #999;
        }
        .go-personal-homepage{
          position: absolute;
          margin: -3rem 0 0 40rem;
          font-size: 0.9rem;
        }
        .top span:nth-child(4){
          margin-left: 1rem;
        }
        .modify{
          float: right;
          font-size: 0.9rem;
          margin-right: 1rem;
        }
      }
    }
  }
</style>
