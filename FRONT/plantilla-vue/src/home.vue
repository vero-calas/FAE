<template>
    <div>
        <carousel :per-page="1">
            <slide>
                <img class="ImageCarousel" src="https://www.wendywutours.co.uk/resource/upload/230/countrychile.jpg">
             </slide>
            <slide>
                <img class="ImageCarousel" src="http://www.educacionadventista.com/wp-content/uploads/2017/08/Chile-1920x600.jpg">
            </slide>
            <slide>
                <img class="ImageCarousel" src="https://www.wendywutours.com.au/resource/upload/1638/chile-top-toe-banner.jpg">
            </slide>
        </carousel>
        <br> <br>
        <md-content class="md-primary">¿Quienes Somos?<br>
            Somos una empresa que encuesta y analiza la opinión de los turistas en varios aspectos sobre la región o ciudad que está o ha visitado.
        </md-content>


        <md-content class="md-primary">Gráficos: <br>
            Podrás encontrar las estadísticas de las valoraciones sobre la confianza, satisfacción, familiaridad, entre otras.
        </md-content>


        <md-content class="md-primary">Encuesta: <br>
            Se encuestan a los turistas sobre los distintos ámbitos de su estancia en Chile.
        </md-content>

        <md-content class="md-primary">¿Para que sirven? <br>
            Son útiles para realizar distintos estudios y análisis con la finalidad de poder mejorar. 
        </md-content>

    </div>
</template>

<script>
    export default {
        name: "home",
    }

</script>

<style scoped>
    .ImageCarousel{
        max-width: 100%;
        height: 300px;
        position: relative;
        display:block;
        margin: auto;
    }
    .md-content {
        width: 400px;
        height: 300px;
        display: inline-flex;
        justify-content: center;
        align-items: center;
        position: relative;
        margin: 23px;

    }
    /* Color del cuadrado primary */
    .md-content.md-theme-default.md-primary {
        background-color: rgba(90, 109, 111, 0.3);
        color: #5d5d5d;
        font-size: 17px;
    @import url('https://fonts.googleapis.com/css?family=Francois+One');
        font-family: 'Francois One', sans-serif;
    }
</style>