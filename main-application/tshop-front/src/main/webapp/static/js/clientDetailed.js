/**
 * Created by Роднуля on 12.04.2017.
 */
(function () {
    var $errorMessageSpan = jQuery("#errorMessage");
    var clienId = jQuery(".client-id").val();

    jQuery.ajax({
        url: [ctx, "/data/clients/", clienId].join(""),
        success: function (data) {

            jQuery(".account-name").val(data.accountTransport.name);
            jQuery(".account-surname").val(data.accountTransport.surname);
            jQuery(".account-login").val(data.accountTransport.login);
            jQuery(".account-password").val(data.accountTransport.password);
            jQuery(".account-email").val(data.accountTransport.email);
            jQuery(".account-birthday").val(data.accountTransport.birthday);

            jQuery(".address-country").val(data.addressTransport.country);
            jQuery(".address-city").val(data.addressTransport.city);
            jQuery(".address-postcode").val(data.addressTransport.postcode);
            jQuery(".address-street").val(data.addressTransport.street);
            jQuery(".address-home").val(data.addressTransport.home);
            jQuery(".address-flat").val(data.addressTransport.flat);

        },
        error: function () {
            $errorMessageSpan.text("can't get client");
        }
    })


})()