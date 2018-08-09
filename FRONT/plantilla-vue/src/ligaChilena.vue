<template>
<div>
    <br>

    <label>Gráfico general Liga Chilena</label>
    <br><br>
    <hr>
    <br><br>

    <div style="width:100%; float: left;"  >

        <vue-chart  v-if="this.chartData !== null" type="horizontalBar" :data="this.chartData"></vue-chart>
            <div v-else>
             <div class=" lds-css ng-scope">
                 <div style="width:100%;height:100%" class="lds-bars">
                   <div></div><div></div><div></div><div></div> <div></div>
                </div>
              </div>
            </div>

   </div>

    <div style="width:50%; float:right;">
        <vue-chart v-if="this.tortaData !== null" type="pie" :data="this.tortaData"></vue-chart>
         <div v-else>
             <div class="lds-css  ng-scope">
                 <div style="width:100%;height:100%" class="lds-bars">
                   <div></div><div></div><div></div><div></div> <div></div>
                </div>
              </div>
            </div>
    </div>


    <div>
        <h1>Descripción:</h1>

    <p> "Este gráfico muestra la aprobación de la comunidad con respecto a los equipos de la primera división que
        participan en la liga chilena.
        Se puede observar la cantidad de comentarios positivos que ha hecho la comunidad hacia el respectivo
        equipo mediante las barras de color verde. De igual manera se pueden observar la cantidad de
        comentarios negativos que la comunidad realiza a dicho equipo observando las barras de color rojo."
    </p>
    </div>

</div>
</template>


<script>
import VueChart from "vue-chart-js";

export default {
  props:['datos'],
  name: "App",

  components: {
    VueChart
  },

  data: () => ({
    chartData: null,
    tortaData: null,
    barra:true,
    torta:false,
    clubs: [],
    colores: []
    
  }),
  created() {
      this.crearGrafico();
      this.crearTorta();
      console.log("grafico creado", this.chartData);
  },
  
  methods: {
    mostrarBarra(){
        this.barra=true;
        this.torta=false;    

    },
     mostrarTorta(){
        this.barra=false;
        this.torta=true;    

    },

 /*---------------------------------------------------------------------------------------------------------*/
/*dejar esta funcion en el for de crear grafico*/
      colorRandom(){
        var color="#"+((1<<24)*Math.random()|0).toString(16)
       /* for(let i = 0; i < this.colores.length-1; i++)
            if (color.localeCompare(this.colores[i]) == 0){
                console.log("econtre un color igual")
                colorRandom();
            }
            else{
                this.colores.push(color)
            }*/
          this.colores.push(color)
              console.log("color", color, "agregado")
          console.log("el arreglo de colores es:", this.colores)

      },

      /*---------------------------------------------------------------------------------------------------------*/

      crearTorta(){
          this.tortaData = {
              labels: ["Promedio de comentarios positivos","Promedio de comentarios negativos"],
              datasets: [
                  {
                      label: ["Promedio de comentarios positivos","Promedio de comentarios negativos"],
                      backgroundColor: ["#56FB4C", "#FB5C57"],
                      data: [this._props.datos[16].statistics[0].positive_value,
                          this._props.datos[16].statistics[0].negative_value]
                  },

              ]

          }
      },

    crearGrafico() {

      this.chartData = {
        labels: [],
        datasets: [
          {
            label: "Comentarios positivos",
            backgroundColor: "#56FB4C",
            data: []
          },

            {
                label: "Comentarios negativos",
                backgroundColor: "#FB5C57",
                data: []
            },
        ]
      };
      console.log(this._props);
      for (let i = 0; i < this._props.datos.length-1; i++) {

        console.log("el data usado es",this._props.datos[16].statistics[0].positive_value)
         /* this.colorRandom();*/
        this.chartData.labels = this.chartData.labels.concat([
          this._props.datos[i].name
         
        ]);
        let tam = this._props.datos[i].statistics.length
        this.chartData.datasets[0].data.push( this._props.datos[i].statistics[tam-1].positive_value) 
        this.chartData.datasets[1].data.push( this._props.datos[i].statistics[tam-1].negative_value)
      }
      /*
      console.log("char:" + this.chartData.labels);
       console.log("char2:" +  this.chartData.datasets[0].data);
        console.log("char3:" +  this.chartData.datasets[1].data);*/
     
    }
  }
};
</script>

<style scoped>
</style>
