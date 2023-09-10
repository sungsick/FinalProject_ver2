/*
//카카오맵 관련
// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(33.379777, 126.545873), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨
    };

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

//-------------------------------------------------------------------------------
// 지도에 표시된 마커 객체를 가지고 있을 배열입니다
var markers = [];

// Plan 객체에서 pbdX와 pbdY 값을 추출합니다
var pbdXElements = document.querySelectorAll('.pbdx');


var pbdYElements = document.querySelectorAll('.pbdy');

// 좌표를 담을 배열
var positions = [];

// Plan 객체에서 pbdX와 pbdY 값을 추출하여 좌표 배열에 추가합니다
for (var i = 0; i < pbdXElements.length; i++) {
    var pbdX = parseFloat(pbdXElements[i].value); // 숫자로 변환
    var pbdY = parseFloat(pbdYElements[i].value); // 숫자로 변환

    console.log(pbdX);
    console.log(pbdY);

    if (!isNaN(pbdX) && !isNaN(pbdY)) {
        var position = new kakao.maps.LatLng(pbdY, pbdX);
        positions.push(position);
    }
}

// positions 배열에 있는 좌표로 마커를 추가합니다
for (var i = 0; i < positions.length; i++) {
    addMarker(positions[i]);
}

// 마커를 생성하고 지도위에 표시하는 함수입니다
function addMarker(position) {

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: position
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);

    // 생성된 마커를 배열에 추가합니다
    markers.push(marker);
}

// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
function setMarkers(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}*/

