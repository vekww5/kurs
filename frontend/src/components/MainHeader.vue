<template>
  <header>
    <div class="container">
      <div class="links">
        <img src="@/assets/sport_logo.png" class="img-logo" alt="logo">
        <router-link :to="{ name: 'Schedules' }">
          Расписание
        </router-link>
        <router-link :to="{ name: 'Sections' }">
          Секции
        </router-link>
        <router-link :to="{ name: 'Trainers' }">
          Тренера
        </router-link>
        <router-link :to="{ name: 'Learners' }">
          Учащиеся
        </router-link>
        <button type="button" class="btn btn-in-out">
          {{ 'Войти' /*auth ? 'Выйти' : 'Войти'*/ }}
        </button>
      </div>
    </div>
  </header>

</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>
.router-link-active {
  color: red;
}

.container {
  margin-top: 0;
  display: flex;
  align-items: baseline;
  background: #f7f8f2;
}

a {
  text-decoration: none;
  color: #2c7ecc;
  font-size: 25px;
  padding-right: 30px;
}

.links {
  display: flex;
  flex-grow: 1;
  align-items: center;
}

.btn {
  margin-left: auto;
  width: auto;
  align-items: center;
  margin-bottom: 0;
}

.img-logo {
  padding: 12px 30px;
  width: 50px;
}

</style>
