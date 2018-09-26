<style scoped>

    .md-tabs.md-theme-default.md-transparent .md-tabs-navigation {
        background-color: #bcf100;
    }
</style>

<template>

    <div>

            <md-tabs md-sync-route class="md-transparent" md-alignment="fixed">
                <md-tab id="tab-home" md-label="Home" to="/components/tabs/home">
                    Home Tab
                </md-tab>

                <md-tab id="tab-pages" md-label="Pages" to="/components/tabs/pages">
                    Pages tab
                    <p>Unde provident nemo reiciendis officia, possimus repellendus. Facere dignissimos dicta quis rem. Aliquam aspernatur dolor atque nisi id deserunt laudantium quam repellat.</p>
                </md-tab>

                <md-tab id="tab-posts" md-label="Posts" to="/components/tabs/posts">
                    Posts tab
                    <p>Qui, voluptas repellat impedit ducimus earum at ad architecto consectetur perferendis aspernatur iste amet ex tempora animi, illum tenetur quae assumenda iusto.</p>
                </md-tab>

                <md-tab id="tab-favorites" md-label="Favorites" to="/components/tabs/favorites">
                    Favorites tab
                    <p>Maiores, dolorum. Beatae, optio tempore fuga odit aperiam velit, consequuntur magni inventore sapiente alias sequi odio qui harum dolorem sunt quasi corporis.</p>
                </md-tab>
            </md-tabs>

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
                            <md-radio v-model="satisPersonas" v-if="k!==8" :key="k" :value="k" v-for="(escala,k) in preguntas.escala" value="k">{{preguntas.escala[k]}}</md-radio>

                        </div>
                    </div>

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
            ],
            array:[],
            array2:null
        })
    }
</script>

