/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var icp = {};
icp.account = function (data) {
    if (data !== "") {
        $("#account").html("Welcome " + data + '!<br /><a href="javascript:;" onclick="icp.logout()"> Logout </a>')
    } else {
        $("#account").html('Welcome visitor <a href="#" data-modal-url="modals/login.html">Login</a> or <a href="#" data-modal-url="modals/register.html">Register</a>');
    }
};

icp.logout = function () {
    $.get("login?act=logout", icp.account);
};

icp.onlogin = function () {

};

icp.login = function () {
    var form = {
        "user_email": $("#user_email").val(),
        "user_password": $("#user_password").val()
    };
    $.post("login", form, function (data) {
        var res = JSON.parse(data);
        if (res.length === 2) {
            icp.account(res[1]);
            $("#closeLogin").trigger("click");
            icp.onlogin();
        } else {
            $("#logWarn").html("<b>Notice:</b> Email or password is incorrect");
        }
    });
};
icp.regis = function () {
    if ($("#pwd").val() === $("#rpwd").val()) {
        var form = {
            "user_email": $("#email").val(),
            "user_password": $("#pwd").val(),
            "user_fname": $("#fName").val(),
            "user_lname": $("#lName").val()
        }
        console.log(form);
        $.post("Register", form, function (data) {
            //console.log(data);
            $('#closeReg').trigger("click");
            $.post("login", form, function (data1) {
                var res = JSON.parse(data1);
                console.log(res);
                icp.account(res[1]);
                icp.onlogin();
            });
        });

    } else {
        alert("The information is incorrect");

    }
}

icp.reg = function () {
    var form = $("#regForm").serialize();
    //$.post("reg", {}, function (data) {
    //    var res = JSON.parse(data);
    //    if (res[0] === "OK") {
    //        $("#closeReg").trigger("click");
    //    } else {
    //        $("#regWarn").html(res[1]);
    //    }
    //});
}
icp.cart = {};

icp.cart.add = function (item, qty) {
    $.post("cart", {"item": item, "qty": qty}, function (data) {
        console.log(data);
        if (data === "invuser") {
            alert("Please login or register!");
        }
        $("#cart").html("");
        icp.cart.get();
        alert('Your item has been added to cart successfully!');
    });
};

icp.cart.rm = function (item) {
    icp.cart.add(item, 0);
}


icp.cart.get = function () {
    $.get("cart", function (data) {
        
        var items = JSON.parse(data);
        
        var total = 0;
        var discount = 0;
        var i = 0;
        for (i = 0; i < items.length; i++) {
            $("#cart").append(' \
            <div class="animated_item"><div class="clearfix sc_product"> \
              <a href="product?id=' + items[i][0] + '" class="product_thumb"><img height="50" width="50" src="' + items[i][3] + '" alt=""></a> \
              <a href="product?id=' + items[i][0] + '" class="product_name">' + items[i][1] + '</a> \
              <p>$' + items[i][2] + '</p>\
              <button onclick="icp.cart.rm(' + items[i][4] + ')" class="close"></button> \
            </div></div>\
            ');
            total += items[i][2] * items[i][6];
            discount += items[i][2] * items[i][5] / 100 * items[i][6];

        }
        $('#discount').html('$'+discount)
        $('.total_price').html('$' + total);
        $('#open_shopping_cart').attr('data-amount', i)
    });
};

icp.cart.clear = function () {
    $.post('cart', {act:'clear'});
    icp.cart.get()
    
};

icp.wish = function (item) {
    var i = {};

    i.item = item;
    $.post("wishlist", i, function (data) {
        if(data==='invuser') {
            alert('Please login or register to addd this item to wish list!');
        }else{
            alert('Your item has been added to wish list successfully!');
        }
        icp.wishNum();
        
    });
};

$.get("login", icp.account);
icp.cart.get();
var sel = {};
sel.btnOff = 'button_dark_grey small_btn';
sel.btnOn = "button_blue small_btn";
sel.getNum = function (num) {
    return function () {
        return num;
    };
}
sel.constHTML = function (val) {
    var i = 0;
    var str = '';
    for (i = 0; i < val.length; i += 1) {
        str += '<button style="margin:5px" class="' + sel.btnOff + '" value="' + val[i] + '">' + val[i] + '</button>';
    }
    var e = $(str);
    e.click(function (event) {
        e.attr("class", sel.btnOff);
        $(event.target).attr("class", sel.btnOn);
        //console.log($(event.target).attr("value"));
    });
    return e;
};

$.get("category?gender=Men", function (data) {
    var c = JSON.parse(data);
    var i = 0;
    for (i = 0; i < c.length; i += 1) {
        $('#mens').append('<li><a onclick="location.reload()" href="category.shtml#Men_' + c[i] + '" class="all cat"><b>' + c[i] + '</b></li>');
    }

});
$.get("category?gender=Women", function (data) {
    var c = JSON.parse(data);
    var i = 0;
    for (i = 0; i < c.length; i += 1) {
        $('#womens').append('<li><a onclick="location.reload()" href="category.shtml#Women_' + c[i] + '" class="all cat"><b>' + c[i] + '</b></li>');
    }

});

icp.item = {};

icp.item.list = [];

icp.item.id = 0;


icp.item.getDistint = function (a, index) {
    var res = [];
    var i = 0;
    for (i = 0; i < a.length; i += 1) {
        if (res.indexOf(a[i][index]) === -1) {
            res.push(a[i][index]);
        }
    }
    return res;
}


icp.item.get = function (id) {
    $.get("item?product=" + id, function (data) {
        icp.item.list = JSON.parse(data);
        var materials = icp.item.getDistint(icp.item.list, 2);
        //console.log(icp.item.filter(icp.item.list, materials[0], 2));
        var mBtn = sel.constHTML(materials).click(function (e) {
            var val = $(e.target).attr("value");
            icp.item.getColor(icp.item.list, val);
        });
        $(mBtn[0]).trigger('click');
        $('#material').append(mBtn);
    });
};

icp.item.getColor = function (data, m) {
    var items = icp.item.filter(data, m, 2);
    var colors = icp.item.getDistint(items, 1);
    var mBtn = sel.constHTML(colors).click(function (e) {
        var c = $(e.target).attr("value");
        icp.item.getSize(items, c);
    });
    $('#color').html('');
    $(mBtn[0]).trigger('click');
    $('#color').append(mBtn);

};

icp.item.getSize = function (data, val) {
    var itm = icp.item.filter(data, val, 1);
    var size = icp.item.getDistint(itm, 4);
    var mBtn = sel.constHTML(size).click(function (e) {
        var s = $(e.target).attr("value");
        var i;
        for (i = 0; i < itm.length; i += 1) {
            if (s === itm[i][4]) {
                icp.item.id = itm[i][0];
            }
        }
    });
    $('#size').html('');
    $(mBtn[0]).trigger('click');
    $('#size').append(mBtn);
};

icp.item.filter = function (a, name, index) {
    var res = [];
    var i = 0;
    for (i = 0; i < a.length; i += 1) {
        if (a[i][index] === name) {
            res.push(a[i]);
        }
    }
    return res;
};

icp.cart.submit = function () {
    var item = icp.item.id;
    var qty = $('#qty').val();
    icp.cart.add(item, qty);
};

icp.wishNum = function () {
    $.get('info', function (data) {
        var info=JSON.parse(data);
        $('.wishlist_button').attr('data-amount', info['wishlist']);
    });
};

icp.wishNum();