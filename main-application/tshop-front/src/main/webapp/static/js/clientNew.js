/**
 * Created by Роднуля on 08.05.2017.
 */
(function () {
    var $errorMessageSpan = jQuery("#errorMessage");
    var pathToGo = jQuery(".path-to-go").val();
    if(!pathToGo){
        pathToGo="/goods"
    }

    jQuery(".client-save-btn").click(function () {
        var client = {}, account = {}, address = {};
        var valid = true;
        client.addressTransport = address;
        client.accountTransport = account;


        account.name = jQuery(".account-name").val();
        account.surname = jQuery(".account-surname").val();
        account.login = jQuery(".account-login").val();
        if (!formValidator.validate("account-login", account.login, jQuery(".account-login"))) {
            valid = false;
        }

        account.password = jQuery(".account-password").val();
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

        if(valid){
            jQuery.ajax({
                url: ctx + "/data/clients",
                type: "POST",
                data: JSON.stringify(client),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    //let's try to sign in
                    jQuery.ajax({
                        url: ctx + "/login",
                        type: "POST",
                        data: {
                            "username": data.accountTransport.login,
                            "userpassword":data.accountTransport.password
                        },
                        success: function () {
                            window.location.href = ctx + pathToGo;
                        }
                    })

                },
                error: function (mes) {
                    if(mes.status ===422){
                        jQuery(".account-login").parent().addClass("has-error");
                        jQuery(".account-login").change(function () {
                            jQuery(".account-login").parent().removeClass("has-error");
                            $errorMessageSpan.text();
                        });
                        $errorMessageSpan.text("Login already in use! Please, try another one");
                    }else {
                        $errorMessageSpan.text(mes.responseText);
                    }
                }
            })
        }

    });


})()