/**
 * Created by Роднуля on 11.04.2017.
 */

(function () {

    var errorMessageSpan = jQuery("#errorMessage");
    var $categorySelectDiv = jQuery(".goods-categories");

    var $goodsId = jQuery(".goods-id");

    var goodsIdVal = $goodsId.val();

    var createCategorySelect = function (categories) {
        var $select = jQuery("<select class='goods-categories-select form-control'></select>").attr("multiple", true);
        for (var i = 0; i < categories.length; i++) {
            $select.append(jQuery("<option value='" + categories[i].id + "'></option>").text(categories[i].name));
        }

        $categorySelectDiv.append($select);
    }

    var initGoodsForm = function () {
        jQuery.ajax({
            url: ctx + "/data/goods/" + goodsIdVal,
            success: function (goods) {
                jQuery(".goods-name").val(goods.name);
                jQuery(".goods-price").val(goods.price);
                jQuery(".goods-brand").val(goods.parameter1);
                jQuery(".goods-colour").val(goods.parameter2);
                jQuery(".goods-info").val(goods.parameter3);
                jQuery(".goods-weight").val(goods.weight);
                jQuery(".goods-volume").val(goods.volume);
                jQuery(".goods-quantity").val(goods.quantity);
                jQuery(".goods-categories select").val(goods.categories);
            }
        });
    }

    jQuery.ajax({
        url: ctx + "/data/categories",
        success: function (data) {
            createCategorySelect(data);
            initGoodsForm();
        },
        error: function (error) {
            $errorMessageSpan.text("Problem with getting categories");
        }
    });

    jQuery(".goods-rtrn-btn").click(function () {
        window.location.href = ctx + "/goods";
    })

    jQuery(".goods-save-btn").click(function () {
        var goods = {};
        goods.id= goodsIdVal;
        goods.name = jQuery(".goods-name").val();
        goods.price = jQuery(".goods-price").val();
        goods.parameter1 = jQuery(".goods-brand").val();
        goods.parameter2 = jQuery(".goods-colour").val();
        goods.parameter3 = jQuery(".goods-info").val();
        goods.weight = jQuery(".goods-weight").val();
        goods.volume = jQuery(".goods-volume").val();
        goods.quantity = jQuery(".goods-quantity").val();
        goods.categories = [];
        $categorySelectDiv.find("option:selected").each(function (i) {
            goods.categories[i] = jQuery(this).val();
        });

        jQuery.ajax({
            url: ctx + "/data/goods",
            type: "POST",
            data: JSON.stringify(goods),
            dataType: "json",
            contentType: "application/json",
            success: function () {
                window.location.href = ctx + "/goods";
            },
            error: function () {
                $errorMessageSpan.text("Problem with saving goods");
            }
        });

    });

})()
