<template>
    <div id="listaPaketa">
        <h1>PROMOTIVNI PAKETI</h1>
        <div class="around">
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-12 col-lg-6" v-for="paket in sviPaketi" :key="paket.id">
                    <Paket :pk="paket"></Paket>
                </div>

            </div>
        </div>
    </div>
</template>

<style>
#listaPaketa {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 50px;
}

#listaPaketa h1 {
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

@media (min-width: 1350px) {
    .col-lg-6 {
        width: 33.33% !important;
    }
}
</style>

<script>
import Paket from '../components/Paket.vue';
import paketi from '../data/paketi.js'

export default {
    name: 'ListaPaketa',
    components: {
        Paket
    },
    data() {
        return {
            sviPaketi: paketi
        }
    }
}
</script>