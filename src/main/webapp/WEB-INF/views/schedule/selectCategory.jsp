
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>


    <input type="hidden" value="" name="name" id="name">
    <div class="card justify-content-center text-center m-1">
        <br/>

            <div class="card-body">
                <h2>일정 카테고리를 선택해주세요</h2>
                    <div class="card-detail">
                        <div class="col-sm">
                            <button id="category_id">
                                <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                <h4>${category[0].name}</h4>
                            </button>

                            <button>
                                <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                <h4>${category[1].name}</h4>
                            </button>


                            <div class="col-sm">
                                <button id="category_id">
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[2].name}</h4>
                                </button>

                                <button>
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[3].name}</h4>
                                </button>
                            </div>
                            <div class="col-sm">
                                <button>
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[4].name}</h4>
                                </button>

                                <button>
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[5].name}</h4>
                                </button>
                            </div>

                            <div class="col-sm">
                                <button>
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[5].name}</h4>
                                </button>

                                <button>
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[7].name}</h4>
                                </button>
                            </div>

                            <div class="col-sm">
                                <button>
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[8].name}</h4>
                                </button>

                                <button>
                                    <img style="width:250px; height:200px;" src="testimg.png" class="col"></img>
                                    <h4>${category[9].name}</h4>
                                </button>
                            </div>


                    </div>
            </div>

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
