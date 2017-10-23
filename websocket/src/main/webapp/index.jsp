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

        var stompClient = null;

        // 连接
        function connect() {
            var userId = $("#userId").val();
            var socket = new SockJS("/stomp");
            stompClient = Stomp.over(socket);
            stompClient.connect({'userId': userId}, function (frame) {
                setConnected(true);
                console.log('连接成功: ' + frame);
                showGreeting("连接成功");
                // 广播
                stompClient.subscribe('/topic/message', function (greeting) {
                    console.log('subscribe: ' + greeting);
                    showGreeting(JSON.parse(greeting.body).content);
                });
                // 一对一通信
                stompClient.subscribe('/user/' + userId + '/message', function (greeting) {
                    console.log('subscribe: ' + greeting);
                    showGreeting(JSON.parse(greeting.body).content);
                });
            }, function (error) {
                console.log('connect error: ' + error);
                alert(error);
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect(function () {
                    setConnected(false);
                    console.log("断开");
                });
            }
        }

        function send() {
            if (stompClient.connected) {
                var body = JSON.stringify({
                    'userId': $("#send_userId").val(),
                    'content': $("#send_content").val()
                });
                stompClient.send("/app/stomp/send", {'type': 'text'}, body);
                console.log("send: " + body);
            } else {
                setConnected(false);
            }
        }

        // 显示信息
        function showGreeting(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }

        function setConnected(connected) {
            $("#connect").prop("disabled", connected);
            $("#disconnect").prop("disabled", !connected);
            if (connected) {
                $("#conversationDiv").show();
            } else {
                $("#conversationDiv").hide();
            }
            $("#response").html('');
        }
    </script>
</head>
<body>
<div>
    <div>
        <label>登录</label><br/>
        <input type="text" id="userId" placeholder="输入账号" value="937447974"/>
        <button id="connect" onclick="connect();">连接</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">断开</button>
    </div>
    <div id="conversationDiv">
        <label>发送消息</label>
        <br/>
        <input type="text" id="send_userId" placeholder="对方账号"/>
        <input type="text" id="send_content" placeholder="输入信息"/>
        <button onclick="send();">发送</button>
        <br/>
        <label>控制台</label><br/>
        <p id="response"></p>
    </div>
</div>
</body>
</html>