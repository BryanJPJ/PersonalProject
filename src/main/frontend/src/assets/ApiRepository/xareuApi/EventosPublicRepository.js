export default class EventosPublicRepository {
  url = "http://localhost:8080/api/events";

  constructor() {}

  async getAll() {
    const response = await fetch(this.url);
    const json = await response.json();

    let eventsList = [];

    eventsList.push(json);

    return json;
  }
}
