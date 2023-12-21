<template>
      <nav class="navbar navbar-expand-lg ">

<div class="container-fluid">
  <a class="navbar-brand">Navbar</a>

  <form class="d-flex" role="search">
    <i class="fa-solid me-3 fa-bell fa-xl"></i>
    <i class="fa-solid me-3 fa-message fa-xl"></i>
    <img src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp" class="rounded-circle me-3" height="25"
      alt="Black and White Portrait of a Man" loading="lazy" />
    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="true">
      Dropdown
    </a>
    <ul class="dropdown-menu">
      <li><a class="d-flex dropdown-item" href="#">Action</a></li>
      <li><a class="dropdown-item" href="#">Another action</a></li>
      <li>
        <hr class="dropdown-divider">
      </li>
      <li><a class="dropdown-item" href="#">Something else here</a></li>
    </ul>
    <button class="btn">hey</button>
  </form>
</div>
</nav> 
  <router-view />
</template>

<style>
@import "@/style.css";
</style>
