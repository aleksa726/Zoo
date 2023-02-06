<template>
    <div>
        <NavigacijaZaposleni></NavigacijaZaposleni>
        <DodavanjeZivotinje></DodavanjeZivotinje>
    </div>
</template>

<script>
import DodavanjeZivotinje from '../components/DodavanjeZivotinje.vue';
import NavigacijaZaposleni from '../components/NavigacijaZaposleni.vue'

export default {
    name: "DodajZivotinju",
    components: {
        NavigacijaZaposleni,
        DodavanjeZivotinje
    }
}
</script>