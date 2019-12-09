var genre = new Vue({
    el: '#cmb-genre',
    data: function () {
        return {
            genres: [
                {
                    id: 0,
                    bezeichnung: '',
                }
            ]
        }
    },
    mounted: function () {
        this.getGenres();

    },
    methods: {
        getGenres: function () {
            // HTTP.Request
            //  TODO: Get Names Array 

 
            axios.get('http://localhost:8080/fave/genre')
            .then((response) => {
                this.genres = response.data
            })
 
//             axios.get('http://localhost:8080/fave/genre')
// .then ((res) => {alert(JSON.stringify(res.data))})



            // var arrGenre = []
            // arrGenre.push({ bezeichnung: "Hip Hop", id: 1 })
            // arrGenre.push({ bezeichnung: "Pop", id: 2 })
            // arrGenre.push({ bezeichnung: "Reggae", id: 3 })
            // this.genres = arrGenre
        }
    }
})