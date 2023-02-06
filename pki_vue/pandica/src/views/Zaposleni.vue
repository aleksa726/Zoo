<template>
    <div>
        <NavigacijaZaposleni></NavigacijaZaposleni>
        <ListaZahteva></ListaZahteva>
    </div>
</template>

<script>
import NavigacijaZaposleni from '../components/NavigacijaZaposleni.vue'
import ListaZahteva from '../components/ListaZahteva.vue'

export default {
    name: "Zaposleni",
    components: {
        NavigacijaZaposleni,
        ListaZahteva
    }
}
</script>