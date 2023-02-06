<template>
    <div id="desavanje">
        <div class="card">
            <h2 class="card-title">{{ ds.naziv }}</h2>
            <div class="card-body">
                <div class="opis_slika">
                    <p class="card-text desavanje_tekst">{{ ds.opis }}</p>
                    <img :src="require('../assets/' + ds.id + '.png')" class="card-img-top" alt="...">
                </div>
                <div class="like_date">
                    <div class="like">
                        <button v-if="!liked" @click="lajk()" class="notliked"></button>
                        <button v-if="liked" @click="lajk()" class="liked"></button>
                        <span>{{ ds.lajk }}</span>
                    </div>
                    <span>{{ ds.datum }}</span>
                </div>
            </div>
        </div>
    </div>
</template>

<style>
#desavanje {
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

.opis_slika {
    margin-top: 15px;
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}

#desavanje .card {
    background: transparent !important;
    --bs-card-border-color: none;
}

.desavanje_tekst {
    font-size: 22px;
    font-style: normal !important;
    text-align: left;
}

#desavanje h2 {
    width: 100%;
    font-size: 28px;
}

#desavanje img {
    max-width: 50%;
    max-height: 250px;
    margin: auto;
    object-fit: contain;
}

#desavanje p {
    margin-left: 20px;
    width: 50%;
    margin: auto;
    margin-right: 20px;
}

.like_date {
    margin-top: 10px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

.like_date span {
    font-size: 22px !important;
    font-weight: 100;
}

.like {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}

.like button {
    width: 50px;
    background-position: center;
    background-repeat: no-repeat;
    background-size: contain;
    border: transparent;
}

.notliked {
    background-image: url("../assets/like.png");
}

.liked {
    background-image: url("../assets/liked.png");
}

.like span {
    margin-left: 5px;
    font-size: 20px;
    font-weight: 300;
}

@media (max-width:770px) {
    .opis_slika {
        flex-direction: column;
    }

    #desavanje img {
        max-width: 100%;
        max-height: 250px;
        margin: auto;
        object-fit: contain;
        margin-top: 20px;
    }

    #desavanje p {
        width: 100%;
        margin: auto;
        text-align: center;
    }
}
</style>

<script>
export default {
    name: 'Desavanje',
    props: [
        'ds'
    ],
    data() {
        return {
            liked: false
        }
    },
    methods: {
        lajk() {
            this.liked = !this.liked
            if (this.liked == true) {
                this.ds.lajk++;
            }
            else {
                this.ds.lajk--;
            }
            let korisnik = JSON.parse(localStorage.getItem('korisnik'))
            let lajkovao = false;
            korisnik.lajkovanaDesavanja.forEach((idDesavanja) => {
                if (idDesavanja == this.ds.id) {
                    lajkovao = true
                }
            })

            let desavanja = JSON.parse(localStorage.getItem('desavanja'))
            let desavanje = desavanja.find(des => des.id == this.ds.id)
            if (!lajkovao) {
                desavanje.lajk++
                korisnik.lajkovanaDesavanja.push(desavanje.id)
                localStorage.setItem('korisnik', JSON.stringify(korisnik))
            }
            else {
                desavanje.lajk--
                for (var i = 0; i < korisnik.lajkovanaDesavanja.length; i++) {
                    if (korisnik.lajkovanaDesavanja[i] === desavanje.id) {
                        korisnik.lajkovanaDesavanja.splice(i, 1);
                    }
                }
                localStorage.setItem('korisnik', JSON.stringify(korisnik))
            }

            let korisnici = JSON.parse(localStorage.getItem('korisnici'))
            for (var i = 0; i < korisnici.length; i++) {
                if (korisnici[i].korime === korisnik.korime) {
                    korisnici.splice(i, 1);
                }
            }
            korisnici.push(korisnik)
            localStorage.setItem('korisnici', JSON.stringify(korisnici))
            localStorage.removeItem('desavanja')
            localStorage.setItem('desavanja', JSON.stringify(desavanja))
        }
    },
    mounted() {
        let korisnik = JSON.parse(localStorage.getItem('korisnik'))
        let lajkovao = false;
        korisnik.lajkovanaDesavanja.forEach((idDesavanja) => {
            if (idDesavanja == this.ds.id) {
                lajkovao = true
            }
        })
        this.liked = lajkovao
    }
}
</script>