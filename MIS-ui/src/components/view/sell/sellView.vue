<template>
  <div class="hello" style="">
    <v-parallax
      height="120"
      :src="bgSrc"
    >
      <div class="carouselSpan mb-2">
        <span class="display-1" style="width: 50%">{{ $t('sellSystem')}}</span>
      </div>
      <div class="carouselSpan1 ma-2">
        <span class="subtitle-1" style="width: 66%">{{$t('sellSystemMsg')}}</span>
      </div>
    </v-parallax>
    <v-card elevation="0">
<!--      <v-card-title class="justify-center">-->
<!--      </v-card-title>-->
      <v-card-text>
        <v-row>
          <v-col sm="3">
            <v-btn color='deep-purple accent-4' block dark @click=getDate() class="mb-1">{{$t('Query')}}</v-btn>
            <v-menu
              ref="dateStart"
              v-model="menu"
              :close-on-content-click="false"
              :return-value.sync="date"
              transition="scale-transition"
              offset-y
              max-width="290px"
              min-width="290px"
            >
              <template v-slot:activator="{ on }">
                <v-text-field
                  v-model="dates[0]"
                  :label="$t('startDate')"
                  prepend-icon="event"
                  readonly
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="dates[0]"
                type="month"
                no-title
                scrollable
              >

              </v-date-picker>
            </v-menu>
            <v-menu
              ref="dateEnd"
              v-model="menu2"
              :close-on-content-click="false"
              :return-value.sync="date"
              transition="scale-transition"
              offset-y
              max-width="290px"
              min-width="290px"
            >
              <template v-slot:activator="{ on }">
                <v-text-field
                  v-model="dates[1]"
                  :label="$t('endDate')"
                  prepend-icon="event"
                  readonly
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="dates[1]"
                type="month"
                no-title
                scrollable
              >

              </v-date-picker>
            </v-menu>
            <v-text-field
              v-model="bill"
              :label="$t('Bill')"
            />
            <v-select
              v-model="selectType"
              :items="typeItems"
              :label="$t('medicineName')"
              :menu-props="{ auto: true, overflowY: true }"
            ></v-select>
            <v-select
              v-model="selectStore"
              :items="storeItems"
              :label="$t('Store')"
              :menu-props="{ auto: true, overflowY: true }"
            ></v-select>
          </v-col>
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
            <v-btn @click="$router.back(-1)"  block color='success' dark >
              {{$t('return')}}
            </v-btn>
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
    items: [],
    typeItems: [],
    selectType: '',
    storeItems: [],
    selectStore: '',
    menu: false,
    menu2: false,
    dates: [],
    date: new Date().toISOString().substr(0, 7),
    bill: ''
  }),
  methods: {
    setHeaders () {
      this.headers = [
        { text: this.$t('Bill'), value: 'sellBill' },
        { text: this.$t('medicineName'), value: 'medicineName' },
        { text: this.$t('sellNumber'), value: 'sellNumber' },
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
      let timeDto = {
        beginDate: new Date(this.dates[0]).getTime(),
        endDate: new Date(this.dates[1]).getTime()
      }
      let url = '/Sell/record?sellType=' + this.selectType + '&sellStore=' + this.selectStore + '&bill=' + this.bill
      this.$axios.post(url, timeDto).then((res) => {
        if (res.status === 200) {
          res.data.forEach((item) => {
            item.date = this.formatDate(item.sellDate).toString()
          })
          this.items = res.data
        }
      })
    },

    getStoreAndMedicine () {
      this.$axios.get('/Medicine/all').then((res) => {
        if (res.status === 200) {
          const result = []
          res.data.forEach((item) => {
            result.push({text: item.medicineName + '-' + item.medicineProducer, value: item.id})
          })
          this.typeItems = result
        }
      })
      this.$axios.get('/Store/all').then((res) => {
        if (res.status === 200) {
          const result = []
          res.data.forEach((item) => {
            result.push({text: item.storeName, value: item.id})
          })
          this.storeItems = result
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
        'transparent',
        '#4caf50',
        'transparent',
        'transparent',
        'transparent'
      ])
  },
  mounted: function () {
    this.setHeaders()
    this.getStoreAndMedicine()
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
