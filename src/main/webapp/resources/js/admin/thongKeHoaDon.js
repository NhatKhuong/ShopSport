LocPage(1)
LocPageSP(1)
function LocForm() {
	XuLiTrenGiaoDien();
	sanPhamBanChayTable();
	tongDonHangTable();
	loadButtonTable();
}
function loadButtonTable() {
	var ngayBatDau = document.getElementById("ngayBatDau").value;
	var ngayKetThuc = document.getElementById("ngayKetThuc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/bao-cao-doanh-thu-load_button`,
		dataType: "json",
		data: {
			ngayBatDau,
			ngayKetThuc,
		},
		timeout: 100000,

		success: function(data) {
			var id = document.getElementById("soTrangtable");
			var items = data.map((e) => {
				return `<input type="button" id="btnLocPage" onclick="LocPage(${e})"
											class="btn btn-primary btn-sm" value=${e}>&emsp;`
			})
			id.innerHTML = `<p style="text-align: center;" class = "col-md-12">` + items.join("") + `</p>`;


		},
		error: function(e) {
			console.log(e);
		},
	});
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
//thêm
function ThongKeTheoNam() {
	var namThongKe = document.getElementById("cbNamThongKe").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/thong-ke-theo-nam`,
		dataType: "json",
		data: {
			namThongKe
		},
		timeout: 100000,

		success: function(data) {
			var id = document.getElementById("listDoanhThuThang");

			id.innerHTML = data.map((e) => {
				return `<tr><td>${e[0]}</td>
						<td>${formatCurrency(e[1])}</td></tr>`
			}).join(" ");
			var doanhthuthang1, doanhthuthang2, doanhthuthang3, doanhthuthang4, doanhthuthang5, doanhthuthang6, doanhthuthang7, doanhthuthang8, doanhthuthang9, doanhthuthang10, doanhthuthang11, doanhthuthang12;
			let e = document.getElementById("listDoanhThuThang")
				.getElementsByTagName("tr");
			for (i = 0; i < e.length; i++) {
				var value = e[i].getElementsByTagName("td")[0].innerText
				if (value === '1') {
					doanhthuthang1 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '2') {
					doanhthuthang2 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '3') {
					doanhthuthang3 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '4') {
					doanhthuthang4 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '5') {
					doanhthuthang5 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '6') {
					doanhthuthang6 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '7') {
					doanhthuthang7 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '8') {
					doanhthuthang8 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '9') {
					doanhthuthang9 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '10') {
					doanhthuthang10 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '11') {
					doanhthuthang11 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (value === '12') {
					doanhthuthang12 = e[i].getElementsByTagName("td")[1].innerText
				}
				if (doanhthuthang1 == null) {
					doanhthuthang1 = '0'
				}
				if (doanhthuthang2 == null) {
					doanhthuthang2 = '0'
				}
				if (doanhthuthang3 == null) {
					doanhthuthang3 = '0'
				}
				if (doanhthuthang4 == null) {
					doanhthuthang4 = '0'
				}
				if (doanhthuthang5 == null) {
					doanhthuthang5 = '0'
				}
				if (doanhthuthang6 == null) {
					doanhthuthang6 = '0'
				}
				if (doanhthuthang7 == null) {
					doanhthuthang7 = '0'
				}
				if (doanhthuthang8 == null) {
					doanhthuthang8 = '0'
				}
				if (doanhthuthang9 == null) {
					doanhthuthang9 = '0'
				}
				if (doanhthuthang10 == null) {
					doanhthuthang10 = '0'
				}
				if (doanhthuthang11 == null) {
					doanhthuthang11 = '0'
				}
				if (doanhthuthang12 == null) {
					doanhthuthang12 = '0'
				}
			}
			var data = {
				labels: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5",
					"Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10",
					"Tháng 11", "Tháng 12"],
				datasets: [{
					label: "Dữ liệu đầu tiên",
					fillColor: "rgba(255, 213, 59, 0.767), 212, 59)",
					strokeColor: "rgb(255, 212, 59)",
					pointColor: "rgb(255, 212, 59)",
					pointStrokeColor: "rgb(255, 212, 59)",
					pointHighlightFill: "rgb(255, 212, 59)",
					pointHighlightStroke: "rgb(255, 212, 59)",
					data: [parseInt(doanhthuthang1), parseInt(doanhthuthang2),
					parseInt(doanhthuthang3), parseInt(doanhthuthang4),
					parseInt(doanhthuthang5), parseInt(doanhthuthang6),
					parseInt(doanhthuthang7), parseInt(doanhthuthang8),
					parseInt(doanhthuthang9), parseInt(doanhthuthang10),
					parseInt(doanhthuthang11), parseInt(doanhthuthang12)]
				}]
			};
			var ctxl = $("#lineChartDemo").get(0).getContext("2d");
			var lineChart = new Chart(ctxl).Line(data);

			var ctxb = $("#barChartDemo").get(0).getContext("2d");
			var barChart = new Chart(ctxb).Bar(data);
		},
		error: function(e) {
			console.log(e);
		},
	});
}

function LocPageSP(number) {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/thong-ke-tong-don-hang-load-page-sp`,
		dataType: "json",
		data: {
			number
		},
		timeout: 100000,

		success: function(data) {
			var id = document.getElementById("sanPhamHetHangTable")
			id.innerHTML = data.map((e) => {
				return `
					<tr>
											<td>${e[0]}</td>
											<td>${e[1]}</td>
											<td>${e[2]}</td>
											<td>${e[3]}</td>
											<td><span class="badge bg-danger">Hết hàng</span></td>
											<td>${formatCurrency(e[4])}</td>
											<td>${e[5]}</td>
										</tr>
					`
			}).join(" ");

		},
		error: function(e) {
			console.log(e);
		},
	});
}

function LocPage(number) {
	var ngayBatDau = document.getElementById("ngayBatDau").value;
	var ngayKetThuc = document.getElementById("ngayKetThuc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/thong-ke-tong-don-hang-load-page`,
		dataType: "json",
		data: {
			number, ngayBatDau, ngayKetThuc
		},
		timeout: 100000,

		success: function(data) {
			var id = document.getElementById("donHangBanTable")
			id.innerHTML = data.map((e) => {
				return `
					<tr>
										<td>${e[0]}</td>
										<td>${e[1]}</td>
										<td>${new Date(e[2]).toLocaleDateString()}</td> 
										
										<td>${formatCurrency(e[4])}</td>
									</tr>
					`
			}).join(" ");

		},
		error: function(e) {
			console.log(e);
		},
	});
}