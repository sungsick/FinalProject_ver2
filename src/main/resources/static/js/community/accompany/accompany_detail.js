

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


//취소 버튼 클릭시 accompany(동행 메인)으로 이동
const cancelbtn = document.querySelector('.bt_container_m_btn');

cancelbtn.addEventListener('click', () => {

    fetch('community/accompany/delete',{
      method: 'GET',

    })
        .then(response => {
            if (response.ok) {
                alert('삭제 성공!!')

            }else {
                alert('eles로 감???')
            }
        })
        .catch(error => {
            console.log('삭제 요청 중 오류 발생:', error);
        })
});
