/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {

    var $errorMessageSpan = jQuery("#errorMessage");
    var goodsIds = [];
    var account = {};
    var client = {};
    var order = {};
    var orderid = "";//jQuery(".order-id").val();
    // var $payButton = jQuery(".pay-by-card");


    // jQuery(".payment-method").click(function () {
    //     if (jQuery(".payment-method:checked").val() === "CARD") {
    //         $payButton.removeClass("disabled");
    //     }
    //     else $payButton.addClass("disabled");
    // });

    //discarting order
    var initDiscartBtn = function () {
        jQuery(".discart-order-btn").click(function () {
            jQuery.ajax({
                url: ctx + "/data/orders/" + orderid,
                type: "DELETE",
                success: function (data) {
                    window.location.href = ctx + "/goods";
                },
                error: function () {
                    $errorMessageSpan.text("Problem discarting order");
                }
            });
        });
    };



    var initOrderBtn = function () {
        jQuery(".order-btn").click(function () {
            var deliveryMethod = jQuery(".delivery-method:checked").val();
            var paymentMethod = jQuery(".payment-method:checked").val();
            order.paymentMethod = paymentMethod;
            order.deliveryMethod = deliveryMethod;
            order.paymentStatus = "";
            if (order.status !== "PAID")
                order.status = "PROCESS";

            order.clientId = client.id;

            jQuery.ajax({
                url: ctx + "/data/orders",
                type: "PUT",
                data: JSON.stringify(order),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    var to = "/orderinfo?id=";
                    if(data.paymentMethod==="CARD"){
                        to="/payment?id=";
                    }
                    window.location.href = ctx + to + orderid;
                },
                error: function (mes) {
                    $errorMessageSpan.text("Problem with saving order");
                }
            })
        });
    };

    // var initPayBtn = function () {
    //     $payButton.click(function () {
    //         //if Ok
    //         //
    //         // order.status = "PAID";
    //         // jQuery.ajax({
    //         //     url: ctx + "/data/orders",
    //         //     type: "PUT",
    //         //     data: JSON.stringify(order),
    //         //     dataType: "json",
    //         //     contentType: "application/json",
    //         //     success: function () {
    //         //         // window.location.href = ctx + "/orderdetailed?id=" + orderid;
    //         //     },
    //         //     error: function (mes) {
    //         //         $errorMessageSpan.text("Problem with saving order");
    //         //     }
    //         // });
    //
    //         ipayCheckout({
    //                 amount: 500,
    //                 currency: 'RUB',
    //                 order_number: order.id,
    //                 description: 'desc'
    //             },
    //             function (order) {
    //                 alert('success')
    //
    //             },
    //             function (order) {
    //                 alert('failure')
    //             });
    //     });
    // };

    jQuery.ajax({
        url: ctx + "/data/clients/current",
        success: function (data) {
            account = data.accountTransport;
            client = data;
            jQuery.ajax({
                url: ctx + "/data/cart",
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        goodsIds[i] = data[i].goodsTransport.id;
                    }
                    var newOrder = {};
                    var deliveryMethod = "";
                    var paymentMethod = "";
                    newOrder.goodsIds = goodsIds;
                    newOrder.paymentMethod = paymentMethod;
                    newOrder.deliveryMethod = deliveryMethod;
                    newOrder.paymentStatus = "";
                    newOrder.status = "INIT";
                    newOrder.clientId = client.id;

                    jQuery.ajax({
                        url: ctx + "/data/orders",
                        type: "POST",
                        data: JSON.stringify(newOrder),
                        dataType: "json",
                        contentType: "application/json",
                        success: function (data) {
                            order = data;
                            orderid = data.id;
                            //init everything else

                            initDiscartBtn();
                            // initPayBtn();
                            initOrderBtn();
                            //clear the cart
                            jQuery.ajax({
                                url: ctx + "/data/cart",
                                type: "DELETE"
                            });
                        },
                        error: function (mes) {
                            if (mes.status === 422) {

                                $errorMessageSpan.text("Sorry,  looks like we re out of this product.");
                                //and
                                //clear the cart
                                jQuery.ajax({
                                    url: ctx + "/data/cart",
                                    type: "DELETE"
                                })
                            } else {
                                $errorMessageSpan.text(mes.responseText);
                            }
                            $errorMessageSpan.text("Problem with ordering");
                        }
                    })
                },
                error: function () {
                    $errorMessageSpan.text("Problem with getting cart");
                }
            });
        }
    });

    // jQuery.ajax({
    //     url: ctx + "/data/clients/current",
    //     success: function (data) {
    //         account = data.accountTransport;
    //         client = data;
    //     }
    // });


    // jQuery.ajax({
    //     url: ctx + "/data/orders/" + orderid,
    //     success: function (data) {
    //         order = data;
    //     },
    //     error: function () {
    //         $errorMessageSpan.text("Problem with getting order detailed");
    //     }
    // });


})()