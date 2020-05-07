<template>
  <div id="myCollection">
    <div class="titles">
      <div class="title pointer">
        我的收藏
      </div>
      <div class="add pointer" @click="addCollection">
        + 新建收藏夹
      </div>
    </div>
    <el-collapse v-model="activeNames" accordion @change="handleChange" v-loading="loading">
      <el-collapse-item :name="item.id" :key="item.id" v-for="item in myCollectionType">
        <template slot="title">
          <p>{{item.value}}</p><br>
          <p class="collection-number grey">{{item.number}}条内容</p>
        </template>
        <div v-if="isNull" class="data-null">暂无收藏</div>
        <div class="one" v-for="i in oneCollectionList">
          <h3 @click="getInfo(i.content_id,i.author_id)" class="pointer">{{i.title}}</h3> <span class="cancel-collection special-text-yellow">取消收藏</span>
          <p class="collection-content">{{i.content_text}}</p>
          <p class="time">{{i.collectio_time}}</p>
        </div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
    export default {
        name: "MyCollection",
      data() {
          return{
            activeNames: [],
            myCollectionType: [],
            oneCollectionList: [],
            isNull: true,
            loading: false,
          }
      },
      mounted() {
          this.refresh()
      },
      methods: {
          addCollection() {
            this.$prompt('请输入收藏夹名称', '新增收藏夹', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              inputPattern: /\S/,
              inputErrorMessage: '收藏夹名称不能为空'
            }).then(({ value }) => {
              let userId = JSON.parse(sessionStorage.getItem("userInfo")).user_id;
              this.$ajax.post("/px/addCollection",{userId:userId,name:value},r=>{
                if (r === 1) {
                  this.$message({
                    type: 'success',
                    message: "新增收藏夹成功"
                  });
                  this.refresh()
                } else {
                  this.$message.error("新增收藏夹失败")
                }
              })
            }).catch(() => {
              this.$message({
                type: 'info',
                message: '取消新增收藏夹'
              });
            });
          },
        refresh() {
          let id = JSON.parse(sessionStorage.getItem("userInfo")).user_id;
          this.$ajax.post('/px/getMyCollectionList',{userId:id},r=>{
            this.myCollectionType = r;
          })
        },
        handleChange(val) {
          this.loading = true;
          this.oneCollectionList = [];
          this.isNull = true;
          let id = JSON.parse(sessionStorage.getItem("userInfo")).user_id;
          this.$ajax.post("/px/getOneCollectionList",{userId:id,typeId:val},r=>{
            if (r.length > 0) {
              this.isNull = false;
              this.oneCollectionList = r;
            }
            this.loading = false;
          })
        },
        getInfo(id,authorId) {
          this.$router.push({name: "content"})
          sessionStorage.setItem("blogId",id)
          sessionStorage.setItem("authorId",authorId)
        },

      }
    }
</script>

<style lang="scss" scoped>
  .one h3{
    margin-bottom: 0.2rem;
  }
  .one .time{
    margin-top: 0.2rem;
  }
  .collection-content{
    height: 3rem;
    overflow: hidden;
    margin: 0 !important;
  }
  .cancel-collection{
    float: right;
    margin-top: -2.2rem;
  }
  .collection-number{
    margin-left: 1rem;
    font-size: 0.5rem;
  }
  *{
    color: #4d4d4d;
  }
  .data-null{
    font-size: 0.9rem;
    margin-left: 1rem;
  }
  #myCollection{
    background: #FFF;
    padding: 1rem 2rem;
    .titles{
      height: 2.5rem;
      .title{
        font-size: 1.3rem;
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
