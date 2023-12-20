<template>
  <div class="registration-box">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <h2 class="mb-4">Registration Form</h2>
        <form @submit.prevent="saveData">
          <div class="grid-x align-center-middle">
            <div class="grid-container">
              <label for="name" class="form-label">Name:</label>
              <input type="text" class="form-control" name="name" v-model="user.name" required>
            </div>

            <div class="grid-container">
              <label for="username" class="form-label">Username:</label>
              <input type="text" class="form-control" name="username" v-model="user.username" required>
            </div>
          </div>


          <div class="grid-x align-center-middle">
            <div class="grid-container">
              <label for="email" class="form-label">Email:</label>
              <input type="email" class="form-control" name="email" v-model="user.email" required>
            </div>

            <div class="grid-container">
              <label for="phone" class="form-label">Phone:</label>
              <input type="text" class="form-control" name="phone" v-model="user.phone" required>
            </div>
          </div>

          <div class="grid-x align-center-middle">
            <div class="grid-container">

              <label for="password" class="form-label">Password:</label>
              <input type="password" class="form-control" name="password" v-model="user.password" required>
            </div>
            <div class="grid-container">
              <label for="confirmPassword" class="form-label">Confirm Password:</label>
              <input type="password" class="form-control" v-model="confirmPassword" required />
            </div>
          </div>
          <fieldset class="grid-container">
            <label>Gender</label>
            <div class="grid-x align-center-middle">

              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" v-model="user.gender" name="gender" id="inlineRadio1"
                  value="male"><label class="form-check-label" for="inlineRadio1">Male</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" v-model="user.gender" name="gender" id="inlineRadio2"
                  value="female"><label class="form-check-label" for="inlineRadio2">Female</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" v-model="user.gender" name="gender" id="inlineRadio3"
                  value="Not_prefered_to_say"><label class="form-check-label" for="inlineRadio3">Not prefered to
                  say</label>

              </div>
            </div>
          </fieldset>
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
      // Validate if passwords match
      if (this.user.password !== this.confirmPassword) {
        this.resetError = 'Passwords do not match.';
        return alert('password not match');
      }
      axios.post("http://localhost:8085/sign-up", this.user)
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
  
  
  
<style>
template{
          background-image: url('https://images.pexels.com/photos/6985001/pexels-photo-6985001.jpeg?auto=compress&cs=tinysrgb&w=1600');
          display: flex;
          align-items: center;
          justify-content: center;
          background-size: 100% 100%;
          background-repeat: no-repeat;

          height: 100vh; /* Make the body take the full height of the viewport */
          margin: 0; /* Remove default margin */
        }

        .registration-box {
          background-color: #f0a7e6; /* White background color */
          padding: 2%;
          box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5); /* Add a subtle box shadow */
          border-radius: 5px; /* Add rounded corners */
          width: auto; /* Set the width of the box */
        }
        .button.cell {
              background-image: url('https://images.pexels.com/photos/6985001/pexels-photo-6985001.jpeg?auto=compress&cs=tinysrgb&w=1600');
              background-size: cover;
              background-position: center;
              background-size: auto;
              color: #fff;
              /* Additional styles for the button */
          }

</style>
  