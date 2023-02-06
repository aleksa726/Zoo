<template>
    <div style="padding-bottom: 50px;">
        <Navigacija></Navigacija>
        <br>
        <div id="detalji">
            <h2>{{ izabranaZivotnja.naziv }}</h2>
            <img :src="require('../assets/' + izabranaZivotnja.slika + '.png')" class="card-img-top" alt="...">
            <p style="margin-top: 40px; width: 65%; font-size: 24px;">{{ izabranaZivotnja.opis }}</p>
            <ListaKomentara></ListaKomentara>
            <div class="potavljanjeKomentara">
                <h2 class="naslov">OSTAVITE KOMENTAR</h2>
                <textarea rows="10" v-model="tekstKomentara"></textarea>
                <br>
                <button class="btn btn-primary" @click="komentarisi()">POSALJI KOMENTAR</button>
            </div>
        </div>
    </div>
</template>


<style>
#detalji {
    margin-top: 70px !important;
    width: 70%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin: auto;
}


#detalji h2 {
    width: 80%;
    font-size: 36px;
    margin: auto;
    font-weight: 400 !important;
    margin-top: 10px;
    color: white;
    letter-spacing: 2px;
}

#detalji img {
    width: 70%;
    margin-top: 50px !important;
    margin: auto;
    object-fit: contain;
    background-color: rgb(218, 218, 218);
    border-radius: 12px;
}

#detalji p {
    margin-top: 40px;
    font-size: 24px;
    color: white;
    width: 65%;
    margin: auto;
    font-weight: 300;
    font-style: italic;
}

.naslov {
    margin-top: 70px !important;
}



.potavljanjeKomentara textarea {
    margin-top: 30px;
    width: 500px;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    resize: none;
    outline: none;
    padding: 15px;
}

.potavljanjeKomentara button {
    margin-top: 20px;
    width: 250px;
    height: 60px;
    font-size: 24px;
    border-radius: 10px;
    box-shadow: 1px 2px 3px 0px rgba(0, 0, 0, 0.4);
    background-color: #59C4DC;
    border: none;
}

@media (max-width: 990px) {
    #detalji img {
        width: 100%;
    }
}

@media (max-width: 700px) {
    #detalji {
        width: 90%;
    }

    #detalji p {
        width: 85% !important;
    }
}
</style>


<script>
import ListaKomentara from '../components/ListaKomentara.vue'
import Navigacija from '../components/Navigacija.vue'
import komentari from '../data/komentari.js'

export default {
    name: 'DetaljiZivotinje',
    components: {
        ListaKomentara,
        Navigacija
    },
    data() {
        return {
            sveZivotinje: [],
            izabranaZivotnja: {},
            tekstKomentara: ''
        }
    },
    mounted() {
        this.sveZivotinje = JSON.parse(localStorage.getItem('zivotinje'))

        let id = Number(this.$route.params.id);
        let zivotinja = this.sveZivotinje.find(zv => zv.id == id);

        this.izabranaZivotnja = zivotinja;

        if (localStorage.getItem('komentari') == null) {
            localStorage.setItem('komentari', JSON.stringify(komentari))
        }
    },
    methods: {
        komentarisi() {
            let korisnik = JSON.parse(localStorage.getItem('korisnik'))
            let sviKomentari = JSON.parse(localStorage.getItem('komentari'))
            sviKomentari.push({
                "idZivotinje": Number(this.$route.params.id),
                "tekst": this.tekstKomentara,
                "korisnik": korisnik.korime
            })
            localStorage.setItem('komentari', JSON.stringify(sviKomentari))
            this.$router.go(0)
        }
    }
}
</script>