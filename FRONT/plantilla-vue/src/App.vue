 <template>
 <div class="page-container">

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
                 <md-button type="submit">Ingresar</md-button>

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
                 <md-button class="md-icon-button" @click="menuVisible = !menuVisible">
                     <md-icon>menu</md-icon>
                 </md-button>
                 <div style="float: right">
                 <span class="md-title">E-EMATUR</span>
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



         <md-app-drawer :md-active.sync="menuVisible" md-persistent="full">
             <md-toolbar class="md-transparent" md-elevation="0">
                 <img width="150" height="80" src="https://upload.wikimedia.org/wikipedia/commons/a/ab/Logo_TV_2015.png">
             </md-toolbar>

             <div class="list-group">
                 <a v-on:click="setSelectedItemHome" href="#" class="list-group-item"><label class="labelSide">Home</label><md-icon class="position">home</md-icon></a>
                 <a v-on:click="setSelectedItemUserForm" href="#" class="list-group-item"><label class="labelSide">Formulario</label><md-icon class="position">local_play</md-icon></a>
                 <a v-on:click="setSelectedItemAdminView" href="#" class="list-group-item"><label class="labelSide">Administrador</label><md-icon class="position">local_play</md-icon></a>
                 <a v-on:click="setSelectedItemEmpresaView" href="#" class="list-group-item"><label class="labelSide">Empresa</label><md-icon class="position">local_play</md-icon></a>
             </div>
         </md-app-drawer>

         <md-app-content class="md-content">
             <div>
                 <div v-if="this.eleccion == 1">
                     <home-component></home-component>
                 </div>
                 <div v-if="this.eleccion == 2">
                     <form-component></form-component>
                 </div>
                 <div v-if="this.eleccion == 3">
                     <admin-component></admin-component>
                 </div>
                 <div v-if="this.eleccion == 4">
                     <empresa-component></empresa-component>
                 </div>
             </div>
         </md-app-content>
     </md-app>
 </div>
 </template>

 <style lang="scss" scoped>

     .md-app {
         max-height: 10000px;
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
         height: 1100px;
     }

     .md-dialog{
         width: 508px;
     }


 </style>

 <script>
     import home from './home.vue';
     import userForm from './userForm.vue';
     import adminView from './adminView.vue';
     import empresaView from './empresaView.vue';
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
             'empresa-component': empresaView
         },

         name: 'Overlap',
         data: () => ({
             showDialogLogin: false,
             showDialogRegister: false,
             menuVisible: false,
                 eleccion: 0,
                 clubs:null,
                 mapas: null,
                 comunas: null,
             nombre: null,
             phone: null,
             region: null,
                 burbujas: null,
                 email: null,
                password: null,
                isInvalidEmail:false,
                isInvalidPass:false

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

         },

         methods: {
             setSelectedItemHome(){
                 this.eleccion=1;
             },
             setSelectedItemUserForm(){
                 this.eleccion=2;
             },
             setSelectedItemAdminView(){
                 this.eleccion=3;
             },
             setSelectedItemEmpresaView(){
                 this.eleccion=4;
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
         font-family: 'Francois One', sans-serif;
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