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

        <form>
			<div>
			    <!-- 이메일 입력창 -->
                <span>이메일</span>
                <br>
                <input type="email" name="email" id="email">
                <p id="valid_email"></p>


                <!-- 비밀번호 입력창 -->
                <span>비밀번호</span>
                <br>
                <input type="password" id="password" name="password" class="jpw1" placeholder="비밀번호를 입력해주세요.">
                <br>
                <br>
                <span>비밀번호 확인</span>

                <br>
                <input type="password" id="pwcheck" name="pwcheck" class="jpw2" placeholder="비밀번호 확인">
                 <p id="valid_password"></p>

				<!-- 닉네임 입력창 -->
                <span>닉네임</span>
                <br>
                <input type="text" name="username" id="username" placeholder="별명 (2~15자)">
				<p id="valid_username"></p>

				<!-- 성별 입력  -->
                <span>성별</span>
                <br>
                <input type="radio" id="gender" name="gender" value=1 checked><span>남자</span>
                &nbsp; &nbsp; &nbsp; &nbsp;
                <input type="radio" id="gender" name="gender" value=2><span>여자</span>
				<p id="valid_gender"></p>
			</div>
        </form>

        <div>
        <button id="joinbtn">가입 완료</button> <!-- 가입하기 버튼 -->
        </div>
    <span>이미 아이디가 있으신가요?</span>
    &nbsp; &nbsp; &nbsp; &nbsp;
    <a href="https://www.w3schools.com">로그인</a>
    </div>
    </div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>