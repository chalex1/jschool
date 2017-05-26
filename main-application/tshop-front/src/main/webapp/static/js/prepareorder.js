/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {

    var $errorMessageSpan = jQuery("#errorMessage");
    var goodsIds = [];
    var account = {};
    var client = {};
    var order = {};
    var orderid = jQuery(".order-id").val();
    var $payButton = jQuery(".pay-by-card");

    jQuery.ajax({
        url: ctx + "/data/clients/current",
        success: function (data) {
            account = data.accountTransport;
            client = data;
        }
    });

    jQuery(".payment-method").click(function () {
        if (jQuery(".payment-method:checked").val() === "CARD") {
            $payButton.removeClass("disabled");
        }
        else $payButton.addClass("disabled");
    })


    jQuery.ajax({
        url: ctx + "/data/orders/" + orderid,
        success: function (data) {
            order = data;
        },
        error: function () {
            $errorMessageSpan.text("Problem with getting order detailed");
        }
    });

    //discarting order
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
            success: function () {
                // jQuery.ajax({
                //     url: ctx+"/orderinfo",
                //     type: "POST",
                //     // contentType: 'application/x-www-form-urlencoded',
                //     // data:JSON.stringify({id: orderid})
                //     data:orderid
                // });
                 window.location.href = ctx + "/orderinfo?id=" + orderid;
            },
            error: function (mes) {
                $errorMessageSpan.text("Problem with saving order");
            }
        })
    });

    $payButton.click(function () {
        //if Ok
        //
        // order.status = "PAID";
        // jQuery.ajax({
        //     url: ctx + "/data/orders",
        //     type: "PUT",
        //     data: JSON.stringify(order),
        //     dataType: "json",
        //     contentType: "application/json",
        //     success: function () {
        //         window.location.href = ctx + "/orderdetailed?id=" + orderid;
        //     },
        //     error: function (mes) {
        //         $errorMessageSpan.text("Problem with saving order");
        //     }
        // });

        ipayCheckout({
                amount: 500,
                currency: 'RUB',
                order_number: order.id,
                description: 'desc'
            },
            function (order) {
                alert('success')
            },
            function (order) {
                alert('failure')
            });
    });
})()