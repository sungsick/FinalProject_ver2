
$(document).ready(function () {


    const choice_post = document.querySelector(".choice_post");
    const nav_community = document.querySelector("#nav_community");
    const nav_trip = document.querySelector("#nav_trip");
    const community_under_bar = $('.community'); // community 아래쪽 div
    const store_under_bar = $('.store'); //store 아래쪽 div


// location.href처리에 따라 스타일 처리하기
    var url = window.location.pathname;
    var url_list = url.substring(1).split("/");


    if(url_list[0] === ''){
        $(".home").addClass('menu_underline');
    }



    var context_path = url_list[0]; // store/community
    var menu = url_list[1]; // 세부적으로 나뉘는 서브 메뉴


    if (context_path === "community") {
        //스타일 처리


        nav_community.classList.add('nav_underline');
        nav_trip.classList.remove('nav_underline');
        $(`.${menu}`).addClass('menu_underline');

        // 커뮤니티/여행상점 선택에 따른 underbar disappear선택
        community_under_bar.removeClass('disappear');
        store_under_bar.addClass('disappear');


    } else if (context_path === "store") {

        nav_community.classList.remove('nav_underline');
        nav_trip.classList.add('nav_underline');
        $(`.${menu}`).addClass('menu_underline');

        // 커뮤니티/여행상점 선택에 따른 underbar disappear선택
        community_under_bar.addClass('disappear');
        store_under_bar.removeClass('disappear');


    }

    $('#write_btn').click(()=>{
        if (choice_post.classList.contains("disappear")) {
            choice_post.classList.remove("disappear");
        } else {
            choice_post.classList.add("disappear");
        }

    })



    $(function () {

        console.log('hi')
        $('html').removeClass('no-js');

    });




    //헤더의 동행을 찾아보세요 서치바 검색 기능.

    $('#search_bar').on('keydown',function(e){

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





})


