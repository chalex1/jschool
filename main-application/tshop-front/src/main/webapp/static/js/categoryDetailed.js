/**
 * Created by Роднуля on 10.04.2017.
 */
(function () {

    var errorMessageDiv = jQuery("#errorMessage");

    var $categoryId = jQuery(".category-id");
    var $categoryName = jQuery(".category-name");
    var categoryIdVal = $categoryId.val();
    jQuery.ajax({
        url: ctx + "/data/categories/" + categoryIdVal,
        success: function (data) {
            $categoryName.val(data.name);
        },
        error: function () {
            errorMessageDiv.text("Category can't be edited");
        }
    });

    jQuery(".cancel-save-btn").click(function () {
        window.location.href = ctx+"/categories";
    })

    jQuery(".save-category-btn").click(function () {
        var categoryNameVal = $categoryName.val();
        if (!categoryNameVal) {
            errorMessageDiv.text("Category name can't be empty");
        } else {
            jQuery.ajax({
                url: ctx + "/data/categories",
                data: JSON.stringify(
                    {
                        id: categoryIdVal,
                        name: categoryNameVal
                    }
                ),
                type: "PUT",
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    window.location.href = ctx + "/categories";
                },
                error: function (error) {
                    errorMessageDiv.text("Problem with saving category");
                }
            });
        }


    })
})()