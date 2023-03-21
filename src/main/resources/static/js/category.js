function cateBtn(value) {
  console.log(value);
  // jsp로부터 form id 를 가져온다
  var cate = $('#cateForm');
  cate.attr("action", "/api/category");
  cate.attr("method", "POST");
  cate.submit();
}