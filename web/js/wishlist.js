$.get("wishlist", function (data) {
    var items = JSON.parse(data);
    var i = 0;
    for (i = 0; i < items.length; i++) {
        $("#wishlist").append('\
<tr id="item' + items[i][0] + '">\
  <td data-title="Product Image">\
    <img src="' + items[i][3] + '" alt="">\
  </td>\
  <td data-title="Product Name">\
    <a href="product?id=' + items[i][0] + '" class="product_title"></a><br><p><b>' + items[i][1] + '</b></p>\
  </td>\
  <td data-title="Price" class="total">$' + items[i][2] + '</td>\
  <td data-title="Action">\
    <ul class="buttons_col">\
      <li><a href="javascript:;" onclick="icp.rmwish(' + items[i][0] + ')" class="button_dark_grey">Remove</a></li>\
      <li><a href="product?id='+items[i][0]+'" class="button_blue middle_btn">Add to Cart</a></li>\
    </ul>\
  </td>\
</tr>\
');
    }
});
icp.rmwish = function (item) {
    $.post('wishlist',{item:item, act:'rm'})
    $("#item" + item).remove();
    $('.wishlist_button').attr('data-amount',$('.wishlist_button').attr('data-amount') - 1);
};