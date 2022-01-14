<template>
  <div class="container">
    <main-header/>
    <h3>Данные о секциях</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
        <tr>
          <th>Наименование секции</th>
          <th>Тренер</th>
          <th>Обновить</th>
          <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="section in sections" v-bind:key="section.id_section">
          <td>{{ section.section_name }}</td>
          <td>{{ section.id_trainer }}</td>
          <td>
            <button class="btn" v-on:click="updateSection(section.id_section)">
              Update
            </button>
          </td>
          <td>
            <button class="btn" v-on:click="deleteSection(section.id_section)">
              Delete
            </button>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn" v-on:click="addSection()">Добавить</button>
      </div>
    </div>
  </div>
</template>
<script>
import SectionDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Sections",
  components: {MainHeader},
  data() {
    return {
      sections: [],
      trainers: [],
      message: "",
    };
  },
  methods: {
    refreshSections() {
      SectionDataService.retrieveAllSections().then((res) => {
        this.sections = res.data;
      });
      SectionDataService.retrieveAllTrainers().then((res) =>{
        this.trainers = res.data;
      });
    },
    addSection() {
      this.$router.push(`/sections/-1`);
    },
    updateSection(id_section) {
      this.$router.push(`/sections/${id_section}`);
    },
    deleteSection(id_section) {
      SectionDataService.deleteSection(id_section).then(() => {
        this.refreshSections();
      });
    },
  },
  created() {
    this.refreshSections();
  },
};
</script>