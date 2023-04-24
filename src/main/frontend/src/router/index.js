import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/event',
      name: 'event',
      component: () => import('../views/EventsView.vue')
    },
    {
      path: '/member',
      name: 'member',
      component: () => import('../views/MembersView.vue')
    },
    {
      path: '/travel',
      name: 'travel',
      component: () => import('../views/TravelsView.vue')
    },
    {
      path: '/contact',
      name: 'contact',
      component: () => import('../views/ContactView.vue')
    },
    {
      path: '/travelgallery',
      name: 'travelgallery',
      component: () => import('../views/TravelsGalleryView.vue')
    },
    {
      path: '/listanuestroseventos',
      name: 'listevents',
      component: () => import('../views/admin/ListEventsView.vue')
    },
    {
      path: '/registronuestroseventos',
      name: 'registerevents',
      component: () => import('../views/admin/RegisterEventsView.vue')
    },
  ]
})

export default router
