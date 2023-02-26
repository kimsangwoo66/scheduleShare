
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>

    <br/>
    <div class="card justify-content-center text-center m-1">
        <br/>

    <div class="card-body">
        <h2>스케줄 상세</h2>
        <div class="image-container row m-3">
            <img style="width:100px; height:100px;" src="testimg.png" class="col"></img>
            <img style="width:100px; height:100px;" src="testimg.png" class="col"></img>
            <img style="width:100px; height:100px;" src="testimg.png" class="col"></img>


        </div>

        <br/>


        <div class="container">
            <div class="col-1"><span class="rounded-lg border border-primary text-left">카테고리</span></div>
            <br/>
            <form>
                  <div class="form-group col-6">
                    <input type="username" class="form-control" placeholder="제목을 입력하세요" id="title">
                  </div>

                  <div class="form-group col-6">
                    <textarea rows="5" id="content" placeholder="내용을 입력하세요" style="width: 100%;"></textarea>
                  </div>


                  <div class="form-check col-1">
                      <label class="form-check-label"></label>
                      <span><input class="form-check-input" type="checkbox">종일</span>
                      </label>
                  </div>

                  <!-- <div class="form-group col-8">
                    <label>시작</label>&nbsp;&nbsp;&nbsp;<input type="datetime-local" name="startTime" id="startTime">
                    <br/>
                    <label>종료</label>&nbsp;&nbsp;&nbsp;<input type="datetime-local" name="endTime" id="endTime">
                 </div> -->

                 <div class="form-group col-8">
                    <label>소요시간</label>
                    <input type="text" name="timeCost">
                    <br/>
                    <label>총비용</label>
                    <input type="text" name="moneyCost">
                 </div>


            </form>
                <div class="container text-right">
                    <button class="my-button text-center" onclick="check()">뒤로</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;

                    <button class="h_container" onclick="hClick()">
                        <i id="heart" class="far fa-heart"></i>
                  </button>
                </div>
        </div>
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


    <script src="src/main/webapp/js/details.js"></script>


<%@ include file="../layout/footer.jsp" %>