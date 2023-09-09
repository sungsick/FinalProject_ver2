$(document).ready(function () {
    // 웹페이지 로드 시 초기화
    $("#result_location").hide();
    $("#result_depart_date").hide();
    $("#result_arrive_date").hide();

    $("#input_location").click(function () {
        if ($("#result_depart_date").is(":visible")) {
            $("#result_depart_date").hide();
        }

        if ($("#result_arrive_date").is(":visible")) {
            $("#result_arrive_date").hide();
        }

        $("#result_location").toggle();
    });


    $("#input_location_booking").click(function () {
        if ($("#result_location").is(":visible")) {
            $("#result_location").hide();
        }

        $("#result_depart_date").show();
    });


    $("#depart_date_booking").click(function () {
        if ($("#result_depart_date").is(":visible")) {
            $("#result_depart_date").hide();
        }


        $("#result_arrive_date").show();
    });


    $("#depart_date").click(function () {
        if ($("#result_location").is(":visible")) {
            $("#result_location").hide();
        }

        if ($("#result_arrive_date").is(":visible")) {
            $("#result_arrive_date").hide();
        }

        $("#result_depart_date").toggle();
    });


    $("#arrive_date").click(function () {
        if ($("#result_location").is(":visible")) {
            $("#result_location").hide();
        }

        if ($("#result_depart_date").is(":visible")) {
            $("#result_depart_date").hide();
        }


        $("#result_arrive_date").toggle();


    });

    $("#arrive_date_booking").click(function () {
        if ($("#result_arrive_date").is(":visible")) {
            $("#result_arrive_date").hide();
        }


    });


    /* 하단 공지사항 카테고리 클릭시 효과 바뀌는 클릭 이벤트*/

    $('#qnaBtn1').addClass('active');

    $('#qnaBtn1').click(function() {
        $(this).addClass('active');
        $('#qnaBtn2, #qnaBtn3').removeClass('active');
    });

    $('#qnaBtn2').click(function() {
        $(this).addClass('active');
        $('#qnaBtn1, #qnaBtn3').removeClass('active');
    });

    $('#qnaBtn3').click(function() {
        $(this).addClass('active');
        $('#qnaBtn1, #qnaBtn2').removeClass('active');
    });


});


/*qna 아코디언 폼 자바스크립트*/

$(function () {
    $('.qna_content_container .qna_title_wrap').click(function (event) {
        event.stopPropagation();

        var $clickedContainer = $(this).closest('.qna_content_container');
        var $accordion = $clickedContainer.find('.qna_line .qna_content_accordion');

        // 다른 아코디언 닫기 및 스타일 초기화
        $('.qna_content_container').not($clickedContainer).removeClass('on').css('margin-bottom', '0');
        $('.qna_line .qna_content_accordion').not($accordion).slideUp(200);

        // 현재 클릭한 아코디언 열기/닫기
        $accordion.stop().slideToggle(200, function () {
            if ($accordion.is(':visible')) {
                $clickedContainer.addClass('on');
                $clickedContainer.css('margin-bottom', $accordion.outerHeight() + 'px');
            } else {
                $clickedContainer.removeClass('on').css('margin-bottom', '0');
            }
        });
    });

    $('.qna_content_container .qna_open_icon').click(function (event) {
        event.stopPropagation();
    });

    $('.qna_content_container .qna_content_accordion').click(function (event) {
        event.stopPropagation();
    });


    //input을 datepicker로 선언

    //대여시간 날짜선택

    $("#depart_datepicker").datepicker({

        dateFormat: 'mm.dd' //Input Display Format 변경

        , nextText: ">"

        ,prevText: "<"

        , inline: true

        , range: true

        , showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시

        , showMonthAfterYear: true //년도 먼저 나오고, 뒤에 월 표시

        , changeYear: true //콤보박스에서 년 선택 가능

        , changeMonth: true //콤보박스에서 월 선택 가능

        /* ,selectOtherMonths: ture // 다른 달도 선택가능 */


        , yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트

        , monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'] //달력의 월 부분 텍스트

        , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'] //달력의 월 부분 Tooltip 텍스트

        , dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'] //달력의 요일 부분 텍스트

        , dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'] //달력의 요일 부분 Tooltip 텍스트

        , minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)

        , maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)


    });

    $("#depart_datepicker").on("change", function () {
        const selectedDate = $(this).val();

        console.log(selectedDate);
        $("#depart_date_check").text(selectedDate);


    });


    //초기값을 오늘 날짜로 설정
    $('#depart_datepicker₩').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)


    //반납날짜 날짜선택

    $("#arrive_datepicker").datepicker({

        dateFormat: 'mm.dd' //Input Display Format 변경

        , nextText: ">"

        ,prevText: "<"

        , inline: true

        , showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시

        , showMonthAfterYear: true //년도 먼저 나오고, 뒤에 월 표시

        , changeYear: true //콤보박스에서 년 선택 가능

        , changeMonth: true //콤보박스에서 월 선택 가능

        /* ,selectOtherMonths: ture // 다른 달도 선택가능 */


        , yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트

        , monthSuffix: "월" //달력의 년도 부분 뒤에 붙는 텍스트

        , monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'] //달력의 월 부분 텍스트

        , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'] //달력의 월 부분 Tooltip 텍스트

        , dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'] //달력의 요일 부분 텍스트

        , dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'] //달력의 요일 부분 Tooltip 텍스트

        , minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)

        , maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)


    });

    $("#arrive_datepicker").on("change", function () {
        const selectedDate = $(this).val();

        console.log(selectedDate);
        $("#arrive_date_check").text(selectedDate);


    });


    //초기값을 오늘 날짜로 설정
    $('#arrive_datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)


    // 대여 날짜 선택 시 js 내용
    $("#depart_datepicker").on("change", function () {
        updateDepartDateTimeDisplay();
    });

    // 대여 시간 선택 시 동작
    $("#depart_time").change(function () {
        updateDepartDateTimeDisplay();
    });

    // 버튼 클릭 시 선택한 날짜와 시간을 입력란에 적용
    $("#depart_date_booking").click(function () {
        const selectedDateTime = $("#depart_date_check").text();
        $("#depart_date").val(selectedDateTime); // 입력란에 선택한 날짜와 시간 적용
    });

    function updateDepartDateTimeDisplay() {
        const selectedDate = $("#depart_datepicker").val(); // 선택한 날짜
        const selectedTime = $("#depart_time").val(); // 선택한 시간

        const dateObject = new Date(selectedDate);
        const options = {month: "2-digit", day: "2-digit"};
        const formattedDate = dateObject.toLocaleDateString("ko-KR", options);

        const formattedDateTime = formattedDate + " " + selectedTime; // 날짜와 시간 조합

        $("#depart_date_check").text(formattedDateTime); // 선택한 날짜와 시간 표시
    }


    //반납일자 선택시 js 내용

    $("#arrive_datepicker").on("change", function () {
        updateArriveDateTimeDisplay();
    });

    // 대여 시간 선택 시 동작
    $("#arrive_time").change(function () {
        updateArriveDateTimeDisplay();
    });

    // 버튼 클릭 시 선택한 날짜와 시간을 입력란에 적용
    $("#arrive_date_booking").click(function () {
        const selectedDateTime = $("#arrive_date_check").text();
        $("#arrive_date").val(selectedDateTime); // 입력란에 선택한 날짜와 시간 적용
    });

    function updateArriveDateTimeDisplay() {
        const selectedDate = $("#arrive_datepicker").val(); // 선택한 날짜
        const selectedTime = $("#arrive_time").val(); // 선택한 시간

        const dateObject = new Date(selectedDate);
        const options = {month: "2-digit", day: "2-digit"};
        const formattedDate = dateObject.toLocaleDateString("ko-KR", options);

        const formattedDateTime = formattedDate + " " + selectedTime; // 날짜와 시간 조합

        $("#arrive_date_check").text(formattedDateTime); // 선택한 날짜와 시간 표시
    }






/*
//컨트롤러에 연결되는 Ajax

    $("#main_rentcar_search").click(function() {
        var location = $("#input_location").val();
        var departDate = $("#depart_date").val();
        var arriveDate = $("#arrive_date").val();
        var birthDate = $("#input_birth").val();

        $.ajax({
            url: "/store/rentcar/rentcarMainSearch",
            type: "get",
            data: {
                location: location,
                departDate: departDate,
                arriveDate: arriveDate,
                birthDate: birthDate
            },
            success: function(data) {
                // 페이지 이동
               window.location.href = "/store/rentcar/thTest";
            },
            error: function(xhr, status, error) {
                console.error(error);
            }
        });
    });
*/

});









/*qna 카테고리별 게시글 변경 자바스크립트*/

document.addEventListener("DOMContentLoaded", function () {
    // 웹페이지 로드 시 초기화
    const defaultAnswer = document.getElementById('qnaBtnAnswer1');
    defaultAnswer.style.display = 'block';
    document.getElementById('qnaBtnAnswer2').style.display = 'none';
    document.getElementById('qnaBtnAnswer3').style.display = 'none';

    // 버튼 클릭에 따른 요소 토글
    function toggleAnswer(btnId) {
        const answerId = btnId.replace('qnaBtn', 'qnaBtnAnswer');
        const answerElement = document.getElementById(answerId);

        // 모든 답변 요소 숨기기
        const allAnswerElements = document.querySelectorAll('.qna_category_content');
        allAnswerElements.forEach(function (element) {
            element.style.display = 'none';
        });

        // 클릭한 버튼에 해당하는 답변 요소 보이기
        answerElement.style.display = 'block';
    }

    document.getElementById('qnaBtn1').addEventListener('click', function () {
        toggleAnswer('qnaBtn1');
    });

    document.getElementById('qnaBtn2').addEventListener('click', function () {
        toggleAnswer('qnaBtn2');
    });

    document.getElementById('qnaBtn3').addEventListener('click', function () {
        toggleAnswer('qnaBtn3');
    });

});

//제주 버튼 눌렀을 때 이동하는 js

function setSessionValuesAndRedirect() {
    // 현재 날짜와 시간을 가져옴
    var currentDate = new Date();
    var currentYear = currentDate.getFullYear();
    var currentMonth = ('0' + (currentDate.getMonth() + 1)).slice(-2);
    var currentDay = ('0' + currentDate.getDate()).slice(-2);

    // 세션 값 설정
    sessionStorage.setItem("input_location", "제주국제공항");
    sessionStorage.setItem("depart_date", currentYear + "-" + currentMonth + "-" + currentDay + " 08:00");

    // 하루 뒤의 날짜를 계산
    currentDate.setDate(currentDate.getDate() + 1);
    var nextYear = currentDate.getFullYear();
    var nextMonth = ('0' + (currentDate.getMonth() + 1)).slice(-2);
    var nextDay = ('0' + currentDate.getDate()).slice(-2);

    // arrive_date 세션 값 설정
    sessionStorage.setItem("arrive_date", nextYear + "-" + nextMonth + "-" + nextDay + " 16:00");

    // input_birth 세션 값 설정
    sessionStorage.setItem("input_birth", "990101");


    console.log(currentYear + "-" + currentMonth + "-" + currentDay + " 08:00");



    // rentcarReserve.html 페이지로 이동
    location.href = "/store/rentcar/rentcarReserve";
}