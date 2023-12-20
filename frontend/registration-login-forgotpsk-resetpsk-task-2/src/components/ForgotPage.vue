<template>
  <div class="registration-box">
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <h2 class="mb-4">Forgot Password</h2>
        <form @submit.prevent="resetPassword">
          <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" v-model="email" required />
          </div>

          <button type="submit" class="btn btn-primary">
            Submit
          </button>
        </form>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "ForgotPassword",
  data() {
    return {
      email: "",
    };
  },
  methods: {
    async resetPassword() {
      try {
        const response = await axios.post("http://localhost:8085/forgotpassword", { email: this.email });

        // Assuming a successful response
        alert(response.data);
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
