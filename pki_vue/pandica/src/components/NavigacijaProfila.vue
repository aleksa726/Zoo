<template>
    <div class="nav2 col-md-8 col-lg-2">
        <router-link to='/mojipodaci'>MOJI PODACI</router-link>
        <router-link to='/promenapodataka'>PROMENA PODATAKA</router-link>
        <router-link to='/promenalozinke'>PROMENA LOZINKE</router-link>
        <router-link to='/obavestenja' v-if="!this.zaposleni">OBAVESTENJA</router-link>
        <router-link to='/prijava'>ODJAVI SE</router-link>
    </div>
</template>

<style>
.nav2 {
    padding: 5px;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    display: flex;
    flex-direction: column;
    justify-content: start;
    align-items: left;
    text-align: left;
    margin-left: 70px;
    margin-top: 50px;
    height: 100%;
}

.nav2 a {
    margin-top: 20px;
    margin-bottom: 20px;
    font-size: 24px;
    margin-left: 20px;
    color: #2c3e50;
    letter-spacing: 1px;
    font-weight: 400;
    text-decoration: none;
}

.nav2 a:hover {
    color: #2c3e50;
}

@media (max-width: 991px) {
    .nav2 {
        align-items: center;
        width: 60% !important;
        margin-left: 0;
    }

    .nav2 a {
        margin-top: 20px;
        margin-bottom: 20px;
        margin-left: 0px;
    }
}
</style>

<script>
export default {
    name: 'NavigacijaProfila',
    data() {
        return {
            zaposleni: false
        }
    },
    mounted() {
        let korisnik = JSON.parse(localStorage.getItem('korisnik'))
        if (korisnik.tip == 1) {
            this.zaposleni = true
        }
    }
}
</script>