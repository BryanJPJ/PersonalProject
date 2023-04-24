<script setup>
import { RouterLink } from "vue-router";
</script>

<template>
  <nav class="navbar navbar-expand-lg">
    <p>Admin Modificable Bar</p>
    <div class="container">
      <i class="bi bi-wechat"></i>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <RouterLink class="nav-link" to="/listanuestroseventos"
              >List events</RouterLink
            >
          </li>
          <li>
            <RouterLink class="nav-link" to="/registronuestroseventos"
              >Register new event</RouterLink
            >
          </li>
          <!-- <li class="nav-item">
            <RouterLink class="nav-link" to="/listausuario"
              >List members</RouterLink
            >
          </li>
          <li>
            <RouterLink class="nav-link" to="/registrousuario"
              >Register new member</RouterLink
            >
          </li> -->
        </ul>
      </div>
    </div>
  </nav>
</template>
<style lang="scss" scoped>
p{
  color: #000000;
  margin-left: 13px;
  font-style: italic;
  margin: 0px 0px 0px 15px;
}
nav {
  .container {
    img.logo {
      width: 13vw;
    }
  }
}
.navbar {
  .nav-item {
    margin-left: 15px;
  }
  background-color: rgba(159, 144, 31, 0.742);
  a {
    color: #ffefff;
    transition: all 0.4s;
    line-height: 0px;
  }
  a.router-link-exact-active,
  a:hover {
    color: #de0000;
    letter-spacing: 1px;
  }
}
</style>
