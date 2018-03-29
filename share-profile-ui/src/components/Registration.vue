<template>
  <div id="registration">
    <div class="registration-fields">
      <md-field>
        <label>Username</label>
        <md-input v-model="username"></md-input>
      </md-field>
      <md-field>
        <label>Password</label>
        <md-input v-model="password" type="password"></md-input>
      </md-field>
      <md-field>
        <label>Repeat Password</label>
        <md-input v-model="repeatPassword" type="password"></md-input>
      </md-field>
      <md-field>
        <label>Email</label>
        <md-input v-model="email" type="email" required></md-input>
        <span class="md-error">Firstname is required</span>
      </md-field>
      <md-field>
        <label>Firstname</label>
        <md-input v-model="firstname" required></md-input>
        <span class="md-error">Firstname is required</span>
      </md-field>
      <md-field>
        <label>Surname</label>
        <md-input v-model="surname" required></md-input>
      </md-field>

      <div>
        <md-button class="md-raised md-accent" v-on:click="register()">Register</md-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Registration',
  data: function data () {
    return {
      required: null,
      repeatPassword: null,
      firstname: null,
      surname: null,
      email: null,
      username: null,
      encodedUserCredentials: null
    }
  },
  methods: {
    register () {
      var params = new URLSearchParams()
      params.append('username', this.username)
      params.append('password', this.password)
      params.append('email', this.email)
      params.append('firstName', this.firstname)
      params.append('surnName', this.surname)
      this.axios.post('http://localhost:1337/users/register', params, { headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }}).then(function (response) {
        console.log(response)
      })
    }
  }
}

</script>

<style scoped>
.registration-fields {
  width: 25%;
  height: 25%;
  margin: 0 auto;
}
</style>
