import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
    mode: 'history',
    routes: [	// вывод таблиц (для проверки, ненужные позже убрать)
        {
            path: "/",
            name: "mainForm",
            component: () => import("./components/mainForm"),
        },
        {
            path: "/trainers",
            name: "Trainers",
            component: () => import("./components/Trainers"),
        },
        {
            path: "/learners",
            name: "Learners",
            component: () => import("./components/Learners"),
        },
        {
            path: "/sections",
            name: "Sections",
            component: () => import("./components/Sections"),
        },
        {
            path: "/places",
            name: "Places",
            component: () => import("./components/Places"),
        },
        {
            path: "/schedules",
            name: "Schedules",
            component: () => import("./components/Schedules"),
        },
        {
            path: "/headerschedules",
            name: "HeaderSchedules",
            component: () => import("./components/HeaderSchedules"),
        },//add
        {
            path: "/trainers/:id_trainer",
            name: "Trainer",
            component: () => import("./components/addTrainer"),
        },
        {
            path: "/learners/:id_learner",
            name: "Learner",
            component: () => import("./components/addLearner"),
        },
        {
            path: "/sections/:id_section",
            name: "Section",
            component: () => import("./components/addSection"),
        },
        {
            path: "/places/:id_place",
            name: "Place",
            component: () => import("./components/addPlace"),
        },
        {
            path: "/schedules/:id_schedule",
            name: "Schedule",
            component: () => import("./components/addSchedule"),
        },
        {
            path: "/headerschedules/:id_header_schedule",
            name: "HeaderSchedules",
            component: () => import("./components/addHeaderSchedule"),
        },
    ]
});

export default router;