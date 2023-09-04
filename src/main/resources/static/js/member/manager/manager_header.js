// 탭 선택에 따른 background color 조정
var url = window.location.pathname;
var tab = url.split('/')[2];
console.log(tab)
if(tab === "home"){
    $('.snc_home').css('background-color','pink');
    $('.snc_home').css('color','white');
}else if(tab === "user"){
    $('.snc_user').css('background-color','pink');
    $('.snc_user').css('color','white');
}else if(tab === "accompany"){
    $('.snc_accompany').css('background-color','pink');
    $('.snc_accompany').css('color','white');
}else if(tab === "plan"){
    $('.snc_plan').css('background-color','pink');
    $('.snc_plan').css('color','white');
}else if(tab === "qna"){
    $('.snc_qna').css('background-color','pink');
    $('.snc_qna').css('color','white');
}else if(tab === "flight"){
    $('.snc_flight').css('background-color','pink');
    $('.snc_flight').css('color','white');
}else if(tab === "rentcar"){
    $('.snc_rentcar').css('background-color','pink');
    $('.snc_rentcar').css('color','white');
}
console.log(url);
