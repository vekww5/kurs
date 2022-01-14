<template>
  <div class="container">
    <main-header/>
    <h3>Общее расписание</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
        <tr>
          <th>Место проведения</th>
          <th>Секция</th>
          <th>Заголовок</th>
          <th>Дата</th>
          <th>Время начала</th>
          <th>Время окончания</th>
          <th>Отмена занятия</th>
          <th>Примечание</th>
          <th>Обновить</th>
          <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="schedule in schedules" v-bind:key="schedule.id_schedule">
          <td>{{ schedule.id_place }}</td>
          <td>{{ schedule.id_section }}</td>
          <td>{{ schedule.id_header_schedule }}</td>
          <td>{{ schedule.date }}</td>
          <td>{{ schedule.time_start }}</td>
          <td>{{ schedule.time_end }}</td>
          <td>{{ schedule.cancell }}</td>
          <td>{{ schedule.note }}</td>
          <td>
            <button class="btn" v-on:click="updateSchedule(schedule.id_schedule)">
              Update
            </button>
          </td>
          <td>
            <button class="btn" v-on:click="deleteSchedule(schedule.id_schedule)">
              Delete
            </button>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addSchedule()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import ScheduleDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Schedules",
  components: {MainHeader},
  data() {
    return {
      schedules: [],
      message: "",
    };
  },
  methods: {
    refreshSchedules() {
      ScheduleDataService.retrieveAllSchedules().then((res) => {
        this.schedules = res.data;
      });
    },
    addSchedule() {
      this.$router.push(`/schedules/-1`);
    },
    updateSchedule(id_schedule) {
      this.$router.push(`/schedules/${id_schedule}`);
    },
    deleteSchedule(id_schedule) {
      ScheduleDataService.deleteSchedule(id_schedule).then(() => {
        this.refreshSchedules();
      });
    },
  },
  created() {
    this.refreshSchedules();
  },
};
</script>