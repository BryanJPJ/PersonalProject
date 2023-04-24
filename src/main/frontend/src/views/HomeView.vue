<script setup>
import { RouterLink } from "vue-router";
</script>

<template>
   
  <main>
    <section class="motto">
  <div class="container-titles">
    <div class="title">
      <p><em>WELCOME TO THIS WONDERFUL MUSICAL FAMILY...</em></p> 
    </div>
    <div class="title">
      <p><em>... CAUSE LIFE GETS BETTER WEARING THIS COLOURS</em></p> 
    </div>
 
</div>
    </section>
    <div class="btn-about-us d-flex justify-content-center">
    <button type="button" class="btn btn-danger btnAbout"><RouterLink to="/about" class="nav-link">get to know more about us!</RouterLink></button>
  </div>
  </main>
</template>
<style lang="scss" scoped>
section{
height: 20rem;
padding-top: 4rem;
}
.btnAbout{
  // margin-bottom: 20rem;
  color: white;
  background-color: #e91216b6;
  border-style: solid;
  // border-radius: 30%;
}
main{
  background-image: url("../assets/imgs/coro_portada.JPG");
  background-repeat: no-repeat;
  background-size: cover;
height: 38.3rem;
  
  p{
    font-size:xx-large;
  }
}
.motto{
  background-color: rgba(0, 0, 0, 0.178);
  color: white;
}
.container-titles{
  display: flex;
  justify-content: space-between;
}
.title{
  width: 35%;
  margin: 0em 2em 0em 2em;
  display: flex;
  justify-content: end;
}
footercomp{
  visibility: hidden;
}
</style>
