<template>
    <div class="container mt-5">
      <h2>Welcome</h2>
      <!-- Display other user details as needed -->
    </div>
  </template>
  
  <script>
  export default {
    name: "DashboardPage",
    data() {
      return {
        user: null,
      };
    },
    mounted() {
      // Retrieve user data from local storage
      const storedUser = localStorage.getItem('user');
      if (storedUser) {
        this.user = JSON.parse(storedUser);
      } else {
        // Handle the case where there's no user data in storage (e.g., user not logged in)
        // Redirect to login or handle accordingly
      }
    },
  };
  </script>
  
  <style scoped>
  /* Add scoped styles if needed */
  </style>
  