
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>

        <div class="card justify-content-center text-center m-1">

           <c:if test="${schedule.user.user_id == principal.user.user_id}">
                <span class="d-flex flex-row ml-5">
               <a href="/schedules/${schedule.schedule_id}" class="btn btn-warning">수정</a>
               <button id="btn-delete" class="btn btn-danger ml-3" value="${schedule.schedule_id}" onclick="btnDelete(value)">삭제</button>
               </span>
           </c:if>
        <div class="card-body row">

            <div class="container col-6">


                <section>
                      <div>

                        <input type="hidden" id="schedule_id" value="${schedule.schedule_id}"/>
                        <input type="hidden" id="user_id" value="${schedule.user.user_id}"/>
                        <h3>${schedule.title}<h3/>
                      </div>

                      <br/>

                      <div>
                        <textarea rows="5" id="content" style="width: 100%;" readonly>${schedule.content}</textarea>
                      </div>


                        <div class="d-flex flex-row-reverse"><span class="rounded border border-primary text-left" style="font-size: medium;">${schedule.category.name}</span></div>

                        <div class="d-flex flex-row-reverse">
                        <input type="text" name="timeCost" value="${schedule.timeCost}" readonly>
                        <label>소요시간&nbsp;</label>
                        </div>
                        <br/>

                        <div class="d-flex flex-row-reverse">
                        <input type="text" name="moneyCost" value="${schedule.moneyCost}" readonly>
                        <label>총비용&nbsp;</label>
                        </div>

                </section>
            </div>
            <style>
                .slick-arrow {
                        z-index: 10;
                        width: 50px;
                        height: 50px;
                        background: rgba(0,0,0, 0.2);
                        border-radius: 50%;

                        }

                .slick-prev {
                    left: 50px;

                }

                .slick-next {
                    right: 50px;
                }

            </style>

            <div class="image-container col-6">
               <c:forEach var="photo" items="${schedule.schedulePhotos}">
                   <img style="width: fit-content; height: fit-content;" src="<c:url value='/img/${photo.fileName}'/>" class="col"></img>
               </c:forEach>
            </div>

        </div>

        <div class="container text-center">
            <button class="my-button text-center" onclick="history.back();">뒤로</button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button class="h_container" onclick="hClick()">

                <c:choose>
                      <c:when test="${empty userlike}">
                        <i id="heart" class="far fa-heart"></i>
                      </c:when>
                       <c:otherwise>
                        <i id="heart" class="fa fa-heart"></i>
                       </c:otherwise>
                </c:choose>

          </button>
        </div>

            <!---->
            </div>
          </div>

        <br/>
        <br/>




        <div>
            <br/>
            <br/>
        </div>

<script src="/js/slick.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script type="text/javascript" src="/js/details.js"></script>
<%@ include file="../layout/footer.jsp" %>