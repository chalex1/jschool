/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {

    var $errorMessageSpan = jQuery("#errorMessage");

    var orderid = jQuery(".order-id").val();
    var order = {};

    var saveOrder = function (corder, scss) {
        jQuery.ajax({
            url: ctx + "/data/orders",
            type: "PUT",
            data: JSON.stringify(corder),
            dataType: "json",
            contentType: "application/json",
            success: scss,
            error: function (mes) {
                $errorMessageSpan.text("Problem with saving order");
            }
        })

    };

    var discardOrder = function (corder) {
        jQuery.ajax({
            url: ctx + "/data/orders/" + corder.id,
            type: "DELETE",
            success: function (data) {
                window.location.href = ctx + "/goods";
            },
            error: function () {
                $errorMessageSpan.text("Problem discarting order");
            }
        });
    };


    jQuery.ajax({
        url: ctx + "/data/orders/" + orderid,
        success: function (data) {
            order = data;
            var goods = [];
            var price = 0;
            if (data.goodsRealPriceMap) {
                for (var ginorder in  data.goodsRealPriceMap) {
                    goods.push(ginorder);
                    price = price + data.goodsRealPriceMap[ginorder];
                }
            }

            ipayCheckout({
                    amount: price,
                    currency: 'RUB',
                    order_number: order.id,
                    description: goods.join(", ")
                },
                function () {
                    jQuery(".payment-status-header").text("The payment was succeed! Tnahk you!");
                    order.status = "PAID";
                    saveOrder(order, function () {
                        window.location.href = ctx + "/orderinfo?id=" + orderid;
                    });


                },
                function (o) {
                    jQuery(".payment-status-header").text("Probem with paying by card! ");
                    jQuery(".discard-btn").removeClass("hidden");
                    jQuery(".try-again-btn").removeClass("hidden");
                    jQuery(".pay-cash-btn").removeClass("hidden");
                    jQuery(".discard-btn").click(function () {
                        discardOrder(order);
                    });
                    jQuery(".try-again-btn").click(function () {
                        window.location.href = ctx + "/payment?id=" + orderid;
                    });
                    jQuery(".pay-cash-btn").click(function () {
                        order.paymentMethod = "CASH";
                        saveOrder(order, function () {
                            window.location.href = ctx + "/orderinfo?id=" + orderid;
                        });
                    });
                });


        },
        error: function () {
            $errorMessageSpan.text("Problem with getting order detailed");
        }
    });


})()