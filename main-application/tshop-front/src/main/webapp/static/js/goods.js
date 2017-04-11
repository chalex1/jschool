/**
 * Created by Роднуля on 10.04.2017.
 */
(function () {

    var errorMessageDiv = jQuery("#errorMessage");



    var createGoodsList = function (goods) {
        jQuery(".goods").empty();
        var detailedUrl = ctx+"/goodsdetailed&id=";
        for (var i = 0; i < goods.length; i++) {
            var row = jQuery("<div></div>");
            var strhtml = [];
            strhtml.push(
                "<a href='",
                detailedUrl,
                goods[i].id,
                "'>", goods[i].name, "</a>"
            );
            var rbody = jQuery(strhtml.join(""));
            row.append(rbody);
            var rdeletebtn = jQuery("<input type='button' value='Delete'/>")
            rdeletebtn.click(i,function (e) {
                jQuery.ajax({
                    url: ctx + "/data/goods?id=" + goods[e.data].id,
                    method: "DELETE",
                    success: function (data) {
                        window.location.href = ctx + "/goods";
                    },
                    failure: function (error) {
                        errorMessageDiv.text("Problem with deleting goods");
                    }
                });
            });
            row.append(rdeletebtn);
            var raddbtn = jQuery("<input type='button' value = 'Add To Cart'/>")

            if(goods[i].quantity>0){
            raddbtn.click(goods[i].id,function (e) {
                jQuery.ajax({
                    url: ctx+"/data/cart?id="+e.data+"&quantity=1",
                    type: "POST",
                    failure: function () {
                        errorMessageDiv.text("Problem with adding to cart");
                    }
                });
            });}
            else{
                raddbtn.attr("disabled", true);
            }
            row.append(raddbtn);
            jQuery(".goods").append(row);
        }
    };

    jQuery.ajax({
        url: ctx + "/data/goods",
        success: function (data) {
            createGoodsList(data);
        },
        failure: function (error) {
            errorMessageDiv.text("Problem with getting categories");
        }
    });

    jQuery(".add-new-goods-btn").click(function () {
        window.location.href = ctx + "/goodsnew";
    });
    jQuery(".find-goods-btn").click(function () {
        var name=jQuery(".filter-goods-name").val();
        var priceFrom= jQuery(".filter-goods-price-from").val();
        var priceTo = jQuery(".filter-goods-price-to").val();
        var showEmpty = jQuery(".filler-goods-show-empty").val();

        jQuery.ajax({
            url: ctx + "/data/goods",
           data: {
                name: name,
                priceFrom: priceFrom,
                priceTo: priceTo,
                showEmpty: showEmpty
            },
            success: function (data) {
                createGoodsList(data);
            },
            failure: function (error) {
                errorMessageDiv.text("Problem with getting categories");
            }
        });
    });
})()