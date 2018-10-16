<style scoped>

    .md-tabs.md-theme-default.md-transparent .md-tabs-navigation {
        background-color: #bcf100;
    }
</style>

<template>

    <div>



        <div>
            <md-steppers md-vertical>


                <!--                          SEGUNDA ETAPA DE ENCUESTA                                        -->
                <!--                          **************************                                       -->
                <md-step id=0  :md-label="Bienvenido"  :md-description="Miau">
                    <label>Bienvenido a la encuesta sobre el turismo en Chile</label>
                </md-step>
                <md-step v-model="array" v-if="i!==20" :key="i" :value="i" v-for="(categoria,i) in datos" :id="datos[i].id"  :md-label="datos[i].nombre"  :md-description="datos[i].descripcion" >
                    <br>
                    <label> Por favor, responda según su opinión </label>
                    <br>
                    <div v-model="array2" v-if="j!==20" :key="j" :value="j" v-for="(preguntas,j) in categoria.preguntas">
                        <hr>
                        <label> {{ preguntas.pregunta }} </label>
                        <div>
                            <md-radio v-model="form.respuesta[j]" v-if="k!==14" :key="k" :value="k" v-for="(escala,k) in preguntas.escala">
                                <label v-if="preguntas.escala !== null">
                                    {{preguntas.escala[k]}}
                                </label>
                            </md-radio>
                            <md-radio v-model="form.respuesta[j]" v-if="k!==14" :key="k" :value="k" v-for="(escala,k) in preguntas.opciones">
                                <label v-if="preguntas.opciones !== null">
                                    {{preguntas.opciones[k]}}
                                </label>
                            </md-radio>
                        </div>
                    </div>
{{form}}
                </md-step>


            </md-steppers>
        </div>

    </div>
</template>

<script>
    export default {
        props: ['datos'],
        name: 'userForm',
        data: () => ({

            form:{
                respuesta:[]
            },
            array:[],
            array2:null
        })
    }
</script>

