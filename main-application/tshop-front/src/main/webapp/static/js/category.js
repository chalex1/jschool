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
        var $table = jQuery("<table class='table '></table>");
        $table.append(jQuery("<tr><td>Category name</td><td></td><td></td></tr>"));
        for (var i = 0; i < categories.length; i++) {
            var row = jQuery("<tr></tr>");

            var rbody = jQuery(["<td><a href='",
                detailedUrl,
                categories[i].id,
                "'>", categories[i].name, "</a></td>"].join(""));
            row.append(rbody);
            var rdeletebtn = jQuery("<input type='button' class='btn btn-default' value='Delete'/>")
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
            row.append(jQuery("<td></td>").append(rdeletebtn));
            $table.append(row);
        }
        jQuery(".categories").append($table);
    };

    jQuery.ajax({
        url: ctx + "/data/categories",
        success: function (data) {
            createCategoriesList(data);
        },
        error: function (error) {
            errorMessageDiv.text("Problem with getting categories");
        }
    });
})()