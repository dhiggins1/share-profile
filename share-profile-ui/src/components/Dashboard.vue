<template>
  <div id="dashboard">
    <p>Hello</p>
    <div class="md-layout md-gutter">
      <div class="md-layout-item md-size-100">
        <md-field id="usersField">
          <v-select :items="currencyCode" v-model="codes" placeholder="Users" style="width:100%;"></v-select>
          <span class="md-error">The dashboard users must be selected</span>
        </md-field>
      </div>
    </div>
    <md-button class="md-dense md-raised md-primary" v-on:click="cryptoRequest()">Raised</md-button>
  </div>
</template>

<script>
import vSelect from 'vue-select'
export default {
  name: 'Dashboard',
  data () {
    return {
      sourceCurrency: null,
      destinationCurrency: null,
      currencyCode: [],
      currencyCodeToName: {}
    }
  },
  methods: {
    cryptoRequest () {
      let self = this
      this.axios.get('https://min-api.cryptocompare.com/data/all/coinlist')
        .then(response => {
          // console.log(response.data.Data)
          // var cryptoKeys = Object.keys(response.data.Data)
          // for (var i = 0; i < cryptoKeys.length; i++) {
          //   console.log(cryptoKeys[i], cryptoKeys[cryptoKeys[i]])
          // }
          // console.log(response.data.Data)
          Object.keys(response.data.Data).forEach(function (key) {
            self.currencyCode.push(response.data.Data[key].FullName)
          })
          console.log(self.currencyCode)
        })
    }
  },
  components: {
    vSelect
  }
}
</script>

<style scoped>

</style>
