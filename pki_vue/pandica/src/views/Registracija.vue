<template>
    <div id="registracija">
        <NavigacijaRegistracija></NavigacijaRegistracija>
        <h1>REGISTRACIJA</h1>
        <div class="registracija2">
            <div class="labele3">
                <span>KORISNICKO IME</span>
                <span>LOZINKA</span>
                <span>IME</span>
                <span>PREZIME</span>
                <span>ADRESA</span>
                <span>KONTAKT TELEFON</span>
            </div>
            <div class="polja2">
                <input type="text" v-model="korime">
                <input type="password" v-model="lozinka">
                <input type="text" v-model="ime">
                <input type="text" v-model="prezime">
                <input type="text" v-model="adresa">
                <input type="text" v-model="telefon">
            </div>
        </div>
        <span v-if="greska" class="greska">Nisu uneta sva polja!</span>
        <br>
        <button @click="registracija()">REGISTRUJ SE</button>
    </div>
</template>


<style>
#registracija {
    background-image: url(../assets/tiger.jpg);
    background-size: cover;
    box-shadow: inset 0 0 0 1000px rgba(0, 0, 0, .7);
    height: 980px
}

#registracija h1 {
    color: white;
    margin-top: 100px;
    letter-spacing: 1.5px;
    font-size: 42px;
    margin-bottom: 30px;
}

.labele3 {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: left;
    text-align: left;
    color: white;
    font-size: 28px;
    letter-spacing: 1.5px;
    font-weight: 200;
    margin-right: 50px;
}

.registracija2 {
    display: flex;
    flex-direction: row;
    justify-content: center;
    height: 500px;
}

.polja2 {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: left;
}

.polja2 input {
    font-size: 22px;
    width: 350px;
    padding: 10px;
    padding-left: 10px;
    background-color: #f2f2f2a4;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    border: none;
    outline: none;
}

#registracija button {
    margin-top: 50px !important;
    width: 300px;
    height: 60px;
    font-size: 22px;
    border-radius: 10px;
    box-shadow: 1px 2px 3px 0px rgba(0, 0, 0, 0.4);
    background-color: #59C4DC;
    border: none;
    margin: auto;
    color: white;
    font-weight: 100;
    letter-spacing: 1.3px;
}

@media (max-width: 650px) {
    #registracija button {
        width: 200px;
        margin-top: 0px !important;
    }

    .polja2 input {
        font-size: 18px;
        width: 250px;
    }

    .labele2 {
        font-size: 24px;
    }

    #registracija h1 {
        font-size: 36px;
    }
}
</style>

<script>
import NavigacijaRegistracija from '../components/NavigacijaRegistracija.vue';
import korisnici from '../data/korisnici';

export default {
    name: "Registracija",
    components: {
        NavigacijaRegistracija
    },
    data() {
        return {
            korime: "",
            lozinka: "",
            ime: "",
            prezime: "",
            adresa: "",
            telefon: "",
            sviKorisnici: [],
            greska: false
        }
    },
    methods: {
        registracija() {

            if (this.korime == "" || this.lozinka == ""
                || this.ime == "" || this.prezime == ""
                || this.adresa == "" || this.telefon == "") {
                this.greska = true
                return;
            }

            korisnici.push({
                "korime": this.korime,
                "lozinka": this.lozinka,
                "ime": this.ime,
                "prezime": this.prezime,
                "adresa": this.adresa,
                "telefon": this.telefon,
                "tip": 0
            })

            localStorage.setItem('korisnici', JSON.stringify(korisnici));
            this.$router.push('prijava')
        }
    },
    mounted() {
        if (localStorage.getItem('korisnici') != null) {
            this.sviKorisnici = JSON.parse(localStorage.getItem('korisnici'))
        }
        else {
            this.sviKorisnici = korisnici;
        }
    }
}
</script>