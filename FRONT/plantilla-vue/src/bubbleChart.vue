<template>
    <div>
        <br>

        <label>Gráfico Burbujas:</label>
        <br><br>
        <hr>
        <br><br>

        <div style="width:80%; float:left;">
            <vue-chart v-if="this.bubbleData !== null" type="bubble" :data="this.bubbleData"></vue-chart>
            <div v-else>
                <div class="lds-css ng-scope">
                    <div style="width:100%;height:100%" class="lds-bars">
                        <div></div><div></div><div></div><div></div> <div></div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <h1>Descripción:</h1>

            <p> "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
                dolore eu fugiat nulla pariatur."
            </p>
        </div>
    </div>

</template>


<script>
    import VueChart from "vue-chart-js";

    export default {
        props:['datos'],
        name: "App",

        components: {
            VueChart
        },

        data: () => ({
            bubbleData: null,
            clubs: [],
            colores: []


        }),
        mounted(){
            console.log("los datos que recibo son", this.datos);
        },
        created() {
            this.crearBubble();
        },

        methods: {

            /*---------------------------------------------------------------------------------------------------------*/
            /*---------------------------------------------------------------------------------------------------------*/

            genRadio(value){
                if(this._props.datos[value].statistic_r < 0.1){
                    return 5
                }
                else if(this._props.datos[value].statistic_r < 0.2){
                    return 10
                }
                else if(this._props.datos[value].statistic_r < 0.3){
                    return 15
                }
                else if(this._props.datos[value].statistic_r < 0.4){
                    return 20
                }
                else if(this._props.datos[value].statistic_r < 0.5){
                    return 25
                }
                else if(this._props.datos[value].statistic_r < 0.6){
                    return 30
                }
                else if(this._props.datos[value].statistic_r < 0.7){
                    return 35
                }
                else if(this._props.datos[value].statistic_r < 0.8){
                    return 40
                }
                else if(this._props.datos[value].statistic_r < 0.9){
                    return 45
                }
                else if(this._props.datos[value].statistic_r <= 1){
                    return 50
                }
            },

            crearJson(value){
                var colores = ['#FF7043', '#FFA726', '#FFCA28', '#FFEE58', '#D4E157', '#9CCC65 ',
                               '#26A69A', '#26C6DA', '#29B6F6', '#42A5F5', '#5C6BC0', '#3F51B5',
                               '#7E57C2', '#AB47BC', '#EC407A', '#EF9A9A', '#D1C4E9  ']

                var set = [{
                    label: this._props.datos[value].nameClub,
                    backgroundColor: colores[value],
                    pointBackgroundColor: 'white',
                    borderWidth: 1,
                    pointBorderColor: '#249EBF',
                    data: [{
                        x: this._props.datos[value].statistic_x,
                        y: this._props.datos[value].statistic_y,
                        r: this.genRadio(value),
                    }]
                }]
                return set[0]
            },

            crearBubble(){
                this.bubbleData = {
                    labels: ["Promedio de comentarios positivos","Promedio de comentarios negativos"],
                    datasets: []
                }

              /*  this.bubbleData.datasets[0].label.push(this._props.datos[1].nameClub)*/

                for (let i = 1; i < this._props.datos.length; i++) {
                    this.bubbleData.datasets.push(this.crearJson(i))
                }
            },



        }
    };
</script>