<template>
    <div id="zivotinja">
        <div class="card">
            <h2 class="card-title">{{ ziv.naziv }}</h2>
            <div class="card-body">
                <img :src="require('../assets/' + ziv.slika + '.png')" class="card-img-top" alt="...">

            </div>
        </div>
    </div>
</template>

<style>
#zivotinja {
    margin-left: 5px;
    margin-right: 5px;
    padding: 5px;
    padding-top: 5px !important;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;

    display: flex;
    flex-direction: column;
    justify-content: center;

}

#zivotinja .card {
    background: transparent !important;
    --bs-card-border-color: none;
}

.card-text {
    font-style: italic;
    font-size: 18px;
}

#zivotinja h2 {
    width: 80%;
    font-size: 24px;
    margin: auto;
    font-weight: 400 !important;
    margin-top: 10px;
}

#zivotinja img {
    height: 200px;
    object-fit: contain;
    background-color: rgb(218, 218, 218);
    border-radius: 12px;
}

#zivotinja p {
    margin-top: 20px;
}
</style>

<script>
export default {
    name: 'Zivotinja',
    props: [
        'ziv'
    ]
}
</script>