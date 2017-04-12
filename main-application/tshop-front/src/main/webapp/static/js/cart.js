/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {

    var $errorMessageSpan = jQuery("#errorMessage");
    var $cartDiv = jQuery(".cart");

    var $order = jQuery(".order-btn");

    $order.click(function () {
        window.location.href = ctx + "/neworder";
    });

    jQuery(".cancel-save-btn").click(function () {
        window.location.href = ctx + "/goods";
    });


    jQuery.ajax({
        url: ctx + "/data/cart",
        success: function (data) {
            if (data.length) {
                var $table = jQuery("<table class='table table-striped'></table>");
                $table.append(jQuery("<tr><td>Product</td><td>Price</td><td></td></tr>"));
                var totalPrice = 0;
                data.forEach(function (element) {
                    totalPrice += element.goodsTransport.price;
                    var $row = jQuery([
                        "<td>", element.goodsTransport.name, "</td>",
                        "<td>", element.goodsTransport.price, "</td>"
                    ].join(""));
                    var $removeFromCartbtn = jQuery("<input type='button' class='btn btn-default' value='Remove from cart'/>");
                    $removeFromCartbtn.click(element.goodsTransport.id, function (e) {
                        jQuery.ajax({
                            url: ctx + "/data/cart?id=" + e.data + "&quantity=-1",
                            type: "POST",
                            success: function () {
                                window.location.href = ctx + "/cart";
                            },
                            error: function () {
                                errorMessageDiv.text("Problem with removing from cart");
                            }
                        });
                    });
                    $table.append(jQuery("<tr></tr>").append($row).append(jQuery("<td></td>").append($removeFromCartbtn)));
                    // $row.append(jQuery("<td></td>").append($removeFromCartbtn));

                });
                $table.append(jQuery(["<tr><td><b>Total price :</b></td><td><b> ", totalPrice, "</b></td><td></td></tr>"].join("")));
                $cartDiv.append($table);

            } else {
                $order.addClass("hidden");
                $cartDiv.append("Cart is empty");
            }
        },
        error: function () {
            $errorMessageSpan.text("Problem with getting cart");
        }
    });


})()