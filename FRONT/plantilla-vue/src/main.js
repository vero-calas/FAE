require("./style.scss");
import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';
import VueChart from 'vue-chart-js'
import VueMaterial from 'vue-material';
Vue.use(VueChart)
Vue.use(VueMaterial);
Vue.use(VueRouter);
Vue.use(VueResource);
import VueCarousel from 'vue-carousel';
Vue.use(VueCarousel);
import App from './App.vue';
import trofeos from './trofeos.vue';
import firebase from 'firebase';
Vue.http.options.emulateJSON = true
var config = {
    apiKey: "AIzaSyAL0ZO7C_dy6slW-pB5CwdrBDkedoS56jA",
    authDomain: "ematur-acea1.firebaseapp.com",
    databaseURL: "https://ematur-acea1.firebaseio.com",
    projectId: "ematur-acea1",
    storageBucket: "ematur-acea1.appspot.com",
    messagingSenderId: "290818540480"
};
firebase.initializeApp(config);


const routes = [
    { path: '/trofeos', component: trofeos}
]

// Create the router instance and pass the `routes` option
const router = new VueRouter({
  routes
})

new Vue({
  el: '#app',
  router,
  render: h => h(App)

})


