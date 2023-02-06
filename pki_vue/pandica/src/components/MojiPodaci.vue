<template >
    <div style="min-height: 800px;" class="moji_podaci">
        <NavigacijaProfila></NavigacijaProfila>
        <div class="podaci">
            <h2>MOJI PODACI</h2>
            <div class="tabela">
                <div class="levo">
                    <span>KORISNICKO IME:</span>
                    <span>IME:</span>
                    <span>PEZIME:</span>
                    <span>KONTAKT TELEFON:</span>
                    <span>ADRESA:</span>
                </div>
                <div class="desno">
                    <span>{{ korisnik.korime }}</span>
                    <span>{{ korisnik.ime }}</span>
                    <span>{{ korisnik.prezime }}</span>
                    <span>{{ korisnik.telefon }}</span>
                    <span>{{ korisnik.adresa }}</span>
                </div>
            </div>
        </div>
    </div>
</template>

<style>
.moji_podaci {
    display: flex;
    flex-direction: row;
    justify-content: start;
    margin-top: 100px;
}

.podaci {
    width: 75%;
    display: flex;
    flex-direction: column;
    justify-content: start;
}

.podaci h2 {
    color: white !important;
    font-size: 36px;
    margin-bottom: 50px;
    letter-spacing: 1.5px;
    font-weight: 400;
}

.tabela {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}

.levo {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: left;
    text-align: left;
    color: white;
    font-size: 24px;
    font-weight: 200;
}

.levo span {
    margin-top: 25px;
}

.desno span {
    margin-top: 25px;
}

.desno {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: right;
    text-align: right;
    color: white;
    font-size: 24px;
    font-weight: 300;
}

@media (max-width: 991px) {
    .moji_podaci {
        flex-direction: column;
        justify-content: start;
        align-items: center;
        margin-top: 30px;
    }

    .podaci {
        margin-top: 50px;
        margin-bottom: 50px;
    }
}
</style>

<script>
import NavigacijaProfila from './NavigacijaProfila.vue';

export default {
    name: "MojiPodaci",
    components: {
        NavigacijaProfila
    },
    data() {
        return {
            korisnik: []
        }
    },
    mounted() {
        this.korisnik = JSON.parse(localStorage.getItem('korisnik'))
    }
}
</script>