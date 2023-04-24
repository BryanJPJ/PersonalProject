<script setup>
import { RouterLink } from "vue-router";
import LoginComponent from "./admin/LoginComponent.vue";
</script>

<template>
  <nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
      <a class="navbar-brand" href="#"
        ><img src="./../assets/imgs/logoPER-removebg-preview.png" id="imgBrand"
      /></a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item" id="homeview">
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
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdownMenuLink"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Log In
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <li>
                <div class="row">
                  <div class="col-md-12">
                    <LoginComponent/>
                  </div>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
<style lang="scss" scoped>
button {
  background-color: red;
}
.navbar {
  background-color: rgba(1, 1, 1, 255);
  .nav-link {
    color: white;
    transition: all 0.4s;
    border-radius: 1em;
  }
  .router-link-exact-active,
  .nav-link:hover {
    background-color: #e22017;
    letter-spacing: 1px;
    color: white;
  }
}
.navbar-expand-lg .navbar-nav .dropdown-menu {
  left: -17rem;
}
#imgBrand {
  width: 7em;
  height: 6em;
}
.nav-item {
  margin: 0em 1em 0em 1em;
  font-size: 1.15em;
  // width: 10em;
}
.navbar-brand {
  // padding: 0;
  margin: 0em 0em 0em 2.8em;
}
// #homeview.router-link-exact-active,
//   .navbar{
//     opacity: 10%;
//   }
</style>
