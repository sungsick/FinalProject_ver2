//버튼 관련

//일정 작성 완료 버튼 클릭 시 plan(일정 메인)으로 이동    (원래: 마이페이지-내 일정으로 이동)
const CompleteMySchedule = document.querySelector('.complete_write_btn');

/*CompleteMySchedule.addEventListener('click', () => {
    window.location.href = '../plan';
});*/


//1번째 테이블 장소 추가 버튼 클릭 시 plan_add로 이동
/*
var PlaceAddBtn = document.querySelectorAll('.place_add_btn');

for(var i = 0; i < PlaceAddBtn.length; i++){
    PlaceAddBtn[i].addEventListener('click', function(e){
       console.log(e.target.innerHTML);
    });
}
*/

function test(e){
    location.href=`/community/plan/add?day=${e.value}`;
}



var dayValues = document.querySelectorAll('.place_add_btn');
//여행 일정 추가 버튼을 누르면 테이블 추가해주는 함수
var dayValue = dayValues.length + 1; // 테이블 번호 카운터 초기화

// 이벤트 리스너를 추가하여 버튼 클릭 시 테이블을 추가하는 함수를 호출
document.getElementById('schedule_add_btn').addEventListener('click', addTable);


function addTable() {
    console.log('추가 버튼 클릭');
    // 새로운 테이블 요소를 생성
    var newTable = document.createElement('table');
    newTable.classList.add('table'); // 클래스 추가

    // 새로운 테이블의 내용 (thead와 tbody) 생성
    var tableContent = `
                <thead>
                    <tr>
                        <th scope="col">
                            <span class="ctn1_span">
                                <span class="ctn1_span2">
                                    <svg width="15" height="15" viewBox="0 0 24 24" fill="#253333" xmlns="http://www.w3.org/2000/svg" color="#333333" size="15">
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M21.5143 12.7857C22.1619 12.462 22.1619 11.538 21.5143 11.2143L3.2715 2.09388C2.68733 1.80182 2 2.22657 2 2.87962L2 9.63235C2 10.1346 2.3726 10.559 2.87068 10.624L13.4216 12L2.87068 13.376C2.3726 13.441 2 13.8654 2 14.3676L2 21.1204C2 21.7734 2.68733 22.1982 3.2715 21.9061L21.5143 12.7857Z" fill="#ffffff"></path>
                                    </svg>
                                </span>
                                <span class="day1_span">Day${dayValue}</span>
                            </span>
                        </th>
                        <th scope="col">여행지</th>
                        <th scope="col">장소분류</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row"><div class="ctn1_des_num">${dayValue}</div></th>
                        <td>새로운 여행지</td>
                        <td>새로운 장소분류</td>
                        <td>
                            <div class="sc_des_mark_hujitong">
                                <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">
                                    <style>svg {fill: #df5368}</style>
                                    <path d="M135.2 17.7C140.6 6.8 151.7 0 163.8 0H284.2c12.1 0 23.2 6.8 28.6 17.7L320 32h96c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 96 0 81.7 0 64S14.3 32 32 32h96l7.2-14.3zM32 128H416V448c0 35.3-28.7 64-64 64H96c-35.3 0-64-28.7-64-64V128zm96 64c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16z"/>
                                </svg>
                            </div>
                        </td>
                    </tr>
                </tbody>
            `;

    // 새로운 테이블에 내용을 삽입
    newTable.innerHTML = tableContent;


    // "장소 추가"와 "메모 추가" 버튼을 포함하는 <div> 요소 생성
    var buttonsDiv = document.createElement('div');
    buttonsDiv.style.width = '100%';
    buttonsDiv.style.height = '71px';
    buttonsDiv.style.display = 'flex';
    buttonsDiv.className = 'btm_btn';

    // "장소 추가" 버튼 추가
    var placeButton = document.createElement('button');
    placeButton.className = 'place_add_btn';
    placeButton.textContent = '장소 추가';
    placeButton.onclick = function(){test(this)};
    placeButton.value = dayValue.toString();
    buttonsDiv.appendChild(placeButton);

    // "메모 추가" 버튼 추가
    var memoButton = document.createElement('button');
    memoButton.className = 'memo_add_btn';
    memoButton.textContent = '메모 추가';
    buttonsDiv.appendChild(memoButton);
    // buttonsDiv를 tableContainer에 추가

    // 새로운 테이블을 컨테이너에 추가
    var table_area = document.createElement('div');
    table_area.classList.add("table_area");
    table_area.appendChild(newTable);
    table_area.appendChild(buttonsDiv);


    var article3 = document.querySelector('.article3');
    article3.appendChild(table_area);

    // 테이블 번호 카운터 증가
    dayValue++;

}

// 테이블 행 삭제하는 함수
function deletePlan(day, place_name){


    console.log(day);
    console.log(place_name);

    $.ajax({
        url: '/community/plan/deletePlan',
        type: 'post',
        data: {
            day : day,
            placeName : place_name
        },
        success: function (data) {
            console.log('성공');
            location.reload();
        },
        error: function(data){
            console.log('삭제실패');
        }

    });

}



//일정작성완료 버튼 클릭 시
$('.complete_write_btn').on('click', function () {
    //
    // alert("일정이 저장되었습니다.")
    var pbTitle = $('.art1_div_subject').text();
    var pbStartDate = $('#select_start_date').val();
    var pbEndDate = $('#select_end_date').val();
    var pbRegion = $('.form-select_place').val();
    var pbViewCount = 0;

// planBoardDTO 객체 생성 및 값 설정
    var planBoardDTO = {
        // pbNum: pbNum, //게시글번호
        // pbWriteDate: pbWriteDate, //작성일자
        pbTitle: pbTitle, //글제목
        pbStartDate: pbStartDate, //시작날짜
        pbEndDate: pbEndDate, //종료날짜
        pbRegion: pbRegion, //여행지역
        pbViewCount: pbViewCount, //조회수
    };

// planBoardDetailDTO 객체 생성 및 값 설정
//     var planBoardDetailDTO = {
//         pbdNum: pbdNum,//세부일정번호
//         pbdPlaceName: pbdPlaceName, //여행지명
//         pbdCategoryGroupName: pbdCategoryGroupName, 장소분류명,
//         pbdX: pbdX, // x좌표
//         pbdY: pbdY, // y좌표
//         pbdDate: pbdDate, // 일자번호
//         planBoard: {
//             pbNum: 2 // PlanBoardDTO와 연관된 게시글 번호
//         }
//     };



// AJAX 요청 설정
    $.ajax({
        url: '/community/plan/completePlan', // 실제 서버 엔드포인트 URL
        type: 'post',
        contentType: 'application/json', // 데이터 형식을 JSON으로 설정
        data: JSON.stringify(planBoardDTO), // 직렬화된 JSON 데이터를 요청 데이터로 설정
        success: function (data) {
            console.log('성공');
            alert("일정이 저장되었습니다.");
            // 서버 응답에 대한 처리
            location.href = "/community/plan";
        },
        error: function (data) {
            console.log('실패');
            // 에러 처리
        }
    });
});




//--------------------------------------------------------------------------------


// 날짜 선택 관련
// 이벤트 리스너를 등록하여 날짜 선택이 변경될 때마다 실행되도록 합니다.
document.getElementById('select_start_date').addEventListener('change', function() {
    // 선택한 날짜 값을 가져옵니다.
    var selectedStartDate = this.value;

    // <div class="sc_date_start"> 요소의 내용을 선택한 날짜로 업데이트합니다.
    document.querySelector('.sc_date_start').textContent = selectedStartDate;
});

// 이벤트 리스너를 등록하여 날짜 선택이 변경될 때마다 실행되도록 합니다.
document.getElementById('select_end_date').addEventListener('change', function() {
    // 선택한 날짜 값을 가져옵니다.
    var selectedEndDate = this.value;

    // <div class="sc_date_start"> 요소의 내용을 선택한 날짜로 업데이트합니다.
    document.querySelector('.sc_date_end').textContent = selectedEndDate;
});

//----------------------------------------------------------------------------------

//카카오맵 관련
// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex: 1});

// 키워드로 장소를 검색합니다
searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch(keyword, placesSearchCB);
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
        console.log(data);
        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

    var listEl = document.getElementById('placesList'),
        menuEl = document.getElementById('menu_wrap'),
        fragment = document.createDocumentFragment(),
        bounds = new kakao.maps.LatLngBounds(),
        listStr = '';

    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();

    for (var i = 0; i < places.length; i++) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i),
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function (marker, title) {
            kakao.maps.event.addListener(marker, 'mouseover', function () {
                displayInfowindow(marker, title);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function () {
                infowindow.close();
            });

            itemEl.onmouseover = function () {
                displayInfowindow(marker, title);
            };

            itemEl.onmouseout = function () {
                infowindow.close();
            };
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

    var el = document.createElement('li'),
        itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
            '<div class="info">' +
            '   <h5>' + places.place_name + '</h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
            '   <span class="jibun gray">' + places.address_name + '</span>';
    } else {
        itemStr += '    <span>' + places.address_name + '</span>';
    }

    itemStr += '  <span class="tel">' + places.phone + '</span>' +
        '</div>';

    el.innerHTML = itemStr;
    el.className = 'item';
    el.addEventListener('click', function () {
        window.open(places.place_url, "_blank", "width=900, height=500")
    }); //place map 보여주는 함수
    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions = {
            spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin: new kakao.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
        marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i;

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild(paginationEl.lastChild);
    }

    for (i = 1; i <= pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i === pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function (i) {
                return function () {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

    infowindow.setContent(content);
    infowindow.open(map, marker);
}

// 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {
    while (el.hasChildNodes()) {
        el.removeChild(el.lastChild);
    }
}

//2. 지도에 컨트롤 올리기 추가
// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

//3. Toolbox 사용하기
// 도형 스타일을 변수로 설정합니다
var strokeColor = '#39f',
    fillColor = '#cce6ff',
    fillOpacity = 0.5,
    hintStrokeStyle = 'dash';

var options = { // Drawing Manager를 생성할 때 사용할 옵션입니다
    map: map, // Drawing Manager로 그리기 요소를 그릴 map 객체입니다
    drawingMode: [
        kakao.maps.Drawing.OverlayType.MARKER,
        kakao.maps.Drawing.OverlayType.ARROW,
        kakao.maps.Drawing.OverlayType.POLYLINE,
        kakao.maps.Drawing.OverlayType.RECTANGLE,
        kakao.maps.Drawing.OverlayType.CIRCLE,
        kakao.maps.Drawing.OverlayType.ELLIPSE,
        kakao.maps.Drawing.OverlayType.POLYGON
    ],
    // 사용자에게 제공할 그리기 가이드 툴팁입니다
    // 사용자에게 도형을 그릴때, 드래그할때, 수정할때 가이드 툴팁을 표시하도록 설정합니다
    guideTooltip: ['draw', 'drag', 'edit'],
    markerOptions: {
        draggable: true,
        removable: true
    },
    arrowOptions: {
        draggable: true,
        removable: true,
        strokeColor: strokeColor,
        hintStrokeStyle: hintStrokeStyle
    },
    polylineOptions: {
        draggable: true,
        removable: true,
        strokeColor: strokeColor,
        hintStrokeStyle: hintStrokeStyle
    },
    rectangleOptions: {
        draggable: true,
        removable: true,
        strokeColor: strokeColor,
        fillColor: fillColor,
        fillOpacity: fillOpacity
    },
    circleOptions: {
        draggable: true,
        removable: true,
        strokeColor: strokeColor,
        fillColor: fillColor,
        fillOpacity: fillOpacity
    },
    ellipseOptions: {
        draggable: true,
        removable: true,
        strokeColor: strokeColor,
        fillColor: fillColor,
        fillOpacity: fillOpacity
    },
    polygonOptions: {
        draggable: true,
        removable: true,
        strokeColor: strokeColor,
        fillColor: fillColor,
        fillOpacity: fillOpacity
    }
};

// 위에 작성한 옵션으로 Drawing Manager를 생성합니다
var manager = new kakao.maps.Drawing.DrawingManager(options);

// Toolbox를 생성합니다.
// Toolbox 생성 시 위에서 생성한 DrawingManager 객체를 설정합니다.
// DrawingManager 객체를 꼭 설정해야만 그리기 모드와 매니저의 상태를 툴박스에 설정할 수 있습니다.
var toolbox = new kakao.maps.Drawing.Toolbox({drawingManager: manager});

// 지도 위에 Toolbox를 표시합니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOP은 위 가운데를 의미합니다.
map.addControl(toolbox.getElement(), kakao.maps.ControlPosition.TOP);




