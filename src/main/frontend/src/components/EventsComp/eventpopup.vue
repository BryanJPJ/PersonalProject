<script setup>
const props = defineProps({
  eventThis: {
    type: Object,
    required: true,
  },
});
</script>
<template>
  <button
    type="button"
    data-bs-toggle="modal"
    :data-bs-target="`#exampleModal${eventThis.id}`"
    class="popUp-button"
  >
    Ver más
  </button>
  <!-- Modal -->
  <div
    class="modal fade"
    :id="`exampleModal${eventThis.id}`"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
        <button
          type="button"
          class="btn-close"
          data-bs-dismiss="modal"
          aria-label="Close"
          :id="`btnClosed${eventThis.id}`"
        ></button>
        <div>
          <div class="event-container">
              <img
                class="imgCardEvent"
                :src="`http://localhost:8080/images/event-photos/${eventThis.imageevent.image}`"
                alt="Imagen Evento"
                v-if="eventThis.imageevent"
              />
              <img
                class="imgCard"
                src="http://localhost:8080/images/logo-corojoven.jpg"
                alt="Imagen"
                v-else
              />
            <div class="text-container">
              <span> {{ eventThis.dateevent }}</span>
              <h4>{{ eventThis.name }}</h4>
              <p>
                {{ eventThis.description }}
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.popUp-button {
  width: 14rem;
  border-radius: 10px;
  border: none;
  background-color: red;
  color: black;
  height: 3rem;
}
.modal.show .modal-dialog {
  .modal-content {
    padding-bottom: 30px;
    .btn-close {
      background-color: #336644;
      opacity: 1;
      align-self: flex-end;
      margin: 10px 10px 0 0;
    }
    div {
      .event-container {
        background-color: #eeefdd;
        display: flex;
        flex-direction: column;
        width: 90%;
        margin: auto;
        img {
          margin: 30px auto 0 auto;
          width: 50%;
          object-fit: scale-down;
        }
        .text-container {
          display: flex;
          flex-direction: column;
          padding: 40px;
          p {
            width: 100%;
          }
        }
      }
    }
  }
}
@media (max-width: 1024px) {
  .text-container {
    p {
      width: 100%;
    }
  }
}

@media (max-width: 768px) {
  .popUp-button {
    width: 10rem;
    
  }
  .modal.show .modal-dialog {
    .modal-content {
      div {
        .event-container {
          .text-container {
            p {
              width: 100%;
              font-size: 13px;
            }
          }
        }
      }
    }
  }
}
@media (max-width: 425px) {
  .popUp-button {
    width: 6rem;
  }
  .event-container {
    img {
      margin-top: 56px;
    }
  }
  .text-container {
    padding-bottom: 0px;
  }
}
@media (max-width: 320px) {
  .modal.show .modal-dialog {
    .modal-content {
      div {
        .event-container {
          img {
            margin-top: 56px;
          }
        }
      }
    }
  }
}

</style>
