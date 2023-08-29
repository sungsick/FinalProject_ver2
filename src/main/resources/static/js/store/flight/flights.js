var pageNo = 1;
var numOfRows = 10;
var thStartAirport = "";
var thEndAirport = "";
var thStartDate = "";
/* 공항 리스트 */
$(function () {

    if($('#thStartAirport') !== undefined){
        thStartAirport = $('#thStartAirport').val();
        thEndAirport = $('#thEndAirport').val();
        thStartDate = $('#thStartDate').val();
    }

    console.log(thStartAirport);
    $.ajax({
        url: '/store/flight/airportList',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            var item = data.response.body.items.item;

            /* 출발 */
            for (var i = 0; i < item.length; i++) {
                var content = `<option value=${item[i].airportId}>
                                  ${item[i].airportNm}
                                  </option>`;

                if (item[i].airportNm === '김포' && thStartAirport === undefined) {
                    content = `<option value=${item[i].airportId} selected>
                                  ${item[i].airportNm}
                                  </option>`;
                    $('#start_airport').append(content);
                    continue;
                } else if(thStartAirport !== undefined && item[i].airportId === thStartAirport){
                    content = `<option value=${item[i].airportId} selected>
                                  ${item[i].airportNm}
                                  </option>`;
                    $('#start_airport').append(content);
                    continue;
                }
                $('#start_airport').append(content);
            }

            /* 도착 */
            for (var i = 0; i < item.length; i++) {
                var content = `<option value=${item[i].airportId}>
                                  ${item[i].airportNm}
                                  </option>`;

                if (item[i].airportNm === '제주') {
                    content = `<option value=${item[i].airportId} selected>
                                  ${item[i].airportNm}
                                  </option>`;
                    $('#end_airport').append(content);
                    continue;
                }
                $('#end_airport').append(content);
            }
        }
    });

    if(thStartAirport !== ""){

    }
});


/* 검색 시작 */
$('#flight_search_btn').on('click', function () {
    pageNo = 1;
    $('.loading_wrap').css('display', 'block'); //검색 모달

    $('.result_title').empty();
    $('.result_table_wrap').empty();

    searchFlight(pageNo, numOfRows);
});

/* 더보기 */
$('.hr-sect').on('click', function () {
    pageNo++;
    searchFlight(pageNo, numOfRows);
});

function searchFlight(pageNo, numOfRows) {

    var totalCount;

    $.ajax({
        url: '/tour/flight/searchFlight',
        type: 'get',
        data: {
            startAirport: $('#start_airport').val(),
            endAirport: $('#end_airport').val(),
            startDate: $('#flight_date').val(),
            pageNo: pageNo,
            numOfRows: numOfRows
        },
        dataType: 'json',
        success: function (data) {
            var itemList = data.response.body.items.item;
            totalCount = data.response.body.totalCount;
            var startAirport = $('#start_airport option:checked').text();
            var endAirport = $('#end_airport option:checked').text();
            var startDate = $('#flight_date').val();
            var dayOfWeek = getDayOfWeek(startDate);
            var item;


            if (pageNo === 1) {
                var title = `<span>${startAirport}</span>` +
                    '<i></i>' +
                    `<span>${endAirport}</span>` +
                    `<span id="result_flight_date">${startDate}(${dayOfWeek})</span>` +
                    `<hr/>` +
                    `<h6>검색결과 : <b id="total_count">${totalCount}</b>건</h6>`

                $('.result_title').append(title);
            }

            if (totalCount === 0) {
                $('.result_table_wrap').empty();
                $('.none_result_table').css('display', 'block');

                $('.loading_wrap').css('display', 'none');
                return;
            } else {
                $('.none_result_table').css('display', 'none');
            }

            if (itemList.length === undefined) {
                item = itemList;
                appendFlight(item);
            } else {
                for (var i = 0; i < itemList.length; i++) {
                    item = itemList[i];
                    appendFlight(item);

                }
            }
            if ((pageNo * numOfRows) < totalCount) {
                $('.hr-sect').css('display', 'flex');
            } else {
                $('.hr-sect').css('display', 'none');
            }
            $('.loading_wrap').css('display', 'none'); //모달 종료
        },
        error: function (request, status, error) {

            console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            $('.loading_wrap').css('display', 'none');
        }
    });
}

function getDayOfWeek(date) { //ex) getDayOfWeek('2022-06-13')

    const week = ['일', '월', '화', '수', '목', '금', '토'];

    const dayOfWeek = week[new Date(date).getDay()];

    return dayOfWeek;
}

function getLogo(airlineName) {

    switch (airlineName) {
        case "아시아나항공" :
            return "asiana.jpg";
        case "에어부산" :
            return "airbusan.jpg";
        case "에어서울" :
            return "airseoul.jpg";
        case "이스타항공" :
            return "eastar.jpg";
        case "플라이강원":
            return "flygangwon.jpg";
        case "하이에어":
            return "hiair.png";
        case "제주항공" :
            return "jejuair.jpg";
        case "진에어" :
            return "jinair.jpg";
        case "대한항공" :
            return "korean.jpg";
        case "티웨이항공" :
            return "tway.jpg";
    }
}

function appendFlight(item) {

    var logo = getLogo(item.airlineNm);
    var startMin = item.depPlandTime.toString().slice(-2);
    var startHour = item.depPlandTime.toString().slice(-4, 10);
    var startTime = startHour + ":" + startMin;
    var endMin = item.arrPlandTime.toString().slice(-2);
    var endHour = item.arrPlandTime.toString().slice(-4, 10);
    var endTime = endHour + ":" + endMin;

    var price = item.economyCharge;

    var img = `<div class="airline_box">
                            <div class="airline_item">
                            <div class="airline_logos">
                            <img src="/img/store/flight/${logo}">
                            </div>
                            <b class="airline_name">${item.airlineNm}</b>
                            </div>
                            </div>`;

    var route = `<div class="airline_route">
                            <span class="start_route">
                            <b>${item.depAirportNm}(${startTime})</b>
                            </span>
                            <span class="end_route">
                            <b>${item.arrAirportNm}(${endTime})</b>
                            </span>
                            </div>`;

    if (price === undefined) {
        price = `<div class="airline_price">
                            <div>
                            <b style="color: red">항공사 문의</b>
                            </div>
                            </div>`;
    } else {
        price = `<div class="airline_price">
                            <div>
                            <b>₩${price.toLocaleString("ko-KR")}</b>
                            </div>
                            </div>`;
    }

    var content = `
                            <div class="result_table">
                            <div class="result_table_inner">
                            <div class="result_schedule">
                            <div class="schedule_item">
                            ${img}
                            ${route}
                            </div>
                            </div>
                            ${price}
                            </div>
                            </div>`;

    $('.result_table_wrap').append(content);
}

/*
    $(function () {
    $.ajax({
        url: '/airportlist',
        type: 'get',
        dataType: 'text',
        success: function (data) {
            let item = JSON.parse(data).response.body.items.item;
            console.log(item);

            for (let i = 0; i < item.length; i++) {
                let option = `<option value=${item[i].airportId}>
                                  ${item[i].airportNm}
                                  </option>`;

                $('#start_airport').append(option);
                // document.getElementById("airport").innerHTML = option;
            }
        },
        error: function (request, status, error) {

            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);

        }
    });


});
    $("#start_airport").change(function (e) {
    console.log(e.target.value);

    $.ajax({
    url: '/airportlist',
    type: 'get',
    dataType: 'text',
    success: function (data) {


    let item = JSON.parse(data).response.body.items.item;

    $('#end_airport').empty();
    for (let i = 0; i < item.length; i++) {
    if (e.target.value !== item[i].airportId) {
    let option = `<option value=${item[i].airportId}>${item[i].airportNm}</option>`;
    $('#end_airport').append(option);
}

    // document.getElementById("airport").innerHTML = option;
}
},
    error: function (request, status, error) {

    console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);

}
});

});

    $('#flight_search_btn').click(function () {

    $.ajax({
        url: '/searchflight',
        type: 'post',
        data: {
            startAirport: $('#start_airport').val(),
            endAirport: $('#end_airport').val(),
            startDay: $('#flight_date').val()
        },
        dataType: 'text',
        success: function (data) {

            let item = JSON.parse(data).response.body.items.item;

            console.log(item);
            $('#flight_list').empty();
            if (item === undefined) {
                let flightInfo = "<tr><td colspan='8'>" + "해당 공항의 항공편이 없습니다." + "</td></tr>"
                $('#flight_list').append(flightInfo);
            } else {

                for (let i = 0; i < item.length; i++) {
                    let airlineNm = item[i].airlineNm; //항공사
                    let depAirportNm = item[i].depAirportNm; //출발공항
                    let arrAirportNm = item[i].arrAirportNm; //도착공항
                    let depPlandTime = item[i].depPlandTime; //출발시간
                    let arrPlandTime = item[i].arrPlandTime; //도착시간
                    let economyCharge = item[i].economyCharge; //이코노미
                    let prestigeCharge = item[i].prestigeCharge;//비즈니스
                    let vihicleId = item[i].vihicleId; //항공편

                    let flightInfo = `<tr>
                                      <td class="airlineNm">${airlineNm}</td>
                                      <td class="depAirportNm">${depAirportNm}</td>
                                      <td class="arrAirportNm">${arrAirportNm}</td>
                                      <td class="depPlandTime">${depPlandTime}</td>
                                      <td class="arrPlandTime">${arrPlandTime}</td>
                                      <td class="economyCharge">${economyCharge}</td>
                                      <td class="prestigeCharge">${prestigeCharge}</td>
                                      <td class="vihicleId">${vihicleId}</td>
                                      <td><button type="button" onclick="resFlight(${i})">예약하기</button></td>
                                      </tr>`;
                    $('#flight_list').append(flightInfo);
                }
            }

        },
        error: function (request, status, error) {

            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);

        }
    });
});

    function resFlight(index) {
    $.ajax({
        url: '/saveFlight',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify({
            ticFlightDepartureDate: $("#flight_list tr .depPlandTime")[flight].innerText,
            ticFlightArrivalDate: $("#flight_list tr .arrPlandTime")[flight].innerText,
            ticSeatGrade: "이코노미",
            ticAirlineName: $("#flight_list tr .airlineNm")[flight].innerText,
            ticFee: $("#flight_list tr .economyCharge")[flight].innerText,
            ticFromLocation: $("#flight_list tr .depAirportNm")[flight].innerText,
            ticToLocation: $("#flight_list tr .arrAirportNm")[flight].innerText,
        }),
        success: function (data) {
            alert("저장완료");

        },
        error: function (request, status, error) {

            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);

        }
    });
}

    $('.flight_result_col').on('click', function () {
    alert('클릭');
});

*/
