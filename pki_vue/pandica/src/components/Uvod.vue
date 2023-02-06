<template>
    <div id="uvod">
        <span>Dobrodosli u zooloski vrt Pandica!</span>
        <br>
        <span>U okviru naseg zooloskog vrta mozete videti raznorazne egzoticne zivotinje.</span>
        <br>
        <span>Nudimo Vam raznovrsnu podunu paketa u okviru kojih <br> mozete uzivati sa porodicom i prijateljima u
            obilasku
            naseg zooloskog vrta.</span>
    </div>

</template>

<style>
#uvod {
    background-image: url(../assets/tiger.jpg);
    background-size: cover;
    height: 700px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin-top: -100px;
    box-shadow: inset 0 0 0 1000px rgba(0, 0, 0, .7);
}

#uvod span {
    color: rgb(209, 209, 209);
    font-size: 24px;
    font-style: italic;
    font-weight: 100;
}

@media (max-width: 778px) {
    #uvod {
        margin-top: -120px;
    }
}
</style>


<script>
export default {
    name: 'Uvod'
}
</script>