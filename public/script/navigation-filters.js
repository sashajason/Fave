var filter = new Vue({
    el: '#filter',
    data: function () {
        return {}
    },
    methods: {
        getPopular: function () {
            // HTTP.Request
            //  TODO: Get Favorites
            var arrGenre = []
            arrGenre.push({ bezeichnung: "Hip Hop", id: 1 })
        },
        getConfirmed: function () {
            // HTTP.Request
            //  TODO: Get Favorites
        },
        getRecommendations: function () {
            // HTTP.Request
            //  TODO: Get Favorites
        },
        search: function () {
            alert("die Suchfunktion ist in Bearbeitung!")
        }

    }
})