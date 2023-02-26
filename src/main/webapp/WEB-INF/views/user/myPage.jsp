
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>

        <div class="card justify-content-center m-3">
            <h2 class="m-3">내 정보 </h2>
            <div class="card-body m-2">
                <form action="/action_page.php">
                    <div class="form-group">

                        <div class="row">
                            <div class="row-cols-sm-1">
                                <div for="email">이메일</div>
                            </div>
                            <div class="col-sm-4">
                                <input type="email" class="form-control" id="email" value="mm@naver.com">
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="row-cols-sm-1">
                                <div for="username">이름</div>
                            </div>
                            <div class="col-sm-2">
                                <input type="username" class="form-control" id="username" value="김땡떙">
                            </div>
                        </div>

                        <br/>
                        <div class="row">

                            <div style="padding-right: 15px;">성별</div>
                            <div class="form-check mb-2 mr-sm-2">

                                <label class="form-check-label">
                                <span><input class="form-check-input" type="checkbox">남자</span>
                                </label>

                            </div>

                            <div class="form-check mb-2 mr-sm-2">
                                <label class="form-check-label">
                                <span><input class="form-check-input" type="checkbox">여자</span>
                                </label>
                            </div>
                        </div>
                        <br/><br/>

                        <div class="image-container">
                            <label for="file"><div class="btn-upload">프로필 이미지 변경</div></label>
                            <input type="file" name="file" id="file">
                            <div><img style="width: 200px;" id="preview-image" src="/img/"></div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">수정적용</button>
                  </form>
            </div>
          </div>
    <br/>
    <br/>


    <div>
        <br/>
        <br/>
    </div>


<script src="src/main/webapp/js/myPage.js"></script>

</div>
<%@ include file="../layout/footer.jsp" %>