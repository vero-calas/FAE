<template>
    <div>

        <md-tabs md-sync-route class="md-transparent" md-alignment="fixed">
            <md-tab id="tab-home" md-label="Resumen" to="/components/tabs/home">

                <div>
                <md-card style="width: 45%; float: left">
                    <md-card-header>
                        <div class="md-title">Cantidades por región:</div>
                    </md-card-header>
                    <md-card-content>
                                <div>
                                    <vue-chart  v-if="this.generalData !== null" type="horizontalBar" :data="this.generalData"></vue-chart>
                                    <div v-else>
                                        <div class=" lds-css ng-scope">
                                            <div style="width:100%;height:100%" class="lds-bars">
                                                <div></div><div></div><div></div><div></div> <div></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        </md-card-content>
                </md-card>

                <md-card style="width: 45%; float: right">
                    <md-card-header>
                        <div class="md-title">Promedio por región:</div>
                    </md-card-header>
                    <md-card-content>
                        <div>
                            <vue-chart  v-if="this.promedioData !== null" type="horizontalBar" :data="this.promedioData"></vue-chart>
                            <div v-else>
                                <div class=" lds-css ng-scope">
                                    <div style="width:100%;height:100%" class="lds-bars">
                                        <div></div><div></div><div></div><div></div> <div></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </md-card-content>
                </md-card>

                    <md-card style="width: 45%; float: left">
                        <md-card-header>
                            <div class="md-title">Cantidades por género:</div>
                        </md-card-header>
                        <md-card-content>
                            <div>
                                <vue-chart  v-if="this.tortaGenero !== null" type="pie" :data="this.tortaGenero"></vue-chart>
                                <div v-else>
                                    <div class=" lds-css ng-scope">
                                        <div style="width:100%;height:100%" class="lds-bars">
                                            <div></div><div></div><div></div><div></div> <div></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </md-card-content>
                    </md-card>

                </div>
            </md-tab>

            <md-tab id="tab-pages" md-label="Estadísticas por Región" to="/components/tabs/pages">
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
                               <div v-if="this.showd">
                                <vue-chart  v-if="this.barData !== null" type="horizontalBar" :data="this.barData"></vue-chart>
                                <div v-else>
                                    <div class=" lds-css ng-scope">
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
                                <md-table style="width:100%;height: 50%">
                                    <select @change="modificarGrafico" v-model="value"  name="" id="select">
                                        <option v-if="i!==12" :key="i" :value="i" v-for="(elemento, i) in this.dataRegiones">
                                            {{elemento.nombre}}</option>
                                    </select>

                                    <md-table-row>
                                        <md-table-head>Categoría</md-table-head>
                                        <md-table-head md-numeric >Aprobación</md-table-head>

                                    </md-table-row>

                                    <md-table-row  v-for="(categoria, j) in this.dataRegiones[this.value].estadisticas">
                                        <div v-for="(each, k) in categoria.categorias">
                                        <md-table-cell >{{categoria.categorias[k]}}</md-table-cell>
                                            <md-table-cell md-numeric>{{categoria.resultados[k]}}</md-table-cell>
                                        </div>
                                    </md-table-row>
                                     <!--   <md-table-cell>{{categoria.resultados[k]}}</md-table-cell>
                                            <md-table-cell>{{categoria.mes}}, {{categoria.anio}}</md-table-cell>

-->
                                </md-table>
                            </md-card-media>

                        </md-card>

                    </div>

                </div>

              </md-tab>

            <md-tab id="tab-posts" md-label="Estadísticas por Empresa" to="/components/tabs/posts">
            <div>
                <md-card>

                    <md-card-header>
                        <div class="md-title"> Usuarios del sistema: </div>
                    </md-card-header>

                    <md-card-media>
                        <md-table style="width: 100%; height: 50%">

                            <md-table-row>
                                <md-table-head>N°</md-table-head>
                                <md-table-head md-numeric >Nombre</md-table-head>
                                <md-table-head md-numeric >Correo</md-table-head>
                                <md-table-head md-numeric>Activo</md-table-head>
                                <md-table-head md-numeric>Rol</md-table-head>
                            </md-table-row>
                            <md-table-row v-for="(usuario, z) in this.dataUsuarios">
                                    <md-table-cell >{{z}}</md-table-cell>
                                    <md-table-cell>{{usuario.nombre}}</md-table-cell>
                                    <md-table-cell>{{usuario.correo}}</md-table-cell>
                                    <md-table-cell>{{usuario.activo}}</md-table-cell>
                                    <md-table-cell>{{usuario.rol}}</md-table-cell>

                            </md-table-row>

                        </md-table>
                    </md-card-media>

                </md-card>

                <md-card style="height: 100%; width: 50%; float: right;">
                    <md-card-header>
                        <div class="md-title"> Busca un usuario específico: </div>
                    </md-card-header>

                    <md-card-media>
                        <label>Buscar por el nombre:</label>
                        <br>
                        <md-field>
                            <label>Escriba el nombre del usuario</label>
                            <md-textarea v-model="buscarNom"></md-textarea>
                        </md-field>
                     <!--   <md-button v-on:click="buscarPorNombre(buscarNom)" class="md-raised">Buscar</md-button> -->
bla
                        {{mostrarNom}}
                        {{this.mostrarNom}}
                        <br><hr>
                        <label>Buscar por el correo:</label>
                        <md-field>
                            <label>Escriba el correo del usuario</label>
                            <md-textarea v-model="buscarCorr"></md-textarea>
                        </md-field>
                   <!--     <md-button v-on:click="buscarPorCorreo" class="md-raised">Buscar</md-button> -->
bla

                        {{this.mostrarCorr}}


                    </md-card-media>
                </md-card>

            </div>
             </md-tab>

            <md-tab id="tab-favorites" md-label="Administración" to="/components/tabs/favorites">
                <div>
                    <md-card style="width: 100%; height: 100%; float: none">
                        <md-card-header>
                            <div class="md-title"> Añadir categoría: </div>
                        </md-card-header>
                    <br>
                    <hr>
                        <md-card-media>
                    <label>Nombre:</label>
                    <md-field>
                        <label>Ingrese el nombre de la categoría</label>
                        <md-textarea v-model="nombreCategoria" md-autogrow></md-textarea>
                    </md-field>
                    <br>

                    <hr>
                    <label>Descripción:</label>
                <md-field>
                    <label>Escriba una pequeña descripcion para la categoría</label>
                    <md-textarea v-model="description"></md-textarea>
                </md-field>


            <br>
                    <hr>
            <label>Cantidad de preguntas:</label>
                    <md-field>
                    <md-select name="cantPreguntas" id="cantPreguntas" v-model="cantPreguntas">
                        <md-option value="1">1</md-option>
                        <md-option value="12">2</md-option>
                        <md-option value="123">3</md-option>
                        <md-option value="1234">4</md-option>
                        <md-option value="12345">5</md-option>
                    </md-select>
                        </md-field>
                    <hr>

                <div v-for="i in this.cantPreguntas" >

                    <br>
                    <label>Pregunta {{i}}:</label>
                    <md-field>
                        <label>Ingrese la pregunta que desea realizar</label>
                        <md-textarea :id=i v-model="preguntaCate" md-autogrow></md-textarea>
                    </md-field>
                    <br>
                    <label>Escala:</label>
                    <md-field>
                        <label>Ingrese la escala con que desea evaluar la pregunta</label>
                        <md-textarea :id=i v-model="escalas" md-autogrow></md-textarea>
                    </md-field>
                    <label>*Seguir el formato: valor1, valor2, valor3 ...</label>
                    <hr>
                    {{this.preguntass}}
                </div>

                    <md-button v-on:click="crearJSON" class="md-raised">Aceptar</md-button>
                        </md-card-media>
                    </md-card>
                </div>
            </md-tab>


            <md-tab id="tab-estudio" md-label="Enviar estudio" to="/components/tabs/estudio">

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
<!--
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
                                <md-button class="md-raised">Enviar</md-button>
                            </md-card-content>
-->
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

            </md-tab>
        </md-tabs>



    </div>
</template>

<script>
    import VueChart from "vue-chart-js";
    export default {
        props: ['datos'],
        name: "adminView",
        components: {
            VueChart
        },

        data: () => ({
            /*  data en forma de lista del v-bind  */
            dataRegiones: null,
            dataUsuarios: null,
            dataEncuestados: null,
            /* variables html */
            json: null,
            eleccion: "",
            buscarCorr: "",
            buscarNom: "",
            mostrarCorr: [],
            mostrarNom: null,


            /*variables para el gráfico de regiones*/
            barData: null,
            promedioData: null,
            tortaGenero: null,
            showd: null,
            resGeneral: null,
            valores: [],
            /*variables para el gráfico de regiones*/
            generalData: null,
            showd2: null,

            /* variables para armar json */
            nombreCategoria: null,
            description: null,
            escalas: [],
            cantPreguntas: null,
            preguntaCate: null
        }),

        created() {
            this.showd = true;
            console.log("estoy creando");
            this.value = 0;
            this.dataRegiones = this.datos[0];
            this.dataUsuarios = this.datos[1];
            this.dataEncuestados = this.datos[2];
            this.guardarRes();
            this.crearGeneral();
            this.crearPromedio();
            this.creaGraficoTorta();
            console.log("grafico de promedio creado", this.generalData)
            console.log("grafico creado", this.promedioData);
            this.barData = this.crearGrafico();
        },


        mounted() {
            console.log("la data que llega es:", this.datos);
            this.dataRegiones = this.datos[0];
            this.dataUsuarios = this.datos[1];
            this.eleccion = this.dataRegiones[0];
            console.log("grafico creado", this.preguntass, this.escalas);
            console.log("la data que llega es:", this.datos)
        },

        methods: {

            modificarGrafico() {
                //console.log("*********"+this.datos);
                this.showd = false;
                this.barData = this.crearGrafico();
                console.log("la data es: ", this.barData.datasets[0].data);
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
                let barData = {
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
                var tam = this.dataRegiones[this.value].estadisticas[0].categorias.length;
                //console.log("el tamaño de la listade categorias es: ", tam);
                var concatenar = "-";
                for (let i = 0; i < tam; i++) {
                    //console.log("las categorias son :", this.dataRegiones[this.value].estadisticas[0].categorias[i]);
                    barData.labels.push(this.dataRegiones[this.value].estadisticas[0].categorias[i]);
                    // console.log("lso resultados son: ", this.dataRegiones[this.value].estadisticas[0].resultados[i]);
                    barData.datasets[0].data.push(this.dataRegiones[this.value].estadisticas[0].resultados[i])

                }
                return barData

            },

            crearGeneral() {
                console.log("estoy aqui miau")
                this.generalData = {
                    labels: [],
                    datasets: [
                        {
                            label: "Comentarios positivos",
                            backgroundColor: "#fba823",
                            data: null
                        },

                    ]
                };


                /* Largo  */
                console.log("estoy aqui miau 2", this.dataRegiones)
                var tam = this.dataRegiones[0].estadisticas[0].categorias.length;
                console.log("estoy aqui miau 3")
                this.generalData.datasets[0].data = this.resGeneral
                for (let i = 0; i < tam; i++) {
                    console.log("entro")
                    //console.log("las categorias son :", this.dataRegiones[this.value].estadisticas[0].categorias[i]);
                    this.generalData.labels.push(this.dataRegiones[0].estadisticas[0].categorias[i]);
                    // console.log("lso resultados son: ", this.dataRegiones[this.value].estadisticas[0].resultados[i]);
                }
            },

            guardarRes(){
                var tam = this.dataRegiones[0].estadisticas[0].categorias.length;
                this.resGeneral = this.dataRegiones[0].estadisticas[0].resultados
                console.log("resGeneral:", this.resGeneral)
                for (let k = 1; k < this.dataRegiones.length; k++) {
                    console.log("k valeeeeeeeeeeee,", k)
                    for (let i = 0; i < tam; i++) {
                        console.log("estoy sumando", this.resGeneral[i], "con:", this.dataRegiones[k].estadisticas[0].resultados[i])
                        this.resGeneral[i] = this.resGeneral[i] + this.dataRegiones[k].estadisticas[0].resultados[i]
                        console.log("los valores quedan comooooooooo", this.resGeneral)
                    }
                }
                console.log("salgo")
            },

            crearPromedio(){
                    console.log("estoy aqui miau")
                    this.promedioData = {
                        labels: [],
                        datasets: [
                            {
                                label: "Cantidad",
                                backgroundColor: "#fbe246",
                                data: null
                            },

                        ]
                    };
                    var tam = this.dataRegiones[0].estadisticas[0].categorias.length;
                    for (let i = 0; i < tam; i++) {
                        console.log("entro")
                        this.promedioData.labels.push(this.dataRegiones[0].estadisticas[0].categorias[i]);
                    }
                for(let i=0; i<tam; i++){
                    this.valores.push(this.resGeneral[i]/this.dataRegiones.length)
                }
                console.log("crearPromedio", this.valores)
                this.promedioData.datasets[0].data = this.valores
                console.log("promedio:", this.promedioData)
            },

            crearJSON() {
                let preguntass = []
                console.log("cantidad de preguntas", this.cantPreguntas)
                for (let i = 0; i < this.cantPreguntas; i++) {
                    var variable = {
                        idpregunta: i,
                        pregunta: this.preguntaCate,
                        opciones: null,
                        escala: this.escalas
                    }
                    preguntass.push(variable)
                    console.log("quiero añadir", preguntass)
                }

                this.json = {
                    nombre: this.nombreCategoria,
                    descripcion: this.description,
                    preguntas: preguntass
                }


                console.log("jsooooooooooooon", this.json)
            },

            creaGraficoTorta(){
                let dataGenero = []
                let contadorM = 0;
                let contadorF = 0;
                let contadorX = 0;
                for (let i=0; i<this.dataEncuestados.length; i++){
                    if (this.dataEncuestados[i].sexo == "M"){
                        contadorM++
                        console.log("la cantidad de hombreses", contadorM)
                    }
                    else if(this.dataEncuestados[i].sexo == "F"){
                        contadorF++
                        console.log("lac antidad de mujer es", contadorF)
                    }
                    else {
                        contadorX++
                    }
                }

                dataGenero.push(contadorM);
                dataGenero.push(contadorF);
                dataGenero.push(contadorX);
                console.log("la data queda en el orden:", dataGenero)
                    this.tortaGenero = {
                        labels: ["Hombres", "Mujeres", "Otro"],
                        datasets: [
                            {
                                label: "",
                                backgroundColor: ['#FF7043',
                                    '#FFA726',
                                    '#FFCA28',],
                                data: dataGenero
                            },
                        ]
                    }
                },

            // crear gráfico laboral, nivel de estudio, nivel de ingresos, estado civil, rango de edad

        }
    }


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
    /*    align-items: right; */
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