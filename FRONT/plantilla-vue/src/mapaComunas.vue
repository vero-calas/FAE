<template>

    <div class="">
        <br>
        <label class="">Mapa de aceptación:</label>
        <br><br>
        <div style="float:right;">
            <label for="select">Seleccione un criterio:</label>
            <div class="styled-select slate">
                <select @change="modGrafico" v-model="value" name="" id="select">
                    <option  value="1">Comentarios positivos</option>
                    <option  value="2">Comentarios negativos</option>
                </select>
            </div>
            <br><br>
        </div>
        <div class="embed-responsive" v-if="this.showd" id="viz">

        </div>
    </div>


</template>

<script>
    /*Para instalar d3plus el comando que deben poner dentro de plantilla-vue es:*/
    /*primero:                     npm install d3                                                            */
    /*                            npm install d3plus@next                                                    */
    /*********************************************************************************************************/
    /* Formato del json
    * id: debe ser el id de la region que está dado por el topojson
    * nombre: nombre de la region
    * positivos: comentarios positivos totales en esa región
    * negativos: negativos totales de la región
    * */

    import VueChart from "vue-chart-js";
    import * as data from './ComunasSantiago';
    export default {
        name: "mapa",
        value:{},

        props:['datos'],
        components: {
            VueChart
        },

        data: () => ({
            showd:true,
            eleccion: "",
            chart:null

        }),

        mounted() {
            this.showd=true;
            this.value=0;
            console.log("me llega la info de:", this.datos)
            this.eleccion="positive_value"
            this.crearMapa()


            //          d3plus.select('#viz')
            // .call(this.chart.draw, chart)
        },
        methods: {
            modGrafico(){
                if(this.value==2){
                    this.eleccion="negative_value";
                    console.log(this.eleccion);
                }
                else{
                    this.eleccion="positive_value";
                    console.log(this.eleccion);
                }
                let a = document.getElementById('viz')
                while(a.hasChildNodes()){

                    a.removeChild(a.firstChild);
                }
                this.crearMapa()
                //      this.showd=false;

                // this.$nextTick(() => {
                //         this.showd = true
                //         console.log('re-render start')
                //         this.$nextTick(() => {
                //             console.log('re-render end')
                //         })
                //          })
            },

            /*  Funcion que demuestra que no funciona el evento :c  */
            // eventMouse(){
            //     console.log("hice click")
            // },
            // /*       Funciones que actualizan la variable render del mapa           */
            // crearPositiva(){
            //     this.eleccion = "positive_value"
            //     console.log("la eleccion cambio a: ", this.eleccion)
            // },
            // crearNegativa(){
            //     this.eleccion = "negative_value"
            //     console.log("la eleccion cambio a: ", this.eleccion)
            // },




            crearMapa(){
                /*    Datos pasados por la vista externa bind  (llegan bien)       */
                var popData = this.datos

                var variable = this.eleccion
                console.log("la variable nombrada es: ", variable)

                this.chart = new d3plus.Geomap()
                /*.width()
                .height()*/
                    .data(popData)
                    /*                Variables que pasa el dato a graficar                 */
                    .colorScale(this.eleccion)
                    .topojson (data)
                        if(this.eleccion =="positive_value"){
                    this.chart
                        .label(function (d) {
                            return d.firstName + ", " + d.positive_value;
                        })
                }
                else{
                    this.chart
                        .label(function (d) {
                            return d.firstName + ", " + d.negative_value;

                        })
                }

                this.chart
                    .ocean("transparent")
                    .colorScaleConfig({scale: "jenks", color: ["#D8F781", "#f9ed69", "#f08a5d", "#b83b5e"]}).select('#viz').render();
                //  chart
                //     .ocean("transparent")
                //     .render();


            }
        }
    }


</script>

<style scoped>

    #viz{
        height:1000px;
        width: 1000px;
    }
</style>