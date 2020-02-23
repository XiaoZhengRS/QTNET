<template>
  <dev>
    <el-container>
      <!-- 顶部 -->
      <el-header style="height: 80px">
        <el-button-group>
          <el-button type="success" plain style="height: 80px;width: 150px;font-size: 27px">充值
          </el-button>
          <el-button type="success" plain style="height: 80px;width: 150px;font-size: 27px">自动发卡
          </el-button>
          <el-button type="success" plain style="height: 80px;width: 150px;font-size: 27px">加入Q群
          </el-button>
          <el-button type="success" plain style="height: 80px;width: 150px;font-size: 27px">个人资料
          </el-button>
          <el-button type="success" plain style="height: 80px;width: 150px;font-size: 27px">开源仓库
          </el-button>
        </el-button-group>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <!--
                      @open="handleOpen"
            @close="handleClose"
          -->
          <el-menu
            default-active="2"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            style="height: 900px">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-school"></i>
                <span slot="title">首页</span>
              </template>
              <el-menu-item @click="goPush('/home/ComponentIndex')">主页</el-menu-item>
              <el-menu-item @click="goPush('/home/statistical')">统计</el-menu-item>
              <el-menu-item @click="goPush('/home/usingTheTutorial')">使用教程</el-menu-item>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-set-up"></i>
                <span slot="title">程序管理</span>
              </template>
              <el-menu-item @click="goPush('/home/programList')">程序列表</el-menu-item>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-paperclip"></i>
                <span slot="title">WebApi</span>
              </template>
              <el-menu-item @click="goPush('/home/webApiList')">WebApi列表</el-menu-item>
              <el-menu-item @click="goPush('/home/webApiDiyErrorCode')">自定义错误代码</el-menu-item>
              <el-menu-item @click="goPush('/home/webApiErrorCode')">错误代码列表</el-menu-item>
            </el-submenu>
            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-s-check"></i>
                <span slot="title">代理管理</span>
              </template>
              <el-menu-item @click="goPush('/home/agentList')">代理列表</el-menu-item>
              <el-menu-item @click="goPush('/home/agentAudit')">代理审核</el-menu-item>
            </el-submenu>
            <el-submenu index="5">
              <template slot="title">
                <i class="el-icon-user-solid"></i>
                <span slot="title">用户管理</span>
              </template>
              <el-menu-item @click="goPush('/home/userList')">用户列表</el-menu-item>
              <el-menu-item @click="goPush('/home/userUserLogin')">登陆数据</el-menu-item>
              <el-menu-item @click="goPush('/home/userOnlineUser')">在线用户</el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <!-- 主内容 -->
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </dev>
</template>

<script>
  export default {
    name: "Home",
    data() {
      return {}
    },
    mounted() {
      this.$router.push("/home/ComponentIndex");
    },
    created() {

    },
    methods: {
      goPush(url) {
        console.log("路由" + url);
        this.$router.push(url);
      }
    },
    components: {}
  }
</script>

<style scoped>
  * {
    margin: 0;
    padding: 0;
  }
</style>
