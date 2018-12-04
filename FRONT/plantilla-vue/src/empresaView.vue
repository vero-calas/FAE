<template>
    <div>
        <!-- Región del Gráfico -->
        <div style="width:50% ; float: left">
            <md-card style="width:98%">
                <md-card-header>
                    <div class="md-title" style="text-align: center">
                        Región de los Lagos: Puerto Montt
                    </div>
                </md-card-header>
            </md-card>
            <!-- Grafico -->
            <md-card>
                <md-card-header>
                    <div class="md-title">Aprobación en distintos ámbitos</div>
                    <label>Selesccione la region a la que pertenece:</label>
                    <select @change="modificarGrafico" v-model="value"  name="" id="select">
                        <option v-if="i!==12" :key="i" :value="i" v-for="(elemento, i) in this.datos">
                            {{elemento.nombre}}</option>
                    </select>
                </md-card-header>
                <md-card-media>
                    <div v-if="this.showd">
                        <vue-chart  v-if="this.polarData !== null" type="polarArea" :data="this.polarData"></vue-chart>
                        <div v-else>
                            <div class=" lds-css ng-scope">
                            </div>
                        </div>
                    </div>
                </md-card-media>
            </md-card>


            <div style=" width: 46%; float: right">
                <!-- Datos generales -->
                <md-card style="height:18.5%">
                    <md-card-header class="md-title">Datos Generales</md-card-header>
                    <md-card-content>
                        <div>
                            La cantidad de datos tomados son 2000.
                        </div>
                        <div>
                            Mujeres encuestadas: 1100
                        </div>
                        <div>
                            Hombres encuestados: 800
                        </div>
                        <div>
                            Otro: 100
                        </div>
                        Aprobación General: 69,3%
                    </md-card-content>
                </md-card>
            </div>
        </div>

        <!-- Tabla -->
        <div style="width:50%; float:right">
            <md-card>
                <md-card-header>
                    <div class="md-title">Detalle Encuestas</div>
                </md-card-header>
                <md-card-media>
                    <md-table style="width:100%;height: 55%">

                        <md-table-row>
                            <md-table-head>Categoría</md-table-head>
                            <md-table-head md-numeric >Aprobación</md-table-head>
                            <md-table-head md-numeric >Desaprobación</md-table-head>
                            <md-table-head md-numeric>x̄</md-table-head>
                        </md-table-row>

                        <md-table-row>
                            <md-table-cell>Familiaridad</md-table-cell>
                            <md-table-cell>73% (1900)</md-table-cell>
                            <md-table-cell>27% (100)</md-table-cell>
                            <md-table-cell>45%</md-table-cell>
                        </md-table-row>

                    </md-table>
                </md-card-media>


                <md-card-expand>
                    <md-card-expand-content>
                        <md-card-content>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum
                        </md-card-content>
                    </md-card-expand-content>
                    <md-card-actions md-alignment="space-between">
                        <md-card-expand-trigger>
                            <md-button class="md-icon-button">
                                <md-icon>keyboard_arrow_down</md-icon>
                            </md-button>
                        </md-card-expand-trigger>
                    </md-card-actions>
                </md-card-expand>


            </md-card>

        </div>

    </div>


</template>


<style lang="scss" scoped>

    .md-card {
        //width: 600px;
        //margin: 5px;
        margin-right: 5px;
        margin-left: 5px;
        margin-top: 5px;
        display: inline-block;
        vertical-align: top;
    }

    .md-content {
        width: 100px;
        height: 200px;
        display: inline-flex;
        justify-content: center;
        align-items: center;
    }
    /* Color del cuadrado primary */
    .md-content.md-theme-default.md-primary {
        background-color: #ffbe33;
        color: #5d5d5d;
        font-size: 17px;
        @import url('https://fonts.googleapis.com/css?family=Francois+One');
        font-family: 'Francois One', sans-serif;
    }
    /* Color del cuadrado accent*/
    .md-content.md-theme-default.md-accent {
        background-color: #ff8b09;
        color: #474747;
        font-size: 17px;
        @import url('https://fonts.googleapis.com/css?family=Francois+One');
        font-family: 'Francois One', sans-serif;
    }
    .imagePos{
        display: inline-flex;
        justify-content: right;
        align-items: right;
        float: right;
    }

    .font1{
        color: black;
        font-size: medium;
        font-weight: normal;
        font-style: oblique;
    }

    .font2{
        color: grey;
        font-size: large;
    }


</style>

<script>
    import VueChart from "vue-chart-js";

    export default {
        props: ['datos'],
        name: 'home',

        components:{
            VueChart
        },
        data: ()=>({
            polarData: null,
            showd: null
        }),

        created() {
            this.polarData = this.crearGrafico();

        },

        mounted() {
            console.log("la data que llega es:", this.datos);
            this.eleccion = this.datos[0];
        },


        methods: {

            modificarGrafico() {
                //console.log("*********"+this.datos);
                this.showd = false;
                this.polarData = this.crearGrafico();
                console.log("la data es: ", this.polarData.datasets[0].data);
                this.showd = false;
                this.$nextTick(() => {
                    this.showd = true
                    console.log('re-render start')
                    this.$nextTick(() => {
                        console.log('re-render end')
                    })
                })
            },


            crearGrafico() {
                console.log("VAlor para graficqar: ", this.value)
                let polarData = {
                    labels: [],
                    datasets: [
                        {
                            data: [],
                            label: ["Puntuación alcanzada"],
                            backgroundColor: ['#FF7043', '#FFA726', '#FFCA28', '#FFEE58', '#D4E157', '#9CCC65 ',
                                '#26A69A', '#26C6DA', '#29B6F6', '#42A5F5', '#5C6BC0', '#3F51B5',
                                '#7E57C2', '#AB47BC', '#EC407A', '#EF9A9A', '#D1C4E9  '],
                        },

                    ]
                };
                /* Largo  */
                var tam = this.datos[this.value].estadisticas[0].categorias.length;
                //console.log("el tamaño de la listade categorias es: ", tam);
                var concatenar = "-";
                for (let i = 0; i < tam; i++) {
                    //console.log("las categorias son :", this.dataRegiones[this.value].estadisticas[0].categorias[i]);
                    polarData.labels.push(this.datos[this.value].estadisticas[0].categorias[i]);
                    // console.log("lso resultados son: ", this.dataRegiones[this.value].estadisticas[0].resultados[i]);
                    polarData.datasets[0].data.push(this.datos[this.value].estadisticas[0].resultados[i])

                }
                return polarData

            },




            createPieChart(){
                this.pieChart = {
                    labels:["Hombres (%)", "Mujeres (%)", "Otro (%)"],
                    datasets: [
                        {
                            data: [40,55,5],
                            backgroundColor: [
                                'rgba(192,192,192)',
                                'rgba(255,255,0)',
                                'rgba(255,0,255)'
                            ]
                        }
                    ]
                }
            }
        }

    }

</script>




