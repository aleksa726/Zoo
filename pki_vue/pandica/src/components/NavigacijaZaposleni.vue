<template>
    <div id="nav">
        <div class='navbar'>
            <a class='navbar-brand' href="/paketi" id="logo">
                PANDICA
            </a>
            <div class="navbar-menu">
                <router-link to="/zahtevi">ZAHTEVI</router-link>
                <router-link to="/dodajzivotinju">DODAJ ZIVOTINJU</router-link>
                <router-link to="/mojprofil">MOJ PROFIL</router-link>
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

.navbar-menu {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    font-size: 18px;
    letter-spacing: 1.5px;
    margin-top: 5px;
    margin-right: 30px;
}

#nav a {
    text-decoration: none;
    color: rgb(224, 224, 224);
    margin-left: 20px;
    margin-right: 20px;
}

@media (max-width: 690px) {
    .navbar-menu {
        margin-right: 0px;
    }
}
</style>

<script>
export default {
    name: 'NavigacijaZaposleni'
}
</script>