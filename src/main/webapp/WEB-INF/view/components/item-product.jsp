<div
    class="${col !=false ? 'col-sm-6 col-lg-3 ':''} product-item men item"
    onclick='window.location.href="${pageContext.request.contextPath}/san-pham/chi-tiet-san-pham?maSanPham=${item["maSanPham"]}"'
>
    <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    <div class="product discount product_filter">
        <div class="product_image">
            <img
                src='${pageContext.request.contextPath}/resources/images/${item["danhSachHinhAnhSanPham"][0]["hinhAnh"]}'
            />
        </div>
        <div class="favorite favorite_left"></div>
        <div
            class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"
        >
            <span class="percent">${item["chietKhau"]}</span>
        </div>
        <div class="product_info">
            <h6 class="product_title">
                <a>${item["tenSanPham"]}</a>
            </h6>
            <div class="product_price">
                <div class="price">
                    ${item["giaTien"]-item["giaTien"]*item["chietKhau"]/100 }
                </div>
                <span class="price price_old">${item["giaTien"] }</span>
            </div>
        </div>
    </div>
    <div class="red_button add_to_cart_button w-100">
        <a href="#" class="w-100">Thêm vào giỏ hàng</a>
    </div>
</div>
