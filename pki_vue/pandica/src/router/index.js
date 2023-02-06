import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Zivotinje from '../views/Zivotinje.vue'
import DetaljiZivotinje from '../views/DetaljiZivotinje.vue'
import MojProfil from '../views/MojProfil.vue'
import PromenaPodataka from '../views/PromenaPodataka.vue'
import PromenaLozinke from '../views/PromenaLozinke.vue'
import Obavestenja from '../views/Obavestenja.vue'
import Korpa from '../views/Korpa.vue'
import Prijava from '../views/Prijava.vue'
import Registracija from '../views/Registracija.vue'
import Zaposleni from '../views/Zaposleni.vue'
import DodajZivotinju from '../views/DodajZivotinju.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/paketi',
    name: 'Home',
    component: Home
  },
  {
    path: '/desavanja',
    name: 'Desavanja',
    component: () => import('../views/Desavanja.vue')
  },
  {
    path: '/zivotinje',
    name: 'Zivotinje',
    component: Zivotinje
  },
  {
    path: '/detaljizivotinje/:id',
    name: 'DetaljiZivotinje',
    component: DetaljiZivotinje
  },
  {
    path: '/mojprofil',
    name: 'MojProfil',
    component: MojProfil
  },
  {
    path: '/mojipodaci',
    name: 'MojProfil',
    component: MojProfil
  },
  {
    path: '/promenapodataka',
    name: 'PromenaPodataka',
    component: PromenaPodataka
  },
  {
    path: '/promenalozinke',
    name: 'PromenaLozinke',
    component: PromenaLozinke
  },
  {
    path: '/obavestenja',
    name: 'Obavestenja',
    component: Obavestenja
  },
  {
    path: '/korpa',
    name: 'Korpa',
    component: Korpa
  },
  {
    path: '/',
    name: 'Prijava',
    component: Prijava
  },
  {
    path: '/prijava',
    name: 'Prijava',
    component: Prijava
  },
  {
    path: '/registracija',
    name: 'Registracija',
    component: Registracija
  },
  {
    path: '/zaposleni',
    name: 'Zaposleni',
    component: Zaposleni
  },
  {
    path: '/zahtevi',
    name: 'Zaposleni',
    component: Zaposleni
  },
  {
    path: '/dodajzivotinju',
    name: 'DodajZivotinju',
    component: DodajZivotinju
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
