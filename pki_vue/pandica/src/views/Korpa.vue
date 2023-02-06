<template>
    <div>
        <Navigacija></Navigacija>
        <br>
        <div id="korpa" style="min-height: 900px;">
            <h2>KORPA</h2>
            <div class="artikli_iznos">
                <div class="artikli">
                    <div class="col-sm-12" v-for="artikal in artikli" :key="artikal.id">
                        <Artikal :ar="artikal"></Artikal>
                    </div>
                </div>
                <div class="iznos">
                    <div>
                        <span>PROMO KOD</span>
                        <input type="text" @change="handle()" v-model="kod">
                    </div>
                    <div>
                        <span style="margin-left: -15px;">UKUPAN IZNOS:</span>
                        <span style="font-style: italic;">{{ ukupanIznos }} dinara</span>
                    </div>
                </div>
            </div>
            <button @click="kupi()" class="kupibtn">KUPI</button>
        </div>
    </div>
</template>

<style>
#korpa {
    display: flex;
    flex-direction: column;
    justify-content: start;
    align-items: center;
}

#korpa h2 {
    font-size: 36px;
    margin: auto;
    font-weight: 400 !important;
    margin-top: 10px;
    color: white;
    letter-spacing: 2px;
    margin-top: 70px;
    margin-bottom: 50px;
}

.artikli_iznos {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    color: white;
    align-items: center;
}

.artikli_iznos span {
    font-size: 22px;
    font-weight: 100;
    letter-spacing: 1.2px;
}

.iznos {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    height: 250px;
}

.iznos span {
    margin-right: 20px;
}

.iznos input {
    padding: 5px;
    padding-left: 10px;
    background-color: #F2F2F2;
    border-radius: 8px;
    border: none;
    outline: none;
}

.kupibtn {
    margin-top: 20px;
    width: 200px;
    height: 60px;
    font-size: 22px;
    border-radius: 10px;
    box-shadow: 1px 2px 3px 0px rgba(0, 0, 0, 0.4);
    background-color: #59C4DC;
    border: none;
    margin: auto;
    margin-top: 50px !important;
}

@media (max-width: 1050px) {
    .artikli_iznos {
        flex-direction: column;
        justify-content: start;
    }
}
</style>


<script>

import Artikal from '../components/Artikal.vue';
import Navigacija from '../components/Navigacija.vue'
import promokodovi from '../data/promokodovi.js'

export default {
    name: 'Korpa',
    components: {
        Artikal,
        Navigacija
    },
    data() {
        return {
            artikli: [],
            ukupanIznos: 0,
            originalnaCena: 0,
            kod: ''
        }
    },
    mounted() {
        this.artikli = JSON.parse(localStorage.getItem('korpa'))

        for (let i = 0; i < this.artikli.length; i++) {
            this.ukupanIznos += this.artikli[i].cena * this.artikli[i].kolicina
        }
        this.originalnaCena = this.ukupanIznos
    },
    methods: {
        handle() {
            for (let i = 0; promokodovi.length; i++) {
                if (promokodovi[i].naziv == this.kod) {
                    this.ukupanIznos = this.originalnaCena * promokodovi[i].popust
                    return
                }
            }
            alert("Neispravan promo kod!")
        },
        kupi() {
            let korisnik = JSON.parse(localStorage.getItem('korisnik'))
            if (localStorage.getItem('zahtevi') == null) {
                let zahtev = [
                    {
                        "id": 1,
                        "artikli": this.artikli,
                        "iznos": this.ukupanIznos,
                        "korisnik": korisnik.korime
                    }
                ]
                localStorage.setItem('zahtevi', JSON.stringify(zahtev))
            }
            else {
                let id = this.getMaxId()
                let zahtev = {
                    "id": id,
                    "artikli": this.artikli,
                    "iznos": this.ukupanIznos,
                    "korisnik": korisnik.korime
                }
                let zahtevi = JSON.parse(localStorage.getItem('zahtevi'))
                zahtevi.push(zahtev)
                localStorage.setItem('zahtevi', JSON.stringify(zahtevi))
            }
            localStorage.removeItem('korpa')
            alert("Upesno je izvrsena kupovina!")
            this.$router.push('paketi')
        },
        getMaxId() {
            let zahtevi = JSON.parse(localStorage.getItem('zahtevi'))
            let maxId = 0
            for (let i = 0; i < zahtevi.length; i++) {
                if (zahtevi[i].id > maxId) {
                    maxId = zahtevi[i].id
                }
            }
            maxId = maxId + 1
            return maxId
        }
    }
}
</script>

