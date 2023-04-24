<script setup>
import CardGallery from '../components/TravelsComp/CardGallery.vue';
import { onBeforeMount, ref, computed } from "vue";
import { ourTravels } from "../stores/ourTravels";

const travel = new ourTravels;

const thistravel = computed(() =>  {
  return travel.ourTravelsObject;
});

// // Api
// const repository = new ApiRepository("nuestrosviajes");
// const api = repository.chooseApi();

const travelCardxPage = 6;
const start = ref(0);
const end = computed(() =>
  Math.min(start.value + travelCardxPage, thistravel.imageTravel.length)
);

// let travelsList = ref([]);
// onBeforeMount(async () => {
//   travelsList.value = await api.getAll();
// });

const travelsToShow = computed(() => {
  return thistravel.imageTravel;
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
  <main>
    <div class="mt-5">
      <div class="container" id="headerH3">
        <h3>{{thistravel.name}}</h3>
      </div>
      <p>
        {{ thistravel.description }}
      </p>
      <div id="containerAlbums">
        <CardGallery
          v-for="image in thistravel.imageTravel"
          :id="image.id"
          :image="image.image"

        />
      </div>
      <!-- <Pagination
        :pageSize="travelCardxPage"
        :start="start"
        :end="end"
        :maxLength="travelsList.length"
        @change="page"
        @prev="prev"
        @next="next"
      /> -->
    </div>
  </main>
</template>

<style scoped lang="scss">

.mt-5 {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;

  p  {
    width: 86%;
    margin: 0 auto 40px auto;
    padding: 2vw;
    background-color: white;
  }
}
#containerAlbums {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  width: 90%;
}
#headerH3 {
  width: 90%;
}
h3 {
  font-weight: bold;
  margin: 0.5em;
}
#color-pag {
  color: black;
}
</style>
