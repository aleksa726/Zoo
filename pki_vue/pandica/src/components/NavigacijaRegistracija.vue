<template>
    <div id="nav">
        <div class='navbar'>
            <a class='navbar-brand' href="/prijava" id="logo">
                PANDICA
            </a>
            <div class="registracija_link">
                <router-link to="/prijava">PRIJAVA</router-link>
            </div>
        </div>
    </div>

</template>

<style>
#logo {
    letter-spacing: 5px;
    font-size: 24px;
    font-weight: bolder;
}

.navbar-brand {
    margin-left: 20px;
}

.registracija_link {
    display: flex;
    flex-direction: row;
    justify-content: right;
    font-size: 18px;
    letter-spacing: 1.5px;
    margin-top: 5px;
    margin-right: 30px;
}

#nav a {
    text-decoration: none;
    color: rgb(224, 224, 224);
}
</style>

<script>
export default {
    name: 'NavigacijaRegistracija'
}
</script>