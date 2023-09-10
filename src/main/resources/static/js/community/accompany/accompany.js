// $(document).ready(function(){
//     let UserDate = document.getElementById('#user_date').value;
//
//     console.log(UserDate)
//
// })
$("#recent").click(() => {
    const recent = "recent"
    window.location.href = `/community/accompany?orderby=${recent}`;
});

$("#viewcount").click(() => {
    const viewcount = "viewcount"
    window.location.href = `/community/accompany?orderby=${viewcount}`;
});


let regionChoice = true;

$("#allRegion").click(() => {
    const regionUl = $(".sub"); // .sub 클래스를 가진 ul 요소 선택


    if (regionChoice) {
        regionUl.slideDown(1000);
    } else {
        regionUl.slideUp(1000);
    }
    regionChoice = !regionChoice;
});

$(".regionAt").click((event) => {

    const id = event.target.name;
    // 여기서는 `name` 속성을 사용하여 선택한 지역 값을 가져옵니다.
    console.log("id값은" + id);
    // URL에 선택한 지역 값을 추가합니다.
    window.location.href = `/community/accompany?regionAt=${id}`;
});


$("#countComment").click((event) => {
    const id = event.target.id;

    console.log("id값은" + id);

    window.location.href = `/community/accompany?orderby=${id}`;


})


let dateToggle = true;
$(".searchDate").click(() => {
    if (dateToggle) {
        $(".queryStartdate").slideDown(1000);
        $(".queryEnddate").slideDown(1000);
    } else {
        $(".queryStartdate").slideDown(1000);
        $(".queryEnddate").slideDown(1000);
    }
    dateToggle = !dateToggle;


})


// 시작 날짜, 마지막 날짜 선택하면  해당 날짜 게시글만 쿼리됨
$(".searchPeriodBtn").click(() => {

    const startdate = $(".queryStartdate").val();
    const enddate = $(".queryEnddate").val();

    console.log(startdate)
    console.log(enddate)
    window.location.href = `/community/accompany?startAt=${startdate}&endAt=${enddate}`;
})

// var startdate = $('.queryStartdate').val()
// var enddate = $('.queryEnddate').val()
// var query = JSON.stringify({
//     ac_startdate : startdate,
//     ac_enddate : enddate
// })
// console.log('date choice query ajax 실행중');
//
// $.ajax({
//     url:'/community/accompany/filter1=startdate&filter'
//
//
//
// })


// })
//
// });

//
// .$("#countComment").click(function () {
//
//     console.log('댓글 많은 순으로 정렬')
//     console.log(event)
//
//     $.ajax({
//
//         url:/community/accompany/
//
//     })
//
// })