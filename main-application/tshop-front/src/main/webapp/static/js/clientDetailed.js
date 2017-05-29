/**
 * Created by Роднуля on 12.04.2017.
 */
(function () {
    var $errorMessageSpan = jQuery("#errorMessage");
    var client = {}, account = {}, address = {};
    jQuery.ajax({
        url: [ctx, "/data/clients/current"].join(""),
        success: function (data) {
            client = data;
            account = data.accountTransport;
            address = data.addressTransport;

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
    });

    jQuery(".client-save-btn").click(function () {

        var valid = true;


        account.name = jQuery(".account-name").val();
        account.surname = jQuery(".account-surname").val();
        account.login = jQuery(".account-login").val().trim();
        if (!formValidator.validate("account-login", account.login, jQuery(".account-login"))) {
            valid = false;
        }

        account.password = jQuery(".account-password").val().trim();
        if (!formValidator.validate("account-password", account.password, jQuery(".account-password"))) {
            valid = false;
        }

        account.email = jQuery(".account-email").val();
        account.birthday = jQuery(".account-birthday").val();
        account.type = "CLIENT";


        address.country = jQuery(".address-country").val();
        address.city = jQuery(".address-city").val();
        address.postcode = jQuery(".address-postcode").val();
        address.street = jQuery(".address-street").val();
        address.home = jQuery(".address-home").val();
        address.flat = jQuery(".address-flat").val();

        if (valid) {//account.login&&account.password
            jQuery.ajax({
                url: ctx + "/data/clients",
                type: "PUT",
                data: JSON.stringify(client),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    window.location.href = ctx ;
                    //let's try to sign in
                    // jQuery.ajax({
                    //     url: ctx + "/login",
                    //     type: "POST",
                    //     data: {
                    //         "username": data.accountTransport.login,
                    //         "userpassword":data.accountTransport.password
                    //     },
                    //     success: function () {
                    //         //todo redirect to the proper page
                    //         alert("should redirect then ")
                    //     }
                    // })

                },
                error: function (mes) {
                    // if(mes.status ===422){
                    //     jQuery(".account-login").parent().addClass("has-error");
                    //     jQuery(".account-login").change(function () {
                    //         jQuery(".account-login").parent().removeClass("has-error");
                    //         $errorMessageSpan.text();
                    //     });
                    //     $errorMessageSpan.text("Login already in use! Please, try another one");
                    // }else {
                    $errorMessageSpan.text(mes.responseText);
                    // }
                }
            })
        }

    });


})()