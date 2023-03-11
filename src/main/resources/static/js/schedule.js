var fileNo = 0;
var filesArr = new Array();
var filelist = "";

function addFile(obj) {
  var maxFileCnt = 3; // 첨부파일 최대 개수
  var attFileCnt = document.querySelectorAll(".filebox").length; // 기존 추가된 첨부파일 개수
  var remainFileCnt = maxFileCnt - attFileCnt; // 추가로 첨부가능한 개수
  var curFileCnt = obj.files.length; // 현재 선택된 첨부파일 개수

  // 첨부파일 개수 확인
  if (curFileCnt > remainFileCnt) {
    alert("첨부파일은 최대 " + maxFileCnt + "개 까지 첨부 가능합니다.");
  }

  for (var i = 0; i < Math.min(curFileCnt, remainFileCnt); i++) {
    const file = obj.files[i];

    // 첨부파일 검증
    if (validation(file)) {
      // 파일 배열에 담기
      var reader = new FileReader();
      reader.onload = function () {
        filesArr.push(file);
      };
      reader.readAsDataURL(file);

      // 목록 추가
      let htmlData = "";
      htmlData += '<div id="file' + fileNo + '" class="filebox">';
      htmlData += '   <p class="name">' + file.name + "</p>";
      htmlData +=
        '   <a class="delete" onclick="deleteFile(' +
        fileNo +
        ');"><i class="far fa-minus-square"></i></a>';
      htmlData += "</div>";
      $(".file-list").append(htmlData);
      fileNo++;
    } else {
      continue;
    }
  }
  // 초기화
  document.querySelector("input[type=file]").value = "";
}

/* 첨부파일 검증 */
function validation(obj) {
  const fileTypes = [
    "application/pdf",
    "image/gif",
    "image/jpeg",
    "image/png",
    "image/bmp",
    "image/tif",
    "application/haansofthwp",
    "application/x-hwp",
  ];
  if (obj.name.length > 100) {
    alert("파일명이 100자 이상인 파일은 제외되었습니다.");
    return false;
  } else if (obj.size > 1024 * 1024 * 2) {
    alert("최대 이미지 파일 사이즈가 2MB를 초과한 파일은 제외되었습니다.");
    return false;
  } else if (obj.name.lastIndexOf(".") == -1) {
    alert("확장자가 없는 파일은 제외되었습니다.");
    return false;
  } else if (!fileTypes.includes(obj.type)) {
    alert("첨부가 불가능한 파일은 제외되었습니다.");
    return false;
  } else {
    return true;
  }
}

/* 첨부파일 삭제 */
function deleteFile(num) {
  document.querySelector("#file" + num).remove();
  filesArr[num].is_delete = true;
}

/* 폼 전송 */
function submitForm() {
  // 폼데이터 담기
  var form = document.querySelector("#imgform");
  var formData = new FormData(form);
  for (var i = 0; i < filesArr.length; i++) {
    // 삭제되지 않은 파일만 폼데이터에 담기
    if (!filesArr[i].is_delete) {
      formData.append("attach_file", filesArr[i]);
    }
  }
    /* formdata key 확인하기 */
    for (let key of formData.keys()) {
    	   console.log(key);
    }
    /* formdata value 확인하기 */
    for (let value of formData.values()) {
          console.log(value);
    }

    let data = {
        category: {
        category_id: parseInt($("#category").val())
        },
        title: $("#title").val(),
        content: $("#content").val(),
        timeCost: parseInt($("#timeCost").val()),
        moneyCost: parseInt($("#moneyCost").val())
    };

    //formData에 input 에 담긴 값들을 담은 json 객체 추가
    formData.append("schedule", new Blob([JSON.stringify(data)], {type: "application/json"}));

  $.ajax({
    type: "POST",
    url: "/api/schedule",
    enctype: "multipart/form-data",
    processData: false,
    contentType: false,
    data: formData,
    datatype: "json",
    async: true,
    timeout: 30000,
    cache: false,
    headers: { "cache-control": "no-cache", pragma: "no-cache" },
    success: function () {
        console.log("파일 업로드 성공");
        alert("등록 완료");
        location.href = "/";

    },
    error: function (xhr, desc, err) {
      alert("사진을 1개이상 첨부해 주세요.");
      return;
    },
  });


}


let index = {
    init: function(){

        $("#sbtn-save").on("click", ()=> { //function을 사용하지 않는 이유는 this를 바인딩하기 위함
            this.save();
        });
    },


//    save:function(){
//
//        let data = {
//            category: {
//            category_id: parseInt($("#category").val())
//            },
//            title: $("#title").val(),
//            content: $("#content").val(),
//            timeCost: parseInt($("#timeCost").val()),
//            moneyCost: parseInt($("#moneyCost").val())
//        };
//        console.log(JSON.stringify(data))
//
//        $.ajax({
//            type: "POST",
//            url: "api/schedule",
//            data: JSON.stringify(data),
//            contentType: "application/json; charset=utf-8",
//            dataType: "json"
//
//        }).done(function(res){
//            alert("등록 완료");
//            location.href = "/";
//        }).fail(function(error){
//            alert(JSON.stringify(error));
//        });
//
//    }

}

//index.init();

