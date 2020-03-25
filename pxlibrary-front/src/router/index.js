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
          path: '/',
          component: () => import('@/components/Homepage')
        },
        {
          name: 'content',
          path: 'content',
          component: () => import('@/components/blog/Content')
        },
        {
          name: 'forum',
          path: 'forum',
          component: () => import('@/components/Forum'),
          children:[
            {
              name: 'forumhomepage',
              path: 'forumhomepage',
              component: () => import('@/components/forum/ForumHomepage'),
            },
            {
              name: 'forumselectplate',
              path: 'forumselectplate',
              component: () => import('@/components/forum/ForumSelectPlate'),
            },
            {
              name: 'forumranking',
              path: 'forumranking',
              component: () => import('@/components/forum/ForumRanking'),
            },
            {
              name: 'forumhelp',
              path: 'forumhelp',
              component: () => import('@/components/forum/ForumHelp'),
            },
            {
              name: 'posting',
              path: 'posting',
              component: () => import('@/components/forum/Posting'),
            },
          ]
        },
        {
          name: 'blog',
          path: 'blog',
          component: () => import('@/components/Blog')
        },
        {
          name: 'download',
          path: 'download',
          component: () => import('@/components/Download')
        },
        ]
    }
  ]
})
