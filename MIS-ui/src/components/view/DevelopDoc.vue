<template>
  <div>

<!--    head-->
    <v-carousel
      hide-delimiter-background
      cycle
      height="180px"
      show-arrows-on-hover
      hide-delimiters
    >
      <v-carousel-item
        v-for="(item, index) in tagItem"
        :key="index"
      >
        <v-sheet
          color="transparent"
          height="100%"
          tile
        >
          <v-parallax
            height="180"
            style="background: no-repeat center center!important;"
            :src=item.src
          ><v-row>
            <v-col sm="4" class="d-flex align-center">
              <div class="carouselSpan mx-4">
                <span class="title" style="width: 40%;text-align: left">{{item.msg}}</span>
              </div>
            </v-col>
            <v-col class="d-flex align-center justify-center">
            <div class="carouselSpan mx-4">
              <span class="display-1" style="width: 100%">{{item.name}}</span>
            </div>
            <div class="carouselSpan1 mx-4">
              <span class="subtitle-1" style="width: 100%"><v-btn class="innerBtn" @click.native="skipTo(item.tag)">{{$t('view')}}</v-btn></span>
            </div>
            </v-col>
            <v-col sm="2" class="d-flex align-center justify-start">
            </v-col>
            </v-row>
          </v-parallax>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
<!--    menu-->
    <v-row class="pa-0 ma-0">
      <v-col class="pa-0 ma-0 d-flex justify-center devMenuBtnCol" :style="{'position': menuPosition,'top':menuPositionTop}">
        <div style="text-align: left;" class="d-flex justify-center align-center">
          <v-btn
            v-for="(item, index) in menuItem"
            :key="index"
            tile
            class="devDocMenuBtn d-flex flex-column"
            elevation="0"
            @click.native="menuItemOn(item.name)"
            :color="menuBtnColor(item.name)"
          >
            <v-row>
              <v-col>
              <v-row><v-col><v-icon :color="menuBtnIconColor(item.name)" large>mdi-leaf</v-icon></v-col></v-row>
                <v-row><v-col class="ma-0 pa-0"><strong :style="{'color':menuBtnIconColor(item.name)}">{{item.name}}</strong></v-col></v-row>
            </v-col>
            </v-row>
          </v-btn>
        </div>
      </v-col>
    </v-row>
      <div style="height: 90px"></div>
<!--    content-->
    <v-row>
      <v-col sm="2"></v-col>
      <v-col class="pa-0 ma-0">
        <div v-for="(item, index) in tagItem" :key="index">
        <v-card elevation="0" class="ml-0 mr-0 pa-0 mb-10 mt-10" :id="item.tag" style="background: transparent!important">
          <v-card-title class="d-flex justify-center pa-0 mb-1">{{item.name}}</v-card-title>
          <v-card-text class="d-flex flex-wrap justify-space-between justify-center  pa-0 ma-0">
            <div
              v-for="(items, index) in menuItem"
              :key="index"
              v-if="item.tag === items.tag"
              class="mb-4 ml-1 mr-1 sheetDiv"
              :style="{'width':setSheetWidth(item.tag, items.name)}"
            >
            <v-sheet class="ml-0 mr-0 devSheet mt-4 d-flex flex-column " :id="items.name" >
              <div style="height: 60px">
              <v-row>
                <v-col class="d-flex justify-left ml-10 title" style="color: rgb(76,175,80);height: 60px">{{items.name}}</v-col>
              </v-row>
              </div>
              <v-row>
                <v-col sm="1" class="pt-0 pb-0"></v-col>
                <v-col class="pt-0 pb-0"><p class="subtitle-2 mb-1 devDocMsg " v-html="(items.msg.article)"></p></v-col>
                <v-col class="pt-0 pb-0" sm="1"></v-col>
              </v-row>
              <v-row v-if="items.btnItems">
                <v-col class="d-flex justify-end align-end">
                  <div v-for="(btnItem, index) in items.btnItems" :key="index">
                    <v-btn outlined color="success" tile style="font-size: 12px" :href="btnItem.href" target="_blank"><strong>{{btnItem.name}}</strong></v-btn>
                    <span class="mr-5"></span>
                  </div>
                </v-col>
              </v-row>
            </v-sheet>
            </div>
          </v-card-text>
        </v-card>
          <div style="height: 20px" class="blankDiv"></div>
        </div>
      </v-col>
      <v-col sm="2"></v-col>
    </v-row>
    <div class="ma-10 blankDiv" ></div>
    <to-top-button></to-top-button>
  </div>
</template>

<script>
import ToTopButton from '../public/ToTopButton'

export default {
  name: 'DevelopDoc',
  components: {
    ToTopButton
  },
  data: () => ({
    bgSrc: window.localStorage.getItem('bgPic'),
    menuItem: [],
    menuPosition: '',
    menuPositionTop: '',
    ItemOn: '',
    tagItem: ' ',
    ZDubboMsg: [
      {
        title: 'DevelopDocMsg.core.msg1.title',
        article: 'DevelopDocMsg.core.msg1.article',
        icon: 'mdi-cast-connected'
      },
      {
        title: 'DevelopDocMsg.core.msg2.title',
        article: 'DevelopDocMsg.core.msg2.article',
        icon: 'mdi-server'
      },
      {
        title: 'DevelopDocMsg.core.msg3.title',
        article: 'DevelopDocMsg.core.msg3.article',
        icon: 'search'
      }
    ]
  }),
  methods: {
    setMenuPosition: function () {
      this.menuPosition = 'absolute'
      this.menuPositionTop = '180px'
    },
    setSheetWidth: function (tag, name) {
      let count = 0
      let lastEnum = ''
      for (let i in this.menuItem) {
        if (this.menuItem[i].tag === tag) {
          lastEnum = this.menuItem[i].name
          count = count + 1
        }
      }
      if ((count % 2 !== 0) && (lastEnum === name)) {
        return '100%'
      }
      return '49%'
    },
    async skipTo (item) {
      document.getElementById(item).scrollIntoView({
        behavior: 'smooth',
        block: 'center'
      })
    },
    menuItemOn: function (item) {
      this.ItemOn = item.toString()
      this.skipTo(item)
    },
    menuBtnColor: function (item) {
      // if (item === this.ItemOn) {
      //   return '#33691E'
      // }
      // return '#4caf50'
      if (item === this.ItemOn) {
        return '#4caf50'
      }
      return '#ffffff'
    },
    menuBtnIconColor: function (item) {
      if (item === this.ItemOn) {
        return '#ffffff'
      }
      return '#4caf50'
    },
    handleScroll: function () {
      if (document.documentElement.scrollTop > 180) {
        this.menuPosition = 'fixed'
        this.menuPositionTop = '60px'
      } else {
        this.menuPosition = 'absolute'
        this.menuPositionTop = '180px'
      }
    },
    setTagItem: function () {
      this.tagItem = [
        {
          name: '基础框架',
          tag: '01',
          msg: 'Core License',
          src: require('./assets/WSFlogo.jpg')
        },
        {
          name: '分布式服务框架',
          tag: '02',
          msg: 'ZDUBBO',
          src: require('./assets/WSFlogo.jpg')
        },
        {
          name: '分布式调度框架',
          tag: '03',
          msg: 'JobServer',
          src: require('./assets/WSFlogo.jpg')
        },
        {
          name: '文档管理系统',
          tag: '04',
          msg: 'DMS',
          src: require('./assets/WSFlogo.jpg')
        },
        {
          name: '通信网关',
          tag: '05',
          msg: 'CG  UIP/BP',
          src: require('./assets/WSFlogo.jpg')
        },
        {
          name: '分布式链路追踪系统',
          tag: '06',
          msg: 'iTracing | iTuning | iLog',
          src: require('./assets/WSFlogo.jpg')
        }

      ]
    },
    setMenuItem: function () {
      this.menuItem = [
        {
          name: 'CORE',
          icon: 'mdi-leaf-maple',
          tag: '01',
          msg: {
            article: '后端框架Core产品是基于SSM（Spring SpringMVC MyBatis） 研发的新一代框架，采用了Spring Boot等主流轻量级技术，极大地减少了编码、测试、配置等工作量，能够让业务聚焦于自身业务领域即可快速完成应用开发。'
          },
          btnItems: [
            {
              name: '开发指南',
              href: 'http://gitlab.iwhalecloud.com/platform/doc/blob/master/00-Docs/R9%E6%8A%80%E6%9C%AF%E6%A1%86%E6%9E%B6-v0.4.docx'
            }
          ]
        },
        {
          name: 'License',
          icon: 'mdi-leaf-maple',
          tag: '01',
          msg: {
            article: 'License即“许可证”或“授权”，是供应商对客户所销售/购买的产品使用范围、功能、期限等进行授权/被授权的一种合约形式，客户通过License可获得供应商所承诺的相应服务，License在物理形式上表现为License授权证书以及License文件。FTF9的License特性，实现了产品在业务功能上和数量上的按需定制。市场销售时，按客户定制的功能和容量需求对设备进行差异化的报价，增强产品的市场竞争力。<br/>  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  业务中心只需通过引入License client的SDK包，调用license服务，便可实现精确的授权限制。'
          },
          btnItems: [
            {
              name: '开发指南',
              href: 'http://10.45.4.162:4000/attach/License.docx'
            }
          ]
        },
        {
          name: 'ZDubbo',
          icon: 'mdi-leaf-maple',
          tag: '02',
          msg: {
            article: 'Dubbo是一个分布式服务框架，致力于提供高性能和透明化的RPC远程服务调用方案，以及SOA服务治理方案。<br/><br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp简单的说，dubbo就是个服务框架，如果没有分布式的需求，其实是不需要用的，只有在分布式的时候，才有dubbo这样的分布式服务框架的需求，并且本质上是个服务调用的框架，说白了就是个远程服务调用的分布式框架（告别Web Service模式中的WSdl，以服务者与消费者的方式在dubbo上注册）。',
            items: this.ZDubboMsg
          },
          btnItems: [
            {
              name: '开发指南',
              href: 'http://10.45.4.162:4000/doc/'
            }
          ]
        },
        {
          name: 'JobServer',
          icon: 'mdi-leaf-maple',
          tag: '03',
          msg: {
            article: 'Job Server是对所有的轮询任务进行管理，把需要轮询的任务从每个分散的节点集合到一个完整的容器里去。独立运行，不影响到主应用，功能完整的日程任务调度系统'
          },
          btnItems: [
            {
              name: '开发指南',
              href: 'http://10.45.4.162:4000/attach/Jobserver_dev.docx'
            }
          ]
        },
        {
          name: 'DMS',
          tag: '04',
          icon: 'mdi-leaf-maple',
          msg: {
            article: 'DMS（Document Management System）是一个涵盖了文档设计、生成、存储、查询、使用和销毁全生命周期的文档管理系统。作为一个内容存储和管理平台，它底层提供分布式存储和检索的能力，主要应用于无纸化办公和电子账单'
          },
          btnItems: [
            {
              name: '开发指南',
              href: 'http://10.45.4.162:4000/attach/DMS_HELP.docx'
            },
            {
              name: '培训手册',
              href: 'http://10.45.4.162:4000/attach/DMS_TRAINING.pptx'
            },
            {
              name: 'API文档',
              href: 'http://10.45.4.162:4000/attach/DMS_API.doc'
            }
          ]
        },
        {
          name: 'CG',
          tag: '05',
          msg: {
            article: 'CG 是 Communication Gateway 的简称。CG提供了与第三方应用、网元之间基于多种协议集成的能力，在提供传统的通讯能力之外，CG还支持基于Dubbo、Spring Cloud、MQ的微服务集成方式。CG支持在 PaaS 平台以容器方式部署，具备横向动态伸缩的能力。'
          },
          btnItems: [
            {
              name: '开发指南',
              href: 'http://10.45.4.162:4000/attach/CG_paper.docx'
            }
          ]
        },
        {
          name: 'UIP/BP',
          tag: '05',
          msg: {
            article: 'UIP 的基础是一个通讯框架，而这个通讯框架又是以适配器为单位组成的。当前支持的适配器的类型有：ACCEPTOR，CONNECTOR，ServerRouter，ClientRouter，Job。<br/>' +
              '<br/>' +
              ' &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 适配器基于管道实现：适配器处理的原始对象是连接、消息，UIP 把连接、消息的状态变化定义为事件，比如，受理一个客户端连接、连接断开、收到一个客户端消息、发送一个客户端消息等等事件；而管道就是适配器中处理这些连接事件、消息事件的一系列处理器的链表。'
          },
          btnItems: [
            {
              name: '开发指南',
              href: 'http://10.45.4.162:4000/attach/UIP_TRAINING.pptx'
            }
          ]
        },
        {
          name: 'iTracing',
          tag: '06',
          msg: {
            article: ''
          },
          btnItems: [
            {
              name: '开发指南',
              href: 'http://itracing.zcm9.svc.ts.zsmart.com/02_composition/composition.html'
            }
          ]
        },
        {
          name: 'iTuning',
          tag: '06',
          msg: {
            article: ''
          }
        },
        {
          name: 'iLog',
          tag: '06',
          msg: {
            article: ''
          },
          btnItems: [
            {
              name: '开发指南',
              href: 'http://itracing.zcm9.svc.ts.zsmart.com/15_log/'
            }
          ]
        }
      ]
    }
  },
  watch: {
    ItemOn () {
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
    window.addEventListener('scroll', this.handleScroll)
  },
  mounted: function () {
    this.setMenuItem()
    this.setTagItem()
    this.setMenuPosition()
  }
}
</script>

<style>
  .developDevItemDiv {
    border: 1px solid #bdbdbd;
  }
  .test2 {
    z-index: 3;
    background: transparent;
    position: relative;
  }
  .test{
    height: 100%;
    z-index: 1;
    width: 600px;
    position:absolute;
  }
  .devDocMenuBtn {
    text-transform: none!important;
    height:90px!important;
    min-width: 90px!important;
  }
  .devDocMenuBtn:hover {
    box-shadow: 0 3px 5px -1px rgba(76,175,80,0.7),0 5px 8px 0 rgba(76,175,80,0.7),0 1px 14px 0 rgba(76,175,80,0.7)!important;
    z-index: 20;
  }
  .devDocMsg{
    text-indent:2em!important;
    text-align: left;
  }
  .devSheet{
    border: rgba(112,128,144,0.3)!important;
    border-radius: 5px!important;
    box-shadow: 0px 0px 1px 1px rgba(0,0,0,.2)!important;
    transition-duration:0.28s!important;
    height: 100%!important;
  }
  .devSheet:hover{
    box-shadow: 0 3px 5px -1px rgba(76,175,80,0.7),0 5px 8px 0 rgba(76,175,80,0.7),0 1px 14px 0 rgba(76,175,80,0.7)!important;
    z-index: 3!important;
    position: relative;
    transition-duration: 0.5s!important;
  }
  .devMenuBtnCol{
    /*background-color: #4caf50!important;*/
    background: #ffffff!important;
    z-index: 4!important;
    box-shadow: 0 1px 1px 1px rgba(76,175,80,0.7)!important;
  }
  .sheetDiv {
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
