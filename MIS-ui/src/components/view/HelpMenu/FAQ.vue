<template>
  <div class="hello">
    <v-parallax
      height="180"
      :src="bgSrc"
    >
      <div class="carouselSpan mb-2">
        <span class="display-1" style="width: 50%">{{$t('FAQ')}}</span>
      </div>
      <div class="carouselSpan1 ma-2">
        <span class="subtitle-1" style="width: 66%">{{$t('FAQ')}}</span>
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
          <v-col sm="1"></v-col>
          <v-col sm="3">
            <template>
              <v-card
                max-width="500"
                elevation="0"
              >
<!--                <v-sheet class="pa-2 success lighten-1" elevation="0">-->
                <v-row>
                  <v-col class="pa-0 ma-0">
                  <v-text-field
                    v-model="search"
                    :label="$t('search')"
                    hide-details
                    clearable
                    class="pr-4 mr-4"
                    color="success"
                  ></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                  <v-col class="pa-0 ma-0">
                  <v-checkbox
                    v-model="caseSensitive"
                    hide-details
                    :label="$t('CaseSensitiveSearch')"
                    class="pt-0 mt-2"
                    color="success"
                  ></v-checkbox>
                  </v-col>
                </v-row>
<!--                </v-sheet>-->
                <v-card-text align="left" class="pl-0 pt-1">
                  <v-treeview
                    :items="items"
                    :search="search"
                    :filter="filter"
                    :open.sync="open"
                    activatable
                    color="success"
                  >
                    <template v-slot:append="{ item, active }" >
                      <a @click="skipTo(item)" class="viewClick">{{$t('view')}}</a>
                    </template>

                  </v-treeview>
                </v-card-text>
              </v-card>
            </template>
          </v-col>
          <v-col align="left" class="ml-2">
            <div v-for="(item, index) in items" :key="index">
              <div :id="item.id">
                <v-row>
                  <v-col class="ma-0 pa-0">
                    <p class="headline mb-1" v-html="(item.name)"></p>
                  </v-col>
                </v-row>
                <v-row v-if="item.msg">
                  <v-col class="ma-0 pa-0">
                    <p class="title mb-1 FAQMsg" v-html="(item.msg)"></p>
                  </v-col>
                </v-row>
                <div v-if="item.children.length > 0">
                  <div v-for="(childrenItem, childrenIndex) in item.children" :key="childrenIndex">
                    <div :id="childrenItem.id" >
                      <v-row >
                        <v-col class="ma-0 pa-0">
                          <p class="subtitle-1 mb-1" style="color: #1B5E20" v-html="(childrenItem.name)"></p>
                        </v-col>
                      </v-row>
                      <v-row v-if="childrenItem.msg" >
                        <v-col class="ma-0 pa-0">
                          <p class="subtitle-2 mb-1 FAQMsg" v-html="(childrenItem.msg)"></p>
                        </v-col>
                      </v-row>
                      <div v-if="childrenItem.children.length > 0">
                        <div v-for="(leafItem, leafIndex) in childrenItem.children" :key="leafIndex">
                          <div :id="leafItem.id">
                            <v-row>
                              <v-col class="ma-0 pa-0">
                                <p class="body-2 mb-1" style="text-indent:2em" v-html="(leafItem.name)"></p>
                              </v-col>
                            </v-row>
                            <v-row v-if="leafItem.msg">
                              <v-col class="ma-0 pa-0">
                                <p class="body-2 mb-1 FAQMsg" style="text-indent:2em" v-html="(leafItem.msg)"></p>
                              </v-col>
                            </v-row>
                          </div>
                        </div>
                      </div>
                      <div style="
                      height: 10px;"
                      class="mb-2 div_line"
                      ></div>
                    </div>
                </div>
              </div>
            </div>
            </div>
          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
        <to-top-button></to-top-button>
      </v-card-text>
    </v-card>
<!--    <v-parallax-->
<!--    height="120"-->
<!--    src="https://picsum.photos/id/722/1920/1080"-->
<!--  ></v-parallax>-->
  </div>
</template>

<script>
import ToTopButton from '../../public/ToTopButton'

export default {
  components: { ToTopButton },
  data: () => ({
    bgSrc: window.localStorage.getItem('bgPic'),
    items: [],
    open: [1, 2],
    search: null,
    caseSensitive: false
  }),
  methods: {
    async skipTo (item) {
      document.getElementById(item.id).scrollIntoView({
        behavior: 'smooth',
        block: 'center'
      })
    },
    test: function (id) {
      alert(id)
    },
    setItems: function () {
      this.items = [{
        id: 1,
        name: 'DUBBO',
        msg: 'dubbo常见问题解答',
        children: [
          {
            id: 101,
            name: '1.如果服务注册不上怎么办？',
            msg: '',
            children: [
              {
                id: 10101,
                name: '(1)检查dubbo的jar包有没有在classpath中，以及有没有重复的jar包'
              },
              {
                id: 10102,
                name: '(2)检查有没有重复的dubbo.properties配置文件'
              },
              {
                id: 10103,
                name: '(3)检查暴露服务的spring配置有没有加载'
              },
              {
                id: 10104,
                name: '(4)检查beanId或beanName有没有重复'
              },
              {
                id: 10105,
                name: '(5)在服务提供者机器上测试与注册中心的网络是否通'
              }
            ]
          },
          {
            id: 102,
            name: '2.出现RpcException:No provider available for remote service',
            msg: '表示没有可用的服务提供者',
            children: [
              {
                id: 10201,
                name: '(1)检查连接的注册中心是否正确'
              },
              {
                id: 10202,
                name: '(2)到注册中心查看相应的服务提供者是否存在'
              },
              {
                id: 10203,
                name: '(3)检查服务提供者是否正常运行'
              }
            ]
          },
          {
            id: 103,
            name: '3.出现org.xml.sax.SAXParseException:cvc-elt.1:Cannot find the declaration of element \'beans\'异常怎么办？',
            msg: '表示xsd加载失败',
            children: [
              {
                id: 10301,
                name: '(1)检查spring版本，如果是spring2.0版本，因为该版本不能读取jar包内xsd，会读取外网的xsd，而线上环境通常不允许访问外网\n，可修改/etc/hosts加入：(已将spring的xsd放在公司内部的maven仓库中)\n' +
                  '10.20.133.138 repo.alibaba-inc.comwww.springframework.org',
                msg: 'spring2.5.x版本不存在此问题，可以考虑升级到2.5.x版本。'
              },
              {
                id: 10302,
                name: '(2)检查有没有使用osgi的xsd，如果用了，需要将spring-osgi.jar及其依赖包加进来'
              }
            ]
          },
          {
            id: 104,
            name: '4.出现Remote server returns error:[6],Got invocation exception',
            children: [
              {
                id: 10401,
                name: '此异常表示Dubbo框架调用服务提供者的实现方法失败，并且不是方法本身的业务异常。\n' +
                  '通常是服务消费者和服务提供者的API签名不一致引起，或者提供方比消费方少此函数。\n' +
                  '一般是服务增加方法，或修改了方法签名，而双方用的服务API的jar包不一致。'
              }
            ]
          },
          {
            id: 105,
            name: '5.服务提供者没挂，但在注册中心里看不到',
            children: [
              {
                id: 10501,
                name: '首先，确认服务提供者是否连接了正确的注册中心，不只是检查配置中的注册中心地址，而且要\n' +
                  '检查实际的网络连接。\n' +
                  '其次，看服务提供者是否非常繁忙，比如压力测试，以至于没有CPU片段向注册中心发送心跳，\n' +
                  '这种情况，减小压力，将自动恢复。'
              }
            ]
          },
          {
            id: 106,
            name: '6.通过netstat-anp看到连接的注册中心和配置的不一样',
            children: [
              {
                id: 10601,
                name: '检查classpath下是否存在两个dubbo.properties文件：<br/>' +
                  'Enumeration&ltURL>urls = Thread.currentThread().getContextClassLoader().getResources("dubbo.properties");<br/>  ' +
                  'while(urls.hasMoreElements()) {<br/>  ' +
                  'URLurl=urls.nextElement();<br/>  ' +
                  'System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+url.getFile());}'
              }
            ]
          },
          {
            id: 107,
            name: '7.出现Could not deserialize parameter instance, error is:read Object:unexpected end of file',
            children: [
              {
                id: 10701,
                name: '通常是消费方或提供方的内存不足，导致buffer不能分配，使发送到一半的请求被中断了。\n' +
                  '也可能是网络抖动，导致传输流被中断。'
              }
            ]
          },
          {
            id: 108,
            name: '8.出现java.net.Socket Exception:Invalid argument:sun.nio.ch.Net.setIntOption',
            children: [
              {
                id: 10801,
                name: '通常是WindowsVista和Windows7的JDK1.6的部分版本存在BUG：<br/>' +
                  'https://issues.apache.org/jira/browse/DIRMINA-379<br/>' +
                  '可以换换JDK版本试试。'
              }
            ]
          },
          {
            id: 109,
            name: '9.出现dubbo Cannot lock the registry cache file',
            msg: '当本地同时启动服务端和客户端的时候就可能产生这个问题。',
            children: [
              {
                id: 10901,
                name: 'Dubbo通过注册中心发现服务，发现的服务Dubbo同时也会保存到本地缓存一份，缓存的好处\n' +
                  '有很多，比如不需要每次使用的时候都通过注册中心获取，注册中心不可用了，不影响消费端的\n' +
                  '调用，因为本地缓存了一份服务提供者列表。Dubbo本地缓存默认采用的文件，会根据注册中\n' +
                  '心自动在当前用户目录下生成一个缓存文件，类似\n' +
                  '/home/newad/.dubbo/dubbo-registry-*.*.*.*.cache，星号表示注册中心的IP地址，当同一台机\n' +
                  '器上同时启动多个进程，就会出现多个进程争夺此文件的写入权限，觖此问题的方法也很简单，\n' +
                  '日志里面都说了重新配置一下这个缓存文件就。\n' +
                  '主要在启动脚本里面添加配置：\n' +
                  '-Ddubbo.registry.file=C:\\Users\\dell.dubbo\\dubbo-registry-192.168.1.62-junit.cache文件名自\n' +
                  '己配置一个\n' +
                  '-Ddubbo.registry.file=C:\\Users\\dell.dubbo\\dubbo-registry-192.168.1.62-junit.cache'
              }
            ]
          },
          {
            id: 110,
            name: '10.Web容器重启后，dubbo服务端口依然占用',
            msg: 'Dubbo是通过JDK的ShutdownHook来完成优雅停机的，所以如果用户使用"kill-9PID"等强制\n' +
              '关闭指令，是不会执行优雅停机的，只有通过"killPID"时，才会执行。',
            children: [
              {
                id: 11001,
                name: '对于webapp，需要在web.xml配置监听。\n' +
                  '&ltlistener>&ltlistener-class>com.listeners.MyContextListener&lt/listener-class>&lt/listener>\n' +
                  '在javax.servlet.ServletContextListener实现类的contextDestroyed函数里面调\n' +
                  '用ProtocolConfig.destroyAll()。'
              }
            ]
          },
          {
            id: 111,
            name: '11.注册到zookeeper上的dubbo服务IP地址不是dubbo服务所在主机地址',
            msg: '原因是：提供dubbo服务的主机hostname配置有误。',
            children: [
              {
                id: 11101,
                name: '在注册dubbo服务到zookeeper时，如不指定IP地址，则dubbo默认使用本机地址（hostname\n' +
                  '对应的地址）。如需要配置IP地址，则可通过dubbo.protocol.host来指定。'
              }
            ]
          },
          {
            id: 112,
            name: '12.出现\n' +
              'org.springframework.beans.factory.BeanCreationExcepti\n' +
              'on:Error creating bean with name \'xxxService\' :\n' +
              'Initialization of bean failed; nested exception is java.lang.IllegalArgumentException:Method must not be null',
            children: [
              {
                id: 11201,
                name: '通常是classpath下存在spring多个版本的jar包，排除掉不需要的spring包即可。'
              }
            ]
          }
        ]
      }]
    }
  },
  computed: {
    area () {
      return this.$i18n.locale
    },
    filter () {
      return this.caseSensitive
        ? (item, search, textKey) => item[textKey].indexOf(search) > -1
        : undefined
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
    this.setItems()
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
  .viewClick {
    text-decoration:none;
    display: block;
    opacity: 0.3;
  }
  .viewClick:hover{
    opacity: 1;
  }
  .FAQMsg {
    color: #757575;
  }
</style>

<style>
  .v-treeview-node__root {
    height: 30px!important;
    min-height: 18px!important;
    padding-left: 0!important;
  }
</style>
