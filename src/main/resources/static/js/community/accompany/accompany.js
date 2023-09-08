
// $(document).ready(function(){
//     let UserDate = document.getElementById('#user_date').value;
//
//     console.log(UserDate)
//
// })

let subToggle=true;
$(".menu").click(()=>{
    if(subToggle){
        $(".sub").slideDown(1000);
    }else{
        $(".sub").slideUp(1000);
    }
    subToggle=!subToggle;
});