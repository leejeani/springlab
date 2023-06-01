<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    var timer = null;
    var isRunning = false;
    function startTimer(count, display) {

        var minutes, seconds;
        timer = setInterval(function () {
            minutes = parseInt(count / 60, 10);
            seconds = parseInt(count % 60, 10);

            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;

            display.html(minutes + ":" + seconds);

            // 타이머 끝
            if (--count < 0) {
                clearInterval(timer);
                alert("시간초과");
                display.html("시간초과, 인증요청을 다시 진행 하세요");
                //$('#auth_btn').attr("disabled","disabled");
                isRunning = false;
            }
        }, 1000);
        isRunning = true;
    }
    $(function(){
        $("#auth_btn").click(function(e){
            // 서버에 인증 메일 전송 이메일 전송 오청

            var display = $('#timer');
            var leftSec = 80;
            // 남은 시간
            // 이미 타이머가 작동중이면 중지
            if (isRunning){
                clearInterval(timer);
                display.html("");
                startTimer(leftSec, display);
            }else{
                startTimer(leftSec, display);

            }
        });
    });
</script>
<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Register OK</h3>
        <h3>${rcust.name} 님 환영 합니다.</h3>
        <h4>다음 인증 작업을 진행 하세요</h4>
        <button  id="auth_btn">인증요청버튼</button>
        <br>
        <h4>메일로 전송된 인증번호를 입력 하세요</h4>
        <input type="text" name="code">
        <button>인증</button>
        <p id="timer"></p>
    </div>
</div>
