<script  setup>
import Footercomp from '../components/footercomp.vue';

</script>
<template>
  <main>
    <div class="card">
        <div class="row g-0">
            <div class="col-md-4">
                <video src="../assets/imgs/recuerdame-coro.mp4" poster="../assets/imgs/poradavideo.jpg" controls>
  <p>Su navegador no soporta vídeos HTML5.</p>
</video>
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">Coro Joven de Gijón</h5>
                    <pre class="card-text">Es un coro para jóvenes coralistas, desde los dieciséis años, que nace, hace 7 años, de un acuerdo de colaboración entre el Ayuntamiento de Gijón y la Federación Coral Asturiana, FECORA. Finalidad: despertar el interés de los jóvenes por la música coral; es decir que jóvenes vean a otros jóvenes disfrutar cantando juntos en una formación coral, encima de un escenario, con repertorios inhabituales dentro de las agrupaciones corales: música joven, y con un acercamiento a la música que en una formación donde son bienvenidos, pero no necesarios conocimientos musicales previos. En este momento este coro, de voces mixtas, está compuesto por más de cuarenta jóvenes coralistas que dedican horas a su ilusión por cantar juntos disfrutando de un aprendizaje musical y de un ambiente de gran amistad. Las músicas de: Fredie Mercury, Queen, Mariah Carey, Extremoduro, Warcry, Supertramp, Adele, Radiohead, Coldplay Beyoncé, Michael Jackson, entro otros músicos, canciones de musicales como "Los Miserable" "Sister Act" "La la land" "Skyfall" forman parte del repertorio de este coro;
                        repertorio bastante inusual en el mundo coral. Desde su formación ha actuado en diversos teatros y centros culturales de Asturias y otros espacios públicos, como el estadio de fútbol del Molinón, la Plaza Mayor de Gijón; así como en actos de homenaje y reconocimientos. Visualmente es de destacar el videoclip "Believer", entre otros, gravado por los propios componentes del coro. Cada concierto supone momentos de disfrute y complicidad con el público, en un proyecto que lleva un camino de notable proyección de futuro.
                    </pre>
                    <img src="../assets/imgs/coro_portada.JPG">
                </div>
            </div>
            
        </div>
    </div>
  </main>
  <Footercomp/>
</template>

<style scoped lang="scss">
.col-md-4{
    padding-top: 3rem;
    padding-left: 3rem;
}
video{
    width: 30rem;
    height: 20rem;
    display: flex;
    justify-self: auto;
}

ul li::before {
    content: "- ";
}

ul.strong li::before {
    content: "";
}

h6 {
    font-weight: bold;
    text-decoration: underline;
}

h6 {
    font-weight: bold;
    text-decoration: underline;
}

.card-body {
    background-color: #ffffff;
}

h5 {
    color: #cc0033;
}

img {
    width: 100%;
    object-fit: cover;
    aspect-ratio: 1/1;
}

.card {
    --bs-card-border-width: none;
    --bs-card-border-color: var(--bs-border-color-translucent);
    --bs-card-border-radius: none;
    --bs-card-inner-border-radius: calc(none);
    border: none;
    border-radius: none;
}

.card:nth-child(even) .row {
    flex-direction: row-reverse;
}

.card-body {
    overflow: auto;
    height: 30vw;
    scrollbar-color: rgba(0, 0, 0, 0.5) rgba(0, 0, 0, 0);
    scrollbar-width: thin;
    margin-right: 15px;
    margin-top: 15px;
    padding: 3em 4em 4em 4em;
}

.card-body::-webkit-scrollbar {
    -webkit-appearance: none;
}

.card-body::-webkit-scrollbar:vertical {
    width: 10px;
}

.card-body::-webkit-scrollbar-button:increment,
.card-body::-webkit-scrollbar-button {
    display: none;
}

.card-body::-webkit-scrollbar:horizontal {
    height: 10px;
}

.card-body::-webkit-scrollbar-thumb {
    background-color: rgb(83, 83, 83);
    border-radius: 20px;
    border: 1px solid #f1f2f3;
}

.contenedor::-webkit-scrollbar-track {
    border-radius: 10px;
}

pre {
    white-space:pre-line;
    // font-family: $font-text;
    font-size: 1rem;
}

@media (max-width: 768px) {
    .card-body {
        height: 100vw;
        padding: 1rem;
    }
}

</style>
