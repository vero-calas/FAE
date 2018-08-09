<template>
    <div>

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

    </div>
</template>

<script>
    export default {
        name: 'userForm',
        data: () => ({
            /* Variables primera etapa */
            gender: false,
            estadoCivil: false,
            estudios: false,
            edad: false,
            ingresos: false,
            laboral: false,
            /* Variables segunda etapa */
            satisPersonas: false,
            reputacion: false,
            habitantes: false,
            instpublic: false,
            instPriv: false,
            /* Variables tercera etapa */
            instalaciones: false,
            entretencion: false,
            relajacion: false,
            gente: false,
            /* Variables cuarta etapa */
            satisfaccion: false,

            selectedCountry: null,
            selectedEmployee: null,
            countries: [
                'Argentina',
                'Brazil',
                'Canada',
                'Italy',
                'Japan',
                'Chile',
                'United Kingdom',
                'United States'
            ]
        })
    }
</script>