<template>
  <div class="hello" style="">
    <v-parallax
      height="120"
      :src="bgSrc"
    >
      <div class="carouselSpan mb-2">
        <span class="display-1" style="width: 50%">{{ $t('purchaseSystem')}}</span>
      </div>
      <div class="carouselSpan1 ma-2">
        <span class="subtitle-1" style="width: 66%">{{$t('purchaseSystemMsg')}}</span>
      </div>
    </v-parallax>
    <v-card elevation="0">
<!--      <v-card-title class="justify-center">-->
<!--      </v-card-title>-->
      <v-card-text>
        <v-row>
          <v-col sm="2"><v-btn color='deep-purple accent-4' block dark @click=getDate()>{{$t('Query')}}</v-btn></v-col>
          <v-col>
            <v-data-table
              :headers="headers"
              :items="items"
              item-key="id"
              class="elevation-1"
            >
            </v-data-table>
          </v-col>

        </v-row>
        <v-row>
          <v-col sm="1"></v-col>
          <v-col>

          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
      </v-card-text>
    </v-card>
    </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data: () => ({
    bgSrc: window.localStorage.getItem('bgPic'),
    msg: 'Welcome to Your Vue.js App',
    headers: [],
    items: [
      {id: 1},
      {id: 2},
      {id: 3},
      {id: 4},
      {id: 5},
      {id: 6},
      {id: 7},
      {id: 8},
      {id: 9},
      {id: 10},
      {id: 11, purchaseBill: 111}
    ]
  }),
  methods: {
    setHeaders () {
      this.headers = [
        { text: this.$t('Bill'), value: 'purchaseBill' },
        { text: this.$t('medicineName'), value: 'medicineName' },
        { text: this.$t('Number'), value: 'purchaseNumber' },
        { text: this.$t('Store'), value: 'storeName' },
        { text: this.$t('Date'), value: 'date' }
      ]
    },

    formatDate (time) {
      let now = new Date(time)
      let year = now.getFullYear() // 取得4位数的年份
      let month = now.getMonth() + 1 // 取得日期中的月份，其中0表示1月，11表示12月
      let date = now.getDate() // 返回日期月份中的天数（1到31）
      let hour = now.getHours() // 返回日期中的小时数（0到23）
      let minute = now.getMinutes() // 返回日期中的分钟数（0到59）
      let second = now.getSeconds() // 返回日期中的秒数（0到59）
      return new Date(year + '-' + month + '-' + date + ' ' + hour + ':' + minute + ':' + second)
    },

    getDate () {
      this.$axios({ method: 'get', url: '/Purchase/all' }).then((res) => {
        if (res.status === 200) {
          res.data.forEach((item) => {
            item.date = this.formatDate(item.purchaseDate).toString()
            console.log(item.date)
          })
          this.items = res.data
        }
      })
    }
  },
  computed: {
    area () {
      return this.$i18n.locale
    }
  },
  created () {
    window.localStorage.setItem(
      'btnColor',
      [
        'transparent',
        '#4caf50',
        'transparent',
        'transparent',
        'transparent',
        'transparent'
      ])
  },
  mounted: function () {
    this.setHeaders()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
