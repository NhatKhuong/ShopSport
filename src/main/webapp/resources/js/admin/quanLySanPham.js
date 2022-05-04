loadLoaiSanPham();

var trangThaiTrang = 2;

function loadLoaiSanPham() {
	jQuery.ajax({
		type: "GET",
		contentType: 'application/json',
		url: contextPath + `/quan-ly/quan-ly-san-pham-load-lsp`,
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
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
	tenSanPham += document.getElementById('locTenSanPham').value;
	giaTien = document.getElementById('giaTien').value;
	trangThai = document.getElementById("mySelect").value;
	loaiSanPham = document.getElementById("selectLoaiSanPham").value;
	trangThaiTrang = trangThai;
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
		contentType: 'application/json',
		url: contextPath + `/quan-ly/quan-ly-san-pham-load-so-luong`,
		data: {
			maSanPham,
		},
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
			return data;
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}

function getDanhSachSanPhamTheoTen(tenSanPham, trangThai, giaTien, loaiSanPham) {
	jQuery.ajax({
		type: "GET",
		contentType: 'application/json',
		url: contextPath + `/quan-ly/quan-ly-san-pham-loc`,
		data: {
			tenSanPham,
			trangThai,
			giaTien,
			loaiSanPham,
		},
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
			let perPage = 10;
			let currentPage = 1;
			let start = 0;
			let end = perPage;
			const totalPage = Math.ceil(data.length / perPage);
			const btnNext = document.querySelector('.btn-next');
			const btnPrev = document.querySelector('.btn-prev');

			function getCurretPage(currentPage) {
				start = (currentPage - 1) * perPage;
				end = currentPage * perPage;
			}

			async function pageSanPham() {
				let temp = "aaaaa";
				const content = data.map(async (v, index) => {
					var trangThai = v.trangThai == "Đang kinh doanh" ? "<td><span class='badge bg-success'>" + v.trangThai + "</span></td>" : "<td><span class='badge bg-warning'>" + v.trangThai + "</span></td>";
					if (index >= start && index < end) {
						var sl = 0;
						//sl =  loadTongSoLuong(v.maSanPham);
						var sl = await loadSoLuong(v.maSanPham);

						return "<tr> <td width='10'><input type='checkbox' name='check1' value='1'></td>" +
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
					jQuery('.btn-prev').addClass('btn-active');
					jQuery('.btn-next').addClass('btn-active');
				}
			};

			function clickButtomListener() {
				let currentPage1 = document.querySelectorAll('.number-page li');
				currentPage1.forEach((item, index) => {
					currentPage1[index].addEventListener('click', () => {
						let value = index + 1;
						currentPage = value;
						jQuery('.number-page li').removeClass('active');
						currentPage1[index].classList.add('active');
						if (currentPage > 1 && currentPage < totalPage) {
							jQuery('.btn-next').removeClass('btn-active');
							jQuery('.btn-prev').removeClass('btn-active');
						}
						if (currentPage === 1) {
							jQuery('.btn-prev').addClass('btn-active');
							jQuery('.btn-next').removeClass('btn-active');
						}
						if (currentPage === totalPage) {
							jQuery('.btn-prev').removeClass('btn-active');
							jQuery('.btn-next').addClass('btn-active');
						}
						getCurretPage(currentPage);
						pageSanPham(data, start, end);
					});
				});
			}
			clickButtomListener();


			btnNext.addEventListener('click', () => {
				currentPage++;

				if (currentPage > totalPage) {
					currentPage = totalPage;
				}
				if (currentPage == totalPage) {
					jQuery('.btn-next').addClass('btn-active');
				}
				jQuery('.btn-prev').removeClass('btn-active');
				jQuery('.number-page li').removeClass('active');
				jQuery(`.number-page li:eq(${currentPage - 1})`).addClass('active');
				getCurretPage(currentPage);
				pageSanPham(data, start, end);
			})
			btnPrev.addEventListener('click', () => {
				currentPage--;

				if (currentPage <= 1) {
					currentPage = 1;
				}
				if (currentPage == 1) {
					jQuery('.btn-prev').addClass('btn-active');
				}
				jQuery('.btn-next').removeClass('btn-active');
				jQuery('.number-page li').removeClass('active');
				jQuery(`.number-page li:eq(${currentPage - 1})`).addClass('active');
				getCurretPage(currentPage);
				pageSanPham(data, start, end);
			})
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});


};
/*async function pageSanPham(data, start, end) {
	
	let temp = "aaaaa";
	const content = data.map(async (v, index) => {
		var trangThai = v.trangThai == "Đang kinh doanh" ? "<td><span class='badge bg-success'>" + v.trangThai + "</span></td>" : "<td><span class='badge bg-warning'>" + v.trangThai + "</span></td>";
		if (index >= start && index < end) {
			var sl = 0;
			//sl =  loadTongSoLuong(v.maSanPham);
			var sl = await loadSoLuong(v.maSanPham);

			return "<tr> <td width='10'><input type='checkbox' name='check1' value='1'></td>" +
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
		contentType: 'application/json',
		url: contextPath + `/quan-ly/quan-ly-san-pham-doi-trang-thai`,
		data: {
			maSanPham,
		},
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
			console.log("SUCCESS: ", data);
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}
function deleteRow(r) {
	var i = r.parentNode.parentNode.rowIndex;
	deleteSanPham(document.getElementById("tableListSanPham").rows[i].cells[1].innerHTML);
	document.getElementById("tableListSanPham").deleteRow(i);
}

function deleteSanPhamListener() {
	jQuery(function() {
		jQuery(".trash").click(function() {
			swal({
				title: "Cảnh báo",
				text: "Bạn có chắc chắn là muốn thay đổi trạng thái của sản phẩm này?",
				buttons: ["Hủy bỏ", "Đồng ý"],
			})
				.then((willDelete) => {
					if (willDelete) {
						if (trangThaiTrang != 2)
							deleteRow(this);
						else {
							console.log(trangThaiTrang);
							var i = this.parentNode.parentNode.rowIndex;
							var temp = document.getElementById("tableListSanPham").rows[i].cells[6].innerText;
							document.getElementById("tableListSanPham").rows[i].cells[6].innerHTML = temp == "Ngừng kinh doanh" ? "<td><span class='badge bg-success'>" + "Đang kinh doanh" + "</span></td>" : "<td><span class='badge bg-warning'>" + "Ngừng kinh doanh" + "</span></td>";
						}
						swal("Đã thay đổi thành công.!", {
						});
					}
				});
		});
	});
}

var rowIndex;
function loadModal(r) {
	var i = r.parentNode.parentNode.rowIndex;
	rowIndex = i;
	var maSanPham = document.getElementById("tableListSanPham").rows[i].cells[1].innerHTML;
	var tenSanPham = document.getElementById("tableListSanPham").rows[i].cells[2].innerHTML;
	var tinhTrangSanPham = document.getElementById("tableListSanPham").rows[i].cells[6].innerText;
	var giaSanPham = document.getElementById("tableListSanPham").rows[i].cells[4].innerHTML;
	jQuery('#modalMaSP').val(maSanPham);
	jQuery('#modalTenSP').val(tenSanPham);
	jQuery('#modalTrangThaiSP').val(tinhTrangSanPham == "Đang kinh doanh" ? 1 : 0);
	jQuery('#modalGiaSP').val(giaSanPham);
}

function updateRow(i) {
	document.getElementById("tableListSanPham").rows[i].cells[1].innerHTML = jQuery('#modalMaSP').val();
	document.getElementById("tableListSanPham").rows[i].cells[2].innerHTML = jQuery('#modalTenSP').val();
	document.getElementById("tableListSanPham").rows[i].cells[6].innerHTML = jQuery('#modalTrangThaiSP').val() == 1 ? "<td><span class='badge bg-success'>" + "Đang kinh doanh" + "</span></td>" : "<td><span class='badge bg-warning'>" + "Ngừng kinh doanh" + "</span></td>";
	document.getElementById("tableListSanPham").rows[i].cells[4].innerHTML = jQuery('#modalGiaSP').val();
}


function updateSanPhamListener() {
	jQuery(function() {
		jQuery(".edit").click(function() {
			loadModal(this);
		});
	})
};
function capNhatSanPhamListener() {
	jQuery(function() {
		jQuery("#btnLuu").click(function() {
			capNhatSanPham(jQuery('#modalMaSP').val(), jQuery('#modalTenSP').val(), jQuery('#modalTrangThaiSP').val(), jQuery('#modalGiaSP').val());
			updateRow(rowIndex);
			jQuery('#ModalUP').modal('hide');
		});
	})
};

function capNhatSanPham(maSanPham, tenSanPham, trangThai, giaTien) {
	jQuery.ajax({
		type: "GET",
		contentType: 'application/json',
		url: contextPath + `/quan-ly/quan-ly-san-pham-cap-nhat`,
		data: {
			maSanPham,
			tenSanPham,
			trangThai,
			giaTien,
		},
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
			console.log(data)
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
};




