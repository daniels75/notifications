<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <script src="http://cdn.sockjs.org/sockjs-0.3.4.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.1/stomp.js"></script>
    <script type="text/javascript">
        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
        	// This should be a part of configuration to point to exact service URL (for IE9 support)
        	// var socket = new SockJS('http://localhost:8080/notifications/hello');
            var socket = new SockJS('/notifications/hello');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function(greeting){
                	console.log(greeting);
                    showGreeting(JSON.parse(greeting.body).content);
                });
            });
        }

        function disconnect() {
            stompClient.disconnect();
            setConnected(false);
            console.log("Disconnected");
        }

        function sendName() {
            var name = document.getElementById('name').value;
            stompClient.send("/app/hello", {}, JSON.stringify({ 'name': name, 'content':'Lorem ipsum','url':'www.wp.pl','user':'Adam' }));

        }

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
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <label>Enter message after connected</label><input type="text" id="name" />
        <button id="sendName" onclick="sendName();">Send</button>
        <label>Results</label>
        <p id="response"></p>
    </div>
</div>
</body>
</html>