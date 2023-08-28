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

    $('#find-id-tab').click(()=>{

        console.log("아이디 버튼클릭.")
        $('.idpw-container-inner1').removeClass('disappear');
        $('.idpw-container-inner2').addClass('disappear');
    })

    $('#find-pw-tab').click(()=>{

        $('.idpw-container-inner2').removeClass('disappear');
        $('.idpw-container-inner1').addClass('disappear');

    })


    $('#find-id-button').click(()=>{ // 아이디 찾기 버튼 클릭시

        var query = {
            user_name : $('[name=user_name]').val(),
            user_phone : $('[name=user_phone1]').val()

        }

        $.ajax({

            url:'/member/requestId',
            method:'POST',
            data:query,
            success:function(result){
                console.log("requestid success");
                if(result !== "error"){

                    alert("찾으시는 아이디는 "+result+"입니다.");

                }else if(result === "error"){

                    alert("조회되는 아이디가 없습니다.");

                }

            },error:function(){


            }

        })
    })

    $('#find-pw-button').click(()=>{ // 비번찾기 버튼 클릭시

        var query = {
            user_id : $('[name=user_id]').val(),
            user_phone : $('[name=user_phone2]').val()
        };

        $.ajax({

            url:'/member/requestPw',
            method:'POST',
            data:query,
            success:function(result){

                if(result !== 'error'){

                    // 아이디와 휴대폰번호에 일치하는 유저정보가 있다는 뜻이므로 실제로
                    // 인증번호를 전송해주고 모달창이나 아래쪽 div를 열어준다.
                    // 혹은 모달창을 띄워준다.



                }else{

                    alert("입력하신 아이디와 휴대폰 번호와 일치하는 회원정보가 없습니다.");
                }

                console.log("requestPw success");
            },error:function(){


            }

        })
    })


})