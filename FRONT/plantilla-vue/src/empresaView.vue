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
                </md-card-header>
                <md-card-media>
                    <vue-chart  v-if="this.summaryChart !== null" type="polarArea" :data="this.summaryChart"></vue-chart>
                    <div v-else>
                        <div class=" lds-css ng-scope">
                            <div  class="lds-bars">
                            </div>
                        </div>
                    </div>
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

            <div style=" width: 54%;float: left">
                <!-- Gráfico Género -->
                <md-card style="height:18.5%">
                    <md-card-media>
                        <vue-chart v-if="this.pieChart != null" type="pie" :data="this.pieChart"></vue-chart>
                        <div v-else>
                            <div class=" lds-css ng-scope">
                                <div style="width:100%;height:100%" class="lds-bars">
                                </div>
                            </div>
                        </div>
                    </md-card-media>
                </md-card>
            </div>
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

                        <md-table-row>
                            <md-table-cell >Reputación</md-table-cell>
                            <md-table-cell>68% (1832)</md-table-cell>
                            <md-table-cell>32% (168)</md-table-cell>
                            <md-table-cell>54%</md-table-cell>
                        </md-table-row>

                        <md-table-row>
                            <md-table-cell>Satisfacción</md-table-cell>
                            <md-table-cell>32% (168)</md-table-cell>
                            <md-table-cell>68% (1832)</md-table-cell>
                            <md-table-cell>12%</md-table-cell>
                        </md-table-row>

                        <md-table-row>
                            <md-table-cell>Evaluación Afectiva</md-table-cell>
                            <md-table-cell>68% (1832)</md-table-cell>
                            <md-table-cell>32% (168)</md-table-cell>
                            <md-table-cell>54%</md-table-cell>
                        </md-table-row>

                        <md-table-row>
                            <md-table-cell >Evaluación Cognitiva</md-table-cell>
                            <md-table-cell>73% (1900)</md-table-cell>
                            <md-table-cell>27% (100)</md-table-cell>
                            <md-table-cell>45%</md-table-cell>
                        </md-table-row>

                        <md-table-row>
                            <md-table-cell>Beneficio Simbólico</md-table-cell>
                            <md-table-cell>32% (168)</md-table-cell>
                            <md-table-cell>68% (1832)</md-table-cell>
                            <md-table-cell>12%</md-table-cell>
                        </md-table-row>

                        <md-table-row>
                            <md-table-cell >Beneficio Funcional</md-table-cell>
                            <md-table-cell>42% (256)</md-table-cell>
                            <md-table-cell>58% (1744)</md-table-cell>
                            <md-table-cell>12%</md-table-cell>
                        </md-table-row>

                        <md-table-row>
                            <md-table-cell >Beneficio Hedónico</md-table-cell>
                            <md-table-cell>32% (168)</md-table-cell>
                            <md-table-cell>68% (1832)</md-table-cell>
                            <md-table-cell>12%</md-table-cell>
                        </md-table-row>

                        <md-table-row>
                            <md-table-cell>Confianza en Personas</md-table-cell>
                            <md-table-cell>73% (1900)</md-table-cell>
                            <md-table-cell>27% (100)</md-table-cell>
                            <md-table-cell>45%</md-table-cell>

                        </md-table-row>

                        <md-table-row>
                            <md-table-cell >Confianza en Inst. Públicas</md-table-cell>
                            <md-table-cell>42% (256)</md-table-cell>
                            <md-table-cell>58% (1744)</md-table-cell>
                            <md-table-cell>12%</md-table-cell>

                        </md-table-row>

                        <md-table-row>
                            <md-table-cell>Confianza en Inst. Privadas</md-table-cell>
                            <md-table-cell>68% (1832)</md-table-cell>
                            <md-table-cell>32% (168)</md-table-cell>
                            <md-table-cell>54%</md-table-cell>

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
        name: 'home',

        components:{
            VueChart
        },
        data: ()=>({
            summaryChart: null,
            pieChart: null
        }),

        created() {
            this.createPolarChart();
            this.createPieChart();
        },

        methods: {
            createPolarChart(){
                this.summaryChart = {
                    labels:["Satisfacción", "Familiaridad", "Reputación","Evaluación Afectiva","Evaluación Cognitiva","Beneficio Simbólico","Beneficio Funcional","Beneficio Hedónico","Confianza"],
                    datasets: [
                        {
                            data: [32,73,68,68,73,32,42,32,73],
                            backgroundColor: [
                                'rgba(0,0,255,0.5)',
                                'rgba(0,255,0,0.5)',
                                'rgba(255,0,0,0.5)',
                                'rgba(192,192,192,0.5)',
                                'rgba(255,255,0,0.5)',
                                'rgba(255,0,255,0.5)',
                                'rgba(204, 153, 255,0.5)',
                                'rgba(204, 255, 204,0.5)',


                            ]
                        }
                    ],

                }
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




