(() => {
	var checkAll = document.getElementById("all");

	var listInputCheck = document.getElementsByClassName("checkInput");
	checkAll.addEventListener("change", (e) => {
		if (checkAll.checked) {
			for (var item of listInputCheck) {
				item.checked = true;
			}
		} else {
			for (var item of listInputCheck) {
				item.checked = false;
			}
		}
	});
})();
var trangThaiTrang = 2;
chuyenTrangThaiNhieu();
async function chuyenTrangThaiNhieu() {
	var listInputCheck = document.getElementsByClassName("checkInput");
	jQuery("#chuyenTrangThaiNhieu").click(function() {
		swal({
			title: "Cảnh báo",
			text: "Bạn có chắc chắn là muốn thay đổi trạng thái của tất cả sản phẩm được chọn?",
			buttons: ["Hủy bỏ", "Đồng ý"],
		}).then((willDelete) => {
			if (willDelete) {
				if (trangThaiTrang != 2) {
					for (var item of listInputCheck) {
						if (item.checked) {
							var i = item.parentNode.parentNode.rowIndex;
							deleteSanPhamDBIndex(i);
						}
					}
					for (var item of listInputCheck) {
						if (item.checked) {
							var i = item.parentNode.parentNode.rowIndex;
							deleteRowIndex(i);
						}
					}
				} else {
					for (var item of listInputCheck) {
						if (item.checked) {
							var i = item.parentNode.parentNode.rowIndex;
							var temp =
								document.getElementById("tableListSanPham").rows[i].cells[6]
									.innerText;
							document.getElementById("tableListSanPham").rows[
								i
							].cells[6].innerHTML =
								temp == "Ngừng kinh doanh"
									? "<td><span>" +
									"Đang kinh doanh" +
									"</span></td>"
									: "<td><span>" +
									"Ngừng kinh doanh" +
									"</span></td>";
							deleteSanPhamDBIndex(i);
						}
					}
				}
			}
		});
	});
}
var maSanPhamClickInEdit;
loadLoaiSanPham();

function loadLoaiSanPham() {
	jQuery.ajax({
		type: "GET",
		contentType: "application/json",
		url: contextPath + `/quan-ly/quan-ly-san-pham-load-lsp`,
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			//   console.log(data);
			let temp = "<option value='Tất cả'>--Tất cả--</option>";
			data.forEach((v) => {
				temp += `<option value='${v.tenLoaiSanPham}'>${v.tenLoaiSanPham}</option>`;
			});
			document.getElementById("selectLoaiSanPham").innerHTML = temp;
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}
getDanhSachSanPham();

function getDanhSachSanPham() {
	var tenSanPham = "";
	var trangThai = "0";
	var giaTien = "0";
	tenSanPham += document.getElementById("locTenSanPham").value;
	giaTien = document.getElementById("giaTien").value;
	trangThai = document.getElementById("mySelect").value;
	loaiSanPham = document.getElementById("selectLoaiSanPham").value;
	trangThaiTrang = document.getElementById("mySelect").value;
	getDanhSachSanPhamTheoTen(tenSanPham, trangThai, giaTien, loaiSanPham);
}

async function loadSoLuong(maSanPham) {
	var a = await fetch(
		contextPath +
		`/quan-ly/quan-ly-san-pham-load-so-luong?` +
		new URLSearchParams({
			maSanPham: maSanPham,
		})
	);
	return await a.json();
}

/*loadSoLuong("SPAA00001").then(data => {
	console.log(data);
});*/

function loadTongSoLuong(maSanPham) {
	jQuery.ajax({
		type: "GET",
		contentType: "application/json",
		url: contextPath + `/quan-ly/quan-ly-san-pham-load-so-luong`,
		data: {
			maSanPham,
		},
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			return data;
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}

function getDanhSachSanPhamTheoTen(
	tenSanPham,
	trangThai,
	giaTien,
	loaiSanPham
) {
	jQuery.ajax({
		type: "GET",
		contentType: "application/json",
		url: contextPath + `/quan-ly/quan-ly-san-pham-loc`,
		data: {
			tenSanPham,
			trangThai,
			giaTien,
			loaiSanPham,
		},
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			console.log(data);
			let perPage = 7;
			let currentPage = 1;
			let start = 0;
			let end = perPage;
			const totalPage = Math.ceil(data.length / perPage);
			const btnNext = document.querySelector(".btn-next");
			const btnPrev = document.querySelector(".btn-prev");

			function getCurretPage(currentPage) {
				start = (currentPage - 1) * perPage;
				end = currentPage * perPage;
			}

			async function pageSanPham() {
				let temp = "aaaaa";
				const content = data.map(async (v, index) => {
					var trangThai =
						v.trangThai == "Đang kinh doanh"
							? "<td><span >" +
							v.trangThai +
							"</span></td>"
							: "<td><span>" +
							v.trangThai +
							"</span></td>";
					if (index >= start && index < end) {
						var sl = 0;
						//sl =  loadTongSoLuong(v.maSanPham);
						var sl = await loadSoLuong(v.maSanPham);

						return (
							"<tr> <td width='10'><input class='checkInput' type='checkbox' name='check1' value='1'></td>" +
							"  <td>" +
							v.maSanPham +
							"</td>" +
							"  <td>" +
							v.tenSanPham +
							"</td>" +
							"  <td>" +
							sl +
							"</td>" +
							"<td>" +
							v.giaTien +
							"đ</td>" +
							"<td>" +
							v.loaiSanPham.tenLoaiSanPham +
							"</td>" +
							trangThai +
							"<td><button class='btn btn-primary btn-sm trash' type='button' title='Xóa'><i class='fa fa-refresh' aria-hidden='true'></i></button>" +
							"<button class='btn btn-primary btn-sm edit' type='button'" +
							"title='Sửa' id='show-emp' data-toggle='modal' data-target='#ModalUP'>" +
							"<i class='fas fa-edit'></i> </button></td></tr>"
						);
					}
				});
				temp = await Promise.all(content);
				document.getElementById("danhSachSanPham").innerHTML = temp.join(" ");
				deleteSanPhamListener();
				updateSanPhamListener();
			}
			pageSanPham();
			//pageSanPham(data, start, end);
			renderListPage();

			function renderListPage() {
				let html = "";
				html += `<li class="active"><a>${1}</a></li>`;
				for (let i = 2; i <= totalPage; i++) {
					html += `<li><a>${i}</a></li>`;
				}
				document.getElementById("number-page").innerHTML = html;
				if (totalPage == 1) {
					jQuery(".btn-prev").addClass("btn-active");
					jQuery(".btn-next").addClass("btn-active");
				}
			}

			function clickButtomListener() {
				let currentPage1 = document.querySelectorAll(".number-page li");
				currentPage1.forEach((item, index) => {
					currentPage1[index].addEventListener("click", () => {
						let value = index + 1;
						currentPage = value;
						jQuery(".number-page li").removeClass("active");
						currentPage1[index].classList.add("active");
						if (currentPage > 1 && currentPage < totalPage) {
							jQuery(".btn-next").removeClass("btn-active");
							jQuery(".btn-prev").removeClass("btn-active");
						}
						if (currentPage === 1) {
							jQuery(".btn-prev").addClass("btn-active");
							jQuery(".btn-next").removeClass("btn-active");
						}
						if (currentPage === totalPage) {
							jQuery(".btn-prev").removeClass("btn-active");
							jQuery(".btn-next").addClass("btn-active");
						}
						getCurretPage(currentPage);
						pageSanPham(data, start, end);
					});
				});
			}
			clickButtomListener();

			btnNext.addEventListener("click", () => {
				currentPage++;

				if (currentPage > totalPage) {
					currentPage = totalPage;
				}
				if (currentPage == totalPage) {
					jQuery(".btn-next").addClass("btn-active");
				}
				jQuery(".btn-prev").removeClass("btn-active");
				jQuery(".number-page li").removeClass("active");
				jQuery(`.number-page li:eq(${currentPage - 1})`).addClass("active");
				getCurretPage(currentPage);
				pageSanPham(data, start, end);
			});
			btnPrev.addEventListener("click", () => {
				currentPage--;

				if (currentPage <= 1) {
					currentPage = 1;
				}
				if (currentPage == 1) {
					jQuery(".btn-prev").addClass("btn-active");
				}
				jQuery(".btn-next").removeClass("btn-active");
				jQuery(".number-page li").removeClass("active");
				jQuery(`.number-page li:eq(${currentPage - 1})`).addClass("active");
				getCurretPage(currentPage);
				pageSanPham(data, start, end);
			});
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}
/*async function pageSanPham(data, start, end) {
	
	let temp = "aaaaa";
	const content = data.map(async (v, index) => {
		var trangThai = v.trangThai == "Đang kinh doanh" ? "<td><span class='badge bg-success'>" + v.trangThai + "</span></td>" : "<td><span class='badge bg-warning'>" + v.trangThai + "</span></td>";
		if (index >= start && index < end) {
			var sl = 0;
			//sl =  loadTongSoLuong(v.maSanPham);
			var sl = await loadSoLuong(v.maSanPham);

			return "<tr> <td width='10'><input class='checkInput' type='checkbox' name='check1' value='1'></td>" +
				"  <td>" + v.maSanPham + "</td>" +
				"  <td>" + v.tenSanPham + "</td>"
				+ "  <td>" + sl + "</td>" +
				"<td>" + v.giaTien + "đ</td>" +
				"<td>" + v.loaiSanPham.tenLoaiSanPham + "</td>" + trangThai +
				"<td><button class='btn btn-primary btn-sm trash' type='button' title='Xóa'><i class='fa fa-refresh' aria-hidden='true'></i></button>" +
				"<button class='btn btn-primary btn-sm edit' type='button'" +
				"title='Sửa' id='show-emp' data-toggle='modal' data-target='#ModalUP'>" +
				"<i class='fas fa-edit'></i> </button></td></tr>"
				;
		}
	});
	temp = await Promise.all(content);
	document.getElementById("danhSachSanPham").innerHTML = temp.join(" ");
	deleteSanPhamListener();
	updateSanPhamListener();
	capNhatSanPhamListener()
};*/

function deleteSanPham(maSanPham) {
	jQuery.ajax({
		type: "GET",
		contentType: "application/json",
		url: contextPath + `/quan-ly/quan-ly-san-pham-doi-trang-thai`,
		data: {
			maSanPham,
		},
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			console.log("SUCCESS: ", data);
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}
function deleteRowI(r) {
	var i = r.parentNode.parentNode.rowIndex;
	document.getElementById("tableListSanPham").deleteRow(i);
}

function deleteRowIndex(i) {
	document.getElementById("tableListSanPham").deleteRow(i);
}

function deleteSanPhamDB(r) {
	var i = r.parentNode.parentNode.rowIndex;
	deleteSanPham(
		document.getElementById("tableListSanPham").rows[i].cells[1].innerHTML
	);
}

function deleteSanPhamDBIndex(i) {
	deleteSanPham(
		document.getElementById("tableListSanPham").rows[i].cells[1].innerHTML
	);
}


function deleteSanPhamListener() {
	jQuery(function() {
		jQuery(".trash").click(function() {
			swal({
				title: "Cảnh báo",
				text: "Bạn có chắc chắn là muốn thay đổi trạng thái của sản phẩm này?",
				buttons: ["Hủy bỏ", "Đồng ý"],
			}).then((willDelete) => {
				if (willDelete) {
					if (trangThaiTrang != 2) {
						deleteRowI(this);
						deleteSanPhamDB(this);
					} else {
						var i = this.parentNode.parentNode.rowIndex;
						var temp =
							document.getElementById("tableListSanPham").rows[i].cells[6]
								.innerText;
						document.getElementById("tableListSanPham").rows[
							i
						].cells[6].innerHTML =
							temp == "Ngừng kinh doanh"
								? "<td><span>" +
								"Đang kinh doanh" +
								"</span></td>"
								: "<td><span>" +
								"Ngừng kinh doanh" +
								"</span></td>";
						deleteSanPhamDB(this);
					}
					swal("Đã thay đổi thành công.!", {});
				}
			});
		});
	});
}

var rowIndex;
function loadModal(r) {
	var i = r.parentNode.parentNode.rowIndex;
	rowIndex = i;
	var maSanPham =
		document.getElementById("tableListSanPham").rows[i].cells[1].innerHTML;
	var tenSanPham =
		document.getElementById("tableListSanPham").rows[i].cells[2].innerHTML;
	var tinhTrangSanPham =
		document.getElementById("tableListSanPham").rows[i].cells[6].innerText;
	var giaSanPham =
		document.getElementById("tableListSanPham").rows[i].cells[4].innerHTML;
	jQuery("#modalMaSP").val(maSanPham);
	jQuery("#modalTenSP").val(tenSanPham);
	jQuery("#modalTrangThaiSP").val(
		tinhTrangSanPham == "Đang kinh doanh" ? 1 : 0
	);
	jQuery("#modalGiaSP").val(giaSanPham);
	showEditSanPham(maSanPham);
	maSanPhamClickInEdit = maSanPham;
}

function updateRow(i) {
	if (trangThaiTrang != 2) {
		if (trangThaiTrang == jQuery("#modalTrangThaiSP").val()) {
			document.getElementById("tableListSanPham").rows[i].cells[1].innerHTML =
				jQuery("#modalMaSP").val();
			document.getElementById("tableListSanPham").rows[i].cells[2].innerHTML =
				jQuery("#modalTenSP").val();
			document.getElementById("tableListSanPham").rows[i].cells[4].innerHTML =
				jQuery("#modalGiaSP").val();
		} else {
			deleteRowIndex(i);
			console.log(i);
		}
	} else {
		document.getElementById("tableListSanPham").rows[i].cells[1].innerHTML =
			jQuery("#modalMaSP").val();
		document.getElementById("tableListSanPham").rows[i].cells[2].innerHTML =
			jQuery("#modalTenSP").val();
		document.getElementById("tableListSanPham").rows[i].cells[6].innerHTML =
			jQuery("#modalTrangThaiSP").val() == 1
				//       ? "<td><span class='badge bg-success'>" +
				? "<td><span>" +
				"Đang kinh doanh" +
				"</span></td>"
				//        : "<td><span class='badge bg-warning'>" +
				: "<td><span>" +
				"Ngừng kinh doanh" +
				"</span></td>";
		document.getElementById("tableListSanPham").rows[i].cells[4].innerHTML =
			jQuery("#modalGiaSP").val();
	}
}

function updateSanPhamListener() {
	jQuery(function() {
		jQuery(".edit").click(function() {
			loadModal(this);
			loadChiTietSanPhamModal(document.getElementById("tableListSanPham").rows[rowIndex].cells[1].innerHTML);
			loadKichThuocSanPham2(document.getElementById("tableListSanPham").rows[rowIndex].cells[1].innerHTML);
		});
	});
}
capNhatSanPhamListener();
function capNhatSanPhamListener() {
	jQuery("#btnLuu").click(function() {
		var listSoLuong = document.getElementsByClassName("soLuong");
		var listKichThuoc = document.getElementsByClassName("selectKichThuoc");
		var soLuong = [];
		var tenKichThuoc = [];
		for (var i = 0; i < listSoLuong.length; i++) {
			soLuong.push(listSoLuong[i].value);
		};

		for (var i = 0; i < listKichThuoc.length; i++) {
			tenKichThuoc.push(listKichThuoc[i].value);
		};

		capNhatSanPham(
			jQuery("#modalMaSP").val(),
			jQuery("#modalTenSP").val(),
			
			jQuery("#modalTrangThaiSP").val(),
			jQuery("#modalGiaSP").val(),
			soLuong,
			tenKichThuoc,
		);
		updateRow(rowIndex);
		Swal.fire({
			title: "Cập nhật thành công!",
			text: "Cảm ơn bạn",
			icon: "success",
			confirmButtonText: "Đồng ý",
		});
		jQuery("#hideModal").click();
		soLuongKichThuoc = 1;
	});
}

var soLanThemCT = 0;
var soLuongKichThuoc = 1;
jQuery("#themChiTietSanPham").click(function() {
	soLanThemCT = soLanThemCT + 1;
	if (soLanThemCT <= soLuongKichThuoc) {
		var temp = "<tr style='border: 0px solid black;'>" +
			"	<td style='border: 0px solid black;'><div class='form-group col-12'>" +
			"<label class='control-label '>Kích thước:</label> <select class='dashboard-filter form-control selectKichThuoc' id='selectKichThuoc'></select></div></td>" +
			"	<td style='border: 0px solid black;'><div class='form-group col-12'>" +
			"<label class='control-label '>Số lượng:</label> <input class='form-control soLuong' id='' type='text' required></div></td> " +
			"<td style='border: 0px solid black;'><button type='button' class='close deleteRowCT' onclick='onClickDeleteRowCT(this);'><h2 aria-hidden='true' class='text-danger'>&times;</h2></button></td></tr >";
		jQuery("#chiTietSanPham").append(temp);
		loadKichThuocSanPham(document.getElementById("tableListSanPham").rows[rowIndex].cells[1].innerHTML);
	}
});
function loadKichThuocSanPham2(maSanPham) {
	jQuery.ajax({
		type: "GET",
		contentType: "application/json",
		url: contextPath + `/quan-ly/quan-ly-san-pham-load-kich-thuoc-modal`,
		data: {
			maSanPham,
		},
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			soLuongKichThuoc = data.length;
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}


function loadKichThuocSanPham(maSanPham) {
	jQuery.ajax({
		type: "GET",
		contentType: "application/json",
		url: contextPath + `/quan-ly/quan-ly-san-pham-load-kich-thuoc-modal`,
		data: {
			maSanPham,
		},
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			let temp = "<option value='Chọn size'>-- Chọn kích thước --</option>";
			data.forEach((v) => {
				temp += `<option value='${v.tenKichThuoc}'>${v.tenKichThuoc}</option>`;
			});
			//	document.getElementById("selectKichThuoc").innerHTML = temp;
			document.getElementsByClassName("selectKichThuoc")[soLanThemCT -  1].innerHTML = temp;
	},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}


function onClickDeleteRowCT(r) {
	var i = r.parentNode.parentNode.rowIndex;
	document.getElementById("chiTietSanPham").deleteRow(i);
	soLanThemCT = soLanThemCT - 1;
	//updateSoLuongChiTietSanPham(i,jQuery("#modalMaSP").val());
};
function updateSoLuongChiTietSanPham(rowIn, maSanPham) {
	jQuery.ajax({
		type: "GET",
		contentType: "application/json",
		url: contextPath + `/quan-ly/quan-ly-san-pham-update-so-luong-chi-tiet-san-pham`,
		data: {
			rowIn,
			maSanPham,
		},
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			console.log(data);

		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}


function loadChiTietSanPhamModal(maSanPham) {
	jQuery.ajax({
		type: "GET",
		contentType: "application/json",
		url: contextPath + `/quan-ly/quan-ly-san-pham-load-chi-tiet-san-pham-modal`,
		data: {
			maSanPham,
		},
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			var loadRowCT = "";
			data.forEach((v) => {
				loadRowCT += "<tr style='border: 0px solid black;'>" +
					"	<td style='border: 0px solid black;'><div class='form-group col-12'>" +
					"<label class='control-label '>Kích thước:</label> <input class='form-control ' disabled id='' type='text' required value='" + v.kichThuoc.tenKichThuoc + "' ></div></td>" +
					"	<td style='border: 0px solid black;'><div class='form-group col-12'>" +
					"<label class='control-label '>Số lượng:</label> <input class='form-control soLuong'  type='text' required value='" + v.soLuongTon + "'></div></td> </tr >";
				//+"<td style='border: 0px solid black;'><button type='button' class='close deleteRowCT' onclick='onClickDeleteRowCT(this);'><h2 aria-hidden='true' class='text-danger'>&times;</h2></button></td></tr >";

			});
			document.getElementById("chiTietSanPham").innerHTML = loadRowCT;
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}


async function capNhatSanPham(maSanPham, tenSanPham, trangThai, giaTien, soLuong, tenKichThuoc) {
	var a = await fetch(
		contextPath +
		`/quan-ly/quan-ly-san-pham-cap-nhat?` +
		new URLSearchParams({
			maSanPham: maSanPham,
			tenSanPham: tenSanPham,
			trangThai: trangThai,
			giaTien: giaTien,
			soLuong: soLuong,
			tenKichThuoc: tenKichThuoc,
		})
	);
	/*jQuery.ajax({
		type: "GET",
		contentType: "application/json",
		url: contextPath + `/quan-ly/quan-ly-san-pham-cap-nhat`,
		data: {
			maSanPham,
			tenSanPham,
			trangThai,
			giaTien,
			soLuong,
		},
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			console.log(data);
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});*/
}

// (() => {
//   /* upload file image*/
//   $(document).ready(function () {
//     $("#input-44").fileinput({
//       initialPreview: [
//         "https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg",
//         "https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg",
//       ],
//       maxFilePreviewSize: 10240,
//       initialPreviewAsData: true,
//       overwriteInitial: false,
//       uploadUrl: "#",
//       maxFilesNum: 10,
//       fileActionSettings: {
//         showUpload: false,
//       },
//     });
//   });
// })();

async function showEditSanPham(maSanPham) {
	var result = await (
		await fetch(
			`${contextPath}/quan-ly/lay-pham-theo-ma?maSanPham=${maSanPham}`
		)
	).json();
	loadInputUpload(result.danhSachHinhAnhSanPham);
}
function loadInputUpload(imageOldUrl) {
	var imagesOld = imageOldUrl.reduce(
		(old, current) => {
			// old.initialPreview.push(
			//   `${contextPath}/resources/images/${current.hinhAnh}`
			// );
			// old.deleteUrl.push(`#`);
			old.initialPreview.push(
				`${contextPath}/resources/images/${current.hinhAnh}`
			);
			old.deleteUrl.push("");
			return old;
		},
		{ initialPreview: [], deleteUrl: [] }
	);
	//  reset default
	document.getElementById("myfileupload").innerHTML = `
                 <div id="upload-image">
									<label for="input-24">Planets and Satellites</label>
									<div class="file-loading">
										<input id="input-44" name="input44[]" type="file" multiple>
									</div>
								</div>
  `;
	jQuery("#input-44").fileinput({
		initialPreview: imagesOld.initialPreview,
		initialPreviewAsData: true,
		overwriteInitial: false,
		uploadUrl: "#",
		// deleteUrl: imagesOld.deleteUrl,
		maxFilePreviewSize: 10240,
		maxFileSize: 10 * 1024 * 1024,
		maxFilesNum: 10,
		fileActionSettings: {
			showUpload: false,
		},
	});
	// delete resert default
	document.querySelector(".fileinput-remove").remove();
	addEventOnAddImage();
	addEventDeleteImage();
}
// add listener event on add file in input
function addEventOnAddImage() {
	var input = document.getElementById("input-44");
	input.addEventListener("change", async () => {
		await fetchThemHinhAnh(input.files);
		removeEventDeleteImage();
		addEventDeleteImage();
	});
}

async function fetchThemHinhAnh(files) {
	console.log(maSanPhamClickInEdit);
	for (let i = 0; i < files.length; i++) {
		let file = files.item(i);
		var base64Image = await toBase64(file);
		const formData = new FormData();
		formData.append("image", base64Image);
		const options = {
			method: "POST",
			body: formData,
		};
		const response = await fetch(
			`${contextPath}/quan-ly/hinh-anh/them-hinh-anh?maSanPham=${maSanPhamClickInEdit}`,
			options
		);
		console.log(await response.json());
	}
}
const toBase64 = (file) =>
	new Promise((resolve, reject) => {
		const reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload = () => resolve(reader.result);
		reader.onerror = (error) => reject(error);
	});

function addEventDeleteImage() {
	var btnDelete = document.querySelectorAll(".kv-file-remove");
	btnDelete.forEach((btn) => {
		btn.addEventListener("click", eventDeleteImage);
	});
}
function removeEventDeleteImage() {
	var btnDelete = document.querySelectorAll(".kv-file-remove");
	btnDelete.forEach((btn) => {
		btn.removeEventListener("click", eventDeleteImage);
	});
}
async function eventDeleteImage(e) {
	var element = e.target.parentNode.parentNode.parentNode.parentNode;
	// i don't know why element it not same
	if (!element.classList.contains("kv-preview-thumb")) {
		element = element.parentNode;
	}
	element.remove();
	const formData = new FormData();
	// formData.append("image", base64Image);
	const options = {
		method: "DELETE",
		body: formData,
	};
	var urlImage = element.querySelector("img").src.split("/");
	var name = urlImage[urlImage.length - 1];
	console.log(name);
	const response = await fetch(
		`${contextPath}/quan-ly/hinh-anh/xoa-hinh-anh?tenHinhAnh=${name}`,
		options
	);
	console.log(await response.json());
}
