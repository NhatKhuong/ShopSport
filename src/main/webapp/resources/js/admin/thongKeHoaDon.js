function LocForm() {
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