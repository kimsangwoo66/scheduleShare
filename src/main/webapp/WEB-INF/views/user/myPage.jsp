
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>

        <div class="card justify-content-center m-3">
            <h2 class="m-3">내 정보 </h2>
            <div class="card-body m-2">
                <div>
                    <!--어떤 user의 정보인지 userid값으로 확인하기 위해 hidden으로 id값을 서버에 가져옴-->
                    <div class="form-group">
                        <input type="hidden" id="user_id" value="${principal.user.user_id}"/>
                        <div class="row">
                            <div class="row-cols-sm-1">
                                <div for="email">이메일</div>
                            </div>
                            <div class="col-sm-4">
                                <input type="email" class="form-control" value="${principal.user.email}" id="email" readonly>
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="row-cols-sm-1">
                                <div for="username">닉네임</div>
                            </div>
                            <div class="col-sm-2">
                                <input type="username" class="form-control" id="username" value="${principal.user.username}" readonly>
                            </div>
                        </div>

                        <br/>
                        <div class="row">
                            <div style="padding-right: 15px;">성별</div>
                            <c:choose>
                                    <c:when test="${principal.user.gender == 1}">
                                        <input type="radio" id="gender" name="gender" value=1 checked onclick="return(false);"><span>남자</span>
                                                        &nbsp; &nbsp; &nbsp; &nbsp;
                                        <input type="radio" id="gender" name="gender" value=2 onclick="return(false);"><span>여자</span>
                                    </c:when>
                                        <c:otherwise>
                                            <input type="radio" id="gender" name="gender" value=1 onclick="return(false);"><span>남자</span>
                                                            &nbsp; &nbsp; &nbsp; &nbsp;
                                            <input type="radio" id="gender" name="gender" value=2 checked onclick="return(false);"><span>여자</span>
                                        </c:otherwise>
                           </c:choose>
                        </div>

                        <br/><br/>
                        <div class="img">
                        		<div class="title_image">
                        			<c:choose>
                        				<c:when test="${profile.fileName == null}">
                        					<img src="/images/noimage.png" class="img-thumbnail rounded" width="50%" height="50%">
                        				</c:when>
                        				<c:otherwise>
                        					<img src="<c:url value='/img/${profile.fileName}'/>" id="image-preview" class="img-thumbnail rounded" width="50%" height="50%">
                        				</c:otherwise>
                        			</c:choose>
                        		</div>

                        </div>
                        <div>
                                <form action="/user/image" method="POST" id="form" name="form" enctype="multipart/form-data" autocomplete="off">
                                    <label class="input-file-button text-center" for="fileline">이미지 변경</label>
                                    <input type="file" id="fileline" name="fileline"/>
                                    <div/>
                                    <button type="submit" class="btn btn-primary">수정적용</button>
                                </form>

                        </div>

                    </div>

                </div>
            </div>
         </div>
    <br/>
    <br/>


    <div>
        <br/>
        <br/>
    </div>


<script src="/js/myPage.js"></script>

</div>
<%@ include file="../layout/footer.jsp" %>