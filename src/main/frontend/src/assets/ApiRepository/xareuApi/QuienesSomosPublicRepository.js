export default class QuienesSomosPublicRepository {
  url = "http://localhost:8080/api/quienessomos";

  constructor() {}

  async getAll() {
    const response = await fetch(this.url);
    const json = await response.json();

    let membersList = [];

    membersList.push(json);

    // console.log(json);
    return json;
  }
}

