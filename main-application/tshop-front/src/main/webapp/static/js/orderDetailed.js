/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {
    var $errorMessageSpan = jQuery("#errorMessage");
    var orderid = jQuery(".order-id").val();
    var order = {};


    jQuery.ajax({
        url: ctx + "/data/orders/" + orderid,
        success: function (data) {
            order = data;
            jQuery(".order-payment-method option").each(function () {
                var $elem = jQuery(this);
                if ($elem.val() === data.paymentMethod) {
                    $elem.attr("selected", true);
                }
            });
            jQuery(".order-delivery-method option").each(function () {
                var $elem = jQuery(this);
                if ($elem.val() === data.deliveryMethod) {
                    $elem.attr("selected", true);
                }
            });
            // jQuery(".order-payment-status option").each(function () {
            //     var $elem = jQuery(this);
            //     if ($elem.val() === data.paymentStatus) {
            //         $elem.attr("selected", true);
            //     }
            // });
            jQuery(".order-status option").each(function () {
                var $elem = jQuery(this);
                if ($elem.val() === data.status) {
                    $elem.attr("selected", true);
                }
            });

        },
        error: function () {
            $errorMessageSpan.text("Problem with getting order detailed");
        }
    });

    <!--todo add goods list-->
    jQuery(".order-save-btn").click(function () {

       order.paymentMethod =  jQuery(".order-payment-method").val();
        order.deliveryMethod = jQuery(".order-delivery-method").val();
       // order.paymentStatus= jQuery(".order-payment-status").val();
       order.status =  jQuery(".order-status").val();

        jQuery.ajax({
            url: ctx + "/data/orders",
            type: "PUT",
            data: JSON.stringify(order),
            dataType: "json",
            contentType: "application/json",
            success: function () {
                window.location.href = ctx + "/orderinfo?id=" + orderid;
            },
            error: function (mes) {
                $errorMessageSpan.text("Problem with saving order");
            }
        });

    });
    jQuery(".goods-rtrn-btn").click(function () {
        window.location.href = ctx + "/orders";
    });
})()