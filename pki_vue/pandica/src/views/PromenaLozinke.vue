<template >
    <div>
        <NavigacijaZaposleni v-if="this.zaposleni"></NavigacijaZaposleni>
        <Navigacija v-if="!this.zaposleni"></Navigacija>
        <br>
        <div style="min-height: 800px;" class="moji_podaci">

            <NavigacijaProfila></NavigacijaProfila>
            <div class="podaci">
                <h2>PROMENA LOZINKE</h2>
                <div class="tabela">
                    <div class="levo">
                        <span>STARA LOZINKA</span>
                        <span>NOVA LOZINKA</span>
                    </div>
                    <div class="desno">
                        <input type="password" v-model="staraLozinka">
                        <input type="password" v-model="novaLozinka">
                    </div>
                </div>
                <button @click="sacuvaj()">SACUVAJ</button>
            </div>
        </div>
    </div>
</template>

<style>
.desno input {
    padding: 5px;
    padding-left: 10px;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    border: none;
    outline: none;
}

.moji_podaci button {
    margin-top: 70px !important;
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
    name: "PromenaLozinke",
    components: {
        NavigacijaProfila,
        Navigacija,
        NavigacijaZaposleni
    },
    data() {
        return {
            staraLozinka: "",
            novaLozinka: "",
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
            if (this.korisnik.lozinka == this.staraLozinka) {
                let ulogovanKorisnik = JSON.parse(localStorage.getItem('korisnik'))
                let korisnici = JSON.parse(localStorage.getItem('korisnici'))
                for (var i = 0; i < korisnici.length; i++) {
                    if (korisnici[i].korime === ulogovanKorisnik.korime) {
                        korisnici.splice(i, 1);
                    }
                }
                this.korisnik.lozinka = this.novaLozinka;
                korisnici.push(this.korisnik)
                localStorage.setItem('korisnici', JSON.stringify(korisnici))
                localStorage.setItem('korisnik', JSON.stringify(this.korisnik))
                this.$router.push('mojprofil')
            }
            else {
                alert("Stara lozinka nije ispravna!")
            }
        }
    }
}
</script>