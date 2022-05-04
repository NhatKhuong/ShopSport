
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Danh sách nhân viên | Quản trị Admin</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Main CSS-->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin/main.css">
<!-- Font-icon css-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<!-- or -->
<link rel="stylesheet"
	href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<script src="http://code.jquery.com/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.baotrongit.com/Money-Format-Plugin/money_format.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body onload="time()" class="app sidebar-mini rtl">
	<!-- Navbar-->
	<header class="app-header">
		<!-- Sidebar toggle button-->
		<a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
			aria-label="Hide Sidebar"></a>
		<!-- Navbar Right Menu-->
		<ul class="app-nav">


			<!-- User Menu-->
			<li><a class="app-nav__item" href="/index.html"><i
					class='bx bx-log-out bx-rotate-180'></i> </a></li>
		</ul>
	</header>
	<!-- Sidebar menu-->
	<div class="app-sidebar__overlay" data-toggle="sidebar"></div>

	<div class="menu">
		<jsp:include page="sidebarMenu.jsp"></jsp:include>
	</div>

	<main class="app-content">
		<div class="row">
			<div class="col-md-12">
				<div class="app-title">
					<ul class="app-breadcrumb breadcrumb">
						<li class="breadcrumb-item"><a href="#"><b>Báo cáo
									doanh thu </b></a></li>
					</ul>
					<div id="clock"></div>
				</div>
			</div>

			<div class="row">

				<div class="col-md-6">
					<p>
						Từ ngày:<input type="date" id="ngayBatDau" class="form-control">
					</p>
					<input type="button" id="btnLoc" onclick="LocForm()"
						class="btn btn-primary btn-sm" value="Lọc kết quả">
				</div>

				<br> <br>
				<div class="col-md-6">
					<p>
						Đến ngày:<input type="date" id="ngayKetThuc" class="form-control">
					</p>
				</div>
			</div>
		</div>
		<form action="#" id="form-reload">
			<div class="row">
				<div class="col-md-6 col-lg-3">
					<div class="widget-small primary coloured-icon">
						<i class='icon  bx bxs-user fa-3x'></i>
						<div class="info">
							<h4>Tổng người dùng</h4>
							<p>
								<b>${soLuongNguoiDung} người dùng</b>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<div class="widget-small info coloured-icon">
						<i class='icon bx bxs-purchase-tag-alt fa-3x'></i>
						<div class="info">
							<h4>Tổng sản phẩm</h4>
							<p>
								<b>${soLuongSanPham} sản phẩm</b>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<div class="widget-small warning coloured-icon">
						<i class='icon fa-3x bx bxs-shopping-bag-alt'></i>
						<div class="info">
							<h4>Tổng đơn hàng</h4>
							<p id ="soDonHang">
								<b >${soDonHang} đơn hàng</b>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<div class="widget-small danger coloured-icon">
						<i class='icon fa-3x bx bxs-info-circle'></i>
						<div class="info">
							<h4>Đơn hàng thành công</h4>
							<p id ="soDonHangThanhCong">
								<b>${soDonThanhCong} đơn hàng</b>
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-lg-3">
					<div class="widget-small primary coloured-icon">
						<i class='icon fa-3x bx bxs-chart'></i>
						<div class="info">
							<h4>Tổng thu nhập</h4>
							<p id = "tongTienThuNhap">
								<b>${tienThuNhap} đ</b>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<div class="widget-small info coloured-icon">
						<i class='icon fa-3x bx bxs-user-badge'></i>
						<div class="info">
							<h4>Hết hàng</h4>
							<p>
								<b>${soSPHetHang} sản phẩm</b>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<div class="widget-small warning coloured-icon">
						<i class='icon fa-3x bx bxs-tag-x'></i>
						<div class="info">
							<h4>Đơn hàng chờ xác nhận</h4>
							<p id = "soDonHangChoXacNhan">
								<b>${soDonHangChoXacNhan} đơn hàng</b>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<div class="widget-small danger coloured-icon">
						<i class='icon fa-3x bx bxs-receipt'></i>
						<div class="info">
							<h4>Đơn hàng hủy</h4>
							<p id ="soDonHangHuy">
								<b>${soDonHangHuy } đơn hàng</b>
							</p>
						</div>
					</div>
				</div>

			</div>
			<div class="row">
				<div class="col-md-6 col-lg-3">
					<div class="widget-small primary coloured-icon">
						<i class='icon fa-3x bx bxs-chart'></i>
						<div class="info">
							<h4>Tổng người dùng bị chặn</h4>
							<p>
								<b>${soNguoiDungBiChan } người</b>
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="tile">
						<div>
							<h3 class="tile-title">SẢN PHẨM BÁN CHẠY</h3>
						</div>
						<div class="tile-body">
							<table class="table table-hover table-bordered" id="sampleTable">
								<thead>
									<tr>
										<th>Mã sản phẩm</th>
										<th>Tên sản phẩm</th>
										<th>Giá tiền</th>
										<th>Tên loại sản phẩm </th>
									</tr>
								</thead>
								<tbody id = "sanPhamBanChaytable">
									<c:forEach var="item" items="${listSanPhamBanChay}">
									<tr>
										<td>${item.getMaSanPham()}</td>
										<td>${item.getTenSanPham()}</td>
										<td>${item.getGiaTien()}</td>
										<td>${item.getLoaiSanPham().getTenLoaiSanPham()}</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="tile">
						<div>
							<h3 class="tile-title">TỔNG ĐƠN HÀNG</h3>
						</div>
						<div class="tile-body">
							<table class="table table-hover table-bordered" id="sampleTable">
								<thead>
									<tr>
										<th>Mã đơn hàng</th>
										<th>Khách hàng</th>
										<th>Ngày tạo đơn hàng</th>
										<th>Số lượng mua</th>
										<th>Tổng tiền</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${listDonHangBan}">
									<tr>
										<td>${item[0]}</td>
										<td>${item[1]}</td>
										<td>${item[2]}</td>
										<td>${item[3]}</td>
										<td>${item[4]}</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="tile">
						<div>
							<h3 class="tile-title">SẢN PHẨM ĐÃ HẾT</h3>
						</div>
						<div class="tile-body">
							<table class="table table-hover table-bordered" id="sampleTable">
								<thead>
									<tr>
										<th>Mã sản phẩm</th>
										<th>Tên sản phẩm</th>
										<th>Tên kích thước</th>
										<th>Số lượng</th>
										<th>Tình trạng</th>
										<th>Giá tiền</th>
										<th>Loại sản phẩm</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="item" items="${listsanPhamHetHang}">
										<tr>
											<td>${item[0]}</td>
											<td>${item[1]}</td>
											<td>${item[2]}</td>
											<td>${item[3]}</td>
											<td><span class="badge bg-danger">Hết hàng</span></td>
											<td>${item[4]}</td>
											<td>${item[5]}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<!-- 	<div class="row">
			<div class="col-md-6">
				<div class="tile">
					<h3 class="tile-title">DỮ LIỆU HÀNG THÁNG</h3>
					<div class="embed-responsive embed-responsive-16by9">
						<canvas class="embed-responsive-item" id="lineChartDemo"></canvas>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="tile">
					<h3 class="tile-title">THỐNG KÊ DOANH SỐ</h3>
					<div class="embed-responsive embed-responsive-16by9">
						<canvas class="embed-responsive-item" id="barChartDemo"></canvas>
					</div>
				</div>
			</div>
		</div> -->

			<div class="text-right" style="font-size: 12px">
				<p>
					<b>Hệ thống quản lý V2.0 | Code by ADMIN</b>
				</p>
			</div>
		</form>
	</main>
	<script
		src="${pageContext.request.contextPath}/resources/js/admin/jquery-3.2.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/admin/main.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/resources/js/admin/pace.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/chart.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript">
		var data = {
			labels : [ "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5",
					"Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10",
					"Tháng 11", "Tháng 12" ],
			datasets : [ {
				label : "Dữ liệu đầu tiên",
				fillColor : "rgba(255, 255, 255, 0.158)",
				strokeColor : "black",
				pointColor : "rgb(220, 64, 59)",
				pointStrokeColor : "#fff",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "green",
				data : [ 20, 59, 90, 51, 56, 100, 40, 60, 78, 53, 33, 81 ]
			}, {
				label : "Dữ liệu kế tiếp",
				fillColor : "rgba(255, 255, 255, 0.158)",
				strokeColor : "rgb(220, 64, 59)",
				pointColor : "black",
				pointStrokeColor : "#fff",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "green",
				data : [ 48, 48, 49, 39, 86, 10, 50, 70, 60, 70, 75, 90 ]
			} ]
		};

		var ctxl = $("#lineChartDemo").get(0).getContext("2d");
		var lineChart = new Chart(ctxl).Line(data);

		var ctxb = $("#barChartDemo").get(0).getContext("2d");
		var barChart = new Chart(ctxb).Bar(data);
	</script>
	<!-- Google analytics script-->
	<script type="text/javascript">
		if (document.location.hostname == 'pratikborsadiya.in') {
			(function(i, s, o, g, r, a, m) {
				i['GoogleAnalyticsObject'] = r;
				i[r] = i[r] || function() {
					(i[r].q = i[r].q || []).push(arguments)
				}, i[r].l = 1 * new Date();
				a = s.createElement(o), m = s.getElementsByTagName(o)[0];
				a.async = 1;
				a.src = g;
				m.parentNode.insertBefore(a, m)
			})(window, document, 'script',
					'//www.google-analytics.com/analytics.js', 'ga');
			ga('create', 'UA-72504830-1', 'auto');
			ga('send', 'pageview');
		}
	</script>
	<script src="<c:url value='/resources/js/admin/thongKeHoaDon.js'/>"></script>
</body>

</html>