<template>
  <div id="hello">

    <div class="login-fields">
      <md-field md-inline>
        <md-input placeholder="Username" v-model="username"></md-input>
      </md-field>

      <md-field md-inline :md-toggle-password="true">
        <md-input placeholder="Password" v-model="password" type="password"></md-input>
      </md-field>

      <div>
        <md-button class="md-raised md-primary" v-on:click="login()">Login</md-button>
      </div>
      Don't have an account? Register below
      <div>
        <md-button class="md-raised md-accent" v-on:click="navToRegistration()">Register</md-button>
      </div>
    </div>
  </div>
</template>

<script>
// import sha256 from 'sha256'
import base64 from 'base-64'
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      initial: 'Initial Value',
      username: null,
      password: null
    }
  },
  methods: {
    navToRegistration: function () {
      this.$router.push('/Registration')
    },

    login () {
      var params = new URLSearchParams()
      params.append('username', this.encodeCredentials())
      this.axios.post('http://localhost:1337/users/login', params, { headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }}).then((response) => {
        console.log(response)
        if (response.data.userId !== 0) {
          this.$router.push('/Dashboard')
        }
      }).catch((error) => {
        console.log(error)
      })
    },

    encodeCredentials () {
      // var pwd = sha256(this.password)
      var credentials = this.username + ':' + this.password
      console.log(credentials)
      return base64.encode(credentials)
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
