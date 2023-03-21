<%--
  Created by IntelliJ IDEA.
  User: gimsang-u
  Date: 2023/02/24
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout/header.jsp" %>



<div class="d-flex flex-row ml-3">전체: ${schedules.totalElements}</div>
<div class="row">
        <c:forEach var="schedule" items="${schedules.content}">
            <div class="card" onclick="location.href='/details/${schedule.schedule_id}'" style="width:300px;height:fit-content;color: royalblue;justify-content: space-around;align-items: center;margin: 30px;cursor: pointer;">
                <!--사용자가 가장 먼저 업로드 한 이미지를 대표사진으로 출력-->
                <div class = "embed-responsive embed-responsive-4by3">
                <img src="<c:url value='/img/${schedule.schedulePhotos[0].fileName}'/>" class="card-img-top embed-responsive-item rounded">
                </div>
                <div class="card-body">
                    <h4 class="card-title">${schedule.title}</h4>
                            <span class="rounded-lg border border-primary">${schedule.category.name}</span>
                            <span class="rounded-lg border border-primary">${schedule.timeCost}시간</span>
                            <span class="rounded-lg border border-primary">${schedule.moneyCost}원</span>
                            <br/>
                            <br/>
                            <i class="fas fa-heart"></i>&nbsp;${schedule.likeCount}
                </div>
            </div>
        </c:forEach>
</div>

    <!-- 페이징 처리 -->
    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${schedules.first}">
                <li class="page-item disabled"><a class="page-link" href="?page=${schedules.number-1}">이전</a></li>
            </c:when>

            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${schedules.number-1}">이전</a></li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${schedules.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${schedules.number+1}">다음</a></li>
            </c:when>

            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${schedules.number+1}">다음</a></li>
            </c:otherwise>
        </c:choose>
    </ul>

    <br/>
    <br/>


<script type="text/javascript" src="/js/main.js"></script>
<%@ include file="layout/footer.jsp" %>