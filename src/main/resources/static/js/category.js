//let index={
//    init:fuction(){
//    $("#my-button text-center").on("click",()=>{
//        this.save();
//    });
//    },
//
//    save: function(){
//    let data={
//        schedule_id:$("#category_id").val()
//    };
//    $.ajax({
//        type:"POST",
//        url:"/",
//        data:json.STRINGIFY(data),
//        contentType:"application/json; charset=utf-8",
//        dataType:"json"
//    }).done(function(resp)){
//        alert("스케줄 등록 페이지로 이동합니다.");
//        location.href="/";
//        }).fail(function(error){
//            alert(JSON.stringify(error));
//        });
//
//    },
//
//}
const cateButton = document.getElementById("btn_cate");
cateButton.addEventListener("click", function(){
    const value = cateButton.value;
    console.log("@@@@@@@@" + value);
    alert(value);


//    var d = "<c:out value=${cate.category_id}">";
//    alert(d);
})

//$(document).ready(function(){
//    $('#click').click(function(){
//
//function fn_scheduleCate(){
//    var categoryId = $("#cate").val();
//    var categoryName = $("#cateName").val();
//    console.log("category name[" + ${cate} + "]")
//    $.ajax({
//        type:'post',
//        url:'/api/category',
//        data : categoryName,
//
//    });
//};

//function fn_goView(name){
//    $("#name").val(name);
//
//    var f = ${"#frm"};
//    f.attr("action", "/schedules");
//    f.attr("method", "POST");
//    f.submit();
//    console.log("f["+ f + "]");
//};
