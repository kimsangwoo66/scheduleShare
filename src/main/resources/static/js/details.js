$(document).ready(function () {

  // 스케줄 상세 이미지 js
  $(".image-container").slick({
    dots: true,

  });
});

function hClick() {
  var element = document.getElementById("heart");
  heartname = element.className;
  console.log(element.className);

  var csrfToken = $("meta[name='_csrf']").attr("content");
  var csrfHeader = $("meta[name='_csrf_header']").attr("content");

  let data = {
              schedule_id : parseInt($("#schedule_id").val())

             };
  console.log(JSON.stringify(data));

  //빈 하트일 경우
  if (heartname === "far fa-heart") {
    //클래스 이름 변경

       $.ajax({
              type:"POST",
              url:"/api/likecnt",
              data:data,
              /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
              beforeSend: function(xhr) {
                           if(csrfToken && csrfHeader){
                               xhr.setRequestHeader(csrfHeader, csrfToken);
                           }

                      },
              success: function(data) {
                          // AJAX 요청이 성공했을 때 실행할 코드
                          //좋아요 추가 성공
                         console.log("좋아요 추가")

                         //채워진 하트로 변경
                         element.className = "fa fa-heart";
                      },
              error: function(jqXHR, textStatus, errorThrown) {
                    console.log("실패");
                    console.log(jqXHR);
                    console.log(textStatus);
                    console.log(errorThrown);


                    document.location.href = "/auth/login";


              }

       });


  }

  //채워진 하트일 경우
  else {
    $.ajax({
              type:"POST",
              url:"/api/likecnt",
              data:data,
              /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
              beforeSend: function(xhr) {
                           if(csrfToken && csrfHeader){
                               xhr.setRequestHeader(csrfHeader, csrfToken);
                           }

                      },
              success: function(data) {
                          // AJAX 요청이 성공했을 때 실행할 코드
                          //좋아요 감소 성공
                         console.log("좋아요 감소 성공")
                         //채워진 하트로 변경
                         element.className = "far fa-heart";
                      },
              error: function(jqXHR, textStatus, errorThrown) {
                    console.log("실패");
                    console.log(jqXHR);
                    console.log(textStatus);
                    console.log(errorThrown);
                    // AJAX 요청이 실패했을 때 실행할 코드
                    alert("로그인이 필요합니다.");
                     document.location.href = "/auth/login";


              }

           });

    element.className = "far fa-heart";
  }


}

function btnDelete(value){
    console.log("id:" + value);

    $.ajax({
               type:"DELETE",
               url:"/api/schedule/"+value,
               dataType:"json"

           }).done(function(resp){
                alert("삭제가 완료되었습니다.");
                location.href="/";
           }).fail(function(error){
                //회원가입에 실패하면 실행하는 함수
                alert(JSON.stringify(error));

           });
}