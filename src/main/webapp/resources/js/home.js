(async () => {
    await filterByButton("ALL");
    document.getElementsByClassName("grid_sorting_button button")[0].click();
})();
$(document).ready(function () {
    $(".categories__nav__item__level1").click(function () {
        const id = this.id;
        // $(`#${id}_items`).toggle();
        $("#" + id + "_items").toggle();
    });
});
//  Format Currency in all elemeny have class = price
(() => {
    document.querySelectorAll(".price").forEach((e) => {
        e.innerText = formatCurrency(e.innerText);
    });
})();
// Format Currency
function formatCurrency(number) {
    // console.log(number);
    // if (isNaN(number)) return number;
    return new Intl.NumberFormat("vi-VN", {
        style: "currency",
        currency: "VND",
    }).format(number);
}
//  part int number in all elemeny have class = percent
(() => {
    document.querySelectorAll(".percent").forEach((e) => {
        e.innerText = parseInt(e.innerText) + "%";
    });
})();

function sliderItemProduct() {
    $(".items-product-suggest.owl-carousel").owlCarousel({
        items: 5,
        animateOut: "fadeOut",
        nav: true,
        lazyLoad: true,
        responsiveClass: true,
        loop: true,
        autoplay: true,
        autoplayTimeout: 3000,
        autoplayHoverPause: true,
    });
    console.log(2);
}

$(document).ready(function () {
    $(".slider.owl-carousel").owlCarousel({
        items: 1,
        animateOut: "fadeOut",
        nav: true,
        responsiveClass: true,
        loop: true,
        margin: 10,
        autoplay: true,
        autoplayTimeout: 3000,
        autoplayHoverPause: true,
    });
});

async function fiterByButtonCategori(e) {
    activeButton(e);
    var inner = e.innerText;
    console.log("==============" + inner);
    await filterByButton(inner);
    var $owl = $(".items-product-suggest.owl-carousel");
    $owl.trigger("destroy.owl.carousel");
    // After destory, the markup is still not the same with the initial.
    // The differences are:
    //   1. The initial content was wrapped by a 'div.owl-stage-outer';
    //   2. The '.owl-carousel' itself has an '.owl-loaded' class attached;
    //   We have to remove that before the new initialization.
    $owl.html($owl.find(".owl-stage-outer").html()).removeClass("owl-loaded");

    sliderItemProduct();
}

function activeButton(e) {
    clearActiveButton();
    e.classList.add("active");
}

function clearActiveButton() {
    var listPage = document.querySelectorAll(".grid_sorting_button");
    listPage.forEach((el) => {
        el.classList.remove("active");
    });
}

async function filterByButton(condition) {
    var a = await fetch(
        contextPath +
            `/trang-chu/loc?` +
            new URLSearchParams({
                condition: condition,
            })
    );
    var result = await a.json();
    console.log(result);
    var filterContainer = document.getElementById("fiterContainer");
    filterContainer.innerHTML = result
        .map((e) => {
            return `
    <div class="product-item men item"
    onclick='window.location.href="${contextPath}/san-pham/chi-tiet-san-pham?maSanPham=${
                e.maSanPham
            }"'>

        <div class="product discount product_filter">

            <div class="product_image">
                <img
                    src='${contextPath}/resources/images/${
                e.danhSachHinhAnhSanPham[0].hinhAnh
            }'>
            </div>
            <div class="favorite favorite_left"></div>
            <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center">
                <span class='percent'>${e.chietKhau} %</span>
            </div>
            <div class="product_info">
                <h6 class="product_title">
                    <a>${e.tenSanPham}</a>
                </h6>
                <div class="product_price">
                    <div class="price">${formatCurrency(
                        e.giaTien - (e.giaTien * e.chietKhau) / 100
                    )}</div> <span
                        class="price">${formatCurrency(e.giaTien)}</span>
                </div>
            </div>
        </div>
        <div class="red_button add_to_cart_button w-100 ">
            <a href="#" class='w-100'>Thêm vào giỏ hàng</a>
        </div>
</div>
    `;
        })
        .join(" ");
    console.log(1);
}
