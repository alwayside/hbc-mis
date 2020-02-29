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
        <v-col>
          <v-snackbar v-model="successAlter" color="success">
              success
              <v-btn dark text @click="successAlter = false">{{$t('close')}}</v-btn>
            </v-snackbar>
             <v-snackbar v-model="errorAlter" color="error">
              error
              <v-btn dark text @click="errorAlter = false">{{$t('close')}}</v-btn>
            </v-snackbar>
    </v-col>
        </v-row>
        <v-row>
          <v-col sm="1"></v-col>
          <v-col>

            <span class="title">{{$t('storeAdd')}}</span>
          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
        <v-row><v-col sm="1"></v-col>
          <v-col>
              <v-text-field
                v-model="storeName"
                :label="$t('storeName')"
              />
          </v-col>
          <v-col sm="1"></v-col>
            <v-col>
              <v-text-field
                v-model="storeAddress"
                :label="$t('storeAddress')"
              />
            </v-col><v-col sm="1"></v-col>

        </v-row>
        <v-row><v-col sm="1"></v-col>
          <v-col>
            <v-text-field
              type="number"
              v-model="storeCapacity"
              :label="$t('storeCapacity')"
            />
          </v-col>
          <v-col sm="1"></v-col>
          <v-col>
            <v-text-field
            type="number"
              v-model="storeCapacityUse"
              :label="$t('storeCapacityUse')"
              disabled
            />
          </v-col><v-col sm="1"></v-col>
        </v-row>
        <v-row>
          <v-col sm=5></v-col>
          <v-col sm="1">
            <v-btn color='success' block dark @click=getDate() class="mb-1">{{$t('add')}}</v-btn>
          </v-col>
          <v-col sm="1">
            <v-btn to="/store"  block color='success' dark >
              {{$t('return')}}
            </v-btn>
          </v-col >
          <v-col sm="5"></v-col>
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
    storeName: '',
    storeAddress: '',
    storeCapacity: 0,
    storeCapacityUse: 0,
    successAlter: false,
    errorAlter: false
  }),
  methods: {
    getDate () {
      this.successAlter = false
      this.errorAlter = false
      let storeDo = {
        storeName: this.storeName,
        storeAddress: this.storeAddress,
        storeCapacity: this.storeCapacity,
        storeCapacityUse: 0
      }
      let url = '/Store/add'
      this.$axios.put(url, storeDo).then((res) => {
        if (res.status === 200) {
          this.storeName = ''
          this.storeAddress = ''
          this.storeCapacity = 0
          this.storeCapacityUse = 0
          this.successAlter = true
        }
      }).catch((err) => {
        if (err) {
          this.errorAlter = true
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
