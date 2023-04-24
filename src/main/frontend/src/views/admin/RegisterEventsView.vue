<script setup>
import router from "../../router";
import { ourEvents } from "../../stores/ourEvents";

const ourEventsToAdd = ourEvents();

let eventItem = {
  name: "",
  description: "",
  dateevent: ""
};

async function save() {
  if (eventItem.name === "") {
    alert("Se necesita añadir el nombre.");
    return;
  }

  if (eventItem.dateevent === "") {
    alert("Se necesita añadir la fecha del evento.");
    return;
  }

  const payload = JSON.stringify(eventItem);
  const url = "http://localhost:8080/api/events";
  const response = fetch(url, {
    method: "POST",
    body: payload,
    headers: {
      "Content-type": "application/json",
      Accept: "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data)
      if (data.name) {
        ourEventsToAdd.ourEventsObject = data;
        alert(data.name + " añadido correctamente.");
        router.push('/registrofotousuario/' + data.id);
      } else {
        alert("Se ha producido un error. \nPor favor, inténtelo de nuevo en unos minutos.");
      }
    });
}
</script>

<template>
  <form>
    <div class="container mt-2">
      <div class="col-12 col-md-8">
        <h2 class="mt-2">Añadir un nuevo evento</h2>
        <div class="mb-3">
          <label for="name" class="form-label">Nombre</label>
          <input v-model="eventItem.name" id="name" class="form-control" type="text" placeholder="Nombre" />
        </div>
        <div class="mb-3">
          <label for="date" class="form-label">Fecha del viaje </label>
          <input v-model="eventItem.dateevent" id="dateevent" class="form-control" type="date"
            placeholder="Fecha del viaje" />
        </div>
        <div class="mb-3">
          <label for="surname" class="form-label">Descripción</label>
          <textarea v-model="eventItem.description" id="description" class="form-control" type="rextarea"
            placeholder="description" />
        </div>
      </div>
      <div class="d-flex w-80 mb-3 mt-3">
        <button
          @click.prevent="save"
          type="submit"
          class="btn btn-success me-2 w-50"
        >
          Enviar
        </button>
        <button type="reset" class="btn btn-danger w-50">Borrar</button>
      </div>
    </div>
  </form>
</template>

<style lang="scss" scoped>

h2 {
//   font-family: $font-text;
  text-align: center;
}

.container {
  width: 80%;
  max-width: none;
  margin: 0 auto;
  display: flex;
  justify-content: space-around;
  align-items: center;
  flex-direction: column;
  background-color: #ffffff;
  height: 100%;
}

.form-control {
  width: 100%;
  border-radius: 10px;
}


input {
  width: 100%;
  background-color: #ffffff;
}

.btn {
  width: 100%;
}

textarea {
  height: 250px;
}


@media (min-width: 768px) {
  .w-10 {
    width: 10%;
  }
}
</style>
