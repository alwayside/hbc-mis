import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/view/HelloWorld'
import purchase from '../components/view/purchase'
import purchaseView from '../components/view/purchase/purchaseView'
import DevelopDoc from '../components/view/DevelopDoc'
import BuildOnline from '../components/view/BuildOnline'
import DownloadCenter from '../components/view/DownloadCenter'
import Help from '../components/view/HelpMenu/Help'
import Question from '../components/view/HelpMenu/FAQ'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/purchase',
      name: 'purchase',
      component: purchase
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/purchase/records',
      name: 'purchaseView',
      component: purchaseView
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/DevelopDoc',
      name: 'DevelopDoc',
      component: DevelopDoc,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/BuildOnline',
      name: 'BuildOnline',
      component: BuildOnline,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/DownloadCenter',
      name: 'DownloadCenter',
      component: DownloadCenter,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/Help',
      name: 'Help',
      component: Help
    },
    {
      path: '/FAQ',
      name: 'Question',
      component: Question
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    next()
  } else {
    let token = localStorage.getItem('Authorization')
    if (token === 'null' || token === '') {
      next('/login')
    } else {
      next()
    }
  }
})

export default router
