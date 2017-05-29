(function () {

    var defaults = {
        api_token: "YRF3C5RFICWISEWFR6GJ", // public test token
        language: 'en'
    };

    var options = {};

    this.IPAY = function () {

        if (arguments[0] && typeof arguments[0] === "object") {
            options = extendDefaults(defaults, arguments[0]);
        }

        function extendDefaults(source, properties) {
            var property;
            for (property in properties) {
                if (properties.hasOwnProperty(property)) {
                    source[property] = properties[property];
                }
            }
            return source;
        }

    };

    this.ipayCheckout = function (order, successCallback, failureCallback) {

        var iframe = document.createElement('iframe');
        iframe.style.width = '390px';
        iframe.style.height = '415px';
        iframe.style.border = '0px';

        var orderStr = JSON.stringify(order);
        iframe.id = options.api_token;

        iframe.src = 'https://3dsec.sberbank.ru/demopayment/docsite/payform-1.html?token=' + options.api_token + '&modal=true&order=' + orderStr + "&language=" + (order.language ? order.language : options.language);

        var modal = new tingle.modal({
            footer: true,
            stickyFooter: false,
            onClose: function() {
                iframe.contentWindow.postMessage(JSON.stringify({'event':'closeModal'}), 'https://3dsec.sberbank.ru/demopayment/docsite');
                setTimeout(function () {
                    window.removeEventListener("message", gotEvent);
                }, 100);
            }
        });

        modal.setContent(iframe);
        modal.open();

        window.addEventListener("message", gotEvent);

        function gotEvent(e) {
            var data = JSON.parse(e.data);
            if (data.height) {
                iframe.style.height = data.height + 'px';
            } else if (data.status) {
                if (data.status == "DEPOSITED" || data.status == "APPROVED") {
                    modal.close();
                    window.removeEventListener("message", gotEvent);
                    successCallback(data);
                } else if (data.status == "DECLINED" || data.status == "CREATED"){
                    modal.close();
                    window.removeEventListener("message", gotEvent);
                    failureCallback(data);
                }
            } else {
                console.warn('Incorrect iframe message');
            }
        }

    };


})();
