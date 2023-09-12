
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

// 어디로 여행가시나요? searchBar 입력시 검색하기


$('#search-bar').on('keydown',function(e){

    console.log(e);
    console.log(e.key)
    if(e.key === "Enter"){ // 엔터 입력시

        if(this.value === ""){
            // Swal.fire('검색어를 입력해주세요.','', 'info')
            alert('검색어를 입력해주세요.');
        }else{

            var query = this.value;
            window.location.href = "/community/accompany?searchName="+query;


        }
    }

});
