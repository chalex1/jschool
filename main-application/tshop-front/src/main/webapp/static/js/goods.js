/**
 * Created by Роднуля on 10.04.2017.
 */
(function () {

    var errorMessageDiv = jQuery("#errorMessage");

    var admin = false;
    jQuery.ajax({
        url: ctx + "/data/clients/current",
        success: function (data) {
            admin = data.accountTransport.type === "ADMIN";
            if(admin){
                jQuery(".add-new-goods-btn").removeClass("hidden");
            }
        }
    })


    var createGoodsList = function (goods) {
        jQuery(".goods").empty();
        var detailedUrl = ctx + "/goodsdetailed?id=";
        var $table = jQuery("<table class='table table-striped'></table>");
        $table.append(jQuery("<tr><td>Model</td><td>Brand</td><td>Color</td><td>In store</td><td>Price</td><td></td></tr>"));//<td></td>
        for (var i = 0; i < goods.length; i++) {
            var row = jQuery("<tr></tr>");


            var rbody = jQuery(
                [
                    "<td>", "<a href='", detailedUrl, goods[i].id, "'>", goods[i].model, "</a>", "</td>",
                    "<td>", goods[i].enginetype, "</td>",
                    "<td>", goods[i].color, "</td>",
                    "<td>", goods[i].quantity, "</td>",
                    "<td>", goods[i].price, "</td>",
                ].join(""));
            row.append(rbody);
            var rdeletebtn = jQuery("<input type='button' class='btn btn-default' value='Delete'/>")
            rdeletebtn.click(i, function (e) {
                jQuery.ajax({
                    url: ctx + "/data/goods?id=" + goods[e.data].id,
                    method: "DELETE",
                    success: function (data) {
                        window.location.href = ctx + "/goods";
                    },
                    error: function (error) {
                        errorMessageDiv.text("Problem with deleting goods");
                    }
                });
            });
            if (admin) {
                row.append(jQuery("<td></td>").append(rdeletebtn));
            }
            var raddbtn = jQuery("<input type='button' class='btn btn-default' value = 'Add To Cart'/>")

            if (goods[i].quantity > 0) {
                raddbtn.click(goods[i].id, function (e) {
                    jQuery.ajax({
                        url: ctx + "/data/cart?id=" + e.data + "&quantity=1",
                        type: "POST",
                        error: function () {
                            errorMessageDiv.text("Problem with adding to cart");
                        }
                    });
                });
            }
            else {
                raddbtn.attr("disabled", true);
            }
            if (!admin) {
                row.append(jQuery("<td></td>").append(raddbtn));
            }
            $table.append(row);
            jQuery(".goods").append($table);
        }
    };

    jQuery.ajax({
        url: ctx + "/data/goods",
        success: function (data) {
            createGoodsList(data);
        },
        error: function (error) {
            errorMessageDiv.text("Problem with getting goods");
        }
    });

    jQuery(".add-new-goods-btn").click(function () {
        window.location.href = ctx + "/goodsnew";
    });
    jQuery(".find-goods-btn").click(function () {
        var model = jQuery(".filter-goods-name").val();
        var priceFrom = jQuery(".filter-goods-price-from").val();
        var priceTo = jQuery(".filter-goods-price-to").val();
        var instock = jQuery(".filler-goods-show-empty")[0].checked;

        jQuery.ajax({
            url: ctx + "/data/goods",
            data: {
                model: model,
                priceFrom: priceFrom,
                priceTo: priceTo,
                quantityFrom: instock ? 1 : 0
            },
            success: function (data) {
                createGoodsList(data);
            },
            error: function (error) {
                errorMessageDiv.text("Problem with getting goods");
            }
        });
    });
})()