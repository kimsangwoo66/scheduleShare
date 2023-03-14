<%--
  Created by IntelliJ IDEA.
  User: gimsang-u
  Date: 2023/02/24
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout/header.jsp" %>




<div class="myslick justify-content-around">
        <c:forEach var="schedule" items="${schedules.content}">
            <div class="card" style="width:300px;height:fit-content;color: royalblue;justify-content: space-around;align-items: center;margin: 30px;">
                <!--사용자가 가장 먼저 업로드 한 이미지를 대표사진으로 출력-->
                <img src="<c:url value='/img/${schedule.schedulePhotos[0].fileName}'/>" class="card-img-top rounded" width="50%" height="50%">

                <div class="card-body">
                    <h4 class="card-title">${schedule.title}</h4>
                            <span class="rounded-lg border border-primary">${schedule.category.name}</span>
                            <span class="rounded-lg border border-primary">${schedule.timeCost}</span>
                            <span class="rounded-lg border border-primary">${schedule.moneyCost}</span>
                            <br/>
                            <br/>
                    <a href="#" class="btn btn-primary"><i class="fas fa-heart"></i></a>[숫자]
                </div>
            </div>

        </c:forEach>

</div>

    <br/>
    <br/>

    <div class="container text-right">
        <button class="my-button text-center" onclick="location.href='/category'">+ 내 스케줄 등록</button>
    </div>

<script src="/js/slick.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<%@ include file="layout/footer.jsp" %>