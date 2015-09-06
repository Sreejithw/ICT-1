<!doctype html>
<html lang="en">
    <head>
        <!-- Basic page
        ============================================ -->
        <title>Best Style Forever | My Account</title>
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
                        <li>My Account</li>

                    </ul>

                    <!-- - - - - - - - - - - - - - End of breadcrumbs - - - - - - - - - - - - - - - - -->

                    <div class="row">

                        <aside class="col-md-3 col-sm-4">

                            <!-- - - - - - - - - - - - - - Information - - - - - - - - - - - - - - - - -->

                            <section class="section_offset">

                                <h3>My Account</h3>

                                <ul class="theme_menu">

                                    <li class="active current"><a href="#">Account Dashboard</a></li>
                                    <li><a href="my_order.shtml">Order History</a></li>
                                    <li><a href="wishlist.shtml">Wish List</a></li>

                                </ul>

                            </section><!--/ .section_offset -->

                            <!-- - - - - - - - - - - - - - End of information - - - - - - - - - - - - - - - - -->

                            <!-- - - - - - - - - - - - - - Banner - - - - - - - - - - - - - - - - -->

                            <div class="section_offset">

                                <a href="#" class="banner">

                                    <img src="images/banner_img_4.png" alt="">

                                </a>

                            </div>

                            <!-- - - - - - - - - - - - - - End of banner - - - - - - - - - - - - - - - - -->

                        </aside><!--/ [col]-->

                        <main class="col-md-9 col-sm-8">

                            <h1>My Dashboard</h1>

                            <section class="theme_box">

                                <h4>Hello, ${fname} ${lname}!</h4>

                                <p>From your My Account Dashboard you have the ability to view a snapshot of your recent account activity and update your account information. Select a link below to view or edit information.</p>

                            </section><!--/ .theme_box -->

                            <!-- - - - - - - - - - - - - - Contact information - - - - - - - - - - - - - - - - -->

                            <section class="theme_box">

                                <h4>Contact Information</h4>

                                <p><b>First Name:</b><br>
                                    ${fname}
                                </p>

                                <p><b>Last Name:</b><br>
                                    ${lname}
                                </p>

                                <p><b>Email Address:</b><br>
                                    <span id="mail">${email}</span>
                                </p>

                                <br>
                                <div class="buttons_row">

                                    <a href="#" class="button_grey middle_btn" data-modal-url="modals/update_acc.html">Edit Account Information</a>

                                    <a href="#" class="button_grey middle_btn" data-modal-url="modals/update_pwd.html">Change Password</a>

                                </div>

                            </section><!--/ .theme_box -->

                            <!-- - - - - - - - - - - - - - End of contact information - - - - - - - - - - - - - - - - -->

<!--                            <div class="table_layout">

                                <div class="table_row">

                                    <div class="table_cell">

                                         - - - - - - - - - - - - - Default shipping address - - - - - - - - - - - - - - - - 

                                        <section>

                                            <h4>Default Shipping Address</h4>

                                            <p><b>Street:</b><br>
                                                Ang Mo Kio Avenue 10
                                            </p>

                                            <p><b>Block/House No:</b><br>
                                                462
                                            </p>

                                            <p><b>Floor:</b><br>
                                                10
                                            </p>

                                            <p><b>Unit:</b><br>
                                                123
                                            </p>

                                            <p><b>Zip/Postal Code:</b><br>
                                                398752
                                            </p>

                                            <p><b>Contact Number:</b><br>
                                                91224784
                                            </p>

                                            <p><b>Country:</b><br>
                                                Singapore
                                            </p>

                                            <a href="#" class="button_grey middle_btn" data-modal-url="modals/update_ship_add.html">Edit Address</a>

                                        </section>

                                         - - - - - - - - - - - - - End of default shipping address - - - - - - - - - - - - - - - - 

                                    </div>/ .table_cell 

                                </div>/ .table_row 

                            </div>/ .table_layout -->

                        </main><!--/ [col]-->

                    </div><!--/ .row-->

                </div><!--/ .container-->

            </div><!--/ .page_wrapper-->

            <!-- - - - - - - - - - - - - - End Page Wrapper - - - - - - - - - - - - - - - - -->

            <#include "footer.shtml">   

        </div><!--/ [layout]-->

        <#include "social_feeds.shtml">

        <!-- Include Plugins
        ============================================ -->
        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/queryloader2.min.js"></script>
        <script src="js/jquery.appear.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owlcarousel/owl.carousel.min.js"></script>
        <script src="twitter/jquery.tweet.min.js"></script>
        <script src="js/arcticmodal/jquery.arcticmodal.js"></script>
        <script src="js/retina.min.js"></script>
        <script src="js/theme.plugins.js"></script>
        <script src="js/theme.core.js"></script>
        <script src="js/script.js"></script>
        <script src="js/user.js"></script>
    </body>
</html>