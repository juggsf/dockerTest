import { createRouter, createWebHistory } from "vue-router";
import LoginView from "./views/LoginView.vue";
import ProfileView from "./views/ProfileView.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", redirect: "/login" },
    { path: "/login", component: LoginView },
    { path: "/profile", component: ProfileView }
  ]
});

export default router;
