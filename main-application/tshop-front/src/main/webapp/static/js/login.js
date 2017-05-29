/**
 * Created by Роднуля on 29.05.2017.
 */
(function () {
    var previousPage = document.referrer;
    if(previousPage.indexOf("cart")>-1){
        var newLink = ctx+"/clientnew?path=neworder";
        jQuery(".linkOnNewAccount").prop("href", newLink);
    }


})()
