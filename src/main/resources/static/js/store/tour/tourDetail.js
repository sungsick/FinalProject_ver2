var startNo = 1;
var title = $('.detail_info_container h4').text();
$(document).ready(function () {


    console.log("title = " + title);

    blogSearch(title, startNo);


});

function blogSearch(title, startNo){
    $.ajax({
        url: '/store/tour/searchBlog',
        type: 'get',
        data: {
            title: title,
            start: startNo
        },
        datatype: 'text',
        success: function (data) {
            var items = JSON.parse(data).items;
            var total = JSON.parse(data).total;
            var start = JSON.parse(data).start;
            console.log(items);

            for(var i = 0; i < items.length; i++){
                var content =
                    `<div class="blog_list">
                        <p class="blog_title">
                            <a href="${items[i].link}">${items[i].title}</a>
                        </p>
                        <p class="blog_content">
                            ${items[i].description}
                        </p>
                        <p class="blog_info">
                            <a href="${items[i].link}" class="blogger_name">
                                <img src="/img/store/tour/blog.png">
                                ${items[i].bloggername}
                            </a>
                            <span class="post_date">${items[i].postdate}</span>
                        </p>
                    </div> <hr/>`;

                $('#blog_search').append(content);
            }

            if(start >= total){
                $('.more_search').css('display', 'none');
            }


        },
        error: function () {
            console.log('블로그 오류');
        }
    });
}

$('.more_search').on('click', function(){
    startNo += 5;
    console.log(startNo);

    blogSearch(title, startNo);
})