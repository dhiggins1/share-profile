<template>
  <div id="hello">

    <div class="login-fields">
      <md-field md-inline>
        <md-input placeholder="Username"></md-input>
      </md-field>

      <md-field md-inline :md-toggle-password="true">
        <md-input placeholder="Password" v-model="password" type="password"></md-input>
      </md-field>

      <div>
        <md-button class="md-raised md-primary">Login</md-button>
      </div>
      Don't have an account? Register below
      <div>
        <md-button class="md-raised md-accent" v-on:click="navToRegistration()">Register</md-button>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      initial: 'Initial Value',
      password: ''
    }
  },
  methods: {
    navToRegistration: function () {
      this.$router.push('/Registration')
    }
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.login-fields {
  width: 25%;
  height: 25%;
  margin: 0 auto;
}
</style>
