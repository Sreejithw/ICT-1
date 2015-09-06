<!--================================================
                Quick view modal window
====================================================-->

<div id="quick_view" class="modal_window">

    <button class="close arcticmodal-close"></button>

    <div class="clearfix">

        <!-- - - - - - - - - - - - - - Product image column - - - - - - - - - - - - - - - - -->

        <div class="single_product">

            <!-- - - - - - - - - - - - - - Image preview container - - - - - - - - - - - - - - - - -->

            <div class="image_preview_container" id="qv_preview">

                <img id="img_zoom" data-zoom-image="${flarge!}" src="${fsmall!}" alt="">

            </div><!--/ .image_preview_container-->

            <!-- - - - - - - - - - - - - - End of image preview container - - - - - - - - - - - - - - - - -->

            <!-- - - - - - - - - - - - - - Prodcut thumbs carousel - - - - - - - - - - - - - - - - -->

            <div class="product_preview" data-output="#qv_preview">

                <div class="owl_carousel" id="thumbnails">
                    ${img}
                </div><!--/ .owl-carousel-->

            </div><!--/ .product_preview-->

            <!-- - - - - - - - - - - - - - End of prodcut thumbs carousel - - - - - - - - - - - - - - - - -->

        </div>

        <!-- - - - - - - - - - - - - - End of product image column - - - - - - - - - - - - - - - - -->

        <!-- - - - - - - - - - - - - - Product description column - - - - - - - - - - - - - - - - -->

        <div class="single_product_description">

            <h3><a href="#">${name}</a></h3>
            
            <hr>

            <div class="description_section">

                <table class="product_info">

                    <tbody>

                        <tr>

                            <td><b>Manufacturer: </b></td>
                            <td><p>${manufacture}</p></td>

                        </tr>

                        <tr>

                            <td><b>Availability: </b></td>
                            <td><span class="in_stock">In stock: </span>20 item(s)</td>

                        </tr>

                        <tr>

                            <td><b>Product Code:</b></td>
                            <td>${id}</td>

                        </tr>

                    </tbody>

                </table>

            </div>

            <hr>

            <div class="description_section">

                <p>${info}</p>

            </div>

            <hr>

            <p class="product_price">${price}</p>

            <hr>

            <!-- - - - - - - - - - - - - - Product actions - - - - - - - - - - - - - - - - -->

            <div class="buttons_row">

                <a href="product?id=${id}" class="button_blue middle_btn">More Details</a>

                <button onclick="icp.wish(${id})" class="button_dark_grey def_icon_btn middle_btn add_to_wishlist tooltip_container"><span class="tooltip top">Add to Wishlist</span></button>

            </div>

            <!-- - - - - - - - - - - - - - End of product actions - - - - - - - - - - - - - - - - -->

        </div>

        <!-- - - - - - - - - - - - - - End of product description column - - - - - - - - - - - - - - - - -->

    </div>

</div>

<!--================================================
                End quick view modal window
==================================================== -->