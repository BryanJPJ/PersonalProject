export default class SobreNosotrosPublicRepository {
  url = "http://localhost:8080/api/aboutus";

  constructor() {}

  async getAll() {
    const response = await fetch(this.url);
    const json = await response.json();

    let membersList = [];

    membersList.push(json);

    return json;
  }
}

