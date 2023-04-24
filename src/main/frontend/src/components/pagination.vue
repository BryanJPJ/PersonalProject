<script setup>
import { computed, watch } from 'vue';

const props = defineProps({
  start: { type: Number },
  end: { type: Number },
  maxLength: { type: Number },
  pageSize: { type: Number},
});

const emit = defineEmits(['next', 'prev', 'change']);

const currentPage = computed(() => Math.ceil(props.start / props.pageSize) + 1);
const lastPage = computed(() => Math.ceil(props.maxLength / props.pageSize));

const pages = computed(() => {
  const pagesArray = [];
  for (let i = 1; i <= lastPage.value; i++) {
    pagesArray.push(i);
  }
  return pagesArray;
});

const prev = () => {
  if (props.start === 0) return;
  emit('prev');
};

const next = () => {
  if (props.end >= props.maxLength) return;
  emit('next');
};

const changePage = (page) => {
  const newStart = (page - 1) * props.pageSize;
  if (newStart >= props.maxLength) return;
  emit('change', newStart);
};

watch(() => props.maxLength, () => {
  lastPage.value = Math.ceil(props.maxLength / props.pageSize);
});

</script>

<template>
  <nav aria-label="Page navigation example" class="paginationbg">
    <ul class="pagination justify-content-center" id="bgpagination">
      <li class="page-item" :class="{ 'disabled': currentPage === 1 }">
        <a class="page-link" href="#" aria-label="Previous" @click.prevent="prev">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <li v-for="page in pages" v-bind:key="page" class="page-item" v-bind:class="{ 'active': currentPage === page }">
        <a class="page-link" href="#" @click.prevent="changePage(page)">{{ page }}</a>
      </li>
      <li class="page-item" :class="{ 'disabled': currentPage === lastPage }">
        <a class="page-link" href="#" aria-label="Next" @click.prevent="next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
</template>
<style lang="scss" scoped>
  .active a,
  .page-link:hover {
    background: #bdadad;
    border-radius: 3px;
    color: #000000;
  }
  .pagination, 
  .page-link {
    background: none;
    color: #000000;
    border: none;
    box-shadow: none;
  }
  #bgpagination{
    background-color: rgba(255, 0, 0, 0.612);
    border-radius: 5px;
    // width: 20%;
  }
</style>
