<template>
    <div id="zahtev">
        <div class="card">
            <div class="card-body">
                <div class="zahtevi_korisnik">
                    <div class="zahtevi">
                        <span v-for="artikal in za.artikli" :key="artikal.id">
                            {{ artikal.naziv }} X {{ artikal.kolicina }}
                        </span>
                    </div>
                    <div>
                        <span class="korisnik">{{ za.korisnik }}</span>
                    </div>
                </div>
                <button @click="prihvati()" style="background-color: #59C4DC;" class="dugme">PRIHVATI</button>
                <button @click="odbaci()" style="background-color: #DC8059;" class="dugme">ODBACI</button>
            </div>
        </div>
    </div>
</template>

<style>
#zahtev {
    margin-left: 20px;
    margin-right: 20px;
    padding: 10px;
    padding-left: 50px;
    padding-right: 50px;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    margin-bottom: 30px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin-top: 20px;

}

.zahtevi_korisnik {
    display: flex;
    flex-direction: row;
    justify-content: start;
    margin-bottom: 20px;
}

.dugme {
    margin-left: 50px;
    margin-right: 50px;
    width: 170px;
    height: 50px;
    font-size: 22px;
    border-radius: 10px;
    box-shadow: 1px 2px 3px 0px rgba(0, 0, 0, 0.4);
    border: none;
    margin-top: 15px;
}

.zahtevi {
    width: 90%;
    display: flex;
    flex-direction: column;
    justify-content: start;
    text-align: left;
}

.zahtevi span {
    font-size: 20px;
    font-style: italic;
}

#zahtev .card {
    background: transparent !important;
    --bs-card-border-color: none;
}

.zahtev_tekst {
    font-size: 22px;
    font-style: normal !important;
    text-align: left;
}

.korisnik {
    font-size: 22px;
    font-style: italic;
}
</style>

<script>
export default {
    name: 'Zahtev',
    props: [
        'za'
    ],
    methods: {
        prihvati() {
            if (localStorage.getItem('obavestenja') == null) {
                let obavestenje = [
                    {
                        "id": 1,
                        "artikli": this.za.artikli,
                        "korisnik": this.za.korisnik,
                        "status": 1,
                        "procitan": 0
                    }
                ]
                localStorage.setItem('obavestenja', JSON.stringify(obavestenje))
            }
            else {
                let id = this.getMaxId()
                let obavestenje = {
                    "id": id,
                    "artikli": this.za.artikli,
                    "korisnik": this.za.korisnik,
                    "status": 1,
                    "procitan": 0
                }
                let obavestenja = JSON.parse(localStorage.getItem('obavestenja'))
                obavestenja.push(obavestenje)
                localStorage.setItem('obavestenja', JSON.stringify(obavestenja))
            }
            let sviZahtevi = JSON.parse(localStorage.getItem('zahtevi'))
            for (var i = 0; i < sviZahtevi.length; i++) {
                if (sviZahtevi[i].id === this.za.id) {
                    sviZahtevi.splice(i, 1);
                }
            }
            localStorage.setItem('zahtevi', JSON.stringify(sviZahtevi))
            this.$router.go(0)
        },
        odbaci() {
            if (localStorage.getItem('obavestenja') == null) {
                let obavestenje = [
                    {
                        "id": 1,
                        "artikli": this.za.artikli,
                        "korisnik": this.za.korisnik,
                        "status": 0,
                        "procitan": 0
                    }
                ]
                localStorage.setItem('obavestenja', JSON.stringify(obavestenje))
            }
            else {
                let id = this.getMaxId();
                let obavestenje = {
                    "id": id,
                    "artikli": this.za.artikli,
                    "korisnik": this.za.korisnik,
                    "status": 0,
                    "procitan": 0
                }
                let obavestenja = JSON.parse(localStorage.getItem('obavestenja'))
                obavestenja.push(obavestenje)
                localStorage.setItem('obavestenja', JSON.stringify(obavestenja))
            }
            let sviZahtevi = JSON.parse(localStorage.getItem('zahtevi'))
            for (var i = 0; i < sviZahtevi.length; i++) {
                if (sviZahtevi[i].id === this.za.id) {
                    sviZahtevi.splice(i, 1);
                }
            }
            localStorage.setItem('zahtevi', JSON.stringify(sviZahtevi))
            this.$router.go(0)
        },
        getMaxId() {
            let obavestenja = JSON.parse(localStorage.getItem('obavestenja'))
            let maxId = 0
            for (let i = 0; i < obavestenja.length; i++) {
                if (obavestenja[i].id > maxId) {
                    maxId = obavestenja[i].id
                }
            }
            maxId = maxId + 1
            return maxId
        }
    }
}
</script>