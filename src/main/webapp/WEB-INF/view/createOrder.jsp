<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title> Mua hàng </title>
                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                    crossorigin="anonymous" />

                <link rel="stylesheet" href="<c:url value='/resources/css/home.css' />">

                <link rel="stylesheet" href="<c:url value='/resources/css/layout.css' />">
                <link rel="stylesheet" href="<c:url value='/resources/css/createOrder.css' />">
            </head>


            <body>
                <div class="container--fluid">

                    <div id='header'>
                        <jsp:include page="components/header.jsp"></jsp:include>
                    </div>
                    <div class="components ">
                        <div class="container">
                            <!-- Body -->
                            <!-- breadcrumb -->

                            <div class="breadcrumb-components">
                                <jsp:include page="components/breadcrumb.jsp"></jsp:include>
                            </div>
                            <!-- /breadcrumb -->

                            <div class='row'>
                                <div class="box  col-8">
                                    <div class="header-title">
                                        <span> Địa chỉ giao hàng</span>
                                    </div>
                                    <div class="component pt-3 mb-4 pb-2">
                                        <div class="row">
                                            <div class="col-6">
                                                <div class="form-group">
                                                    <label for="hoTen">Họ tên</label>
                                                    <input type="text" name="hoTen" id="hoTen" class="form-control"
                                                        placeholder="Nhập họ và tên" aria-describedby="helpId">
                                                    <small id="helpHoTen" class="text-muted"></small>
                                                </div>
                                                <div class="form-group">
                                                    <label for="soDienThoai">Số điện thoại</label>
                                                    <input type="text" name="soDienThoai" id="soDienThoai"
                                                        class="form-control" placeholder="Nhập số điện thoại"
                                                        aria-describedby="helpId">
                                                    <small id="helpSoDienThoai" class="text-muted"></small>
                                                </div>

                                            </div>
                                            <div class="col-6">
                                                <div class="form-group">
                                                    <label for="tinhThanhPho">Tỉnh/Thành phố</label>
                                                    <select class="form-control" name="tinhThanhPho" id="tinhThanhPho">
                                                        <option selected disabled>Chọn tỉnh / thành phố</option>
                                                        <option>Hồ chí minh</option>
                                                        <option>Hà nội</option>
                                                        <option>Tây ninh</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="quanHuyen">Quận/Huyện</label>
                                                    <select class="form-control" name="quanHuyen" id="quanHuyen">
                                                        <option selected disabled>Chọn quận / huyện</option>
                                                        <option>Quận 1</option>
                                                        <option>Quận 2</option>
                                                        <option>Quận 3</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="phuongXa">Phường xã</label>
                                                    <select class="form-control" name="phuongXa" id="phuongXa">
                                                        <option selected disabled>Chọn phường xã</option>
                                                        <option>Hồ chí minh</option>
                                                        <option>Hà nội</option>
                                                        <option>Tây ninh</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="diaChi">Địa chỉ</label>
                                                    <input type="text" name="diaChiChiTiet" id="diaChi"
                                                        class="form-control" placeholder="Nhập địa chỉ"
                                                        aria-describedby="helpId">
                                                    <small id="helpDiaChi" class="text-muted"></small>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="header-title mt-4">
                                        <span>Sản phẩm đặt</span>
                                    </div>

                                    <div class="component">
                                        <div>
                                            <div class=choise-delivery>
                                                <small>Choose your delivery option</small>
                                            </div>
                                            <div class='card-select color-blue' style="width: 250px">
                                                <div class=" top">
                                                    <div class="info">
                                                        <img alt="" width="15"
                                                            src="${pageContext.request.contextPath}/resources/images/icon/checkIcon.png">

                                                        <span class="price pl-2">₫ 30,000</span>
                                                    </div>
                                                </div>
                                                <div class="bot">
                                                    <small class="sub">GH tiêu chuẩn</small> <br>
                                                    <small class="sub">Nhận vào: 23 thg 4-16 thg 5</small>
                                                </div>
                                            </div>
                                        </div>
                                        <div class='items-order'>
                                        	<div class='item'>
                                        	
                                        	</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="box col-4 pl-2">
                                    <div class="header-title">
                                        <span> Thanh toán</span>

                                    </div>
                                    <div class="component ">
                                        <div>
                                            <div class="title-component">
                                                <span>Chọn phương thức thanh toán</span>
                                            </div>
                                            <div class='card-select'>
                                                <div class=" top">
                                                    <div class="info">
                                                        <img alt="" width="30"
                                                            src="https://laz-img-cdn.alicdn.com/tfs/TB1ZP8kM1T2gK0jSZFvXXXnFXXa-96-96.png">
                                                        <span class="title">Thanh toán khi nhận hàng</span>
                                                    </div>
                                                    <div class="icon ">
                                                        <img alt="" width="15"
                                                            src="${pageContext.request.contextPath}/resources/images/icon/checkIcon.png">
                                                    </div>
                                                </div>
                                                <div class="bot">
                                                    <small class="sub">Thanh toán tại nhà cho đơn vị vận chuyển</small>
                                                </div>
                                            </div>

                                        </div>
                                        <div>
                                            <div class="title-component mt-4">
                                                <span>Giảm giá</span>

                                            </div>
                                            <div class="input-group mb-3">
                                                <input type="text" class="form-control" placeholder="Nhập mã giảm giá"
                                                    aria-describedby="basic-addon2">
                                                <div class="input-group-append ">
                                                    <span class="input-group-text bg-primary text-white"
                                                        id="basic-addon2">Thêm</span>
                                                </div>
                                            </div>

                                        </div>
                                        <div>
                                            <div class="title-component mt-4">
                                                <span>Tổng quan</span>
                                            </div>
                                            <div class='general-line'>
                                                <span class='left title'> Tổng đơn hàng</span>
                                                <span class='right price'>₫ 243,000</span>
                                            </div>
                                            <div class='general-line'>
                                                <span class='left '>Phí vận chuyển</span>
                                                <span class='right price'> ₫ 30,000</span>
                                            </div>
                                            <hr>
                                            <div class='general-line'>
                                                <span class='left text-dark'>Tổng</span>
                                                <span class='right price text-danger'> ₫ 30,000</span>
                                            </div>
                                        </div>
                                        <div class='btn-xac-nhan'>
                                            <input type="button" class="form-control btn bg-danger text-white"
                                                value="Thanh toán">
                                        </div>
                                    </div>

                                </div>
                            </div>



                            <!-- /Body -->
                        </div>

                        <div id='footer'>
                            <jsp:include page="components/footer.jsp"></jsp:include>
                        </div>
                    </div>

                </div>
                <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                    crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                    crossorigin="anonymous"></script>
            </body>

            </html>