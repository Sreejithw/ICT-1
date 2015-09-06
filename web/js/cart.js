/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var cart = {};
cart.items = [];
cart.total = function () {
    var i = 0;
    var total = 0;
    for (i = 0; i < cart.items.length; i += 1) {
        total += cart.items[i][9];
    }
    return total;
};

cart.get = function () {
    $.get('cart?act=view', function (data) {
        var items = JSON.parse(data);
        cart.items = items;
        $('#subtotal').html('$'+cart.total());
        $('#total').html('$'+cart.total());
        var i = 0;
        var out = '';
        for (i = 0; i < items.length; i += 1) {
            out += '\
<tr id="r'+items[i][0]+'">\
  <td class="product_image_col" data-title="Product Image">\
    <a href="#"><img src="'+items[i][7]+'" alt=""></a>\
  </td>\
  <td data-title="Product Name">\
    <a href="#" class="product_title">'+items[i][4]+'</a>\
    <ul class="sc_product_info">\
      <li><b>Size:</b> '+items[i][3]+'</li>\
      <li><b>Color:</b> '+items[i][2]+'</li>\
      <li><b>Material:</b> '+items[i][1]+'</li>\
    </ul>\
  </td>\
  <td data-title="ID">'+items[i][5]+'</td>\
  <td class="subtotal" data-title="Price">$'+items[i][6]+'</td>\
  <td data-title="Quantity">\
    <div class="qty min clearfix">\
      <button class="theme_button" data-direction="minus" onclick="cart.add('+items[i][0]+','+i+',-1)">&#45;</button>\
      <input id="qty'+items[i][0]+'" type="text" name="" value="'+items[i][8]+'">\
      <button class="theme_button" data-direction="plus" onclick="cart.add('+items[i][0]+','+i+',1)">&#43;</button>\
  </div>\
  </td>\
  <td class="total" data-title="Total" id="total'+items[i][0]+'">$'+items[i][9]+'</td>\
  <td data-title="Action"><a href="javascript:;" onclick="cart.remove('+items[i][0]+')" class="button_dark_grey middle_btn">Delete</a></td>\
</tr>\
            ';
        }
        $('#clist').html(out);
    });
};


cart.remove = function (item) {
    $.post("cart", {"item": item, "qty": 0}, function (){
        document.getElementById('r'+item).innerHTML='';
        cart.get();
    });
};
cart.get();

cart.add = function (item,i,sign) {
    var qty=parseInt($('#qty'+item).val())+sign;
    icp.cart.add(item, qty);
    cart.items[i][9]=cart.items[i][6] * qty;
    $('#subtotal').html('$'+cart.total());
    $('#total').html('$'+cart.total());
    $('#total'+item).html('$'+cart.items[i][9]);
    if(qty === 0) {
        $('#r'+item).remove();
    }
};