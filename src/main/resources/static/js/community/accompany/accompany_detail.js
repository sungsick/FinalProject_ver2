// 로그인 해서 user.number 가지고 있는 사람이거나 user

// $(document).ready(function() {
//
//     const editBtn = document.getElementsByClassName('bt_container_m_view');
//
//     console.log()
//
//     for(let i = 0; i < editBtn.length; i++) {
//         if (user.user_number !== accompany.user_number) {
//             editBtn.style.display= 'none';
//         } else {
//             editBtn.style.display = 'block';
//         }
//     }
// });


// //취소 버튼 클릭시 accompany(동행 메인)으로 이동


// 삭제 버튼 클릭 이벤트
// 삭제 버튼 클릭 이벤트
$('#deleteBtn').click(function() {
    console.log('delAccompany ajax 메서드 실행');
    var ac_num = element.id; // element 변수가 어떻게 정의되었는지 확인

    Swal.fire({
        title: '<strong>HTML <u>example</u></strong>',
        icon: 'warning',
        text: '정말 글을 삭제하시겠습니까?', // 'title'을 'text'로 수정
        showCloseButton: false,
        showCancelButton: true,
        focusConfirm: false,
        confirmButtonText: '확인',
        confirmButtonAriaLabel: 'great!',
        cancelButtonText: '취소',
        cancelButtonAriaLabel: 'Thumbs down'
    }).then((result) => {
        if (result.isConfirmed) {
            var query = {
                ac_num: ac_num
            };

            $.ajax({
                url: 'community/accompany/delete',
                method: 'GET',
                data: query,
                success: function (data) {
                    // Ajax 요청 성공 시 작업 수행
                    // 페이지 내용 업데이트 또는 메시지 표시
                    Swal.fire('삭제가 완료되었습니다.', '', 'success');
                    // 예를 들어, 페이지 내용 업데이트
                    // updatePageContent(data);
                },
                error: function (error) {
                    // Ajax 요청 실패 시 작업 수행
                    // 오류 메시지 표시 또는 사용자 안내
                    Swal.fire('삭제 실패', '작업 수행에 실패하였습니다.', 'error');
                },
            });
        }
    });
});
