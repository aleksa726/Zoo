<template>
    <div id="listaKomentara">
        <h1>KOMENTARI</h1>
        <div class="row justify-content-center komentar">
            <div class="col-sm-10 komentar" v-for="komentar in sviKomentari" :key="komentar.id">
                <Komentar :kom="komentar"></Komentar>
            </div>
        </div>
    </div>
</template>

<style>
#listaKomentara {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 50px;
    width: 80%;
    margin: auto;
}

#listaKomentara h1 {
    margin-top: 100px;
    color: white !important;
    font-size: 36px;
    margin-bottom: 50px;
    letter-spacing: 1.5px;
    font-weight: 400;
}

.komentar {
    widows: 100% !important;
    min-width: 90% !important;
}
</style>

<script>
import Komentar from '../components/Komentar.vue';

export default {
    name: 'ListaKomentara',
    components: {
        Komentar
    },
    data() {
        return {
            sviKomentari: []
        }
    },
    mounted() {
        let idZivotinje = Number(this.$route.params.id);
        let komentari = JSON.parse(localStorage.getItem('komentari'))
        komentari.forEach((kom) => {
            if (kom.idZivotinje == idZivotinje) {
                this.sviKomentari.push(kom)
            }
        })
    }
}
</script>
