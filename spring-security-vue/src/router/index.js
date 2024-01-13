import { createRouter, createWebHistory } from 'vue-router'
import {getToken} from "../api/token";

const routes = [
    {
      path: '/logout',
        component: () => import('../components/logout.vue')
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('../view/login.vue')
    },
    {
        path: '/',
        redirect:'/main'
    },
    {
        path: '/main',
        name: 'main',
        component: () => import('../view/index.vue'),
        meta: {title: '对话', icon: 'ChatDotRound'},
        children:[
            {
                path: '',
                redirect: '/main/home',
            },
            {
                path: 'home',
                meta: {title: '对话', icon: 'ChatDotRound'},
                // redirect: '/main'
                component: () => import('../components/chat/chatIndex.vue')
            },
            {
                path: 'task',
                meta: {title: '任务', icon: 'List'},
                component: () => import('../components/task/taskIndex.vue')
            },
            {
                path: 'money',
                meta: {title: '钱包', icon: 'Money'},
                component: () => import('../components/money/moneyIndex.vue')
            },
            {
                 path: 'feedback',
                meta: {title: '反馈', icon: 'Money'},
                 component: () => import('../components/feedback/feedbackIndex.vue')
            },
            {
                path: 'infoIndex',
                meta: {title: '消息', icon: 'Money'},
                component: () => import('../components/information/infoIndex.vue')
            },
            {
                path: 'info',
                component: () => import('../view/info.vue')
            },
        ]
    },

  ]


const router = createRouter({
    history:createWebHistory(),
    routes
})

router.beforeEach((to,from,next)=>{
  // 获取用户身份
  let token = getToken()
  if( token || to.path === '/login'){
    next()
  }
  next('/login')
})

export default router
