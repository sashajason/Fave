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
          <a href="artist.html"><img v-bind:src="artistImage" class="card-img-top" alt="photo"></a>
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
        artistsRow1: [],
        artistsRow2: []
      },
      mounted: function () {
        this.getArtistsRow1();
        // this.getArtistsRow2();
      },
      methods: {
        getArtistsRow1: function () {
          // HTTP.Request
          // TODO: Get Names Array 
  
          axios.get('http://localhost:8080/fave/artists')
            .then((response) => {
              for (i = 0; i < response.data.length; i++) {
                if (i < 4) {
                  this.artistsRow1.push(response.data[i])
                }
                else if (i < 8){
                  this.artistsRow2.push(response.data[i])
                }
              }
            })
  
          // var arrArtistsRow1 = []
          // arrArtistsRow1.push({ id: "1", imgsrc: "Slides/wutang.jpg", name: "Wu-Tang Clan", investition: "2345.00", anzvotes: "645" })
          // arrArtistsRow1.push({ id: "2", imgsrc: "Slides/mobb.jpg", name: "Mobb Deep", investition: "2345.00", anzvotes: "645" })
          // arrArtistsRow1.push({ id: "3", imgsrc: "Slides/roots.jpg", name: "The Roots", investition: "2345.00", anzvotes: "645" })
          // arrArtistsRow1.push({ id: "4", imgsrc: "Slides/cnn.jpg", name: "CNN", investition: "2345.00", anzvotes: "645" })
  
          // this.artistsRow1 = arrArtistsRow1
        },
        getArtistsRow2: function () {
          // HTTP.Request
          //  TODO: Get Names Array 
          // var arrArtistsRow2 = []
          // arrArtistsRow2.push({ id: "5", imgsrc: "Slides/apollo.jpg", name: "Apollo Brown", investition: "2345.00", anzvotes: "645" })
          // arrArtistsRow2.push({ id: "6", imgsrc: "Slides/immortal.jpg", name: "Immortal Technique", investition: "2345.00", anzvotes: "645" })
          // arrArtistsRow2.push({ id: "7", imgsrc: "Slides/lox.jpg", name: "The LOX", investition: "2345.00", anzvotes: "645" })
          // arrArtistsRow2.push({ id: "8", imgsrc: "Slides/gibbs.jpg", name: "Freddie Gibbs", investition: "2345.00", anzvotes: "645" })
          // this.artistsRow2 = arrArtistsRow2
        },
  
  
      }
    })