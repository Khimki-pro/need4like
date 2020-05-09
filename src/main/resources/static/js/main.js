import Vue from 'vue'
import '@babel/polyfill'
import 'api/resource'
import router from 'router/router'
import App from 'pages/App.vue'
import store from './store/store'
import { connect } from './util/ws'
import 'vuetify/dist/vuetify.min.css'
import Vuetify from 'vuetify'

if (profile) {
    connect()
}

Vue.use(Vuetify, { iconfont: 'mdiSvg' })

new Vue({
    el: '#app',
    store,
    router,
    render: a => a(App),
    vuetify: new Vuetify({}),

})
