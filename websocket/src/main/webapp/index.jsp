<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Hello WebSocket</title>
    <script src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script>
    <%--<script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>--%>
    <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/stomp.js"/>
<%--//    </script>--%>
    <script type="text/javascript">
        $(document).ready(function () {
            connect();
            //checkoutUserlist();
        });

        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        //this line.
        function connect() {
            var userid = document.getElementById('name').value;
            var socket = new SockJS("${pageContext.request.contextPath}/hello");
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function (greeting) {
                    showGreeting(JSON.parse(greeting.body).content);
                });

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

        function connectAny() {
            var socket = new SockJS("${pageContext.request.contextPath}/hello");
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/feed', function (greeting) {
                    alert(JSON.parse(greeting.body).content);
                    showGreeting(JSON.parse(greeting.body).content);
                });
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }


        function showGreeting(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }

        //将消息显示在网页上
        function setMessageInnerHTML(innerHTML) {
            var msg = innerHTML.split(" - ")

            var table = document.getElementById("tb");

            var row;
            row = table.insertRow(1);
            for (var i = 0; i < msg.length; i++) {
                var cell = row.insertCell(i);
                cell.appendChild(document.createTextNode(msg[i]));
            }
            if (table.rows.length > 50) {
                table.deleteRow(table.rows.length - 1);
            }
            //  document.getElementById('message').innerHTML += innerHTML + '<br/>';
        }

    </script>
</head>
<body>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="connectAny" onclick="connectAny();">ConnectAny</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <label>What is your name?</label><input type="text" id="name"/>
        <button id="sendName" onclick="sendName();">Send</button>
        <p id="response"></p>
    </div>
    <div id="message"></div>
    <table id="tb" class="altrowstable">
        <th align="center" colspan="9">实时信息监控</th>
    </table>
</div>
</body>
</html>