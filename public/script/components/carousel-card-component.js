Vue.component('carouselcardcomponent', {
  data: function () {
    return {}
  },
  props: ['artistImage', 'name', 'investition', 'anzvotes', 'artistid'],
  template:
    `<div>
          <div class="card">
        <!--Card image-->
        <div class="view">
          <img v-bind:src="artistImage" class="card-img-top" alt="photo">
          <a href="#">
            <div class="mask rgba-white-slight"></div>
          </a>
        </div>
        <!--Card content-->
        <div class="card-body" id="voteButton">
          <!--Title-->
          <h5 class="card-title">{{name}}</h5>
            <div class="row">
              <div class="col">
                <img id="carousel-icons" src="Icons/votes.png">
                <p id="carousel-icon-text">{{anzvotes}}</p>
              </div>
              <div class="col">
                <img id="carousel-icons" src="Icons/pot.png">
                <p id="carousel-icon-text">{{investition}}</p>
              </div>
            </div> 
            <vote-button-component v-bind:anzvotes="anzvotes" v-bind:investition="investition" v-bind:artistid="artistid"></vote-button-component>
        </div>
        </div>
      </div>`,
})


var carousel = new Vue(
  {
    el: '#favoritecarousel',
    data: {
      carouselArtists: [],
      artistsRow1: [],
      artistsRow2: [],
    },

    mounted: function () {
      this.getArtists();
    },
    methods: {
      getVoteInformation: async function (cartist) {
        varInvestition = 0
        varVotes = 0

        await axios.get('http://localhost:8080/fave/artistVotes/' + cartist.id)
          .then((response) => {

            response.data.forEach(element => {
              varVotes += 1;
              varInvestition = varInvestition + element.investition
            });

            cartist.investition = varInvestition;
            cartist.anzVotes = varVotes;
            this.carouselArtists.push(cartist)

          })
      },


      getCarouselitems: async function (totalartists) {

        //Create the Carousel Artist Objects
        for (var i = 0, len = totalartists.length; i < len; i++) {
          element = totalartists[i]
          var newCarouselArtist = new CarouselArtist(element.artistId, element.artistImage, element.name, element.beschreibung)
          await this.getVoteInformation(newCarouselArtist)
        };
      },

      getArtists: async function () {

        axios.get('http://localhost:8080/fave/artists')
          .then((response) => {
            var totalartists = response.data
            this.getCarouselitems(totalartists).then(this.fillCarouselArtists)

          })
      },

      fillCarouselArtists: function () {
        //Fill the Artist Rows in the Carousel 
        for (i = 0; i < this.carouselArtists.length; i++) {
          var artist = this.carouselArtists[i]

          if (i < 4) {
            this.artistsRow1.push(artist)
          }
          else if (i < 8) {
            this.artistsRow2.push(artist)
          }
        }
      },
    }
  })