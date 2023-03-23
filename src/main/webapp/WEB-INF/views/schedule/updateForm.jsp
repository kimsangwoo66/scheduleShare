<%--
  Created by IntelliJ IDEA.
  User: gimsang-u
  Date: 2023/02/24
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>

<div class="card justify-content-center text-center m-1">
        <br/>
    <div class="card-body">
        <h2>스케줄 작성</h2>
        <div class="image-container">
            <div class="insert-img">
                <form onsubmit="return submitForm();" id="imgform">
                    <label class="input-file-button" for="file">사진 추가</label>
                    <input type="file" id="file" name="file" onchange="addFile(this);" multiple  style="display: none;"/>
                    <div class="file-list">

                       <c:forEach var="sphoto" items="${schedule.schedulePhotos}" varStatus="loop">
                          <div id="file${loop.index}" class="filebox" value="${sphoto.originFileName}">
                             <input id="filePath${loop.index}" hidden value="${sphoto.physicalPath}"" style="display:none;">
                             <p>${sphoto.originFileName}</p>
                             <a class="delete" onclick="deleteFile(${loop.index});">
                                <i class="far fa-minus-square" aria-hidden="true"></i>
                             </a>
                          </div>
                       </c:forEach>


                    </div>
                </form>
        </div>

        <br/>


        <div class="container">


            <form>
            <input type="hidden" id="schedule_id" name="schedule_id" value="${schedule.schedule_id}" hidden>
            <div class="col-1"><span class="rounded-lg border border-primary text-left"><input type="text" hidden id="category" value="${schedule.category.category_id}"/>${schedule.category.name}
            </span></div>

             <div></div>

                        <br/>
                  <div class="form-group col-6">
                    <input type="username" class="form-control"  id="title" value="${schedule.title}">
                  </div>

                  <div class="form-group col-6">
                    <textarea rows="5" id="content"  style="width: 100%;">${schedule.content}</textarea>
                  </div>

                 <div class="form-group col-8">
                    <label>소요시간</label>
                    <input type="number" name="timeCost" id="timeCost" value="${schedule.timeCost}">
                    <br/>
                    <label>총비용</label>
                    <input type="number" name="moneyCost" id="moneyCost" value="${schedule.moneyCost}">
                 </div>
            </form>
                <div class="container text-right">

                    <button onclick="submitForm()" id="sbtn-save" class="my-button text-center">수정 완료</button>

                </div>
        </div>
    </div>


<script src="/js/scheduleUpdate.js"></script>
<%@ include file="../layout/footer.jsp" %>