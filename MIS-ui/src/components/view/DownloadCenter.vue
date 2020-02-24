<template>
  <div>
    <v-parallax
      height="180"
      :src="bgSrc"
    >
      <div class="carouselSpan mb-2">
        <span class="display-1" style="width: 50%">{{$t('developTool')}}</span>
      </div>
      <div class="carouselSpan1 ma-2">
        <span class="subtitle-1" style="width: 66%">{{$t('developToolMsg')}}</span>
      </div>
    </v-parallax>
    <v-card elevation="0">
      <v-card-title></v-card-title>
      <v-card-text>
        <v-row>
          <v-col sm="2"></v-col>
          <v-col align="left">
            <div v-for="(item,index) in downloadItem" :key="index">
              <v-row class="pa-0 ma-0">
                <v-col class="pa-0 ma-0 title">
                  <p class="pa-0 ma-0" v-html='$t(item.title)'></p>
                </v-col>
              </v-row>
              <v-row>
                <v-col>
                  <p class="pa-0 ma-0" v-html='$t(item.article)'></p></v-col>
              </v-row>
              <v-row>
                <v-col>
<!--                      <a :href="item.monitoring" target="_blank">{{$t('monitoring')}}</a>-->
                  <a :href="item.href" target="_blank" download>{{$t('download')}}</a>
                  <span class="mr-2 ml-2"></span>
                  <a :href="item.document" target="_blank">{{$t('deployDocument')}}</a>
                  <span class="mr-2 ml-2"></span>
                  <a v-if="item.try" :href="item.try" target="_blank">{{$t('tryIt')}}</a>
                  <v-divider v-if="(index + 1) < downloadItem.length"
                             class="mt-4"
                             light
                  ></v-divider>
                </v-col>
              </v-row>
            </div>
            </v-col>
          <v-col sm="1"></v-col>
        </v-row>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
// import res from '@/res/resource.json'

export default {
  name: 'DownloadCenter',
  data: () => ({
    bgSrc: window.localStorage.getItem('bgPic'),
    name: '',
    downloadItem: [
      {
        title: 'downloadCenterMsg.ZDubboAdmin.title',
        article: 'downloadCenterMsg.ZDubboAdmin.article',
        href: 'http://10.45.4.162:4000/attach/zdubbo-admin-server.jar',
        document: 'http://10.45.4.162:4000/doc/ZDubboAdmin/01_installation_instructions.html',
        try: 'http://172.16.17.20:8080/#/'
      },
      {
        title: 'downloadCenterMsg.ZKTool.title',
        article: 'downloadCenterMsg.ZKTool.article',
        href: '',
        document: 'http://10.45.4.162:4000/doc/ZKTool/01_installation_instructions.html'
      },
      {
        title: 'downloadCenterMsg.Zookeeper.title',
        article: 'downloadCenterMsg.Zookeeper.article',
        href: '',
        document: 'http://10.45.4.162:4000/doc/Zookeeper/01_installation_instructions.html'
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
  mounted: function () {
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
