/**
 * Created by Роднуля on 10.04.2017.
 */
(function () {

    var errorMessageDiv = jQuery("#errorMessage");



    var createGoodsList = function (goods) {
        jQuery(".goods").empty();
        var detailedUrl = "";
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

            $table.append(row);
            jQuery(".goods").append($table);
        }
    };

    jQuery.ajax({
        url: "http://localhost:8080/tshop-front-1.0-SNAPSHOT/data/goods",
        success: function (data) {
            createGoodsList(data);
        },
        error: function (error) {
            errorMessageDiv.text("Problem with getting categories");
        }
    });

})()