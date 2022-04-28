const formHiddenTenKichThuoc = document.getElementById("hidden-tenKichThuoc");
const formHiddenSoLuong = document.getElementById("hidden-soLuong");
const soLuongMua = document.getElementById("quantity");
const submitFormBuy = document.getElementById("submit-buy-now");
const maSanPham = new URL(window.location.href).searchParams.get("maSanPham");
// Vote rating
(function voteRating() {
  var ratings = document.querySelectorAll(".rating-start");
  var ratingsInput = document.querySelectorAll(".rating-start");
  var indexRatingInput = document.querySelector(
    'input[name="rating-input"]:checked'
  ).value;
  var ratingsInput = document.querySelectorAll(".rating-input");
  //   set rating default
  vote(indexRatingInput);

  ratings.forEach((el) =>
    el.addEventListener("click", (event) => {
      var index = event.target.id[7];
      vote(index);
    })
  );
  function vote(index) {
    ratingsInput[index - 1].checked = true;
    for (let i = 0; i < index; i++) {
      ratings[i].className = "fa fa-star rating-start";
    }
    for (let i = index; i < 5; i++) {
      ratings[i].className = "fa fa-star-o rating-start";
    }
  }
})();
// vote rating

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

function addToCard() {
  var tenKichThuoc = document.querySelector(".sizes .active").innerText;
  var soLuong = document.getElementById("quantity").innerText;
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
      // $(function () {
      $("#myModal").on("show.bs.modal", function () {
        var myModal = $(this);
        clearTimeout(myModal.data("hideInterval"));
        myModal.data(
          "hideInterval",
          setTimeout(function () {
            myModal.modal("hide");
          }, 3000)
        );
      });
      // });
    },
    error: function (e) {
      // $("#myModal").on("show.bs.modal", function () {
      //     var myModal = $(this);
      //     clearTimeout(myModal.data("hideInterval"));
      //     myModal.data(
      //         "hideInterval",
      //         setTimeout(function () {
      //             myModal.modal("hide");
      //         }, 3000)
      //     );
      // });

      $("#myModal").modal();
      // setTimeout(function () {
      //     $("#myModal").modal("hide");
      // }, 1000);
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
      var rating = document.querySelector('input[name="rating-input"]:checked');
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
      console.log(await response.json());
    });
})();
