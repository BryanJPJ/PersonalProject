<script setup>
import Slider from '../components/TravelsComp/slider.vue';
import Footercomp from '../components/footercomp.vue';
import { onBeforeMount, ref, computed } from "vue";
import pagination from '../components/pagination.vue';
import ApiRepository from '../assets/ApiRepository/ApiRepository';
import CardAlbum from '../components/TravelsComp/CardAlbum.vue';

const repository = new ApiRepository("nuestrosviajes");
const api = repository.chooseApi();

const travelCardxPage = 4;
const start = ref(0);
const end = computed(() =>
  Math.min(start.value + travelCardxPage, travelsList.value.length)
);

let travelsList = ref([]);
onBeforeMount(async () => {
  travelsList.value = await api.getAll();
});

const travelsToShow = computed(() => {
  return travelsList.value.slice(start.value, end.value);
});

const next = () => {
  start.value += travelCardxPage;
};

const prev = () => {
  start.value = Math.max(start.value - travelCardxPage, 0);
};

const page = (algo) => {
  start.value = algo;
};
</script>
<template>
    <Slider/>
    <div class="container d-flex justify-content-around">
        <CardAlbum
          v-for="travel in travelsToShow"
          :key="travel.id"
          :travel="travel"
        />
    </div>
    <div class="d-flex justify-content-center">
    <pagination
    :pageSize="travelCardxPage"
      :start="start"
      :end="end"
      :maxLength="travelsList.length"
      @change="page"
      @prev="prev"
      @next="next"/>   
    </div> 
    <Footercomp/>
</template>
<style lang="scss" scoped>

</style>