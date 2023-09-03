async function answerBtn(element) {
    qnaNumber = element.id;
    const { value: text } = await Swal.fire({
        input: 'textarea',
        inputLabel: '답변하기',
        inputPlaceholder: 'Type your message here...',
        inputAttributes: {
            'aria-label': 'Type your message here'
        },
        showCancelButton: true
    })

    if (text) {
        Swal.fire({
            title: '답변을 저장할까요?',
            showDenyButton: true,
            confirmButtonText: '네',
            denyButtonText: `아니오`,
        }).then((result) => {
            /* Read more about isConfirmed, isDenied below */
            if (result.isConfirmed) {
                var query = {
                    qnaNumber:qnaNumber,
                    qnaAnswer:text
                }

                $.ajax({

                    url: '/manager/answerQna',
                    method: 'POST',
                    data: query,
                    success: function (data) {

                        Swal.fire('답변이 저장되었습니다.', '', 'success').then((result) => {

                            location.reload();

                        })
                    }, error: function () {

                    }
                });
            }
        })
    }


}

function delQna(element) {

    qnaNumber = element.id;

    console.log("삭제버튼 클릭");
    // Swal.fire('비밀번호가 변경됐습니다', '', 'success').then((result) => {
    //
    //     window.location.href = '/';
    //
    // })

    Swal.fire({
        title: '<strong>HTML <u>example</u></strong>',
        icon: 'warning',
        title: '정말 문의내용을 삭제하시겠습니까?',
        showCloseButton: false,
        showCancelButton: true,
        focusConfirm: false,
        confirmButtonText:
            '확인',
        confirmButtonAriaLabel: 'great!',
        cancelButtonText:
            '취소',
        cancelButtonAriaLabel: 'Thumbs down'
    }).then((result) => {

        if (result.isConfirmed) {

            var query = {
                qnaNumber:qnaNumber
            }

            $.ajax({

                url: '/manager/deleteQna',
                method: 'POST',
                data: query,
                success: function (data) {

                    Swal.fire('삭제가 완료됐습니다.', '', 'success').then((result) => {

                        location.reload();

                    })
                }, error: function () {

                }
            });

        }

    })
}