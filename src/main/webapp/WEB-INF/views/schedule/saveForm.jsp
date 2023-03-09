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
                <form method="POST" onsubmit="return submitForm();" enctype="multipart/form-data" id="imgform">
                    <label class="input-file-button" for="file">사진 추가</label>
                    <input type="file" id="file" onchange="addFile(this);" multiple  style="display: none;"/>
                    <div class="file-list"></div>
                </form>
        </div>

        <br/>


        <div class="container">

            <form>
            <div class="col-1"><span class="rounded-lg border border-primary text-left"><input hidden id="category" value="1">카테고리</span></div>
                        <br/>

                  <div class="form-group col-6">
                    <input type="username" class="form-control" placeholder="제목을 입력하세요" id="title">
                  </div>

                  <div class="form-group col-6">
                    <textarea rows="5" id="content" placeholder="내용을 입력하세요" style="width: 100%;"></textarea>
                  </div>


                  <!-- <div class="form-group col-8">
                    <label>시작</label>&nbsp;&nbsp;&nbsp;<input type="datetime-local" name="startTime" id="startTime">
                    <br/>
                    <label>종료</label>&nbsp;&nbsp;&nbsp;<input type="datetime-local" name="endTime" id="endTime">
                 </div> -->

                 <div class="form-group col-8">
                    <label>소요시간</label>
                    <input type="text" name="timeCost" id="timeCost">
                    <br/>
                    <label>총비용</label>
                    <input type="text" name="moneyCost" id="moneyCost">
                 </div>
            </form>
                <div class="container text-right">
                    <button onclick="submitForm()" id="sbtn-save" class="my-button text-center">등록 완료</button>
                </div>
        </div>
    </div>


<script src="/js/schedule.js"></script>
<%@ include file="../layout/footer.jsp" %>