<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Danh sách sản phẩm | Quản trị Admin</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Main CSS-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin/main.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<!-- or -->
<link rel="stylesheet"
	href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

<!-- Font-icon css-->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<style>
.tab-item {
	min-width: 80px;
	padding: 16px 20px 11px 20px;
	font-size: 20 px;
	text-align: center;
	color: #1a1013;
	background-color: #fff;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom: 5px solid transparent;
	opacity: 0.6;
	cursor: pointer;
	transition: all 0.25s ease;
}

.tab-item.active {
	opacity: 1;
}

.tab-icon {
	font-size: 10px;
	width: 12px;
	position: relative;
	top: 2px;
}

.tab-item:hover {
	opacity: 1;
	background-color: rgba(194, 53, 100, 0.05);
	border-color: rgba(194, 53, 100, 0.1);
}

.tab-pane {
	color: #333;
	display: none;
}

.tab-pane.active {
	display: block;
}

.tab-pane h2 {
	font-size: 24px;
	margin-bottom: 8px;
}
</style>
<link rel="stylesheet"
	href="<c:url value='/resources/css/admin/paging.css'/>">
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
		<div class="app-title">
			<ul class="app-breadcrumb breadcrumb side">
				<li class="breadcrumb-item active"><a href="#"><b>Danh
							sách sản phẩm</b></a></li>
			</ul>
			<div id="clock"></div>
		</div>
		<div class="tab-pane active">
			<div class="row">
				<div class="col-md-4">
					<p>
						Tên sản phẩm:<input type="text" id="locTenSanPham"
							class="form-control">
					</p>

				</div>
				<div class="col-md-4">
					<p>
						Tình trạng: <select class="dashboard-filter form-control"
							id="mySelect">
							<option value="2">-- Tất cả --</option>
							<option value="1">Đang kinh doanh</option>
							<option value="0">Ngừng kinh doanh</option>
						</select>
					</p>
				</div>
				<div class="col-md-4">
					<p>
						Giá tiền:<input type="text" class="form-control" id="giaTien"
							value="0">
					</p>
				</div>
				<div class="col-md-4">
					<p>
						Loại sản phẩm: <select class="dashboard-filter form-control"
							id="selectLoaiSanPham">
							<option value="Tất cả">-- Tất cả --</option>
						</select>
					</p>
					<input type="button" id="btn-dashboard-filter"
						class="btn btn-primary btn-sm" value="Lọc kết quả"
						onclick='getDanhSachSanPham()'>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="tile">
							<div class="tile-body">
								<div class="row element-button">
									<div class="col-sm-2">

										<a class="btn btn-add btn-sm" href="them-san-pham"
											title="Thêm"><i class="fas fa-plus"></i> Tạo mới sản phẩm</a>
									</div>
									<div class="col-sm-2">
										<a class="btn btn-delete btn-sm print-file" type="button"
											title="In" onclick="myApp.printTable()"><i
											class="fas fa-print"></i> In dữ liệu</a>
									</div>
									<div class="col-sm-2">
										<a class="btn btn-delete btn-sm pdf-file" type="button"
											title="In" onclick="myFunction(this)"><i
											class="fas fa-file-pdf"></i> Xuất PDF</a>
									</div>
									<div class="col-sm-2">
										<a class="btn btn-delete btn-sm" type="button" title="Xóa"
											onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
											Xóa tất cả </a>
									</div>
								</div>
								<table class="table table-hover table-bordered"
									id="tableListSanPham">
									<thead>
										<tr>
											<th width="10"><input type="checkbox" id="all"></th>
											<th width='120'>Mã sản phẩm</th>
											<th width='550'>Tên sản phẩm</th>
											<th width='70'>Số lượng</th>
											<th width='120'>Giá tiền</th>
											<th width='120'>Loại sản phẩm</th>
											<th width='120'>Trạng Thái</th>
											<th width='80'>Chức năng</th>
										</tr>
									</thead>
									<tbody id="danhSachSanPham">
										<!-- <c:forEach var="item" items="${listSanPham}">
											<tr>
												<td width="10"><input type="checkbox" name="check1"
													value="1"></td>
												<td>${item.maSanPham}</td>
												<td>${item.tenSanPham }</td>
												<td>${item.getTongSoLuongSanPham()}</td>
												<td>${item.giaTien}đ</td>
												<td>${item.loaiSanPham.tenLoaiSanPham}</td>
												<td>${item.getTrangThai()}</td>
												<td><button class="btn btn-primary btn-sm trash"
														type="button" title="Xóa">
														<i class="fas fa-trash-alt"></i>
													</button>
													<button class="btn btn-primary btn-sm edit" type="button"
														title="Sửa" id="show-emp" data-toggle="modal"
														data-target="#ModalUP">
														<i class="fas fa-edit"></i>
													</button></td>
											</tr>
										</c:forEach> -->

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="content__paging">
			<div class="page">
				<ul>
					<li class="btn-prev btn-active fas fa-angle-left"></li>
					<div class="number-page" id="number-page">
						<!-- <li class="active">
						<a>1</a>
					</li>
					<li>
						<a>2</a>
					</li>
					<li>
						<a>3</a>
					</li> -->
					</div>
					<li class="btn-next fas fa-angle-right"></li>
				</ul>
			</div>
		</div>
		</div>
	</main>

	<!--
  MODAL
-->
	<div class="modal fade updateSanPham" id="ModalUP" tabindex="-1" role="dialog"
		aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">

				<div class="modal-body">
					<div class="row">
						<div class="form-group  col-md-12">
							<span class="thong-tin-thanh-toan">
								<h5>Chỉnh sửa thông tin sản phẩm cơ bản</h5>
							</span>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-6">
							<label class="control-label ">Mã sản phẩm</label> <input
								class="form-control " id="modalMaSP" type="text" required
								value="SP000001" disabled >
						</div>
						<div class="form-group col-md-6">
							<label class="control-label">Tên sản phẩm</label> <input
								class="form-control" id="modalTenSP"  type="text" required
								value="Bàn ăn gỗ Theresa">
						</div>
						<!--<div class="form-group  col-md-6">
							<label class="control-label">Số lượng</label> <input
								class="form-control" type="number" required value="20">
						</div>-->
						<div class="form-group col-md-6 ">
							<label for="exampleSelect1" class="control-label">Tình
								trạng sản phẩm</label> <select class="form-control" id="modalTrangThaiSP">
								<option value="1">Đang kinh doanh</option>
								<option value="0">Ngừng kinh doanh</option>
							</select>
						</div>
						<div class="form-group col-md-6">
							<label class="control-label">Giá bán</label> <input
								class="form-control" id="modalGiaSP" type="text" value="5.600.000">
						</div>


						<!--<div class="form-group col-md-6">
							<label for="exampleSelect1" class="control-label">Danh
								mục</label> <select class="form-control" id="exampleSelect1">
								<option>Bàn ăn</option>
								<option>Bàn thông minh</option>
								<option>Tủ</option>
								<option>Ghế gỗ</option>
								<option>Ghế sắt</option>
								<option>Giường người lớn</option>
								<option>Giường trẻ em</option>
								<option>Bàn trang điểm</option>
								<option>Giá đỡ</option>
							</select>
						</div>-->
						<div class="form-group col-md-12">
							<label class="control-label">Ảnh sản phẩm</label>
							<div id="myfileupload">
								<input type="file" id="uploadfile" name="ImageUpload"
									onchange="readURL(this);" />
							</div>
						</div>
					
						<BR>
						<button class="btn btn-save " id="btnLuu"  type="button"  >Lưu lại</button>
						<a class="btn btn-cancel " data-dismiss="modal" href="#">Hủy bỏ</a>
						<BR>
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
		<!-- The javascript plugin to display page loading on top-->
		<!-- Data table plugin-->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/js/admin/jquery.dataTables.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/js/admin/dataTables.bootstrap.min.js"></script>
		<!-- Page specific javascripts-->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
		<script src="<c:url value='/resources/js/lib/owl.carousel.js'/>"
			data-cover></script>
		<script src="<c:url value='/resources/js/lib/owl.support.js'/>"
			data-cover></script>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
		<script src="<c:url value='/resources/js/admin/quanLySanPham.js'/>"></script>
		<script type="text/javascript">
    $('#sampleTable').DataTable();
    //Thời Gian
    function time() {
      var today = new Date();
      var weekday = new Array(7);
      weekday[0] = "Chủ Nhật";
      weekday[1] = "Thứ Hai";
      weekday[2] = "Thứ Ba";
      weekday[3] = "Thứ Tư";
      weekday[4] = "Thứ Năm";
      weekday[5] = "Thứ Sáu";
      weekday[6] = "Thứ Bảy";
      var day = weekday[today.getDay()];
      var dd = today.getDate();
      var mm = today.getMonth() + 1;
      var yyyy = today.getFullYear();
      var h = today.getHours();
      var m = today.getMinutes();
      var s = today.getSeconds();
      m = checkTime(m);
      s = checkTime(s);
      nowTime = h + " giờ " + m + " phút " + s + " giây";
      if (dd < 10) {
        dd = '0' + dd
      }
      if (mm < 10) {
        mm = '0' + mm
      }
      today = day + ', ' + dd + '/' + mm + '/' + yyyy;
      tmp = '<span class="date"> ' + today + ' - ' + nowTime +
        '</span>';
      document.getElementById("clock").innerHTML = tmp;
      clocktime = setTimeout("time()", "1000", "Javascript");

      function checkTime(i) {
        if (i < 10) {
          i = "0" + i;
        }
        return i;
      }
    }
  </script>
		<script>
    function banRow(r) {
      var i = r.parentNode.parentNode.rowIndex;
      document.getElementById("myTable").deleteRow(i);
    }
    jQuery(function () {
      jQuery(".ban").click(function () {
        swal({
          title: "Cảnh báo",
          text: "Bạn có chắc chắn là muốn bán sản phẩm này?",
          buttons: ["Hủy bỏ", "Đồng ý"],
        })
          .then((willDelete) => {
            if (willDelete) {
              swal("Đã bán thành công.!", {

              });
            }
          });
      });
    });
    oTable = $('#sampleTable').dataTable();
    $('#all').click(function (e) {
      $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
      e.stopImmediatePropagation();
    });
  </script>

		<script>

    const $ = document.querySelector.bind(document)
    const $$ = document.querySelectorAll.bind(document)

    const tabs = $$('.tab-item')
    const panes = $$('.tab-pane')

    tabs.forEach((tab, index) => {
      const pane = panes[index]



      tab.onclick = function () {

        $('.tab-item.active').classList.remove('active')
        $('.tab-pane.active').classList.remove('active')


        this.classList.add('active')
        pane.classList.add('active')
      }
    })

  </script>
</body>

</html>