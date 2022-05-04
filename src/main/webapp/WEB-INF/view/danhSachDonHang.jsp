<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Danh sách đơn hàng</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />

<link rel="stylesheet"
	href="<c:url value='/resources/css/trangthaidonhang.css' />">
<link rel="stylesheet"
	href="<c:url value='/resources/css/layout.css' />">
</head>


<body>
	<div class="container--fluid">

		<div id='header'>
			<jsp:include page="components/header.jsp"></jsp:include>
		</div>


		<div class="components">
			<!-- Body -->
			<div class="container">
				<!-- breadcrumb -->

				<div class="breadcrumb-components">
					<jsp:include page="components/breadcrumb.jsp"></jsp:include>
				</div>
				<!-- /breadcrumb -->

				<div class="container">
					<div class="component block-btn-status ">
						<div
							class="btn-status ${maTrangThaiDonHang == null ? 'active': '' }">
							<a
								href="${pageContext.request.contextPath}/don-hang/danh-sach-don-hang">Tất
								cả</a>
						</div>
						<c:forEach var='item' items="${danhSachTrangThaiDonHang }">
							<div
								class="btn-status ${maTrangThaiDonHang == item.maTrangThaiDonHang ? 'active': '' }">
								<a
									href="${pageContext.request.contextPath}/don-hang/danh-sach-don-hang/${item.maTrangThaiDonHang}">
									${item.tenTrangThaiDonHang} </a>
							</div>
						</c:forEach>
					</div>

					<!-- <div class="component p-2"> -->
					<div class="search_block">
						<i class="fa fa-search" aria-hidden="true"></i> <input type="text"
							placeholder="Tìm kiếm theo mã hóa đơn, tên sản phẩm"
							class="txtSearch">
					</div>
					<!-- </div> -->

					<c:forEach var='donHang' items="${danhSachDonHang}">
						<div class="component order_status_block">
							<div class="order_status_item_header">
								<i class="fa fa-clock-o" aria-hidden="true"></i>
								<div class="order_status_result">Ngày đặt: <i>${donHang.ngayTao } </i></div>
								<span>|</span>
								<div class="order_status_name">  ${maTrangThaiDonHang == null ? '': donHang.trangThaiDonHang.tenTrangThaiDonHang}</div>
							</div>
							<div
								style="max-height: 400px; overflow: scroll; overflow-x: hidden; padding-right: 20px; margin-top: 15px">
								<c:forEach var='chiTietDonHang'
									items="${donHang.danhSachChiTietDonHang }">
									<div class="order_status_item_body"  >
										<div class="img_name_orderstatus">

											<div class="order_status_item_img">
												<img
													src='${pageContext.request.contextPath}/resources/images/${chiTietDonHang.chiTietSanPham.sanPham.danhSachHinhAnhSanPham[0].hinhAnh}'
													alt="">
											</div>
											<div class="order_status_item_info">
												<div class="order_status_item_name break_text"  ><a
										href='${pageContext.request.contextPath}/san-pham/chi-tiet-san-pham?maSanPham=${chiTietDonHang.chiTietSanPham.sanPham.maSanPham }'>${ chiTietDonHang.chiTietSanPham.sanPham.tenSanPham}</a></div>
												<small class="order_status_item_quatity"> Số lượng:
													<i>${ chiTietDonHang.soLuongMua}</i>
												</small> <br> <small class="order_status_item_size">
													Kích thước: <i class='time'>${ chiTietDonHang.chiTietSanPham.kichThuoc.tenKichThuoc}</i>
												</small>
											</div>
										</div>
										<div class="order_status_item_price price">${ chiTietDonHang.giaMua}</div>
									</div>
									<hr>
								</c:forEach>
							</div>
							<div class="order_status_item_footer">
								<div class="order_status_item_footer_price">
									<div class="order_status_item_footer_price_title">Tổng số
										tiền:</div>
									<div class="order_status_item_footer_price_nane price">${donHang.tongTien()}</div>
								</div>
								<div class="order_status_item_footer_btn">
									<button  onclick="window.location.href='${pageContext.request.contextPath}/don-hang/chi-tiet-don-hang/${ donHang.maDonHang}'" class="btn_first btn text-white "
										style="width: 156px; background-color: #fe4c50;">Chi tiết đơn hàng</button>
									<button class="btn bg-white d-none" style="border: 1px solid #ccc;">Chi tiết đơn hàng</button>
								</div>
							</div>
						</div>
					</c:forEach>
					<!-- /Body -->
				</div>
			</div>

			<nav class="pagination_block d-flex justify-content-center mb-4">
				<ul class="pagination" id="pagination_id">
					<li class="page-item ${page == 1 ? 'disabled':'' }"><a class="page-link"  href="?page=${page-1}"
						tabindex="-1"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
					</li>
					<c:forEach var="i" begin="1" end="${tongSoTrang}">
						<li class="page-item ${i == page ? 'active':'' }"><a class="page-link" href="?page=${i}">${i}</a></li>
					</c:forEach>
					<li class="page-item  ${page == tongSoTrang ? 'disabled':'' }"><a class="page-link" href="?page=${page+1}"><i
							class="fa fa-angle-right" aria-hidden="true"></i></a></li>
				</ul>
			</nav>

			<div id='footer'>
				<jsp:include page="components/footer.jsp"></jsp:include>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
		<script src="<c:url value='/resources/js/home.js'/>" defer="defer"></script>
</body>

</html>