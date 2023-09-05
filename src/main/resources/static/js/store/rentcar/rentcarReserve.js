$(document).ready(function () {


    $('#high_price_list_btn').click(function () {

        window.location.href = '/highPriceList';
    });

    $('#low_price_list_btn').click(function () {

        window.location.href = '/lowPriceList';
    });


    $('#result_item').hover(function () {
        $(this).css("box-shadow", "5px 5px 5px 5px");
    }, function () {
    $(this).css("box-shadow","none");

    });


});

