<template>
  <div class="hello" style="">
    <v-parallax
      height="120"
      :src="bgSrc"
    >
      <div class="carouselSpan mb-2">
        <span class="display-1" style="width: 50%">{{ $t('storeSystem')}}</span>
      </div>
      <div class="carouselSpan1 ma-2">
        <span class="subtitle-1" style="width: 66%">{{$t('storeSystemMsg')}}</span>
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
              v-model="storeName"
              :label="$t('storeName')"
            />
            <v-text-field
              v-model="storeAddress"
              :label="$t('storeAddress')"
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
            <v-btn to="/store"  block color='success' dark >
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
    storeAddress: '',
    storeName: ''
  }),
  methods: {
    setHeaders () {
      this.headers = [
        { text: this.$t('storeName'), value: 'storeName' },
        { text: this.$t('storeAddress'), value: 'storeAddress' },
        { text: this.$t('storeCapacity'), value: 'storeCapacity' },
        { text: this.$t('storeCapacityUse'), value: 'storeCapacityUse' }
      ]
    },

    getDate () {
      let url = '/Store/record?storeName=' + this.storeName + '&storeAddress=' + this.storeAddress
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
        'transparent',
        'transparent',
        'transparent',
        '#4caf50',
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
