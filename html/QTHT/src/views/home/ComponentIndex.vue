<template>
  <div>
    <el-card class="box-card" style="width: 300px;margin:10px auto 10px 50px ">
      <div slot="header" class="clearfix">
        <span>账号信息</span>
        <el-button style="float: right; padding: 3px 0" type="text">充值</el-button>
      </div>
      <div style="color: #CC6633">余额: {{balance}} 元</div>
    </el-card>
    <el-card class="box-card" style="width: 300px;margin:10px auto 10px 50px;float:left">
      <div slot="header" class="clearfix">
        <span>系统信息</span>
      </div>
      <div style="color: #9933CC">前端版本: {{sysInfo.htmlVersion}}</div>
      <br>
      <div style="color: #9933CC">后端版本: {{sysInfo.apiVersion}}</div>
      <br>
      <div style="color: #9933CC">Api接口调用总次数: {{sysInfo.api.apiCallMAX}}</div>
      <br>
      <div style="color: #9933CC">今日Api调用次数: {{sysInfo.api.toDayCallMAX}}</div>
      <br>
      <div style="color: #9933CC">7日Api调用次数: {{sysInfo.api.Day7CallMAX}}</div>
      <br>
      <div style="color: #9933CC">30日Api调用次数: {{sysInfo.api.Day30CallMAX}}</div>
      <br>
      <div style="color: #9933CC">集群数量: {{sysInfo.api.clusterMAX}}</div>
      <br>
    </el-card>
    <el-card class="box-card" style="width: 300px;margin:20px auto 10px 400px ">
      <div slot="header" class="clearfix">
        <span>用户信息</span>
      </div>
      <div style="color: #FF0066">在线用户: {{sysInfo.user.onlineUser}} 个</div>
      <br>
      <div style="color: #FF0066">用户总数: {{sysInfo.user.MAXOnline}} 个</div>
      <br>
      <div style="color: #FF0066">今日在线用户总数: {{sysInfo.user.toDayOnline}} 个</div>
      <br>
      <div style="color: #FF0066">今日注册用户总数: {{sysInfo.user.RegiserUser}} 个</div>
      <br>
    </el-card>
  </div>
</template>

<script>

  export default {
    name: "ComponentIndex",
    data() {
      return {
        balance: "100.00",
        sysInfo: {
          htmlVersion: "alpha-0.1",
          apiVersion: "alpha-0.7",
          api: {
            apiCallMAX: "0",
            toDayCallMAX: "0",
            Day7CallMAX: "0",
            Day30CallMAX: "0",
            clusterMAX: "1000"
          },
          user: {
            onlineUser: "0",
            toDayOnline: "0",
            MAXOnline: "0",
            RegiserUser: "0"
          }
        }
      }
    },
    mounted() {

    },
    created() {

    },
    methods: {}
  }
</script>

<style scoped>

</style>
