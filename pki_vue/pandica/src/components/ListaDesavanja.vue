<template>
    <div id="listaDesavanja">
        <h1>DESAVANJA</h1>
        <div class="around3">
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-12 col-lg-8" v-for="desavanje in svaDesavanja" :key="desavanje.id">
                    <Desavanje :ds="desavanje"></Desavanje>
                </div>

            </div>
        </div>
    </div>
</template>

<style>
#listaDesavanja {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    margin: auto;
}

#listaDesavanja h1 {
    margin-top: 80px;
    color: white !important;
    font-size: 36px;
    margin-bottom: 50px;
    letter-spacing: 1.5px;
    font-weight: 400;
}

.around3 {
    width: 85%;
}
</style>

<script>
import Desavanje from '../components/Desavanje.vue';
import desavanja from '../data/desavanja.js'

export default {
    name: 'ListaDesavanja',
    components: {
        Desavanje
    },
    data() {
        return {
            svaDesavanja: []
        }
    },
    mounted() {
        if (localStorage.getItem('desavanja') != null) {
            this.svaDesavanja = JSON.parse(localStorage.getItem('desavanja'))
        }
        else {
            this.svaDesavanja = desavanja;
            localStorage.setItem('desavanja', JSON.stringify(this.svaDesavanja))
        }
    }
}
</script>