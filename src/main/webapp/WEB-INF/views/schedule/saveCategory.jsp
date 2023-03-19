
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>


    <div class="card justify-content-center text-center m-1">
        <br/>
          <form id="cateForm" name="cateForm" accept-charset="utf-8">
            <div class="card-body">
                <h2>일정 카테고리를 선택해주세요</h2>
                    <div class="card-detail">
                        <div class="col-sm">

                            <input type="hidden" id="cateId" name="cateId" value="${category[0].category_id}" hidden>
                            <button type="submit" id="cateName" name="cateName" value="${category[0].name}" onclick="cateBtn(value)">

                                <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                <h4>${category[0].name}</h4>
                            </button>


                            <button type="submit" id="cate" name="cate" value="${category[1].name}" onclick="cateBtn(value)">
                                <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                <h4>${category[1].name}</h4>
                            </button>
                        </div>

                            <div class="col-sm">

                            <button type="submit" id="cate" name="cate" value="${category[2].name}" onclick="cateBtn(value)">
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[2].name}</h4>
                                </button>

                            <button type="submit" id="cate" name="cate" value="${category[3].name}" onclick="cateBtn(value)">
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[3].name}</h4>
                                </button>
                            </div>
                            <div class="col-sm">
                            <button type="submit" id="cate" name="cate" value="${category[4].name}" onclick="cateBtn(value)">
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[4].name}</h4>
                                </button>

                            <button type="submit" id="cate" name="cate" value="${category[5].name}" onclick="cateBtn(value)">
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[5].name}</h4>

                                </button>
                            </div>

                            <div class="col-sm">

                                <button type="submit" id="cate" name="cate" value="${category[6].name}" onclick="cateBtn(value)">

                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[6].name}</h4>
                                </button>

                                <button type="submit" id="cate" name="cate" value="${category[7].name}" onclick="cateBtn(value)">
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[7].name}</h4>
                                </button>
                            </div>

                            <div class="col-sm">

                                <button type="submit" id="cate" name="cate" value="${category[8].name}" onclick="cateBtn(value)">
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[8].name}</h4>
                                </button>


                            <button id="cate" name="cate" value="${category[9].name}" onclick="cateBtn(value)">
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[9].name}</h4>
                                </button>
                            </div>

                    </div>
            </div>
          </form>
        <br/>


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
