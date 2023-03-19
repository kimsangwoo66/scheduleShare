function cateBtn(cateForm) {
  console.log(cateForm);

  let obj;
  var cate = $('#cateForm');
  cate.attr("action", "/schedules");
  cate.submit();

}

<<<<<<< Updated upstream
function cateBtn(value) {
  console.log(value);

//  let obj;
//  var cate = $('#cateForm');
//  alert(cate);
//  cate.attr("action", "/schedules");
//  cate.submit()
=======
  let obj;
  // jsp로부터 form id 를 가져온다
  var cate = $('#cateForm');
  //cate라는 변수에
  cate.attr("action", "/api/category");
  cate.attr("method", "POST");
  cate.submit()
>>>>>>> Stashed changes

}