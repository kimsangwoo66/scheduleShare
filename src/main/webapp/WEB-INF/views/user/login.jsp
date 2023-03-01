<%--
  Created by IntelliJ IDEA.
  User: gimsang-u
  Date: 2023/02/25
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<div class="row justify-content-around">

        <div class="card" style="width:400px">
            <div class="card-body">
                <div class="logo-back"> 로고 </div>
                <br>

                <form action="/auth/loginProc" method="post">
                    <h4 class="card-title">로그인</h4>
                    <div id="form-group"> <!-- 이메일 입력창 -->
                        <input type="email" name="email" id="email" placeholder="이메일을 입력하세요." required="required" class="form-control w-75">
                    </div>
                    <br>

                    <div id="form-group"> <!-- 비밀번호 입력창 -->
                        <input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요." required="required" class="form-control w-75">
                    </div>
                    <br>

                    <div> <!-- 로그인 버튼 -->
                        <button>로그인</button>
                    </div>
                </form>

                <div id="joinbt" > <!-- 회원가입 이동 버튼 -->
                    <button id="joinbtn" onclick="location.href='join'">회원가입</button>
                </div>
                <br>

            </div>
        </div>
</div>

<%@ include file="../layout/footer.jsp" %>