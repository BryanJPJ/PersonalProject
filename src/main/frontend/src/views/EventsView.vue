<script setup>
import Footercomp from '../components/footercomp.vue';
import eventcomp from '../components/EventsComp/eventcomp.vue';
import { onBeforeMount, ref, computed } from "vue";
import pagination from '..//components/pagination.vue';
import ApiRepository from '../assets/ApiRepository/ApiRepository.js';

const repository = new ApiRepository("eventos");
const api = repository.chooseApi();

const eventCardxPage = 2;
const start = ref(0);
const end = computed(() => Math.min(start.value + eventCardxPage, eventsList.value.length)
);

let eventsList = ref([]);
onBeforeMount(async () => {
  eventsList.value = await api.getAll();
});

const eventsToShow = computed(() => {
  return eventsList.value.slice(start.value, end.value);
});

const next = () => {
  start.value += eventCardxPage;
};

const prev = () => {
  start.value = Math.max(start.value - eventCardxPage, 0);
};

const page = (algo) => {
  start.value = algo;
};
</script>
<template>
    <main>
      <div class="container">
        <div class="section-header">
          <h2>UPCOMING EVENTS <i class="bi bi-calendar2-event"></i></h2>
    </div>
    <div>
      <eventcomp
      v-for="event in eventsToShow"
        :key="event.id"
        :event="event"
        />

    </div>
    <div class="d-flex justify-content-center">
    <pagination
      :pageSize="eventCardxPage"
      :start="start"
      :end="end"
      :maxLength="eventsList.length"
      @change="page"
      @prev="prev"
      @next="next"
    />
  </div>
    </div>
    </main>
    <Footercomp/>
</template>
<style lang="scss" scoped>
@import "../../node_modules/bootstrap-icons";
main{
    background-image: url("../assets/imgs/bg-events2.jpg") ;
  background-repeat: no-repeat;
  background-size: cover;
  height: 43rem;
  color: black;
}
h2{
  color: white;
}
.section-header{
  display: flex;
  justify-content: center;
  padding: 1rem 0rem 1rem 0rem;
}
</style>