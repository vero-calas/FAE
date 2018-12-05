 <template>
 <div class="page-container">
     <div  v-if="load<100" style="position:absolute;top:25%;left:42%">

         <img width="250px" src="https://upload.wikimedia.org/wikipedia/commons/a/ab/Logo_TV_2015.png" alt="People">
         <md-progress-bar   md-mode="determinate" :md-value="load"></md-progress-bar>
     </div>
     <!-- Dialog para Login -->
     <div>
         <md-dialog :md-active.sync="showDialogLogin">
             <md-dialog-title>Inicio de Sesión</md-dialog-title>
             <md-dialog-content>

                 <md-field :class="{'md-invalid': isInvalidEmail}">
                     <label>Correo electrónico</label>
                     <md-input v-model="email" type="email" @click="isInvalidEmail=true"></md-input>
                     <span class="md-error" v-if="!$v.email.required">El correo electrónico no puede estar vacío</span>
                     <span class="md-error" v-if="!$v.email.email">Correo electrónico inválido</span>
                 </md-field>

                 <md-field :class="{'md-invalid': isInvalidPass}">
                     <label>Contraseña</label>
                     <md-input v-model="password" type="password" @click="isInvalidPass=true"></md-input>
                     <span class="md-error" v-if="!$v.password.required">La contraseña no puede estar vacía</span>
                 </md-field>

             </md-dialog-content>
             <md-dialog-actions>
                 <md-button class="md-primary"  @click="showDialogLogin = false">Cerrar</md-button>
                 <md-button v-on:click="servicioLogin" type="submit">Ingresar</md-button>

             </md-dialog-actions>
         </md-dialog>
     </div>

     <!-- Dialog para Registro -->
     <div>
         <md-dialog :md-active.sync="showDialogRegister">
             <md-dialog-title>Solicitud de Registro</md-dialog-title>
             <md-dialog-content>
                 <md-field>
                     <label>Nombre</label>
                     <md-input v-model="nombre"></md-input>
                 </md-field>
                 <md-field>
                     <label>Región</label>
                     <md-input v-model="region"></md-input>
                 </md-field>
                 <md-field>
                     <label>N° Contacto</label>
                     <md-input v-model="phone" type="tel"></md-input>
                 </md-field>
             </md-dialog-content>
             <md-dialog-actions>
                 <md-button class="md-primary"  @click="showDialogRegister = false">Cerrar</md-button>
                 <md-button type="submit">Enviar</md-button>

             </md-dialog-actions>
         </md-dialog>
     </div>

     <!-- Pagina General -->
     <md-app md-waterfall md-mode="overlap">
         <md-app-toolbar class="md-accent md-large">
             <div class="md-toolbar-row">
                 <md-button v-if="this.role < 2" class="md-icon-button" @click="menuVisible = !menuVisible">
                     <md-icon>menu</md-icon>
                 </md-button>
                 <div style="float: right">
                 <span class="md-title">e-ematur</span>
                 </div>



                 <div class="md-toolbar-section-end">
                     <md-button @click="showDialogLogin = true">
                         Login
                     </md-button>
                     <md-button @click="showDialogRegister = true">
                         Registro
                     </md-button>
                 </div>
             </div>
         </md-app-toolbar>



         <md-app-drawer :md-active.sync="menuVisible" md-persistent="full" v-if="this.role < 2">
             <md-toolbar class="md-transparent" md-elevation="0">
                 <img width="150" height="80" src="https://images.vexels.com/media/users/3/145779/isolated/preview/53f7a1777bd2d2c3f8628d745268c5a3-ilustraci-n-del-loro-by-vexels.png">
             </md-toolbar>

             <div class="list-group" v-if="this.role === 1">
                 <a v-on:click="setSelectedItemHome" href="#" class="list-group-item"><label class="labelSide">Home</label><md-icon class="position">home</md-icon></a>
                 <a v-on:click="setSelectedItemEmpresaInfo" href="#" class="list-group-item"><label class="labelSide">Mi perfil</label><md-icon class="position">local_play</md-icon></a>
                 <a v-on:click="setSelectedItemEmpresaView" href="#" class="list-group-item"><label class="labelSide">Empresa</label><md-icon class="position">local_play</md-icon></a>
             </div>
             <div class="list-group" v-if="this.role === 0">
                 <a v-on:click="setSelectedItemHome" href="#" class="list-group-item"><label class="labelSide">Home</label><md-icon class="position">home</md-icon></a>
                 <a v-on:click="setSelectedItemAdminView" href="#" class="list-group-item"><label class="labelSide">Estadísticas generales</label><md-icon class="position">local_play</md-icon></a>
                 <a v-on:click="setSelectedItemAdminEdit" href="#" class="list-group-item"><label class="labelSide">Editar encuesta general</label><md-icon class="position">local_play</md-icon></a>
                 <a v-on:click="setSelectedItemAdminView2" href="#" class="list-group-item"><label class="labelSide">Estadísticas de sentimiento</label><md-icon class="position">local_play</md-icon></a>
                 <a v-on:click="setSelectedItemAdminEdit2" href="#" class="list-group-item"><label class="labelSide">Editar encuesta de sentimiento</label><md-icon class="position">local_play</md-icon></a>
                 <a v-on:click="setSelectedItemEmpresaInfo" href="#" class="list-group-item"><label class="labelSide">Mi perfil</label><md-icon class="position">local_play</md-icon></a>
             </div>
         </md-app-drawer>

         <md-app-content class="md-content">
             <div>
                 <div v-if="this.eleccion == 1">
                     <home-component v-bind:datos="preguntas"></home-component>
                 </div>
                 <div v-if="this.eleccion == 2">
                     <admin-edit-component v-bind:datos="[usuarios, preguntas]"></admin-edit-component>
                 </div>
                 <div v-if="this.eleccion == 3">
                     <admin-component v-bind:datos="[regiones, encuestados]"></admin-component>
                 </div>
                 <div v-if="this.eleccion == 4">
                     <empresa-component v-bind:datos="regiones"></empresa-component>
                 </div>
                 <div v-if="this.eleccion == 5">
                     <admin2-component v-bind:datos="[regiones, encuestados]"></admin2-component>
                 </div>
                 <div v-if="this.eleccion == 6">
                     <admin-edit2-component v-bind:datos="[usuarios, preguntas]"></admin-edit2-component>
                 </div>
                 <div v-if="this.eleccion == 7">
                     <empresa-userInfo-component></empresa-userInfo-component>
                 </div>
             </div>
         </md-app-content>
     </md-app>
 </div>
 </template>

 <style lang="scss" scoped>

     .md-app {
         max-height: 100000px;
         border: 1px solid rgba(#000, .12);
     }

     // Demo purposes only
     .md-drawer {
         width: 230px;
         max-width: calc(100vw - 125px);
     }

     .md-color{
         background-color: #4F8A10;
     }

     .md-content{
         height: 11000px;
     }

     .md-dialog{
         width: 508px;
     }




 </style>

 <script>
     import home from './home.vue';
     import userForm from './userForm.vue';
     import adminEdit from './adminEdit.vue';
     import adminView from './adminView.vue';
     import empresaView from './empresaView.vue';
     import empresaInfo from './empresaUserInfo.vue';
     import adminEdit2 from './adminEdit2.vue';
     import adminView2 from './adminView2.vue';
     import {
         required,
         email
     } from 'vuelidate/lib/validators'

     import Vue from 'vue'
     import Vuelidate from 'vuelidate'
     Vue.use(Vuelidate)

     export default {
         components: {
             'home-component': home,
             'form-component': userForm,
             'admin-component': adminView,
             'admin2-component': adminView2,
             'admin-edit-component': adminEdit,
             'admin-edit2-component': adminEdit2,
             'empresa-component': empresaView,
             'empresa-userInfo-component': empresaInfo
         },

         name: 'Overlap',
         data: () => ({
             load: 0,
             //role 0 = admin; role 1 = empresa; role 2 = usuario natural
             role: 1,
             error:false,
             showDialogLogin: false,
             showDialogRegister: false,
             menuVisible: false,
                 eleccion: 0,
             nombre: null,
             phone: null,
             region: null,
                 email: null,
                password: null,
                isInvalidEmail:false,
                isInvalidPass:false,
             loginjson:null,

             preguntas:null,
             regiones: null,
             usuarios: null,
             encuestados: null,
             usuariosE: null

         }),
         validations:{
            email: {
                required,
                email
            },
             password:{
                required
             }
         },

         created() {

             const auth = {
                 headers: {'Authorization':'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250cmFzZW5hIjoiYXNkZiIsInJvbCI6MSwiY29ycmVvIjoibWFpbEBtYWlsLmNsIiwiYWN0aXZvIjp0cnVlfQ.f8io8d-_s5ruT-ShuWrJTolHHB0hx4bK7y2lTexiGoo'}
             }

             this.$http.get('http://localhost:8092/categories/all').then(response => {
                 this.preguntas = response.data;
                 console.log('data de preguntas obtenido es:', this.preguntas);
                 this.eleccion = 1;
                 this.load += 33
             }, (response) => {
                 this.error = true;
             });

             this.$http.get('http://localhost:8092/regiones/all',auth).then(response => {
                 this.regiones = response.data;
                 console.log('data de regiones obtenido es:', this.regiones);
                 this.eleccion = 1;
                 this.load += 33
             }, (response) => {
                 this.error = true;
             });

             this.$http.get('http://localhost:8092/usuarios/all',auth).then(response => {
                 this.usuarios = response.data;
                 console.log('data de usuarios obtenido es:', this.usuarios);
                 this.eleccion = 1;
                 this.load += 34
             }, (response) => {
                 this.error = true;
             });

             this.$http.get('http://localhost:8092/encuestados/all',auth).then(response => {
                 this.encuestados = response.data;
                 console.log('data de encuestados obtenido es:', this.encuestados);
                 this.eleccion = 1;
                 this.load += 34
             }, (response) => {
                 this.error = true;
             });

             this.$http.get('http://localhost:8092/usuarios/name/d',auth).then(response => {
                 this.usuariosE = response.data;
                 console.log('data de usuario d obtenido es:', this.usuariosE);
                 this.eleccion = 1;
             }, (response) => {
                 this.error = true;
             });

         },

         methods: {

             setSelectedItemHome(){
                 this.eleccion=1;
             },
             setSelectedItemAdminEdit(){
                 this.eleccion=2;
             },
             setSelectedItemAdminView(){
                 this.eleccion=3;
             },
             setSelectedItemEmpresaView(){
                 this.eleccion=4;
             },
             setSelectedItemAdminView2(){
                 this.eleccion=5;
             },
             setSelectedItemAdminEdit2(){
                 this.eleccion=6;
             },
             setSelectedItemEmpresaInfo(){
                 this.eleccion=7;
             },

             servicioLogin(){
                 const config = {
                     headers: {'Content-Type': 'application/json'}};

                 this.loginjson = {
                     correo: this.email,
                     contrasena: this.password
                 }

                 this.$http.post('http://localhost:8092/usuarios/login',JSON.stringify(this.loginjson),config).then((response) => {
                     console.log("Se hizo el login",response.headers.get('Authorization'))
                     console.log("TODITO",response)
                 }, (response) =>{
                     console.log("No se logro el login",response)
                 });
             },

         },
         ready: function() {
             $('.dropdown-submenu a.test').on("click", function(e){
                 $(this).next('ul').toggle();
                 e.stopPropagation();
                 e.preventDefault();
             });
         }

     }
 </script>

 <style scoped>
     .position {
         position: absolute;
         right: 15px;
     }
     .md-toolbar.md-theme-default.md-accent {
         background-color: #202C39;
     }
     .md-toolbar.md-theme-default.md-accent .md-title{
     @import url('https://fonts.googleapis.com/css?family=Francois+One');
         font-family: 'Lobster Two', cursive;
         font-size: 35px;
         color: #FABC3C;
         margin-left: 20px;

     }
     .md-drawer.md-theme-default {
         background-color: #202C39;
     }
     a.list-group-item:focus, a.list-group-item:hover, button.list-group-item:focus, button.list-group-item:hover {
        background-color: #4F5C66;
     }
     a.list-group-item{
         background-color: #202C39;
     }
     .labelSide{
     @import url('https://fonts.googleapis.com/css?family=Francois+One');
         font-family: 'Francois One', sans-serif;
         font-size: 18px;
         color: #F2D492;
     }
     .md-content.md-theme-default{
         background-color: #FDFBF5;
     }
     body{
         background: #FAEFD7 ;
     }
 </style>