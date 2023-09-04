// 일별 가입자 수 현황
const ctx = document.getElementById('myChart');
var user_number = "";
$.ajax({

    method: 'POST',
    data: "",
    url: '/test/getUserChart',
    success: function (data) {


        var daycountList = data.countList;
        var dayList = getdayList(daycountList.length);
        var ageMap = data.ageMap;// circle chart에 보여질값.


        //
        showChart(daycountList, dayList);
        showCircleChart(ageMap);

    }, error() {

        console.log("bye")
    }
})

function getdayList(daylength) { // 오늘부터 이전 10일까지의 날짜값은 직접 포매팅해야한다.

    var dayList = [];
    const date = new Date();

    date.setDate(date.getDate() - daylength);

    for (var i = 0; i < daylength; i++) {

        date.setDate(date.getDate() + 1);

        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        const formattedDate = `${month}-${day}`; // "2023-08-31"

        dayList.push(formattedDate);

    }
    return dayList;
}

function showChart(countList, dayList) {

    console.log(countList);
    new Chart(ctx, {

        type: 'line',
        data: {
            labels: dayList,
            datasets: [{
                label: '일별 가입자 수 현황',
                data: countList,
                borderWidth: 2
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: false
                }
            }
        }
    });

}


function showCircleChart(ageMap) {


    anychart.onDocumentReady(function () {
        // create pie chart with passed data
        var chart = anychart.pie([
            ['10대', ageMap.ten],
            ['20대', ageMap.two],
            ['30대', ageMap.three],
            ['40대', ageMap.four],
            ['50대', ageMap.five],
            ['60대', ageMap.six],
            ['70대', ageMap.seven]
        ]);


        // set chart labels position to outside
        // set legend title settings
        chart.title('');
        // set chart labels position to outside
        chart.labels().position('outside');
        // set legend title settings
        chart
            .legend()
            .title()
            .enabled(true)
            .text('회원 연령대 비율')
            .padding([0, 0, 10, 0]);

        // set legend position and items layout
        chart
            .legend()
            .position('center-bottom')
            .itemsLayout('horizontal')
            .align('center');
        chart.innerRadius('30%');

        // set container id for the chart
        chart.container('container');
        // initiate chart drawing
        chart.draw();
    });


}


// 삭제하기 버튼 클릭시
function deluser(element) {

    console.log('deluser메서드실행');
    user_number = element.id;


    // Swal.fire('비밀번호가 변경됐습니다', '', 'success').then((result) => {
    //
    //     window.location.href = '/';
    //
    // })

    Swal.fire({
        title: '<strong>HTML <u>example</u></strong>',
        icon: 'warning',
        title: '정말 회원 정보를 삭제하시겠습니까?',
        showCloseButton: false,
        showCancelButton: true,
        focusConfirm: false,
        confirmButtonText:
            '확인',
        confirmButtonAriaLabel: 'great!',
        cancelButtonText:
            '취소',
        cancelButtonAriaLabel: 'Thumbs down'
    }).then((result) => {

        if (result.isConfirmed) {

            var query = {
                user_number: user_number
            }

            $.ajax({

                url: '/manager/deleteUser',
                method: 'POST',
                data: query,
                success: function (data) {


                    // 추가한 버튼의 이벤트 핸들러를 추가한다.
                    Swal.fire('삭제가 완료됐습니다.', '', 'success').then((result) => {

                        location.href = '/manager/user';

                    })
                }, error: function () {

                }
            });

        }

    })


    $('.swal2-confirm').click(function () {


        console.log('모달확인버튼.')
    })
}

// 선택된 페이지 버튼 속성주기

var pageSelectBtn = document.querySelectorAll('.page-select-btn');
console.log(pageSelectBtn);

// #selected-btn은 페이지 렌더링시 히든값으로 가지고 있는 pageNo의 value이다.

for (var i = 0; i < pageSelectBtn.length; i++) {

    if (pageSelectBtn[i].id == $('#selected-btn').val()) {

        console.log(pageSelectBtn[i])
        console.log('h')
        pageSelectBtn[i].style = "background-color:#00b8ff; color:white";

    }
}

// 유저 아이디, 혹은 유저 이름으로 유저 찾기 버튼을 클릭, 혹은 enter를 눌렸을 때


$('#search-input').on('keyup', function (e) {

    if (e.key === "Enter") {

        var search_word = $('#search-input').val();
        var search_option = $('#user-search-option').val();
        console.log(search_word);
        if(search_option === "all" ){
            location.href = `/manager/user`;

        }
        else if (search_word === "") {
            Swal.fire('검색어를 입력해주세요.', '', 'warning')
        } else {
            location.href = `/manager/user?pageNo=1&search_word=${search_word}&search_option=${search_option}`;
        }
    }
})


var search_option = $('#search_option').val(); // hidden값
console.log(search_option);


// hidden값으로 이전에 지정했던 설정을 저장하고 있는다.
var selected = document.querySelector(`select [value=${search_option}]`);
selected.selected = true;


// hiiden값으로 아까 검색했던 검색어를 검색창에 집어넣ㄴ는다.
$('#search-input').val($('#search_word').val());
var search_word = $('#search-input').val();


function pageChange(element){ // 페이지 버튼 클릭할시

    var pageNo = element.id;

    if(search_word === "") { // 검색어 없을 경우 그냥 페이지만 변경한다.
        location.href = `/manager/user?pageNo=${pageNo}`;
    }else if(search_word !== ""){ // 검색어가 있을 경우 페이지NO과 함꼐 검색어와 option도 계속 전달한다.
        location.href = `/manager/user?pageNo=${pageNo}&search_word=${search_word}&search_option=${search_option}`;

    }

}



