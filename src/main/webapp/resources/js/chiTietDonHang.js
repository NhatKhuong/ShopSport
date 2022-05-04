const soLuongMua = document.getElementById("quantity");
const submitFormBuy = document.getElementById("submit-buy-now");
var maSanPhamDanhGia;
// Vote rating
// $("#myModal").modal();
// $("#myModalDialogSuccess").modal();
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
      console.log(review.value);
      if (review.value.trim() == "") {
        alert("Bạn chưa viết đánh giá");
        return;
      }
      if (fileInput.files.length != 0) {
        formData.append("file", fileInput.files[0]);
      } else {
        formData.append("file", new File([""], "")); // it not save
      }
      formData.append("rating", rating.value);
      formData.append("review", review.value);
      formData.append("productId", maSanPhamDanhGia);
      const options = {
        method: "POST",
        body: formData,
      };
      const response = await fetch(
        contextPath + "/danh-gia/them-danh-gia",
        options
      );
      var status = await response.json();
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
      fileInput.files[0] = undefined;
      $("#addReivewModal").modal("hide");
    });
})();
//  upload image

// show form add review
var srcImageReview = "";
(() => {
  var noiDungTextarea = document.getElementById("review");
  var noiDungTextarea = document.getElementById("review");
  document.querySelectorAll(".order_status_item_reiview").forEach((e) => {
    e.addEventListener("click", async (e) => {
      var product = e.target.parentElement.parentElement;
      maSanPhamDanhGia = product.querySelector(".productId").innerText;
      var result = undefined;
      try {
        result = await loadReviewbyProductId(maSanPhamDanhGia);
      } catch (error) {}
      $("#addReivewModal").modal("show");
      document.getElementById("box-input-upload-image").innerHTML = `
              <div class="kv-avatar">
											<div class="file-loading">
												<input id="avatar-1" name="file" type="file" required>
											</div>
										</div>
										<div class="kv-avatar-hint">
											<small>Select file < 10 MB </small>
										</div>
    `;
      if (result) {
        console.log("cap nhat");
        console.log({ result });
        document.getElementById(`rating-${result.xepHang}`).click();
        document.getElementById("review").innerText = result.noiDung;
        document.getElementById("submit-comment").innerText = "Cập nhật";
      } else {
        document.getElementById(`rating-5`).click();
        document.getElementById("review").innerText = "";
        document.getElementById("submit-comment").innerText = "Bình luận";
      }
      $("#avatar-1").fileinput({
        initialPreview: result ? result.src : "",
        overwriteInitial: true,
        initialPreviewAsData: true,
        maxFileSize: 1500,
        showClose: false,
        showCaption: false,
        showCaption: false,
        // showPreview: false,
        showRemove: false,
        showUpload: false, // <------ just set this from false to false
        showCancel: false,
        showUploadedThumbs: false,
        // defaultPreviewContent: `<img src='${src}' alt='HÌnh ảnh đánh giá'>`,
      });
    });
  });
})();

// Load review old
async function loadReviewbyProductId(maSanPhamDanhGia) {
  var imageReivew = document.querySelector(".file-default-preview img");
  const response = await fetch(
    `${contextPath}/danh-gia/danh-gia-theo-ma-san-pham?maSanPham=${maSanPhamDanhGia}`
  );
  var result = await response.json();
  console.log(result);
  try {
    document.querySelector(".fileinput-remove-button").click();
  } catch (error) {}
  srcImageReview = `${contextPath}/resources/images/reviews/${result.hinhAnh}`;
  // imageReivew.style.width = "100%";
  // imageReivew.src = srcImageReview;
  console.log(srcImageReview);
  return {
    src: srcImageReview,
    noiDung: result.noiDung,
    xepHang: result.xepHang,
  };
}
