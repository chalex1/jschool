/**
 * Created by Роднуля on 09.04.2017.
 */
(function () {

    var errorMessageDiv = jQuery("#errorMessage");

    jQuery(".cancel-save-btn").click(function () {
        window.location.href = ctx + "/categories";
    })


    jQuery(".sendnewcategorybtn").click(function () {
        var newCategory = jQuery(".newcategory").val();

        if (!newCategory || newCategory.trim().length === 0) {
            errorMessageDiv.text("Category name can't be empty");
        } else {
            jQuery.ajax({
                url: ctx + "/data/categories",
                data: JSON.stringify({name: newCategory}),
                type: "POST",
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    window.location.href = ctx + "/categories";
                },
                error: function (error) {
                    errorMessageDiv.text("Problem with creating new category");
                }
            });
        }
    })
})()