
// $(document).ready(function(){
//     let UserDate = document.getElementById('#user_date').value;
//
//     console.log(UserDate)
//
// })

/* 하단 검색창에 지역 검색하면 필터링 되서 동행글이 지역별로 나오는 코드 */
let subToggle=true;
$("#allRegion").click(()=>{
    if(subToggle){
        $(".sub").slideDown(1000);
    }else{
        $(".sub").slideUp(1000);
    }
    subToggle=!subToggle;
})

$(".allRegionBtn").click((event) => {

    event.target.id
       console.log(event.target.id)





})
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