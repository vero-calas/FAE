<template>
    <div>

        <md-tabs md-sync-route class="md-transparent" md-alignment="fixed">
            <md-tab id="tab-home" md-label="Home" to="/components/tabs/home">
                <div>
                    <!-- Carousel -->
                    <div style="float: left; width: 70%">
                        <div id="carouselExampleIndicators" class="carousel slide container" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active" >
                                    <img class="d-block w-100" src="https://www.wendywutours.co.uk/resource/upload/230/countrychile.jpg" alt="grafico" style="width: 200px; height:700px; margin: 0 auto">
                                    <div class="carousel-caption">
                                        <h2>Norte</h2>
                                        <h3>Visita el norte de Chile</h3>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="http://www.educacionadventista.com/wp-content/uploads/2017/08/Chile-1920x600.jpg" alt="mapas" style="width: 200px; height:700px; margin: 0 auto">
                                    <div class="carousel-caption">
                                        <h2>Centro</h2>
                                        <h3>
                                            Visita el centro de Chile
                                        </h3>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="https://www.wendywutours.com.au/resource/upload/1638/chile-top-toe-banner.jpg" alt="grafo" style="width: 200px; height:700px; margin: 0 auto">
                                    <div class="carousel-caption">
                                        <h2>Sur</h2>
                                        <h3>Visita el sur de Chile
                                        </h3>
                                    </div>
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev" style="border-bottom-color: black">
                                <span class="glyphicon glyphicon-chevron-left fa-4x" aria-hidden="true"></span>
                                <span class="sr-only">Anterior</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right fa-4x" aria-hidden="true"></span>
                                <span class="sr-only">Siguiente</span>
                            </a>
                        </div>

                    </div>

                    <div style="float: right; width: 30%">
                        <md-card>
                            <md-card-header>
                                <div class="md-title">Turismo en Chile: </div>
                            </md-card-header>

                            <md-card-content>
                                La World Travel Awards por cuarto año consecutivo ha elegido a Chile como el mejor destino de turismo aventura de Sudamérica 2018. Sin duda, este reiterado reconocimiento internacional es una gran oportunidad como país, para ofrecer y cristalizar una atención sobresaliente a los turistas que nos visitan y construir una imagen como destino turístico de nivel internacional.  Si bien, las características geográficas de Chile (desiertos, montañas y lagos, playas y mar) son un gran estímulo para los visitantes, esto por sí solo no basta para construir una experiencia única y diferente para el turista. Es necesario gestionar un proceso sinérgico a partir del complemento del sector público y el sector privado, única manera de ofrecer servicios turísticos integrales a los visitantes. En este contexto, por un lado, hoteles, restaurantes, comercios y medios de transporte y telecomunicaciones y por otro, oficinas de servicios de turismo, municipalidades, guarda parqués, incluso los propios habitantes, juegan un rol gravitante en la construcción de esta imagen como destino turístico internacional.
                                <hr>
                                <img  class="img-responsive" src="https://images.sipse.com/XcKdUIMJr5cgvgtxW2HW6TXjm4g=/800x497/smart/2018/04/25/1524624771669.jpg">

                            </md-card-content>

                        </md-card>
                    </div>
                    <div><br><br><md-card>
                    </md-card><br><br></div>


                    <div style="width: 10%">
                        <md-card>
                        </md-card>
                    </div>

                    <div>
                        <div style="float: right; width: 40%">
                            <md-card>
                                <md-card-header>
                                    <div class="md-title"> Información general </div>
                                </md-card-header>
                                <md-card-content>
                                    e-ematur surge como resultado de la tesis doctoral denominada: “Confianza hacia los Destinos Turísticos. El rol de la Imagen, sus habitantes e Instituciones”. Este estudio fue presentado en el marco del Programa de Doctorado en Ciencias Empresariales impartido por la Facultad de Ciencias Económicas y Empresariales de la Universidad Autónoma de Madrid, España. Cabe destacar que este trabajo de investigación fue calificado como “Sobresaliente Cum Laude”,
                                    siendo esta la máxima calificación que se puede obtener en España.
                                </md-card-content>
                            </md-card>
                        </div>
                        <div>
                            <md-card>
                                <md-card-header>
                                    <div class="md-title"> ¿Quiénes somos? </div>
                                </md-card-header>
                                <md-card-content>
                                    e-ematur es un servicio de medición online de percepciones pionero en el área del marketing turístico.  Es un servicio innovador que permite la detección temprana, prevención, diagnóstico y tratamiento de un débil posicionamiento de imagen logrado por un destino turístico.
                                </md-card-content>
                            </md-card>
                        </div>

                    </div>
                </div>
            </md-tab>

            <md-tab id="tab-pages" md-label="¿Quiénes Somos?" to="/components/tabs/pages">
                <div>
                    <md-card-content style="float: left; width: 50%">
                        <img  class="img-responsive" src="https://d1ljaggyrdca1l.cloudfront.net/wp-content/uploads/2017/04/Guanaco-in-Torres-del-Paine-National-Park-Chile-1600x900.jpg">
                    </md-card-content>

                    <div>
                        <md-card class="card">
                            <md-card-header>
                                <div class="md-title">Sobre la empresa: </div>
                            </md-card-header>
                            <md-card-content>
                                <label>e-ematur pretende ser el proveedor líder a nivel mundial de soluciones tecnológicas de marketing para mejorar la percepción de los destinos turísticos. A través de un modelo de suscripción predecible y asequible, nuestros clientes podrán adquirir y aplicar las mejores estrategias de marketing para posicionar, consolidar y/o recordar la imagen de un destino turístico a nivel internacional, nacional o local. Servicios tecnológicos que serán complementados con asesorías y capacitaciones especializadas dictadas por expertos, en el tratamiento de la imagen de los destinos turísticos.</label>
                            </md-card-content>
                        </md-card>
                    </div>
                </div>


            </md-tab>

            <md-tab id="tab-posts" md-label="Contacto" to="/components/tabs/posts">

                <div>
                    <md-card-content style="float: left; width: 50%">
                        <img  class="img-responsive" src="https://www.rockandpop.cl/wp-content/uploads/2016/10/isla-de-pascua_shutterstok-MZ33.jpg">
                    </md-card-content>

                    <div>
                        <md-card class="card">
                            <md-card-header>
                                <div class="md-title">Información de contacto:</div>
                            </md-card-header>
                            <md-card-content>
                                <label> A su disposición medios de contacto directo:</label>
                                <hr>
                                <label><i class="material-icons">call</i> +56-9-98875670 </label>
                                <hr>
                                <label><i class="material-icons">mail_outline</i> enrique.marinao@gmail.com</label>
                                <hr>
                                <label><i class="material-icons">mail_outline</i> enrique.marinao@usach.cl </label>
                                <hr>
                                <label><i class="material-icons">mail_outline</i> enrique.marinao@e-ematur.cl </label>
                                <!--<label><i class="material-icons">public</i> https: facebook </label>-->
                            </md-card-content>
                        </md-card>
                    </div>
                </div>


            </md-tab>

            <md-tab id="tab-favorites" md-label="Responder encuesta" to="/components/tabs/favorites">

                <div>



                    <div>
                        <!-- opciones  md-vertical, md-horizontal, md-alternative-->

                        <md-steppers md-horizontal>


                            <!--                          SEGUNDA ETAPA DE ENCUESTA                                        -->
                            <!--                          **************************                                       -->
                            <md-step id="0">
                                <div>
                                    <img width="150" height="80" src="https://images.vexels.com/media/users/3/145779/isolated/preview/53f7a1777bd2d2c3f8628d745268c5a3-ilustraci-n-del-loro-by-vexels.png">
                                    <label>Bienvenido a la encuesta sobre el turismo en Chile</label>
                                </div>
                            </md-step>
                            <md-step v-model="array" v-if="i!==20" :key="i" :value="i" v-for="(categoria,i) in datos" :id="datos[i].id">
                                <h1>{{datos[i].nombre}}</h1><br>
                                <label>{{datos[i].descripcion}}</label>
                                <br><label> Por favor, responda según su opinión</label>
                                <hr>
                                <div v-model="array2" v-if="j!==20" :key="j" :value="j" v-for="(preguntas,j) in categoria.preguntas">
                                    <hr>
                                    <label> {{ preguntas.pregunta }} </label>
                                    <div>
                                        <md-radio v-model="form2[i].respuesta[j]" v-if="k!==14" :key="k" :value="k" v-for="(escala,k) in preguntas.escala">
                                            <label v-if="preguntas.escala !== null">
                                                {{preguntas.escala[k]}}
                                            </label>
                                        </md-radio>
                                        <md-radio v-model="form2[i].respuesta[j]" v-if="k!==14" :key="k" :value="k" v-for="(escala,k) in preguntas.opciones">
                                            <label v-if="preguntas.opciones !== null">
                                                {{preguntas.opciones[k]}}
                                            </label>
                                        </md-radio>
                                    </div>
                                </div>
                            </md-step>

                            <md-button class="md-raised md-primary; center">Enviar Respuestas</md-button>

                        </md-steppers>
                    </div>
                </div>
            </md-tab>


            <md-tab id="tab-encuesta2" md-label="Responder encuesta 2" to="/components/tabs/encuesta2">

                <div>



                    <div>
                        <!-- opciones  md-vertical, md-horizontal, md-alternative-->

                        <md-steppers md-horizontal>


                            <!--                          SEGUNDA ETAPA DE ENCUESTA                                        -->
                            <!--                          **************************                                       -->
                            <md-step id="0">
                                <div>
                                    <img width="150" height="80" src="https://images.vexels.com/media/users/3/145779/isolated/preview/53f7a1777bd2d2c3f8628d745268c5a3-ilustraci-n-del-loro-by-vexels.png">
                                    <label>Bienvenido a la encuesta sobre el turismo en Chile</label>
                                </div>
                            </md-step>
                            <md-step v-model="array" v-if="i!==20" :key="i" :value="i" v-for="(categoria,i) in datos" :id="datos[i].id">
                                <h1>{{datos[i].nombre}}</h1><br>
                                <label>{{datos[i].descripcion}}</label>
                                <br><label> Por favor, responda según su opinión</label>
                                <hr>
                                <div v-model="array2" v-if="j!==20" :key="j" :value="j" v-for="(preguntas,j) in categoria.preguntas">
                                    <hr>
                                    <label> {{ preguntas.pregunta }} </label>
                                    <div>
                                        <md-icon class="md-size-2x" style="color: #08e166">
                                            sentiment_very_satisfied
                                        </md-icon>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <md-icon class="md-size-2x" style="color: #fbe246">
                                            sentiment_satisfied
                                        </md-icon>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <md-icon class="md-size-2x" style="color: #fb2514">
                                            sentiment_very_dissatisfied
                                        </md-icon><br>
                                        <md-radio v-model="form2[i].respuesta[j]" v-if="k!==14" :key="k" :value="k" v-for="(escala,k) in preguntas.escala">
                                            <label v-if="preguntas.escala !== null">
                                                {{preguntas.escala[k]}}
                                            </label>
                                        </md-radio>
                                        <md-radio v-model="form2[i].respuesta[j]" v-if="k!==14" :key="k" :value="k" v-for="(escala,k) in preguntas.opciones">
                                            <label v-if="preguntas.opciones !== null">
                                                {{preguntas.opciones[k]}}
                                            </label>
                                        </md-radio>
                                    </div>
                                </div>
                            </md-step>


                        </md-steppers>
                    </div>
                </div>
            </md-tab>
        </md-tabs>




    </div>
</template>

<script>
    export default {
        name: "home",
        props: ['datos'],
        data: () => ({
            form2:[],
            array:[],
            array2:null,
            cantidadCategoria: null
        }),
        created() {
        },
        mounted(){
            this.cantidad();
        },
        methods:{
            cantidad(){
                console.log("la data que llega es", this.datos);
                this.cantidadCategoria = (this._props.datos).length;
                for (let i=0; i<this.cantidadCategoria; i++){
                    let json ={
                        respuesta: []
                    }
                    this.form2.push(json)
                }
            }
        }
    }
</script>


<style lang="scss" scoped>
    .carousel-item{
        height: 480px;
    }
    .card-expansion {
        height: 480px;
    }
    .md-card {
        width: 320px;
        margin: 4px;
        display: inline-block;
        vertical-align: top;
    }
    .center {
        display: block;
        margin-left: auto;
        margin-right: auto;
        width: 20%;
    }
    .ImageCarousel{
        max-width: 100%;
        height: 300px;
        position: relative;
        display: block;
        margin: auto;
    }
    .card {
        width: 40%;
        margin: 4px;
        display: inline-block;
        vertical-align: top;
    }
</style>