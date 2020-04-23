import Vue from 'vue'
import 'api/resource'
import App from 'pages/App.vue'
import { connect } from './util/ws'
import 'vuetify/dist/vuetify.min.css'
import Vuetify from 'vuetify'

if (frontendData.profile) {
    connect()
}

Vue.use(Vuetify, { iconfont: 'mdiSvg' })

new Vue({
    el: '#app',
    render: a => a(App),
    vuetify: new Vuetify({}),

})
