$(document).ready(() => {
// // 로그인 해서 user.number 가지고 있는 사람
//
//
//     const editBtn = document.getElementsByClassName('bt_container_m_view');
//
//     console.log()
//
//     for (let i = 0; i < editBtn.length; i++) {
//         if (user.user_number !== accompany.user_number) {
//             editBtn.style.display = 'none';
//         } else {
//             editBtn.style.display = 'block';
//         }
//     }


// //취소 버튼 클릭시 accompany(동행 메인)으로 이동


// 삭제버튼 클릭시 실행


    $('#deleteBtn').click(function () {
        console.log('delAccompany ajax 메서드 실행');

        var ac_num = $('#inputAcNum').val(); // input 요소의 값을 가져옵니다.

        var query = {
            ac_num: ac_num
        };
        console.log('ac_num실행 중');
        console.log('delAccompany ajax실행 중');

        $.ajax({
            url: '/community/accompany/delete',
            method: 'POST',
            data: query,
            success: function (data) {
                console.log("result : " + data);

                Swal.fire({
                    title: '게시물을 삭제하시겠습니까?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: '삭제'
                }).then((result) => {
                    if (result.isConfirmed) {
                        Swal.fire('삭제',
                            '삭제되었습니다.',
                            'success')
                        window.location.href = '/community/accompany/'
                    }
                });
            },
            error: function () {
                Swal.fire('삭제 실패', '작업 수행에 실패하였습니다.', 'error');
            }
        });
    });

})

