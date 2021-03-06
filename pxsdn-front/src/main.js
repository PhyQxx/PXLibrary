// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/css/public.css'
// 引用API文件
import api from './api/index.js'
// 将API方法绑定到全局

import marked from 'marked'
import scroll from 'vue-scroll'
import hljs from '../static/js/highlight.min'
import range from '../static/js/rangeFn.js'
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(scroll)
Vue.prototype.$ajax = api
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
