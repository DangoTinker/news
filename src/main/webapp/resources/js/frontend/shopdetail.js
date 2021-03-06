$(function(){

    var loading=false;
    var pageNum=1;
    var pageSize=3;
    var maxItems = 20;
    var shopId=getQueryString('shopId');
    var searchDivUrl='/frontend/listshopdetailpageinfo?shopId='+shopId;
    var listUrl='/frontend/listproductsbyshop';

    var shopId = getQueryString('shopId');
    	var productCategoryId = '';
    	var productName = '';


    $('#exchangelist').attr('href', '/frontend/awardlist?shopId=' +
	 shopId);

    getSearchDivData();

    addItems(pageSize, pageNum);



    function getSearchDivData(){

        $.getJSON(searchDivUrl,function(data){
            if(data.success){
                var shop = data.shop;
                $('#shop-cover-pic').attr('src', shop.shopImg);
                $('#shop-update-time').html(
                        new Date(shop.lastEditTime)
                                .Format("yyyy-MM-dd"));
                $('#shop-name').html(shop.shopName);
                $('#shop-desc').html(shop.shopDesc);
                $('#shop-addr').html(shop.shopAddr);
                $('#shop-phone').html(shop.phone);
                // 获取后台返回的该店铺的商品类别列表
                var productCategoryList = data.productCategoryList;
                var html = '';
                // 遍历商品列表，生成可以点击搜索相应商品类别下的商品的a标签
                productCategoryList
                        .map(function(item, index) {
                            html += '<a href="#" class="button" data-product-search-id='
                                    + item.productCategoryId
                                    + '>'
                                    + item.productCategoryName
                                    + '</a>';
                        });
                // 将商品类别a标签绑定到相应的HTML组件中
                $('#shopdetail-button-div').html(html);
            }
        })

    }


    function addItems(pageSize,pageIndex){
        loading=true;
        var url = listUrl + '?' + 'pageIndex=' + pageIndex + '&pageSize='
        				+ pageSize + '&productCategoryId=' + productCategoryId
        				+ '&productName=' + productName + '&shopId=' + shopId;
        $.getJSON(url,function(data){
            if(data.success){
                maxItems=data.count;
                var html = '';
                // 遍历商品列表，拼接出卡片集合
                data.productList.map(function(item, index) {
                html += '' + '<div class="card" data-product-id='
                        + item.productId + '>'
                        + '<div class="card-header">' + item.productName
                        + '</div>' + '<div class="card-content">'
                        + '<div class="list-block media-list">' + '<ul>'
                        + '<li class="item-content">'
                        + '<div class="item-media">' + '<img src="'
                        + item.imgAddr + '" width="44">' + '</div>'
                        + '<div class="item-inner">'
                        + '<div class="item-subtitle">' + item.productDesc
                        + '</div>' + '</div>' + '</li>' + '</ul>'
                        + '</div>' + '</div>' + '<div class="card-footer">'
                        + '<p class="color-gray">'
                        + new Date(item.lastEditTime).Format("yyyy-MM-dd")
                        + '更新</p>' + '<span>点击查看</span>' + '</div>'
                        + '</div>';
                });
                // 将卡片集合添加到目标HTML组件里
                $('.list-div').append(html);

                var total=$('.list-div .card').length;

                if (total >= maxItems) {
                    // 隐藏提示符
                    $('.infinite-scroll-preloader').hide();
                } else {
                    $('.infinite-scroll-preloader').show();
                }

                pageNum+=1;

                loading = false;
                				// 刷新页面，显示新加载的店铺
                $.refreshScroller();


            }
        })

    }


    $('.product-list').on('click', '.card', function(e) {
            		var productId = e.currentTarget.dataset.productId;
            		window.location.href = '/frontend/productdetail?productId=' + productId;
            	});

    // 下滑屏幕自动进行分页搜索
    $(document).on('infinite', '.infinite-scroll-bottom', function() {
        if (loading)
            return;
        addItems(pageSize, pageNum);
    });
    // 选择新的商品类别之后，重置页码，清空原先的商品列表，按照新的类别去查询
    $('#shopdetail-button-div').on(
            'click',
            '.button',
            function(e) {
                // 获取商品类别Id
                productCategoryId = e.target.dataset.productSearchId;
                if (productCategoryId) {
                    // 若之前已选定了别的category,则移除其选定效果，改成选定新的
                    if ($(e.target).hasClass('button-fill')) {
                        $(e.target).removeClass('button-fill');
                        productCategoryId = '';
                    } else {
                        $(e.target).addClass('button-fill').siblings()
                                .removeClass('button-fill');
                    }
                    $('.list-div').empty();
                    pageNum = 1;
                    addItems(pageSize, pageNum);
                }
            });

    // 需要查询的商品名字发生变化后，重置页码，清空原先的商品列表，按照新的名字去查询
    $('#search').on('change', function(e) {
        productName = e.target.value;
        $('.list-div').empty();
        pageNum = 1;
        addItems(pageSize, pageNum);
    });
    // 点击后打开右侧栏
    $('#me').click(function() {
        $.openPanel('#panel-right-demo');
    });
    $.init();


})