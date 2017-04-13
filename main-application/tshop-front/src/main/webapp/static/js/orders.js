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
            $table.append("<tr><td>Client</td><td>Order Status</td><td>Payment Status</td><td>Payment method</td><td>Created At</td><td></td></tr>")
            if (data.length) {
                for (var i = 0; i < data.length; i++) {
                    (function (i) {
                        jQuery.ajax({
                            url: ctx + "/data/clients/" + data[i].clientId

                        }).then(function (client) {
                            var clientlogin = "";
                            if (client && client.accountTransport.login) {
                                clientlogin = client.accountTransport.login;
                            }
                            var $row = jQuery(["<tr><td>", clientlogin ? clientlogin : data[i].clientId, "</td>",
                                "<td>", data[i].status, "</td>",
                                "<td>", data[i].paymentStatus, "</td>",
                                "<td>", data[i].paymentMethod, "</td>",
                                "<td>", new Date(data[i].createdAt).toLocaleString(), "</td>",
                                "<td>", "<a href='", ctx, "/orderdetailed?id=", data[i].id, "'> detailed </a> </td>",
                                "</tr>"].join(""));
                            $table.append($row);

                        });
                    })(i)
                }
                $ordersList.append($table);
            } else {
                $ordersList.append("No orders for show");
            }
        },
        error: function () {
            $errorMessageSpan.text("Problem with getting orders");
        }
    });

    var createRow = function () {
        var $row = jQuery(["<tr><td>",
            data[i].clientId, "</td>",
            "<td>", data[i].status, "</td>",
            "<td>", data[i].paymentStatus, "</td>",
            "<td>", data[i].paymentMethod, "</td>",
            "<td>", new Date(data[i].createdAt).toLocaleString(), "</td>",
            "<td>", "<a href='", ctx, "/orderdetailed?id=", e.data, "'> detailed </a> </td>",
            "</tr>"].join("")).click(data[i].id, function (e) {
            window.location.href = [ctx, "/orderdetailed?id=", e.data].join("");
        });
        $table.append($row);
    }

    var getUserLoginById = function (id) {
        var result = "";
        jQuery.ajax({
            url: [ctx, "/data/clients/", id].join(""),
            success: function (data) {
                return data.accountTransport.login;
            }
        });

    };

})()