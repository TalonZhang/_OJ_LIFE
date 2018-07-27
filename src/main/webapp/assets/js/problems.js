jQuery(document).ready(function () {
    $(function () {
        $.ajax({
            type:"GET",
            url:"/tutorial/problems",
            dataType:"json",
            success:function (data) {
                $("#chapter").text("第"+data.tutorial.chapter+"章 第"+data.tutorial.section+"节："+data.tutorial.title);
                $("#description").text(data.tutorial.description);
                $.each(data.tutorial.problems,function (n,value) {
                    $("#task-item"+n).html("<span class=\"badge\">未完成</span>任务"+(n+1)+"："+value.title)
                    $("#task-item"+n).show();
                })
            }
        })
    })
});