<template>

    <div>

        <md-tabs md-sync-route class="md-transparent" md-alignment="fixed">
            <md-tab id="tab-home" md-label="Home" to="/components/tabs/home">
                <div>
                    <img width="150" height="80" src="https://images.vexels.com/media/users/3/145779/isolated/preview/53f7a1777bd2d2c3f8628d745268c5a3-ilustraci-n-del-loro-by-vexels.png">
                    <label>Edición de encuesta por sentimiento</label>
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
                        <md-button v-on:click="buscarPorNom" class="md-raised">Buscar</md-button>
                        <div v-if="mostrarNom == null">
                        </div>
                        <div class="center" v-else>
                            <md-card  v-for="user in mostrarNom">
                                <label>Nombre: {{user.nombre}}</label><br>
                                <label>Correo: {{user.correo}}</label><br>
                                <label>Rol: {{user.rol}}</label>
                            </md-card>
                        </div>
                        <hr>
                        <label>Buscar por el correo:</label>
                        <md-field>
                            <label>Escriba el correo del usuario</label>
                            <md-textarea v-model="buscarCorr"></md-textarea>
                        </md-field>
                        <md-button v-on:click="buscarPorCorr" class="md-raised">Buscar</md-button>
                        <div v-if="mostrarCorr == null">
                        </div>
                        <div class="center" v-else>
                            <md-card  v-for="correo in mostrarCorr">
                                <label>Nombre: {{correo.nombre}}</label><br>
                                <label>Correo: {{correo.correo}}</label><br>
                                <label>Rol: {{correo.rol}}</label>
                            </md-card>
                        </div>


                    </md-card-media>
                </md-card>

            </div>
        </md-tab>

        <md-tab id="tab-favorites" md-label="Añadir Categoria" to="/components/tabs/favorites">
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
                        <div>
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
                                    <md-textarea :id=i v-model="preguntaCate[i]" md-autogrow></md-textarea>
                                </md-field>
                                {{preguntaCate}}
                                <br>
                                <label>Escala:</label>
                                <hr>
                                {{this.preguntass}}
                            </div>
                        </div>

                        <md-button v-on:click="crearJSON" class="md-raised">Aceptar</md-button>
                    </md-card-media>
                </md-card>
            </div>
        </md-tab>

        <md-tab id="tab-preguntas" md-label="Eliminar Preguntas" to="/components/tabs/preguntas">

            <md-card style="width:30%; float: left">
                <md-card-header>
                    <div class="md-title"> Categorías: </div>
                </md-card-header>
                <div v-for="categoria in dataPreguntas">
                    <label>-Numeración de la categoría: {{categoria.ID}}<br>
                        -Nombre de la categoría: {{categoria.nombre}}<br>
                        <md-button  class="md-raised md-accent">Eliminar</md-button> </label>
                    <hr>
                </div>
            </md-card>
            <md-card style="width: 68%; float: right">
                <md-card-header>
                    <div class="md-title"> Edición de categorías: </div>
                </md-card-header>
                <br>
                <label>Seleccione la categoría que desea editar:</label>
                <select>
                    <option  v-for="(elemento, i) in dataPreguntas">
                        {{elemento.nombre}}</option>
                </select>
                <br>
                <br>
                <hr>
                <div>
                    <label>Modifique el nombre de la categoria:</label>
                    <md-field>
                        <label>Nuevo nombre de la categoría</label>
                        <md-textarea v-model="nuevoNombre" md-autogrow></md-textarea>
                    </md-field>
                    <hr>
                    <label>Modifique la descripcion de la categoria:</label>
                    <md-field>
                        <label>Nueva descripción de la categoría</label>
                        <md-textarea v-model="nuevaDescripcion" md-autogrow></md-textarea>
                    </md-field>
                </div>

            </md-card>

        </md-tab>
        </md-tabs>

    </div>



</template>

<script>
    export default {
        props: ['datos'],
        name: "adminEdit",

        data: () => ({

            /*Data del bind*/
            dataUsuarios: null,
            dataPreguntas: null,




                         buscarCorr: null,
                         buscarNom: null,
                         mostrarCorr: [],
                         mostrarNom: [],


            /* variables para armar json */
            nombreCategoria: null,
            description: null,
            escalas: [],
            opciones: [],
            cantPreguntas: null,
            cantPreguntas2: null,
            preguntaCate: [],
            preguntaCate2: [],
            booleanEscala: false,
            booleanOpciones: false,
                     }),

        created() {
            this.dataUsuarios = this.datos[0];
            this.dataPreguntas = this.datos[1];
            this.buscarPorNom();
            this.buscarPorCorr();

        },
        methods : {

            crearJSON() {
                let preguntass = []
                console.log("cantidad de preguntas", this.cantPreguntas)
                for (let i = 0; i < this.cantPreguntas; i++) {
                    console.log("preguntaCate tineeeeee", this.preguntaCate, "y su largooo essss", this.preguntaCate.length);
                    if (this.preguntaCate[i] != null && this.preguntaCate2.length == 0) {
                        //preguntaCate2 son escalas
                        console.log("entro a este if");
                        var variable = {
                            idpregunta: i,
                            pregunta: this.preguntaCate[i],
                            opciones: this.opciones,
                            escala: null
                        }
                        preguntass.push(variable)
                    }
                    else if(this.preguntaCate2[i] != null && this.preguntaCate.length == 0){
                        console.log("entro a este else if");
                        var variable = {
                            idpregunta: i,
                            pregunta: this.preguntaCate[i],
                            opciones: null,
                            escala: this.escalas
                        }
                        preguntass.push(variable)
                    }
                    else{
                        console.log("No se puede añadir esta categoría")
                    }
                }
                console.log("quiero añadir", preguntass)

                this.json = {
                    ID: 19,
                    nombre: this.nombreCategoria,
                    descripcion: this.description,
                    preguntas: preguntass
                }


                console.log("jsooooooooooooon", this.json)

                this.$http.post('http://localhost:8092/categories/', this.json).then((response) => {
                    console.log("Hice el post")
                }, (response) => {
                    console.log("Fallo servicio")
                });
            },



            buscarPorNom(){

                for (let i=0; i<this.dataUsuarios.length; i++){
                    if(this.dataUsuarios[i].nombre.includes(this.buscarNom)){
                        this.mostrarNom.push(this.dataUsuarios[i])
                    }
                }

            },

            buscarPorCorr(){

                for (let i=0; i<this.dataUsuarios.length; i++){
                    if(this.dataUsuarios[i].correo.includes(this.buscarCorr)){
                        this.mostrarCorr.push(this.dataUsuarios[i])
                    }
                }

            }
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