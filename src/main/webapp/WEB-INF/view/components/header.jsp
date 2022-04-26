<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
        <!-- this is so important. ajax will call it -->
        <script>var contextPath = "${pageContext.request.contextPath}"</script>
        <script src="<c:url value='/resources/js/layout.js'/>" defer="defer"></script>
        <header class="header trans_300">

            <!-- Top Navigation -->

            <div class="top_nav">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="top_nav_left">free shipping on all u.s orders over $50</div>
                        </div>
                        <div class="col-md-6 text-right">
                            <div class="top_nav_right">
                                <ul class="top_nav_menu">

                                    <!-- Currency / Language / My Account -->

                                    <li class="currency">
                                        <a href="#">
                                            usd
                                            <i class="fa fa-angle-down"></i>
                                        </a>
                                        <ul class="currency_selection">
                                            <li><a href="#">cad</a></li>
                                            <li><a href="#">aud</a></li>
                                            <li><a href="#">eur</a></li>
                                            <li><a href="#">gbp</a></li>
                                        </ul>
                                    </li>
                                    <li class="language">
                                        <a href="#">
                                            English
                                            <i class="fa fa-angle-down"></i>
                                        </a>
                                        <ul class="language_selection">
                                            <li><a href="#">French</a></li>
                                            <li><a href="#">Italian</a></li>
                                            <li><a href="#">German</a></li>
                                            <li><a href="#">Spanish</a></li>
                                        </ul>
                                    </li>
                                    <li class="account">
                                        <a href="#">
                                            My Account
                                            <i class="fa fa-angle-down"></i>
                                        </a>
                                        <ul class="account_selection">
                                            <li><a href=""><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a>
                                            </li>
                                            <li><a href="" data-toggle="modal" data-target="#RegisterModal"
                                                    aria-hidden="true"><i class="fa fa-user-plus"
                                                        aria-hidden="true"></i>Register</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Main Navigation -->

            <div class="main_nav_container">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-right">
                            <div class="logo_container">
                                <a href="#">colo<span>shop</span></a>
                            </div>
                            <nav class="navbar">
                                <ul class="navbar_menu">
                                    <li><a href="">home</a></li>
                                    <li><a href="shop">shop</a></li>
                                    <li><a href="#">promotion</a></li>
                                    <li><a href="#">pages</a></li>
                                    <li><a href="#">blog</a></li>
                                    <li><a href="contact.html">contact</a></li>
                                </ul>
                                <ul class="navbar_user">
                                    <li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>
                                    <li class="checkout">
                                        <a href="" data-toggle="modal" data-target="#CardModal" aria-hidden="true" onclick="loadDuLieuGioHang()">
                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                            <span id="checkout_items" class="checkout_items">2</span>
                                        </a>
                                    </li>
                                </ul>
                                <div class="hamburger_container">
                                    <i class="fa fa-bars" aria-hidden="true"></i>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade model_card" id="CardModal" tabindex="-1" role="dialog"
                aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <input type="checkbox" class="check_all">
                            <h5 class="modal-title" id="exampleModalLabel">Giỏ hàng</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body modal_body_card" id="cardProducts">
                             <c:forEach var="item" items="${dsSanPhamTrongGioHang}">

                                <%-- <div class="card_product">
                                    <div class="check_item">
                                        <input type="checkbox" class="check_item_input">
                                    </div>
                                    <div class="card_item_img">
                                        <img
                                            src='${pageContext.request.contextPath}/resources/images/${item.chiTietSanPham.sanPham.danhSachHinhAnhSanPham[0].hinhAnh}'>
                                    </div>
                                    <div class="card_item_info">
                                        <div class="card_item_info_name break_text">
                                            ${item.chiTietSanPham.sanPham.tenSanPham}</div>
                                        <!-- <div class="card_item_info_quatity">1</div> -->
                                        <div class="quantity">

                                            <button class="btn ml-2 " onclick='quantityPrivate(this)'> <i
                                                    class="fa fa-minus" aria-hidden="true"></i></button>
                                            <span class="item_quantity quantity-number">${item.soLuong }</span>
                                            <button class="btn mr-2 "
                                                onclick='quantityPluss(this,${item.chiTietSanPham.soLuongTon})'> <i
                                                    class="fa fa-plus" aria-hidden="true"></i></button>

                                        </div>
                                        <div class="card_item_info_price_item">
                                            <div class="card_item_info_price price">
                                                ${item.chiTietSanPham.sanPham.giaTien-item.chiTietSanPham.sanPham.giaTien*item.chiTietSanPham.sanPham.chietKhau/100}
                                            </div>
                                            <div class="card_item_info_total price">
                                                ${item.soLuong*(item.chiTietSanPham.sanPham.giaTien-item.chiTietSanPham.sanPham.giaTien*item.chiTietSanPham.sanPham.chietKhau/100)
                                                }</div>
                                        </div>
                                    </div>
                                    <button type="button" class="close delete_item" data-dismiss="modal"
                                        aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div> --%>

                            </c:forEach>
 

                        </div>
                        <div class="modal-footer">
                            <div class="Subtotal">
                                <div class="Subtotal_title">Tổng tiền</div>
                                <div class="Subtotal_price price">0</div>
                            </div>
                            <div class="block_checkout">

                                <button type="button" class="btn_checkout" data-dismiss="modal">Thanh Toán</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Modal card -->


            <!-- Modal Register -->

            <div class="modal fade model_card" id="RegisterModal" tabindex="-1" role="dialog"
                aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <div class="register_header_logo">
                                <img src="https://blueskytechco.com/rubix/wp-content/uploads/2021/05/logo_x2.png"
                                    alt="">
                                <h5 class="modal-title" id="exampleModalLabel">ĐĂNG KÝ TÀI KHOẢN</h5>
                            </div>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body modal_body_register">

                            <form>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example1cg">Your Name: </label>
                                    <input type="text" id="form3Example1cg" class="form-control form-control" />
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example3cg">Your Email:</label>
                                    <input type="email" id="form3Example3cg" class="form-control form-control" />
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cg">Password:</label>
                                    <input type="password" id="form3Example4cg" class="form-control form-control" />
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cdg">Repeat your password:</label>
                                    <input type="password" id="form3Example4cdg" class="form-control form-control" />
                                </div>

                                <div class="form-check-inline d-flex justify-content-center mb-5">
                                    <input class="form-check-input me-2" type="checkbox" value=""
                                        id="form2Example3cg" />
                                    <label class="form-check-label" for="form2Example3g">
                                        I agree all statements in <a href="#!" class="text-body"><u>Terms of
                                                service</u></a>
                                    </label>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <button type="button"
                                        class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0 register_login_here">Have already an account?
                                    <a href="#!" class="fw-bold text-body"><u>Login here</u></a>
                                </p>

                            </form>


                        </div>
                    </div>
                </div>
            </div>

            <!-- end -->

        </header>