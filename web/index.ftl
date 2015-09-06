<!doctype html>
<html lang="en">
    <head>
        <!-- Basic
        ============================================ -->
        <title>Best Style Forever | Home</title>
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
        <link rel="stylesheet" href="js/layerslider/css/layerslider.css">
        <link rel="stylesheet" href="js/owlcarousel/owl.carousel.css">
        <link rel="stylesheet" href="js/arcticmodal/jquery.arcticmodal.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- JS for IE
        ============================================ -->
        <script src="js/modernizr.js"></script>

        <!-- Old IE stylesheet
        ============================================ -->
        <!--[if lte IE 9]>
                <link rel="stylesheet" type="text/css" href="css/oldie.css">
        <![endif]-->
    </head>
    <body class="front_page">
        <div class="wide_layout">
            <#include "header.shtml">

            <!-- - - - - - - - - - - - - - Layer slider - - - - - - - - - - - - - - - - -->

            <div class="layerslider full_width" style="width:100%; height: 522px;">

                <!-- - - - - - - - - - - - - - Slide 1 - - - - - - - - - - - - - - - - -->

                <div class="ls-slide" data-ls="transition2d: 10, 27, 63, 67, 69;">

                    <img class="ls-bg" src="images/index_slide_1.jpg" alt="slider_pic1">
                    
                </div>

                <!-- - - - - - - - - - - - - - End of slide 1 - - - - - - - - - - - - - - - - -->

                <!-- - - - - - - - - - - - - - Slide 2 - - - - - - - - - - - - - - - - -->

                <div class="ls-slide" data-ls="transition2d: 10, 27, 63, 67, 69;">

                    <img class="ls-bg" src="images/index_slide_2.jpg" alt="slider_pic2">

                </div>

                <!-- - - - - - - - - - - - - - End of slide 2 - - - - - - - - - - - - - - - - -->

                <!-- - - - - - - - - - - - - - Slide 3 - - - - - - - - - - - - - - - - -->

                <div class="ls-slide" data-ls="transition2d: 10, 27, 63, 67, 69;">

                    <img class="ls-bg" src="images/index_slide_3.jpg" alt="slider_pic3">

                </div>

                <!-- - - - - - - - - - - - - - End of slide 3 - - - - - - - - - - - - - - - - -->
                
                <!-- - - - - - - - - - - - - - Slide 4 - - - - - - - - - - - - - - - - -->

                <div class="ls-slide" data-ls="transition2d: 10, 27, 63, 67, 69;">

                    <img class="ls-bg" src="images/index_slide_4.jpg" alt="slider_pic4">

                </div>

                <!-- - - - - - - - - - - - - - End of slide 4 - - - - - - - - - - - - - - - - -->

            </div><!--/ #layerslider-->

            <!-- - - - - - - - - - - - - - End of layer slider - - - - - - - - - - - - - - - - -->

            <!-- - - - - - - - - - - - - - Page Wrapper - - - - - - - - - - - - - - - - -->

            <div class="page_wrapper" id="todayDeal">

                <div class="container">

                    <!-- - - - - - - - - - - - - - Banners - - - - - - - - - - - - - - - - -->

                    <div class="section_offset">

                        <div class="row">

                            <div class="col-sm-4">

                                <a href="#" class="banner animated transparent" data-animation="fadeInDown">

                                    <img src="images/banner_img_1.jpg" alt="">

                                </a>

                            </div><!--/ [col]-->

                            <div class="col-sm-4">

                                <a href="#" class="banner animated transparent" data-animation="fadeInDown" data-animation-delay="150">

                                    <img src="images/banner_img_2.jpg" alt="">

                                </a>

                            </div><!--/ [col]-->

                            <div class="col-sm-4">

                                <a href="#" class="banner animated transparent" data-animation="fadeInDown" data-animation-delay="300">

                                    <img src="images/banner_img_3.jpg" alt="">

                                </a>

                            </div><!--/ [col]-->

                        </div><!--/ .row-->

                    </div><!--/ .section_offset-->

                    <!-- - - - - - - - - - - - - - End of banners - - - - - - - - - - - - - - - - -->

                    <!-- - - - - - - - - - - - - - Today's deals - - - - - - - - - - - - - - - - -->

                    <section class="section_offset animated transparent" data-animation="fadeInDown">

                        <h3 class="section_title offset_title">Today's Deals</h3>

                        <!-- - - - - - - - - - - - - - Carousel of today's deals - - - - - - - - - - - - - - - - -->

                        <div class="owl_carousel five_items">
                            
                            ${deals!}

                        </div><!--/ .owl_carousel-->

                        <!-- - - - - - - - - - - - - - End of carousel of today's deals - - - - - - - - - - - - - - - - -->

                    </section><!--/ .section_offset.animated.transparent-->

                    <!-- - - - - - - - - - - - - - End of today's deals - - - - - - - - - - - - - - - - -->

                    <!-- - - - - - - - - - - - - - Featured products - - - - - - - - - - - - - - - - -->

                    <section class="section_offset animated transparent" data-animation="fadeInDown">

                        <h3 class="offset_title">Featured Items</h3>

                        <!-- - - - - - - - - - - - - - Carousel of featured products - - - - - - - - - - - - - - - - -->

                        <div class="owl_carousel five_items">

                            ${feature!}

                        </div><!--/ .owl_carousel.five_items-->

                        <!-- - - - - - - - - - - - - - End of featured products - - - - - - - - - - - - - - - - -->

                    </section><!--/ .section_offset.animated.transparent-->

                    <!-- - - - - - - - - - - - - - End of featured products - - - - - - - - - - - - - - - - -->

                    <!-- - - - - - - - - - - - - - Testimonials - - - - - - - - - - - - - - - - -->

                    <section class="section_offset animated transparent" data-animation="fadeInDown">

                        <h3 class="offset_title">Testimonials</h3>

                        <div class="table_layout">

                            <div class="table_row">

                                <!-- - - - - - - - - - - - - - Testimonial - - - - - - - - - - - - - - - - -->

                                <div class="table_cell">

                                    <blockquote>

                                        <div class="author_info"><b>Lee Ann</b></div>

                                        <p>Follow Up: I arrived home last night to find my tops and they are wonderful. Thanks so much. Best Style Forever!</p>

                                    </blockquote>

                                </div>

                                <!-- - - - - - - - - - - - - - End testimonial - - - - - - - - - - - - - - - - -->

                                <!-- - - - - - - - - - - - - - Testimonial - - - - - - - - - - - - - - - - -->

                                <div class="table_cell">

                                    <blockquote>

                                        <div class="author_info"><b>Maria & Anders</b></div>

                                        <p>WOW!!! What service, I was thinking it would take a few weeks, THANK YOU so much for such good service!! Maria & Anders</p>

                                    </blockquote>

                                </div>

                                <!-- - - - - - - - - - - - - - End testimonial - - - - - - - - - - - - - - - - -->

                                <!-- - - - - - - - - - - - - - Testimonial - - - - - - - - - - - - - - - - -->

                                <div class="table_cell">

                                    <blockquote>

                                        <div class="author_info"><b>Amy & Steven</b></div>

                                        <p>I am writing to thank you for the very quick delivery of my order. I am so rapt, I have been dancing around the room in my new knickers & shirt. They all FIT!!! I feel so lovely & happy. Thanks.</p>

                                    </blockquote>

                                </div>

                                <!-- - - - - - - - - - - - - - End testimonial - - - - - - - - - - - - - - - - -->

                                <!-- - - - - - - - - - - - - - Testimonial - - - - - - - - - - - - - - - - -->

                                <div class="table_cell">

                                    <blockquote>

                                        <div class="author_info"><b>John Smith</b></div>

                                        <p>My top has arrived this morning and I love it. Such a high quality product at a reasonable price. Thanks, Best Style Forever.</p>

                                    </blockquote>

                                </div>

                                <!-- - - - - - - - - - - - - - End testimonial - - - - - - - - - - - - - - - - -->

                            </div>

                        </div>

                        <!--- - - - - - - - - - - - - View all testimonials - - - - - - - - - - - - - - - - 
                        
                                            <footer class="bottom_box">
                        
                                                <a href="#" class="button_grey middle_btn" data-modal-url="modals/testimonials.shtml">View All Testimonials</a>
                        
                                            </footer>
                        
                                             - - - - - - - - - - - - - End of view all testimonials - - - - - - - - - - - - - - - - -->

                    </section><!--/ .section_offset.animated.transparent-->

                    <!-- - - - - - - - - - - - - - End of testimonials - - - - - - - - - - - - - - - - -->

                    <!-- - - - - - - - - - - - - - New products - - - - - - - - - - - - - - - - -->

                    <section class="section_offset animated transparent" data-animation="fadeInDown">

                        <h3 class="offset_title">New Arrivals</h3>

                        <!-- - - - - - - - - - - - - - Carousel of featured products - - - - - - - - - - - - - - - - -->

                        <div id="arrival" class="owl_carousel five_items">

                            ${arrival!}

                        </div><!--/ .owl_carousel.five_items-->

                        <!-- - - - - - - - - - - - - - End of featured products - - - - - - - - - - - - - - - - -->

                    </section><!--/ .section_offset.animated.transparent-->

                    <!-- - - - - - - - - - - - - - End of New products - - - - - - - - - - - - - - - - -->

                    <!-- - - - - - - - - - - - - - Bestsellers - - - - - - - - - - - - - - - - -->

                    <section class="section_offset animated transparent" data-animation="fadeInDown">

                        <h3 class="offset_title">Bestsellers</h3>

                        <!-- - - - - - - - - - - - - - Carousel of bestsellers - - - - - - - - - - - - - - - - -->

                        <div class="owl_carousel four_items">

                            ${bestsell!}

                        </div><!--/ .owl_carousel-->

                        <!-- - - - - - - - - - - - - - End of carousel of bestseller - - - - - - - - - - - - - - - - -->

                    </section>

                    <!-- - - - - - - - - - - - - - End of bestsellers - - - - - - - - - - - - - - - - -->

                    <!-- - - - - - - - - - - - - - Our brands - - - - - - - - - - - - - - - - -->

                    <section class="section_offset animated transparent" data-animation="fadeInDown">

                        <h3 class="offset_title">Our Brands</h3>

                        <!-- - - - - - - - - - - - - - Carousel of brands - - - - - - - - - - - - - - - - -->

                        <div class="owl_carousel brands_full_width">

                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_1.jpg" alt="">
                            </a>
                            <!--End brand-->

                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_2.jpg" alt="">
                            </a>
                            <!--End brand-->

                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_3.jpg" alt="">
                            </a>
                            <!--End brand-->

                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_4.jpg" alt="">
                            </a>
                            <!--End brand-->

                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_5.jpg" alt="">
                            </a>
                            <!--End brand-->

                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_6.jpg" alt="">
                            </a>
                            <!--End brand-->

                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_7.jpg" alt="">
                            </a>
                            <!--End brand-->

                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_8.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_9.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_10.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_11.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_12.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_13.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_14.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_15.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_16.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_17.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_18.jpg" alt="">
                            </a>
                            <!--End brand-->
                            
                            <!--Brand-->
                            <a href="#">
                                <img src="images/brands_img_19.jpg" alt="">
                            </a>
                            <!--End brand-->

                        </div><!--/ .owl_carousel-->

                        <!-- - - - - - - - - - - - - - End of carousel of brands - - - - - - - - - - - - - - - - -->

                    </section><!--/ .section_offset.animated.transparent-->

                    <!-- - - - - - - - - - - - - - End our brands - - - - - - - - - - - - - - - - -->

                </div><!--/ .container-->

            </div><!--/ .page_wrapper-->

            <#include "footer.shtml">   

        </div><!--/ [layout]-->

        <#include "social_feeds.shtml">

        <!-- Include Plugins
        ============================================ -->
        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/queryloader2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/layerslider/js/greensock.js"></script>
        <script src="js/layerslider/js/layerslider.transitions.js"></script>
        <script src="js/layerslider/js/layerslider.kreaturamedia.jquery.js"></script>
        <script src="js/jquery.appear.js"></script>
        <script src="js/owlcarousel/owl.carousel.min.js"></script>
        <script src="js/jquery.countdown.plugin.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/arcticmodal/jquery.arcticmodal.js"></script>
        <script src="twitter/jquery.tweet.min.js"></script>
        <script src="js/retina.min.js"></script>
        <script src="js/theme.plugins.js"></script>
        <script src="js/theme.core.js"></script>        
        <script src="js/script.js" type="text/javascript"></script>
    </body>
</html>
