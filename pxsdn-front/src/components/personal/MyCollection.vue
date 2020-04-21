<template>
  <div id="myCollection">
    <div class="titles">
      <div class="title pointer">
        我的收藏
      </div>
      <div class="add pointer">
        + 新建收藏夹
      </div>
    </div>
    <hr>
    <div class="list">
      <div class="one" v- v-for="item in 5">
        <div class="name">
          <span class="pointer">数据库</span>
        </div>
        <div class="number">2条内容</div>
        <i class="el-icon-arrow-right icon pointer"></i>
        <hr>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "MyCollection",
      data() {
          return{

          }
      },
      mounted() {
          // this.$ajax.post('/px/getMyCollectionList')
      },
      methods: {

      }
    }
</script>

<style lang="scss" scoped>
  *{
    color: #4d4d4d;
  }
  #myCollection{
    background: #FFF;
    padding: 1rem 2rem;
    .titles{
      height: 2.5rem;
      .title{
        font-size: 1.5rem;
        float: left;
      }
      .add{
        float: right;
        margin: 0.25rem 0.25rem 0 0;
      }
    }

    .list{
      .one{
        /*height: 2rem;*/
        .name{
          font-weight: bold;
          height: 2rem;
          line-height: 2rem;
        }
        .number{
          font-size: 0.8rem;
          height: 1.5rem;
          line-height: 1.5rem;
          color: #545C64;
        }
        .icon{
          float: right;
          margin-top: -2.2rem;
        }
      }
    }
  }
</style>
