<template>
  <div id="app">

    <router-view />
  </div>
</template>

<script>


export default {
  name: 'App'
}
</script>

<style>
body {
  background-color: #82966D;
}

body::-webkit-scrollbar {
  display: none;
}

#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: #82966D;
}
</style>
