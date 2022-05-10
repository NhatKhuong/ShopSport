const formHiddenTenKichThuoc = document.getElementById("hidden-tenKichThuoc");
const formHiddenSoLuong = document.getElementById("hidden-soLuong");
const soLuongMua = document.getElementById("quantity");
const submitFormBuy = document.getElementById("submit-buy-now");
const maSanPham = new URL(window.location.href).searchParams.get("maSanPham");
var totalReview = 0,
    totalPage,
    limit = 5,
    pageNow = 1;
// Vote rating
// $("#myModal").modal();
// $("#myModalDialogSuccess").modal();

// vote rating

var btn_kichThuoc = document.getElementsByClassName("btn_kichThuoc");
btn_kichThuoc[0].classList.add("active");
if (btn_kichThuoc[0].innerText === "Khac") {
    btn_kichThuoc[0].style.display = "none";
    getQuantityProductBySizeName("Khac");
} else {
    getQuantityProductBySizeName(btn_kichThuoc[0].innerText);
}

(function activeImage() {
    var imageSub = document.querySelectorAll(".img-sub");
    var imageMain = document.querySelector(".img-main img");
    var eOld;
    imageSub.forEach((el) =>
        el.addEventListener("click", (event) => {
            if (!event.target.src) {
                return;
            }
            imageMain.src = event.target.src;
            if (eOld) eOld.classList.remove("active");
            event.target.parentElement.classList.add("active");
            eOld = event.target.parentElement;
        })
    );
})();

(function activeSize() {
    var sizes = document.querySelectorAll(".size");
    var eOld;
    console.log(sizes);
    sizes.forEach((el) =>
        el.addEventListener("click", (event) => {
            if (eOld) eOld.classList.remove("active");
            event.target.classList.add("active");
            eOld = event.target;
        })
    );
})();

// owl-carousel // slider
$(document).ready(function () {
    $(".imgs-sub.owl-carousel").owlCarousel({
        items: 5,
        animateOut: "fadeOut",
        nav: true,
        responsiveClass: true,
        responsive: {
            300: {
                items: 3,
                nav: false,
            },

            600: {
                items: 5,
                nav: true,
                loop: false,
            },
        },
    });
});

// slider
$(document).ready(function () {
    $(".items-product-suggest.owl-carousel").owlCarousel({
        items: 5,
        animateOut: "fadeOut",
        nav: true,
        responsiveClass: true,
        loop: true,
        margin: 10,
        autoplay: true,
        autoplayTimeout: 3000,
        autoplayHoverPause: true,
        responsive: {
            300: {
                items: 3,
                nav: false,
            },

            600: {
                items: 4,
                nav: true,
            },
        },
    });
});

function showDialogSuccessStatus() {
    $("#myModalDialogSuccess").addClass("show");
    setTimeout(function () {
        $("#myModalDialogSuccess").removeClass("show");
    }, 1000);
}

function addToCard() {
    if (!authenticated) {
        if (
            confirm("Bạn chưa đăng nhập ! Bạn có muốn đăng nhập không ?") ==
            true
        ) {
            window.location.href = `${contextPath}/dang-nhap`;
        }
        return;
    }

    var url = new URL(window.location.href);
    var productId = url.searchParams.get("maSanPham");
    var tenKichThuoc = document.querySelector(".sizes .active").innerText;
    var soLuong = document.getElementById("quantity").innerText;
    // $("#myModalDialogSuccess").modal();

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: `${contextPath}/gio-hang/them`,
        dataType: "json",
        data: {
            productId,
            tenKichThuoc,
            soLuong,
        },
        timeout: 100000,

        success: function (data) {
            console.log("sucess" + data);
        },
        error: function (e) {
            console.log("----------" + 1);
            showDialogSuccessStatus();
            // $("#myModalDialogSuccess").addClass("show");
            // alert("ssss");
            console.log("--------" + 2);
        },
    });
}

(() => {})();

function getQuantityProductBySizeName(tenKichThuoc) {
    var url = new URL(window.location.href);
    var maSanPham = url.searchParams.get("maSanPham");

    $.ajax({
        type: "GET",
        contentType: "application/json",
        // contextPath declared in header
        url: contextPath + `/san-pham/so-luong-ton`,
        data: {
            maSanPham,
            tenKichThuoc,
        },
        dataType: "json",
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);

            document.getElementById("soLuongTon").innerText = data;
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
    });
}

//  buy now
submitFormBuy.addEventListener("submit", (e) => {
    const tenKichThuoc = document.querySelector(".sizes .size.active");
    if (!tenKichThuoc) {
        alert("Vui lòng chọn kích thước");
        e.preventDefault();
    }

    formHiddenSoLuong.value = +soLuongMua.innerText;
    formHiddenTenKichThuoc.value = tenKichThuoc.innerText;
});
/* input */

// comment
(async () => {
    // on click submit comment
    document
        .getElementById("submit-comment")
        .addEventListener("click", async (e) => {
            // productId = delace on top productdetail
            const formData = new FormData();
            var rating = document.querySelector(
                'input[name="rating-input"]:checked'
            );
            var review = document.getElementById("review");
            const fileInput = document.querySelector("#avatar-1");
            if (!review) {
                alert("Bạn chưa viết đánh giá");
            }

            if (fileInput.files.length != 0) {
                formData.append("file", fileInput.files[0]);
            } else {
                formData.append("file", new File([""], "")); // it not save
            }
            formData.append("rating", rating.value);
            formData.append("review", review.value);
            formData.append("productId", maSanPham);
            const options = {
                method: "POST",
                body: formData,
            };
            const response = await fetch(
                contextPath + "/danh-gia/them-danh-gia",
                options
            );
            var status = await response.json();
            console.log(status.status);
            if (status.status != "false") {
                Swal.fire({
                    title: "Đánh giá thành công!",
                    text: "Cảm ơn bạn",
                    icon: "success",
                    confirmButtonText: "Đồng ý",
                });
            } else {
                Swal.fire({
                    title: "Không thành công!",
                    text: "Bạn đã đánh giá rồi",
                    icon: "error",
                    confirmButtonText: "Đồng ý",
                });
            }
            review.value = "";
            fileInput.files[0] = undefined;
        });
})();

async function loadQuantityTotalComment() {
    var params = new URLSearchParams({ maSanPham });
    var response = await fetch(
        `${contextPath}/danh-gia/tong-so-danh-gia?${params}`
    );
    var totalReview = await response.json();
    totalReview = totalReview;
    totalPage =
        totalReview % limit == 0
            ? totalReview / limit
            : totalReview / limit + 1;
}
loadQuantityTotalComment();
// load list comment
async function loadComment(page, limit) {
    if (!limit) limit = 1;

    var params = new URLSearchParams({ page, limit, maSanPham });
    axios({
        method: "get",
        url: `${contextPath}/danh-gia/danh-sach-danh-gia?${params}`,
    }).then(function (response) {
        var danhSachDanhGia = response.data.danhSachDanhGia;
        document.getElementById("comments").innerHTML = danhSachDanhGia
            .map((e) => {
                return `
        <div class="comment">
        <div class="avatar">
          <img src="https://secure.gravatar.com/avatar/bb90dcb0ceabfc8bf10c550f1ee95ee7?s=60&d=mm&r=g"
            alt="">
        </div>
        <div class="info-comment">
        <div class="name  pb-1">${e.nguoiDung.hoTen} </div>
          <div class="d-flex align-items-center">
     
            <div class="ratings pb-1">
            <i class="fa fa-star" aria-hidden="true"></i> <i
              class="fa fa-star${
                  e.xepHang < 2 ? "-o" : ""
              } " aria-hidden="true"></i> <i
              class="fa fa-star${
                  e.xepHang < 3 ? "-o" : ""
              } " aria-hidden="true"></i> <i
              class="fa fa-star${
                  e.xepHang < 4 ? "-o" : ""
              } " aria-hidden="true"></i> <i
              class="fa fa-star${
                  e.xepHang < 5 ? "-o" : ""
              } " aria-hidden="true"></i>
          </div>
             
          <div class="date ml-2">
          <small> ${new Date(e.thoiGian).toLocaleString()}</small>
        </div>
          </div>
       
          <div class="content">${e.noiDung}</div>
          <div class="image pt-2 ${e.hinhAnh ? "" : "d-none"}">
            <img height="60"
              src="${contextPath}/resources/images/reviews/${e.hinhAnh}"
              class="rounded float-left">
          </div>
        </div>
      </div>
        `;
            })
            .join(" ");
    });

    if (totalPage == undefined) {
        await loadQuantityTotalComment();
    }
    loadPagination(totalPage, page);
}
function loadPagination(pageTotal, pageNow) {
    console.log({ pageTotal, pageNow });
    var pagination = document.getElementById("pagination-comment");
    var left = `
  	<li class="page-item ${pageNow == 1 ? "disabled" : ""}">
      <i class="page-link" aria-label="Previous" onclick='loadComment(${
          pageNow - 1
      })'>
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </i>
    </li>`;
    var right = `
    <li class="page-item ${pageNow == pageTotal ? "disabled" : ""}">
      <i class="page-link" aria-label="Next" onclick='loadComment(${
          pageNow + 1
      })'> 
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </i>
    </li>
  `;
    var item = "";
    for (var i = 0; i < pageTotal; i++) {
        item += `<li class="page-item ${
            i + 1 == pageNow ? "active" : ""
        }"><i class="page-link " onclick='loadComment(${i + 1})'>${
            i + 1
        }</i></li>`;
    }
    pagination.innerHTML = left + item + right;
}
loadComment(1, limit);
