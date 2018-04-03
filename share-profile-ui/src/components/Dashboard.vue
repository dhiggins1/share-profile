<template>
  <div id="dashboard">
    <md-button class="md-dense md-raised md-primary" v-on:click="cryptoRequest()">Populate Coin Base</md-button>
    <div class="md-layout md-gutter">
      <div class="md-layout-item md-size-100">
        <md-field id="usersField">
          <v-select multiple :options="currencyCode" v-model="codes" placeholder="Users" style="width:100%;"></v-select>
          <span class="md-error">The dashboard users must be selected</span>
        </md-field>
      </div>
    </div>
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
          var i = 0
          Object.keys(response.data.Data).forEach(function (key) {
            self.currencyCode.push({label: response.data.Data[key].FullName, value: i})
            i++
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
