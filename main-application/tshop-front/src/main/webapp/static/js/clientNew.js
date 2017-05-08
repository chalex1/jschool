/**
 * Created by Роднуля on 08.05.2017.
 */
(function () {
    var $errorMessageSpan = jQuery("#errorMessage");

    jQuery(".client-save-btn").click(function () {
        var client = {}, account = {}, address = {};
        client.addressTransport = address;
        client.accountTransport = account;


        account.name = jQuery(".account-name").val();
        account.surname = jQuery(".account-surname").val();
        account.login = jQuery(".account-login").val();
        account.password = jQuery(".account-password").val();
        account.email = jQuery(".account-email").val();
        account.birthday = jQuery(".account-birthday").val();
        account.type = "CLIENT";


        address.country = jQuery(".address-country").val();
        address.city = jQuery(".address-city").val();
        address.postcode = jQuery(".address-postcode").val();
        address.street = jQuery(".address-street").val();
        address.home = jQuery(".address-home").val();
        address.flat = jQuery(".address-flat").val();

        if(account.login&&account.password){
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
                            //todo redirect to the proper page
                            alert("should redirect then ")
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