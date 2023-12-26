<template>
  <nav class="navbar navbar-expand-lg stats" data-bs-theme="dark">
    <div class="container">
      <a class="navbar-brand" href="#">RISESLABS</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link class="nav-link active" to="/dashboard">Home</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/about">About</router-link>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Services
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider" />
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
        </ul>
        <form class="d-flex" role="search">
          <input class="form-control mx-4" type="search" placeholder="Search" aria-label="Search" />
          <button type="button" class="btn btn-outline-light">Serch</button>
        </form>
        <div v-if="isDashboardPage" class="row">
          <div class="col p-0 mx-3">
            <img class="img-xs rounded-circle mx-1" height="40px" width="35px"
            src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            alt="profile" /></div>
          <div class="col p-2 mx-0"><div class="dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Profile
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider" />
              </li>
              <li><router-link to="/login" class="nodecoration dropdown-item">Logout</router-link></li>
            </ul>
          </div></div>
          
        </div>
        <div v-else>
          <div class="mx-3">
          <button type="submit" value="login" class="btn btn-outline-light ">
            <router-link to="/login" class="nodecoration">Login Now</router-link>
            <!-- <a href="/login">Login Now </a> -->
          </button>
        </div>
        </div>

      </div>
    </div>
  </nav>
  <router-view />
</template>

<script>
export default {
  computed: {
    isDashboardPage() {
      // Use your router or other logic to determine if it's the /dashboard page
      return this.$route.path === "/dashboard";
    },
  },
};
</script>



<style>
@import "/src/style.css";
.nodecoration {
  text-decoration: none; /* Remove underline */
  color: inherit; /* Inherit color from parent */
}
</style>
