/**
 *
 * 提交回复
 */
function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    comment2target(questionId,1,content);
}
/*
提交评论
 */
function comment(e) {
    var commentId = e.getAttribute("data-id")
    var content = $("#input-"+commentId).val();
    comment2target(commentId,2,content);

}

/**
 * 展开二级评论
 */
function collapseComments(e) {
    var id = e.getAttribute("data-id")
    var comments = $("#comment-" + id);

    //获取二级评论展开状态
    var collapse = e.getAttribute("data-collapse");
    console.log(collapse);
    if (collapse){
        //折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    }else{
        $.getJSON("/comment/" + id, function (data) {
            console.log(data);

            var subCommentContrainer = $("comment-body-" + id);
            $.each(data.data, function (comment) {
                $("<div/>",{
                    "class":"col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse comments",
                    html: comment.content
                });
                subCommentContrainer.prepend(c);
            });


            //展开二级评论
            comments.addClass("in");
            //标记二级评论展开状态
            e.setAttribute("data-collapse", "in")
            e.classList.add("active");
        })

    }
}

//校验
function comment2target(targetId,type,content) {
    if (!content){
        alert("不能回复空内容~~");
        return;
    }
    $.ajax({
        type: "post",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
                 $("#comment_section").hide();

            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=b3cd429693b7193f770d&redirect_uri=" + document.location.origin + "/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
        },
        dateType: "json"
    });
    
}



