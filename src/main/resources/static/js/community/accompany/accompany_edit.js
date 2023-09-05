$(function () {

    let choiceRegion = document.getElementById("region").value;
    let editRegion = document.querySelectorAll(".C-nav-btn")

    console.log(choiceRegion)
    console.log(editRegion.length);


    for (let i = 0; i < editRegion.length; i++) {
        let editRegionValue = editRegion[i].innerText;
        console.log(editRegionValue)
        if (choiceRegion === editRegionValue) {
            editRegion[i].style.backgroundColor = "#00b8ff";
            editRegion[i].style.border = "none";
            editRegion[i].style.color = "ffffff";
            editRegion[i].style.fontWeight = "500";

        }

        editRegion[i].addEventListener("click", function () {
            editRegion[i].style.backgroundColor = "";
            editRegion[i].style.border = "";
            editRegion[i].style.color = "";
            editRegion[i].style.fontWeight = "";

        })


        function editPerson() {
            let selectedPerson = document.getElementById("#customRange1").value;
            document.getElementById("#slider_value_view").innerText = selectedPerson;

        }

        var myRange = document.querySelector('#customRange1');
        var myValue = document.querySelector('#slider_value_view');
        var thumbWidth = 18;

        var off = (myRange.clientWidth - thumbWidth) / (parseInt(myRange.max) - parseInt(myRange.min));
        var px = ((myRange.valueAsNumber - parseInt(myRange.min)) * off) - (myValue.clientWidth / 2) + (thumbWidth / 2);

        myValue.style.left = px + 'px';
        myValue.style.top = -myRange.offsetHeight - 5 + 'px';
        myValue.innerHTML = myRange.value;

        myRange.oninput = function () {
            let px = ((myRange.valueAsNumber - parseInt(myRange.min)) * off) - (myValue.clientWidth / 2) + (thumbWidth / 2);
            myValue.innerHTML = myRange.value;
            myValue.style.left = px + 'px';
        };
    }



//취소 버튼 클릭시 accompany(동행 메인)으로 이동
    const cancelbtn = document.querySelector('.cancelbtn');

    cancelbtn.addEventListener('click', () => {
        window.location.href = '/community/accompany';
    });

    // //작성완료 버튼 클릭시 accompany(동행 메인)으로 이동
    // const writebtn = document.querySelector('.writebtn');
    //
    // cancelbtn.addEventListener('click', () => {
    //     window.location.href = '/community/accompany/update';
    // });



// // 지역 선택 시 색깔 변함
// const Cnavbtnsp1 = document.querySelectorAll(".C-nav-btn1 > div");
// const Cnavbtnsp2 = document.querySelectorAll(".C-nav-btn2 > div");
//
// function handleClick(e) {
//     const targetElement = e.currentTarget;
//
//     if (targetElement.classList.contains("regionCliked")) {
//         targetElement.classList.remove("regionCliked");
//     } else {
//         for (var i = 0; i < Cnavbtnsp1.length; i++) {
//             Cnavbtnsp1[i].classList.remove("regionCliked");
//         }
//         for (var i = 0; i < Cnavbtnsp2.length; i++) {
//             Cnavbtnsp2[i].classList.remove("regionCliked");
//         }
//         targetElement.classList.add("regionCliked");
//     }
// }
//
// function regionInit() {
//     Cnavbtnsp1.forEach(btn => {
//         btn.addEventListener("click", handleClick);
//     });
//
//     Cnavbtnsp2.forEach(btn => {
//         btn.addEventListener("click", handleClick);
//     });
// }
//
// regionInit();


    const Cnavbtnsp1 = document.querySelectorAll(".C-nav-btn1 .C-nav-btn");
    const Cnavbtnsp2 = document.querySelectorAll(".C-nav-btn2 .C-nav-btn");
    const Cnavbtnsp3 = document.querySelectorAll(".C-activ");

// const regionInput = document.querySelector("#region");

    function handleClick(e) {
        const targetElement = e.currentTarget;
        const totalBtn = [...Cnavbtnsp1, ...Cnavbtnsp2]
        console.log(totalBtn.length);

        if (targetElement.classList.contains("regionCliked")) {
            targetElement.classList.remove("regionCliked");
        } else {
            for (let i = 0; i < totalBtn.length; i++) {
                totalBtn[i].classList.remove("regionCliked");
            }
            targetElement.classList.add("regionCliked");
            region.value = targetElement?.children[0]?.textContent
        }
    }

    function regionInit() {
        Cnavbtnsp1.forEach(btn => {
            btn.addEventListener("click", handleClick);
        });

        Cnavbtnsp2.forEach(btn => {
            btn.addEventListener("click", handleClick);
        });
        Cnavbtnsp3.forEach(btn => {
            btn.addEventListener("click", handleClick);
        });
    }

    regionInit();


    
    
    
    
    
    
    
    // range 커스텀 한 것. 점 따라서 숫자 변하게
    var myRange = document.querySelector('#customRange1');
    var myValue = document.querySelector('#slider_value_view');
    var thumbWidth = 18;

    function updateSliderValue() {
        var off = (myRange.clientWidth - thumbWidth) / (parseInt(myRange.max) - parseInt(myRange.min));
        var px = ((myRange.valueAsNumber - parseInt(myRange.min)) * off) - (myValue.clientWidth / 2) + (thumbWidth / 2);

        myValue.style.left = px + 'px';
        myValue.style.top = -myRange.offsetHeight - 5 + 'px';
        myValue.innerHTML = myRange.value;
    }


    myRange.oninput = function () {
        updateSliderValue();
    };


// 페이지 로드 시 슬라이더 값 업데이트
    window.onload = function () {
        updateSliderValue();
    };


$('.writebtn').click(function () {

    console.log("accompany update submit_btn 클릭!")



    var query = JSON.stringify({
        ac_region: $('input[name=ac_region]').val(), // 변수명 수정
        ac_startdate: $('input[name=ac_startdate]').val(), // 변수명 수정
        ac_enddate: $('input[name=ac_enddate]').val(), // 변수명 수정
        ac_people: $('input[name=ac_people]').val(), // 변수명 수정
        ac_picture: $('input[name=ac_picture]').val(), // 변수명 수정
        ac_title: $('input[name=ac_title]').val(), // 변수명 수정
        ac_text: $('input[name=ac_text]').val() // 변수명 수정
    });


    $.ajax({
        url: '/community/accompany/update',
        type: 'POST',
        data: query,
        contentType: 'application/json',
        success : function (data) {
            alert("저장완료");
    },
        error: function () {

        alert("code: ajax 통신 에러")
    },

    })
})

// //배경사진 선택 자바스크립트
//     const photoDiv = document.querySelector('.photo');
//     const fileInput = document.getElementById('fileInput');
//
//     photoDiv.addEventListener('click', () => {
//         fileInput.click();
//     });
//
//     fileInput.addEventListener('change', (event) => {
//         const selectedImage = event.target.files[0];
//
//         if (selectedImage) {
//             const imageUrl = URL.createObjectURL(selectedImage);
//             photoDiv.style.backgroundImage = `url(${imageUrl})`;
//         }
//     });


});