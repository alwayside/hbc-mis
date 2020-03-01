<template>
  <div class="hello" style>
    <v-parallax height="120" :src="bgSrc">
      <div class="carouselSpan mb-2">
        <span class="display-1" style="width: 50%">{{ $t('medicineSystem')}}</span>
      </div>
      <div class="carouselSpan1 ma-2">
        <span class="subtitle-1" style="width: 66%">{{$t('medicineSystemMsg')}}</span>
      </div>
    </v-parallax>
    <v-card elevation="0">
      <!--      <v-card-title class="justify-center">-->
      <!--      </v-card-title>-->
      <v-card-text>
        <v-row>
          <v-col>
            <v-snackbar v-model="successAlter" color="success">
              success
              <v-btn dark text @click="successAlter = false">{{$t('close')}}</v-btn>
            </v-snackbar>
            <v-snackbar v-model="errorAlter" color="error">
              {{error}}
              <v-btn dark text @click="errorAlter = false">{{$t('close')}}</v-btn>
            </v-snackbar>
          </v-col>
        </v-row>
                <v-row>
          <v-col sm="1"></v-col>
          <v-col>

            <span class="title">{{$t('medicineSell')}}</span>
          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
        <v-row>
          <v-col sm="1"></v-col>
          <v-select
            v-model="selectType"
            :items="typeItems"
            :label="$t('medicineName')"
            :menu-props="{ auto: true, overflowY: true }"
          ></v-select>
          <v-col sm="1"></v-col>
          <v-select
            v-model="selectStore"
            :items="storeItems"
            :label="$t('sellStore')"
            :menu-props="{ auto: true, overflowY: true }"
          ></v-select>
          <v-col sm="1"></v-col>
        </v-row>
        <v-row>
          <v-col sm="1"></v-col>
          <v-text-field
              type="number"
              v-model="number"
              :label="$t('puchaseNumber')"
            />
          <v-col sm="1"></v-col>
          <v-col>
              <v-btn color="success" block dark @click="getDate()" class="mb-1">{{$t('addRecord')}}</v-btn>

          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
        <v-row>
          <v-col sm="1"></v-col>
          <v-col>
            <v-btn @click="$router.back(-1)" block color="success" dark>{{$t('return')}}</v-btn>
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
    typeItems: [],
    number: 0,
    selectType: null,
    storeItems: [],
    selectStore: null,
    successAlter: false,
    errorAlter: false,
    error: 'ERROR'
  }),
  methods: {
    getDate () {
      this.successAlter = false
      this.errorAlter = false
      let url = '/Sell?sellType=' + this.selectType + '&sellStore=' + this.selectStore + '&sellNumber=' + this.number
      this.$axios
        .put(url)
        .then(res => {
          console.log(res)
          if (res.status === 200) {
            this.number = 0
            this.selectStore = null
            this.selectType = null
            this.successAlter = true
          }
        })
        .catch(err => {
          if (err) {
            this.error = err.response.data ? err.response.data : 'error'
            this.errorAlter = true
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
    window.localStorage.setItem('btnColor', [
      'transparent',
      'transparent',
      '#4caf50',
      'transparent',
      'transparent',
      'transparent'
    ])
  },
  mounted: function () {
    this.getStoreAndMedicine()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
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
