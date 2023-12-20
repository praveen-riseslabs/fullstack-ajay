<template>
  <div class="home">
    
    <HelloWorld msg="Ajay Task-1 Frontend Using Vue.js, Bootstrap" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "HomeView",
  components: {
    HelloWorld,
  },
};
</script>
