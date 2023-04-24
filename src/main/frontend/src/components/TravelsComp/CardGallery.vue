<script setup>
const props = defineProps({
  id: {
    type: String,
    required: true,
  },
  image: {
    type: String,
  },
});
</script>

<template>
  <div :id="`card-size${id}`" class="card-container">
    <div class="card">
      <figure>
        <img
          class="imgCard"
          :src="`http://localhost:8080/images/travel-photos/${image}`"
          alt="Imagen"
          id="imgCards"
        />
      </figure>
      <!-- <div class="card-body pt-1"> -->
  
      <div id="containerBtnMemebrs">
          <a
            data-bs-toggle="modal"
            :data-bs-target="`#exampleModal${id}`"
            class="btn btn-primary"
            id="Btn-see"
            >Ampliar</a
          >
        </div>
      <!-- </div> -->
    </div>


    <div
      class="modal fade"
      :id="`exampleModal${id}`"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog" :id="`modalDialog${id}`">
        <div class="modal-content bg-transparent" :id="`boxImg${id}`">
          <figure>
            <div class="d-flex justify-content-end">
              <button
                type="button"
                data-bs-dismiss="modal"
                aria-label="Close"
                :id="`btnClosed${id}`"
              >
                X
              </button>
            </div>
            <img
              :src="`http://localhost:8080/images/travel-photos/${image}`"
              data-bs-toggle="modal"
              data-bs-target="#exampleModal"
            />
          </figure>
        </div>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>

.card-container {
  width: 30%;
  .card {
    background-color: #34dcd3;
    .imgCard {
      aspect-ratio: 16/9;
      width: 100%;
      object-fit: cover;
    }
    .btn btn-primary {
      display: flex;
      justify-content: center;
    }
  }
}

.modal {
    width: 100vw;
    .modal-dialog {
      max-width: none;
      padding: 15px;
      border-radius: 10px;
      .modal-content {
        justify-content: center;
        border: none;
        figure {
          object-fit: scale-down;
          width: fit-content;
          margin: auto;
          background-color: #234fed;
          padding: 1em;
          border-radius: 8px;

          img {
            object-fit: scale-down;
            width: 100%;
            max-height: 70vh;
            margin: auto;
          }

          button {
            background-color: #b8b203;
            opacity: 100%;
            position: absolute;
            margin: 10px 10px 0 0;
            color: #c8c838;
            padding: 2px 5px;
            border-radius: 2px;
            border: none;
            transition: all 0.4s;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            font-weight: bold;
            &:hover {
              color: white;
            }
          }
        }
      }
    }
  }


@media (max-width: 768px) {
  .card-container {
    width: 45%;
  }
}
@media (max-width: 576px) {
  .card-container {
    width: 90%;
  }
}
</style>
