var areaText = '';

var areaCode = '';
var areaName = '';
var sigunguCode = '';
var sigunguName = '';
var contentTypeId = '';
var contentTypeName = '';
var cat1 = '';
var cat1Name = '';
var cat2 = '';
var cat2Name = '';
var cat3 = '';
var cat3Name = '';

var searchType = '지역별';


//지역 선택 모달
$('.search_area_btn').on('click', function(){
   $('.area_container').addClass('modal_on');

   $('#area_list1').empty();
   $('#area_list2').empty();
   $('.sigungu_list').empty();

   $.ajax({
      url: '/store/tour/getArea',
      type: 'get',
      dataType: 'json',
      success: function(data){
         console.log(data);
         var item = data.response.body.items.item;

         /* 시/도 리스트 생성 */
         for(var i = 0; i < item.length; i++){
            var content =
                           `<button class="modal_btn" onclick="insertArea(this)" value="${item[i].code}">` +
                           item[i].name + '</button>'

            if(i === Math.floor(item.length / 2)){

               var line = '<div class="btn_list area_list" id="area_list2"></div>'
               $('#area_box').append(line);
            }

            if(i <= Math.floor(item.length/2)){
               $('#area_list1').append(content);
            } else {
               $('#area_list2').append(content);
            }
         }
      }
   });
});

function insertArea(e){
   areaCode = e.value;
   areaName = e.textContent;

   console.log('code=' + areaCode + ', name = ' + areaName);

   sigunguCode = '';
   sigunguName = '';

   console.log("insertArea: "+sigunguName);
   $.ajax({
      url: '/store/tour/getSigungu',
      type: 'get',
      data: {
         areaCode : areaCode
      },
      dataType: 'json',
      success: function(data){
         console.log(data);
         var item = data.response.body.items.item;
         $('.sigungu_list').empty();
         for(var i = 0; i < item.length; i++){
            var content = `<button class="modal_btn sigungu_btn" onclick = "insertAreaCode(this)" value="${item[i].code}">` +
                        item[i].name +'</button>';
            $('.sigungu_list').append(content);
         }
      }

   });
}

function insertAreaCode(e){
   sigunguCode = e.value;
   sigunguName = e.textContent;

}

//지역 확인 버튼 누르면
$('#area_confirm_btn').on('click', function(){
   if(sigunguCode === ''){
      sigunguName = '전체';
   }
   
   var areaInput = '광역시/도 : ' + areaName + ' , 시/군/구 : ' + sigunguName;

   if(searchType === '지역별') {
      $('#area_area_code').text(areaInput);
      closeModal();
   } else if(searchType === '통합'){
      $('#keyword_area_code').text(areaInput);
      closeModal();
   }

   console.log('areaCode:'+areaCode+'areaName:'+areaName);
   console.log('sigunguCode:'+sigunguCode+'sigunguName:'+sigunguName);
});

//관광 타입 모달
$('.search_content_btn').on('click', function(){
   $('.content_type_container').addClass('modal_on');
});
$('.modal_btn[name=contentTypeId]').on('click', function(){
   contentTypeId = $(this).val();
   contentTypeName = $(this).text();
   console.log('contentTypeId:'+contentTypeId);
   console.log('contentTypeName:'+contentTypeName);
});
$('#content_type_confirm_btn').on('click', function(){
   insertContentType(contentTypeName);
   closeModal();
});
function insertContentType(contentTypeName){
   $('#area_content_id').text(contentTypeName);
}
//서비스 분류 모달
$('.search_category_btn').on('click', function(){
   $('.service_container').addClass('modal_on');

   $('.cat_list').empty();
   var data = {
      contentTypeId: contentTypeId,
   }
   //대분류
   $.ajax({
      url: '/store/tour/getCat1',
      type: 'get',
      data: data,
      dataType: 'json',
      success: function(data){
         var item = data.response.body.items.item;

         for(var i = 0; i < item.length; i++){
            var content =
                `<button class="modal_btn" name="cat1" value="${item[i].code}" onclick="insertCat1(this)">
                ${item[i].name}
                </button>`;
            $('.cat1').append(content);
         }
      }
   });
});

function insertCat1(e){
   cat1 = e.value;
   cat1Name = e.textContent;

   var data = {
      contentTypeId: contentTypeId,
      cat1: cat1
   };

   $('.cat2').empty();
   $('.cat3').empty();

   cat2 = '';
   cat2Name = '';
   cat3 = '';
   cat3Name = '';

   $.ajax({
      url: '/store/tour/getCat2',
      type: 'get',
      data: data,
      dataType: 'json',
      success: function(data){
         var item = data.response.body.items.item;

         for(var i = 0; i < item.length; i++){
         var content =
             `<button class="modal_btn" name="cat2" value="${item[i].code}" onclick="insertCat2(this)">
                ${item[i].name}
             </button>`;
         $('.cat2').append(content);
         }
      }
   });
}

function insertCat2(e){
   cat2 = e.value;
   cat2Name = e.textContent;

   var data = {
      contentTypeId: contentTypeId,
      cat1: cat1,
      cat2: cat2
   };

   cat3 = '';
   cat3Name = '';

   $('.cat3').empty();

   $.ajax({
      url: '/store/tour/getCat3',
      type: 'get',
      data: data,
      dataType: 'json',
      success: function(data){
         var item = data.response.body.items.item;
         console.log(item);

         for(var i = 0; i < item.length; i++){

            var content =
                `<button class="modal_btn" name="cat3" value="${item[i].code}" onclick="insertCat3(this)">
                ${item[i].name}
                </button>`;

            $('.cat3').append(content);
         }
      }
   });
}

function insertCat3(e){
   cat3 = e.value;
   cat3Name = e.textContent;
}
$('#service_confirm_btn').on('click', function(){

   var  categoryInput = '';

   if(cat1Name !== ''){
       categoryInput += '대분류 : ' + cat1Name;
   }

   if(cat2Name !== ''){
       categoryInput += ', 중분류 : ' + cat2Name;
   }

   if(cat3Name !== ''){
       categoryInput += ', 소분류 : ' + cat3Name;
   }

   if(searchType === '지역별') {
      $('#area_category_code').text(categoryInput);
      closeModal();
   } else if(searchType === '통합'){
      $('#keyword_category_code').text(categoryInput);
      closeModal();
   }


   closeModal();
});
//모달 창 닫기
$('.modal_cancel_btn').on('click', function(){
   console.log($(this).attr('id'));

   /*switch ($(this).attr('id')){
      case 'area_cancel_btn':
         areaCode = '';
         areaName = '';
         sigunguCode = '';
         sigunguName = '';
         break;
      case 'service_cancel_btn':

   }*/
   closeModal();
});
$('.modal_close_btn').on('click', function(){

   closeModal();
});
function closeModal(){
   $('.modal_container').removeClass('modal_on');
}

//검색 타입 선택
$('.type_btn').on('click', function(){
   //text 초기화

   
   if($(this).text() === '지역별 검색'){
      $('.type_area').css('display', 'block');
      $('.type_keyword').css('display', 'none');
      $('.type_keyword .search_option_text').text('');
      searchType = '지역별';
   } else {
      $('.type_keyword').css('display', 'block');
      $('.type_area').css('display', 'none');
      $('.type_area .search_option_text').text('');
      searchType = '통합';
   }

});

$('.type_area_btn').on('click', function(){

});


/*
   $('#search_area_btn').on('click', function(){
   alert('모달');
});
   $(function () {
   $.ajax({
      url: '/tourismInfo',
      type: 'get',
      dataType: 'text',
      success: function (data) {
         let item = JSON.parse(data).response.body.items.item;
         for (let i = 0; i < item.length; i++) {
            let content = `<p>${item[i].title}</p>
                                 <p><img src="${item[i].firstimage}" width="500px" height="300px"></p>
                                 <p>${item[i].zipcode}</p>
                                 <p>${item[i].addr1}</p>
                                 <p>${item[i].overview}</p>`;
            $('.container1').append(content);
            blogSearchByContentId(item[i].title);

         }

      }
   });
});

   function blogSearchByContentId(title) {
   $.ajax({
      url: '/searchBlog',
      type: 'get',
      data: {
         title: title
      },
      dataType: 'text',
      success: function (data) {
         let items = JSON.parse(data).items;
         console.log(data);
         for (let i = 0; i < items.length; i++) {
            let content = `<p><a href="${items[i].link}">${items[i].title}</a></p>
                                  <p>${items[i].description}</p>
                                  <p><a href="${items[i].bloggerlink}">출처:${items[i].bloggername}</a></p>
                                  <p>작성일:${items[i].postdate}</p><hr/>`;
            $('.blog').append(content);
         }

      },
      error: function () {
         alert('블로그 오류');
      }
   });
}
*/
