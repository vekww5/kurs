<template>
  <div class="container">
    <main-header/>
    <h3>Данные о тренерах</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
        <tr>
          <th>Фамилия</th>
          <th>Имя</th>
          <th>Отчество</th>
          <th>Телефон</th>
          <th>Дата рождения</th>
          <th>Обновить</th>
          <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="trainer in trainers" v-bind:key="trainer.id_trainer">
          <td>{{ trainer.last_name }}</td>
          <td>{{ trainer.first_name }}</td>
          <td>{{ trainer.middle_name }}</td>
          <td>{{ trainer.phone }}</td>
          <td>{{ trainer.birthday }}</td>
          <td>
            <button class="btn" v-on:click="updateTrainer(trainer.id_trainer)">
              Update
            </button>
          </td>
          <td>
            <button class="btn" v-on:click="deleteTrainer(trainer.id_trainer)">
              Delete
            </button>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addTrainer()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import TrainerDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Trainers",
  components: {MainHeader},
  data() {
    return {
      trainers: [],
      message: "",
    };
  },
  methods: {
    refreshTrainers() {
      TrainerDataService.retrieveAllTrainers().then((res) => {
        this.trainers = res.data;
      });
    },
    addTrainer() {
      this.$router.push(`/trainers/-1`);
    },
    updateTrainer(id_trainer) {
      this.$router.push(`/trainers/${id_trainer}`);
    },
    deleteTrainer(id_trainer) {
      TrainerDataService.deleteTrainer(id_trainer).then(() => {
        this.refreshTrainers();
      });
    },
  },
  created() {
    this.refreshTrainers();
  },
};
</script>