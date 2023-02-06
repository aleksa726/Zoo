<template>
    <div id="komentar">
        <div class="card">
            <div class="card-body">
                <p>{{ kom.tekst }}</p>
                <div class="korisnik">
                    <span>{{ kom.korisnik }}</span>
                </div>
            </div>
        </div>
    </div>
</template>

<style>
#komentar {
    margin-left: 5px;
    margin-right: 5px;
    padding: 5px;
    padding-top: 5px !important;
    background-color: #F2F2F2;
    box-shadow: 1px 4px 10px 2px rgba(0, 0, 0, 0.3);
    border-radius: 12px;
    width: 100% !important;
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin-top: 20px;
    color: #2c3e50;
}

#komentar .card {
    background: transparent !important;
    --bs-card-border-color: none;
}

.card-text {
    font-style: italic;
    font-size: 18px;

}


#komentar p {
    color: #2c3e50 !important;
    margin: 0 !important;
    margin-top: -10px !important;
    width: 80% !important;
    text-align: left !important;
    font-size: 22px !important;
}

#komentar span {
    text-align: right !important;
    font-style: italic;
    font-size: 18px;
    color: #2c3e50;
}

.korisnik {
    display: flex;
    flex-direction: column;
    justify-content: right;
}
</style>

<script>
export default {
    name: 'Komentar',
    props: [
        'kom'
    ]
}
</script>