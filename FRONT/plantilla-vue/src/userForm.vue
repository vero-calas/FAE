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
                <div>

                </div>
                <md-step v-model="array" v-if="i!==15" :key="i" :value="i" v-for="(categoria,i) in datos" :id="datos[i].id"  :md-label="datos[i].nombre"  :md-description="datos[i].descripcion" >
                    <br>
                    <label> Por favor, responda según su opinión </label>
                    <br>
                    <div v-model="array2" v-if="j!==15" :key="j" :value="j" v-for="(preguntas,j) in categoria.preguntas">
                        <label> {{ preguntas.pregunta }} </label>
                        <div>
                            <md-radio v-model="satisPersonas" v-if="k!==8" :key="k" :value="k" v-for="(escala,k) in preguntas.escala">{{preguntas.escala[k]}}</md-radio>

                        </div>
                    </div>

                </md-step>
{{satisPersonas}}dsgfsdg


            </md-steppers>
        </div>

    </div>
</template>

<script>
    export default {
        props: ['datos'],
        name: 'userForm',
        data: () => ({

            satisPersonas: [],
            array:[],
            array2:null
        })
    }
</script>

