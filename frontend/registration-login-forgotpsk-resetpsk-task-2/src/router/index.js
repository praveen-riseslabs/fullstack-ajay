import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import Register from "../components/RegisterPage.vue";
import Login from "../components/LoginPage.vue";
import Dashboard from "../components/DashboardPage.vue"
import Forgotpassword from "../components/ForgotPage.vue"
import Reset from "../components/ResetPage.vue"

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/register",
    name: "RegisterPage",
    component: Register,
  },
  {
    path: "/login",
    name: "LoginPage",
    component: Login,
  },
  {
    path:"/dashboard",
    name: "DashboardPage",
    component : Dashboard
  },
  {
    path:"/forgot-password",
    name: "forgot-password",
    component : Forgotpassword
  },
  {
    path:"/reset_password",
    name: "password-reset",
    component : Reset
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
