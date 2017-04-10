/**
 * Created by Роднуля on 08.04.2017.
 */
(function () {

    var errorMessageDiv = jQuery("#errorMessage");
    jQuery(".addNewCategoryBtn").click(function () {
        window.location.href = ctx + "/newcategory";
    });

    var createCategoriesList = function (categories) {

        var detailedUrl = ctx + "/categorydetailed?id=";
        for (var i = 0; i < categories.length; i++) {
            var row = jQuery("<div></div>");
            var strhtml = [];
            strhtml.push(
                "<a href='",
                detailedUrl,
                categories[i].id,
                "'>", categories[i].name, "</a>"
            );
            var rbody = jQuery(strhtml.join(""));
            row.append(rbody);
            var rdeletebtn = jQuery("<input type=button value='Delete'/>")
            rdeletebtn.click(i,function (e) {
                 jQuery.ajax({
                    url: ctx + "/data/categories?id=" + categories[e.data].id,
                    method: "DELETE",
                    success: function (data) {
                        window.location.href = ctx + "/categories";
                    },
                    failure: function (error) {
                        errorMessageDiv.text("Problem with deleting categories");
                    }
                });
            });
            row.append(rdeletebtn);
            jQuery(".categories").append(row);
        }
    };

    jQuery.ajax({
        url: ctx + "/data/categories",
        success: function (data) {
            createCategoriesList(data);
        },
        failure: function (error) {
            errorMessageDiv.text("Problem with getting categories");
        }
    });
})()