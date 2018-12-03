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


                    <md-card style="width: 45%; float: right">
                        <md-card-header>
                            <div class="md-title">Cantidades por Estado Civil:</div>
                        </md-card-header>
                        <md-card-content>
                            <div>
                                <vue-chart  v-if="this.tortaEstadoC !== null" type="pie" :data="this.tortaEstadoC"></vue-chart>
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
                            <div class="md-title">Cantidades por Edad:</div>
                        </md-card-header>
                        <md-card-content>
                            <div>
                                <vue-chart  v-if="this.tortaEdad !== null" type="pie" :data="this.tortaEdad"></vue-chart>
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
                            <div class="md-title">Cantidades por Situación Laboral:</div>
                        </md-card-header>
                        <md-card-content>
                            <div>
                                <vue-chart  v-if="this.tortaLaboral !== null" type="pie" :data="this.tortaLaboral"></vue-chart>
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
                                    Datos específicos:
                                </div>
                            </md-card-header>
                        </md-card>

                        <!-- Grafico -->
                        <md-card style="width: 97%; float: left">
                            <md-card-header>
                                <div class="md-title">Categorías por región:</div>
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
                        </md-card>

                        <md-card style="width: 97%; float: left">
                            <md-card-header>
                                <div class="md-title">Categorías por fecha:</div>
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
            dataPreguntas: null,
            /* variables html */
            json: null,
            eleccion: "",



            /*variables para el gráfico de regiones*/
            barData: null,
            promedioData: null,
            tortaGenero: null,
            tortaEstadoC: null,
            tortaEdad: null,
            tortaLaboral: null,
            showd: null,
            resGeneral: null,
            valores: [],
            /*variables para el gráfico de regiones*/
            generalData: null,
            showd2: null,



            /**/
            nuevoNombre: null,
            nuevaDescripcion: null

        }),

        created() {
            this.showd = true;
            console.log("estoy creando");
            this.value = 0;
            this.dataRegiones = this.datos[0];
            this.dataEncuestados = this.datos[1];
            this.guardarRes(); this.crearGeneral(); this.crearPromedio(); this.crearGraficoTorta();
            this.crearTortaEstadoCivil(); this.crearTortaEdad(); this.crearTortaLaboral();
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
                            backgroundColor: ['#D4E157','#D4E157','#D4E157','#D4E157','#D4E157',
                                '#D4E157','#D4E157','#D4E157','#D4E157','#D4E157','#D4E157','#D4E157','#D4E157','#D4E157',
                                '#D4E157','#D4E157','#D4E157'],
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


            crearGraficoTorta(){
                let dataGenero = []
                let contadorM = 0;
                let contadorF = 0;
                let contadorX = 0;
                for (let i=0; i<this.dataEncuestados.length; i++){
                    if (this.dataEncuestados[i].sexo == "Masculino"){
                        contadorM++
                        console.log("la cantidad de hombreses", contadorM)
                    }
                    else if(this.dataEncuestados[i].sexo == "Femenino"){
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

            crearTortaEstadoCivil(){
            //{"Casada(o)","Soltera(o)","Divorciada(o) o Separada(o)","Viuda(o)","Otro","No sabe-No responde"]
                let dataEstadoC = []
                let contadorC = 0; let contadorSolt = 0; let contadorDS = 0;
                let contadorV = 0; let contadorX = 0; let contadorNA = 0;
                for (let i=0; i<this.dataEncuestados.length; i++){
                    if (this.dataEncuestados[i].estadoCivil == "Soltera(o)"){
                        contadorSolt++
                        console.log("la cantidad de hombreses", contadorSolt)
                    }
                    else if(this.dataEncuestados[i].estadoCivil == "Casada(o)"){
                        contadorC++
                        console.log("lac antidad de mujer es", contadorC)
                    }
                    else if(this.dataEncuestados[i].estadoCivil == "Divorciada(o) o Separada(o)"){
                        contadorDS++
                        console.log("lac antidad de mujer es", contadorDS)
                    }
                    else if(this.dataEncuestados[i].estadoCivil == "Viuda(o)"){
                        contadorV++
                        console.log("lac antidad de mujer es", contadorV)
                    }
                    else if(this.dataEncuestados[i].estadoCivil == "Otro"){
                        contadorX++
                        console.log("lac antidad de mujer es", contadorX)
                    }
                    else {
                        contadorNA++
                    }
                }

                dataEstadoC.push(contadorC);
                dataEstadoC.push(contadorSolt);
                dataEstadoC.push(contadorDS);
                dataEstadoC.push(contadorV);
                dataEstadoC.push(contadorX);
                dataEstadoC.push(contadorNA);
                console.log("la data queda en el orden:", dataEstadoC)
                this.tortaEstadoC = {
                    labels: ["Casada(o)","Soltera(o)","Divorciada(o) o Separada(o)","Viuda(o)","Otro","No sabe-No responde"],
                    datasets: [
                        {
                            label: "",
                            backgroundColor:  ['#FF7043',
                                '#FFA726',
                                '#FFCA28',
                                '#FFEE58',
                                '#D4E157',
                                '#9CCC65 '],
                            data: dataEstadoC
                        },
                    ]
                }
            },
            // crear gráfico nivel de estudio, nivel de ingresos
            crearTortaEdad(){
                let dataEdad = []
                let contador18 = 0; let contador25 = 0; let contador35 = 0;
                let contador45 = 0; let contador55 = 0; let contador65 = 0;
                let contadorNA = 0;
                for (let i=0; i<this.dataEncuestados.length; i++){
                    if (this.dataEncuestados[i].rangoDeEdad == "Entre 18 y 24"){
                        contador18++
                        console.log("la cantidad de hombreses", contador18)
                    }
                    else if(this.dataEncuestados[i].rangoDeEdad == "Entre 25 y 34"){
                        contador25++
                        console.log("lac antidad de mujer es", contador25)
                    }
                    else if(this.dataEncuestados[i].rangoDeEdad == "Entre 35 y 44"){
                        contador35++
                        console.log("lac antidad de mujer es", contador35)
                    }
                    else if(this.dataEncuestados[i].rangoDeEdad == "Entre 45 y 54"){
                        contador45++
                        console.log("lac antidad de mujer es", contador45)
                    }
                    else if(this.dataEncuestados[i].rangoDeEdad == "Entre 55 y 64"){
                        contador55++
                        console.log("lac antidad de mujer es", contador55)
                    }
                    else if(this.dataEncuestados[i].rangoDeEdad == "Mayor de 65"){
                        contador65++
                        console.log("lac antidad de mujer es", contador65)
                    }
                    else {
                        contadorNA++
                    }
                }
                dataEdad.push(contador18);
                dataEdad.push(contador25);
                dataEdad.push(contador35);
                dataEdad.push(contador45);
                dataEdad.push(contador55);
                dataEdad.push(contador65);
                dataEdad.push(contadorNA);
                console.log("la data queda en el orden:", dataEdad)
                this.tortaEdad = {
                    labels: ["Entre 18 y 24", "Entre 25 y 34","Entre 35 y 44","Entre 45 y 54",
                        "Entre 55 y 64","Mayor de 65", "No sabe-No responde"],
                    datasets: [
                        {
                            label: "",
                            backgroundColor:  ['#FF7043', '#FFA726', '#FFCA28', '#FFEE58', '#D4E157', '#9CCC65 ',
                                '#26A69A'],
                            data: dataEdad
                        },
                    ]
                }
            },

            crearTortaLaboral(){
                let dataLaboral = []
                let contadorPT = 0; let contadorFT = 0; let contadorBE = 0;
                let contadorDC = 0; let contadorJ = 0; let contadorE = 0;
                let contadorNA = 0;
                for (let i=0; i<this.dataEncuestados.length; i++){
                    if (this.dataEncuestados[i].situacionLaboral == "Trabaja part time"){
                        contadorPT++
                        console.log("la cantidad de hombreses", contadorPT)
                    }
                    else if(this.dataEncuestados[i].situacionLaboral == "Trabaja full time"){
                        contadorFT++
                        console.log("lac antidad de mujer es", contadorFT)
                    }
                    else if(this.dataEncuestados[i].situacionLaboral == "Busca empleo"){
                        contadorBE++
                        console.log("lac antidad de mujer es", contadorBE)
                    }
                    else if(this.dataEncuestados[i].situacionLaboral == "Dueña de Casa"){
                        contadorDC++
                        console.log("lac antidad de mujer es", contadorDC)
                    }
                    else if(this.dataEncuestados[i].situacionLaboral == "Jubilado"){
                        contadorJ++
                        console.log("lac antidad de mujer es", contadorJ)
                    }
                    else if(this.dataEncuestados[i].situacionLaboral == "Estudiante"){
                        contadorE++
                        console.log("lac antidad de mujer es", contadorE)
                    }
                    else {
                        contadorNA++
                    }
                }
                dataLaboral.push(contadorPT); dataLaboral.push(contadorFT); dataLaboral.push(contadorBE);
                dataLaboral.push(contadorDC); dataLaboral.push(contadorJ); dataLaboral.push(contadorE);
                dataLaboral.push(contadorNA);
                console.log("la data queda en el orden:", dataLaboral)
                this.tortaLaboral = {
                    labels: ["Trabaja part time","Trabaja full time","Busca empleo", "Dueña de Casa",
                        "Jubilado","Estudiante","No sabe-No responde"],
                    datasets: [
                        {
                            label: "",
                            backgroundColor:  ['#FF7043', '#FFA726', '#FFCA28', '#FFEE58', '#D4E157', '#9CCC65 ',
                                '#26A69A'],
                            data: dataLaboral
                        },
                    ]
                }
            },
            //

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