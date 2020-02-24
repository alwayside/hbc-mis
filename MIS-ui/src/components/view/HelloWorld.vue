<template>
  <div>
    <v-carousel
      hide-delimiter-background
      cycle
      height="700"
      :show-arrows="false"
      hide-delimiters
    >
      <v-carousel-item
        v-for="(item, index) in CarouselsItem"
        :key="index"
      >
        <v-sheet
          :color="item.color"
          height="100%  "
          tile
        >
          <v-parallax
            height="700"
          >

            <div class="carouselSpan mb-2" >
              <span class="display-2" style="width: 50%">{{$t(item.msg.title)}}</span>
            </div>
            <div class="carouselSpan1 ma-2" >
              <span class="title" style="width: 67%;text-align: left;text-indent:2em">{{$t(item.msg.article)}}</span>
            </div>
            <div style="height: 100px"></div>
            <div v-if="'' !== item.btn" class="carouselSpan2">
              <span>
                <v-btn :href="item.btn" target="_blank"  class="innerBtn loginBtn mb-2 mt-4">
                  {{$t('Login')}}
                </v-btn>
              </span>
            </div>
            <div id="particlesjs" style="position: absolute;width: 100%;height: 600px;z-index: -1">
            </div>
          </v-parallax>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
  </div>
</template>

<script>
// eslint-disable-next-line no-unused-vars
import particles from 'particles.js'

export default {
  name: 'HomePage',
  data: () => ({
    CarouselsItem: [
      {
        color: '#4caf50',
        msg: {
          title: 'HBCMISTitle',
          article: 'HBCMISArticle'
        },
        img: '',
        src: 'https://picsum.photos/1920/1080?random',
        btn: 'http://10.45.4.162:8585/'
      }
    ],
    srcUrl: '',
    introduceModelItem: [
      {
        name: 'name',
        items: []
      },
      {
        name: 'name',
        items: []
      }
    ]
  }),
  methods: {
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
        '#4caf50',
        'transparent'
      ])
  },
  mounted: function () {
    // eslint-disable-next-line no-undef
    particlesJS.load('particlesjs', 'static/particles.json', function () {
      console.log('particles.js loaded - callback')
    })
  }
}
</script>

<style>
  .loginBtn :hover{
    border-width:10px!important;
    transition-duration: 0.28s;
  }
</style>
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
