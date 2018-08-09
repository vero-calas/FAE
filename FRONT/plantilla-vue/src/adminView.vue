<template>
    <div>
        <div>
            <md-card style="width:98%">
                <div class="demo-badge">
                    <div>
                        <md-badge md-content="1" md-dense>

                            <md-menu md-align-trigger>
                                <md-button class="md-icon-button" md-menu-trigger>
                                    <md-icon>notifications</md-icon>
                                </md-button>

                                <md-menu-content>
                                    <md-menu-item>Notificacion 1</md-menu-item>
                                    <md-menu-item>Notificacion 2</md-menu-item>
                                    <md-menu-item>Notificacion 3</md-menu-item>
                                </md-menu-content>
                            </md-menu>

                        </md-badge>

                        <md-badge class="md-primary" md-content="12" md-dense>

                            <md-menu md-align-trigger>
                                <md-button class="md-icon-button" md-menu-trigger>
                                    <md-icon>home</md-icon>
                                </md-button>
                                <md-menu-content>
                                    <md-menu-item>Notificacion 1</md-menu-item>
                                    <md-menu-item>Notificacion 2</md-menu-item>
                                    <md-menu-item>Notificacion 3</md-menu-item>
                                </md-menu-content>
                            </md-menu>
                        </md-badge>

                       <br> <H1> Para enviar diagnóstico despliegue esta ventana </H1>
                    </div>
                </div>


                <md-card-expand>
                    <md-card-expand-content>

                        <md-card-content>
                                <label>Elija la empresa que desea buscar:</label>
                                <md-autocomplete v-model="selectedEmpresas" :md-options="empresas">
                                    <label>Empresas</label>
                                </md-autocomplete>
                                <label>Ingrese archivo de diagnóstico: </label>
                                <md-field>
                                    <label>Archivo subido:</label>
                                    <md-file v-model="placeholder" placeholder="Haga clic y seleccione el archivo que desea enviar" />
                                </md-field>
                                <!--  Botón que envía el archivo -->
                                <md-button class="md-raised">Enviar</md-button>
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
        <div>
            <!-- Región del Gráfico -->
            <div style="width:50% ; float: left">
                <md-card style="width:98%">
                    <md-card-header>
                        <div class="md-title" style="text-align: center">
                            Resumen:
                        </div>
                    </md-card-header>
                </md-card>

                <!-- Grafico -->
                <md-card>
                    <md-card-header>
                        <div class="md-title">Aprobación en distintos ámbitos</div>
                    </md-card-header>
                    <md-card-media>
                        <vue-chart  v-if="this.chartData !== null" type="bar" :data="this.chartData"></vue-chart>
                        <div v-else>
                            <div class=" lds-css ng-scope">
                                <div  class="lds-bars">
                                    <div></div><div></div><div></div><div></div> <div></div>
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

                <div style=" width: 100%;float: left">
                    <!-- Gráfico Género -->
                            <vue-chart v-if="this.chartData != null" type="polarArea" :data="this.chartData"></vue-chart>
                            <div v-else>
                                <div class=" lds-css ng-scope">
                                    <div style="width:100%;height:100%" class="lds-bars">
                                        <div></div><div></div><div></div><div></div> <div></div>
                                    </div>
                                </div>
                            </div>

                </div>
                <br><br><br>
                <div style="float: left; width: 50%">
                    <!-- Datos generales -->
                    <md-card>
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
                <div style="float: left; width: 50%">
                    <!-- Datos generales -->
                    <md-card>
                        <md-card-header class="md-title">Datos de la Región:</md-card-header>
                        <md-card-content>
                            <div>
                                La cantidad de datos tomados son 2000.
                            </div>
                            <div>
                                Referencias positivas: 295
                            </div>
                            <div>
                                Referencias negativas: 800
                            </div>
                            <div>
                                Otro: 100
                            </div>
                            Aprobación General: 49,3%
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

    </div>
</template>

<script>
    import VueChart from "vue-chart-js";
    export default {
        name: "adminView",
        components: {
            VueChart
        },

        data: () => ({
            chartData: null,
            selectedEmpresas: null,
            placeholder: null,
            empresas: [
                'Empresa 1',
                'Empresa 2',
                'Empresa 3',
                'Empresa 4',
                'Empresa 5',
                'Empresa 6',
                'Empresa 7'
            ]
        }),


        mounted() {
            this.crearGrafico();
            console.log("grafico creado", this.chartData);
        },

        methods: {
          crearGrafico() {
                this.chartData = {
                    labels: ["Satisfacción", "Familiaridad", "Confianza", "Reputación", "Evaluación Cognitiva"],
                    datasets: [{
                            data: [50, 64, 73, 22, 48],
                            backgroundColor:['#FF7043', '#FFA726', '#FFCA28', '#FFEE58', '#D4E157', '#9CCC65 '],
                            label: [""]
                        },


                    ]

                };
            }
        }
    };


</script>

<style lang="scss" scoped>
    .demo-badge {
        > div {
            margin-bottom: 16px;
        }
    }

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