
/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {

    var $errorMessageSpan = jQuery("#errorMessage");
    var goodsIds = [];
    var account = {};
    jQuery.ajax({
        url: ctx + "/data/clients/current",
        success: function (data) {
            account = data.accountTransport;
            makeAnOrdersList();
        }
    });


    jQuery.ajax({
        url: ctx + "/data/cart",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                goodsIds[i] = data.goodsTransport.id;
            }
        },
        error: function () {
            $errorMessageSpan.text("Problem with getting cart");
        }
    });

    jQuery(".back-cart-btn").click(function () {
        window.location.href=ctx+"/cart";
    })

    jQuery(".order-btn").click(function () {
        var order = {};

        var deliveryMethod = jQuery(".delivery-method:checked").val();
        var paymentMethod = jQuery(".payment-method:checked").val();


        order.goodsIds = goodsIds;
        order.paymentMethod = paymentMethod;
        order.deliveryMethod = deliveryMethod;
        order.paymentStatus = "NOTPAYED";
        order.status = "INIT";
        order.clientId = account.id;

        jQuery.ajax({
            url: ctx + "/data/orders",
            type: "POST",
            data: JSON.stringify(order),
            dataType: "json",
            contentType: "application/json",
            success: function () {
                //clear the cart
                jQuery.ajax({
                    url: ctx + "/data/cart",
                    type: "DELETE"
                })
                //todo change quantity for goods
                //or should i do it in the service
                window.location.href = ctx + "/goods";
            },
            error: function () {
                $errorMessageSpan.text("Problem with ordering");
            }
        })
    })


})()