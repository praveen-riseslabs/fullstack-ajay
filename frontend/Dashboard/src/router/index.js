import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import Login from "../components/LoginPage.vue";
import Register from "../components/RegisterPage.vue";
import Forgotpassword from "../components/ForgotPage.vue"
import Reset from "../components/ResetPage.vue"


// import DashboardView from "../views/DashboardView.vue";

const routes = [
  {
    path: "/dashboard",
    name: "home",
    component: HomeView,
  },
  {
    path: "/login",
    name: "LoginPage",
    component: Login,
  },
  {
    path: "/register",
    name: "RegisterPage",
    component: Register,
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
  // {
  //   path: "/dashboard",
  //   name: "Dashboard",
  //   component: DashboardView,
  // },
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
