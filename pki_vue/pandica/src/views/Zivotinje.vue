<template>
    <div class="zivotinje">
        <Navigacija></Navigacija>
        <br>
        <Uvod></Uvod>
        <ListaZivotinja></ListaZivotinja>
    </div>
</template>

<style>
.zivotinje {
    padding-bottom: 100px;
}

.zivotinje a {
    color: #2c3e50;
    text-decoration: none;
}

.zivotinje a:hover {
    color: #2c3e50;
}
</style>


<script>
import ListaZivotinja from '../components/ListaZivotinja.vue';
import Uvod from '../components/Uvod.vue';
import Navigacija from '../components/Navigacija.vue'
import zivotinje from '../data/zivotinje';

export default {
    name: "Zivotinje",
    components: {
        Uvod,
        ListaZivotinja,
        Navigacija
    },
    mounted() {
        if (localStorage.getItem('zivoitnje') === undefined) {
            localStorage.setItem('zivotinje', JSON.stringify(zivotinje))
        }
    }
}


</script>