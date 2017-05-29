var formValidator = {};
(function () {
    validator = {};
    var checkOnEmpty = function (val) {
        var result = "";
        if (typeof val === "string" && val === '') {
            result = "this field can't be empty";
        }
        return result;
    };
    var checkOnLess10 = function (val) {
        var result = "";
        if (typeof val === "string" && val.length>9) {
            result = "the length should be less than 10";
        }
        return result;
    };

    var getCheckOnArr = function(jQueryelem){
        var res = [];
        var lokingIn = jQueryelem.attr("class").split(" ");
        for(var  i = 0; i<lokingIn.length; i++){
            if(lokingIn[i].indexOf("chk-")>-1){
                res.push(lokingIn[i].split("chk-").join(""));
            }
        }
        return res;
    };

    /**
     *
     * @param elementBodyName - the root of name form field or field in a transport object. jQuery looks for element with that name
     * @param elementVal - checking value
     * @param checkOnArr - checking methods array
     */
    formValidator.validate = function (elementBodyName, elementVal, jQel) {
        var validFlag = true;
        var checkOnArr = getCheckOnArr(jQel);
        var resultMessages = [];
        var $helperSpan = jQuery(".check-" + elementBodyName);
        if ($helperSpan.length) {
            $helperSpan.text("");
            $helperSpan.parent().removeClass("has-error");
            if (checkOnArr.length) {

                for (var i = 0; i < checkOnArr.length; i++) {
                    var res = "";
                    switch (checkOnArr[i]) {
                        case "notempty":
                            res = checkOnEmpty(elementVal);
                            break;
                        case "less10":
                            res = checkOnLess10(elementVal);
                            break;

                    }
                    if (res) {
                        validFlag = false;
                        resultMessages.push(res);
                    }
                }
            }
            if (resultMessages.length) {
                $helperSpan.text(resultMessages.join("; "));
                $helperSpan.parent().addClass("has-error");

            }
        }
        return validFlag;
    };


})()

