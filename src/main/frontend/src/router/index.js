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
      name: 'events',
      component: () => import('../views/EventsView.vue')
    },
    {
      path: '/member',
      name: 'events',
      component: () => import('../views/MembersView.vue')
    },
    {
      path: '/travel',
      name: 'events',
      component: () => import('../views/TravelsView.vue')
    },
    {
      path: '/contact',
      name: 'events',
      component: () => import('../views/ContactView.vue')
    },
  ]
})

export default router
