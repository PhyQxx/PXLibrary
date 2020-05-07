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
                        @click="one(item.id,item.value)">
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
        <ul v-if="blogList != ''" v-loading="loading">
          <li v-for="item in blogList" :data-id="item.id">
            <h1 class="special-text pointer" @click="getInfo(item.id,item.author_id)">{{item.title}}</h1>
            <p>{{item.content}}</p>
            <div class="author">
              <div class="left">
                <div>{{item.header_photo}}</div>
                <span class="special-text">{{item.author}}</span>
              </div>
              <div class="right">
                <div class="icon">
                  <div class="one-icon" @click="getInfo(item.id,item.author_id)">
                    <i class="el-icon-star-off"></i>
                    <span>{{item.praise_number}}</span>
                  </div>
                  <div class="one-icon" @click="getInfo(item.id,item.author_id)">
                    <i class="el-icon-view"></i>
                    <span>{{item.read_number}}</span>
                  </div>
                  <!--<div class="one-icon">
                    <i class="el-icon-chat-dot-square"></i>
                    <span>{{item.comment_number}}</span>
                  </div>-->
                </div>
              </div>
            </div>
          </li>
        </ul>
        <nodata v-if="blogList == ''"></nodata>
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
  import nodata from './components/NoData'
  export default {
    name: "blog",
    data() {
      return{
        index:"",
        nav:[
          {
            name:"推荐",
            value:"",
            id:'1'
          },
          {
            name:"程序人生",
            value:"程序人生",
            id: "3"
          },
          {
            name:"Java",
            value:"Java",
            id: "4"
          },
          {
            name:"前端",
            value:"前端",
            id: "5"
          },
          {
            name:"数据库",
            value:"数据库",
            id: "6"
          },
          {
            name:"移动开发",
            value:"移动开发",
            id: "7"
          },
          {
            name:"运维",
            value:"运维",
            id: "8"
          },
          {
            name:"计算机基础",
            value:"计算机基础",
            id: "9"
          }, {
            name:"其他",
            value:"其他",
            id: "0"
          },
        ],
        loading: false,
        blogList: "",
      }
    },
    mounted() {
      this.getBlogList();
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
      },
      getBlogList() {
        this.loading = true;
        this.$ajax.post('/px/getBlogList', {type:""}, r => {
          this.blogList = r;
          for (let i = 0; i < this.blogList.length; i++) {
            this.blogList[i].header_photo = this.blogList[i].author.substring(0,1)
          }
          this.loading = false;
        });
        setTimeout(()=>{},1000)
      },
      one(id,name) {
        this.$ajax.post('/px/getBlogList', {type:name}, r => {
          this.blogList = r;
          for (let i = 0; i < this.blogList.length; i++) {
            this.blogList[i].header_photo = this.blogList[i].author.substring(0,1)
          }
        });
      },
      getInfo(id,authorId) {
        this.$router.push({name: "content"})
        sessionStorage.setItem("blogId",id)
        sessionStorage.setItem("authorId",authorId)
      }
    },
    components: {
      footers,
      nodata
    }
  }
</script>

<style scoped>
  .left div{
    float: left;
    height: 1.5rem;
    width: 1.5rem;
    line-height: 1.5rem;
    text-align: center;
    border-radius: 50%;
    background: #545C64;
    color: #fff;
    margin-top: 0.25rem;
  }
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
    padding: 0.5rem 1rem;
    border-bottom: 1px solid #999;
  }
  .content li h1{
    margin: 0.3rem 0;
  }
  .content li p{
    margin: 0;
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
    padding: 0.2rem 0.5rem;
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
