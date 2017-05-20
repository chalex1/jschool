/**
 * Created by Роднуля on 10.04.2017.
 */
(function () {

    var errorMessageDiv = jQuery("#errorMessage");
    var lastUpdated = 0;


    var createGoodsList = function (goods) {
        jQuery(".goods").empty();
        var detailedUrl = "";
        var $div = jQuery("<div class='row'></div>");

        for (var i = 0; i < goods.length; i++) {
            var $block = jQuery("<div class='col-xs-6 col-lg-4'></div>");


            var $rbody = jQuery(
                [
                    "<br>", "<a href='", detailedUrl, goods[i].id, "'>", goods[i].model, "</a>",
                    "<br>", goods[i].enginetype,
                    "<br>", goods[i].color,
                    "<br>", goods[i].quantity,
                    "<br>", goods[i].price,
                    "<input type='button' class='btn btn-default' value='Details'>"
                ].join(""));
            $block.append($rbody);

            $div.append($block);
            jQuery(".goods").append($div);
        }
    };


    var updateGoods = function () {

        jQuery.ajax({
            url: "http://localhost:8080/tshop-front-1.0-SNAPSHOT/data/goods",
            success: function (data) {
                createGoodsList(data);
            },
            error: function (error) {
                errorMessageDiv.text("Problem with getting goods");
            }
        });
    }
    var checkUpdateGoods = function () {
        // alert("checking");
        jQuery.ajax({
            url: [ctx, "/app/updated"].join(""),
            success: function (data) {
                if (!lastUpdated) {
                    lastUpdated = data;
                } else if (data > lastUpdated) {
                    lastUpdated = data;
                    updateGoods();
                    // alert("Updated!");
                }

            },
            error: function () {

            }
        })
    }
    updateGoods();
    setInterval(checkUpdateGoods, 15000);
})()