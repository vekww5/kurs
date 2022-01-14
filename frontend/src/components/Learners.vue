<template>
  <div class="container">
    <main-header/>
    <h3>Данные обо всех учениках</h3>
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
          <th>Секция</th>
          <th>Зачислен</th>
          <th>Обновить</th>
          <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="learner in learners" v-bind:key="learner.id_learner">
          <td>{{ learner.last_name }}</td>
          <td>{{ learner.first_name }}</td>
          <td>{{ learner.middle_name }}</td>
          <td>{{ learner.phone }}</td>
          <td>{{ learner.birthday }}</td>
          <td>{{ learner.id_section }}</td>
          <td>{{ learner.enrolled }}</td>
          <td>
            <button class="btn" v-on:click="updateLearner(learner.id_learner)">
              Update
            </button>
          </td>
          <td>
            <button class="btn" v-on:click="deleteLearner(learner.id_learner)">
              Delete
            </button>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addLearner()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import LearnerDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Learners",
  components: {MainHeader},
  data() {
    return {
      learners: [],
      message: "",
    };
  },
  methods: {
    refreshLearners() {
      LearnerDataService.retrieveAllLearners().then((res) => {
        this.learners = res.data;
      });
    },
    addLearner() {
      this.$router.push(`/learners/-1`);
    },
    updateLearner(id_learner) {
      this.$router.push(`/learners/${id_learner}`);
    },
    deleteTrainer(id_learner) {
      LearnerDataService.deleteLearner(id_learner).then(() => {
        this.refreshLearners();
      });
    },
  },
  created() {
    this.refreshLearners();
  },
};
</script>