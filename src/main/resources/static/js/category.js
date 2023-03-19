function cateBtn(value) {
  console.log(value);
  // jsp로부터 form id 를 가져온다
  var cate = $('#cateForm');
  //cate라는 변수에
  cate.attr("action", "/api/category");
  cate.attr("method", "POST");
  cate.submit()

}