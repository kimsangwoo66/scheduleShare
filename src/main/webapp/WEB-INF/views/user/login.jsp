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

            <h4 class="card-title">로그인</h4>
            <div id="idin"> <!-- 아이디 입력창 -->
                <input type="text" name="id" id="id" placeholder="아이디를 입력하세요." required="required">
            </div>
            <br>
            <div id="pwin"> <!-- 비밀번호 입력창 -->
                <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요." required="required">
            </div>
            <br>
                <div id="loginbt" > <!-- 로그인 버튼 -->
                    <button id="loginbtn">
                        <!-- <img alt="login" src="./img/login1.png" style="vertical-align: text-bottom;"> -->
                    로그인</button>
                </div>
                <br>
                </div>
        </div>



    </div>

<%@ include file="../layout/footer.jsp" %>