<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/item-product.css">

<%-- <div class="col-sm-6 col-lg-3" onclick='window.location.href="san-pham/chi-tiet-san-pham?maSanPham=${item["maSanPham"]}"'  >
                        <div class="card_item">
                             <div class="item_img">
                       
                                <img src="<a:url value='/resources/images/${item["danhSachHinhAnhSanPham"][0]["hinhAnh"]}' />"
                                    alt="">
                                <div class="btn_add-to-card">
                                    <i class="fa fa-shopping-cart" aria-hidden="true"></i> Add to card
                                </div>
                            </div>
                            <div class="item_info">
                                <div class="item_title">${item["tenSanPham"] }</div>
                                <div class="item_info_price">

                                    <div class="item_price">${item["giaTien"]-item["giaTien"]*item["chietKhau"]/100 }</div>
                                    <div class="item_price_discount">${item["giaTien"] }</div>
                                </div>
                            </div> 
                            
						
                            <div class="card_item_action">
                                <a href=""><i class="card_icon fa fa-heart-o" aria-hidden="true"></i></a>
                                <a href=""><i class="card_icon fa fa-sliders" aria-hidden="true"></i></a>
                                <a href=""><i class="card_icon fa fa-eye" aria-hidden="true"></i></a>
                            </div>
                            <div class="sale">
                                Sale
                            </div>
                        </div>
                    </div> --%>

<div class="col-sm-6 col-lg-3 product-item men" onclick='window.location.href="san-pham/chi-tiet-san-pham?maSanPham=${item["maSanPham"]}"'>
	<div class="product discount product_filter">
		<div class="product_image">
			<img src="<a:url value='/resources/images/${item["danhSachHinhAnhSanPham"][0]["hinhAnh"]}' />">
		</div>
		<div class="favorite favorite_left"></div>
		<div
			class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center">
			<span>- ${item["chietKhau"]} %</span>
		</div>
		<div class="product_info">
			<h6 class="product_title">
				<a>${item["tenSanPham"] }</a>				
			</h6>
			<div class="product_price">
				${item["giaTien"]-item["giaTien"]*item["chietKhau"]/100 }<span>${item["giaTien"] }</span>
			</div>
		</div>
	</div>
	<div class="red_button add_to_cart_button">
		<a href="#">add to cart</a>
	</div>
</div>