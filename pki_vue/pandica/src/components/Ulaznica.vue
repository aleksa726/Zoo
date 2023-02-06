<template>
    <div id="ulaznica">
        <div class="card">
            <h2 class="card-title">{{ ul.naziv }}</h2>
            <div class="card-body">
                <p class="card-text">Cena: {{ ul.cena }} dinara
                </p>
                <button @click="kupi()" class="btn btn-primary">KUPI</button>
            </div>
        </div>
    </div>
</template>

<style>
#ulaznica {
    margin-left: 20px;
    margin-right: 20px;
    padding: 20px;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    margin-bottom: 30px;
    height: auto;
    display: flex;
    flex-direction: column;
    justify-content: center;

}

#ulaznica .card {
    background: transparent !important;
    --bs-card-border-color: none;
}

.card-text {
    font-style: italic;
    font-size: 18px;
}

#ulaznica h2 {
    width: 90%;
    height: 60px;
    font-size: 24px;
    margin-bottom: 20px;
    margin: auto;
}

#ulaznica p {
    margin-top: 20px;
}

#ulaznica button {
    width: 100%;
    font-size: 20px;
    border-radius: 10px;
    box-shadow: 1px 2px 3px 0px rgba(0, 0, 0, 0.4);
    background-color: #59C4DC;
    border: none;
    margin-top: 10px;

}
</style>

<script>
export default {
    name: 'Ulaznica',
    props: [
        'ul'
    ],
    methods: {
        kupi() {
            if (localStorage.getItem('korpa') == null) {
                let ulaznica = [
                    {
                        "id": this.ul.id,
                        "naziv": this.ul.naziv,
                        "cena": this.ul.cena,
                        "ulaznica": this.ul.ulaznica,
                        "kolicina": 1
                    }
                ]
                localStorage.setItem('korpa', JSON.stringify(ulaznica))
            }
            else {
                let korpa = JSON.parse(localStorage.getItem('korpa'))
                let kolicina = 1
                for (let i = 0; i < korpa.length; i++) {
                    if (korpa[i].id == this.ul.id) {
                        kolicina = korpa[i].kolicina + 1
                    }
                }
                for (var i = 0; i < korpa.length; i++) {
                    if (korpa[i].id === this.ul.id) {
                        korpa.splice(i, 1);
                    }
                }
                let ulaznica = {
                    "id": this.ul.id,
                    "naziv": this.ul.naziv,
                    "cena": this.ul.cena,
                    "ulaznica": this.ul.ulaznica,
                    "kolicina": kolicina
                }
                korpa.push(ulaznica)
                localStorage.setItem('korpa', JSON.stringify(korpa))
            }
        }
    }
}
</script>