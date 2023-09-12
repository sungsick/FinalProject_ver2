$(function () {

    const currentUrl = window.location.href;



    let word = currentUrl.split('=');
    console.log("word값은" + word)

    console.log("word값은" + word[1])
    if (word[1] === "recent") {

        let accompanyQueryChoice = document.getElementById("recent");
        let accompanyQueryBtn = document.getElementsByClassName("accompanyQuery");


        for (let i = 0; i < accompanyQueryBtn.length; i++) {
            let QueryValue = accompanyQueryBtn[i].getAttribute("name");
            console.log("QueryValue 값은" + QueryValue)
            if (accompanyQueryChoice.getAttribute("name") === QueryValue) {
                accompanyQueryBtn[i].style.backgroundColor = "#00b8ff";
                accompanyQueryBtn[i].style.border = "none";
                accompanyQueryBtn[i].style.color = "#ffffff";
            }

            accompanyQueryBtn[i].addEventListener("click", function () {
                accompanyQueryBtn[i].style.backgroundColor = "";
                accompanyQueryBtn[i].style.border = "";
                accompanyQueryBtn[i].style.color = "";
            })

        }
    } else if (word[1] === "viewcount") {

        let accompanyQueryChoice = document.getElementById("viewcount");
        let accompanyQueryBtn = document.getElementsByClassName("accompanyQuery");


        for (let i = 0; i < accompanyQueryBtn.length; i++) {
            let QueryValue = accompanyQueryBtn[i].getAttribute("name");
            console.log("QueryValue 값은" + QueryValue)
            if (accompanyQueryChoice.getAttribute("name") === QueryValue) {
                accompanyQueryBtn[i].style.backgroundColor = "#00b8ff";
                accompanyQueryBtn[i].style.border = "none";
                accompanyQueryBtn[i].style.color = "#ffffff";
            }

            accompanyQueryBtn[i].addEventListener("click", function () {
                accompanyQueryBtn[i].style.backgroundColor = "";
                accompanyQueryBtn[i].style.border = "";
                accompanyQueryBtn[i].style.color = "";
            })

        }
    } else if (word[1] === "countComment") {

        let accompanyQueryChoice = document.getElementById("countComment");
        let accompanyQueryBtn = document.getElementsByClassName("accompanyQuery");


        for (let i = 0; i < accompanyQueryBtn.length; i++) {
            let QueryValue = accompanyQueryBtn[i].getAttribute("name");
            console.log("QueryValue 값은" + QueryValue)
            if (accompanyQueryChoice.getAttribute("name") === QueryValue) {
                accompanyQueryBtn[i].style.backgroundColor = "#00b8ff";
                accompanyQueryBtn[i].style.border = "none";
                accompanyQueryBtn[i].style.color = "#ffffff";
            }

            accompanyQueryBtn[i].addEventListener("click", function () {
                accompanyQueryBtn[i].style.backgroundColor = "";
                accompanyQueryBtn[i].style.border = "";
                accompanyQueryBtn[i].style.color = "";
            })

        }
    }


    /* 최근 글 순으로 정렬*/
    $("#recent").click(() => {
        const recent = "recent"

        window.location.href = `/community/accompany?orderby=${recent}`;

    });

    $("#viewcount").click(() => {
        const viewcount = "viewcount"
        window.location.href = `/community/accompany?orderby=${viewcount}`;
    });

    let regionChoice = true;

    /* 모든 지역 클릭하면 슬라이드다운 */
    $("#allRegion, #allRegionIcon").click(() => {
        const regionUl = $(".sub"); // .sub 클래스를 가진 ul 요소 선택


        if (regionChoice) {
            regionUl.slideDown(1000);
        } else {
            regionUl.slideUp(1000);
        }
        regionChoice = !regionChoice;
    });


    /* 지역 선택 해서 동행글 쿼리*/
    $(".regionAt").click((event) => {

        const id = event.target.name;
        // 여기서는 `name` 속성을 사용하여 선택한 지역 값을 가져옵니다.
        console.log("id값은" + id);
        // URL에 선택한 지역 값을 추가합니다.
        window.location.href = `/community/accompany?regionAt=${id}`;
    });


    $("#countComment").click((event) => {
        const id = event.target.id;

        console.log("id값은" + id);

        window.location.href = `/community/accompany?orderby=${id}`;


    })


// /* 모든 지역 클릭하면 슬라이드다운 */

    let dateToggle = false;
    $(".md_searchPeriodIcon, .md_searchPeriod").click(() => {

        const periodUI = $(".searchPeriodBox");

        if (dateToggle) {
            periodUI.slideDown(1000);
        } else {
            periodUI.slideUp(1000);
        }
        dateToggle = !dateToggle;
    })


// 시작 날짜, 마지막 날짜 선택하면  해당 날짜 게시글만 쿼리됨
    $(".searchPeriodBtn").click(() => {

        const startdate = $(".queryStartdate").val();
        const enddate = $(".queryEnddate").val();

        console.log(startdate)
        console.log(enddate)
        window.location.href = `/community/accompany?startAt=${startdate}&endAt=${enddate}`;
    })
})


/* 중복 쿼리 하는중....*/

function updateURL(params) {


    const queryString = '/community/accompany';
    const newURL = new URLSearchParams(queryString.search);

}

/* 지역 선택 해서 동행글 쿼리 */
$(".regionAt").click((event) => {
    const id = event.target.name;
    // 여기서는 `name` 속성을 사용하여 선택한 지역 값을 가져옵니다.
    console.log("id값은 " + id);
    // URL에 선택한 지역 값을 추가합니다.
    const regionURL = `/community/accompany?regionAt=${id}`;
    window.location.href = regionURL;
});

$(".searchPeriodBtn").click(() => {
    const startdate = $(".queryStartdate").val();
    const enddate = $(".queryEnddate").val();
    console.log(startdate);
    console.log(enddate);
    window.location.href = `/community/accompany?startAt=${startdate}&endAt=${enddate}`;
});

$("#recent, .regionAt").click((event) => {
    const params = {};
    // 여기서 필요한 파라미터를 추가
    params["startAt"] = $(".queryStartdate").val();
    params["endAt"] = $(".queryEnddate").val();

    if (event.target.id === "recent") {
        params["orderby"] = "recent"; // 최신 순 정렬
    } else if (event.target.classList.contains("regionAt")) {
        const id = event.target.name;
        params["regionAt"] = id; // 지역 선택
    }

    // URL을 생성할 때 쿼리 파라미터를 추가합니다.
    const queryString = Object.keys(params)
        .map((key) => key + "=" + params[key])
        .join("&");
    console.log('hi')
    const newURL = `/community/accompgany?${queryString}`;
    window.location.href = newURL;

});
/* hi*/