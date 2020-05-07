<template>
  <el-container>
    <el-aside>
      <nav>
        <el-menu
          :default-active="index"
          class="el-menu-vertical-demo">
          <el-menu-item @click="goMyCollection" index="1">
            <span slot="title">我的收藏</span>
          </el-menu-item>
          <el-menu-item @click="goMyBlog" index="2">
            <span slot="title">我的博客</span>
          </el-menu-item>
          <el-menu-item @click="goPersonalData" index="3">
            <span slot="title">个人资料</span>
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
        name: "Personal",
      data() {
          return{
            index: this.$route.params.index,
          }
      },
      watch: {
        $route(to,from){
          this.Index = this.$route.params.index
          console.log(this.Index)
        }
      },
      mounted() {
        console.log(location)
      },
      methods: {
        goMyCollection() {
          this.$router.push({
            name:'mycollection',
            params: {
              index: "1"
            }
          })
        },
        goMyBlog() {
          this.$router.push({
            name:'myblog',
            params: {
              index: "1"
            }
          })
          sessionStorage.setItem("userId",JSON.parse(sessionStorage.getItem("userInfo")).user_id)
          /*let router = this.$router.resolve({
            name:'myblog',
            params: {
              index: "1"
            }
          })
          window.open(router.href+"?1",'_blank')*/
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
