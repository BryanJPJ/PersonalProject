<script setup>
import Footercomp from '../components/footercomp.vue';

</script>
<template>
    <main>
        <div class="d-flex justify-content-center">
            <h1>MEMBERS</h1>
        </div>
        <div class="headline d-flex justify-content-center">
    <div class="card mb-3" style="max-width: 800px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="../assets/imgs/director-coro.jpg" class="img-fluid rounded-start" alt="choirs director">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">Santiago Novoa <em>Director</em></h5>
        <p class="card-text">El coro está dirigido desde sus inicios por Santi Novoa Marchena, co-impulsor de esta idea, que desde muy joven guarda una relación especial con la dirección coral.</p>
      </div>
    </div>
  </div>
</div>
</div>
<div class="container">
  <div class="row g-2">
    <div class="col-6">
      <div class="p-3 border bg-light">Soprano</div>
    </div>
    <div class="col-6">
      <div class="p-3 border bg-light">Alto</div>
    </div>
    <div class="col-6">
      <div class="p-3 border bg-light">Tenor</div>
    </div>
    <div class="col-6">
      <div class="p-3 border bg-light">Bass</div>
    </div>
  </div>
</div>
</main>

    <Footercomp/>
</template>
<style lang="scss" scoped>
em{
    font-weight: 400;
}
main{
    margin-bottom: 4rem;
}
</style>