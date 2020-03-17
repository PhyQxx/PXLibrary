import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: () => import('@/view/Index'),
      children:[
        {
          name: 'homepage',
          path: 'homepage',
          component: () => import('@/components/Homepage')
        },
        {
          name: 'forum',
          path: 'forum',
          component: () => import('@/components/Forum')
        },
        {
          name: 'blog',
          path: 'blog',
          component: () => import('@/components/Blog')
        },
        {
          name: 'data',
          path: 'data',
          component: () => import('@/components/Data')
        },
        ]
    }
  ]
})
