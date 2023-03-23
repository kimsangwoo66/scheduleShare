var fileNo = 3;
var filesArr = new Array();
var filelist = "";

const scheduleId = $("#schedule_id").val();
console.log("scheduleId: " + scheduleId);


//category 값 string 타입에서 -> int 타입으로 형 변환
const cateIdString = document.getElementById("category").value;
console.log("cateIdString: " + cateIdString)
const cateIdInt = parseInt(cateIdString);
document.getElementById("category").value = cateIdInt;



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
    console.log("fileinfo: " + file);

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


    let data = {
        schedule_id : $("#schedule_id").val(),
        category: {
        category_id: parseInt($("#category").val())
        },
        title: $("#title").val(),
        content: $("#content").val(),
        timeCost: parseInt($("#timeCost").val()),
        moneyCost: parseInt($("#moneyCost").val())
    };


    //기존 이미지 파일 가져오기
    const file0 = $('#file0').attr('value');
    const file1 = $('#file1').attr('value');
    const file2 = $('#file2').attr('value');

    let fileNameList = [];
      if (file0) {
        fileNameList.push(file0);
      }
      if (file1) {
        fileNameList.push(file1);
      }

      if (file2) {
        fileNameList.push(file2);
      }

    //서버에 scheduleId 전달 및 서버로 부터 받은 FileUrl을 파일데이터로 만들어 formData에 추가
    fetch(`/Images?schedule_id=${scheduleId}`)
      .then(response => response.json())
      .then(imagePaths => {

        const promises = [];
        for (let i = 0; i < imagePaths.length; i++) {
          const imageUrl = `/img/${imagePaths[i]}`;
          const promise = fetch(imageUrl)
            .then(response => {
              if (!response.ok) {
                throw new Error(`HTTP error ${response.status}`);
              }
              return response.blob();
            })
            .then(imageBlob => {
              console.log("imageBlob: " + imageBlob);
              //이름이 이름이 존재할 경우에만 파일데이터 생성
              if(fileNameList[i]){
                const serverfile = new File([imageBlob], fileNameList[i], { type: 'image/png' });
                formData.append('attach_file', serverfile);
              }

            })
            .catch(error => console.error(error));
          promises.push(promise);
        }
        Promise.all(promises).then(() => {
          // formData를 사용하여 이미지 파일 데이터를 전송하거나 처리

          $.ajax({
                      type: "PUT",
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
                        console.log("파일 수정 성공");
                        alert("수정 완료");
                        location.href = "/";
                      },
                      error: function (xhr, desc, err) {
                        alert("사진을 1개이상 첨부해 주세요.");
                        return;
                      },
                    });
        });
      })
      .catch(error => console.error(error));

    //formData에 input 에 담긴 값들을 담은 json 객체 추가
    formData.append("schedule", new Blob([JSON.stringify(data)], {type: "application/json"}));


}







