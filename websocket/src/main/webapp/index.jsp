<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>WebSocket</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/sockjs.js"></script>
    <script src="${pageContext.request.contextPath}/js/stomp.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            setConnected(false);
        });
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

        var stompClient = null;
        //this line.
        function connect() {
            var userid = document.getElementById('userid').value;
            var socket = new SockJS("/stomp");
            stompClient = Stomp.over(socket);
            stompClient.connect({'Auth-Token': userid}, function (frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                showGreeting("连接成功");
                // 广播
                stompClient.subscribe('/topic', function (greeting) {
                    console.log('subscribe: ' + greeting);
                    showGreeting(JSON.parse(greeting.body).content);
                });
                // 一对一通信
                stompClient.subscribe('/user/' + userid + '/message', function (greeting) {
                    console.log('subscribe: ' + greeting);
                    showGreeting(JSON.parse(greeting.body).content);
                });
            }, function(error) {
                console.log('connect error: ' + error);
                alert(error);
            });
        }

        function sendToUser() {
            var name = document.getElementById('targetMsg').value;
            stompClient.send("/app/stomp/sendToUser/1", {'type': 'text'}, JSON.stringify({ 'userID':'1','content': name}));
        }

        function sendBroadcast() {
            if (stompClient.connected) {
                var txt = document.getElementById('broadcast').value;
                stompClient.send("/app/stomp/sendBroadcast", {'type': 'text'}, JSON.stringify({'content': txt}));
            }
//           stompClient.send("/sendBroadcast", {"type": "text"}, JSON.stringify({'content': txt}));
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
        <label>登录</label><br/>
        <input type="text" id="userid" placeholder="输入账号"/>
        <button id="connect" onclick="connect();">连接</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">断开</button>
    </div>
    <div id="conversationDiv">
        <label>广播</label><br/>
        <input type="text" id="broadcast" placeholder="输入信息"/>
        <button onclick="sendBroadcast();">发送</button>
        <br/>
        <label>一对一通信</label><<br/>
        <input type="text" id="targetid" placeholder="对方账号"/><input type="text" id="targetMsg" placeholder="输入信息"/>
        <button onclick="sendToUser();">发送</button>
        <br/>
        <p id="response"></p>
    </div>
</div>
</body>
</html>