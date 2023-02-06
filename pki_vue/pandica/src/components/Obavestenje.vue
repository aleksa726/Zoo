<template>
    <div id="obaves">
        <div class="obavestenje2" v-if="ob.procitan == 1">
            <div class="card">
                <div class="card-body">
                    <p class="card-text obavestenje_tekst">{{ tekst }}</p>
                </div>
            </div>
        </div>
        <div class="obavestenje2 neprocitan" v-if="ob.procitan == 0">
            <div class="card">
                <div class="card-body">
                    <p class="card-text obavestenje_tekst">{{ tekst }}</p>
                </div>
            </div>
        </div>
    </div>
</template>

<style>
#obaves {
    background-color: transparent !important;
    box-shadow: none !important;
}

.obavestenje2 {
    margin-left: 20px;
    margin-right: 20px;
    padding: 20px;
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

.obavestenje2 .card {
    background: transparent !important;
    --bs-card-border-color: none;
}

.obavestenje_tekst {
    font-size: 22px;
    font-style: normal !important;
    text-align: left;
}

.neprocitan {
    background-color: #59C4DC !important;
}
</style>

<script>
export default {
    name: 'Obavestenje',
    props: [
        'ob'
    ],
    data() {
        return {
            tekst: 'Vasa porudzbina - '
        }
    },
    mounted() {
        for (let i = 0; i < this.ob.artikli.length; i++) {
            this.tekst = this.tekst.concat(this.ob.artikli[i].naziv, ", ")
        }
        if (this.ob.status == 1) {
            this.tekst = this.tekst.concat("je prihvacena. ")
        }
        else {
            this.tekst = this.tekst.concat("je odbijena. ")
        }
        if (this.ob.procitan == 0) {
            let obavestenje = {
                "id": this.ob.id,
                "artikli": this.ob.artikli,
                "korisnik": this.ob.korisnik,
                "status": this.ob.status,
                "procitan": 1
            }
            let obavestenja = JSON.parse(localStorage.getItem('obavestenja'))
            for (var i = 0; i < obavestenja.length; i++) {
                if (obavestenja[i].id === this.ob.id) {
                    obavestenja.splice(i, 1);
                }
            }
            obavestenja.push(obavestenje)
            localStorage.setItem('obavestenja', JSON.stringify(obavestenja))
        }
    }
}
</script>