/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


icp.revArray = function () {
    return $("#rating").serializeArray();
}
icp.revObj = function (id) {
    var res = {};
    var ra = icp.revArray();
    var i;
    for (i = 0; i < ra.length; i += 1) {
        res[ra[i].name] = ra[i].value;
    }
    res["item"] = id;
    return res;
}
icp.sendRev = function () {
    $.post("review", icp.revObj(), function (data) {
        if (data === "invuser") {
            alert("Please login or register to review.");
        }
        if (data === "invrate") {
            alert("Please rate the product :)");
        }
        if (data === "invtext") {
            alert("Please tell us your feedback :)");
        }
        if (data === "invtitle") {
            alert("Please write a title.");
        }
        icp.getReview();
    });
}
String.prototype.repeat = function (num) {
    return new Array(num + 1).join(this);
}
//var icp = {};
icp.rate = function (rate) {
    return "<li class=\"active\"></li>".repeat(rate) + "<li></li>".repeat(5 - rate);
}
icp.getReview = function (id) {
    $.get("review?item=" + id, function (data) {
        //console.log(data);
        var items = JSON.parse(data);
        $(".reviews").html("");
        for (i = 0; i < items.length; i++) {
            //console.log(items[i]);
            var price = items[i][4];
            var value = items[i][5];
            var quality = items[i][6];
            $(".reviews").append("\
            <li>\
                <article class=\"review\">\
                    <ul class=\"review-rates\">\
                        <li class=\"v_centered\">\
                            <span class=\"name\">Price</span>\
                            <ul class=\"rating\">"
                    + icp.rate(price) +
                    "</ul>\
                        </li>\
                        <li class=\"v_centered\">\
                            <span class=\"name\">Value</span>\
                            <ul class=\"rating\">"
                    + icp.rate(value) +
                    "</ul>\
                        </li>\
                        <li class=\"v_centered\">\
                            <span class=\"name\">Quality</span>\
                            <ul class=\"rating\">"
                    + icp.rate(quality) +
                    "</ul>\
                        </li>\
                    </ul>\
                    <div class=\"review-body\">\
                        <div class=\"review-meta\">\
                            <h5 class=\"bold\">" + items[i][2] + "</h5>\
                            Review by <a href=\"#\" class=\"bold\">" + items[i][1] + "</a> on " + items[i][3] + "\
                        </div>\
                        <p>" + items[i][7] + "</p>\
                    </div>\
                </article>\
            </li>"

                    );
        }
    });
}
icp.getReview();

icp.revArray = function () {
    return $("#rating").serializeArray();
}
icp.revObj = function (id) {
    var res = {};
    var ra = icp.revArray();
    var i;
    for (i = 0; i < ra.length; i += 1) {
        res[ra[i].name] = ra[i].value;
    }
    res["item"] = id;
    res["title"] = $("#summary").val();
    res["content"] = $("#review_message").val();
    return res;
}
icp.sendRev = function (id) {
    $.post("review", icp.revObj(id), function (data) {
        if (data === "invuser") {
            alert("Please login or register to review.");
        } else if (data === "invrate") {
            alert("Please rate the product :)");
        } else if (data === "invtext") {
            alert("Please tell us your feedback :)");
        } else if (data === "invtitle") {
            alert("Please write a title.");
        } else {
            icp.getReview(id);
        }
    });
}
String.prototype.repeat = function (num) {
    return new Array(num + 1).join(this);
}
//var icp = {};

icp.rate = function (rate) {
    return "<li class=\"active\"></li>".repeat(rate) + "<li></li>".repeat(5 - rate);
}
icp.avgRate = 0;
icp.getReview = function (id) {
    $.get("review?item=" + id, function (data) {
        //console.log(data);
        var items = JSON.parse(data);
        $(".reviews").html("");
        icp.avgRate = 0;
        if (items.length > 0) {
            for (i = 0; i < items.length; i++) {
                //console.log(items[i]);
                var price = items[i][4];
                var value = items[i][5];
                var quality = items[i][6];
                icp.avgRate += (price + value + quality) / 3;
                $(".reviews").append("\
            <li>\
                <article class=\"review\">\
                    <ul class=\"review-rates\">\
                        <li class=\"v_centered\">\
                            <span class=\"name\">Price</span>\
                            <ul class=\"rating\">"
                        + icp.rate(price) +
                        "</ul>\
                        </li>\
                        <li class=\"v_centered\">\
                            <span class=\"name\">Value</span>\
                            <ul class=\"rating\">"
                        + icp.rate(value) +
                        "</ul>\
                        </li>\
                        <li class=\"v_centered\">\
                            <span class=\"name\">Quality</span>\
                            <ul class=\"rating\">"
                        + icp.rate(quality) +
                        "</ul>\
                        </li>\
                    </ul>\
                    <div class=\"review-body\">\
                        <div class=\"review-meta\">\
                            <h5 class=\"bold\">" + items[i][2] + "</h5>\
                            Review by <a href=\"#\" class=\"bold\">" + items[i][1] + "</a> on " + items[i][3] + "\
                        </div>\
                        <p>" + items[i][7] + "</p>\
                    </div>\
                </article>\
            </li>"

                        );
            }
            icp.avgRate = Math.round(icp.avgRate / items.length);
            $("#avgRate").html(icp.rate(icp.avgRate));
            $(".reviewNum").html(items.length);
        } else {
            icp.avgRate = 0;
            $("#avgRate").html(icp.rate(0));
            $(".reviewNum").html(0);
        }
    });
};
