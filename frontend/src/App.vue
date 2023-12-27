<template>
    <nav class="navbar navbar-expand-lg stats" data-bs-theme="dark">
    <div class="container">
      <a class="navbar-brand" href="#"><img src="../src/img/logo.webp" alt=""></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link class="nav-link active" to="/">Home</router-link>
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
              alt="profile" />
          </div>
          <div class="col p-2 mx-0">
            <div class="dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Profile
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li>
                  <router-link to="/login" class="nodecoration dropdown-item">Logout</router-link>
                </li>
              </ul>
            </div>

          </div>
          <div class="col">
              <a class="btn btn-outline-light " data-bs-toggle="offcanvas" href="#offcanvasExample" role="button"
                aria-controls="offcanvasExample">
                <i class="text-white fa-solid fa-bars"></i>
              </a>
            </div>
        </div>
        <div v-else>
          <div class="mx-3">
            <button type="submit" value="login" class="btn btn-outline-light">
              <router-link to="/login" class="nodecoration">Login Now</router-link>
              <!-- <a href="/login">Login Now </a> -->
            </button>
          </div>
        </div>
        </div>

      </div>
    
  </nav>

  <!-- used Offcanvas from bootstrap  -->

  <div class="offcanvas offcanvas-start stats" tabindex="-1" id="offcanvasExample"
    aria-labelledby="offcanvasExampleLabel">
    <div class="offcanvas-header">
      <h5 class="offcanvas-title text-white" id="offcanvasExampleLabel"><img src="../src/img/logo.webp" alt=""></h5>
      <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div>
      <ul class="nav nav-pills flex-column mt-4">
        <li class="nav-item py-2 py-sm-0">
          <a href="#" class="nav-link text-white" aria-current="page"><i class="fa-solid fa-gauge"></i><span
              class="fs-4 d-none ms-3 d-sm-inline">Dashboard</span>
          </a>
        </li>
        <li class="nav-item py-2 py-sm-0">
          <a href="#" class="nav-link text-white" aria-current="page"><i class="fa-solid fa-house"></i><span
              class="fs-4 d-none ms-3 d-sm-inline">Home</span>
          </a>
        </li>
        <li class="nav-item py-2 py-sm-0">
          <a href="#" class="nav-link text-white border-warning-subtle" aria-current="page"><i
              class="fs-5  fa-solid fa-border-all"></i><span class="fs-4 ms-3 d-none d-sm-inline">Articles</span>
          </a>
        </li>
        <li class="nav-item py-2 py-sm-0">
          <a href="#" class="nav-link text-white" aria-current="page"><i class="fa-solid fa-clipboard"></i><span
              class="fs-4 ms-3 d-none d-sm-inline">products</span>
          </a>
        </li>
        <li class="nav-item py-2 py-sm-0">
          <a href="#" class="nav-link text-white" aria-current="page"><i class="fa-solid fa-arrow-up-z-a"></i><span
              class="fs-4 d-none ms-3 d-sm-inline">Order</span>
          </a>
        </li>
        <li class="nav-item py-2 py-sm-0">
          <a href="#" class="nav-link text-white" aria-current="page"><i class="fa-solid fa-user"></i><span
              class="fs-4 d-none ms-3 d-sm-inline">Customers</span>
          </a>
        </li>

      </ul>
      <div class="dropdown open dropdown  p-2">
        <button class="btn border-0 stats btn-secondary text-white dropdown-toggle" type="button" id="triggerId"
          data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fa-solid fa-user"></i><span class="ms-2"> Yourself</span>
        </button>
        <div class="dropdown-menu" aria-labelledby="triggerId">
          <button class="dropdown-item" href="#">setting</button>
          <button class="dropdown-item disabled" href="#">
            profile
          </button>
        </div>
      </div>
    </div>
  </div>
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
