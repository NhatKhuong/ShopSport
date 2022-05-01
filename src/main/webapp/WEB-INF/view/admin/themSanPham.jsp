
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Thêm sản phẩm | Quản trị Admin</title>
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
<script>
	function readURL(input, thumbimage) {
		if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#thumbimage").attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		} else { // Sử dụng cho IE
			$("#thumbimage").attr('src', input.value);

		}
		$("#thumbimage").show();
		$('.filename').text($("#uploadfile").val());
		$('.Choicefile').css('background', '#14142B');
		$('.Choicefile').css('cursor', 'default');
		$(".removeimg").show();
		$(".Choicefile").unbind('click');

	}
	$(document)
			.ready(
					function() {
						$(".Choicefile").bind('click', function() {
							$("#uploadfile").click();

						});
						$(".removeimg")
								.click(
										function() {
											$("#thumbimage").attr('src', '')
													.hide();
											$("#myfileupload")
													.html(
															'<input type="file" id="uploadfile"  onchange="readURL(this);" />');
											$(".removeimg").hide();
											$(".Choicefile").bind(
													'click',
													function() {
														$("#uploadfile")
																.click();
													});
											$('.Choicefile').css('background',
													'#14142B');
											$('.Choicefile').css('cursor',
													'pointer');
											$(".filename").text("");
										});
					})
</script>
</head>

<body class="app sidebar-mini rtl">
	<style>
.Choicefile {
	display: block;
	background: #14142B;
	border: 1px solid #fff;
	color: #fff;
	width: 150px;
	text-align: center;
	text-decoration: none;
	cursor: pointer;
	padding: 5px 0px;
	border-radius: 5px;
	font-weight: 500;
	align-items: center;
	justify-content: center;
}

.Choicefile:hover {
	text-decoration: none;
	color: white;
}

#uploadfile, .removeimg {
	display: none;
}

#thumbbox {
	position: relative;
	width: 100%;
	margin-bottom: 20px;
}

.removeimg {
	height: 25px;
	position: absolute;
	background-repeat: no-repeat;
	top: 5px;
	left: 5px;
	background-size: 25px;
	width: 25px;
	/* border: 3px solid red; */
	border-radius: 50%;
}

.removeimg::before {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	content: '';
	border: 1px solid red;
	background: red;
	text-align: center;
	display: block;
	margin-top: 11px;
	transform: rotate(45deg);
}

.removeimg::after {
	/* color: #FFF; */
	/* background-color: #DC403B; */
	content: '';
	background: red;
	border: 1px solid red;
	text-align: center;
	display: block;
	transform: rotate(-45deg);
	margin-top: -2px;
}

input:valid {
	border-color: hsl(120, 76%, 50%);
}
</style>
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
		<div class="app-title">
			<ul class="app-breadcrumb breadcrumb">
				<li class="breadcrumb-item">Danh sách sản phẩm</li>
				<li class="breadcrumb-item"><a href="#">Thêm sản phẩm</a></li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<h3 class="tile-title">Tạo mới sản phẩm</h3>
					<div class="tile-body">
						<div class="row element-button">

							<div class="col-sm-2">
								<a class="btn btn-add btn-sm" id="myModalThemLoaiSanPham"
									data-toggle="modal" data-target="#addLoaiSanPham"><i
									class="fas fa-folder-plus"></i> Thêm loại sản phẩm</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-add btn-sm" id="myModalThemNhanHieu"
									data-toggle="modal" data-target="#addNhanHieu"><i
									class="fas fa-folder-plus"></i> Thêm nhãn hiệu</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-add btn-sm" id="myModalThemMonTheThao"
									data-toggle="modal" data-target="#addMonTheThao"><i
									class="fas fa-folder-plus"></i>Thêm môn thể thao</a>
							</div>
						</div>
						<form class="row">
							<div class="form-group col-md-3">
								<label class="control-label">Mã sản phẩm </label> <input
									class="form-control" id="maSanPham" type="text" value="${maSP}"
									disabled="disabled" style="color: red;">
							</div>
							<div class="form-group col-md-3">
								<label class="control-label">Tên sản phẩm</label> <input
									class="form-control" id="tenSanPham" type="text"
									placeholder="Tên sản phẩm" required pattern="\S+.*">
							</div>
							<div class="form-group  col-md-3">
								<label class="control-label">Số lượng</label> <input
									class="form-control" type="number" id="soLuong"
									onkeypress="soLuongPress()" min="1" value="1">
							</div>

							<div class="form-group col-md-3 ">
								<label for="exampleSelect1" class="control-label1">Môn
									thể thao</label> <select class="form-control" id="cbTenMonTheThao">
									<c:forEach var="item" items="${listTenMonTT}">
										<option>${item}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="exampleSelect1" class="control-labe2">Loại
									sản phẩm</label> <select class="form-control" id="cbLoaiSanPham">
									<c:forEach var="item" items="${listTenLoaiSP}">
										<option>${item}</option>
									</c:forEach>

								</select>

							</div>

							<div class="form-group col-md-3">
								<label for="exampleSelect1" class="control-label">Nhãn
									hiệu</label> <select class="form-control" id="cbNhanHieu">
									<c:forEach var="item" items="${listTenNhanHieu}">
										<option>${item}</option>
									</c:forEach>

								</select>

							</div>
							<div class="form-group col-md-3">
								<label class="control-label">Giá tiền VNĐ</label> <input
									class="form-control" id="giaTien" onkeypress="return isNumberKey(event);" type="text"
									placeholder="Nhập giá tiền VNĐ">
							</div>
							<div class="form-group col-md-3">
								<label class="control-label">Chiết khấu</label> <input
									class="form-control" id="chietKhau"
									onkeypress="chietKhauPress()" type="number" min="0" max="1"
									step="0.01" value="0">
							</div>
							<div class="form-group col-md-12">
								<label class="control-label">Ảnh sản phẩm</label>
								<div id="myfileupload">
									<input type="file" id="uploadfile" name="ImageUpload"
										onchange="readURL(this);" />
								</div>
								<div id="thumbbox">
									<img height="450" width="400" alt="Thumb image" id="thumbimage"
										style="display: none" /> <a class="removeimg"
										href="javascript:"></a>
								</div>
								<div id="boxchoice">
									<a href="javascript:" class="Choicefile"><i
										class="fas fa-cloud-upload-alt"></i> Chọn ảnh</a>
									<p style="clear: both"></p>
								</div>

							</div>
							<div class="form-group col-md-12">
								<label class="control-label">Mô tả sản phẩm</label>
								<textarea class="form-control" name="mota" id="mota"></textarea>
								<script>
									CKEDITOR.replace('mota');
								</script>
							</div>
					</div>
					<button class="btn btn-save" onclick="addSanPham()" type="button">Lưu
						lại</button>
					<a class="btn btn-cancel" href="quan-ly-san-pham">Hủy bỏ</a>
				</div>
	</main>

	<!--
MODAL
-->
	<!--
  MODAL Thêm loại sản phẩm
-->
	<div class="modal fade" id="addLoaiSanPham" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">

				<div class="modal-body">
					<div class="row">
						<div class="form-group  col-md-12">
							<span class="thong-tin-thanh-toan">
								<h5>THÊM MỚI LOẠI SẢN PHẨM</h5>
							</span>
						</div>
						<div class="form-group col-md-12">
							<label class="control-label">Mã loại sản phẩm</label> <input
								class="form-control" id="maLoaiSanPham" type="text" required
								disabled="disabled" value="${maLoaiSP}" style="color: red;">
						</div>
						<div class="form-group col-md-12">
							<label class="control-label">Tên loại sản phẩm</label> <input
								class="form-control" id="tenLoaiSanPham" type="text" required
								pattern="\S+.*" placeholder="Tên loại sản phẩm">
						</div>
					</div>
					<BR>
					<button class="btn btn-save" onclick="addLoaiSanPham()"
						type="button">Lưu lại</button>
					<a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy
						bỏ</a> <BR>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

	<!-- MODAL Thêm Nhãn Hiệu
 -->
	<div class="modal fade" id="addNhanHieu" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">

				<div class="modal-body">
					<div class="row">
						<div class="form-group  col-md-12">
							<span class="thong-tin-thanh-toan">
								<h5>THÊM MỚI NHÃN HIỆU</h5>
							</span>
						</div>
						<div class="form-group col-md-12">
							<label class="control-label">Mã nhãn hiệu</label> <input
								class="form-control" id="maNhanHieu" type="text" required
								disabled="disabled" value="${maNhanHieu}" style="color: red;">
						</div>
						<div class="form-group col-md-12">
							<label class="control-label">Tên nhãn hiệu</label> <input
								class="form-control" id="tenNhanHieu" type="text" required
								pattern="\S+.*" placeholder="Tên nhãn hiệu">
						</div>
					</div>
					<BR>
					<button class="btn btn-save" onclick="addNhanHieu()" type="button">Lưu
						lại</button>
					<a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy
						bỏ</a> <BR>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<!-- MODAL Thêm Môn Thể Thao
 -->
	<div class="modal fade" id="addMonTheThao" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div class="row">
						<div class="form-group  col-md-12">
							<span class="thong-tin-thanh-toan">
								<h5>THÊM MỚI MÔN THỂ THAO</h5>
							</span>
						</div>
						<div class="form-group col-md-12">
							<label class="control-label">Mã môn thể thao</label> <input
								class="form-control" id="maMonTheThao" type="text" required
								disabled="disabled" value="${maMTT}" style="color: red;">
						</div>
						<div class="form-group col-md-12">
							<label class="control-label">Tên môn thể thao</label> <input
								class="form-control" id="tenMonTheThao" type="text" required
								pattern="\S+.*" placeholder="Tên môn thể thao">
						</div>
					</div>
					<BR>
					<button class="btn btn-save" onclick="addTaoMonTheThao()"
						type="button">Lưu lại</button>
					<a class="btn btn-cancel" id="btnCanelMonTheThao"
						data-dismiss="modal" href="#">Hủy bỏ</a> <BR>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<!--
MODAL
-->



	<!-- Essential javascripts for application to work-->
	<script
		src="${pageContext.request.contextPath}/resources/js/admin/main.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/resources/js/admin/pace.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/admin/chart.js"></script>
	<!--===============================================================================================-->
	<script>
		function soLuongPress() {
			var a = document.getElementById("soLuong").value
			if (parseInt(a) > 0) {

			} else {
				document.getElementById("soLuong").value = 1
			}
		}
	</script>

	<script>
		function chietKhauPress() {
			var b = document.getElementById("chietKhau").value

			if (parseInt(b) >= 0 && parseInt(b) <= 1) {

			} else {
				document.getElementById("chietKhau").value = 0.1
			}
		}
	</script>

	<script type="text/javascript">
		$('#giaTien').simpleMoneyFormat();
		function isNumberKey(evt){
		    var charCode = (evt.which) ? evt.which : evt.keyCode
		    return !(charCode > 31 && (charCode < 48 || charCode > 57));
		}
	</script>

	<script>
		const inpFile = document.getElementById("inpFile");
		const loadFile = document.getElementById("loadFile");
		// const previewContainer = document.getElementById("imagePreview");
		const previewContainer = document.getElementById("imagePreview");
		const previewImage = previewContainer
				.querySelector(".image-preview__image");
		const previewDefaultText = previewContainer
				.querySelector(".image-preview__default-text");
		inpFile.addEventListener("change", function() {
			const file = this.files[0];
			if (file) {
				const reader = new FileReader();
				previewDefaultText.style.display = "none";
				previewImage.style.display = "block";
				reader.addEventListener("load", function() {
					previewImage.setAttribute("src", this.result);
				});
				reader.readAsDataURL(file);
			}
		});
	</script>
	<script src="<c:url value='/resources/js/sanPham.js'/>"></script>
</body>

</html>