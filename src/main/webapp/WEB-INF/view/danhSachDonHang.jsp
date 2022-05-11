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

<!-- input custome  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.min.css"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/css/fileinput.min.css"
	media="all" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	crossorigin="anonymous">
</head>
<style>
.ratings i {
	color: #ba933e;
	font-size: 22px;
}

.ratings .number-start {
	color: #ba933e;
	margin-right: 5px;
}
</style>

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
					<!-- 	<div class="search_block">
						<i class="fa fa-search" aria-hidden="true"></i> <input type="text"
							placeholder="Tìm kiếm theo mã hóa đơn, tên sản phẩm"
							class="txtSearch">
					</div> -->
					<!-- </div> -->

					<c:forEach var='donHang' items="${danhSachDonHang}">
						<div class="component order_status_block">
							<div class="order_status_item_header">
								<i class="fa fa-clock-o" aria-hidden="true"></i>
								<small class="order_status_result">
									Ngày đặt: <i class='date'>${donHang.ngayTao} </i>
								</small>
								<span>|</span>
								<div class="order_status_name">${ donHang.trangThaiDonHang.tenTrangThaiDonHang}</div>
							</div>
							<div
								style="max-height: 400px; overflow: scroll; overflow-x: hidden; padding-right: 20px; margin-top: 15px">
								<c:forEach var='chiTietDonHang'
									items="${donHang.danhSachChiTietDonHang }">
									<div class="order_status_item_body">
										<div class="img_name_orderstatus">
											<div class='d-none productId'>${chiTietDonHang.chiTietSanPham.sanPham.maSanPham}</div>
											<div class="order_status_item_img">
												<img
													src='${pageContext.request.contextPath}/resources/images/${chiTietDonHang.chiTietSanPham.sanPham.danhSachHinhAnhSanPham[0].hinhAnh}'
													alt="">
											</div>
											<div class="order_status_item_info">
												<div class="order_status_item_name break_text">
													<a
														href='${pageContext.request.contextPath}/san-pham/chi-tiet-san-pham?maSanPham=${chiTietDonHang.chiTietSanPham.sanPham.maSanPham }'>${ chiTietDonHang.chiTietSanPham.sanPham.tenSanPham}</a>
												</div>
												<small class="order_status_item_quatity"> Số lượng:
													<i>${ chiTietDonHang.soLuongMua}</i>
													
												</small> <br> <small
													class="order_status_item_size ${ chiTietDonHang.chiTietSanPham.kichThuoc.tenKichThuoc == 'Khác' || chiTietDonHang.chiTietSanPham.kichThuoc.tenKichThuoc == 'Khac' ? 'd-none':'' }">
													Kích thước: <i class='time'>${ chiTietDonHang.chiTietSanPham.kichThuoc.tenKichThuoc}</i>
												</small>
											</div>
										</div>
										<div>
										<div class="order_status_item_price price">${ chiTietDonHang.giaMua}</div>
											<div class="order_status_item_reiview ${donHang.trangThaiDonHang.maTrangThaiDonHang == 'TTDH00003' ? '' : 'd-none' }">Viết đánh giá</div>
										</div>
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
									<button
										onclick="window.location.href='${pageContext.request.contextPath}/don-hang/chi-tiet-don-hang/${ donHang.maDonHang}'"
										class="btn_first btn text-white "
										style="width: 156px; background-color: #fe4c50;">Chi
										tiết đơn hàng</button>
									<button class="btn bg-white d-none"
										style="border: 1px solid #ccc;">Chi tiết đơn hàng</button>
								</div>
							</div>
						</div>
					</c:forEach>
					<!-- /Body -->
				</div>
			</div>

			<nav class="pagination_block d-flex justify-content-center mb-4">
				<ul class="pagination" id="pagination_id">
					<li class="page-item ${page == 1 ? 'disabled':'' }"><a
						class="page-link" href="?page=${page-1}" tabindex="-1"><i
							class="fa fa-angle-left" aria-hidden="true"></i></a></li>
					<c:forEach var="i" begin="1" end="${tongSoTrang}">
						<li class="page-item ${i == page ? 'active':'' }"><a
							class="page-link" href="?page=${i}">${i}</a></li>
					</c:forEach>
					<li class="page-item  ${page == tongSoTrang ? 'disabled':'' }"><a
						class="page-link" href="?page=${page+1}"><i
							class="fa fa-angle-right" aria-hidden="true"></i></a></li>
				</ul>
			</nav>

			<div id='footer'>
				<jsp:include page="components/footer.jsp"></jsp:include>
			</div>
		</div>
		<!--Modal comment -->
		<div class="modal  " id="addReivewModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Đánh giá sản phẩm</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" onclick="$('#addReivewModal').modal('hide')"> &times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class='d-none' id='maSanPham'>123</div>
					<div class="create-comment pt-3 text-center">
						<div class="option pt-4 pl-0 pr-0">
							<form:form method="POST" class="form form-vertical">
								<div class="row">
									<div class="col-sm-5 text-center" id='box-input-upload-image'>
										<div class="kv-avatar">
											<div class="file-loading">
												<input id="avatar-1" name="file" type="file" required>
											</div>
										</div>
										<div class="kv-avatar-hint">
											<small>Select file < 10 MB</small>
										</div>
									</div>
									<div class="col-sm-7">
										<div class=" bg-light p-4">
											<h5 class="text-secondary" style="font-size: 16px">Xếp hạng</h5>
											<div class="your-rating">
												<!--  code JSP set rating at here (checked) -->
												<div class="ratings-input" style="display: none;">
													<input type="radio" name="rating-input" value='1'
														class="rating-input" id="rating-input-1"> <input
														type="radio" name="rating-input" value='2'
														class="rating-input" id="rating-input-2"> <input
														type="radio" name="rating-input" value='3'
														class="rating-input" id="rating-input-3"> <input
														type="radio" name="rating-input" value='4'
														class="rating-input" id="rating-input-4"> <input
														type="radio" name="rating-input" value='5'
														class="rating-input" id="rating-input-5" checked>
												</div>
												<div class="ratings">
													<i class="fa fa-star rating-start" id="rating-1"
														aria-hidden="true"> </i> <i
														class="fa fa-star rating-start" id="rating-2"
														aria-hidden="true"> </i> <i
														class="fa fa-star rating-start" id="rating-3"
														aria-hidden="true"></i> <i class="fa fa-star rating-start"
														id="rating-4" aria-hidden="true"></i> <i
														class="fa fa-star rating-start" id="rating-5"
														aria-hidden="true"></i>
												</div>
											</div>
										</div>
										<div class="row col-12 pt-3">
											<textarea name="review" id="review" class="p-3 form-control"
												cols="30" rows="3"></textarea>
										</div>

										<div class="form-group">
											<hr>
											<div class="text-right">
												<button type="button" id="submit-comment"
													class="btn btn-primary">Submit</button>
											</div>
										</div>
									</div>
								</div>
							</form:form>
							<div id="kv-avatar-errors-1" class="text-center"
								style="display: none"></div>
						</div>
					</div>
				</div>
			</div>
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
			<!-- Input js  -->
	<script
		src="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/js/plugins/piexif.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/js/plugins/sortable.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/js/fileinput.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/js/locales/LANG.js"></script>
		
		
			<script src="<c:url value='/resources/js/chiTietDonHang.js'/>"></script>
		<script type="text/javascript">
		
		/* format date */
		(()=>{
		    document.querySelectorAll('.date').forEach(e=>{e.innerText = new Date(e.innerText).toLocaleDateString()});
		})();
		</script>
</body>

</html>