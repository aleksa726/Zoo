<template>
    <div id="paket">
        <div class="card">
            <h2 class="card-title">{{ pk.naziv }}</h2>
            <img :src="require('../assets/' + pk.slika + '')" class="card-img-top" alt="...">
            <div class="card-body">
                <p class="card-text">{{ pk.opis }}
                </p>
                <button @click="kupi()" class="btn btn-primary">KUPI</button>
            </div>
        </div>
    </div>
</template>

<style>
#paket {
    margin-left: 20px;
    margin-right: 20px;
    padding: 20px;
}

#paket .card {
    background: transparent !important;
    --bs-card-border-color: none;
}

#paket img {
    width: 250px;
    height: 250px;
    margin: auto;
}

.card-text {
    font-style: italic;
    font-size: 18px;
}

#paket h2 {
    font-size: 24px;
    margin-bottom: 20px;
}

#paket p {
    margin-top: 20px;
}

#paket button {
    width: 80%;
    font-size: 20px;
    border-radius: 10px;
    box-shadow: 1px 2px 3px 0px rgba(0, 0, 0, 0.4);
    background-color: #59C4DC;
    border: none;
}
</style>

<script>
export default {
    name: 'Paket',
    props: [
        'pk'
    ],
    methods: {
        kupi() {
            if (localStorage.getItem('korpa') == null) {
                let paket = [
                    {
                        "id": this.pk.id,
                        "naziv": this.pk.naziv,
                        "cena": this.pk.cena,
                        "ulaznica": this.pk.ulaznica,
                        "kolicina": 1
                    }
                ]
                localStorage.setItem('korpa', JSON.stringify(paket))
            }
            else {
                let korpa = JSON.parse(localStorage.getItem('korpa'))
                let kolicina = 1
                for (let i = 0; i < korpa.length; i++) {
                    if (korpa[i].id == this.pk.id) {
                        kolicina = korpa[i].kolicina + 1
                    }
                }
                for (var i = 0; i < korpa.length; i++) {
                    if (korpa[i].id === this.pk.id) {
                        korpa.splice(i, 1);
                    }
                }
                let paket = {
                    "id": this.pk.id,
                    "naziv": this.pk.naziv,
                    "cena": this.pk.cena,
                    "ulaznica": this.pk.ulaznica,
                    "kolicina": kolicina
                }
                korpa.push(paket)
                localStorage.setItem('korpa', JSON.stringify(korpa))
            }
        }
    }
}
</script>