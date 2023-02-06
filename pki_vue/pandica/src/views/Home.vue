<template>
  <div class="home">
    <Navigacija></Navigacija>
    <br>
    <Uvod></Uvod>
    <ListaPaketa></ListaPaketa>
    <ListaUlaznica></ListaUlaznica>
  </div>
</template>


<script>
import ListaPaketa from '../components/ListaPaketa.vue';
import ListaUlaznica from '../components/ListaUlaznica.vue';
import Uvod from '../components/Uvod.vue';
import Navigacija from '../components/Navigacija.vue'


export default {
  name: "Home",
  components: {
    ListaPaketa,
    ListaUlaznica,
    Uvod,
    Navigacija
  }
}
</script>
