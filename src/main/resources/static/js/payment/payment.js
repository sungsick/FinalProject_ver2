$(function () {
    // tab 기능
    var $tablink = $('.second-box-tabs div').click(function (e) {
        var idx = $tablink.index(this);
        $('.second-box-tabs div').css('color', 'rgb(170, 170, 170)');
        $('.second-box-tabs div').css('font-weight', '400');
        $(this).css('color', '#00ce7c');
        $(this).css('font-weight', '600');

        var marginLeftValue = idx * 33.3333;
        $('.second-box-tabs-clicked-bar').animate({
            'margin-left': marginLeftValue + '%'
        }, 200)
        $('.sections-con').removeClass('show');
        $('.third-box section:first > div').eq(idx).addClass('show')
    });

// 대여 가능 여부 생년 검사
    $('#input_birth').keyup(() => {

        var input_birth = document.getElementById('input_birth');
        var warningDiv = document.getElementById('warning');
        var inputYear = parseInt(input_birth.value.substring(0, 2));
        var currentYear = new Date().getFullYear() % 100;
        var btnKakaoPay = document.getElementById('btnKakaoPay');

        if (input_birth.value >= 2) {
            var inputValue = parseInt(input_birth.value.substring(0, 2));
        }

        console.log(input_birth.value.length);
        if (input_birth.value.length >= 6) {

            console.log(currentYear - inputYear);
            result = currentYear - inputYear;
            console.log(result);
            absolute = Math.abs(result);
            console.log(absolute);

            if (absolute >= 20) {
                console.log('20이상');
                // 20세 이상
                warningDiv.textContent = "만 20세, 해당 차량 대여 가능합니다.";
                warningDiv.style.color = "rgb(89, 178, 106)"; // 기본 색상으로 변경
                btnKakaoPay.disabled = false;
            } else {
                console.log('20이하');
                // 20세 미만
                warningDiv.textContent = "20세 미만입니다.";
                warningDiv.style.color = "red"; // 빨간색으로 변경
                btnKakaoPay.disabled = true;
            }

        } else {
            warningDiv.textContent = ""; // 경고 메시지 초기화
            btnKakaoPay.disabled = true;
        }
    });
    // 카카오결제
    $("#btnKakaoPay").click(function () {
        // 결제버튼
        const input_name = document.getElementById('input_name');
        const input_phone = document.getElementById('input_phone');
        const input_birth = document.getElementById('input_birth');
        // const nameValue = input_name.value;
        // const phoneValue = input_phone.value;
        // const birthValue = input_birth.value;
        // console.log(nameValue);
        // console.log(phoneValue);
        // console.log(birthValue);
        if (input_name.value === '' || input_phone.value === '' || input_birth.value === '') {
            alert('필수 항목을 입력하세요');
            (this).focus();
        } else {

            // 필수입력값을 확인.
            var name = $("#form-payment input[name='pay-name']").val();
            var tel = $("#form-payment input[name='pay-tel']").val();
            var email = $("#form-payment input[name='pay-email']").val();

            if (name === "") {
                $("#form-payment input[name='pay-name']").focus()
            }
            if (tel === "") {
                $("#form-payment input[name='pay-tel']").focus()
            }
            if (email === "") {
                $("#form-payment input[name='pay-email']").focus()
            }

            // 결제 정보를 form에 저장한다.
            let totalPayPrice = parseInt($("#total-pay-price").text().replace(/,/g, ''))
            let totalPrice = parseInt($("#total-price").text().replace(/,/g, ''))
            let discountPrice = totalPrice - totalPayPrice
            let usePoint = $("#point-use").val()
            let useUserCouponNo = $(":radio[name='userCoupon']:checked").val()

            // 카카오페이 결제전송
            $.ajax({
                type: 'get'
                , url: '/kakaoPay'
                // ,data:{
                //     total_amount: totalPayPrice
                //     ,payUserName: name
                //     ,sumPrice:totalPrice
                //     ,discountPrice:discountPrice
                //     ,totalPrice:totalPayPrice
                //     ,tel:tel
                //     ,email:email
                //     ,usePoint:usePoint
                //     ,useCouponNo:useUserCouponNo
                //
                // }
                , success: function (response) {
                    // 화면 중앙에 위치시키기 위한 x, y 좌표 계산
                    var screenWidth = window.screen.width;
                    var screenHeight = window.screen.height;
                    var popupWidth = 500; // 팝업 창 가로 크기
                    var popupHeight = 600; // 팝업 창 세로 크기
                    var left = (window.screen.width / 2) - (popupWidth / 2);
                    var top = (window.screen.height / 2) - (popupHeight / 2);

                    // 팝업 창 열기
                    var popup = window.open(response.next_redirect_pc_url, "_blank", "width=500,height=600,left=" + left + ",top=" + top);

                }
            })
        }
    })

    // 모달 열기
    $('.shuttle-button').click(function () {
        $('.modal').css('display', 'block');
        $("body").css('overflow', 'hidden');
        $("body").css('margin-left', '-6px');
    })
    // 모달 닫기

    $('.modal-btn').click(function () {
        $('.modal').css('display', 'none');
        $("body").css('overflow', 'auto');
        $("body").css('margin-left', '0px');
    })

    // 텍스트 숨기기
    $('.arrow').click(function () {
        if ($(this).hasClass('false')) {
            $('.arrow').removeClass('false');
            $('.arrow').addClass('onArrow');
            $('.policy-detail').css('max-height', '989px');
            $('.policy-detail').css('margin-bottom', '20px');
        } else {
            $('.arrow').removeClass('onArrow');
            $('.arrow').addClass('false');
            $('.policy-detail').css('max-height', '0px');
            $('.policy-detail').css('margin-bottom', '0px');
        }
    })

    // 내륙, 제주 지역 선택텝
    var $landLocation = $('.insurance-locations div').click(function () {
        var idx = $landLocation.index(this);
        $('.insurance-locations div').removeClass('locationClick');
        $(this).addClass('locationClick');

        $('.insurance-info').removeClass('showTale');
        $('.sections-con.show > section:nth-child(1) > table').eq(idx).addClass('showTale');
    });

});
// if (idx === 0) {
//     $('.second-box-tabs-clicked-bar').css('margin-left', '0px')
// } else if (idx === 1) {
//     $('.second-box-tabs-clicked-bar').css('margin-left', '243px')
// } else {
//     $('.second-box-tabs-clicked-bar').css('margin-left', '486px')
// }

