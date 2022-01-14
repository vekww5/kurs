<template>
  <div class="container">
    <h3>Места проведения секций</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
        <tr>
          <th>Место проведения</th>
          <th>Обновить</th>
          <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="place in places" v-bind:key="place.id_place">
          <td>{{ place.place_name }}</td>
          <td>
            <button class="btn" v-on:click="updatePlace(place.id_place)">
              Update
            </button>
          </td>
          <td>
            <button class="btn" v-on:click="deletePlace(place.id_place)">
              Delete
            </button>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addPlace()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import PlaceDataService from "../service/DataService";

export default {
  name: "Places",
  data() {
    return {
      places: [],
      message: "",
    };
  },
  methods: {
    refreshPlaces() {
      PlaceDataService.retrieveAllPlaces().then((res) => {
        this.places = res.data;
      });
    },
    addPlace() {
      this.$router.push(`/places/-1`);
    },
    updatePlace(id_place) {
      this.$router.push(`/places/${id_place}`);
    },
    deletePlace(id_place) {
      PlaceDataService.deletePlace(id_place).then(() => {
        this.refreshPlaces();
      });
    },
  },
  created() {
    this.refreshPlaces();
  },
};
</script>