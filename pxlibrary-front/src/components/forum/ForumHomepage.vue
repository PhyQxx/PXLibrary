<template>
  <el-container>
    <el-main>
      <div class="plate technology">
        <div class="header">
          <div class="left">
            技术区
          </div>
          <div class="right special-text-blue">
            更多
          </div>
        </div>
        <div class="content">
          <div class="header1">
            <div class="title">标题</div>
            <div class="questioner">提问人</div>
            <div class="replyNumber">回复数</div>
            <div class="popularity">人气</div>
          </div>
          <hr>
          <div class="list">
            <div class="one" v-for="item in technologyList">
              <div class="title">
                <span class="blue title-type">{{item.title.type}}</span>
                ·
                <span class="special-text-blue">{{item.title.title}}</span>
              </div>
              <div class="questioner pointer">
                {{item.questioner}}
              </div>
              <div class="replyNumber">
                {{item.replyNumber}}
              </div>
              <div class="popularity">
                {{item.popularity}}
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="plate life">
        <div class="header">
          <div class="left">
            生活区
          </div>
          <div class="right special-text-blue">
            更多
          </div>
        </div>
        <div class="content">
          <div class="header1">
            <div class="title">标题</div>
            <div class="questioner">提问人</div>
            <div class="replyNumber">回复数</div>
            <div class="popularity">人气</div>
          </div>
          <hr>
          <div class="list">
            <div class="one" v-for="item in lifeList">
              <div class="title">
                <span class="blue title-type">{{item.title.type}}</span>
                ·
                <span class="special-text-blue">{{item.title.title}}</span>
              </div>
              <div class="questioner pointer">
                {{item.questioner}}
              </div>
              <div class="replyNumber">
                {{item.replyNumber}}
              </div>
              <div class="popularity">
                {{item.popularity}}
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="plate all">
        <div class="header">
          <div class="left">
            主要论坛分类
          </div>
        </div>
        <div class="content">
          <div class="type-one" v-for="item in typeList">
            <div class="type-name special-text-blue">{{item.name}}</div>
            <div class="type-list">
              <span class="special-text-blue underline-hover" v-for="i in item.type">{{i}}</span>
            </div>
            <hr>
          </div>
        </div>
      </div>
    </el-main>
    <el-aside>
      <div class="personal-info">
        <div class="info">
          <div class="header-photo">
            <img src="../../assets/imgs/header1.jpg" height="75" width="75"/>
          </div>
          <div class="username">
            <p>{{userInfo.username}}</p>
            <div class="grade">
              <span>论坛</span>
              <span>{{userInfo.grade}}</span>
            </div>
          </div>
        </div>
        <hr>
        <div class="integral">
          <div id="integral">
            <div class="all">
              <p>剩余可用分</p>
              <span style="color: #FF9900">{{integral.all}}</span>
              <img src="../../assets/imgs/score.png" height="9" width="10"/>
            </div>
            <div class="technology">
              <p>总技术分</p>
              <span style="color: #FF9900">{{integral.technology}}</span>
              <img src="../../assets/imgs/score.png" height="9" width="10"/>
            </div>
            <div class="not-technology">
              <p>总非技术分</p>
              <span style="color: #FF9900">{{integral.notTechnology}}</span>
              <img src="../../assets/imgs/score.png" height="9" width="10"/>
            </div>
          </div>
        </div>
        <div id="ranking">
          <div class="now">
            <p>现在排名</p>
            <span>{{integral.nowRanking}}</span>
            <img v-if="top" src="../../assets/imgs/top.png" height="14" width="14"/>
            <img v-if="bottom" src="../../assets/imgs/bottom.png" height="14" width="14"/></div>
          <div class="last">
            <p>上次排名</p>
            <span>{{integral.lastRanking}}</span>
          </div>
          <div class="space">
          </div>
        </div>
      </div>
      <div class="honor-roll">
        <div class="honor-roll-header">
          <span>荣誉榜</span>
        </div>
        <div class="honor-roll-content">
          <div class="honor-roll-one" v-for="(item,index) in honorRollList">
            <span class="honor-roll-one-ranking">{{index+1}}</span>
            <div class="user-info">
              <div class="pointer">{{item.headerPhoto}}</div>
              <span class="special-text-blue">{{item.username}}</span>
            </div>
            <span>{{item.integral}}</span>
          </div>
        </div>
      </div>
      <footers></footers>
    </el-aside>
  </el-container>
</template>

<script>
  import footers from "../Footer"
    export default {
        name: "ForumHomepage",
      data() {
          return{
            top: false,
            bottom: false,
            integral: {
              all: "120",
              technology: "250",
              notTechnology: "410",
              lastRanking: "3",
              nowRanking: "5",
            },
            userInfo: {
              username: "帅气的布里茨",
              grade: "1",
            },
            technologyList: [
              {
                title: {
                  type: "C#",
                  title: "有没有c#可以调用的，定位桌面图标位置的方法或者DLL？",
                },
                questioner: "美丽的娃哈哈",
                replyNumber: "42",
                popularity: "241"
              },
              {
                title: {
                  type: "C#",
                  title: "有没有c#可以调用的，定位桌面图标位置的方法或者DLL？",
                },
                questioner: "美丽的娃哈哈",
                replyNumber: "42",
                popularity: "241"
              },
              {
                title: {
                  type: "C#",
                  title: "有没有c#可以调用的，定位桌面图标位置的方法或者DLL？",
                },
                questioner: "美丽的娃哈哈",
                replyNumber: "42",
                popularity: "241"
              },
            ],
            lifeList: [
              {
                title: {
                  type: "C#",
                  title: "有没有c#可以调用的，定位桌面图标位置的方法或者DLL？",
                },
                questioner: "美丽的娃哈哈",
                replyNumber: "42",
                popularity: "241"
              },
              {
                title: {
                  type: "C#",
                  title: "有没有c#可以调用的，定位桌面图标位置的方法或者DLL？",
                },
                questioner: "美丽的娃哈哈",
                replyNumber: "42",
                popularity: "241"
              },
              {
                title: {
                  type: "C#",
                  title: "有没有c#可以调用的，定位桌面图标位置的方法或者DLL？",
                },
                questioner: "美丽的娃哈哈",
                replyNumber: "42",
                popularity: "241"
              },
            ],
            typeList: [
              {
                id:"0",
                name: "移动开发",
                type: ["Android","iOS","Qt","WP"]
              },
              {
                id:"1",
                name: "Java技术",
                type: ["Java SE","Java Web 开发","Java EE","Java其他相关"]
              },
              {
                id:"2",
                name: "Web开发",
                type: ["PHP","JavaScript","ASP","HTML(CSS)","HTML5","Apache"]
              },
              {
                id:"3",
                name: "数据库开发",
                type: ["Oracle","MS-SQL Server","其他数据库开发"]
              },
              {
                id:"4",
                name: "硬件/嵌入式开发",
                type: ["嵌入开发(WinCE)","驱动开发/核心开发","硬件设计","单片机/工控","汇编语言"]
              },
              {
                id:"5",
                name: "Linux/Unix社区",
                type: ["系统维护与使用区","应用程序开发区","内核源代码研究区","驱动程序开发区","CPU和硬件区"]
              },
            ],
            honorRollList: [
              {
                id: "",
                headerPhoto: "",
                username: "帅气的小兜",
                integral: "654"
              },
              {
                id: "",
                headerPhoto: "",
                username: "娃哈哈",
                integral: "474"
              },
              {
                id: "",
                headerPhoto: "",
                username: "乌拉拉",
                integral: "254"
              },
              {
                id: "",
                headerPhoto: "",
                username: "我的天哪",
                integral: "98"
              },
            ],
          }
      },
      mounted() {
        for (let i = 0; i < this.honorRollList.length; i++) {
          this.honorRollList[i].headerPhoto = this.honorRollList[i].username.substring(0,1)
        }
        if (this.integral.lastRanking > this.integral.nowRanking) {
          this.top = true
        } else if (this.integral.lastRanking < this.integral.nowRanking) {
          this.bottom = true
        }
      },
      components: {
          footers
      }

    }
</script>

<style scoped>
  .el-aside{
    margin-left: 1rem;
  }
  .honor-roll-one:nth-child(-n+3) .honor-roll-one-ranking{
    background: #FF9900;
    color: #fff!important;
  }
  .user-info img{
    height: 1rem;
    width: 1rem;
    position: absolute;
    margin-top: 0.25rem;
  }
  .user-info div{
    margin: 0 0.5rem;
    display: inline-block;
    position: absolute;
    height: 1.5rem;
    width: 1.5rem;
    line-height: 1.5rem;
    text-align: center;
    border-radius: 50%;
    background: #545C64;
    color: #fff;
  }
  .user-info span{
    margin-left: 2.4rem;
    display: inline-block;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    width: 9rem;
  }
  .honor-roll-one span:nth-child(1){
    display: inline-block;
    text-align: center;
    flex: 1;
    font-size: 0.9rem;
    color: #ccc;

  }
  .honor-roll-one .user-info{
    flex: 8;
  }
  .honor-roll-one span:nth-child(3){
    display: inline-block;
    text-align: center;
    flex: 2;
    color: #999;
  }
  .honor-roll-content{
    margin: 0 1rem;
  }
  .honor-roll-one{
    line-height: 1.5rem;
    height: 1.5rem;
    display: flex;
    padding: 0.5rem 0;
    border-bottom: 1px solid #7f7f7f;
  }
  .honor-roll-header{
    padding: 1rem 1rem 0 1rem;
    color: #545C64;
    font-weight: bold;

  }
  .honor-roll{
    margin: 1rem 0 0 0;
    background: #fff;
  }
  #ranking{
    padding: 0 1rem;
    display: flex;
    text-align: center;
  }
  #ranking .last{
    flex: 1;
  }
  #ranking .now{
    flex: 1;
  }
  #ranking .space{
    flex: 1;
  }
  #ranking p{
    font-size: 0.9rem;
    margin: 0;
    color: #545C64;
  }
  #ranking span{
    font-size: 0.9rem;
    font-weight: bold;
  }
  .integral{
    padding: 0 1rem 1rem 1rem;
  }
  #integral{
    display: flex;
    text-align: center;
  }
  #integral .all{
    margin-top: 0;
    flex: 1;
  }
  #integral .technology{
    flex: 1;
  }
  #integral .not-technology{
    flex: 1;
  }
  #integral p{
    font-size: 0.9rem;
    margin: 0;
    color: #545C64;
  }
  #integral span{
    font-size: 0.8rem;
  }
  .grade{
    font-size: 0.8rem;
    color: #fff;
    border-radius: 5px;
  }
  .grade span:nth-child(1){
    background: #9DC75F;
    float: left;

  }
  .grade span:nth-child(2){
    background: #2D5315;
    float: left;
    min-width: 1rem;
    text-align: center;

  }
  .personal-info{
    background: #fff;
  }
  .info{
    padding: 1rem 1rem  0 1rem;
    display: flex;
  }
  .username{
    margin-left: 1rem;
  }
  .username p{
    font-weight: bold;
  }
  .type-one{
    margin-top: 1rem;
    width: 49%;
    float: left;
  }
  .type-one:nth-child(2n+0){
    margin-left: 2%;
  }
  .type-name{
    font-weight: bold;
  }
  .type-list{
    min-height: 6rem;
  }
  .type-list span{
    display: inline-block;
    margin-top: 0.5rem;
    margin-right: 1rem;
  }
  .all{
    margin-top: 1rem;
  }
  .life{
    margin-top: 1rem;
  }
  .title-type{
    cursor: pointer;
  }
  .title-type:hover{
    text-decoration: underline;
  }
  .one{
    display: flex;
    border-bottom: 1px solid #7f7f7f;
    padding: 0.5rem;
  }
  .el-container{
    padding: 0 20%;
  }
  .el-main{
    padding: 0%;
  }
  .plate{
    background: #fff;
  }
  .plate .header{
    background: #E3E6E8;
    height: 1.5rem;
    padding: 0.5rem 1rem;
  }
  .plate .header .left{
    float: left;
    font-weight: bold;
    height: 1.5rem;
    line-height: 1.5rem;
  }
  .plate .header .right{
    float: right;
    height: 1.5rem;
    line-height: 1.5rem;
  }
  .header1{
    background: #FAFAFA;
    display: flex;
    color: #999;
  }
  .title{
    flex: 8;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .questioner{
    flex: 2;
    color: #999;
  }
  .replyNumber{
    flex: 1;
    text-align: center;
    color: #999;
  }
  .popularity{
    text-align: center;
    color: #999;
    flex: 1;
  }
  .content{
    padding: 0 1rem;
  }
  .all .content{
    min-height: 30rem;
  }
</style>
