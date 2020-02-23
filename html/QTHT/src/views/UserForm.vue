<template>
  <dev>
    <el-form ref="form" :model="LoginForm" label-width="80px"
             style="width: 400px;background-color: #304156;margin:0 auto;padding-top: 10%">
      <div class="title-container">
        <h3 class="title">量 子 网 络 验 证</h3>
      </div>
      <el-form-item label="用户名">
        <el-input v-model="LoginForm.username"></el-input>
      </el-form-item>
      <el-form-item label="用户密码">
        <el-input type="password" v-model="LoginForm.password"></el-input>
      </el-form-item>
      <el-button :loading="loading" type="primary" style="width:280px;margin-bottom:10px;margin-left: 80px"
                 @click="Login">登陆
      </el-button>
      <br>
      <el-button :loading="loading" type="info" style="width:280px;margin-bottom:30px;margin-left: 80px"
                 @click="Register">注册
      </el-button>
      <div class="tips" style="margin-left: 80px">
        <span style="margin-right:20px;">开源协议: GPL</span>
        <span style="margin-right:20px;">系统作者: XiaoZhengRS</span>
      </div>
    </el-form>
  </dev>
</template>

<script>
  export default {
    name: "UserForm",
    data() {
      return {
        LoginForm: {
          username: 'xzkjxzkj',
          password: 'xzkjxzkj'
        }
      }
    },
    mounted() {

    },
    created() {

    },
    methods: {
      Login() {
        var data = new URLSearchParams();
        data.append("username", this.LoginForm.username);
        data.append("password", this.LoginForm.password);
        this.axios({
          method: "post",
          url: this.$cfg.ApiUrl + "user/login",
          data: data
        }).then(res => {
          if (res.data.code == 200) {
            /*登陆成功*/
            this.$userData.userToken = res.data.data.token;
            this.$userData.userName = this.LoginForm.username;
            this.$userData.userID = res.data.data.id;
            this.$userData.userUUID = res.data.data.uUID;
            this.$message({
              message: '恭喜你，登陆成功!',
              type: 'success'
            });
            this.$router.push("/home");
          } else {
            this.$message({
              message: res.data.data,
              type: 'warning'
            });
            console.log(res.data.data);
          }
        }).catch(res => {
          this.$message({
            message: res.data.data,
            type: 'warning'
          });
          console.log(res.data.data);
        })
      },
      Register() {
        var data = new URLSearchParams();
        data.append("username", this.LoginForm.username);
        data.append("password", this.LoginForm.password);
        this.axios({
          method: "post",
          url: this.$cfg.ApiUrl + "/user/register",
          data: data
        }).then(res => {
          if (res.data.code == 200) {
            /*注册成功*/
            this.$message({
              message: '恭喜你，注册成功!',
              type: 'success'
            });
          } else {
            this.$message({
              message: res.data.data,
              type: 'warning'
            });
            console.log(res.data.data);
          }
        }).catch(res => {
          this.$message({
            message: res.data.data,
            type: 'warning'
          });
          console.log(res.data.data);
        })
      }
    }
  }
</script>

<style>
  * {
    margin: 0;
    padding: 0;
  }

  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;
  }

  .title {
    font-size: 26px;
    color: #fff;
    margin: 0 auto 40px auto;
    text-align: center;
    font-weight: bold;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }
</style>


