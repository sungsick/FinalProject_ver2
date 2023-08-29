

function easyFlightSearch(num) {
    var startAirport = "";
    var endAirport = "";

    var now = new Date();
    var startDate = new Date(now.setDate(now.getDate()+7))
    var year = startDate.getFullYear();
    var month = String(startDate.getMonth() + 1).padStart(2, "0");
    var date = String(startDate.getDate()).padStart(2, "0");

    startDate = year + "-" + month + "-" + date;

    console.log(startDate);
    switch (num) {
        case 0:
            startAirport = "NAARKSS";
            endAirport = "NAARKPC";
            break;
        case 1:
            startAirport = "NAARKSS";
            endAirport = "NAARKPK";
            break;
        case 2:
            startAirport = "NAARKSS";
            endAirport = "NAARKJY";
            break;
        case 3:
            startAirport = "NAARKPC";
            endAirport = "NAARKTU";
            break;
    }
    console.log(num);
    console.log(startAirport);
    console.log(endAirport);
    location.href="/store/flight/flights?startAirport=" + startAirport + "&endAirport=" + endAirport + "&startDate=" + startDate + "&pageNo=" + 1;


}