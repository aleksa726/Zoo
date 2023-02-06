<template>
    <div id="dodavanjeZivotinje">
        <h1>DODAJ ZIVOTINJU</h1>
        <div class="row justify-content-center" style="min-height: 750px;">
            <div class="tabela2">
                <div class="levo2">
                    <span>NAZIV</span>
                    <span style="margin-top: 25px;">OPIS</span>
                </div>
                <div class="inputPolja2">
                    <input v-model="naziv">
                    <textarea v-model="opis"></textarea>
                </div>
            </div>
            <div class="blok">
                <div class="slike">
                    <div class="jedna_slika" :style="{
                        backgroundColor: active1 ? '#59C4DC' : 'white',
                    }">
                        <img src="../assets/animal1.png" alt=""
                            @click="izaberi('animal1'); active1 = setActive(active1)">
                    </div>
                    <div class="jedna_slika" :style="{
                        backgroundColor: active2 ? '#59C4DC' : 'white',
                    }">
                        <img src="../assets/animal2.png" alt=""
                            @click="izaberi('animal2'); active2 = setActive(active2)">
                    </div>
                    <div class="jedna_slika" :style="{
                        backgroundColor: active3 ? '#59C4DC' : 'white',
                    }">
                        <img src="../assets/animal3.png" alt=""
                            @click="izaberi('animal3'); active3 = setActive(active3)">
                    </div>
                    <div class="jedna_slika" :style="{
                        backgroundColor: active4 ? '#59C4DC' : 'white',
                    }">
                        <img src="../assets/animal4.png" alt=""
                            @click="izaberi('animal4'); active4 = setActive(active4)">
                    </div>
                    <div class="jedna_slika" :style="{
                        backgroundColor: active5 ? '#59C4DC' : 'white',
                    }">
                        <img src="../assets/animal5.png" alt=""
                            @click="izaberi('animal5'); active5 = setActive(active5)">
                    </div>
                </div>
                <br>
                <button @click="dodaj()">DODAJ</button>
            </div>
        </div>
    </div>
</template>

<style>
.blok {
    display: flex;
    flex-direction: column;
    justify-content: start;
    align-items: center;
}

#dodavanjeZivotinje {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 50px;
}

#dodavanjeZivotinje h1 {
    margin-top: 40px;
    color: white !important;
    font-size: 36px;
    margin-bottom: 70px;
    letter-spacing: 1.5px;
    font-weight: 400;
}

.slike {
    background-color: white;
    border-radius: 14px;
    box-shadow: 2px 4px 6px 0px rgba(0, 0, 0, 0.4);
    margin-top: 50px !important;
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    width: 90% !important;
    align-items: center;
}

.jedna_slika {
    padding: 10px;
    height: 200px;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
}

.jedna_slika img {
    height: 150px;
    object-fit: contain;
}

.tabela2 {
    display: flex;
    flex-direction: row;
    justify-content: center;
}

.levo2 {
    display: flex;
    flex-direction: column;
    justify-content: start;
    margin-right: 50px;
}

.levo2 span {
    color: white;
    font-size: 24px;
    font-weight: 200;
}

.inputPolja2 {
    display: flex;
    flex-direction: column;
    justify-content: start;
}

.labele2 {
    justify-content: start;
}

.labele2 span {
    font-size: 24px;
}

.inputPolja2 input {
    padding: 5px;
    padding-left: 10px;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    border: none;
    outline: none;
    font-size: 24px;
}

.inputPolja2 textarea {
    margin-top: 20px;
    width: 400px;
    height: 300px;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    resize: none;
    outline: none;
    padding: 15px;
    font-size: 22px;
}

#dodavanjeZivotinje button {
    margin-top: 20px;
    width: 200px;
    height: 60px;
    font-size: 24px;
    border-radius: 10px;
    box-shadow: 1px 2px 3px 0px rgba(0, 0, 0, 0.4);
    background-color: #59C4DC;
    border: none;
    margin-bottom: 50px;
}

@media (max-width: 1400px) {
    .jedna_slika img {
        height: 130px;
    }

    .jedna_slika {
        padding: 5px;
        height: 150px;
    }
}

@media (max-width: 1170px) {
    .slike {
        flex-direction: column;
        justify-content: start;
        width: 65% !important;
    }

    .jedna_slika img {
        height: 200px;
    }

    .jedna_slika {
        padding: 5px;
        height: 250px;
    }
}
</style>

<script>

export default {
    name: 'DodavanjeZivotinje',
    data() {
        return {
            naziv: '',
            opis: '',
            active1: false,
            active2: false,
            active3: false,
            active4: false,
            active5: false,
            slika: ''
        }
    },
    mounted() {
    },
    methods: {
        dodaj() {
            let id = this.getMaxId()
            let zivotinja = {
                "id": id,
                "naziv": this.naziv,
                "opis": this.opis,
                "slika": this.slika
            }
            let zivotinje = JSON.parse(localStorage.getItem('zivotinje'))
            zivotinje.push(zivotinja)
            localStorage.setItem('zivotinje', JSON.stringify(zivotinje))
            alert("Zivotinja je uspesno dodata!")
            this.$router.push('zaposleni')
        },
        izaberi(slika) {
            this.slika = slika
        },
        setActive(active) {
            this.active1 = false
            this.active2 = false
            this.active3 = false
            this.active4 = false
            this.active5 = false
            return !active
        },
        getMaxId() {
            let zivotinje = JSON.parse(localStorage.getItem('zivotinje'))
            let maxId = 0
            for (let i = 0; i < zivotinje.length; i++) {
                if (zivotinje[i].id > maxId) {
                    maxId = zivotinje[i].id
                }
            }
            maxId = maxId + 1
            return maxId
        }
    }
}
</script>