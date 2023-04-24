<script setup>
import { RouterView } from 'vue-router'
import Navbar from './components/navbar.vue';
import NavbarAdminComponent from './components/admin/NavbarAdminComponent.vue';
import {useAuthStore} from './stores/auth-storage'
const isAuthenticated = useAuthStore()
</script>

<template>
  <Navbar/>
  <NavbarAdminComponent/>
  <RouterView />
</template>

<!-- v-if="isAuthenticated.roles=='ROLE_ADMIN'" -->