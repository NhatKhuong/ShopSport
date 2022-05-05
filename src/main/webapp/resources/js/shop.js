var offsetSub = 0;
var numPageSub;
var limitSub = 5;
var numButtonOldActice;

const urlParams = new URLSearchParams(window.location.search);
const myParam = urlParams.get("key");
console.log("myParam====" + myParam);
if (myParam == 1) {
    var inputQuanAo = document.getElementById("LSP00001");
    console.log(inputQuanAo.checked);
    inputQuanAo.checked = true;
} else if (myParam == 2) {
    var inputDungCu = document.getElementById("LSP00003");
    console.log(inputDungCu);
    inputDungCu.checked = true;
} else if (myParam == 3) {
    var inputGiay = document.getElementById("LSP00004");
    console.log(inputGiay);
    inputGiay.checked = true;
}

searchFilterCheckbox();

// jQuery(document).ready(function ($) {
//
var header = $(".header");
var topNav = $(".top_nav");
var mainSlider = $(".main_slider");
var hamburger = $(".hamburger_container");
var menu = $(".hamburger_menu");
var menuActive = false;
var hamburgerClose = $(".hamburger_close");
var fsOverlay = $(".fs_menu_overlay");

console.log(header);

setHeader();

function setHeader() {
    if (window.innerWidth < 992) {
        if ($(window).scrollTop() > 100) {
            header.css({ top: "0" });
        } else {
            header.css({ top: "0" });
        }
    } else {
        if ($(window).scrollTop() > 100) {
            header.css({ top: "-50px" });
        } else {
            header.css({ top: "0" });
        }
    }
    if (window.innerWidth > 991 && menuActive) {
        closeMenu();
    }
}

function initPriceSlider() {
    console.log("cateforufdf" + maxPrice);
    $("#slider-range").slider({
        range: true,
        min: 0,
        max: maxPrice,
        values: [0, Math.floor(maxPrice / 4)],
        slide: function (event, ui) {
            $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
        },
    });

    $("#amount").val(
        "$" +
            $("#slider-range").slider("values", 0) +
            " - $" +
            $("#slider-range").slider("values", 1)
    );
}
// });

async function getNumpage(
    strLoaiSanPham,
    strMonTheThao,
    strNhanHieu,
    priceFrom,
    priceTo,
    limit
) {
    var a = await fetch(
        contextPath +
            `/cua-hang/soTrang?` +
            new URLSearchParams({
                listLoaiSanPham: strLoaiSanPham,
                listMonTheThao: strMonTheThao,
                listNhanHieu: strNhanHieu,
                price_to: priceTo,
                price_from: priceFrom,
                limit: limit,
            })
    );
    return await a.json();
}

function clearActiveButtonPagination() {
    var listPage = document.querySelectorAll(".page-item");
    listPage.forEach((el) => {
        el.classList.remove("active");
    });
}

function resetActiveButonWhenClickNextPage() {
    var listPage = document.querySelectorAll(".page-item");
    console.log("listPage.target:" + listPage);
    console.log("numButtonReset=======" + numButtonOldActice);
    listPage.forEach((el) => {
        console.log(el.target);
        if (
            el.getElementsByClassName("page-link")[0].innerText ===
            numButtonOldActice
        ) {
            console.log("el: " + el);
            el.classList.add("active");
        }
    });
}

function getPageActiveAndDisableOutButton(e) {
    console.log("111111111111111111");
    console.log(e);
    clearActiveButtonPagination();

    e.classList.add("active");
    numButtonOldActice = e.getElementsByClassName("page-link")[0].innerText;
    console.log("numButtonOldActice: " + numButtonOldActice);

    // var price_to = 100000000;
    // var price_from = 0;

    var priceRange = $("#amount").val();
    var price_from = parseFloat(priceRange.split("-")[0].replace("$", ""));
    var price_to = parseFloat(priceRange.split("-")[1].replace("$", ""));
    console.log(priceRange, price_from, price_to);

    var elementsLoaiSanPham = document.getElementsByClassName(
        "categories__nav__item__level2_loaiSanPham"
    );
    var elementsMonTheThao = document.getElementsByClassName(
        "categories__nav__item__level2_monTheThao"
    );
    var elementsNhanHieu = document.getElementsByClassName(
        "categories__nav__item__level2_nhanHieu"
    );

    var listLoaiSanPham = [];
    for (var i = 0; i < elementsLoaiSanPham.length; i++) {
        if (elementsLoaiSanPham[i].querySelector("input:checked")) {
            listLoaiSanPham.push(
                elementsLoaiSanPham[i].querySelector("label").innerText
            );
        }
    }

    var listMonTheThao = [];
    for (var i = 0; i < elementsMonTheThao.length; i++) {
        if (elementsMonTheThao[i].querySelector("input:checked")) {
            listMonTheThao.push(
                elementsMonTheThao[i].querySelector("label").innerText
            );
        }
    }

    var listNhanHieu = [];
    for (var i = 0; i < elementsNhanHieu.length; i++) {
        if (elementsNhanHieu[i].querySelector("input:checked")) {
            listNhanHieu.push(
                elementsNhanHieu[i].querySelector("label").innerText
            );
        }
    }
    var pageIndex;
    try {
        pageIndex = document
            .querySelector(".active")
            .getElementsByClassName("page-link")[0].innerText;
    } catch (error) {
        pageIndex = 1;
    }

    console.log("searchFilter-------------" + pageIndex);
    var limit = document.querySelector("select").value;
    console.log("limit---------" + limit);

    searchFilter(
        listLoaiSanPham,
        listMonTheThao,
        listNhanHieu,
        pageIndex,
        price_to,
        price_from,
        limit
    );
}

// function renderPagination(numPage) {
//     var nextLeft = `
//     <li class="page-item disabled">
//         <a class="page-link" href="#" tabindex="-1"><i class="fa fa-angle-left"
//         aria-hidden="true"></i></a>
//     </li>`;
//     var nextRight = `
//         <li class="page-item onclick=searchFilter()">
//             <a class="page-link" href="#"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
//         </li>
//     `;

//     var li_item = "";
//     if (numPage == 1) {
//         li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${numPage}</a></li>`;
//     } else if (numPage > 1) {
//         li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">1</a></li>`;
//         for (var i = 2; i <= numPage; i++) {
//             li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
//         }
//     }
//     var pagination_id = document.getElementById("pagination_id");
//     pagination_id.innerHTML = nextLeft + li_item + nextRight;
// }

function nextPage() {
    var maxOffset;
    if (numPageSub < limitSub) {
        maxOffset = 0;
    } else {
        maxOffset =
            numPageSub % limitSub == 0
                ? Math.floor(numPageSub / limitSub) - 1
                : Math.floor(numPageSub / limitSub);
    }

    if (offsetSub < maxOffset) {
        offsetSub = offsetSub + 1;
        renderPagination(numPageSub, offsetSub, limitSub);
        clearActiveButtonPagination();
        console.log("next---" + numButtonOldActice);
        resetActiveButonWhenClickNextPage();
    }
}

function backPage() {
    if (offsetSub > 0) {
        offsetSub = offsetSub - 1;
        renderPagination(numPageSub, offsetSub, limitSub);
        clearActiveButtonPagination();
        console.log("back----" + numButtonOldActice);
        resetActiveButonWhenClickNextPage();
    }
}

function renderPagination(numPage, offset, limit) {
    console.log("Numpage:===" + numPage);
    console.log("limit:===" + limit);

    var maxOffset;
    if (numPage < limit) {
        maxOffset = 0;
    } else {
        maxOffset =
            numPage % limit == 0
                ? Math.floor(numPage / limit) - 1
                : Math.floor(numPage / limit);
    }

    console.log("offsetSub====" + offsetSub);
    console.log("maxOffset=====" + maxOffset);
    var nextLeft = `
    <li onclick="backPage()" class="page-item">
        <a class="page-link" href="#" tabindex="-1"><i class="fa fa-angle-left"
        aria-hidden="true"></i></a>
    </li>`;
    var nextRight = `
        <li onclick="nextPage()" class="page-item onclick=searchFilter()">
            <a class="page-link" href="#"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
        </li>
    `;
    var li_item = "";
    var result = numPage - offset * limit;
    var expand = `<li class="page-item">...</li>`;
    if (result == limit) {
        li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${
            offset * limit + 1
        }</a></li>`;
        for (var i = offset * limit + 2; i <= offset * limit + limit; i++) {
            li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
        }
        if (offset == 0) {
            li_item = li_item;
        } else {
            li_item = expand + li_item;
        }
    } else if (result > limit) {
        li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${
            offset * limit + 1
        }</a></li>`;
        for (var i = offset * limit + 2; i <= offset * limit + limit; i++) {
            li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
        }
        // =====================================
        if (offset == 0) {
            li_item += expand;
        } else if (offset == maxOffset) {
            li_item = expand + li_item;
        } else {
            li_item = expand + li_item + expand;
        }
    } else if (result < limit) {
        if (offset == 0) {
            if (result == 1) {
                li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">1</a></li>`;
            } else {
                li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">1</a></li>`;
                for (var i = 2; i <= result; i++) {
                    li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
                }
            }
        } else {
            if (result == 1) {
                li_item += expand;
                li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${
                    offset * limit + 1
                }</a></li>`;
                // ======================================
            } else {
                li_item += expand;
                li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${
                    offset * limit + 1
                }</a></li>`;
                for (
                    var i = offset * limit + 2;
                    i <= offset * limit + result;
                    i++
                ) {
                    li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
                }
            }
        }
    }

    var pagination_id = document.getElementById("pagination_id");

    pagination_id.innerHTML = nextLeft + li_item + nextRight;
}

async function searchFilterCheckbox() {
    var elementsLoaiSanPham = document.getElementsByClassName(
        "categories__nav__item__level2_loaiSanPham"
    );
    var elementsMonTheThao = document.getElementsByClassName(
        "categories__nav__item__level2_monTheThao"
    );
    var elementsNhanHieu = document.getElementsByClassName(
        "categories__nav__item__level2_nhanHieu"
    );

    var listLoaiSanPham = [];
    for (var i = 0; i < elementsLoaiSanPham.length; i++) {
        if (elementsLoaiSanPham[i].querySelector("input:checked")) {
            listLoaiSanPham.push(
                elementsLoaiSanPham[i].querySelector("label").innerText
            );
        }
    }

    var listMonTheThao = [];
    for (var i = 0; i < elementsMonTheThao.length; i++) {
        if (elementsMonTheThao[i].querySelector("input:checked")) {
            listMonTheThao.push(
                elementsMonTheThao[i].querySelector("label").innerText
            );
        }
    }

    var listNhanHieu = [];
    for (var i = 0; i < elementsNhanHieu.length; i++) {
        if (elementsNhanHieu[i].querySelector("input:checked")) {
            listNhanHieu.push(
                elementsNhanHieu[i].querySelector("label").innerText
            );
        }
    }

    maxPrice = parseInt(
        (
            await Promise.all([
                getMaxPrice(listLoaiSanPham, listMonTheThao, listNhanHieu),
            ])
        )[0]
    );
    initPriceSlider();
    var priceRange = $("#amount").val();
    if (priceRange != "") {
        console.log("vao");
        var price_from = parseFloat(priceRange.split("-")[0].replace("$", ""));
        var price_to = parseFloat(priceRange.split("-")[1].replace("$", ""));
    } else {
        var price_from = 0;
        var price_to = maxPrice;
    }

    var pageIndex;
    try {
        pageIndex = document
            .querySelector(".active")
            .getElementsByClassName("page-link")[0].innerText;
    } catch (error) {
        pageIndex = 1;
    }

    console.log("searchFilter-------------" + pageIndex);
    var limit = document.querySelector("select").value;
    console.log("limit---------" + limit);

    searchFilter(
        listLoaiSanPham,
        listMonTheThao,
        listNhanHieu,
        pageIndex,
        price_to,
        price_from,
        limit
    );
    var numPage = await getNumpage(
        listLoaiSanPham,
        listMonTheThao,
        listNhanHieu,
        price_from,
        price_to,
        limit
    );

    console.log(numPage);
    offsetSub = 0;
    renderPagination(numPage, offsetSub, limitSub);

    // ============================================================sua========================================
    numPageSub = numPage;
    // ============================================================
}

async function searchbyPriceFilter() {
    var priceRange = $("#amount").val();
    if (priceRange != "") {
        console.log("vao by filter");
        var price_from = parseFloat(priceRange.split("-")[0].replace("$", ""));
        var price_to = parseFloat(priceRange.split("-")[1].replace("$", ""));
    } else {
        var price_from = 0;
        var price_to = maxPrice;
    }

    var elementsLoaiSanPham = document.getElementsByClassName(
        "categories__nav__item__level2_loaiSanPham"
    );
    var elementsMonTheThao = document.getElementsByClassName(
        "categories__nav__item__level2_monTheThao"
    );
    var elementsNhanHieu = document.getElementsByClassName(
        "categories__nav__item__level2_nhanHieu"
    );

    var listLoaiSanPham = [];
    for (var i = 0; i < elementsLoaiSanPham.length; i++) {
        if (elementsLoaiSanPham[i].querySelector("input:checked")) {
            listLoaiSanPham.push(
                elementsLoaiSanPham[i].querySelector("label").innerText
            );
        }
    }

    var listMonTheThao = [];
    for (var i = 0; i < elementsMonTheThao.length; i++) {
        if (elementsMonTheThao[i].querySelector("input:checked")) {
            listMonTheThao.push(
                elementsMonTheThao[i].querySelector("label").innerText
            );
        }
    }

    var listNhanHieu = [];
    for (var i = 0; i < elementsNhanHieu.length; i++) {
        if (elementsNhanHieu[i].querySelector("input:checked")) {
            listNhanHieu.push(
                elementsNhanHieu[i].querySelector("label").innerText
            );
        }
    }
    var pageIndex;
    try {
        pageIndex = document
            .querySelector(".active")
            .getElementsByClassName("page-link")[0].innerText;
    } catch (error) {
        pageIndex = 1;
    }

    console.log("searchFilter-------------" + pageIndex);
    var limit = document.querySelector("select").value;
    console.log("limit---------" + limit);

    searchFilter(
        listLoaiSanPham,
        listMonTheThao,
        listNhanHieu,
        pageIndex,
        price_to,
        price_from,
        limit
    );
    var numPage = await getNumpage(
        listLoaiSanPham,
        listMonTheThao,
        listNhanHieu,
        price_from,
        price_to,
        limit
    );

    console.log(numPage);
    offsetSub = 0;
    renderPagination(numPage, offsetSub, limitSub);
    maxPrice = parseInt(
        (
            await Promise.all([
                getMaxPrice(listLoaiSanPham, listMonTheThao, listNhanHieu),
            ])
        )[0]
    );
    // ============================================================sua========================================
    numPageSub = numPage;
    // ============================================================
}

async function getMaxPrice(listLoaiSanPham, listMonTheThao, listNhanHieu) {
    var a = await fetch(
        contextPath +
            `/cua-hang/max-price?` +
            new URLSearchParams({
                listLoaiSanPham: listLoaiSanPham,
                listMonTheThao: listMonTheThao,
                listNhanHieu: listNhanHieu,
            })
    );
    var result = await a.json();
    return result.maxPrice;
}

// Function search fiter
async function searchFilter(
    listLoaiSanPham,
    listMonTheThao,
    listNhanHieu,
    pageIndex,
    price_to,
    price_from,
    limit
) {
    // -------------------------------------------------------------------------------------------

    var data = {
        listLoaiSanPham: listLoaiSanPham,
        listMonTheThao: listMonTheThao,
        listNhanHieu: listNhanHieu,
        pageIndex: pageIndex,
        price_to: price_to,
        price_from: price_from,
        limit: limit,
    };
    var a = await fetch(
        contextPath + `/cua-hang/loc?` + new URLSearchParams(data)
    );
    var result = await a.json();

    // --------------------------------------------------------------------------------------------

    // console.log(pageIndex);
    // console.log(limit);

    var container_item_product = document.getElementById(
        "container_item_product"
    );
    container_item_product.innerHTML = result
        .map((e) => {
            return `
        <div class="col-sm-6 col-lg-3 product-item men item"
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
                        <div class="price"> ${formatCurrency(
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
}
