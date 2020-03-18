var apiclient = ( function () {

    var getAirportsByName = (function (callback,name) {

        axios({
            method: 'GET',
            url: 'http://localhost:8080/airportsfinder/getairportsbyname/'+name,

        })
            .then(response => callback(response.data))
            .catch(error => console.log(error));
    });

    return{
        getAirportsByName:getAirportsByName,
    }
})();
