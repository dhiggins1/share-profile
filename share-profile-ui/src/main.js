// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import axios from 'axios'
import router from './router'
import jQuery from 'jquery'
import 'vue-material/dist/vue-material.min.css'
import VueAxios from 'vue-axios'
import VueMaterial from 'vue-material'
import Registration from '@/components/Registration.vue'

Vue.config.productionTip = false

window.jQuery = jQuery
window.$ = jQuery

Vue.use(VueMaterial)
Vue.use(VueAxios, axios)
Vue.component('registration', Registration)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
