
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Danh sách người dùng | Quản trị Admin</title>
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
<script>var contextPath = "${pageContext.request.contextPath}"</script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
	
	<link rel="stylesheet"
	href="<c:url value='/resources/css/admin/paging.css'/>">
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
</head>

<body onload="time()" class="app sidebar-mini rtl">
	<!-- Navbar-->
	<header class="app-header">
		<!-- Sidebar toggle button-->
		<a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
			aria-label="Hide Sidebar"></a>
		<!-- Navbar Right Menu-->
		<ul class="app-na v">

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
							sách người dùng</b></a></li>
			</ul>
			<div id="clock"></div>
		</div>

		<!-- <div class="tabs">
			<button class="tab-item active">
				<i class="tab-icon fas fa-code"></i> Tất cả người dùng
			</button>

			<button class="tab-item">
				<i class="tab-icon fas fa-cog"></i> Danh sách người dùng bị chặn
			</button>

			<button class="tab-item">
				<i class="tab-icon fas fa-plus-circle"></i> Danh sách người dùng
				muốn chặn
			</button>
		</div> -->

		<div class="tab-pane active">
			<div class="row">
				<div class="col-md-4">
					<p>
						Họ và tên:<input type="text" id="locTenNguoiDung"
							class="form-control" onkeyup='tableSearch()'>
					</p>
					<input type="button" id="btn-dashboard-filter"
						class="btn btn-primary btn-sm" value="Lọc kết quả"
						onclick='getDanhSachNguoiDung()'>
				</div>
				<div class="col-md-4">
					<p>
						Trạng thái: <select class="dashboard-filter form-control"
							id="mySelect">
							<option value="2" selected="selected">-- Tất cả --</option>
							<option value="1">Truy Cập</option>
							<option value="0">Bị Chặn</option>
						</select>
					</p>
				</div>

				<!-- <div class="col-md-4">
          <p>Giới tính:<select class="dashboard-filter form-control" id="selectLoaiSanPham">
              <option value="2">-- Tất cả --</option>
              <option value="1">Nam</option>
              <option value="0">Nữ</option>
            </select></p>
        </div> -->

			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="tile">
						<div class="tile-body">
							<div class="row element-button">
								<div class="col-sm-2"></div>

								<div class="col-sm-2">
									<a class="btn btn-add btn-sm" type="button"
										title="Chặn" onclick="chuyenTrangThaiNhieu()"><i
										class="fas fa-print"></i> Chặn</a>
								</div>
								<div class="col-sm-2">
									<a class="btn btn-delete btn-sm pdf-file" type="button"
										title="Hủy Chặn" onclick="huyTrangThaiNhieu()"><i
										class="fas fa-file-pdf"></i> Hủy Chặn</a>
								</div>

							</div>
							<table class="table table-hover table-bordered"
								id="tableListNguoiDung">
								<thead>
									<tr>
										<th width="10"><input type="checkbox" id="all"></th>
										<th>Mã người dùng</th>
										<th>Họ và tên</th>
										<th>Địa chỉ chi tiết</th>
										<th>Địa chỉ</th>
										<th>Email</th>
										<th>Giới tính</th>
										<th>Trạng thái</th>
										<th>Chức năng</th>
									</tr>
								</thead>


								<tbody id="danhSachNguoiDung">
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


	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="<c:url value='/resources/js/admin/quanLyNguoiDung.js'/>"></script>
	<%-- <script src="<c:url value='/resources/js/admin/quanLy.js'/>"></script> --%>

	<script type="text/javascript">
    $('#sampleTable').DataTable();
    //Thời Gian
  <script>
    function deleteRow(r) {
      var i = r.parentNode.parentNode.rowIndex;
      document.getElementById("myTable").deleteRow(i);
    }
    jQuery(function () {
      jQuery(".trash").click(function () {
        swal({
          title: "Cảnh báo",

          text: "Bạn có chắc chắn là muốn xóa?",
          buttons: ["Hủy bỏ", "Đồng ý"],
        })
          .then((willDelete) => {
            if (willDelete) {
              swal("Đã xóa thành công.!", {

              });
            }
          });
      });
    });

    function blockRow(r) {
      var i = r.parentNode.parentNode.rowIndex;
      document.getElementById("myTable").blockRow(i);
    }
    jQuery(function () {
      jQuery(".block").click(function () {
        swal({
          title: "Cảnh báo",

          text: "Bạn có chắc chắn là muốn chặn?",
          buttons: ["Hủy bỏ", "Đồng ý"],
        })
          .then((willBlock) => {
            if (willBlock) {
              swal("Đã chặn thành công.!", {

              });
            }
          });
      });
    });

    function noblockRow(r) {
      var i = r.parentNode.parentNode.rowIndex;
      document.getElementById("myTable").noblockRow(i);
    }
    jQuery(function () {
      jQuery(".noblock").click(function () {
        swal({
          title: "Cảnh báo",

          text: "Bạn có chắc chắn là muốn bỏ chặn?",
          buttons: ["Hủy bỏ", "Đồng ý"],
        })
          .then((willnoBlock) => {
            if (willnoBlock) {
              swal("Đã bỏ chặn thành công.!", {

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

    //EXCEL
    // $(document).ready(function () {
    //   $('#').DataTable({

    //     dom: 'Bfrtip',
    //     "buttons": [
    //       'excel'
    //     ]
    //   });
    // });


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
    //In dữ liệu
    var myApp = new function () {
      this.printTable = function () {
        var tab = document.getElementById('sampleTable');
        var win = window.open('', '', 'height=700,width=700');
        win.document.write(tab.outerHTML);
        win.document.close();
        win.print();
      }
    }
    //     //Sao chép dữ liệu
    //     var copyTextareaBtn = document.querySelector('.js-textareacopybtn');

    // copyTextareaBtn.addEventListener('click', function(event) {
    //   var copyTextarea = document.querySelector('.js-copytextarea');
    //   copyTextarea.focus();
    //   copyTextarea.select();

    //   try {
    //     var successful = document.execCommand('copy');
    //     var msg = successful ? 'successful' : 'unsuccessful';
    //     console.log('Copying text command was ' + msg);
    //   } catch (err) {
    //     console.log('Oops, unable to copy');
    //   }
    // });


    //Modal
    $("#show-emp").on("click", function () {
      $("#ModalUP").modal({ backdrop: false, keyboard: false })
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