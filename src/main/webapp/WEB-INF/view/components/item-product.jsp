<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<link rel="stylesheet" href="<c:url value='/resources/components/item-product/item-product.css' />">
<%@ taglib prefix = "a" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="col-3" onclick='window.location.href="san-pham/chi-tiet-san-pham?maSanPham=${item["maSanPham"]}"'  >
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
                    </div>