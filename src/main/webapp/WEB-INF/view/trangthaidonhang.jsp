<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title> --- </title>
                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                    crossorigin="anonymous" />

                <link rel="stylesheet" href="<c:url value='/resources/css/trangthaidonhang.css' />">
                 <link rel="stylesheet" href="<c:url value='/resources/css/layout.css' />">
            </head>


            <body>
                <div class="container--fluid">

                    <div id='header'>
                        <jsp:include page="components/header.jsp"></jsp:include>
                    </div>


                    <div class="components">
                        <!-- Body -->
                        <div class="container">
                            <!-- breadcrumb -->

                            <div class="breadcrumb-components">
                                <jsp:include page="components/breadcrumb.jsp"></jsp:include>
                            </div>
                            <!-- /breadcrumb -->

							<div class="container">
                <div class="component block-btn-status ">
                    <div class="btn-status ">Tất cả</div>
                    <div class="btn-status ">Chờ xác nhận</div>
                    <div class="btn-status ">Chờ lấy hàng</div>
                    <div class="btn-status ">Đang giao</div>
                    <div class="btn-status ">Đã giao</div>
                    <div class="btn-status ">Đã hủy</div>
                </div>

                <!-- <div class="component p-2"> -->
                    <div class="search_block">
                        <i class="fa fa-search" aria-hidden="true"></i>
                        
                        <input type="text" placeholder="Tìm kiếm theo mã hóa đơn, tên sản phẩm" class="txtSearch">
                    </div>
                <!-- </div> -->

                <div class="component order_status_block">
                    <div class="order_status_item_header">
                         <i class="fa fa-truck" aria-hidden="true"></i>
                        <div class="order_status_result">Giao hàng thành công</div>
                        <span>|</span>
                        <div class="order_status_name">ĐÃ GIAO</div>
                    </div>

                    <div class="order_status_item_body">
                        <div class="img_name_orderstatus">

                            <div class="order_status_item_img">
                                <img src="https://cf.shopee.vn/file/22a25d5e5e04fcdcc426c0eacee62518_tn" alt="">
                            </div>
                            <div class="order_status_item_info">
                                <div class="order_status_item_name break_text"> Hướng Dẫn Thực Hành CANSLIM Cho Người Mới Bắt Đầu Bộ sách Làm Giàu Từ </div>
                                <div class="order_status_item_quatity">Số lượng: <span>1</span></div>
                            </div>
                        </div>
                        <div class="order_status_item_price">700.000 đ</div>
                    </div>

                    <div class="order_status_item_footer">
                     <div class="order_status_item_footer_price">
                         <div class="order_status_item_footer_price_title">Tổng số tiền:</div>
                         <div class="order_status_item_footer_price_nane">720.500</div>
                     </div>
                     <div class="order_status_item_footer_btn">
                         <button class="btn_first btn text-white mr-4" style="width: 156px; background-color: #fe4c50;">Mua Lại</button>
                         <button class="btn bg-white" style="border: 1px solid #ccc;">Liên hệ Người Bán</button>
                     </div>
                    </div>
             </div>

             <div class="component order_status_block">
                <div class="order_status_item_header">
                     <i class="fa fa-truck" aria-hidden="true"></i>
                    <div class="order_status_result">Giao hàng thành công</div>
                    <span>|</span>
                    <div class="order_status_name">ĐÃ GIAO</div>
                </div>

                <div class="order_status_item_body">
                    <div class="img_name_orderstatus">

                        <div class="order_status_item_img">
                            <img src="https://cf.shopee.vn/file/22a25d5e5e04fcdcc426c0eacee62518_tn" alt="">
                        </div>
                        <div class="order_status_item_info">
                            <div class="order_status_item_name break_text"> Hướng Dẫn Thực Hành CANSLIM Cho Người Mới Bắt Đầu Bộ sách Làm Giàu Từ </div>
                            <div class="order_status_item_quatity">Số lượng: <span>1</span></div>
                        </div>
                    </div>
                    <div class="order_status_item_price">700.000 đ</div>
                </div>

                <div class="order_status_item_footer">
                 <div class="order_status_item_footer_price">
                     <div class="order_status_item_footer_price_title">Tổng số tiền:</div>
                     <div class="order_status_item_footer_price_nane">720.500</div>
                 </div>
                 <div class="order_status_item_footer_btn">
                     <button class="btn_first btn text-white mr-4" style="width: 156px; background-color: #fe4c50;">Mua Lại</button>
                     <button class="btn bg-white" style="border: 1px solid #ccc;">Liên hệ Người Bán</button>
                 </div>
                </div>
         </div>

         <div class="component order_status_block">
                <div class="order_status_item_header">
                    <i class="fa fa-truck" aria-hidden="true"></i>
                    <div class="order_status_result">Giao hàng thành công</div>
                    <span>|</span>
                    <div class="order_status_name">ĐÃ GIAO</div>
             </div>

            <div class="order_status_item_body">
                <div class="img_name_orderstatus">

                    <div class="order_status_item_img">
                        <img src="https://cf.shopee.vn/file/22a25d5e5e04fcdcc426c0eacee62518_tn" alt="">
                    </div>
                    <div class="order_status_item_info">
                        <div class="order_status_item_name break_text"> Hướng Dẫn Thực Hành CANSLIM Cho Người Mới Bắt Đầu Bộ sách Làm Giàu Từ </div>
                        <div class="order_status_item_quatity">Số lượng: <span>1</span></div>
                    </div>
                </div>
                <div class="order_status_item_price">700.000 đ</div>
            </div>

           

            <div class="order_status_item_footer">
             <div class="order_status_item_footer_price">
                 <div class="order_status_item_footer_price_title">Tổng số tiền:</div>
                 <div class="order_status_item_footer_price_nane">720.500</div>
             </div>
             <div class="order_status_item_footer_btn">
                 <button class="btn_first btn text-white mr-4" style="width: 156px; background-color: #fe4c50;">Mua Lại</button>
                 <button class="btn bg-white" style="border: 1px solid #ccc;">Liên hệ Người Bán</button>
             </div>
            </div>
         </div>
							


                            <!-- /Body -->
                        </div>
                    </div>

                    <nav class="pagination_block" aria-label="...">
                        <ul class="pagination" id="pagination_id">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1"><i class="fa fa-angle-left"
                                        aria-hidden="true"></i></a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item active">
                                <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
                            </li>
                        </ul>
                    </nav>
                    
                    <div id='footer'>
                        <jsp:include page="components/footer.jsp"></jsp:include>
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