var userNumber;
var user;
var roomId;
var webSocket;
var webSocketList = [];
// * 채팅 버튼 클릭시
// 모달 닫기
// 모달 닫기
$('.modal-btn').click(function () {
    $('.modal').css('display', 'none');
    console.log(webSocketList)
    $('.chat-room-block').remove();

    for (var i = 0; i < webSocketList.length; i++) {

        webSocketList[i].close(); // 소켓 연결을 모두 끊는다.
    }
    webSocketList = {};
    // 소켓 연결을 끊는다.
})


// 모달 열기
$('#live-chat').click(function () {

    // 세션의 usernumber를 이용해 접속한 채팅방 목록을 불러온다.

    $.ajax({

        method: 'POST',
        url: '/getUserNumber',
        success: function (data) {
            //
            // if(data == -1){
            //     alert('로그인 후 이용하세요.');
            //     return;
            // }
            // userNumber = data;

            console.log(data);

            user = data.user;
            var roomList = data.roomList;

            if (user == null) {

                alert("로그인이 필요한 서비스입니다.");
                return;
            }

            userNumber= user.userNumber;

            // userNumber = 1;



            $('.modal').css('display', 'block');


            var body = '';
            for (var i = 0; i < roomList.length; i++) {

                roomId = roomList[i];
                webSocket = new WebSocket('ws://' + location.host + '/ws/' + roomId + '/' + userNumber);
                webSocketList[roomId] = webSocket;

                body += `<div class="chat-room-block" onclick="joinChatRoom(this)" id=${roomId}>${roomList[i]}</div>`


                run(); // addEvenetListener를 추가한다고 생각하면 됨.


            }

            // 채팅방 목록 불러오기 완료, 불러온 채팅방 ui 추가.
            $('.modal-content').append(body);
            // 세션을 통해 유저 정보를 가지고 오고 해당 유저 정보를 가진 채팅방을 모두 불러온다.

        }, error: function () {

        }
    })
})


function run() { // 채팅방 목록을 불러온다.
    webSocket.onopen = function (e) {
    }
    webSocket.close = function (e) {

        console.log("소켓연결이 종료됐습니다.")
    }


    // 채팅방을 클릭했을 때
    // $('.chat-room-block').click(function(e){
    //
    //     var roomId = e.target.id;
    //     console.log(roomId + '번방 채팅방 접속.');
    //
    //
    // })



    // 소켓 연결된 다른 클라이언트에게 메시지가 왔을 떄.
    webSocket.onmessage = function (e) {

        console.log(e.data);
        var data = JSON.parse(e.data);
        console.log(data);

        // console.log(e.data);
        // // 문자열로 넘어온 List<Long>의 객체를 JSON타입으로 파싱한다.
        // var list = JSON.parse(e.data);
        //
        // for(var i = 0 ; i < list.length ; i ++){
        //
        //     console.log(list[i]); //해당 방만큼 소켓연결을 시도한다.
        // }

    }

}


// 채팅방을 들어왔을 때 실행되는 메서드.
function joinChatRoom(element) {

    // 방을 접속하게 되면 현재 접속한 방의 번호와 유저정보를 가지고 있어야한다.
    //유저 정보는 어차피 한번 불러오면 세션에서 동일한 유저일 것임.
    roomId = element.id;
    webSocket = webSocketList[roomId]; // 현재 접속한 방번호로 socket을 교체한다.
    // 채팅방을 접속하고 나면 대화목록을 모두 불러와야 한다.




    $('.chat-modal-content').remove();

    $.ajax({

        method: 'POST',
        url: '/getMessageList',
        data: {roomId: roomId},
        success: function (data) {

            console.log(data);
            var chatMessageList = data;
            var body = '';

            $('.chat-room-block').remove(); // 채팅방목록을 제거한다.


            for (var i = 0; i < chatMessageList.length; i++) {
                var date = new Date(chatMessageList[i].sendTime);
                var hour = String(date.getHours()).padStart(2, '0');
                var minute = String(date.getMinutes()).padStart(2, '0');

                const formattedDate = `${hour}:${minute}`; // '09:11'
                var userId = chatMessageList[i].user.userId.split('@')[0];

                // 여기서 내 메시지냐 상대 메시지냐에 따라 오른쪽으로 배치하냐 왼쪽으로 배치하냐 속성을 다르게 준다.
                body += '<div class = "message-block">' +
                    '<div class = "message-img">' +
                    `<img class = "message-img" src="/file/profile_image/${chatMessageList[i].user.userImg}" alt="">` +
                    '</div>' +
                    `<div class = "message-center">` +
                    `<div class = "message-userId">${userId}</div>` +
                    `<div class = "message-content" >${chatMessageList[i].content}</div>` +
                    `</div>` +
                    `<div class = "message-time">${formattedDate}</div>` +
                    '</div>'

            }


            ``
            console.log(body)
            // 이전 대화내용을 모두 불러온다.
            // userNumber는 전역변수로 선언돼있다.
            $('.modal-content').append(body);
            $('.modal-btn').remove(); // 모달 나가기 버튼 없애기
            $('.message-input').removeClass('disappear');


        }, error: function () {

        }

    })

    $('.message-input').on('keypress', function (e) {

        if (e.key === "Enter") {
            console.log('hi')

            var query = {
                type: 'message',     // 데이터 전송 타입
                sendId: userNumber, // 발신자
                roomId: roomId,    // 채팅방번호
                content: $('.message-input').val() // 전송 데이터.
            }
            webSocket.send(JSON.stringify(query));

            console.log(query.content);

            var date = new Date();
            var hour = String(date.getHours()).padStart(2, '0');
            var minute = String(date.getMinutes()).padStart(2, '0');

            const formattedDate = `${hour}:${minute}`; // '09:11'
            var userId = user.userId.split('@')[0];

            // var formattedValue = inputValue.replace(/\n/g, '<br>');


            // 여기서 내 메시지냐 상대 메시지냐에 따라 오른쪽으로 배치하냐 왼쪽으로 배치하냐 속성을 다르게 준다.
            var body = '<div class = "message-block">' +
                '<div class = "message-img">' +
                `<img class = "message-img" src="/file/profile_image/${user.userImg}" alt="">` +
                '</div>' +
                `<div class = "message-center">` +
                `<div class = "message-userId">${userId}</div>` +
                `<div class = "message-content" >${query.content}</div>` +
                `</div>` +
                `<div class = "message-time">${formattedDate}</div>` +
                '</div>'


            $('.message-input').val(''); // 빈칸으로 만들어준다.
            $('.modal-content').append(body);
            var textarea = document.getElementById('message-input'); // 'myTextarea'를 해당 textarea의 ID로 변경하세요.
            console.log(textarea)
            textarea.focus(); // textarea에 포커스 설정
            textarea.setSelectionRange(0, 0); // 포커스 위치를 맨 처음으로 설정 (0, 0)
            textarea.selectionStart = 0; // 커서 시작 위치를 0으로 설정
            textarea.selectionEnd = 0; // 커서 종료 위치도 0으로 설정


        }

    })


}


