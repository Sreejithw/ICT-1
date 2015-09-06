<!doctype html>
<html lang="en">
    <head>
        <!-- Basic page
        ============================================ -->
        <title>Best Style Forever | Product Details</title>
        <meta charset="utf-8">
        <meta name="author" content="GOTG">
        <meta name="description" content="Fashion, clothing, online shopping">
        <meta name="keywords" content="Fashion, clothing, online shopping">

        <!-- Mobile metas
        ============================================ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

        <!-- Favicon
        ============================================ -->
        <link rel="shortcut icon" type="image/x-icon" href="images/fav_icon.ico">

        <!-- Google web fonts
        ============================================ -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,400italic,300,300italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

        <!-- Main CSS
        ============================================ -->
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/fontello.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="js/fancybox/source/jquery.fancybox.css">
        <link rel="stylesheet" href="js/fancybox/source/helpers/jquery.fancybox-thumbs.css">
        <link rel="stylesheet" href="js/arcticmodal/jquery.arcticmodal.css">
        <link rel="stylesheet" href="js/owlcarousel/owl.carousel.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- JS Libs
        ============================================ -->
        <script src="js/modernizr.js"></script>

        <!-- JS for IE
        ============================================ -->
        <!--[if lte IE 9]>
                <link rel="stylesheet" type="text/css" href="css/oldie.css">
        <![endif]-->
    </head>
    <body>

        <!-- - - - - - - - - - - - - - Main Wrapper - - - - - - - - - - - - - - - - -->
        <div class="wide_layout">
            <#include "header.shtml">

            <!-- - - - - - - - - - - - - - Page Wrapper - - - - - - - - - - - - - - - - -->

            <div class="secondary_page_wrapper">

                <div class="container">

                    <!-- - - - - - - - - - - - - - Breadcrumbs - - - - - - - - - - - - - - - - -->

                    <ul class="breadcrumbs">

                        <li><a href="index.shtml">Home</a></li>
                        <li><a href="#">${gender!}</a></li>
                        <li><a href="#">${category!}</a></li>
                        <li>${name}</li>

                    </ul>

                    <!-- - - - - - - - - - - - - - End of breadcrumbs - - - - - - - - - - - - - - - - -->

                    <!-- - - - - - - - - - - - - - Product images & description - - - - - - - - - - - - - - - - -->

                    <section class="section_offset">

                        <div class="clearfix">

                            <!-- - - - - - - - - - - - - - Product image column - - - - - - - - - - - - - - - - -->

                            <div class="single_product">

                                <!-- - - - - - - - - - - - - - Image preview container - - - - - - - - - - - - - - - - -->

                                <div class="image_preview_container">

                                    <img id="img_zoom" data-zoom-image="${flarge}" src="${fsmall}" alt="">

                                    <button class="button_grey_2 icon_btn middle_btn open_qv"><i class="icon-resize-full-6"></i></button>

                                </div><!--/ .image_preview_container-->

                                <!-- - - - - - - - - - - - - - End of image preview container - - - - - - - - - - - - - - - - -->

                                <!-- - - - - - - - - - - - - - Product thumbs carousel - - - - - - - - - - - - - - - - -->

                                <div class="product_preview">

                                    <div class="owl_carousel" id="thumbnails">
                                        ${img!}
                                    </div><!--/ .owl-carousel-->

                                </div><!--/ .product_preview-->

                                <!-- - - - - - - - - - - - - - End of prodcut thumbs carousel - - - - - - - - - - - - - - - - -->

                            </div>

                            <!-- - - - - - - - - - - - - - End of product image column - - - - - - - - - - - - - - - - -->

                            <!-- - - - - - - - - - - - - - Product description column - - - - - - - - - - - - - - - - -->

                            <div class="single_product_description">

                                <h3 class="offset_title">${name}</h3>

                                <div class="description_section v_centered">

                                    <!-- - - - - - - - - - - - - - Product rating - - - - - - - - - - - - - - - - -->

                                    <ul id="avgRate" class="rating">

                                    </ul>

                                    <!-- - - - - - - - - - - - - - End of product rating - - - - - - - - - - - - - - - - -->

                                    <!-- - - - - - - - - - - - - - Reviews menu - - - - - - - - - - - - - - - - -->

                                    <ul class="topbar">

                                        <li><b><span class="reviewNum"></span> Review(s)</b></li>

                                    </ul>

                                    <!-- - - - - - - - - - - - - - End of reviews menu - - - - - - - - - - - - - - - - -->

                                </div>

                                <div class="description_section">

                                    <table class="product_info">

                                        <tbody>

                                            <tr>

                                                <td><b>Manufacturer:</b> </td>
                                                <td><a href="#">${manufacture}</a></td>

                                            </tr>

                                            <tr>

                                                <td><b>Availability:</b> </td>
                                                <td><span class="in_stock">In stock: </span>10 item(s)</td>

                                            </tr>

                                            <tr>

                                                <td><b>Product ID:</b> </td>
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

                                <div>
                                    <div class="title">Material:</div>
                                    <div id="material">

                                    </div>
                                </div>
                                
                                <div>
                                    <div class="title">Color:</div>
                                    <div id="color">

                                    </div>
                                </div>
                                
                                <div>
                                    <div class="title">Size:</div>
                                    <div id="size">

                                    </div>
                                </div>
                                <!-- - - - - - - - - - - - - - Quantity - - - - - - - - - - - - - - - - -->

                                <div class="description_section_3 v_centered">

                                    <span class="title">Qty:</span>

                                    <div class="qty min clearfix">

                                        <button class="theme_button" data-direction="minus">&#45;</button>
                                        <input type="text" id="qty" value="1">
                                        <button class="theme_button" data-direction="plus">&#43;</button>

                                    </div>

                                </div>

                                <!-- - - - - - - - - - - - - - End of quantity - - - - - - - - - - - - - - - - -->

                                <!-- - - - - - - - - - - - - - Product actions - - - - - - - - - - - - - - - - -->

                                <div class="description_section_2 v_centered">

                                    <div class="buttons_row">

                                        <button onclick="icp.cart.submit()" class="button_blue middle_btn">Add to Cart</button>

                                        <button onclick="icp.wish(${id})" class="button_dark_grey def_icon_btn middle_btn add_to_wishlist tooltip_container">
                                            <span class="tooltip top">Add to Wishlist</span></button>

                                    </div>

                                </div>

                                <!-- - - - - - - - - - - - - - End of product actions - - - - - - - - - - - - - - - - -->

                            </div>

                            <!-- - - - - - - - - - - - - - End of product description column - - - - - - - - - - - - - - - - -->

                        </div>

                    </section><!--/ .section_offset -->

                    <!-- - - - - - - - - - - - - - End of product images & description - - - - - - - - - - - - - - - - -->

                    <!-- - - - - - - - - - - - - - Tabs - - - - - - - - - - - - - - - - -->

                    <div class="section_offset">

                        <div class="tabs type_2">

                            <!-- - - - - - - - - - - - - - Navigation of tabs - - - - - - - - - - - - - - - - -->

                            <ul class="tabs_nav clearfix">

                                <li><a href="#tab-1">Description</a></li>
                                <li><a href="#tab-2">(<span class="reviewNum"></span>) Reviews</a></li>

                            </ul>

                            <!-- - - - - - - - - - - - - - End navigation of tabs - - - - - - - - - - - - - - - - -->

                            <!-- - - - - - - - - - - - - - Tabs container - - - - - - - - - - - - - - - - -->

                            <div class="tab_containers_wrap">

                                <!-- - - - - - - - - - - - - - Tab - - - - - - - - - - - - - - - - -->

                                <div id="tab-1" class="tab_container">

                                    ${info}

                                </div><!--/ #tab-1-->

                                <!-- - - - - - - - - - - - - - End tab - - - - - - - - - - - - - - - - -->

                                <!-- - - - - - - - - - - - - - Tab - - - - - - - - - - - - - - - - -->

                                <div id="tab-2" class="tab_container">

                                    <section class="section_offset">

                                        <h3>Customer Reviews</h3>

                                        <ul class="reviews">



                                        </ul>

                                    </section><!--/ .section_offset -->

                                    <section class="section_offset">

                                        <h3>Write Your Own Review</h3>

                                        <div class="row">

                                            <div class="col-lg-5 col-md-6">

                                                <p>How do you rate this product? *</p><br>

                                                <!-- - - - - - - - - - - - - - Rate the - - - - - - - - - - - - - - - - -->

                                                <div class="table_wrap_reviews">
                                                    <form id="rating">
                                                        <table>

                                                            <thead>

                                                                <tr>

                                                                    <th></th>
                                                                    <th>1 Star</th>
                                                                    <th>2 Stars</th>
                                                                    <th>3 Stars</th>
                                                                    <th>4 Stars</th>
                                                                    <th>5 Stars</th>

                                                                </tr>

                                                            </thead>

                                                            <tbody>

                                                                <tr>

                                                                    <td>Price</td>

                                                                    <td>

                                                                        <input type="radio" name="price_rate" id="rate_1" value="1">
                                                                        <label for="rate_1"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="price_rate" id="rate_2" value="2">
                                                                        <label for="rate_2"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="price_rate" id="rate_3" value="3">
                                                                        <label for="rate_3"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="price_rate" id="rate_4" value="4">
                                                                        <label for="rate_4"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="price_rate" id="rate_5" value="5">
                                                                        <label for="rate_5"></label>

                                                                    </td>

                                                                </tr>

                                                                <tr>

                                                                    <td>Value</td>

                                                                    <td>

                                                                        <input type="radio" name="value_rate" id="rate_6" value="1">
                                                                        <label for="rate_6"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="value_rate" id="rate_7" value="2">
                                                                        <label for="rate_7"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="value_rate" id="rate_8" value="3">
                                                                        <label for="rate_8"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="value_rate" id="rate_9" value="4">
                                                                        <label for="rate_9"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="value_rate" id="rate_10" value="5">
                                                                        <label for="rate_10"></label>

                                                                    </td>

                                                                </tr>

                                                                <tr>

                                                                    <td>Quality</td>

                                                                    <td>

                                                                        <input type="radio" name="quality_rate" id="rate_11" value="1">
                                                                        <label for="rate_11"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="quality_rate" id="rate_12" value="2">
                                                                        <label for="rate_12"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="quality_rate" id="rate_13" value="3">
                                                                        <label for="rate_13"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="quality_rate" id="rate_14" value="4">
                                                                        <label for="rate_14"></label>

                                                                    </td>

                                                                    <td>

                                                                        <input type="radio" name="quality_rate" id="rate_15" value="5">
                                                                        <label for="rate_15"></label>

                                                                    </td>

                                                                </tr>

                                                            </tbody>

                                                        </table>
                                                    </form>
                                                </div>

                                                <!-- - - - - - - - - - - - - - End of rate the - - - - - - - - - - - - - - - - -->

                                            </div><!--/ [col]-->

                                            <div class="col-lg-7 col-md-6">

                                                <p class="subcaption">All fields are required.</p>

                                                <!-- - - - - - - - - - - - - - Review div - - - - - - - - - - - - - - - - -->

                                                <div class="type_2">

                                                    <ul>

                                                        <li class="row">

                                                            <div class="col-sm-6">

                                                                <label for="summary">Summary of your review</label>
                                                                <input type="text" name="title" id="summary">

                                                            </div>

                                                        </li>

                                                        <li class="row">

                                                            <div class="col-xs-12">

                                                                <label for="review_message">Review</label>

                                                                <textarea rows="5" name="content" id="review_message"></textarea>

                                                            </div>

                                                        </li>

                                                        <li>
                                                            <br>
                                                        </li>

                                                        <li class="row">

                                                            <div class="col-xs-12">

                                                                <a id="sendRev" class="button_dark_grey middle_btn" href="javascript:;" onclick="icp.sendRev('${id}')">Submit Review</a>

                                                            </div>

                                                        </li>

                                                    </ul>

                                                </div>

                                                <!-- - - - - - - - - - - - - - End of review div - - - - - - - - - - - - - - - - -->

                                            </div>

                                        </div><!--/ .row -->

                                    </section><!--/ .section_offset -->

                                </div><!--/ #tab-2-->

                                <!-- - - - - - - - - - - - - - End tab - - - - - - - - - - - - - - - - -->

                            </div><!--/ .tab_containers_wrap -->

                            <!-- - - - - - - - - - - - - - End of tabs containers - - - - - - - - - - - - - - - - -->

                        </div><!--/ .tabs-->

                    </div><!--/ .section_offset -->

                    <!-- - - - - - - - - - - - - - End of tabs - - - - - - - - - - - - - - - - -->

                </div>
            </div>

            <#include "footer.shtml">

        </div><!--/ [layout]-->

        <#include "social_feeds.shtml">

        <!-- Include Plugins
        ============================================ -->
        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/queryloader2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.elevateZoom-3.0.8.min.js"></script>
        <script src="js/fancybox/source/jquery.fancybox.pack.js"></script>
        <script src="js/fancybox/source/helpers/jquery.fancybox-media.js"></script>
        <script src="js/fancybox/source/helpers/jquery.fancybox-thumbs.js"></script>
        <script src="js/jquery.appear.js"></script>
        <script src="js/jquery.countdown.plugin.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/owlcarousel/owl.carousel.min.js"></script>
        <script src="twitter/jquery.tweet.min.js"></script>
        <script src="js/arcticmodal/jquery.arcticmodal.js"></script>
        <script src="js/retina.min.js"></script>
        <script src="js/theme.plugins.js"></script>
        <script src="js/theme.core.js"></script>
        <script src="js/script.js" type="text/javascript"></script>
        <script src="js/product.js" type="text/javascript"></script>
        <script>
            icp.getReview("${id}");
            icp.item.get("${id}");
        </script>
    </body>
</html>