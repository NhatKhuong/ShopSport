function addTaoMonTheThao() {
  var maMonTheThao = document.getElementById("maMonTheThao").value;
  var tenMonTheThao = document.getElementById("tenMonTheThao").value;
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: `${contextPath}/quan-ly/them-mon-the-thao`,
    dataType: "json",
    data: {
      maMonTheThao,
      tenMonTheThao,
    },
    timeout: 100000,

    success: function (data) {
      console.log("Them Thanh Cong");
    },
    error: function (e) {
      if (tenMonTheThao == "") {
        alert("Tên môn thể thao không được rỗng và không được trùng");
      } else {
        document.getElementById("cbTenMonTheThao").innerHTML +=
          "\n\t\t\t\t\t\t\t\t\t<option>" +
          tenMonTheThao +
          "</option>\n\t\t\t\t\t\t\t\t";
        $("#addMonTheThao").modal("hide");
        alert("Thêm thành công");
      }

      console.log(e);
    },
  });
}

function addNhanHieu() {
  var maNhanHieu = document.getElementById("maNhanHieu").value;
  var tenNhanHieu = document.getElementById("tenNhanHieu").value;

  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: `${contextPath}/quan-ly/them-nhan-hieu`,
    dataType: "json",
    data: {
      maNhanHieu,
      tenNhanHieu,
    },
    timeout: 100000,

    success: function (data) {
      console.log("Them Thanh Cong");
    },
    error: function (e) {
      if (tenNhanHieu == "") {
        alert("Tên nhãn hiệu không được rỗng và không được trùng");
      } else {
        document.getElementById("cbNhanHieu").innerHTML +=
          "\n\t\t\t\t\t\t\t\t\t<option>" +
          tenNhanHieu +
          "</option>\n\t\t\t\t\t\t\t\t";
        $("#addNhanHieu").modal("hide");
        alert("Thêm thành công");
      }
      console.log(e);
    },
  });
}

function addLoaiSanPham() {
  var maLoaiSanPham = document.getElementById("maLoaiSanPham").value;
  var tenLoaiSanPham = document.getElementById("tenLoaiSanPham").value;

  $.ajax({
    type: "GET",
    contentType: "ap`plication/json",
    url: `${contextPath}/quan-ly/them-loai-san-pham`,
    dataType: "json",
    data: {
      maLoaiSanPham,
      tenLoaiSanPham,
    },
    timeout: 100000,

    success: function (data) {
      console.log("Them Thanh Cong");
    },
    error: function (e) {
      if (tenLoaiSanPham == "") {
        alert("Tên loại sản phẩm không được rỗng và không được trùng");
      } else {
        document.getElementById("cbLoaiSanPham").innerHTML +=
          "\n\t\t\t\t\t\t\t\t\t<option>" +
          tenLoaiSanPham +
          "</option>\n\t\t\t\t\t\t\t\t";
        $("#addLoaiSanPham").modal("hide");
        alert("Thêm thành công");
      }
      console.log(e);
    },
  });
}
async function addSanPham() {
  var maSanPham = document.getElementById("maSanPham").value;
  var tenMaSanPham = document.getElementById("tenSanPham").value;
  var soLuong = document.getElementById("soLuong").value;
  var monTheThao = document.getElementById("cbTenMonTheThao").value;
  var loaiSanPham = document.getElementById("cbLoaiSanPham").value;
  var nhanHieu = document.getElementById("cbNhanHieu").value;
  var giaTien = document.getElementById("giaTien").value.replaceAll(",", "");
  var chietKhau = document.getElementById("chietKhau").value;
  var images = document.querySelectorAll(".kv-file-content img");
  var imagesArray = [];
  // var img = document.getElementById("uploadfile").value;
  for (let index = 0; index < images.length; index += 2) {
    imagesArray.push(images[index].src);
  }
  console.log(imagesArray);
  var mota = document.getElementById("mota").value;
  const formData = new FormData();
  formData.append("maSanPham", maSanPham);
  formData.append("tenMaSanPham", tenMaSanPham);
  formData.append("soLuong", soLuong);
  formData.append("monTheThao", monTheThao);
  formData.append("loaiSanPham", loaiSanPham);
  formData.append("nhanHieu", nhanHieu);
  formData.append("giaTien", giaTien);
  formData.append("chietKhau", chietKhau);
  formData.append("mota", mota);
  formData.append("danhSachHinhAnh", imagesArray);
  const options = {
    method: "POST",
    body: formData,
  };
  const response = await fetch(
    `${contextPath}/quan-ly/them-san-pham-moi`,
    options
  );
  console.log(await response.json());
}

/*Upload image*/
$(document).ready(function () {
  $("#input-44").fileinput({
    uploadUrl: "#",
    maxFilePreviewSize: 10240,
    maxFilesNum: 10,
    fileActionSettings: {
      showUpload: false,
    },
  });
});
