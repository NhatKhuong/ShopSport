function LocForm() {
	XuLiTrenGiaoDien();
	sanPhamBanChayTable();
	tongDonHangTable();
	
}

function XuLiTrenGiaoDien() {
	var ngayBatDau = document.getElementById("ngayBatDau").value;
	var ngayKetThuc = document.getElementById("ngayKetThuc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/bao-cao-doanh-thu-load`,
		dataType: "json",
		data: {
			ngayBatDau,
			ngayKetThuc,
		},
		timeout: 100000,

		success: function(data) {

			document.getElementById("soDonHang").innerHTML = '\n\t\t\t\t\t\t\t\t<b>' + data[0] + ' đơn hàng</b>\n\t\t\t\t\t\t\t';
			document.getElementById("soDonHangThanhCong").innerHTML = '\n\t\t\t\t\t\t\t\t<b>' + data[1] + ' đơn hàng</b>\n\t\t\t\t\t\t\t';
			document.getElementById("tongTienThuNhap").innerHTML = '\n\t\t\t\t\t\t\t\t<b>' + data[2] + ' đ</b>\n\t\t\t\t\t\t\t';
			document.getElementById("soDonHangChoXacNhan").innerHTML = '\n\t\t\t\t\t\t\t\t<b>' + data[3] + ' đơn hàng</b>\n\t\t\t\t\t\t\t';
			document.getElementById("soDonHangHuy").innerHTML = '\n\t\t\t\t\t\t\t\t<b>' + data[4] + ' đơn hàng</b>\n\t\t\t\t\t\t\t';
		},
		error: function(e) {
			console.log(e);
		},
	});
}

function sanPhamBanChayTable() {
	var ngayBatDau = document.getElementById("ngayBatDau").value;
	var ngayKetThuc = document.getElementById("ngayKetThuc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/bao-cao-doanh-thu-san-pham-ban-chay-load`,
		dataType: "json",
		data: {
			ngayBatDau,
			ngayKetThuc,
		},
		timeout: 100000,

		success: function(data) {
			var table = document.getElementById("sanPhamBanChaytable")
			var items = data.map((e) => {
				return `
					<tr>
										<td>${e.maSanPham}</td>
										<td>${e.tenSanPham}</td>
										<td>${formatCurrency(e.giaTien)}</td>
										<td>${e.loaiSanPham.tenLoaiSanPham}</td>
									</tr>
					`
			})
			table.innerHTML = items.join("");

		},
		error: function(e) {
			console.log(e);
		},
	});
}
function tongDonHangTable() {
	var ngayBatDau = document.getElementById("ngayBatDau").value;
	var ngayKetThuc = document.getElementById("ngayKetThuc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/bao-cao-doanh-thu-tong-don-hang-load`,
		dataType: "json",
		data: {
			ngayBatDau,
			ngayKetThuc,
		},
		timeout: 100000,

		success: function(data) {
			var table = document.getElementById("donHangBanTable")
			var items = data.map((e) => {
				return `
					<tr>
										<td>${e[0]}</td>
										<td>${e[1]}</td>
										<td>${new Date(e[2]).toLocaleDateString()}</td> 
										<td>${e[3]}</td>
										<td>${formatCurrency(e[4])}</td>
									</tr>
					`
			})
			table.innerHTML = items.join("");
		},
		error: function(e) {
			console.log(e);
		},
	});
}
function formatCurrency(number) {
    // if (isNaN(number)) return number;
    return new Intl.NumberFormat("vi-VN", {
        style: "currency",
        currency: "VND",
    }).format(number);
}