<template>
  <el-container>
    <el-main>
      <nav>
        <el-menu
          default-active="1"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose">
          <el-menu-item v-for="(item) in nav"
                        :key="item.id"
                        :index="item.id"
                        @click="one(item.id,item.name)">
            <span slot="title">{{item.name}}</span>
          </el-menu-item>
        </el-menu>
      </nav>
      <div class="content">
        <el-carousel :interval="5000" arrow="always">
          <el-carousel-item>
            <!--v-for="item in 4" :key="item"-->
            <img src="../assets/imgs/list1.png" height="300" width="920"/>
          </el-carousel-item>
          <el-carousel-item>
            <img src="../assets/imgs/list2.png" height="300" width="920"/>
          </el-carousel-item>
          <el-carousel-item>
            <img src="../assets/imgs/list3.png" height="300" width="920"/>
          </el-carousel-item>
          <el-carousel-item>
            <img src="../assets/imgs/list4.png" height="300" width="920"/>
          </el-carousel-item>
          <el-carousel-item>
            <img src="../assets/imgs/list5.png" height="300" width="920"/>
          </el-carousel-item>
        </el-carousel>
        <ul>
          <li>
            <h1 class="special-text">这些软件太强了，Windows必装！尤其程序员！</h1>
            <p>Windows可谓是大多数人的生产力工具，集娱乐办公于一体，虽然在程序员这个群体中都说苹果是信仰，但是大部分</p>
            <div class="author">
              <div class="left">
                <img class="header special-text" src="../assets/imgs/header.jpg"/>
                <span class="special-text">ithuangqing</span>
              </div>
              <div class="right">
                <div class="icon">
                  <div class="one-icon">
                    <i class="el-icon-star-off"></i>
                    <span>224</span>
                  </div>
                  <div class="one-icon">
                    <i class="el-icon-view"></i>
                    <span>6665</span>
                  </div>
                  <div class="one-icon">
                    <i class="el-icon-chat-dot-square"></i>
                    <span>24</span>
                  </div>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </el-main>
    <el-aside>
      <div class="official-blog">
          <img class="radius official-blog-header" src="../assets/imgs/header2.jpg" />
          <div class="official-blog-name special-text-blue">
            飘雪文库官方博客
          </div>
      </div>
      <footers></footers>
    </el-aside>
  </el-container>

</template>

<script>
  import footers from './components/Footer'
  export default {
    name: "blog",
    data() {
      return{
        index:"",
        nav:[
          {
            name:"推荐",
            id:'1'
          },
          {
            name:"动态",
            id: "2"
          },
          {
            name:"程序人生",
            id: "3"
          },
          {
            name:"Java",
            id: "4"
          },
          {
            name:"前端",
            id: "5"
          },
          {
            name:"数据库",
            id: "6"
          },
          {
            name:"移动开发",
            id: "7"
          },
          {
            name:"运维",
            id: "8"
          },
          {
            name:"计算机基础",
            id: "9"
          }, {
            name:"其他",
            id: "0"
          },
        ],
      }
    },
    methods:{
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      one(id,name) {
        console.log(id,name)
      }
    },
    components: {
      footers
    }
  }
</script>

<style scoped>
  .official-blog-header{
    margin-top: 1rem;
    height: 2rem;
    width: 2rem;
  }
  .official-blog-name{
    font-size: 1.5rem;
    height: 4rem;
    color: #999;
    line-height: 4rem;
    margin-left: 1rem;
  }
  .official-blog{
    background: #fff;
    height: 4rem;
    padding: 1rem;
    display: flex;
  }
  .el-container{
    padding: 0 20%;
  }
  .el-aside{
    margin-top: 1rem;
    margin-left: 1rem;
  }
  .secant{

  }
  nav{
    width: 14%;
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
  .el-menu-item.is-active{
    color: #fff!important;
    background: #545C64!important;
  }
  .content ul{
    list-style: none;
    padding: 1rem;
  }
  .el-main{
    display: flex;
    padding: 1rem 0;
  }
  .content li{
    padding: 1rem;
  }
  .el-main li h1{
    overflow: hidden;
    text-overflow:ellipsis;
    white-space: nowrap;
  }
  .el-main li p{
    font-size: 0.9rem;
    color: #7f7f7f;
    overflow: hidden;
    text-overflow:ellipsis;
    white-space: nowrap;
  }
  .content{
    width: 84%;
    background: #fff;
    margin-left: 2%;
  }

  .el-carousel img{
    vertical-align: middle
  }
  .header{
    border-radius: 50%;
  }
  .icon{
    height: 1.2rem;
  }
  .author{
    display: flex;
    padding: 0.5rem;
  }
  .left{
    height: 2rem;
  }
  .left img{
    display: inline-block;
    height: 2rem;
    float: left;
  }
  .left span{
    margin-left:0.5rem ;
    display: inline-block;
    line-height: 2rem;
  }

  .right{
    flex: 4;
    height: 2rem;
    line-height: 2rem;
  }
  .right .icon{
    float: right;
    height: 2rem;
    display: flex;
  }
  .right .icon i{
    height: 2rem;
    line-height: 2rem;
    margin-right: 0.1rem;
  }
  .right .icon span{
    height: 2rem;
    line-height: 2rem;
    margin-right: 0.5rem;
  }
  .right span{
    font-size: 0.9rem;
    color: #349EDF;
  }
  .one-icon{
    cursor: pointer;
  }
  .one-icon:hover{
    color: #349EDF;
  }
</style>
