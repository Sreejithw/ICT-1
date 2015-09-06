
icp.order = {};
icp.order.get = function () {
    var res = {};
    var ra = $("#addr").serializeArray().concat($("#ship_method").serializeArray());
    var i;
    for (i = 0; i < ra.length; i += 1) {
        res[ra[i].name] = ra[i].value;
    }
    return res;
}
icp.order.submit = function () {
    //console.log(icp.order.get());
    $.post("order", icp.order.get(), function (data) {
        console.log(data);
    });
};

icp.order = {};
icp.order.get = function () {
    var res = {};
    var ra = $("#addr").serializeArray().concat($("#ship_method").serializeArray());
    var i;
    for (i = 0; i < ra.length; i += 1) {
        res[ra[i].name] = ra[i].value;
    }
    return res;
}
icp.order.submit = function () {
    //console.log(icp.order.get());
    $.post("order", icp.order.get(), function (data) {
        console.log(data);
    });
};

