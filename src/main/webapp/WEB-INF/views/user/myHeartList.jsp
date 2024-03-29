<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>



<div class="d-flex flex-row ml-3">전체: ${userLikes.totalElements}</div>
<div class="row">
        <c:forEach var="userLike" items="${userLikes.content}">
            <div class="card" onclick="location.href='/details/${userLike.schedule.schedule_id}'" style="width:300px;height:fit-content;color: royalblue;justify-content: space-around;align-items: center;margin: 30px;cursor: pointer;">
                <!--사용자가 가장 먼저 업로드 한 이미지를 대표사진으로 출력-->
                <div class = "embed-responsive embed-responsive-4by3">
                <img src="<c:url value='/img/${userLike.schedule.schedulePhotos[0].fileName}'/>" class="card-img-top embed-responsive-item rounded">
                </div>
                <div class="card-body">
                    <h4 class="card-title">${userLike.schedule.title}</h4>
                            <span class="rounded-lg border border-primary">${userLike.schedule.category.name}</span>
                            <span class="rounded-lg border border-primary">${userLike.schedule.timeCost}시간</span>
                            <span class="rounded-lg border border-primary">${userLike.schedule.moneyCost}원</span>
                            <br/>
                            <br/>
                            <i class="fas fa-heart"></i>&nbsp;${userLike.schedule.likeCount}
                </div>
            </div>
        </c:forEach>
</div>

    <!-- 페이징 처리 -->
    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${userLikes.first}">
                <li class="page-item disabled"><a class="page-link" href="?page=${userLikes.number-1}">이전</a></li>
            </c:when>

            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${userLikes.number-1}">이전</a></li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${userLikes.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${userLikes.number+1}">다음</a></li>
            </c:when>

            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${userLikes.number+1}">다음</a></li>
            </c:otherwise>
        </c:choose>
    </ul>

    <br/>
    <br/>


<script type="text/javascript" src="/js/main.js"></script>
<%@ include file="../layout/footer.jsp" %>