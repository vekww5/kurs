<template>
  <div class="container">
    <main-header/>
    <h3>Заголовки расписания</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
        <tr>
          <th>Заголовок</th>
          <th>Утверждено</th>
          <th>Обновить</th>
          <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="headerschedule in headerschedules" v-bind:key="headerschedule.id_header_schedule">
          <td>{{ headerschedule.header_name }}</td>
          <td>{{ headerschedule.approved }}</td>
          <td>
            <button class="btn" v-on:click="updateHeaderSchedule(headerschedule.id_header_schedule)">
              Update
            </button>
          </td>
          <td>
            <button class="btn" v-on:click="deleteHeaderSchedule(headerschedule.id_header_schedule)">
              Delete
            </button>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addHeaderSchedule()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import HeaderSchedulesDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "HeaderSchedules",
  components: {MainHeader},
  data() {
    return {
      headerschedules: [],
      message: "",
    };
  },
  methods: {
    refreshHeaderSchedules() {
      HeaderSchedulesDataService.retrieveAllHeaderSchedules().then((res) => {
        this.headerschedules = res.data;
      });
    },
    addHeaderSchedule() {
      this.$router.push(`/headerschedules/-1`);
    },
    updateHeaderSchedule(id_header_schedule) {
      this.$router.push(`/headerschedules/${id_header_schedule}`);
    },
    deleteHeaderSchedule(id_header_schedule) {
      HeaderSchedulesDataService.deleteHeaderSchedule(id_header_schedule).then(() => {
        this.refreshHeaderSchedules();
      });
    },
  },
  created() {
    this.refreshHeaderSchedules();
  },
};
</script>