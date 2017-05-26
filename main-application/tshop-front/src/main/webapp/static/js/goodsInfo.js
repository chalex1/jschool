/**
 * Created by Роднуля on 11.04.2017.
 */

(function () {


    var errorMessageSpan = jQuery("#errorMessage");
    var $categorySelectDiv = jQuery(".goods-categories");

    var $goodsId = jQuery(".goods-id");

    var goodsStructure = {};

    var goodsIdVal = $goodsId.val();


    jQuery.ajax({
        url: ctx + "/data/goods/structure",
        success: function (goods) {
            goodsStructure = goods;
        }
    });

    var initGoodsFormRefactored = function () {
        jQuery.ajax({
            url: ctx + "/data/goods/" + goodsIdVal,
            success: function (goods) {
                for (var prop in goods) {
                    var $field = jQuery(".goods-" + prop);
                    if ($field) {
                        $field.val(goods[prop]);
                    }
                }
                jQuery(".goods-categories select").val(goods.categories);
            }
        });
    };

    jQuery.ajax({
        url: ctx + "/data/categories",
        success: function (data) {
            createCategorySelect(data);
            // initGoodsForm();
            initGoodsFormRefactored();
        },
        error: function (error) {
            $errorMessageSpan.text("Problem with getting categories");
        }
    });

    jQuery(".goods-rtrn-btn").click(function () {
        window.location.href = ctx + "/goods";
    });


})()
