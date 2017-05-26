/**
 * Created by Роднуля on 11.04.2017.
 */

(function () {


    var errorMessageSpan = jQuery("#errorMessage");
    var orderid = jQuery(".order-id").val();

    jQuery(".ok-btn").click(function () {
        window.location.href = ctx + "/goods";
    });

    jQuery.ajax({
        url: ctx + "/data/orders/" + orderid,
        success: function (data) {

            jQuery(".order-number").append(data.id);
            jQuery(".order-status").append(data.status);
            jQuery(".order-delivery").append(data.deliveryMethod);
            var address = "";
            if (data.deliveryMethod === "DELIVERY" && data.client.addressTransport) {
                var address = data.client.addressTransport;
                address = [address.country, address.city, address.postcode, address.street, address.home, address.flat].join("  ");
            }
            jQuery(".order-address").append(address);

            var goods = [];
            var price =0;
            if(data.goodsRealPriceMap){
               for(var ginorder in  data.goodsRealPriceMap){
                   goods.push(ginorder);
                   price = price+data.goodsRealPriceMap[ginorder];
               }
            }
            jQuery(".order-goods").append(goods.join(" "));
            jQuery(".order-price").append((!isNaN(price)&&price!=0)?price:"");


        },
        error: function () {
            $errorMessageSpan.text("Problem with getting order detailed");
        }
    });


})()
