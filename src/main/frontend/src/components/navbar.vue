<script setup>
import { RouterLink } from "vue-router";
</script>

<template>
    <nav class="navbar navbar-expand-lg">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><img src="./../assets/imgs/logoPER-removebg-preview.png" id="imgBrand"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item">
            <RouterLink class="nav-link" to="/">Home</RouterLink>
        </li>
        <li class="nav-item">
         <RouterLink to="/about" class="nav-link">About Us</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/event" class="nav-link">Events</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/member" class="nav-link">Members</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/travel" class="nav-link">Travels</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/contact" class="nav-link">Contact</RouterLink>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown link
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="#">nada</a></li>
            <li><a class="dropdown-item" href="#">nada</a></li>
            <li><a class="dropdown-item" href="#">nada</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
</template>
<style lang="scss" scoped>
.navbar {
  background-color: #663333;
  a {
    color: white;
    transition: all 0.4s;
    border-radius: 1em;
  }
  a.router-link-exact-active,
  a:hover {
    background-color: yellow;
    letter-spacing: 1px;
    color: black;
  }
}
.navbar-expand-lg .navbar-nav .dropdown-menu {
    left: -1em;
}
#imgBrand{
  width: 7em;
  height: 6em;
}
</style>
