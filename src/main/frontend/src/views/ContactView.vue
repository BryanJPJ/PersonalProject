<script setup>
import Footercomp from '../components/footercomp.vue';

</script>
<template>
    <main>
  <div class="container">
        <div class="row aos-init aos-animate" data-aos="fade-up">
          <div class="col-lg-6">
            <div class="info-box mb-4">
              <i class="bx bx-map"></i>
              <h3>Our Address</h3>
              <p>C. Colegiata, 2, 33201 Gijón, Asturias</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6">
            <div class="info-box  mb-4">
              <i class="bx bx-envelope"></i>
              <h3>Email Us</h3>
              <p>corojovendegijon@gmail.com</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6">
            <div class="info-box  mb-4">
              <i class="bx bx-phone-call"></i>
              <h3>Call Us</h3>
              <p>+34 6XX 26X 00X</p>
            </div>
          </div>

        </div>



        <div class="row aos-init aos-animate" data-aos="fade-up">

<div class="col-lg-6 ">
  <iframe class="mb-4 mb-lg-0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d639.4715583037294!2d-5.664100881635008!3d43.54538236745755!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd367d57ed54b605%3A0xa2a1e87ed85aade7!2sCoro%20Joven%20de%20Gijon!5e0!3m2!1ses!2ses!4v1682366872277!5m2!1ses!2ses" frameborder="0" style="border:0; width: 100%; height: 300px;" allowfullscreen=""></iframe>
</div>

<div class="col-lg-6">
  <form action="forms/contact.php" method="post" role="form" class="php-email-form">
    <div class="row">
      <div class="col-md-6 form-group">
        <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required="">
      </div>
      <div class="col-md-6 form-group mt-3 mt-md-0">
        <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required="">
      </div>
    </div>
    <div class="form-group mt-3">
      <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required="">
    </div>
    <div class="form-group mt-3">
      <textarea class="form-control" name="message" rows="5" placeholder="Message" required=""></textarea>
    </div>
    <div class="text-center mt-3"><button type="submit">Send Message</button></div>
  </form>
</div>

</div>
</div>
    </main>
   <Footercomp/>
</template>
<style lang="scss" scoped>
main{
  margin-top: 2rem;
  margin-bottom: 3rem;
}
</style>