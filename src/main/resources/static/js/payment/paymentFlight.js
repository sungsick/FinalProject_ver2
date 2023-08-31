$(function () {
    // tab 기능
    var $tablink = $('.second-box-tabs div').click(function (e) {
        var idx = $tablink.index(this);
        $('.second-box-tabs div').css('color', 'rgb(170, 170, 170)');
        $('.second-box-tabs div').css('font-weight', '400');
        $(this).css('color', '#00ce7c');
        $(this).css('font-weight', '600');

        var marginLeftValue = idx * 50;
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
        const birthpattern = /^(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0,1])$/;
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
            } else if (absolute < 20) {
                console.log('20이하');
                // 20세 미만
                warningDiv.textContent = "20세 미만입니다.";
                warningDiv.style.color = "red"; // 빨간색으로 변경
                btnKakaoPay.disabled = true;
            }

        } else if (!birthpattern.test(input_birth.value)) {
            // 정규식 제대로 작동 안함. 이전에 조건에 의해 조건이 끝나는듯
            console.log(birthpattern.test(input_birth.value) || input_birth.value.length > 6);
            warningDiv.textContent = "정확한 생년월일을 입력 하세요.";
            warningDiv.style.color = "red";
            btnKakaoPay.disabled = true;
        } else {
            warningDiv.textContent = "'-' 을 제외한 생년월일 6자리를 입력하세요"; // 경고 메시지 초기화
            btnKakaoPay.disabled = true;
        }
    });

    // 카카오결제
    $("#btnKakaoPay").click(function () {

        var query = {
            input_name: $("#input_name").val(),
            input_phone: $("#input_phone").val(),
            input_birth: $("#input_birth").val(),
            checkVal: $("input[formcontrolname=gender]:checked")
        }
        const phoneNumberPattern = /^01([0|1|6|7|8|9]?)([0-9]{3,4})([0-9]{4})$/; // 휴대폰 형식검사 정규 표현식

        if (query.input_name === '') {
            alert('이름을 입력하세요.');
            query.input_name.focus();
        } else if (query.input_phone === '') {
            alert('핸드폰 번호를 입력하세요.');
            query.input_birth.focus();
        } else if (iquery.input_birth === '') {
            alert('생년월일을 입력하세요.');
            query.input_birth.focus();
        } else if (!phoneNumberPattern.test(query.input_phone.value)) {
            alert("휴대폰 번호를 올바르게 입력하세요.");
            query.input_birth.focus();
        } else if (!query.checkVal) {
            alert("성별을 선택해 주세요.");
            focus(input[formcontrolname = gender]);
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
        // $("body").css('margin-left', '1px');  // 스크롤로 인한 화면 꿀렁거림 제거
        // 이유 모르겠는데 위 현상 없어짐
    })
    // 모달 닫기
    $('.modal-btn').click(function () {
        $('.modal').css('display', 'none');
        $("body").css('overflow', 'auto');
        // $("body").css('margin-left', '0px');  // 스크롤로 인한 화면 꿀렁거림 제거
        // 이유 모르겠는데 위 현상 없어짐
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

