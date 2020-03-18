var apiclient = ( function () {

    var getAirportsByName = (function (callback,name) {

        axios({
            method: 'GET',
            url: '/airportsfinder/getairportsbyname/'+name,

        })
            .then(response => callback(response.data))
            .catch(error => console.log(error));
    });

    return{
        getAirportsByName:getAirportsByName,
    }
})();
