let index = {

    init: function(){
        $("#joinbtn").on("click", ()=> {
            this.save();
        });

    },


    save: function(){


            console.log(gender);
            let data = {
                email: $("#email").val(),
                password: $("#password").val(),
                username: $("#username").val(),
                gender: $("input:radio[name=gender]:checked").val()

            };

            var password = document.getElementById("password").value;  // 비밀번호 입력란 값 가져오기
            var pwcheck = document.getElementById("pwcheck").value;    // 비밀번호 확인 입력란 값 가져오기
            console.log("password: " + password);
            console.log("pwcheck: " + pwcheck);
            console.log("gender: " + gender);

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
                                alert("회원가입 완료");
                                location.href = "/";
                                console.log(response);
                           }).fail(function(error){
                                //회원가입에 실패할 경우
                                alert(JSON.stringify(error));
                           });

            }




    }

}


index.init();