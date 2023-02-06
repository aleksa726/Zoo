<template>
    <div>
        <hr>
        <div class="artikal">
            <h4>{{ ar.naziv }}</h4>
            <div>
                <span>{{ ar.cena }} dinara</span>
                <input type="number" v-model="ar.kolicina" @change="handle()">
                <button class=" close" @click="removeItem()"></button>
            </div>
        </div>
        <hr>
    </div>
</template>

<style>
.artikal {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    color: white;
    text-align: left;
    align-items: center;
}

.artikal h4 {
    text-align: left;
    margin-right: 150px;
    font-size: 22px;
    font-weight: 300;
    margin-left: 10px;
    margin-bottom: 0px !important;
}

.artikal span {
    margin-right: 150px;
    font-style: italic;
    font-size: 20px;
    font-weight: 100;
}

.artikal input {
    font-size: 26px;
    width: 40px;
    border: none;
    outline: none;
    border-radius: 8px;
    text-align: center;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

input[type=number] {
    -moz-appearance: textfield;
}

hr {
    height: 1px;
}

.close {
    background-image: url('../assets/close.png');
    width: 20px !important;
    height: 20px;
    background-position: center;
    background-repeat: no-repeat;
    background-size: contain;
    border: transparent;
    background-color: transparent !important;
    box-shadow: none !important;
    margin-top: 5px !important;
    margin-left: 50px;
    margin-right: 10px;
}

@media (max-width: 700px) {
    .artikal h4 {
        margin-right: 50px;
    }

    .artikal span {
        margin-right: 50px;
    }
}

@media (max-width: 500px) {
    .artikal h4 {
        margin-right: 20px;
    }

    .artikal span {
        margin-right: 20px;
    }
}
</style>

<script>
export default {
    name: 'Artikal',
    props: [
        'ar'
    ],
    methods: {
        removeItem() {
            let korpa = JSON.parse(localStorage.getItem('korpa'))
            let id = this.ar.id
            for (var i = 0; i < korpa.length; i++) {
                if (korpa[i].id === id) {
                    korpa.splice(i, 1);
                }
            }
            localStorage.setItem('korpa', JSON.stringify(korpa))
            this.$router.go(0)
        },
        handle() {
            let korpa = JSON.parse(localStorage.getItem('korpa'))
            let id = this.ar.id
            for (var i = 0; i < korpa.length; i++) {
                if (korpa[i].id === id) {
                    korpa.splice(i, 1);
                }
            }
            korpa.push(this.ar)
            localStorage.setItem('korpa', JSON.stringify(korpa))
            this.$router.go(0)
        }
    }
}
</script>