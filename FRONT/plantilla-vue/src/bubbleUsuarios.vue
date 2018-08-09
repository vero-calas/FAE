
 <template>
 <div class="">
     <label class="">Tablas de Usuarios Influyentes:</label>
     <br><br>
     <div style="float:right;">
         <label for="select">Seleccione un criterio:</label>
         <div class="styled-select slate"
         <br><br>
             <select @change="modGrafico" v-model="value" name="" id="select">
                 <option  value="1">Universidad Católica</option>
                 <option  value="2">Colo-Colo</option>
                 <option  value="3">Universidad de Chile</option>
                 <option  value="4">Antofagasta</option>
                 <option  value="5">Audax Italiano</option>
                 <option  value="6">Curico Unido</option>
                 <option  value="7">Deportes Iquique</option>
                 <option  value="8">Deportes Temuco</option>
                 <option  value="9">Everton CD</option>
                 <option  value="10">Huachipato</option>
                 <option  value="11">O'Higgins</option>
                 <option  value="12">Palestino</option>
                 <option  value="13">San Luis</option>
                 <option  value="14">Universidad de Concepción</option>
                 <option  value="15">Unión Española</option>
                 <option  value="16">Unión la Calera</option>

             </select>
         </div>
         <br><br>
        <br><br>
         <table class="table">
           <thead class="thead-light">
           <tr>
               <th>Nombre</th>
               <th>Seguidores</th>
               <th>Cantidad de tweets sobre el equipo</th>
               <th>Influencia normalizada</th>
               <th>Tipo de comentario</th>
           </tr>
           </thead>
           <tbody>
           <tr v-if="i!==6" :key="i" :value="i" v-for="(usuario,i) in this.eleccion">
               <td> {{ usuario.name }} </td>
               <td> {{ usuario.followers }} </td>
               <td> {{ usuario.cantidad }} </td>
               <td> {{ usuario.influencia }} </td>
               <td> {{usuario.razon}} </td>
           </tr>

           <!--    <td><span class="label label-success">Active</span> -->


                   </tbody>
               </table>
     <h1>Descripción:</h1>

     <p> "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
     </p>
     </div>
 </div>
 </template>


 <script>
     import VueChart from "vue-chart-js";
     export default {
         name: "Usuarios",
         value:{},

         props:['datos'],
         components: {
             VueChart
         },

         data: () => ({
             showd:true,
             eleccion: "",
             chart:null,
             esPositiva: true

         }),

         mounted() {
             this.showd=true;
             this.value=0;
             console.log("me llega la info de:", this.datos)




             //          d3plus.select('#viz')
             // .call(this.chart.draw, chart)
         },
         methods: {

             modGrafico() {
                 if (this.value == 1) {
                     this.eleccion = this.datos[this.value].usuariosInfluyentes;
                     console.log("dsjkghsdgsdg", this.eleccion[0].name);
                 }
                 else {
                     this.eleccion = this.datos[this.value].usuariosInfluyentes;
                     console.log(this.eleccion);
                 }
             }
         }
     }
 </script>

 <style scoped>



 </style>