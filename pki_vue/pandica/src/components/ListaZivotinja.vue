<template>
    <div id="listaZivotinja">
        <h1>ZIVOTINJE</h1>
        <div class="row justify-content-center" style="min-width: 90%;">
            <div style="margin-top:30px; " class="col-sm-12 col-md-6 col-lg-6" v-for="zivotinja in zivotinje"
                :key="zivotinja.id">
                <router-link :to='/detaljizivotinje/ + zivotinja.id'>
                    <Zivotinja :ziv="zivotinja"></Zivotinja>
                </router-link>
            </div>
        </div>
        <div class="paginacija">
            <button @click="prev()">&#60;</button>
            <span>{{ currPage }}</span>
            <button @click="next()">></button>
        </div>
    </div>
</template>

<style>
#listaZivotinja {
    width: 95% !important;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 50px;
    width: 80%;
    margin: auto;
}

#listaZivotinja h1 {
    margin-top: 80px;
    color: white !important;
    font-size: 36px;
    margin-bottom: 50px;
    letter-spacing: 1.5px;
    font-weight: 400;
}

.paginacija {
    margin-top: 50px;
}

.paginacija span {
    font-size: 36px;
    font-weight: 400;
    color: white;
    margin-left: 20px;
    margin-right: 20px;
}

.paginacija button {
    color: white;
    font-weight: bolder;
    border: none;
    background-color: transparent;
    font-size: 36px;
}

@media (min-width: 1400px) {
    .col-lg-6 {
        width: 16.66666667% !important;
    }
}
</style>

<script>
import Zivotinja from '../components/Zivotinja.vue';
import zivotinje from '../data/zivotinje';

export default {
    name: 'ListaZivotinja',
    components: {
        Zivotinja
    },
    data() {
        return {
            zivotinje: [],
            currPage: 1
        }
    },
    mounted() {
        let sveZivoitnje = JSON.parse(localStorage.getItem('zivotinje'))
        for (let i = 0; i < 5; i++) {
            this.zivotinje.push(sveZivoitnje[i])
        }
    },
    methods: {
        next() {
            let sveZivoitnje = JSON.parse(localStorage.getItem('zivotinje'))
            if (sveZivoitnje.length < this.currPage * 5) {
                return
            }
            this.zivotinje = []
            this.currPage++
            for (let i = (this.currPage - 1) * 5; i < this.currPage * 5; i++) {
                if (sveZivoitnje[i] != undefined) {
                    this.zivotinje.push(sveZivoitnje[i])
                }
            }
        },
        prev() {
            if (this.currPage == 1) {
                return
            }
            let sveZivoitnje = JSON.parse(localStorage.getItem('zivotinje'))
            this.zivotinje = []
            this.currPage--
            for (let i = (this.currPage - 1) * 5; i < (this.currPage) * 5; i++) {
                this.zivotinje.push(sveZivoitnje[i])
            }
        }
    }
}
</script>
