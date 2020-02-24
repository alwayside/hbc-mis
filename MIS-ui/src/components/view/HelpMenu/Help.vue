<template>
  <div>
    <v-parallax
      height="180"
      :src="bgSrc"
    >
      <div class="carouselSpan mb-2">
      <span class="display-1" style="width: 50%">{{$t('help')}}</span>
    </div>
      <div class="carouselSpan1 ma-2">
        <span class="subtitle-1" style="width: 66%">{{$t('help')}} & {{$t('support')}}</span>
      </div>
    </v-parallax>
    <v-card elevation="0">
<!--      <v-card-title>-->
<!--        <v-col sm="2"></v-col>-->
<!--        <v-col align="left" class="title pa-0" >-->
<!--          <span>-->
<!--            <p class="ma-0" v-html="$t('buildOnlineMsg.title')"></p>-->
<!--          </span>-->
<!--        </v-col>-->
<!--        <v-col sm="2"></v-col>-->
<!--      </v-card-title>-->
      <v-card-text>
        <v-row>
          <v-col sm="2"></v-col>
          <v-col>
            <v-row class="pa-0 ma-0">
              <v-col class="pa-0 ma-0 title" align="left">
                <span>
                  <p class="ma-4 pt-4">平台技术产品部</p>
                </span>
              </v-col>
            </v-row>
            <v-row>
              <v-col align="left">
                <span>
                  <p class="ma-0">微服务平台团队——JAVA后端框架团队——ZDubbo</p>
                </span>
              </v-col>
            </v-row>
            <div v-for="(item, index) in supportGroup" :key="index" align="left">
            <v-row>
              <v-col>
                <v-row>
                  <v-col class="ml-4 pa-1 d-flex align-center"><v-icon>mdi-account</v-icon>
                    {{item.name}}
                  </v-col>
                  <v-col class="ml-4 pa-1 d-flex align-center">
                    <img src="./assets/dingding.png" width="24"><span class="mr-2"></span>
                    {{item.dingding}}
                  </v-col>
                </v-row>
                <v-row>
                  <v-col class="ml-4 pa-1 d-flex align-center">
                  <v-icon>mdi-book</v-icon>
                  {{item.number}}
                </v-col>
                  <v-col class="ml-4 pa-1 d-flex align-center">
                    <v-icon>email</v-icon>
                    {{item.email}}
                  </v-col>
                </v-row>
                <v-row>
                  <v-col class="ma-0 pa-1">
                  <div class="div_line" style="height:2px"></div>
                    </v-col>
                </v-row>
              </v-col>
            </v-row>
            </div>
          </v-col >
          <v-col class="d-flex align-center justify-center ma-0 pa-0">
            <div>
              <img src="./assets/help_QRcode.jpg" width="414">
            </div>
          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
      </v-card-text>
    </v-card>
<!--    <v-parallax-->
<!--    height="120"-->
<!--    src="https://picsum.photos/id/722/1920/1080"-->
<!--  ></v-parallax>-->
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data: () => ({
    bgSrc: window.localStorage.getItem('bgPic'),
    msg: 'Welcome to Your Vue.js App',
    supportGroup: []
  }),
  methods: {
    setSupportGroup: function () {
      this.supportGroup = [
        {
          name: '何磊',
          dingding: 'ZDubbo-何磊',
          number: '0027006717',
          email: 'he.lei45@iwhalecloud.com'
        },
        {
          name: '刘林',
          dingding: '刘林',
          number: '0027008133',
          email: 'liu.lin@iwhalecloud.com'
        },
        {
          name: '丁付明',
          dingding: '丁付明',
          number: '0027011319',
          email: 'ding.fuming111@iwhalecloud.com'
        },
        {
          name: '黄鑫',
          dingding: '黄鑫',
          number: '00270013825',
          email: 'huang.xin12@iwhalecloud.com'
        }
      ]
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
        'transparent',
        'transparent',
        '#4caf50'
      ])
  },
  mounted: function () {
    this.setSupportGroup()
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
