<template >
    <div>
        <Navigacija></Navigacija>
        <br>
        <div style="min-height: 800px;" class="moji_podaci">
            <NavigacijaProfila></NavigacijaProfila>
            <div class="podaci">
                <h2>OBAVESTENJA</h2>
                <div class="obavestenja">
                    <div class="obavestenje" v-for="obavestenje in obavestenja" :key="obavestenje.id">
                        <Obavestenje :ob="obavestenje"></Obavestenje>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style>
.obavestenja {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: left;
}

#obavestenje {
    padding: 10px !important;
    padding-left: 20px !important;
    padding-right: 20px !important;
    background-color: transparent !important;
}

.obavestenje {
    width: 70%;
    padding: 0 !important;
}

@media (max-width: 991px) {
    .obavestenje {
        width: 100%;
    }
}
</style>

<script>
import NavigacijaProfila from '../components/NavigacijaProfila.vue';
import Obavestenje from '../components/Obavestenje.vue';
import Navigacija from '../components/Navigacija.vue'

export default {
    name: "Obavestenja",
    components: {
        NavigacijaProfila,
        Obavestenje,
        Navigacija
    },
    data() {
        return {
            obavestenja: []
        }
    },
    mounted() {
        let korisnik = JSON.parse(localStorage.getItem('korisnik'))
        let svaObavestenja = JSON.parse(localStorage.getItem('obavestenja'))
        for (let i = 0; i < svaObavestenja.length; i++) {
            if (svaObavestenja[i].korisnik === korisnik.korime) {
                this.obavestenja.push(svaObavestenja[i])
            }
        }
        this.obavestenja = this.obavestenja.reverse()
    }
}
</script>