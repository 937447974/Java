<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>WebSocket</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/sockjs.js"></script>
    <script src="${pageContext.request.contextPath}/js/stomp.js"></script>
    <script type="text/javascript">
        var stompClient = null;

        function setConnected(connected) {
            $("#connect").prop("disabled", connected);
            $("#disconnect").prop("disabled", !connected);
            if (connected) {
                $("#conversationDiv").show();
            } else {
                $("#conversationDiv").hide();
            }
            document.getElementById('response').innerHTML = '';
        }

        //this line.
        function connect() {
            var userid = document.getElementById('userid').value;
            var socket = new SockJS("/websocket");
            stompClient = Stomp.over(socket);
            alert("333");
            stompClient.connect({}, function (frame) {
                alert(frame);
                setConnected(true);
                console.log('Connected: ' + frame);
                // 广播
                stompClient.subscribe('/topic/greetings', function (greeting) {
                    alert(JSON.parse(greeting.body).content);
                    showGreeting(JSON.parse(greeting.body).content);
                });
                // 一对一通信
                stompClient.subscribe('/user/' + userid + '/message', function (greeting) {
                    alert(JSON.parse(greeting.body).content);
                    showGreeting(JSON.parse(greeting.body).content);
                });
            });
        }

        function sendName() {
            var name = document.getElementById('name').value;

            stompClient.send("/app/hello", {atytopic: "greetings"}, JSON.stringify({'name': name}));
        }
        function sendBroadcast() {
            alert($("#broadcast").val());
            var txt = document.getElementById('broadcast').value;
            stompClient.send("/app/hello", {atytopic: "greetings"}, JSON.stringify({'msg': name}));
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }

        // 显示信息
        function showGreeting(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }
    </script>
</head>
<body>
<div>
    <div>
        <label>用户id?</label><input type="text" id="userid"/>
        <button id="connect" onclick="connect();">连接</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">断开</button>
    </div>
    <div id="conversationDiv">
        <label>广播</label><input type="text" id="broadcast"/><button onclick="sendBroadcast();">连接</button>

        <p id="response"></p>
    </div>
</div>
</body>
</html>