<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

    <link rel="stylesheet" href="<c:url value='/resources/css/home.css' />">
    <link rel="stylesheet" href="<c:url value='/resources/css/productDetail.css' />">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />

    <!-- owlcarousel2 -->

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/qunit/2.18.1/qunit.css"
        integrity="sha512-ZCCKiB7dW1caC4UXu/J3xiZVV+nf4KEBFhp1AAc2q9S30+Di9o9hnXHdGuJaMc1pD/Fv2tc8e3PneXR1M/mJ4w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="stylesheet" href="/lib/OwlCarousel2-2.3.4/dist/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="/lib/OwlCarousel2-2.3.4/dist/assets/owl.theme.default.min.css">

</head>

<body>
    <div class="container--fluid">

        <div class="header">
            <div class="header__logo">
                <img src="https://blueskytechco.com/rubix/wp-content/uploads/2021/05/logo_x2.png" alt="" />
            </div>
            <div class="header__navigation">
                <ul class="nav__level1">

                    <li class="item_level1"><a href="">Home</a></li>
                    <li class="item_level1"><a href="">Shop</a></li>
                    <li class="item_level1"><a href="">Page</a></li>
                    <li class="item_level1"><a href="">Blog</a></li>
                    <li class="item_level1"><a href="">Contact</a></li>
                </ul>
            </div>
            <div class="header__action">
                <div class="header__action_left">
                    <div class="login">
                        <a href="">
                            <i class="fa fa-user" aria-hidden="true"></i>Login</a>
                    </div>
                    <span></span>
                    <div class="register">
                        <a href="">Register</a>
                    </div>
                </div>
                <span>|</span>
                <div class="header__action_right">
                    <i class="fa fa-heart-o" aria-hidden="true"></i>
                    <i class="fa fa-cart-arrow-down" aria-hidden="true"></i>
                    <i class="fa fa-search" aria-hidden="true"></i>
                </div>
            </div>
        </div>

        <div class="content ">
            <div class="breadcrumb-contain">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item"><a href="#">Library</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Data</li>
                    </ol>
                </nav>
            </div>
        </div>
        <div class="container ">
            <div class="product-detail row">
                <div class="images-detail col-lg-6 pr-3">
                    <div class="img-main">
                        <div class="img-contain">
                            <img src="https://thuthuatnhanh.com/wp-content/uploads/2019/07/anh-girl-xinh-facebook-tuyet-dep-387x580.jpg"
                                alt="">
                        </div>
                        <div class="icon-search ">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="imgs-sub owl-carousel">
                        <div class="img-sub ">
                            <img src="https://18hubnet.sgp1.digitaloceanspaces.com/uploads/photos/2021/12/18h_72c4b1ca98a399826e50ca8ed226c072.jpg"
                                alt="">
                        </div>
                        <div class="img-sub ">
                            <img src="https://media.doisongvietnam.vn/u/rootimage/editor/2020/10/12/13/17/tu-1602461870_3723.jpg"
                                alt="">
                        </div>
                        <div class="img-sub ">
                            <img src="https://media.doisongvietnam.vn/u/rootimage/editor/2020/10/12/13/17/tu-1602461870_3723.jpg"
                                alt="">
                        </div>
                        <div class="img-sub ">
                            <img src="https://media.doisongvietnam.vn/u/rootimage/editor/2020/10/12/13/17/tu-1602461870_3723.jpg"
                                alt="">
                        </div>
                        <div class="img-sub ">
                            <img src="https://media.doisongvietnam.vn/u/rootimage/editor/2020/10/12/13/17/tu-1602461870_3723.jpg"
                                alt="">
                        </div>
                        <div class="img-sub ">
                            <img src="https://media.doisongvietnam.vn/u/rootimage/editor/2020/10/12/13/17/tu-1602461870_3723.jpg"
                                alt="">
                        </div>
                    </div>
                </div>
                <div class="info-detail  pr-6 col-lg-6 ">
                    <div class="title  pb-3">
                        <h4>Áo thun nam POLO trơn vải cá sấu cotton cao cấp ngắn tay cực sang trọng</h4>
                    </div>
                    <div class="ratings pb-3">
                        <span class="mr-2">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                        </span>
                        <span class="info-rating"> (2 customer reviews)</span>
                    </div>
                    <div class="price-line pb-3">
                        <span class="price-current">$32.00</span>
                        <bdi class="price-old">$49.00</bdi>
                    </div>


                    <div class="option mb-2">
                        <div class="title left mr-2">
                            <b> Loại: </b>
                        </div>
                        <div class="title rioght mr-2">
                            <span>Quần áo</span>
                        </div>
                    </div>
                    <div class="option">
                        <div class="title left mr-2">
                            <b> Kích thước: </b>
                        </div>
                        <div class="sizes">
                            <button class="btn mr-2 size "> S </button>
                            <button class="btn mr-2 size "> M </button>
                            <button class="btn mr-2 size "> L </button>
                            <button class="btn mr-2 size false " disabled> M </button>
                        </div>
                    </div>
                    <div class="option mb-3">
                        <div class="title left mr-2">
                            <b>Hàng tồn </b>
                        </div>
                        <div class="title rioght mr-2">
                            <span>200 sản phẩm có sẵn</span>
                        </div>
                    </div>
                    <div class="option ">
                        <div class=" left title mr-2">
                            <b> số lượng: </b>
                        </div>
                        <div class="quantity ">
                            <button class="btn mr-2"> <i class="fa fa-plus" aria-hidden="true"></i></button>
                            <span class="btn " id="quantity">1</span>
                            <button class="btn ml-2"> <i class="fa fa-minus" aria-hidden="true"></i></button>
                        </div>
                    </div>

                    <div class="option pb-3 mt-4">
                        <div class="btn-option" id="buy-now">
                            <button class="btn "> <i class="fa fa-shopping-cart" aria-hidden="true"></i> Mua
                                ngay</button>
                        </div>
                        <div class="btn-option" id="add-to-cart">
                            <button class="btn "><i class="fa fa-money" aria-hidden="true"></i> Thêm vào
                                giỏ</button>
                        </div>
                    </div>
                </div>
            </div>
            <br> <br>
            <div class="tab p-4">
                <section class="container-tab pb-3">
                    <nav class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active " id="#nav-description" data-toggle="tab"
                            href="#nav-description" role="tab" aria-controls="nav-general">description</a>

                        <a class="nav-item nav-link " id="#nav-comment" id='clock' data-toggle="tab" href="#nav-comment"
                            role="tab" aria-controls="nav-profile">Reviews(1)</a>
                    </nav>
                </section>

                <div class="tab-content py-3 px-sm-0" id="nav-tabContent">

                    <div class="tab-pane fSade show active" id="nav-description" role="tabpanel"
                        aria-labelledby="nav-description">
                        <div class="description-detail color-gray pb-3 pt-3">
                            <p>Tailored line. Wool mix fabric. Long design. Long buttoned sleeve. Lapel with notch.
                                Back slit. Two
                                pockets with flaps on the front. Button up. Inner lining. Inner pocket. Back length
                                95.0 cm. Common
                                Projects’ black Original Achilles trainers exude the label’s stark minimalism. They’re
                                constructed
                                in
                                Italy from leather to a round-toe, low-top shape, and accented with a signature serial
                                number at
                                the
                                heel.</p>

                            <p> Anti-Theft Backpack: Made of strong anti-scratch /-cut fabric, this college backpack
                                keeps your
                                belongings pretty safe with hidden zippers of the main pocket and a secret pocket at the
                                back</p>
                            <p> Convenient Charging: Via the built-in charging cable on the inside of the laptop
                                backpack and the
                                USB
                                charging port on the outside, you can just plug in and charge your device anywhere
                            </p>
                            <p>(Reminder: Power
                                bank
                                NOT included)</p>
                        </div>

                    </div>
                    <div class="tab-pane fSade show " id="nav-comment" role="tabpanel" aria-labelledby="nav-comment">
                        <div class="comments pb-3">
                            <div class="title pb-3 ">
                                <h4> 1 review for Daily Ritual Women’s</h4>
                            </div>

                            <div class="comment">
                                <div class="avatar">
                                    <img src="
                                        https://secure.gravatar.com/avatar/bb90dcb0ceabfc8bf10c550f1ee95ee7?s=60&d=mm&r=g"
                                        alt="">
                                </div>
                                <div class="info-comment">
                                    <div class="name  pb-1">
                                        Nguyễn Thanh sơn
                                    </div>
                                    <div class="ratings pb-1">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>

                                    </div>
                                    <div class="date">
                                        <small> June 11, 2021</small>
                                    </div>
                                    <div class="content">
                                        It has survived not only
                                    </div>
                                </div>

                            </div>
                            <div class="comment">
                                <div class="avatar">
                                    <img src="
                                        https://secure.gravatar.com/avatar/bb90dcb0ceabfc8bf10c550f1ee95ee7?s=60&d=mm&r=g"
                                        alt="">
                                </div>
                                <div class="info-comment">
                                    <div class="name  pb-1">
                                        Nguyễn Thanh sơn
                                    </div>
                                    <div class="ratings pb-1">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>

                                    </div>
                                    <div class="date">
                                        <small> June 11, 2021</small>
                                    </div>
                                    <div class="content">
                                        It has survived not only
                                    </div>
                                </div>

                            </div>
                            <div class="comment">
                                <div class="avatar">
                                    <img src="
                                        https://secure.gravatar.com/avatar/bb90dcb0ceabfc8bf10c550f1ee95ee7?s=60&d=mm&r=g"
                                        alt="">
                                </div>
                                <div class="info-comment">
                                    <div class="name  pb-1">
                                        Nguyễn Thanh sơn
                                    </div>
                                    <div class="ratings pb-1">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </div>
                                    <div class="date">
                                        <small> June 11, 2021</small>
                                    </div>
                                    <div class="content">
                                        It has survived not only
                                    </div>
                                </div>
                            </div>

                        </div>
                        <form class="create-comment pt-3 text-center">
                            <div class=" bg-light p-5">
                                <h5 class="text-secondary">Add a review</h5>
                                <div class="your-rating">
                                    <!--  code JSP set rating at here (checked) -->
                                    <div class="ratings-input" style="display: none;">
                                        <input type="radio" name="rating-input" value='1' class="rating-input"
                                            id="rating-input-1">
                                        <input type="radio" name="rating-input" value='2' checked class="rating-input"
                                            id="rating-input-2">
                                        <input type="radio" name="rating-input" value='3' class="rating-input"
                                            id="rating-input-3">
                                        <input type="radio" name="rating-input" value='4' class="rating-input"
                                            id="rating-input-4">
                                        <input type="radio" name="rating-input" value='5' class="rating-input"
                                            id="rating-input-5">
                                    </div>
                                    <div class="ratings">
                                        <i class="fa fa-star rating-start" id="rating-1" aria-hidden="true"> </i>
                                        <i class="fa fa-star rating-start" id="rating-2" aria-hidden="true"> </i>
                                        <i class="fa fa-star rating-start" id="rating-3" aria-hidden="true"></i>
                                        <i class="fa fa-star rating-start" id="rating-4" aria-hidden="true"></i>
                                        <i class="fa fa-star rating-start" id="rating-5" aria-hidden="true"></i>
                                    </div>
                                </div>
                            </div>

                            <div class="reivew">

                                <div class="row col-12 pt-3">
                                    <lable for="review" class="pb-2">Your review *</lable>
                                    <textarea name="review" id="review" class="p-3 form-control" cols="30"
                                        rows="8"></textarea>
                                </div>
                                <div class="row col-12 pt-4">
                                    <div class="col-6 p-0 pr-4 text-left">
                                        <lable for="name" class="pb-4 ">Your name *</lable>
                                        <input name="name" id="name" class="pl-3 mt-2 form-control" />
                                    </div>
                                    <div class="col-6 p-0 pl-4 text-left">
                                        <lable for="email" class="pb-4 ">Your email *</lable>

                                        <input name="email" id="email" class="pl-3 mt-2 form-control" />
                                    </div>
                                </div>
                            </div>
                            <div class="option pt-4 pl-0">
                                <div class="btn-option compare text-left">
                                    <button class="btn ml-0 pl-4 pr-4 bg-dark font-weight-bold text-white">
                                        Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class=" trending__products">
    </div>
    <div class="best__seller"></div>
    <div class="contact"></div>
    <div class="brand"></div>
    </section>
    <div class="footer">
        <div class="row">
            <div class="col-3">
                <div class="logo">
                    <img src="https://blueskytechco.com/rubix/wp-content/uploads/2021/01/logo-footer-rubix.png" alt="">
                </div>
                <div class="social">
                    <i class="fa fa-twitter" aria-hidden="true"></i>
                    <i class="fa fa-youtube-play" aria-hidden="true"></i>
                    <i class="fa fa-facebook-official" aria-hidden="true"></i>

                </div>
            </div>
            <div class="col-3">
                <ul class="footer_ul">Customer Services
                    <li>My Account</li>
                    <li>Track Your Order</li>
                    <li>FAQs</li>
                    <li>Payment Methods</li>
                    <li>Shipping Guide</li>
                    <li>Products Support</li>
                    <li>Gift Card balance</li>
                </ul>
            </div>
            <div class="col-3">
                <ul class="footer_ul">Customer Services
                    <li>My Account</li>
                    <li>Track Your Order</li>
                    <li>FAQs</li>
                    <li>Payment Methods</li>
                    <li>Shipping Guide</li>
                    <li>Products Support</li>
                    <li>Gift Card balance</li>
                </ul>
            </div>

            <div class="col-3">
                <ul class="footer_ul">Customer Services
                    <li>My Account</li>
                    <li>Track Your Order</li>
                    <li>FAQs</li>
                    <li>Payment Methods</li>
                    <li>Shipping Guide</li>
                    <li>Products Support</li>
                    <li>Gift Card balance</li>
                </ul>
            </div>


        </div>
        <hr>
        <div class="row footer_bot">
            <div class="col-6">
                Copyright ©
                <span style="color: #ffffff;"><a style="color: #ffffff;" href="#">Rubix</a></span>
                all rights reserved. Powered by
            </div>
            <div class="col-6">
                <img src="https://blueskytechco.com/rubix/wp-content/uploads/2021/01/payment.png" alt="">
            </div>
        </div>
    </div>
    <!-- Set up your HTML -->

    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <!-- <script
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
        ></script> -->
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    
       <script src="<c:url value='/resources/js/productDetail.js'/>"></script>
          <script src="<c:url value='/resources/js/home.js'/>"></script>
    
    <!-- owlcarousel2 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/qunit/2.18.1/qunit.min.js"
        integrity="sha512-ioX9yMm2dVWL5HF8AVsxIMNNs5SEQa0Pr73G3fQflXtZ/5O8zwqJGkyP9A9jFtOMms8IykDBLxfnSpJWqkEKmg=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <script src="/lib/OwlCarousel2-2.3.4/src/js/owl.carousel.js" data-cover></script>
    <script src="/lib/OwlCarousel2-2.3.4/src/js/owl.support.js" data-cover></script>
    <script src="/lib/OwlCarousel2-2.3.4/src/js/owl.autoplay.js" data-cover></script>
    <script src="unit/core.js" defer></script>
    <script src="unit/autoplay.js" defer></script>
    
    
    
</body>

</html>