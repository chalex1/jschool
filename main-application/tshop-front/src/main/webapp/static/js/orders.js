/**
 * Created by Роднуля on 11.04.2017.
 */

(function () {
    var $errorMessageSpan = jQuery("#errorMessage");
    var $ordersList = jQuery(".orders-list");

    jQuery.ajax({
        url: ctx + "/data/orders",
        success: function (data) {
            var $table = jQuery("<table class='table table-striped'></table>");
            $table.append("<tr><td>Client id</td><td>Order Status</td><td>Payment Status</td><td>Payment method</td></tr>")
            if (data.length) {
                for (var i = 0; i < data.length; i++) {
                    var $row = jQuery(["<tr><td>", data[i].clientId, "</td>",
                        "<td>", data[i].status, "</td>",
                        "<td>", data[i].paymentStatus, "</td>",
                        "<td>", data[i].paymentMethod, "</td>",
                        "</tr>"].join("")).click(data[i].id, function (e) {
                        window.location.href = [ctx, "/orderdetailed?id=", e.data].join("");
                    });
                    $table.append($row);
                }
                $ordersList.append($table);
            } else {
                $ordersList.append("No orders for show");
            }
        },
        error: function () {
            $errorMessageSpan.text("Problem with getting orders");
        }
    })
})()