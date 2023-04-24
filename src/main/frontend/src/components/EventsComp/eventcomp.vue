<script setup>

import eventpopup from "./eventpopup.vue";
const props = defineProps({
  event: {
    type: Object,
    required: true,
  },
});
</script>
<template>
  <div :id="`card-size${event.id}`" class="card-container">
    <figure v-if="event.imageevent">
      <img
        class="imgCardEvent"
        :src="`http://localhost:8080/images/event-photos/${event.imageevent.image}`"
        alt="Imagen Evento"
      />
    </figure>
    <figure v-else>
      <img
        class="imgCard"
        src="http://localhost:8080/images/logo-corojoven.jpg"
        alt="Imagen"
      />
    </figure>
    <div class="text-container">
      <span> {{ event.dateevent }}</span>
      <h4>{{ event.name }}</h4>
      <p>
        {{ event.description }}
      </p>

      <div class="event-popup">
        <eventpopup :eventThis="event"/>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
// @import "../../assets/sass/our-events/our-events-component.scss";
.card-container {
  display: flex;
  width: 100%;
  background-color: #fffffe;
  margin-bottom: 2em;
  max-height: 15em;

  img {
    
    height: 15em;
    width: 20em;
    object-fit: cover;
    aspect-ratio: 16/9;

      
  }
  h4{
    font-weight: bold;
  }
  .text-container {
    display: flex;
    flex-direction: column;
    justify-content:flex-start;
    padding: 1em;
  
    span {
      font-style: italic;
      font-size: 1.2em;
      
    }
    .event-popup {
      display: flex;
      justify-content: end;
      width: 100%;
      
    }
  }
}


@media (max-width: 1024px) {
  .card-container {
  img {
    width: 100%;
    
  }
  .text-container {
    p{
      font-size: 70%;
    }
    div {
      button {
        width: 12rem;
        height: 2.5rem;
      }
    }
  }
}
}


@media (max-width: 768px) {
  .card-container {
    display: flex;
    flex-direction: row;
    
  img {
    width:12em;
   
  }
  .text-container {
   
    p{
      font-size: 60%;
    }
    div {
     
      button {
        width: 10rem;
        height: 2rem;
      }
    }
  }
}
}
@media (max-width: 426px) {
  .card-container {
  display: flex;
  flex-direction: column;
  width: 100%;
  img {
    width: 100%;
  }
  .text-container {
    p{
      font-size: 60%;
    }
    div {
      button {
        width: 6rem;
        height: 2rem;
      }
    }
  }
}
}
</style>
