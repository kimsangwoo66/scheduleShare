<%--
  Created by IntelliJ IDEA.
  User: gimsang-u
  Date: 2023/02/24
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--spring security 승인태그 , 세션으로 저장된 로그인 객체가 principal이름으로 저장, var="principal" 이 userDetail-->
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script src="https://kit.fontawesome.com/3929e16ef5.js" crossorigin="anonymous"></script>


     <style>
        .my-button {
                width: 100px;
                height: 100px;
                border: none;
                border-radius: 100px;
                outline: none;
                background: #0c0fdd;
                color: white;
                cursor: pointer;
                box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
              }

        .my-button:hover {
        background: #2c4ba3;
        }

        .h_container{
        width: 100px;
        height: 100px;
        background-color: #f7f7f7;
        border-radius: 100px;
        box-shadow: 0 2px 8px rgba(0,0,0,.1);
        display: inline;

        }

        #heart{
        font-size: 30px;
        }

        #heart:hover{
        color:red;
        }

        .hclicked{
        color: red;
        }




        .insert-img {

            background: #fff;
            border: 1px solid rgb(77,77,77);

            align-items: center;
            justify-content: center;
            margin-left:150px;
            margin-right:150px;


        }


        .insert-img .file-list {
            height: 100px;

            overflow: auto;
            border: 1px solid #989898;
            padding: 10px;
        }

        .insert-img .file-list .filebox p {
            font-size: 14px;
            margin-top: 10px;
            display: inline-block;
        }

        .insert-img .file-list .filebox .delete i{
            color: #ff5353;
            margin-left: 5px;
        }

        #fileline {
        display: none;
        }


        .input-file-button{
            width: 150px;
            height: 30px;
            background: #fff;
            border: 1px solid rgb(77,77,77);
            border-radius: 10px;
            font-weight: 500;
            cursor: pointer;
            align-items: center;
            justify-content: center;
        }


        .logo-back {
        background-color: yellow; padding:10px;
        }
        <!-- myPage사용 -->
        .btn-upload {
                width: 150px;
                height: 30px;
                background: #fff;
                border: 1px solid rgb(77,77,77);
                border-radius: 10px;
                font-weight: 500;
                cursor: pointer;
                display: flex;
                align-items: center;
                justify-content: center;

        }
     </style>
</head>


<body>

    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>주말에 이런 스케줄은 어떠세요?</h1>

    </div>

<!-- A grey horizontal navbar that becomes vertical on small screens -->
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="/">로고</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <c:choose>
                    <c:when test="${empty principal}">
                          <!--로그인 안한 상태일 경우 나오는 nav bar-->
                          <div class="col-8">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/">홈</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">카테고리</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/selectCategory">스케줄 생성</a>
                                    </li>
                                </ul>
                          </div>

                          <div class="col-4">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/myHeartList">
                                        <i class="fas fa-heart"></i>스케줄함</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/myList">마이스케줄함</a>
                                    </li>

                                    <li class="nav-item">
                                        <a class="nav-link" href="/auth/login">로그인</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/auth/join">회원가입</a>
                                    </li>
                                </ul>
                          </div>

                    </c:when>
                        <c:otherwise>
                            <!--로그인한 상태일 경우 나오는 nav bar-->
                            <div class="col-8">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/">홈</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">카테고리</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/selectCategory">스케줄 생성</a>
                                    </li>

                                </ul>
                            </div>

                            <div class="col-4">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/myHeartList">
                                        <i class="fas fa-heart"></i>스케줄함</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/myList"></i>마이스케줄함</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/myPage">마이페이지</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/logout">로그아웃</a>
                                    </li>
                                </ul>

                            </div>

                        </c:otherwise>
            </c:choose>

    </nav>

    <div>
        <br/>
        <br/>
    </div>
