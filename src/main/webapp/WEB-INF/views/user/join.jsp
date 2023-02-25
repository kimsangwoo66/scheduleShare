<%--
  Created by IntelliJ IDEA.
  User: gimsang-u
  Date: 2023/02/25
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<div class="row justify-content-around">

        <div class="card" style="width:400px">
            <div class="card-body">
            <h4 class="card-title">회원가입</h4>
        </div>
        <form action="./join" method="post" onsubmit="return join()">
			<div id="joinaction">
				<p id="joinid" class="joinus"> <!-- 아이디 입력창 -->
					<span class="joinM">이메일</span>
                    <br>
					<input type="text" name="id" id="id" onchange="checkID()">
				</p>
				<p id="joinpassword" class="joinus"> <!-- 비밀번호 입력창 -->
					<span class="joinM">비밀번호</span>
                    <br>
                    <span class="joinM">영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요</span>
					<input type="password" id="pw1" name="pw1" class="jpw1" placeholder="비밀번호를 입력해주세요.">
                    <br>
                    <br>
                    <span id="joinM">비밀번호 확인</span>
                    <br>
                    <input type="password" id="pw2" name="pw2" class="jpw2" placeholder="비밀번호 확인" onchange="Same()">
				</p>
				<p id="joinemail" class="joinus"> <!-- 이메일 입력창 -->
					<span class="joinM">닉네임</span>
                    <br>
					<input type="email" name="email" id="email" placeholder="별명 (2~15자)">
				</p>
				<p id="joinbirth" class="joinus"> <!-- 생년월일 입력창 -->
					<span class="joinM">성별</span>
                    <br>
                    <input type="radio" id="css" name="fav_language" value="CSS"> <span>남자</span>
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    <input type="radio" id="css" name="fav_language" value="CSS"><span>여자</span>
				</p>
			</div>
			<div id="joinIA">
					<button type="submit" id="joinbtn">가입 완료</button> <!-- 가입하기 버튼 -->
			</div>
            <span>이미 아이디가 있으신가요?</span>
            &nbsp; &nbsp; &nbsp; &nbsp;
            <a href="https://www.w3schools.com">로그인</a>
        </form>
    </div>
    </div>

<%@ include file="../layout/footer.jsp" %>