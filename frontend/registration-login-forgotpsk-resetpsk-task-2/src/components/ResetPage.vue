<template>
    <div class="container mt-5">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <h2 class="mb-4">{{ pageTitle }}</h2>
          <form @submit.prevent="resetPassword">
            <div v-if="message" class="alert alert-danger" role="alert">
              {{ message }}
            </div>
  
            <div v-if="!message">
              <div class="mb-3">
                <label for="password" class="form-label">New Password:</label>
                <input type="password" class="form-control" v-model="password" required />
              </div>
  
              <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm Password:</label>
                <input type="password" class="form-control" v-model="confirmPassword" required />
              </div>
  
              <button type="submit" class="btn btn-primary">
                Reset Password
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import axios from "axios";
  
  export default {
    name: "ResetPassword",
    data() {
      return {
        token: "", // Received from the server when displaying the form
        pageTitle: "",
        message: "",
        password: "",
        confirmPassword: "",
      };
    },
    created() {
      // Fetch the token and pageTitle from the server when the component is created
      this.token = this.$route.query.token;
      this.fetchResetPasswordInfo();
    },
    methods: {
      async fetchResetPasswordInfo() {
        try {
          const response = await axios.get(`/reset_password?token=${this.token}`);
          this.pageTitle = response.data.pageTitle;
  
          if (response.data.message) {
            this.message = response.data.message;
          }
        } catch (error) {
          console.error("Error fetching reset password info:", error);
          // Handle other errors if needed
        }
      },
      async resetPassword() {
        if (this.password !== this.confirmPassword) {
            alert("Passwords do not match");
          return;
        }
  
        try {
          const response = await axios.post(`/reset_password?token=${this.token}`, { password: this.password });
          alert(response.data); // Show an alert or handle success as needed
          // Optionally, you can navigate to a different page after successful password reset
        } catch (error) {
          console.error("Reset password error:", error);
          // Handle other errors if needed
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* Add scoped styles if needed */
  </style>
  