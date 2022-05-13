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

		success: function(data) {
			console.log("Them Thanh Cong");
		},
		error: function(e) {
			if (tenMonTheThao == "") {
				alert("Tên môn thể thao không được rỗng và không được trùng");
			} else {
				document.getElementById("cbTenMonTheThao").innerHTML +=
					"\n\t\t\t\t\t\t\t\t\t<option>" +
					tenMonTheThao +
					"</option>\n\t\t\t\t\t\t\t\t";
				$("#Closemodal4").click();
				alert("Thêm thành công");
				
				loadLaiMaMonTheThao();
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

		success: function(data) {
			console.log("Them Thanh Cong");
		},
		error: function(e) {
			if (tenNhanHieu == "") {
				alert("Tên nhãn hiệu không được rỗng và không được trùng");
			} else {
				document.getElementById("cbNhanHieu").innerHTML +=
					"\n\t\t\t\t\t\t\t\t\t<option>" +
					tenNhanHieu +
					"</option>\n\t\t\t\t\t\t\t\t";
				$("#Closemodal3").click();
				alert("Thêm thành công");
				loadLaiMaNhanHieu();
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

		success: function(data) {
			console.log("Them Thanh Cong");
		},
		error: function(e) {
			if (tenLoaiSanPham == "") {
				alert("Tên loại sản phẩm không được rỗng và không được trùng");
			} else {
				document.getElementById("cbLoaiSanPham").innerHTML +=
					"\n\t\t\t\t\t\t\t\t\t<option>" +
					tenLoaiSanPham +
					"</option>\n\t\t\t\t\t\t\t\t";
				$("#Closemodal2").click();
				alert("Thêm thành công");
				loadLaiMaLoaiSP();
			}
			console.log(e);
		},
	});
}
function notifySuccess(mesage){
	Swal.fire({
			title: mesage,
			text: "Cảm ơn bạn",
			icon: "success",
			confirmButtonText: "Đồng ý",
		});
}

async function addSanPham() {
	var maSanPham = document.getElementById("maSanPham").value;
	var tenMaSanPham = document.getElementById("tenSanPham").value;
	if (tenMaSanPham == '') {
		alert("Tên sản phẩm không được rỗng");
		return;
	}
	var monTheThao = document.getElementById("cbTenMonTheThao").value;
	var loaiSanPham = document.getElementById("cbLoaiSanPham").value;
	var nhanHieu = document.getElementById("cbNhanHieu").value;
	var giaTien = document.getElementById("giaTien").value.replaceAll(",", "");
	if(giaTien == ''){
		alert("Vui lòng nhập giá tiền");
		return;
	}
	var chietKhau = document.getElementById("chietKhau").value;
	
	var images = document.querySelectorAll(".kv-file-content img");
	var imagesArray = [];
	let e = document.getElementById("ChiTietSanPham").getElementsByTagName("tr");
	if(e.length == 0){
		alert("Vui lòng chọn ít nhất một kích thước và số lượng");
		return;
	}
	var elements = Array.from(e);
	var a = [];
	elements.forEach(e => {
		a.push(JSON.stringify({
			[e.querySelector('.kichThuoc').innerText]
				: e.querySelector('.soLuong').innerText
		}))
	})
	// var img = document.getElementById("uploadfile").value;
	for (let index = 0; index < images.length; index += 2) {
		imagesArray.push(images[index].src);
	}
	console.log(imagesArray);
	var mota = document.getElementById("mota").value;
	const formData = new FormData();
	formData.append("maSanPham", maSanPham);
	formData.append("tenMaSanPham", tenMaSanPham);
	formData.append("monTheThao", monTheThao);
	formData.append("loaiSanPham", loaiSanPham);
	formData.append("nhanHieu", nhanHieu);
	formData.append("giaTien", giaTien);
	formData.append("chietKhau", chietKhau);
	formData.append("mota", mota);
	formData.append("danhSachHinhAnh", imagesArray);
	formData.append("danhSachChiTietSanPham", a);
	if (imagesArray.length == 0) {
		alert("Chọn ít nhất một image để minh họa sản phẩm !");
		return;
	}
	

	const options = {
		method: "POST",
		body: formData,
	};
	
	const response = await fetch(
		`${contextPath}/quan-ly/them-san-pham-moi`,
		options
	);
	
	alert("Thêm thành công")
	location.reload();
}




function addDSChiTietSP() {
	var kichThuoc = document.getElementById("cbKichThuoc").value;
	var soLuong = document.getElementById("soLuong").value;
	var table = document.getElementById("ChiTietSanPham");
	var soLuongitem = parseInt(document.getElementById("soLuong").value);
	if (soLuongitem > 100000) {
		alert("Số lượng phải nhỏ hơn 100000");
		return;
	}
	table.innerHTML += "</th>\n\t\t\t\t\t\t\t\t\t\t\t<th style='text-align: center;' class = 'kichThuoc'>" + kichThuoc + "</th>\n\t\t\t\t\t\t\t\t\t\t\t<th style='text-align: center;' class = 'soLuong'>" + soLuong + "</th>\n\t\t\t\t\t\t\t\t\t\t\t<th style='text-align: center;'><a href='#' onclick='XoaItem(this)'>Xóa</a></th>\n\t\t\t\t\t\t\t\t\t\t\t</tr>";
	$("#Closemodal1").click();
	document.getElementById("cbKichThuoc").selectedIndex = 0;
	document.getElementById("soLuong").value = 1

}
/*Upload image*/

$(document).ready(function() {
	$("#input-44").fileinput({
		uploadUrl: "#",
		maxFilePreviewSize: 10240,
		maxFilesNum: 10,
		fileActionSettings: {
			showUpload: false,
		},
	});
});

function XoaItem(row) {
	var i = row.parentNode.parentNode.rowIndex;
	document.getElementById('ChiTietSanPham').deleteRow(i - 1);
}

async function loadKichThuoc() {
	var tenloaiKichThuoc = document.getElementById("cbLoaiKichThuoc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/kich-thuoc-load`,
		dataType: "json",
		data: {
			tenloaiKichThuoc
		},
		timeout: 100000,

		success: function(data) {
			var id = document.getElementById("cbKichThuoc");
			id.innerHTML = data.map((e) => {
				return `<option>${e}</option>`
			});
		},
		error: function(e) {


		},
	});
}

async function loadLaiMaLoaiSP() {
	 var a = await fetch(
        contextPath +
            `/quan-ly/load-lai-ma-loai-san-pham`
    );
    var result = await a.json();
	document.getElementById("maLoaiSanPham").value = result.maLoaiSP
	document.getElementById("tenLoaiSanPham").value = '';
}

async function loadLaiMaNhanHieu() {
	 var a = await fetch(
        contextPath +
            `/quan-ly/load-lai-ma-nhan-hieu`
    );
    var result = await a.json();
	document.getElementById("maNhanHieu").value = result.maNhanHieu
	document.getElementById("tenNhanHieu").value = '';
}

async function loadLaiMaMonTheThao() {
	 var a = await fetch(
        contextPath +
            `/quan-ly/load-lai-ma-mon-the-thao`
    );
    var result = await a.json();
	document.getElementById("maMonTheThao").value = result.maMTT
	document.getElementById("tenMonTheThao").value = '';
}
