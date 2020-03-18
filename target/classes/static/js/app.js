var app = (function(){
    var generarTabla = function(name){
        apiclient.getAirportsByName(crearTabla,name);
    }

    var crearTabla = (function (aeropuertos) {

        $("#filasAeropuerto").empty();
        aeropuertos.map(function(element){
            var markup = "<tr> <td>"+ element.code +"</td> <td>"+element.name+"</td> <td>"+ element.city +"</td> <td>"+ element.countryCode +"</td> </tr>";
            $("#filasAeropuerto").append(markup)
        })
        plotMarkers(aeropuertos);
    })
    return{
        generarTabla:generarTabla,
    }
})();