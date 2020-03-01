<template>
  <div class="hello" style="">
    <v-parallax
      height="120"
      :src="bgSrc"
    >
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
          <v-col sm="3">
            <v-btn color='deep-purple accent-4' block dark @click=getDate() class="mb-1">{{$t('Query')}}</v-btn>
            <v-text-field
              v-model="producer"
              :label="$t('producer')"
            />
            <v-text-field
              v-model="medicineName"
              :label="$t('medicineName')"
            />
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
    producer: '',
    medicineName: ''
  }),
  methods: {
    setHeaders () {
      this.headers = [
        { text: this.$t('medicineName'), value: 'medicineName' },
        { text: this.$t('producer'), value: 'medicineProducer' },
        { text: this.$t('Price'), value: 'medicinePrice' },
        { text: this.$t('Unit'), value: 'medicineUnit' },
        { text: this.$t('Description'), value: 'medicineDescription' }
      ]
    },

    getDate () {
      let url = '/Medicine/record?name=' + this.medicineName + '&producer=' + this.producer
      this.$axios.get(url).then((res) => {
        if (res.status === 200) {
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
        '#4caf50',
        'transparent',

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
