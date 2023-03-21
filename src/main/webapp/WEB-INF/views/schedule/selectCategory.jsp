
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<style type="text/css">
button{
border:none; background-color:white; padding:10px;
}
h4{
padding:10px;
}
</style>

    <div class="card justify-content-center text-center m-1">
        <br/>

            <div class="card-body">
                <h2>보고싶은 카테고리를 선택해 주세요</h2>
                <br>
                    <div class="card-detail">
                        <div class="col-sm" >


                            <button  id="cate" name="cate" value="${category[0].category_id}" onclick="cateBtn(value)">
                                <img style="width:300px; height:200px;" src="/images/class.jpeg" class="col"></img>
                                <h4>${category[0].name}</h4>
                            </button>


                            <button  id="cate" name="cate" value="${category[1].category_id}" onclick="cateBtn(value)">
                                <img style="width:300px; height:200px;" src="/images/teamproject.jpeg" class="col"></img>
                                <h4>${category[1].name}</h4>
                            </button>


                            <button  id="cate" name="cate" value="${category[2].category_id}" onclick="cateBtn(value)">
                                    <img style="width:300px; height:200px;" src="/images/meal.jpeg" class="col"></img>
                                    <h4>${category[2].name}</h4>
                                </button>
                        </div>

                            <div class="col-sm">


                            <button  id="cate" name="cate" value="${category[3].category_id}" onclick="cateBtn(value)">
                                    <img style="width:300px; height:200px;" src="./images/drinks.jpeg" class="col"></img>
                                    <h4>${category[3].name}</h4>
                                </button>


                            <button  id="cate" name="cate" value="${category[4].category_id}" onclick="cateBtn(value)">
                                    <img style="width:300px; height:200px;" src="./images/work.jpeg" class="col"></img>
                                    <h4>${category[4].name}</h4>
                                </button>


                            <button  id="cate" name="cate" value="${category[5].category_id}" onclick="cateBtn(value)">
                                    <img style="width:300px; height:200px;" src="./images/date.jpeg" class="col"></img>
                                    <h4>${category[5].name}</h4>

                                </button>
                            </div>

                            <div class="col-sm">


                            <button  id="cate" name="cate" value="${category[6].category_id}" onclick="cateBtn(value)">
                                    <img style="width:300px; height:200px;" src="./images/study.jpeg" class="col"></img>
                                    <h4>${category[6].name}</h4>
                                </button>


                            <button  id="cate" name="cate" value="${category[7].category_id}" onclick="cateBtn(value)">
                                    <img style="width:300px; height:200px;" src="./images/meetup.jpeg" class="col"></img>
                                    <h4>${category[7].name}</h4>
                                </button>


                            <button  id="cate" name="cate" value="${category[8].category_id}" onclick="cateBtn(value)">
                                    <img style="width:300px; height:200px;" src="./images/exercise.jpeg" class="col"></img>
                                    <h4>${category[8].name}</h4>
                                </button>
                            </div>

                            <div class="col-sm">



                            <button  id="cate" name="cate" value="${category[9].category_id}" onclick="cateBtn(value)">
                                    <img style="width:300px; height:200px;" src="./images/travel.jpeg" class="col"></img>
                                    <h4>${category[9].name}</h4>
                                </button>
                            </div>

                    </div>
            </div>

        <br/>

                &nbsp;&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </div>
    <br/>
    <br/>


<script type="text/javascript" src="/js/selectCategory.js"></script>
<%@ include file="../layout/footer.jsp" %>
