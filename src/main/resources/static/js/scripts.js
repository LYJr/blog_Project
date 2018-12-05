$(".comment-form input[type=submit]").click(addAnswer);
  console.log("확인용");
function addAnswer(e) {
    e.preventDefault(); //submit 이 자동으로 동작하는 것을 막는다.

    var queryString = $(".comment-form").serialize(); //form data들을 자동으로 묶어준다.
    console.log("query : "+ queryString);

    var url = $(".comment-form").attr("action");
        console.log("url : " + url);

        $.ajax({
            type : 'post',
            url : url,
            data : queryString,
            dataType : 'json',
            error: function(xhr){console.log(xhr)},
            success : function (data, status) {
                console.log("sucess data : " + data)
                console.log(data);


                var answerTemplate = $("#blogTemplate").html();
                var template = answerTemplate.format(data.name, data.messages);
                $(".comment-list").before(template);
                $("textarea[name=contents]").val("");
                console.log("success ")
            }


        });
}

String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};