<template>
<v-btn @click.native="loginFun">{{$t('login')}}</v-btn>
</template>

<script>
export default {
  name: 'Login',
  methods: {
    loginFun () {
      let adminDo = {
        account: 'admin', // 登录名
        password: 'admin' // 登录密码
      }
      let url = '/admin/login'
      this.$axios.post(url, adminDo).then((res) => {
        if (res.data.status === 200) {
          var userInfo = res.data.data
          this.$store.commit('$_setToken', userInfo.token)
          alert({ message: '登录成功', type: 'success', duration: 1500 }) // ui弹窗提示
          this.$router.push({ name: 'homePage' }) // 跳转到首页
        } else {
          alert({ message: res.data.message, duration: 1500 }) // ui弹窗提示
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
