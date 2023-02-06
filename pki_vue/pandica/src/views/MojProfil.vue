<template>
    <div class="mojprofil">
        <NavigacijaZaposleni v-if="this.zaposleni"></NavigacijaZaposleni>
        <Navigacija v-if="!this.zaposleni"></Navigacija>
        <br>
        <MojiPodaci></MojiPodaci>
    </div>
</template>


<script>
import MojiPodaci from '../components/MojiPodaci.vue'
import Navigacija from '../components/Navigacija.vue'
import NavigacijaZaposleni from '../components/NavigacijaZaposleni.vue'


export default {
    name: "MojProfil",
    components: {
        MojiPodaci,
        Navigacija,
        NavigacijaZaposleni
    },
    data() {
        return {
            zaposleni: false
        }
    },
    mounted() {
        let korisnik = JSON.parse(localStorage.getItem('korisnik'))
        if (korisnik.tip == 1) {
            this.zaposleni = true
        }
    }
}
</script>
