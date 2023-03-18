function cateBtn(cateForm) {
  console.log(cateForm);

  let obj;
  var cate = $('#cateForm');
  alert(cateForm);
  cate.attr("action", "/schedules");
  cate.submit()

}