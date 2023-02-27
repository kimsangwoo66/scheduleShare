let index = {

    init: function(){
        $("#joinbtn").on("click", ()=> {
            this.save();
        });

    },


    save: function(){

            let data = {
                email: $("#email").val(),
                password: $("#password").val(),
                username: $("#username").val(),
                gender: $("input:radio[name=gender]:checked").val()

            };

            var password = document.getElementById("password").value;  // 비밀번호 입력란 값 가져오기
            var pwcheck = document.getElementById("pwcheck").value;    // 비밀번호 확인 입력란 값 가져오기


            if (password !== pwcheck) {   // 비밀번호와 비밀번호 확인 값이 다를 경우
                alert("비밀번호가 일치하지 않습니다.");  // 경고창 띄우기
                document.getElementById("pwcheck").value = "";   // 비밀번호 확인 입력란 초기화
                document.getElementById("pwcheck").focus();      // 비밀번호 확인 입력란에 포커스 맞추기
              }
             else{


                $.ajax({
                            type: "POST",
                            url:"/auth/joinProc",
                            data: JSON.stringify(data),
                            contentType: "application/json; charset=utf-8",
                            dataType: "json"
                           }).done(function(response){

                                //클라이언트에 반환된 상태코드 값이 400일 경우
                                if(response.status == 400){
                                  alert("회원가입 정보를 다시 확인해 주세요.")
                                  if(response.data.hasOwnProperty("valid_email"))
                                  {
                                    $("#valid_email").text(response.data.valid_email);
                                    $("#valid_email").css('color', 'red');
                                  }
                                  else{
                                   $("#valid_email").text("");
                                  }

                                  if(response.data.hasOwnProperty("valid_password"))
                                  {
                                    $("#valid_password").text(response.data.valid_password);
                                    $("#valid_password").css('color', 'red');
                                  }
                                  else{
                                    $("#valid_password").text("");
                                  }

                                  if(response.data.hasOwnProperty("valid_username"))
                                  {
                                      $("#valid_username").text(response.data.valid_username);
                                      $("#valid_username").css('color', 'red');
                                  }
                                  else{
                                    $("#valid_username").text("");
                                  }

                                  if(response.data.hasOwnProperty("valid_gender"))
                                  {
                                    $("#valid_gender").text(response.data.valid_gender);
                                    $("#valid_gender").css('color', 'red');
                                  }
                                  else{
                                    $("#valid_gender").text("");
                                  }

                                }
                                else{
                                    alert("회원가입 완료");
                                    location.href = "/";
                                    console.log(response);
                                }

                           }).fail(function(error){
                                //회원가입에 실패할 경우
                                alert(JSON.stringify(error));
                           });

            }

    }

}


index.init();