$(document).ready(() => {


    var $tablink = $('.idpw-box-tabs div').click(function (e) {
        var idx = $tablink.index(this);
        $('.idpw-box-tabs div').css('color', 'rgb(170, 170, 170)');
        $('.idpw-box-tabs div').css('font-weight', '400');
        $(this).css('color', 'black');
        $(this).css('font-weight', '600');

        var marginLeftValue = idx * 50;
        $('.idpw-box-tabs-clicked-bar').animate({
            'margin-left': marginLeftValue + '%'
        }, 200)

    });

    $('#find-id-btn').click(()=>{

        console.log("아이디 버튼클릭.")
        $('.idpw-container-inner1').removeClass('disappear');
        $('.idpw-container-inner2').addClass('disappear');
    })

    $('#find-pw-btn').click(()=>{

        $('.idpw-container-inner2').removeClass('disappear');
        $('.idpw-container-inner1').addClass('disappear');

    })



})