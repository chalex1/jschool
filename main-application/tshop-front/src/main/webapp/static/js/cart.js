/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {

    var $errorMessageSpan = jQuery("#errorMessage");
    var $cartDiv = jQuery(".cart");

    var $order = jQuery(".order-btn");



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


    //todo add swithch to order cart

    $order.click(function () {
        window.location.href = ctx + "/neworder";
        // var goodsIds = [];
        // var account = {};
        // var client = {};
        // jQuery.ajax({
        //     url: ctx + "/data/clients/current",
        //     success: function (data) {
        //         account = data.accountTransport;
        //         client = data;
        //         jQuery.ajax({
        //             url: ctx + "/data/cart",
        //             success: function (data) {
        //                 for (var i = 0; i < data.length; i++) {
        //                     goodsIds[i] = data[i].goodsTransport.id;
        //                 }
        //                 var order = {};
        //                 var deliveryMethod = "";
        //                 var paymentMethod = "";
        //                 order.goodsIds = goodsIds;
        //                 order.paymentMethod = paymentMethod;
        //                 order.deliveryMethod = deliveryMethod;
        //                 order.paymentStatus = "";
        //                 order.status = "INIT";
        //                 order.clientId = client.id;
        //
        //                 jQuery.ajax({
        //                     url: ctx + "/data/orders",
        //                     type: "POST",
        //                     data: JSON.stringify(order),
        //                     dataType: "json",
        //                     contentType: "application/json",
        //                     success: function (data) {
        //                         //clear the cart
        //                         jQuery.ajax({
        //                             url: ctx + "/data/cart",
        //                             type: "DELETE"
        //                         })
        //                         window.location.href = ctx + "/neworder?id="+data.id;
        //                         // window.location.href = ctx + "/goods";
        //                     },
        //                     error: function (mes) {
        //                         if(mes.status ===422){
        //
        //                             $errorMessageSpan.text("Sorry,  looks like we re out of this product.");
        //                             //and
        //                             //clear the cart
        //                             jQuery.ajax({
        //                                 url: ctx + "/data/cart",
        //                                 type: "DELETE"
        //                             })
        //                         }else {
        //                             $errorMessageSpan.text(mes.responseText);
        //                         }
        //                         $errorMessageSpan.text("Problem with ordering");
        //                     }
        //                 })
        //             },
        //             error: function () {
        //                 $errorMessageSpan.text("Problem with getting cart");
        //             }
        //         });
        //     }
        // });

    });


})()