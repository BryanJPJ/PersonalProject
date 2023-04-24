export default class ViajesPublicRepository {
    url = "http://localhost:8080/api/travels";
  
    constructor() {}
  
    async getAll() {
      const response = await fetch(this.url);
      const json = await response.json();
  
      let travelsList = [];
  
      travelsList.push(json);
  
      return json;
    }
  }
  