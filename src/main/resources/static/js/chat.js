var userNumber = -1;
var user;
var roomId = -1;
var webSocket;
var webSocketList = [];

console.log(userNumber)

// * 채팅 버튼 클릭시
// 모달 닫기


/*

    크게 두가지로 나뉘어진다.
    1. 채팅방 바깥에 , 즉 채팅방 목록에 있을 경우
        1-1. 내가 속해있는 채팅방을 모두 불러온다
        1-2. 내가 속해있는 채팅방의 마지막 메시지를 모두 불러온다. 해당 채팅방의 id는 roomId로 설정돼있다.


    2. 채팅방 안에 들어갔을 경우
        2-1. 채팅방에 들어갔을 때 전체 채팅방 메시지를 불러오기
        2-2. 만약 나와 같은 roomId에 있는 소켓에서 sendMessage를 실행한다면 addMessageBlock실행

 */


var url = location.pathname;
console.log(url);

if(url === '/chatTest1'){
    userNumber = 1;
}else if(url === '/chatTest2'){
    userNumber = 2;
}else if(url === '/chatTest3'){
    userNumber = 3;
}
else if(url === '/chatTest4'){
    userNumber = 4;
}



//클릭관련 이벤트 함수는 위쪽 배치. 실제 실행되는 함수는 아래쪽 배치.
$('#quit-chat-btn').click(function () {
    $('.modal').css('display', 'none');
    $('.chat-room-block').remove();
    $('.message-block').remove();
    //메시지 내용을 모두 지운다.

    userNumber = -1; // userNumber는 다시 1로 초기화해준다.
    // 그래야지 다음번에 showChatRoom메서드를 실행할 수 있다.

    for (var i = 0; i < webSocketList.length; i++) {

        if (webSocketList[i] != null) {

            webSocketList[i].close(); // 소켓 연결을 모두 끊는다.

        }
    }

})


$('#back-chat-btn').click(function () { // 뒤로가기 버튼 클릭시 채팅내용을 갖고 있던 건 모두 지워버린후 기존의 채팅방 조회 목록으로 진입.

    $('#message-input').addClass('disappear'); // 채팅입력하는 채팅창 disappear
    $('.message-block').remove(); // 채팅 메시지 블럭 제거
    $('#back-chat-btn').addClass('disappear'); // 뒤로가기버튼 disappear

    showChatRoom();

})


$('#live-chat').click(function () {

    //모달을 열때마다 userNumber를 요청한다.
    getUserNumber();

    // 소켓이 열린 상태라면 실행해서는 안된다.


    // 세션의 usernumber를 이용해 접속한 채팅방 목록을 불러온다.

})


// 메시지 전송을 눌렀을떄(Enter) sendMessage메서드 실행.
$('.message-input').on('keypress', function (e) {

        sendMessage(e);

    }
)


function getUserNumber(){

    console.log(userNumber)

    if(userNumber == -1){

        $.ajax({

            method : 'POST',
            url : '/getUserNumber2',
            data : {userNumber: userNumber}, // 임의로 설정한 userNumber를 넘겨주고 그걸 세션으로 더해준다.
            // 그러면 chatTest1에서는 세션1이 추가되고 chatTest2에서는 세션2기 추가될 것.

            // 실제로는 data쿼리없이 진짜 data만 받아와야한다.
            // 여기서 userNumber를 얻어온 후
            success : function(data){

                userNumber = data;
                console.log(userNumber + "userNumber값"  );

                showChatRoom(); // 콜백함수기 때문에 따로 실행하면 안된다.
            },error:function(){

            }
        })
    }else{

        showChatRoom(); // 콜백함수기 때문에 따로 실행하면 안된다.

    }


}

// 모달 열기 + 채팅방 목록 불러오는 함수
// 처음 모달을 열떄는 소켓 통신이 되어있어야한다.
function showChatRoom() {

    if (userNumber == -1) {

        alert("로그인이 필요한 서비스입니다.");
        return;
    }

    $.ajax({

        method: 'POST',
        // url: '/getUserNumber',      원래는 getUserNumber를 통해 관련데이터를 넘겨받는 식이지만
        url : '/getChatData',                                // 현재로서는 서로 다른 세션을 가져오기 위해 userNumber는 원래 가지고 있다고 가정하고 해당 userNumber로
        data : {userNumber:userNumber},                                // 채팅방 및 메세지 정보를 가지고 오는 ajax요청을 실행한다.
        success: function (data) {

            console.log(data)
            user = data.user; // 현재 접속한 유저 정보를 저장한다.
            var roomList = data.roomList; // 현재 속해있는 방의 리스트를 가지고 온다.
            var lastMessageList = data.lastMessageList;

            userNumber = user.userNumber;

            $('.modal').css('display', 'block');


            addSocket(data); // roomList정보에 맞게 소켓정보를 추가해준다.

            // 채팅방 목록 불러오기 완료, 불러온 채팅방 ui 추가.

            // 세션을 통해 유저 정보를 가지고 오고 해당 유저 정보를 가진 채팅방을 모두 불러온다.

        }, error: function () {

        }
    })

}

function addSocket(data){

    var body = '';
    // 소켓 추가하는 기능.
    user = data.user; // 현재 접속한 유저 정보를 저장한다.
    var roomList = data.roomList; // 현재 속해있는 방의 리스트를 가지고 온다.
    var lastMessageList = data.lastMessageList;



    for (var i = 0; i < roomList.length; i++) {

        var roomId = roomList[i].roomId; // 전역변수 roomId x. 전역변수 roomId는 현재 내 위치가 어디있는지 파악하기 위함이다.
        webSocket = new WebSocket('ws://' + location.host + '/ws/' + roomId + '/' + userNumber);
        webSocketList[roomId] = webSocket; // webSocketList에 roomId를 키값으로 해서 webSocket을 차례대로 put한다
        // 즉 위코드는 다음과 같다 Map 객체에 put(key,value)

        var tmpUser = roomList[i].user1.userNumber != user.userNumber ? roomList[i].user1 : roomList[i].user2;

        // 현재 유저 말고 다른 유저를 가지고 온다.

        body += `<div class="chat-room-block" onclick="joinChatRoom(this)" id=${roomId}>` +

            `<div class = "chat-room-block-left"><img class = "chat-room-img" src = "/file/profile_image/${tmpUser.userImg}"></div>` +
            `<div class = "chat-room-block-right">` +
            `<div class = "chat-room-name">${tmpUser.userId.split('@')[0]}</div>` +
            `<div class = "chat-room-content">${lastMessageList[i]}</div>` +
            `</div>` +
            `</div>`
        run(); // addEvenetListener를 추가한다고 생각하면 됨.
    }
    $('.modal-content').append(body);
}


// enter눌렸을 떄 실행되는 메서드.
function sendMessage(e) {


    if (e.key === "Enter") {

        var query = {
            type: 'message',     // 데이터 전송 타입
            sendId: userNumber, // 발신자 ,(userNumber).
            roomId: roomId,    // 채팅방번호
            content: $('.message-input').val() // 전송 데이터.
        }
        webSocket.send(JSON.stringify(query));


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


    }
}


// 실제 소켓 연결이 된 후 채팅방에 접속하고 나가고 할때 이뤄지는 동작들(close, send, error등)
function run() {
    webSocket.onopen = function (e) {
        console.log('소켈열림.')
    }
    webSocket.close = function (e) {

        console.log("소켓연결이 종료됐습니다.")
        webSocket.send(`connection closed:${e.reason}`);
    }


    // 소켓 연결된 다른 클라이언트에게 메시지가 왔을 떄.
    webSocket.onmessage = function (e) {

        // 넘어온 데이터는 기존 타입에서 chatMessage 객체가 추가된 property일것이다.
        var data = JSON.parse(e.data);
        var sendId = JSON.parse(data.sendId); //료 발신자 user객체
        var content = data.content; // 발신 내용
        var type = data.type; //메시지 전송타입.
        var message = data.message;

        // 넘어온 데이터를 파싱한다. 이때 소켓이 열려있지 않다면 db에만 저장될 것.
        // payload에서 가지고 오는 값은 user
        //
        var parsed_message = JSON.parse(message);

        if (type === 'message' && roomId == parsed_message.chatRoom.roomId) { // 전송된 데이터가 단순 메시지 전송이라면

            addMessageBlock(message);

        }
    }

}

// 메시지를 수신시, 송신이세 modal-content에 자식요소 div추가하는 메서드.
// 수신시에 실시간으로 메시지를 추가해줘야한다. 그러나 이떄 현재 내가 대화하는 roomId와
// 메시지를 발신한 사람의 roomId가 같아야만 한다.
function addMessageBlock(message) {

    var message = JSON.parse(message);
    var user = message.user; // db의 필드명인 sendId로 저장되는 것이 아니고 Message객체의 필드인 USer객체이름인 user로 저장된다.
    var date = new Date(); // 정확히 말하면 이 시간으로 하면 안되고 db에 저장된 시간으로 해야한다.
    var hour = String(date.getHours()).padStart(2, '0');
    var minute = String(date.getMinutes()).padStart(2, '0');

    if (message.sendTime != null) {
    } else {
        hour = message.snedTime[3];
        minute = message.snedTime[4];
    }


    const formattedDate = `${hour}:${minute}`; // '09:11'
    var userId = user.userId.split('@')[0];

    var body = '<div class = "message-block">' +
        '<div class = "message-img">' +
        `<img class = "message-img" src="/file/profile_image/${user.userImg}" alt="">` +
        '</div>' +
        `<div class = "message-center">` +
        `<div class = "message-userId">${userId}</div>` +
        `<div class = "message-content" >${message.content}</div>` +
        `</div>` +
        `<div class = "message-time">${formattedDate}</div>` +
        '</div>'

    $('.modal-content').append(body); // 채팅창에 메시지를 추가한다.

}


// 채팅방을 들어왔을 때 실행되는 메서드.
// 채팅방에 들어왔을떄는 기존의 버튼을 제거하고 위쪽의 뒤로가기 버튼을 추가해줘야한다.
function joinChatRoom(element) {


    // 방을 접속하게 되면 현재 접속한 방의 번호와 유저정보를 가지고 있어야한다.
    //유저 정보는 어차피 한번 불러오면 세션에서 동일한 유저일 것임.
    roomId = element.id;
    console.log(roomId)
    webSocket = webSocketList[roomId]; // 현재 접속한 방번호로 socket을 교체한다.
    // 채팅방을 접속하고 나면 대화목록을 모두 불러와야 한다.


    $('.chat-modal-content').remove(); // 채팅방 목록을 제거한다.
    $('#back-chat-btn').removeClass('disappear'); // 뒤로가기 버튼을 생성한다.


    $.ajax({

        method: 'POST',
        url: '/getMessageList',
        data: {roomId: roomId},
        success: function (data) {

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
            // 이전 대화내용을 모두 불러온다.
            // userNumber는 전역변수로 선언돼있다.
            $('.modal-content').append(body);
            $('.modal-btn').remove(); // 모달 나가기 버튼 없애기
            $('.message-input').removeClass('disappear');


        }, error: function () {

        }

    })


}


// show 채팅방목록


// show 채팅방 들어가ㄴㄴㄴ