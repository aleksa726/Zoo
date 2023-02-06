<template>
    <div id="listaUlaznica">
        <h1>ULAZNICE</h1>
        <div class="around2">
            <div class="row justify-content-center">
                <div class="col-sm-6 col-md-6 col-lg-6" v-for="ulaznica in sveUlaznice" :key="ulaznica.id">
                    <Ulaznica :ul="ulaznica"></Ulaznica>
                </div>

            </div>
        </div>
    </div>
</template>

<style>
#listaUlaznica {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 50px;
    width: 80%;
    margin: auto;
}

#listaUlaznica h1 {
    margin-top: 80px;
    color: white !important;
    font-size: 36px;
    margin-bottom: 50px;
    letter-spacing: 1.5px;
    font-weight: 400;
}

.around2 {
    width: 80%;
}

@media (min-width: 1150px) {
    .col-lg-6 {
        width: 33.33% !important;
    }
}
</style>

<script>
import Ulaznica from '../components/Ulaznica.vue';
import ulaznice from '../data/ulaznice.js'

export default {
    name: 'ListaUlaznica',
    components: {
        Ulaznica
    },
    data() {
        return {
            sveUlaznice: ulaznice
        }
    }
}
</script>