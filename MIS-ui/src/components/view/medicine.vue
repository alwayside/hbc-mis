<template>
  <div class="hello" style="">
    <v-parallax
      height="180"
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
          <v-col sm="2"></v-col>
          <v-col>
            <v-col>
              <v-btn to="/medicine/records"  class="innerBtn mb-2 mt-4">
                {{$t('medicineRecord')}}
              </v-btn>
            </v-col >
          </v-col >
          <v-col class="d-flex align-center justify-center">
            <div>
              <v-btn to="/purchase/medicine"  class="innerBtn mb-2 mt-4">
                {{$t('medicinePurchase')}}
              </v-btn>
            </div>
          </v-col>
          <v-col sm="2"></v-col>
        </v-row>
        <v-row>
          <v-col sm="2"></v-col>
          <v-col>
            <v-col>
              <v-btn to="/medicine/add"  class="innerBtn mb-2 mt-4">
                {{$t('medicineAdd')}}
              </v-btn>
            </v-col >
          </v-col >
          <v-col class="d-flex align-center justify-center">
            <div>
              <v-btn to="/sell/medicine"  class="innerBtn mb-2 mt-4">
                {{$t('medicineSell')}}
              </v-btn>
            </div>
          </v-col>
          <v-col sm="2"></v-col>
        </v-row>
         <v-row>
          <v-col sm="2"></v-col>
          <v-col class="d-flex align-center justify-center">
            <div>
              <v-btn to="/medicine/manage"  class="innerBtn mb-2 mt-4">
                {{$t('medicineManage')}}
              </v-btn>
            </div>
          </v-col>
          <v-col sm="2"></v-col>
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
    msg: 'Welcome to Your Vue.js App'
  }),
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
