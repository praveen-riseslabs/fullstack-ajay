<template>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h2 class="mb-4">Login</h2>
                <form @submit.prevent="loginUser">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username:</label>
                        <input type="text" class="form-control" v-model="loginRequest.username" required />
                    </div>

                    <div class="mb-3">
                        <label for="password" class="form-label">Password:</label>
                        <input type="password" class="form-control" v-model="loginRequest.password" required />
                    </div>

                    <button type="submit" value="login" class="btn btn-primary">
                        Login
                    </button>
                    <h6 class="p-4" >Not Yet Regestered? <router-link to="/register">Register Now</router-link></h6>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "LoginPage",
    data() {
        return {
            loginRequest: {
                username: "",
                password: "",
            },
        };
    },
    methods: {
        async loginUser() {
    try {
        const response = await axios.post("localhost:8080/user/login", this.loginRequest);

        if (response.status === 200) {
            const userData = response.data;
            localStorage.setItem('user', JSON.stringify(userData));
            this.$router.push('/dashboard');
        } else {
            // Handle login failure
            // ...
        }
    } catch (error) {
        console.error("Login error:", error);
        // Handle other errors if needed
    }
}

    }
};
</script>


<style scoped>
/* Add scoped styles if needed */
</style>
