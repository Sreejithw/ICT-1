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
                        <li>Search Results</li>

                    </ul>

                    <!-- - - - - - - - - - - - - - End of breadcrumbs - - - - - - - - - - - - - - - - -->

                    <div class="row">

                        <main class="col-md-9 col-sm-8">

                            <h1>Search Results</h1>

                            <section class="theme_box">

                                <p>Your search results are displayed below</p>

                            </section><!--/ .theme_box -->

                            <!-- - - - - - - - - - - - - - Search information - - - - - - - - - - - - - - - - -->

                            <section class="theme_box">

                                ${products!}                              

                            </section><!--/ .theme_box -->

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
        <script src="js/script.js" type="text/javascript"></script>
    </body>
</html>