<template>
  <div class="desavanja">
    <Navigacija></Navigacija>
    <br>
    <Uvod></Uvod>
    <ListaDesavanja></ListaDesavanja>
  </div>
</template>


<script>
import ListaDesavanja from '../components/ListaDesavanja.vue';
import Uvod from '../components/Uvod.vue';
import Navigacija from '../components/Navigacija.vue'

export default {
  name: "Desavanja",
  components: {
    Uvod,
    ListaDesavanja,
    Navigacija

  }
}


</script>