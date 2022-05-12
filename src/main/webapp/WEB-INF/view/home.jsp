<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="utf-8">
                <title>Insert title here</title>

                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                    crossorigin="anonymous" />
                <link rel="stylesheet" href="<c:url value='/resources/css/shop.css' />">
                <link rel="stylesheet" href="<c:url value='/resources/css/home.css' />">
                <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/item-product.css">

                <!-- owlcarousel2 -->

                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/qunit/2.18.1/qunit.css"
                    integrity="sha512-ZCCKiB7dW1caC4UXu/J3xiZVV+nf4KEBFhp1AAc2q9S30+Di9o9hnXHdGuJaMc1pD/Fv2tc8e3PneXR1M/mJ4w=="
                    crossorigin="anonymous" referrerpolicy="no-referrer" />

                <link rel="stylesheet" href="<c:url value='/resources/css/lib/owl.theme.default.min.css' />">
                <link rel="stylesheet" href="<c:url value='/resources/css/lib/owl.carousel.min.css' />">


            </head>

            <body>
                <div class="">
                    <jsp:include page="components/header.jsp"></jsp:include>
                    <section>

                        <div class='slider'>
                            <div class="slider owl-carousel  owl-theme">
                                <div class="item" >
                                    <img 
                                        src='${pageContext.request.contextPath}/resources/imgSlider/slider_pic2.jpg'>                                       
                                </div>
                                  <div class="item">
                                    <img
                                        src='${pageContext.request.contextPath}/resources/imgSlider/slider1_pic.jpg'>
                      
                                </div>
                            </div>
                        </div>

                        <div class="banner">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="banner_item align-items-center"
                                            style="background-image:url(https://leanhtien.net/wp-content/uploads/2020/12/71.jpg)">
                                            <div class="banner_category">
                                                <a href="/ShopSport/shop?key=1">QUẦN ÁO</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="banner_item align-items-center"
                                            style="background-image:url(data:image/webp;base64,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)">
                                            <div class="banner_category">
                                                <a href="/ShopSport/shop?key=2">DỤNG CỤ & THIẾT BỊ</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="banner_item align-items-center"
                                            style="background-image:url(https://cf.shopee.vn/file/fbfdad77c8d108e2f6aff2036c8f8980)">
                                            <div class="banner_category">
                                                <a href="/ShopSport/shop?key=3">GIẦY THỂ THAO</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- New Arrivals -->

                        <div class="new_arrivals">
                            <div class="container">
                                <div class="row">
                                    <div class="col text-center">
                                        <div class="section_title new_arrivals_title">
                                            <h2>New Arrivals</h2>
                                        </div>
                                    </div>
                                </div>
                                <div class="row align-items-center">
                                    <div class="col text-center">
                                        <div class="new_arrivals_sorting">
                                            <ul
                                                class="arrivals_grid_sorting clearfix button-group filters-button-group">
                                                <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked"
                                                 onclick="fiterByButtonCategori(this)">all</li>
                                                <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
                                                onclick="fiterByButtonCategori(this)">Quần áo</li>
                                                <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
                                                onclick="fiterByButtonCategori(this)">Dụng cụ & thiết bị</li>
                                                <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
                                                onclick="fiterByButtonCategori(this)">Giầy thể thao</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="items-product-suggest owl-carousel" id="fiterContainer">
                                        <!-- <c:forEach var="item" items="${listSanPham }" varStatus="status">
                                            <c:set var="item" value="${item}" scope="request" />
                                            <c:set var="col" value="${false}" scope="request" />
                                            <jsp:include page="components/item-product.jsp">
                                                <jsp:param value="${col}" name="col" />
                                                <jsp:param value="${item }" name="item" />
                                            </jsp:include>
                                        </c:forEach> -->

                                    </div>
                                </div>

                                <!-- Deal of the week -->
                            </div>

                            <div class="deal_ofthe_week">
                                <div class="container">
                                    <div class="row align-items-center">
                                        <div class="col-lg-6">
                                            <div class="deal_ofthe_week_img">
                                                <img src="https://sre.com.vn/wp-content/uploads/2020/12/top-5-tay-vot-xuat-sac-nhat-moi-thoi-dai-trong-lang-quan-vot-rafael-nadal-earns-fourth-stefan-edberg-sportsmanship-award.jpg"
                                                    alt="">
                                            </div>
                                        </div>
                                        <div class="col-lg-6 text-right deal_ofthe_week_col">
                                            <div
                                                class="deal_ofthe_week_content d-flex flex-column align-items-center float-right">
                                                <div class="section_title">
                                                    <h2>Deal Of The Week</h2>
                                                </div>
                                                <ul class="timer">
                                                    <li
                                                        class="d-inline-flex flex-column justify-content-center align-items-center">
                                                        <div id="day" class="timer_num">03</div>
                                                        <div class="timer_unit">Day</div>
                                                    </li>
                                                    <li
                                                        class="d-inline-flex flex-column justify-content-center align-items-center">
                                                        <div id="hour" class="timer_num">15</div>
                                                        <div class="timer_unit">Hours</div>
                                                    </li>
                                                    <li
                                                        class="d-inline-flex flex-column justify-content-center align-items-center">
                                                        <div id="minute" class="timer_num">45</div>
                                                        <div class="timer_unit">Mins</div>
                                                    </li>
                                                    <li
                                                        class="d-inline-flex flex-column justify-content-center align-items-center">
                                                        <div id="second" class="timer_num">23</div>
                                                        <div class="timer_unit">Sec</div>
                                                    </li>
                                                </ul>
                                                <div class="red_button deal_ofthe_week_button"><a href="#">shop now</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="best_sellers">
                            <div class="container">
                                <div class="row">
                                    <div class="col text-center">
                                        <div class="section_title new_arrivals_title">
                                            <h2>Best Sellers</h2>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="items-product-suggest owl-carousel" id="bestseller_product_container">
                                        <!-- <c:forEach var="item" items="${listSanPham }" varStatus="status">
                                            <c:set var="item" value="${item}" scope="request" />
                                            <c:set var="col" value="${false}" scope="request" />
                                            <jsp:include page="components/item-product.jsp">
                                                <jsp:param value="${col}" name="col" />
                                                <jsp:param value="${item }" name="item" />
                                            </jsp:include>
                                        </c:forEach> -->

                                        <!-- <script>
                                            console.log("vào best seller");
                                            hiddenPrice();
                                        </script> -->

                                    </div>
                                </div>
                            </div>

                    </section>

                    <jsp:include page="components/footer.jsp"></jsp:include>


                </div>
                <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                    crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                    crossorigin="anonymous"></script>

                <!--  Custome js-->
                <script src="<c:url value='/resources/js/home.js'/>"></script>
                <script src="<c:url value='/resources/js/filter.js'/>"></script>


                <!-- owlcarousel2 -->
                <script src="https://cdnjs.cloudflare.com/ajax/libs/qunit/2.18.1/qunit.min.js"
                    integrity="sha512-ioX9yMm2dVWL5HF8AVsxIMNNs5SEQa0Pr73G3fQflXtZ/5O8zwqJGkyP9A9jFtOMms8IykDBLxfnSpJWqkEKmg=="
                    crossorigin="anonymous" referrerpolicy="no-referrer"></script>

                <script src="<c:url value='/resources/js/lib/owl.carousel.js'/>" data-cover></script>
                <script src="<c:url value='/resources/js/lib/owl.support.js'/>" data-cover></script>
                <script src="<c:url value='/resources/js/lib/owl.autoplay.js'/>" data-cover></script>

            </body>

            </html>