import axios from 'axios'


const API_URL = 'http://localhost:8080/'


class DataService { // не работает add
//Trainer
    retrieveAllTrainers() {
        return axios.get(`${API_URL}/trainers/getTrainers`);
    }

    retrieveTrainer(id_trainer) {
        return axios.get(`${API_URL}/trainers/getTrainerById`, id_trainer);
    }

    deleteTrainer(id_trainer) {

        return axios.delete(`${API_URL}/trainers/${id_trainer}`);
    }

    updateTrainer(id_trainer, trainer) {

        return axios.post(`${API_URL}/trainers/updateTrainer`, trainer);
    }

    createTrainer(trainer) {

        return axios.post(`${API_URL}/trainers/insertTrainer`, trainer);
    }


//Learner-------------------
    retrieveAllLearners() {
        return axios.get(`${API_URL}/learners/getLearners`);
    }

    retrieveLearner(id_learner) {
        return axios.get(`${API_URL}/learners/getLearnerById`, id_learner);
    }

    deleteLearner(id_learner) {

        return axios.delete(`${API_URL}/learners/${id_learner}`);
    }

    updateLearner(id_learner, learner) {

        return axios.put(`${API_URL}/learners/updateLearner`, learner);
    }

    createLearner(learner) {

        return axios.post(`${API_URL}/learners/insertLearner`, learner);
    }

//Place
    retrieveAllPlaces() {
        return axios.get(`${API_URL}/places/getPlaces`);
    }

    retrievePlace(id_place) {
        return axios.get(`${API_URL}/places/getPlaceById`, id_place);
    }

    deletePlace(id_place) {

        return axios.delete(`${API_URL}/places/${id_place}`);
    }

    updatePlace(id_place, place) {

        return axios.post(`${API_URL}/places/updatePlace`, place);
    }

    createPlace(place) {

        return axios.post(`${API_URL}/places/insertPlace`, place);
    }

//Section--------------------
    retrieveAllSections() {
        return axios.get(`${API_URL}/sections/getSections`);
    }

    retrieveSection(id_section) {
        return axios.get(`${API_URL}/sections/getSectionById`, id_section);
    }

    deleteSection(id_section) {

        return axios.delete(`${API_URL}/sections/${id_section}`);
    }

    updateSection(id_section, section) {

        return axios.post(`${API_URL}/sections/updateSection`, section);
    }

    createSection(section) {

        return axios.post(`${API_URL}/sections/insertSection`, section);
    }

//Schedule-----------------
    retrieveAllSchedules() {
        return axios.get(`${API_URL}/schedules/getSchedules`);
    }

    retrieveSchedule(id_schedule) {
        return axios.get(`${API_URL}/schedules/getScheduleById`, id_schedule);
    }

    deleteSchedule(id_schedule) {

        return axios.delete(`${API_URL}/schedules/${id_schedule}`);
    }

    updateSchedule(id_schedule, schedule) {

        return axios.post(`${API_URL}/schedules/updateSchedule`, schedule);
    }

    createSchedule(schedule) {

        return axios.post(`${API_URL}/schedules/insertSchedule`, schedule);
    }

//HeaderSchedule
    retrieveAllHeaderSchedules() {
        return axios.get(`${API_URL}/headerschedules/getHeaderSchedules`);
    }

    retrieveHeaderSchedule(id_header_schedule) {
        return axios.get(`${API_URL}/headerschedules/getHeaderScheduleById`, id_header_schedule);
    }

    deleteHeaderSchedule(id_header_schedule) {

        return axios.delete(`${API_URL}/headerschedules/${id_header_schedule}`);
    }

    updateHeaderSchedule(id_header_schedule, headerschedule) {

        return axios.post(`${API_URL}/headerschedules/updateHeaderSchedule`, headerschedule);
    }

    createHeaderSchedule(headerschedule) {

        return axios.post(`${API_URL}/headerschedules/insertHeaderSchedule`, headerschedule);
    }

}

export default new DataService()