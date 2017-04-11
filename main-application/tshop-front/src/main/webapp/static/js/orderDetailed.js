/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {
    var orderid = jQuery(".order-id").val();


    jQuery.ajax({
        url: ctx+"/data/orders?id="+orderid,
        success: function (data) {
            jQuery(".order-payment-method option").each(function () {
                var $elem = jQuery(this);
                if($elem.val()===data.paymentMethod){
                    $elem.attr("selected", true);
                }
            });
            jQuery(".order-delivery-method option").each(function () {
                var $elem = jQuery(this);
                if($elem.val()===data.deliveryMethod){
                    $elem.attr("selected", true);
                }
            });
            jQuery(".order-payment-status option").each(function () {
                var $elem = jQuery(this);
                if($elem.val()===data.paymentStatus){
                    $elem.attr("selected", true);
                }
            });
            jQuery(".order-status option").each(function () {
                var $elem = jQuery(this);
                if($elem.val()===data.orderStatus){
                    $elem.attr("selected", true);
                }
            });

        },
        failure: function () {

        }
    });
})()