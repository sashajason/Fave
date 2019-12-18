Vue.component('vote-button-component', {
    data: function () {
        return {
        }
      },
    props: ['anzvotes','artistid', 'investition'],
    template:
        `<button class="draw vote" v-on:click="addvote(investition, anzvotes)">Vote</button>`
})


