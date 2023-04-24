export default class GaleriaViajesPublicRepository {
    url = "http://localhost:8080/api/travels";
  
    constructor() {}
  
    async getAll() {
      const response = await fetch(this.url);
      const json = await response.json();
  
      let galleryList = [];
  
      galleryList.push(json);
  
      return json;
    }
  }
  