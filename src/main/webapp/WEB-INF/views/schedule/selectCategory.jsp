
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>

<form id="frm">
    <input type="hidden" value="" name="name" id="name">
    <div class="card justify-content-center text-center m-1">
        <br/>

            <div class="card-body">
                <h2>일정 카테고리를 선택해주세요</h2>
                <c:forEach items="${category}" var="cate">
                    <div class="card-detail">
                        <div class="col-sm"><a href="#" onclick="fn_goView(${cate.name})">
                            <button id="category_id" >
                                <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                <h4>${cate.name}</h4>
                            </button>

                        </a></div>
                    </div>
                </c:forEach>
            </div>

        <br/>
</form>

            <div class="container text-right">
                <button class="my-button text-center" onclick="location.href='/schedules'">다음</button>
<%--                <button class="my-button text-center" onclick="click()">다음</button> --%>
                &nbsp;&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </div>
    <br/>
    <br/>


<script src="/js/category.js"></script>
<%@ include file="../layout/footer.jsp" %>
