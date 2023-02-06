<template>
    <div id="listaZahteva">
        <h1>ZAHTEVI</h1>
        <div class="row justify-content-center" style="min-height: 750px;">
            <div class="col-sm-12 col-md-12 col-lg-7 zaht" v-for="zahtev in zahtevi" :key="zahtev.iznos">
                <Zahtev :za="zahtev"></Zahtev>
            </div>
        </div>
    </div>
</template>

<style>
#listaZahteva {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 50px;
}

#listaZahteva h1 {
    margin-top: 40px;
    color: white !important;
    font-size: 36px;
    margin-bottom: 70px;
    letter-spacing: 1.5px;
    font-weight: 400;
}

.around {
    width: 70%;
    background-color: #F2F2F2;
    border-radius: 16px;
    box-shadow: 2px 6px 18px 2px rgba(0, 0, 0, 0.4);
}

@media (min-width: 990px) {
    .zaht {
        min-width: 1000px;
    }
}

@media (min-width: 1350px) {
    .col-lg-6 {
        width: 33.33% !important;
    }
}
</style>

<script>
import Zahtev from '../components/Zahtev.vue';

export default {
    name: 'ListaZahteva',
    components: {
        Zahtev
    },
    data() {
        return {
            zahtevi: []
        }
    },
    mounted() {
        this.zahtevi = JSON.parse(localStorage.getItem('zahtevi'))
    }
}
</script>