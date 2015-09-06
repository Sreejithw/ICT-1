<<<<<<< HEAD
$.get("getitem", function (data) {
    var items = JSON.parse(data);
    for (i = 0; i < items.length; i++) {
$("#arrival").append('\
<div class="product_item type_3">\
  <div class="image_wrap">\
    <img src="images/product_img_24.jpg" alt="">\
    <div class="actions_wrap">\
      <button onclick="icp.wish(' + items[i][0] + ')" class="button_dark_grey def_icon_btn middle_btn add_to_wishlist tooltip_container alignleft">\
        <span class="tooltip right">Add to Wishlist</span>\
      </button>\
      <button class="button_black def_icon_btn middle_btn quick_view_product tooltip_container align_center" data-modal-url="view?id=' + items[i][0] + '">\
        <span class="tooltip top">Quick View</span>\
      </button>\
      <button onclick="icp.cart.add(' + items[i][0] + ')" class="button_blue def_icon_btn middle_btn add_to_cart tooltip_container alignright">\
        <span class="tooltip left">Add to Cart</span>\
      </button>\
    </div>\
  </div>\
  <div class="label_new">New</div>\
  <div class="description">\
    <a href="product?id=' + items[i][0] + '">' + items[i][1] + '</a>\
    <div class="clearfix product_info">\
      <p class="product_price alignleft"><b>$' + items[i][2] + '</b></p>\
    </div>\
  </div>\
</div>');
        
    }

});
=======
$.get("getitem", function (data) {
    var items = JSON.parse(data);
    for (i = 0; i < items.length; i++) {
$("#arrival").append('\
<div class="product_item type_3">\
  <div class="image_wrap">\
    <img src="images/product_img_24.jpg" alt="">\
    <div class="actions_wrap">\
      <button onclick="icp.wish(' + items[i][0] + ')" class="button_dark_grey def_icon_btn middle_btn add_to_wishlist tooltip_container alignleft">\
        <span class="tooltip right">Add to Wishlist</span>\
      </button>\
      <button class="button_black def_icon_btn middle_btn quick_view_product tooltip_container align_center" data-modal-url="view?id=' + items[i][0] + '">\
        <span class="tooltip top">Quick View</span>\
      </button>\
      <button onclick="icp.cart.add(' + items[i][0] + ')" class="button_blue def_icon_btn middle_btn add_to_cart tooltip_container alignright">\
        <span class="tooltip left">Add to Cart</span>\
      </button>\
    </div>\
  </div>\
  <div class="label_new">New</div>\
  <div class="description">\
    <a href="product?id=' + items[i][0] + '">' + items[i][1] + '</a>\
    <div class="clearfix product_info">\
      <p class="product_price alignleft"><b>$' + items[i][2] + '</b></p>\
    </div>\
  </div>\
</div>');
        
    }

});
>>>>>>> upstream/master
