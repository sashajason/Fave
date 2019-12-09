Vue.component('vote-button-component', {
    data: function () {
        return {
        }
      },
    methods: {
        addvote: function (investition, anzvotes) {
            var newInvestition = investition + 10
            var newAnzVotes = anzvotes + 1
            // this.anzvotes = newAnzVotes
            // this.investition = newInvestition

        }
    },
    props: ['anzvotes','artistid', 'investition'],
    template:
        `<button class="draw vote" v-on:click="addvote(investition, anzvotes)">Vote</button>`
})


