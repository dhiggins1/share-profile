<template>
  <div id="dashboard">
    <md-button class="md-dense md-raised md-primary" v-on:click="cryptoRequest()">Populate Coin Base</md-button>
    <div class="md-layout md-gutter">
      <div class="md-layout-item md-size-100">
        <div class="inputInvestment">
        <md-field id="usersField">
          <v-select :options="currencyCode" :on-change="getCurrencySelected" placeholder="Currency" style="width:100%;"></v-select>
        </md-field>
        <md-field>
          <label>Enter Investment Total</label>
          <md-input v-model="amountInvested"></md-input>
        </md-field>
        </div>
          <md-button class="md-dense md-raised md-primary" v-on:click="getInvestmentValue(amountInvested, sourceCurrency)">Enter Value</md-button>
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
      currencyCodeToName: [],
      amountInvested: 0,
      calculatedValue: 0
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
            self.currencyCodeToName[response.data.Data[key].FullName] = key
            i++
          })
          console.log(self.currencyCodeToName)
        })
    },

    getInvestmentValue (currencyValue, currencyCode) {
      let self = this
      let requestURL = 'https://min-api.cryptocompare.com/data/price?fsym=' + this.sourceCurrency + '&tsyms=EUR'
      this.axios.get(requestURL)
        .then(response => {
          let currRate = response.data.EUR
          this.calculateCurrencyConversion(currRate)
          console.log(this.calculatedValue)
        })
      console.log(this.sourceCurrency)
    },

    getCurrencySelected (value) {
      this.sourceCurrency = this.currencyCodeToName[value.label]
    },

    calculateCurrencyConversion (currRate) {
      this.calculatedValue = currRate * this.amountInvested
    }
  },
  components: {
    vSelect
  }
}
</script>

<style scoped>
#usersField {
  width: 25%;
  height: 25%;
  margin: 0 auto;
}

.inputInvestment {

  margin: 0 auto;
}
</style>
