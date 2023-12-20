<template>
    <div class="container mt-5">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <h2 class="mb-4">Registration Form</h2>
          <form @submit.prevent="saveData">
  
            <div class="mb-3">
              <label for="name" class="form-label">Name:</label>
              <input type="text" class="form-control" name="name" v-model="user.name" required>
            </div>
  
            <div class="mb-3">
              <label for="username" class="form-label">Username:</label>
              <input type="text" class="form-control" name="username" v-model="user.username" required>
            </div>
  
            <div class="mb-3">
              <label for="email" class="form-label">Email:</label>
              <input type="email" class="form-control" name="email" v-model="user.email" required>
            </div>
  
            <div class="mb-3">
              <label for="phone" class="form-label">Phone:</label>
              <input type="text" class="form-control" name="phone" v-model="user.phone" required>
            </div>
  
            <div class="mb-3">
              <label for="password" class="form-label">Password:</label>
              <input type="password" class="form-control" name="password" v-model="user.password" required>
            </div>
  
            <div class="mb-3">
              <label for="gender" class="form-label">Gender:</label>
              <select class="form-select" v-model="user.gender" name="gender" required>
                <option value="male">Male</option>
                <option value="female">Female</option>
              </select>
            </div>
  
            <button type="submit" class="btn btn-primary">Register</button>
          </form>
  
          <div class="text-center mt-3">
            <h6>Already Registered? <router-link to="/login" class="btn btn-link">Login Now</router-link></h6>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  
  <script>
  import axios from 'axios';
  
  export default {
    name: "RegistrationForm",
    data() {
      return {
        result: {},
        user: {
          name: '',
          username: '',
          email: '',
          phone: '',
          password: '',
          gender: ''
        }
      };
    },
    methods: {
      saveData() {
        axios.post("http://localhost:8085/user/save", this.user)
          .then(({ data }) => {
            console.log(data);
            try {
              alert("User Registration Successfull");
            } catch (err) {
              alert("failed");
            }
          })
          .catch(error => {
            console.error('Error during registration:', error);
            alert('Registration failed. Please try again.');
          });
      }
    }
  }
  </script>
  
  
  
  <style scoped>
  /* Add your component-specific styles here */
  </style>
  