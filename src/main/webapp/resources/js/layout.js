// Change quantity item

function formatCurrency(number) {
    console.log(number);
    // if (isNaN(number)) return number;
    return new Intl.NumberFormat("vi-VN", {
        style: "currency",
        currency: "VND",
    }).format(number);
}

function quantityPluss(e, quantityTotal) {
    var quantityCurrent = e.parentElement.querySelector(".quantity-number");

    if (!quantityTotal) {
        quantityTotal = document.getElementById("soLuongTon").innerText;
    }

    if (+quantityCurrent.innerText < +quantityTotal) {
        quantityCurrent.innerText = +quantityCurrent.innerText + 1;
    }
    updateTotalPrice(e);
    updateTotalPriceWhenChangeQuanityItem();
    updateQutityInDB(quantityCurrent);
}

// upadate total price item when change quantity

function updateTotalPrice(e) {
    var card_item_info = e.parentElement.parentElement;
    var quantitynumber =
        card_item_info.getElementsByClassName("quantity-number")[0];
    var card_item_info_price = card_item_info.getElementsByClassName(
        "card_item_info_price"
    )[0];
    // =========== t sua cho nay ==============p
    if (!card_item_info_price) {
        return;
    }
    // =====================
    var card_item_info_total = card_item_info.getElementsByClassName(
        "card_item_info_total"
    )[0];

    var itemQuatityNum = +quantitynumber.innerText;
    var card_item_info_priceNum = +card_item_info_price.innerText
        .replaceAll(".", "")
        .replace("₫", "");
    card_item_info_total.innerText = formatCurrency(
        itemQuatityNum * card_item_info_priceNum
    );
}

//update quantity when change

function updateQutityInDB(e) {
    var soLuong = e.innerText;
    // console.log(
    //   e.parentElement.parentElement.parentElement.getElementsByClassName(
    //     "maSanPhamTrongGioHang"
    //   )
    // );
    var maSanPham =
        e.parentElement.parentElement.parentElement.getElementsByClassName(
            "maSanPhamTrongGioHang"
        )[0].innerText;
    // console.log(maSanPham);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: `${contextPath}/gio-hang/update_quatity`,
        dataType: "json",
        data: {
            maSanPham,
            soLuong,
        },
        timeout: 100000,

        success: function (data) {
            console.log("thanhcong");
        },
        error: function (e) {},
    });
}

// Change quantity item

function quantityPrivate(e) {
    var quantityCurrent = e.parentElement.querySelector(".quantity-number");

    if (quantityCurrent.innerText > 0) {
        quantityCurrent.innerText = +quantityCurrent.innerText - 1;
    }
    updateTotalPrice(e);
    updateTotalPriceWhenChangeQuanityItem();
    updateQutityInDB(quantityCurrent);
}

// format cast

function formatCurrency(number) {
    // if (isNaN(number)) return number;
    return new Intl.NumberFormat("vi-VN", {
        style: "currency",
        currency: "VND",
    }).format(number);
}

// update subtotal price when change in checkbox

function updateCheckItemPrice(e) {
    var price = e.parentElement.parentElement;

    var card_item_info = price.querySelector(".card_item_info");
    var card_item_info_price_item = card_item_info.querySelector(
        ".card_item_info_price_item"
    );
    var card_item_info_total = card_item_info_price_item.querySelector(
        ".card_item_info_total"
    );

    var subtotal_price = document.getElementsByClassName("Subtotal_price")[0];
    var subtotal_price_num = +subtotal_price.innerText
        .replaceAll(".", "")
        .replace("₫", "");
    var price_item_num = +card_item_info_total.innerText
        .replaceAll(".", "")
        .replace("₫", "");

    if (e.checked) {
        subtotal_price_num = subtotal_price_num + price_item_num;
    } else {
        console.log(subtotal_price_num, price_item_num);
        subtotal_price_num = subtotal_price_num - price_item_num;
    }
    subtotal_price.innerText = formatCurrency(subtotal_price_num);
}

const checkItem = (e) => {
    updateCheckItemPrice(e);
};

const updateTotalPriceWhenChangeQuanityItem = () => {
    var a = document.getElementsByClassName("Subtotal_price")[0];
    a.innerText = 0;
    var listCheckItem = document.getElementsByClassName("check_item_input");
    for (var item of listCheckItem) {
        if (item.checked) {
            updateCheckItemPrice(item);
        }
    }
};

(() => {
    document
        .getElementsByClassName("check_all")[0]
        .addEventListener("change", (e) => {
            var a = document.getElementsByClassName("Subtotal_price")[0];
            a.innerText = 0;
            var listCheckItem =
                document.getElementsByClassName("check_item_input");
            if (e.target.checked) {
                for (var item of listCheckItem) {
                    item.checked = true;
                    updateCheckItemPrice(item);
                }
            } else {
                for (var item of listCheckItem) {
                    item.checked = false;
                    // updateCheckItemPrice(e);
                }
            }
        });
})();

async function loadDuLieuGioHang() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: contextPath + `/gio-hang/san-pham`,

        dataType: "json",
        success: function (data) {
            console.log("SUCCESS: ", data);
            loadDataCard(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
    });
}

// detele card item product

function deleteCardItem(e) {
    var maSanPhamTrongGioHang = e.parentElement.getElementsByClassName(
        "maSanPhamTrongGioHang"
    )[0].innerText;
    console.log(maSanPhamTrongGioHang);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: contextPath + `/gio-hang/delete`,
        dataType: "json",
        data: {
            maSanPhamTrongGioHang,
        },

        timeout: 100000,
        success: function (data) {
            // loadDuLieuGioHang();
        },
        error: function (ex) {
            // console.log("ERROR: ", e);
            // loadDuLieuGioHang();
            var a = e.parentElement
                .getElementsByClassName("maSanPhamTrongGioHang")[0]
                .parentElement.remove();
            updateTotalPriceWhenChangeQuanityItem();
        },
    });
}

// Load data card product form db to card

function loadDataCard(data) {
    document.getElementsByClassName("Subtotal_price price")[0].innerText = 0;
    var id = document.getElementById("cardProducts");
    id.innerHTML = data
        .map((e) => {
            return ` <div class="card_product">
        
            <div class="maSanPham" hidden>${
                e.chiTietSanPham.sanPham.maSanPham
            }</div> 
            <div class="maSanPhamTrongGioHang" hidden>${
                e.maSanPhamTrongGioHang
            }</div>
        <div class="check_item">
            <input type="checkbox" class="check_item_input" onchange="checkItem(this)">
        </div>
        <div class="card_item_img">
            <img
                src='${contextPath}/resources/images/${
                e.chiTietSanPham.sanPham.danhSachHinhAnhSanPham[0].hinhAnh
            }'>
            <small class='sizeTitle'> Size: <small class='tenKichThuoc'>${
                e.chiTietSanPham.kichThuoc.tenKichThuoc
            }</small> </small>
        </div>
        <div class="card_item_info">
            <div class="card_item_info_name break_text">
                ${e.chiTietSanPham.sanPham.tenSanPham}</div>
            
            <!-- <div class="card_item_info_quatity">1</div> -->
            <div class="quantity">

                <button class="btn ml-2 " onclick='quantityPrivate(this)'> <i
                        class="fa fa-minus" aria-hidden="true"></i></button>
                <span class="item_quantity quantity-number">${e.soLuong}</span>
                <button class="btn mr-2 "
                    onclick='quantityPluss(this,${
                        e.chiTietSanPham.soLuongTon
                    })'> <i
                        class="fa fa-plus" aria-hidden="true"></i></button>

            </div>
            <div class="card_item_info_price_item">
                <div class="card_item_info_price price" onchange = "updateTotalPriceWhenChangeQuanityItem()">
                    ${formatCurrency(
                        e.chiTietSanPham.sanPham.giaTien -
                            (e.chiTietSanPham.sanPham.giaTien *
                                e.chiTietSanPham.sanPham.chietKhau) /
                                100
                    )}
                </div>
                <div class="card_item_info_total price">
                    ${formatCurrency(
                        e.soLuong *
                            (e.chiTietSanPham.sanPham.giaTien -
                                (e.chiTietSanPham.sanPham.giaTien *
                                    e.chiTietSanPham.sanPham.chietKhau) /
                                    100)
                    )}</div>
            </div>
        </div>
        <button type="button" class="close delete_item close_model" onclick="deleteCardItem(this)">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
`;
        })
        .join(" ");
}

//  price * quantity when chang quantity
(() => {
    document.querySelectorAll(".quantity button").forEach((e) => {
        e.addEventListener("click", (e) => {
            var info = e.target.parentElement.parentElement.parentElement;
            var price = info.querySelector(".card_item_info_price");
            var total = info.querySelector(".card_item_info_total");
            // =========== t sua cho nay ==============
            if (!total) {
                return;
            }
            var quantity = info.querySelector(".quantity-number");
            total.innerText = formatCurrency(
                price.innerText.replaceAll(".", "").replace("₫", "") *
                    quantity.innerText
            );
        });
    });
})();

(() => {
    var formCard = document.getElementById("form-card");
    var valueForm = document.getElementById("value-form-hidden");
    var parent;

    formCard.addEventListener("submit", (e) => {
        var productsCheck = document.querySelectorAll(
            ".card_product input:checked"
        );
        var soLuong,
            tenKichThuoc,
            maSanPham,
            i = 0;
        if (!productsCheck.length) {
            alert("Bạn chưa chọn sản phẩm");
            e.preventDefault();
        }
        valueForm.innerHTML = Array.from(productsCheck)
            .map((e) => {
                parent = e.parentElement.parentElement;

                soLuong = parent.querySelector(".quantity-number").innerText;
                tenKichThuoc = parent.querySelector(".tenKichThuoc").innerText;
                maSanPham = parent.querySelector(".maSanPham").innerText;
                return `

      <input id="hidden-maSanPham"
      name="danhSachChiTietDonHang[${i}].chiTietSanPham.sanPham.maSanPham"
      value="${maSanPham}" readonly="true" />

      <input id="hidden-tenKichThuoc" 
      name="danhSachChiTietDonHang[${i}].chiTietSanPham.kichThuoc.tenKichThuoc"
      value="${tenKichThuoc}"
      readonly="true" />

     <input id="hidden-soLuong" name="danhSachChiTietDonHang[${i++}].soLuongMua"
     value="${soLuong}"
      readonly="true" />
        `;
            })
            .join(" ");
    });
})();

async function loadModalSearch() {
    var contition = document.getElementById("searchInput").value;
    var a = await fetch(
        contextPath +
            `/header/tim-kiem?` +
            new URLSearchParams({
                contition: contition,
            })
    );

    var result = await a.json();

    var modal_body_search_category_list_container = document.getElementById(
        "modal-body-search_category_list_container"
    );
    modal_body_search_category_list_container.innerHTML = result
        .map((e) => {
            return `
        <div class="card_product" onclick='window.location.href="${contextPath}/san-pham/chi-tiet-san-pham?maSanPham=${
                e.maSanPham
            }"'>
                
        <div class="card_item_img">
            <img
                src='${contextPath}/resources/images/${
                e.danhSachHinhAnhSanPham[0].hinhAnh
            }'>
        </div>
        <div class="card_item_info">
            <div class="card_item_info_name_search break_text">
                ${e.tenSanPham}</div>

            <div class="card_item_info_price_item">
                
                <div class="card_item_info_price price_new">
                    ${formatCurrency(
                        e.giaTien - (e.giaTien * e.chietKhau) / 100
                    )}
                </div>
                <div class="card_item_info_price price_old">
                    ${formatCurrency(e.giaTien)}
                </div>

            </div>
        </div>
    </div>
        `;
        })
        .join(" ");
}

// ==============================================================shop.js=========================

// var offsetSub = 0;
// var numPageSub;
// var limitSub = 5;
// var numButtonOldActice;

// searchFilterCheckbox();

// async function getNumpage(
//     strLoaiSanPham,
//     strMonTheThao,
//     strNhanHieu,
//     priceFrom,
//     priceTo,
//     limit
// ) {
//     var a = await fetch(
//         contextPath +
//             `/cua-hang/soTrang?` +
//             new URLSearchParams({
//                 listLoaiSanPham: strLoaiSanPham,
//                 listMonTheThao: strMonTheThao,
//                 listNhanHieu: strNhanHieu,
//                 price_to: priceTo,
//                 price_from: priceFrom,
//                 limit: limit,
//             })
//     );
//     return await a.json();
// }

// function clearActiveButtonPagination() {
//     var listPage = document.querySelectorAll(".page-item");
//     listPage.forEach((el) => {
//         el.classList.remove("active");
//     });
// }

// function resetActiveButonWhenClickNextPage() {
//     var listPage = document.querySelectorAll(".page-item");
//     console.log("listPage.target:" + listPage);
//     console.log("numButtonReset=======" + numButtonOldActice);
//     listPage.forEach((el) => {
//         console.log(el.target);
//         if (
//             el.getElementsByClassName("page-link")[0].innerText ===
//             numButtonOldActice
//         ) {
//             console.log("el: " + el);
//             el.classList.add("active");
//         }
//     });
// }

// function getPageActiveAndDisableOutButton(e) {
//     console.log("111111111111111111");
//     console.log(e);
//     clearActiveButtonPagination();

//     e.classList.add("active");
//     numButtonOldActice = e.getElementsByClassName("page-link")[0].innerText;
//     console.log("numButtonOldActice: " + numButtonOldActice);

//     var price_to = 100000000;
//     var price_from = 0;

//     var elementsLoaiSanPham = document.getElementsByClassName(
//         "categories__nav__item__level2_loaiSanPham"
//     );
//     var elementsMonTheThao = document.getElementsByClassName(
//         "categories__nav__item__level2_monTheThao"
//     );
//     var elementsNhanHieu = document.getElementsByClassName(
//         "categories__nav__item__level2_nhanHieu"
//     );

//     var listLoaiSanPham = [];
//     for (var i = 0; i < elementsLoaiSanPham.length; i++) {
//         if (elementsLoaiSanPham[i].querySelector("input:checked")) {
//             listLoaiSanPham.push(
//                 elementsLoaiSanPham[i].querySelector("label").innerText
//             );
//         }
//     }

//     var listMonTheThao = [];
//     for (var i = 0; i < elementsMonTheThao.length; i++) {
//         if (elementsMonTheThao[i].querySelector("input:checked")) {
//             listMonTheThao.push(
//                 elementsMonTheThao[i].querySelector("label").innerText
//             );
//         }
//     }

//     var listNhanHieu = [];
//     for (var i = 0; i < elementsNhanHieu.length; i++) {
//         if (elementsNhanHieu[i].querySelector("input:checked")) {
//             listNhanHieu.push(
//                 elementsNhanHieu[i].querySelector("label").innerText
//             );
//         }
//     }
//     var pageIndex;
//     try {
//         pageIndex = document
//             .querySelector(".active")
//             .getElementsByClassName("page-link")[0].innerText;
//     } catch (error) {
//         pageIndex = 1;
//     }

//     console.log("searchFilter-------------" + pageIndex);
//     var limit = document.querySelector("select").value;
//     console.log("limit---------" + limit);
//     searchFilter(
//         listLoaiSanPham,
//         listMonTheThao,
//         listNhanHieu,
//         pageIndex,
//         price_to,
//         price_from,
//         limit
//     );
// }

// // function renderPagination(numPage) {
// //     var nextLeft = `
// //     <li class="page-item disabled">
// //         <a class="page-link" href="#" tabindex="-1"><i class="fa fa-angle-left"
// //         aria-hidden="true"></i></a>
// //     </li>`;
// //     var nextRight = `
// //         <li class="page-item onclick=searchFilter()">
// //             <a class="page-link" href="#"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
// //         </li>
// //     `;

// //     var li_item = "";
// //     if (numPage == 1) {
// //         li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${numPage}</a></li>`;
// //     } else if (numPage > 1) {
// //         li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">1</a></li>`;
// //         for (var i = 2; i <= numPage; i++) {
// //             li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
// //         }
// //     }
// //     var pagination_id = document.getElementById("pagination_id");
// //     pagination_id.innerHTML = nextLeft + li_item + nextRight;
// // }

// function nextPage() {
//     var maxOffset;
//     if (numPageSub < limitSub) {
//         maxOffset = 0;
//     } else {
//         maxOffset =
//             numPageSub % limitSub == 0
//                 ? Math.floor(numPageSub / limitSub) - 1
//                 : Math.floor(numPageSub / limitSub);
//     }

//     if (offsetSub < maxOffset) {
//         offsetSub = offsetSub + 1;
//         renderPagination(numPageSub, offsetSub, limitSub);
//         clearActiveButtonPagination();
//         console.log("next---" + numButtonOldActice);
//         resetActiveButonWhenClickNextPage();
//     }
// }

// function backPage() {
//     if (offsetSub > 0) {
//         offsetSub = offsetSub - 1;
//         renderPagination(numPageSub, offsetSub, limitSub);
//         clearActiveButtonPagination();
//         console.log("back----" + numButtonOldActice);
//         resetActiveButonWhenClickNextPage();
//     }
// }

// function renderPagination(numPage, offset, limit) {
//     console.log("Numpage:===" + numPage);
//     console.log("limit:===" + limit);

//     var maxOffset;
//     if (numPage < limit) {
//         maxOffset = 0;
//     } else {
//         maxOffset =
//             numPage % limit == 0
//                 ? Math.floor(numPage / limit) - 1
//                 : Math.floor(numPage / limit);
//     }

//     console.log("offsetSub====" + offsetSub);
//     console.log("maxOffset=====" + maxOffset);
//     var nextLeft = `
//     <li onclick="backPage()" class="page-item">
//         <a class="page-link" href="#" tabindex="-1"><i class="fa fa-angle-left"
//         aria-hidden="true"></i></a>
//     </li>`;
//     var nextRight = `
//         <li onclick="nextPage()" class="page-item onclick=searchFilter()">
//             <a class="page-link" href="#"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
//         </li>
//     `;
//     var li_item = "";
//     var result = numPage - offset * limit;
//     var expand = `<li class="page-item">...</li>`;
//     if (result == limit) {
//         li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${
//             offset * limit + 1
//         }</a></li>`;
//         for (var i = offset * limit + 2; i <= offset * limit + limit; i++) {
//             li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
//         }
//         if (offset == 0) {
//             li_item = li_item;
//         } else {
//             li_item = expand + li_item;
//         }
//     } else if (result > limit) {
//         li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${
//             offset * limit + 1
//         }</a></li>`;
//         for (var i = offset * limit + 2; i <= offset * limit + limit; i++) {
//             li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
//         }
//         // =====================================
//         if (offset == 0) {
//             li_item += expand;
//         } else if (offset == maxOffset) {
//             li_item = expand + li_item;
//         } else {
//             li_item = expand + li_item + expand;
//         }
//     } else if (result < limit) {
//         if (offset == 0) {
//             if (result == 1) {
//                 li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">1</a></li>`;
//             } else {
//                 li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">1</a></li>`;
//                 for (var i = 2; i <= result; i++) {
//                     li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
//                 }
//             }
//         } else {
//             if (result == 1) {
//                 li_item += expand;
//                 li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${
//                     offset * limit + 1
//                 }</a></li>`;
//                 // ======================================
//             } else {
//                 li_item += expand;
//                 li_item += `<li class="page-item active" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${
//                     offset * limit + 1
//                 }</a></li>`;
//                 for (
//                     var i = offset * limit + 2;
//                     i <= offset * limit + result;
//                     i++
//                 ) {
//                     li_item += `<li class="page-item" onclick="getPageActiveAndDisableOutButton(this)"><a class="page-link" href="#">${i}</a></li>`;
//                 }
//             }
//         }
//     }

//     var pagination_id = document.getElementById("pagination_id");

//     pagination_id.innerHTML = nextLeft + li_item + nextRight;
// }

// async function searchFilterCheckbox() {
//     var price_to = 100000000;
//     var price_from = 0;

//     var elementsLoaiSanPham = document.getElementsByClassName(
//         "categories__nav__item__level2_loaiSanPham"
//     );
//     var elementsMonTheThao = document.getElementsByClassName(
//         "categories__nav__item__level2_monTheThao"
//     );
//     var elementsNhanHieu = document.getElementsByClassName(
//         "categories__nav__item__level2_nhanHieu"
//     );

//     var listLoaiSanPham = [];
//     for (var i = 0; i < elementsLoaiSanPham.length; i++) {
//         if (elementsLoaiSanPham[i].querySelector("input:checked")) {
//             listLoaiSanPham.push(
//                 elementsLoaiSanPham[i].querySelector("label").innerText
//             );
//         }
//     }

//     var listMonTheThao = [];
//     for (var i = 0; i < elementsMonTheThao.length; i++) {
//         if (elementsMonTheThao[i].querySelector("input:checked")) {
//             listMonTheThao.push(
//                 elementsMonTheThao[i].querySelector("label").innerText
//             );
//         }
//     }

//     var listNhanHieu = [];
//     for (var i = 0; i < elementsNhanHieu.length; i++) {
//         if (elementsNhanHieu[i].querySelector("input:checked")) {
//             listNhanHieu.push(
//                 elementsNhanHieu[i].querySelector("label").innerText
//             );
//         }
//     }
//     var pageIndex;
//     try {
//         pageIndex = document
//             .querySelector(".active")
//             .getElementsByClassName("page-link")[0].innerText;
//     } catch (error) {
//         pageIndex = 1;
//     }

//     console.log("searchFilter-------------" + pageIndex);
//     var limit = document.querySelector("select").value;
//     console.log("limit---------" + limit);
//     searchFilter(
//         listLoaiSanPham,
//         listMonTheThao,
//         listNhanHieu,
//         pageIndex,
//         price_to,
//         price_from,
//         limit
//     );
//     var numPage = await getNumpage(
//         listLoaiSanPham,
//         listMonTheThao,
//         listNhanHieu,
//         price_from,
//         price_to,
//         limit
//     );
//     console.log(numPage);
//     offsetSub = 0;
//     renderPagination(numPage, offsetSub, limitSub);

//     // ============================================================sua========================================
//     numPageSub = numPage;
//     // ============================================================
// }

// // Function search fiter
// async function searchFilter(
//     listLoaiSanPham,
//     listMonTheThao,
//     listNhanHieu,
//     pageIndex,
//     price_to,
//     price_from,
//     limit
// ) {
//     // -------------------------------------------------------------------------------------------

//     var a = await fetch(
//         contextPath +
//             `/cua-hang/loc?` +
//             new URLSearchParams({
//                 listLoaiSanPham: listLoaiSanPham,
//                 listMonTheThao: listMonTheThao,
//                 listNhanHieu: listNhanHieu,
//                 pageIndex: pageIndex,
//                 price_to: price_to,
//                 price_from: price_from,
//                 limit: limit,
//             })
//     );
//     var result = await a.json();

//     // --------------------------------------------------------------------------------------------

//     // console.log(pageIndex);
//     // console.log(limit);

//     var container_item_product = document.getElementById(
//         "container_item_product"
//     );
//     container_item_product.innerHTML = result
//         .map((e) => {
//             return `
//         <div class="col-sm-6 col-lg-3 product-item men item"
//         onclick='window.location.href="${contextPath}/san-pham/chi-tiet-san-pham?maSanPham=${
//                 e.maSanPham
//             }"'>

//             <div class="product discount product_filter">

//                 <div class="product_image">
//                     <img
//                         src='${contextPath}/resources/images/${
//                 e.danhSachHinhAnhSanPham[0].hinhAnh
//             }'>
//                 </div>
//                 <div class="favorite favorite_left"></div>
//                 <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center">
//                     <span class='percent'>${e.chietKhau} %</span>
//                 </div>
//                 <div class="product_info">
//                     <h6 class="product_title">
//                         <a>${e.tenSanPham}</a>
//                     </h6>
//                     <div class="product_price">
//                         <div class="price"> ${formatCurrency(
//                             e.giaTien - (e.giaTien * e.chietKhau) / 100
//                         )}</div> <span
//                             class="price">${formatCurrency(e.giaTien)}</span>
//                     </div>
//                 </div>
//             </div>
//             <div class="red_button add_to_cart_button w-100 ">
//                 <a href="#" class='w-100'>Thêm vào giỏ hàng</a>
//             </div>
//     </div>
//         `;
//         })
//         .join(" ");
// }
