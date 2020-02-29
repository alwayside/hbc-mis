import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/view/HelloWorld'
import purchase from '../components/view/purchase'
import purchaseView from '../components/view/purchase/purchaseView'
import purchasMedicine from '../components/view/purchase/purchaseMedicine'
import Medicine from '../components/view/medicine'
import medicineView from '../components/view/medicine/medicineView'
import medicineAdd from '../components/view/medicine/medicineAdd'
import medicineManage from '../components/view/medicine/medicineManage'
import Store from '../components/view/store'
import storeView from '../components/view/store/storeView'
import storeAdd from '../components/view/store/storeAdd'
import storeManage from '../components/view/store/storeManage'
import storeRemain from '../components/view/store/storeRemain'

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
      path: '/purchase/medicine',
      name: 'purchasMedicine',
      component: purchasMedicine
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/medicine',
      name: 'medicine',
      component: Medicine
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/medicine/records',
      name: 'medicineView',
      component: medicineView
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/medicine/add',
      name: 'medicineAdd',
      component: medicineAdd
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/medicine/manage',
      name: 'medicineManage',
      component: medicineManage
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/store',
      name: 'Store',
      component: Store
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/store/records',
      name: 'storeView',
      component: storeView
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/store/add',
      name: 'storeAdd',
      component: storeAdd
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/store/manage',
      name: 'storeManage',
      component: storeManage
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/store/remain',
      name: 'storeRemain',
      component: storeRemain
      // meta: {
      //   requiresAuth: true
      // }
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
