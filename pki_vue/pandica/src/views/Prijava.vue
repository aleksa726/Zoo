<template>
    <div id="prijava">
        <NavigacijaPrijava></NavigacijaPrijava>
        <h1>PRIJAVA</h1>
        <div class="prijava2">
            <div class="labele">
                <span>KORISNICKO IME</span>
                <span style="margin-top: 60px;">LOZINKA</span>
            </div>
            <div class="polja">
                <input type="text" v-model="korime">
                <input type="password" style="margin-top: 50px;" v-model="lozinka">
            </div>
        </div>
        <span v-if="greska" class="greska">Pogresno korisnicko ime ili lozinka!</span>
        <br>
        <button @click="prijava()">PRIJAVI SE</button>
    </div>
</template>


<style>
#prijava {
    background-image: url(../assets/tiger.jpg);
    background-size: cover;
    box-shadow: inset 0 0 0 1000px rgba(0, 0, 0, .7);
    height: 980px
}

#prijava h1 {
    color: white;
    margin-top: 150px;
    letter-spacing: 1.5px;
    font-size: 42px;
}

.labele {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: left;
    text-align: left;
    color: white;
    font-size: 28px;
    letter-spacing: 1.5px;
    font-weight: 200;
    margin-right: 50px;
}

.prijava2 {
    display: flex;
    flex-direction: row;
    justify-content: center;
    height: 300px;
}

.polja {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: left;
}

.polja input {
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

#prijava button {
    margin-top: 20px !important;
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
    outline: none;

}

.greska {
    color: red;
    font-style: italic;
    font-size: 28px;
    margin-top: -50px !important;
}

@media (max-width: 650px) {
    #prijava button {
        width: 200px;
        margin-top: 0px !important;
    }

    .polja input {
        font-size: 18px;
        width: 250px;
    }

    .labele {
        font-size: 24px;
    }

    #prijava h1 {
        font-size: 36px;
    }
}
</style>

<script>
import NavigacijaPrijava from '../components/NavigacijaPrijava.vue';
import korisnici from '../data/korisnici.js'

export default {
    name: "Prijava",
    components: {
        NavigacijaPrijava
    },
    data() {
        return {
            korime: '',
            lozinka: '',
            greska: false
        }
    },
    methods: {
        prijava() {
            let korisnici = JSON.parse(localStorage.getItem('korisnici'))
            let korisnik = korisnici.find(kor => kor.korime == this.korime && kor.lozinka == this.lozinka);
            if (korisnik == null) {
                this.greska = true
                return
            }

            localStorage.setItem('korisnik', JSON.stringify(korisnik))
            if (korisnik.tip == 1) {
                // zaposleni
                this.$router.push('zaposleni')
            }
            else {
                this.$router.push('paketi')
            }
        }
    },
    mounted() {
        if (localStorage.getItem('korisnici') == null) {
            localStorage.setItem('korisnici', JSON.stringify(korisnici))
        }
    }
}
</script>