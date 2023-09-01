
    //배경사진 선택 자바스크립트
    const photoDiv = document.querySelector('.photo');
    const fileInput = document.getElementById('fileInput');

    photoDiv.addEventListener('click', () => {
    fileInput.click();
});

    fileInput.addEventListener('change', (event) => {
    const selectedImage = event.target.files[0];

    if (selectedImage) {
    const imageUrl = URL.createObjectURL(selectedImage);
    photoDiv.style.backgroundImage = `url(${imageUrl})`;
}
});



    //작성완료 버튼 클릭시 accompany_detail(동행게시글 상세보기)으로 이동
    const writeButton = document.querySelector('.writebtn');

    writeButton.addEventListener('click', () => {
    window.location.href = '/community/accompany/writePro';
});

    //취소 버튼 클릭시 accompany(동행 메인)으로 이동
    const cancelbtn = document.querySelector('.cancelbtn');

    cancelbtn.addEventListener('click', () => {
    window.location.href = '/community/accompany';
});


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

    function handleClick(e) {
        const targetElement = e.currentTarget;

        if (targetElement.classList.contains("regionCliked")) {
            targetElement.classList.remove("regionCliked");
        } else {
            // "전체" 버튼을 선택하는 조건 추가
            if (targetElement.classList.contains("C-activ")) {
                for (var i = 0; i < Cnavbtnsp1.length; i++) {
                    Cnavbtnsp1[i].classList.remove("regionCliked");
                }
                for (var i = 0; i < Cnavbtnsp2.length; i++) {
                    Cnavbtnsp2[i].classList.remove("regionCliked");
                }
            } else {
                for (var i = 0; i < Cnavbtnsp1.length; i++) {
                    Cnavbtnsp1[i].classList.remove("regionCliked");
                }
                for (var i = 0; i < Cnavbtnsp2.length; i++) {
                    Cnavbtnsp2[i].classList.remove("regionCliked");
                }
                targetElement.classList.add("regionCliked");
            }
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




