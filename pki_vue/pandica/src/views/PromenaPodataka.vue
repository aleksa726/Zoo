<template >
    <div>
        <NavigacijaZaposleni v-if="this.zaposleni"></NavigacijaZaposleni>
        <Navigacija v-if="!this.zaposleni"></Navigacija>
        <br>
        <div style="min-height: 800px;" class="moji_podaci">
            <NavigacijaProfila></NavigacijaProfila>
            <div class="podaci">
                <h2>PROMENA PODATAKA</h2>
                <div class="tabela">
                    <div class="levo">
                        <span>KORISNICKO IME:</span>
                        <span>IME:</span>
                        <span>PEZIME:</span>
                        <span>KONTAKT TELEFON:</span>
                        <span>ADRESA:</span>
                    </div>
                    <div class="desno">
                        <input type="text" v-model="korisnik.korime">
                        <input type="text" v-model="korisnik.ime">
                        <input type="text" v-model="korisnik.prezime">
                        <input type="text" v-model="korisnik.telefon">
                        <input type="text" v-model="korisnik.adresa">
                    </div>
                </div>
                <button @click="sacuvaj()">SACUVAJ</button>
            </div>
        </div>
    </div>
</template>

<style>
.desno input {
    margin-top: 25px;
    padding: 5px;
    padding-left: 10px;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    border: none;
    outline: none;
}

.moji_podaci button {
    margin-top: 20px;
    width: 18%;
    height: 60px;
    font-size: 22px;
    border-radius: 10px;
    box-shadow: 1px 2px 3px 0px rgba(0, 0, 0, 0.4);
    background-color: #59C4DC;
    border: none;
    margin: auto;
}
</style>

<script>
import NavigacijaProfila from '../components/NavigacijaProfila.vue';
import Navigacija from '../components/Navigacija.vue'
import NavigacijaZaposleni from '../components/NavigacijaZaposleni.vue'

export default {
    name: "PromenaPodataka",
    components: {
        NavigacijaProfila,
        Navigacija,
        NavigacijaZaposleni
    },
    data() {
        return {
            korisnik: [],
            zaposleni: false
        }
    },
    mounted() {
        let korisnik = JSON.parse(localStorage.getItem('korisnik'))
        if (korisnik.tip == 1) {
            this.zaposleni = true
        }
        this.korisnik = JSON.parse(localStorage.getItem('korisnik'))
    },
    methods: {
        sacuvaj() {
            let ulogovanKorisnik = JSON.parse(localStorage.getItem('korisnik'))
            let korisnici = JSON.parse(localStorage.getItem('korisnici'))
            for (var i = 0; i < korisnici.length; i++) {
                if (korisnici[i].korime === ulogovanKorisnik.korime) {
                    korisnici.splice(i, 1);
                }
            }
            korisnici.push(this.korisnik)
            localStorage.setItem('korisnici', JSON.stringify(korisnici))
            localStorage.setItem('korisnik', JSON.stringify(this.korisnik))
            this.$router.push('mojprofil')
        }
    }
}
</script>