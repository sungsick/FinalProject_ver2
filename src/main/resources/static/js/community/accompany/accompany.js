
// $(document).ready(function(){
//     let UserDate = document.getElementById('#user_date').value;
//
//     console.log(UserDate)
//
// })

/* 얘는 무슨 코드지 ?*/
let subToggle=true;
$(".menu").click(()=>{
    if(subToggle){
        $(".sub").slideDown(1000);
    }else{
        $(".sub").slideUp(1000);
    }
    subToggle=!subToggle;
})

.$("#countComment").click(function () {

    console.log('댓글 많은 순으로 정렬')
    console

    $.ajax({

        url:/community/accompany/

    })

})