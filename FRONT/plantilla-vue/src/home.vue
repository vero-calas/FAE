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
                                <div class="md-title">Datos interesantes: </div>
                            </md-card-header>

                            <md-card-content>
                                <br>
                                <i class="material-icons">face</i>Contador de visitas: 13
                                <hr>

                                <i class="material-icons">thumb_up_alt</i>Contador de respuestas: 4
                                <hr>

                            </md-card-content>
                            <md-card-header>
                                <div class="md-title">Turismo en Chile: </div>
                            </md-card-header>

                            <md-card-content>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                                et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                aliquip ex ea commodo consequat.
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
                        <md-card>
                            <md-card-header>
                                <div class="md-title"> ¿Quiénes somos? </div>
                            </md-card-header>
                            <md-card-content>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                                et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                aliquip ex ea commodo consequat.
                            </md-card-content>
                        </md-card>

                        <md-card>
                            <md-card-header>
                                <div class="md-title"> Información general </div>
                            </md-card-header>
                            <md-card-content>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                                et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                aliquip ex ea commodo consequat.
                            </md-card-content>
                        </md-card>

                        <md-card>
                            <md-card-header>
                                <div class="md-title"> </div>
                            </md-card-header>
                            <md-card-content>
                                <img  class="img-responsive" src="https://images.sipse.com/XcKdUIMJr5cgvgtxW2HW6TXjm4g=/800x497/smart/2018/04/25/1524624771669.jpg">
                            </md-card-content>
                        </md-card>
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
                    <label>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                        aliquip ex ea commodo consequat.</label>
                     </md-card-content>
                    </md-card>
                    <md-card class="card">
                        <md-card-header>
                            <div class="md-title">Objetivos: </div>
                        </md-card-header>
                        <md-card-content>
                            <label>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                                et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                aliquip ex ea commodo consequat.</label>
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
                                <label> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                                    et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                    aliquip ex ea commodo consequat. </label>
                                <label><i class="material-icons">call</i> +569 0000000 </label>
                                <label><i class="material-icons">mail_outline</i> ejemplo@ejemplo.cl </label>
                                <label><i class="material-icons">public</i> https: facebook </label>
                            </md-card-content>
                        </md-card>
                    </div>
                </div>


            </md-tab>

            <md-tab id="tab-favorites" md-label="Responder encuesta" to="/components/tabs/favorites">

                <div>
                    <md-steppers md-vertical>

                        <!--                          PRIMERA ETAPA DE ENCUESTA                                        -->
                        <!--                          **************************                                       -->

                        <md-step id="primero" md-label="Preguntas generales" md-description="Preguntas generales destinadas a la realización de estadísticas">

                        </md-step>

                        <!--                          SEGUNDA ETAPA DE ENCUESTA                                        -->
                        <!--                          **************************                                       -->
                        <md-step id="segundo" md-label="Familiaridad" md-description="Preguntas referentes al nivel de socialización alcanzado en el lugar visitado">
                            <br>
                            <label> Por favor, responda según su opinión </label>
                            <br>
                            <div>
                                <label>Elija el nivel de familiaridad del lugar:</label>
                                <div>
                                    <md-radio v-model="satisPersonas" value="1">Muy alto</md-radio>
                                    <md-radio v-model="satisPersonas" value="2">Alto</md-radio>
                                    <md-radio v-model="satisPersonas" value="3">Medio</md-radio>
                                    <md-radio v-model="satisPersonas" value="4">Bajo</md-radio>
                                    <md-radio v-model="satisPersonas" value="5">Muy bajo</md-radio>
                                    <small>Valor de la elección: {{ satisPersonas }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Elija el nivel de reputación del lugar:</label>
                                <div>
                                    <md-radio v-model="reputacion" value="1">Muy alto</md-radio>
                                    <md-radio v-model="reputacion" value="2">Alto</md-radio>
                                    <md-radio v-model="reputacion" value="3">Medio</md-radio>
                                    <md-radio v-model="reputacion" value="4">Bajo</md-radio>
                                    <md-radio v-model="reputacion" value="5">Muy bajo</md-radio>
                                    <small>Valor de la elección: {{ reputacion }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Los habitantes de este lugar son honestos:</label>
                                <div>
                                    <md-radio v-model="habitantes" value="1">Totalmente de acuerdo</md-radio>
                                    <md-radio v-model="habitantes" value="2">De acuerdo</md-radio>
                                    <md-radio v-model="habitantes" value="3">Indiferente</md-radio>
                                    <md-radio v-model="habitantes" value="4">En desacuerdo</md-radio>
                                    <md-radio v-model="habitantes" value="5">Totalmente en desacuerdo</md-radio>
                                    <small>Valor de la elección: {{ habitantes }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Los instituciones públicas de este lugar son honestas:</label>
                                <div>
                                    <md-radio v-model="instpublic" value="1">Totalmente de acuerdo</md-radio>
                                    <md-radio v-model="instpublic" value="2">De acuerdo</md-radio>
                                    <md-radio v-model="instpublic" value="3">Indiferente</md-radio>
                                    <md-radio v-model="instpublic" value="4">En desacuerdo</md-radio>
                                    <md-radio v-model="instpublic" value="5">Totalmente en desacuerdo</md-radio>
                                    <small>Valor de la elección: {{ instpublic }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Los instituciones privadas de este lugar son honestas:</label>
                                <div>
                                    <md-radio v-model="instPriv" value="1">Totalmente de acuerdo</md-radio>
                                    <md-radio v-model="instPriv" value="2">De acuerdo</md-radio>
                                    <md-radio v-model="instPriv" value="3">Indiferente</md-radio>
                                    <md-radio v-model="instPriv" value="4">En desacuerdo</md-radio>
                                    <md-radio v-model="instPriv" value="5">Totalmente en desacuerdo</md-radio>
                                    <small>Valor de la elección: {{ instPriv }}</small>
                                </div>
                            </div>
                        </md-step>

                        <!--                          TERCERA ETAPA DE ENCUESTA                                        -->
                        <!--                          **************************                                       -->
                        <md-step id="tercero" md-label="Entorno" md-description="Preguntas referentes al nivel de comodidad y adaptación en el lugar visitado">
                            <br>
                            <label> Por favor, responda según su opinión </label>
                            <br>
                            <div>
                                <label>En este lugar las instalaciones son modernas y seguras:</label>
                                <div>
                                    <md-radio v-model="instalaciones" value="1">Totalmente de acuerdo</md-radio>
                                    <md-radio v-model="instalaciones" value="2">De acuerdo</md-radio>
                                    <md-radio v-model="instalaciones" value="3">Indiferente</md-radio>
                                    <md-radio v-model="instalaciones" value="4">En desacuerdo</md-radio>
                                    <md-radio v-model="instalaciones" value="5">Totalmente en desacuerdo</md-radio>
                                    <small>Valor de la elección: {{ instalaciones }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Este lugar es entretenido:</label>
                                <div>
                                    <md-radio v-model="entretencion" value="1">Totalmente de acuerdo</md-radio>
                                    <md-radio v-model="entretencion" value="2">De acuerdo</md-radio>
                                    <md-radio v-model="entretencion" value="3">Indiferente</md-radio>
                                    <md-radio v-model="entretencion" value="4">En desacuerdo</md-radio>
                                    <md-radio v-model="entretencion" value="5">Totalmente en desacuerdo</md-radio>
                                    <small>Valor de la elección: {{ entretencion }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Este lugar me relaja:</label>
                                <div>
                                    <md-radio v-model="relajacion" value="1">Totalmente de acuerdo</md-radio>
                                    <md-radio v-model="relajacion" value="2">De acuerdo</md-radio>
                                    <md-radio v-model="relajacion" value="3">Indiferente</md-radio>
                                    <md-radio v-model="relajacion" value="4">En desacuerdo</md-radio>
                                    <md-radio v-model="relajacion" value="5">Totalmente en desacuerdo</md-radio>
                                    <small>Valor de la elección: {{ relajacion }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label> A este lugar viene gente similar a mí:</label>
                                <div>
                                    <md-radio v-model="gente" value="1">Totalmente de acuerdo</md-radio>
                                    <md-radio v-model="gente" value="2">De acuerdo</md-radio>
                                    <md-radio v-model="gente" value="3">Indiferente</md-radio>
                                    <md-radio v-model="gente" value="4">En desacuerdo</md-radio>
                                    <md-radio v-model="gente" value="5">Totalmente en desacuerdo</md-radio>
                                    <small>Valor de la elección: {{ gente }}</small>
                                </div>
                            </div>

                        </md-step>

                        <!--                          CUARTA ETAPA DE ENCUESTA                                        -->
                        <!--                          **************************                                      -->
                        <md-step id="cuarto" md-label="Satsifacción" md-description="Preguntas eferentes al nivel de satisfacción y disfrute del lugar visitado">
                            <br>
                            <label> Por favor, responda según su opinión </label>
                            <br>
                            <div>
                                <label>Este lugar es satisfactorio:</label>
                                <div>
                                    <md-radio v-model="satisfaccion" value="1">Totalmente de acuerdo</md-radio>
                                    <md-radio v-model="satisfaccion" value="2">De acuerdo</md-radio>
                                    <md-radio v-model="satisfaccion" value="3">Indiferente</md-radio>
                                    <md-radio v-model="satisfaccion" value="4">En desacuerdo</md-radio>
                                    <md-radio v-model="satisfaccion" value="5">Totalmente en desacuerdo</md-radio>
                                    <small>Valor de la elección: {{ satisfaccion }}</small>
                                </div>
                            </div>
                        </md-step>

                        <!--                          QUINTA ETAPA DE ENCUESTA                                        -->
                        <!--                          **************************                                      -->
                        <md-step id="quinto" md-label="Datos Personales" md-description="Queremos saber un poco de ti, toda tu información estará protegida">
                            <br>
                            <label> Por favor, rellene todos los campos, sus datos se mantendrán confidenciales. </label>
                            <br>
                            <!--                              elemento                                          -->
                            <div>
                                <label>Elija su género:</label>
                                <div>
                                    <md-radio v-model="gender" value="M">Mujer</md-radio>
                                    <md-radio v-model="gender" value="H">Hombre</md-radio>
                                    <md-radio v-model="gender" value="X">Otro</md-radio>
                                    <small>Valor de la elección: {{ gender }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label> Ciudad de origen: </label>
                                <md-autocomplete v-model="selectedCountry" :md-options="countries" :md-open-on-focus="false">
                                    <label>Escriba o elija una opción</label>
                                </md-autocomplete>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Elija su estado civil:</label>
                                <div>
                                    <md-radio v-model="estadoCivil" value="S">Soltero</md-radio>
                                    <md-radio v-model="estadoCivil" value="C">Casado</md-radio>
                                    <md-radio v-model="estadoCivil" value="X">Otro</md-radio>
                                    <small>Valor de la elección: {{ estadoCivil }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Seleccione su nivel de estudios:</label>
                                <div>
                                    <md-radio v-model="estudios" value="X">Sin estudios</md-radio>
                                    <md-radio v-model="estudios" value="B">Básico</md-radio>
                                    <md-radio v-model="estudios" value="M">Medio</md-radio>
                                    <md-radio v-model="estudios" value="T">Técnico</md-radio>
                                    <md-radio v-model="estudios" value="U">Universitario</md-radio>
                                    <small>Valor de la elección: {{ estudios }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Mi edad se encuentra entre:</label>
                                <div>
                                    <md-radio v-model="edad" value="A">Menor de 18 años</md-radio>
                                    <md-radio v-model="edad" value="B">18 y 30 años</md-radio>
                                    <md-radio v-model="edad" value="C">31 y 40 años</md-radio>
                                    <md-radio v-model="edad" value="D">Mayor de 40 años</md-radio>
                                    <small>Valor de la elección: {{ edad }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Mi nivel de ingresos es:</label>
                                <div>
                                    <md-radio v-model="ingresos" value="A">Menor a $1 millón</md-radio>
                                    <md-radio v-model="ingresos" value="B">Mayor a $1 millón</md-radio>
                                    <md-radio v-model="ingresos" value="X">No respondo</md-radio>
                                    <small>Valor de la elección: {{ ingresos }}</small>
                                </div>
                            </div>
                            <!--                              elemento                                          -->
                            <br>
                            <div>
                                <label>Mi situación laboral es:</label>
                                <div>
                                    <md-radio v-model="laboral" value="A">Trabajo tiempo completo</md-radio>
                                    <md-radio v-model="laboral" value="B">Trabajo tiempo parcial</md-radio>
                                    <md-radio v-model="laboral" value="C">Busco trabajo</md-radio>
                                    <md-radio v-model="laboral" value="D">No vtrabajo</md-radio>
                                    <small>Valor de la elección: {{ laboral }}</small>
                                </div>
                            </div>
                        </md-step>

                    </md-steppers>
                </div>

            </md-tab>
        </md-tabs>




    </div>
</template>

<script>
    export default {
        name: "home",
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