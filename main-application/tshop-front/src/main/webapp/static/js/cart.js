/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {

    var $errorMessageSpan = jQuery("#errorMessage");
    var $cartDiv = jQuery(".cart");

    var $order = jQuery(".order-btn");

    $order.click(function () {
        window.location.href = ctx + "/neworder";
    })


    jQuery.ajax({
        url: ctx + "/data/cart",
        success: function (data) {
            if(data.length) {
                var $table = jQuery("<table><tr><td>Product</td><td>Qantity</td><td>Price</td></tr></table>");
                data.forEach(function (element) {
                    $table.append(jQuery(["<tr>",
                        "<td>", element.goodsTransport.name, "</td>",
                        "<td>", element.quantity, "</td>",
                        "<td>", element.goodsTransport.price, "</td>",
                        "</tr>"].join("")));
                });
                $cartDiv.append($table);
            }else{
                $order.addClass("hidden");
                $cartDiv.append("Cart is empty");
            }
        },
        failure: function () {
            $errorMessageSpan.text("Problem with getting cart");
        }
    });


})()