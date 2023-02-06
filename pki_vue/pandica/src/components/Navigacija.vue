<template>
    <div id="nav">
        <div class='navbar'>
            <a class='navbar-brand' href="/paketi" id="logo">
                PANDICA
            </a>
            <div class="navbar-menu">
                <router-link to="/paketi">PAKETI</router-link>
                <router-link to="/desavanja">DESAVANJA</router-link>
                <router-link to="/zivotinje">ZIVOTINJE</router-link>
                <router-link to="/mojprofil">MOJ PROFIL</router-link>
                <router-link to="/korpa"><img src="../assets/img_94407.png" alt="" width="20px" height="20px">
                </router-link>
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
    margin-left: 10px;
    margin-right: 10px;
}

@media (max-width: 690px) {
    .navbar-menu {
        margin-right: 0px;
    }
}
</style>

<script>
export default {
    name: 'Navigacija'
}
</script>