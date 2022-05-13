<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Danh sách đơn hàng | Quản trị Admin</title>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!-- Main CSS-->
        <link
            rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/admin/main.css"
        />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css"
        />
        <!-- or -->
        <link
            rel="stylesheet"
            href="https://unpkg.com/boxicons@latest/css/boxicons.min.css"
        />
        <!--   ============================================================================================= -->
        <link
            rel="stylesheet"
            href="<c:url value='/resources/css/admin/quanlydonhang.css' />"
        />

        <!-- Font-icon css-->
        <link
            rel="stylesheet"
            type="text/css"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
        />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
        />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css"
        />
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a
                class="app-sidebar__toggle"
                href="#"
                data-toggle="sidebar"
                aria-label="Hide Sidebar"
            ></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">
                <!-- User Menu-->
                <li>
                    <a class="app-nav__item" href="/index.html"
                        ><i class="bx bx-log-out bx-rotate-180"></i>
                    </a>
                </li>
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
                    <li class="breadcrumb-item active">
                        <a href="#"><b>Danh sách đơn hàng</b></a>
                    </li>
                </ul>
                <div id="clock"></div>
            </div>

            <div class="status__container">
                <div
                    class="btnStatus active_btn"
                    onclick="lickAndLoad('TTDH00001',this)"
                >
                    Chờ xác nhận
                </div>

                <div class="btnStatus" onclick="lickAndLoad('TTDH00002',this)">
                    Chờ lấy hàng
                </div>

                <div class="btnStatus" onclick="lickAndLoad('TTDH00003',this)">
                    Đang giao
                </div>

                <div class="btnStatus" onclick="lickAndLoad('TTDH00004',this)">
                    Đã giao
                </div>

                <div class="btnStatus" onclick="lickAndLoad('TTDH00005',this)">
                    Đã hủy
                </div>
            </div>

            <div class="">
                <div class="row">
                    <div class="col-md-4">
                        <p>
                            Mã khách hàng:<input
                                type="text"
                                id="maKhachHang"
                                class="form-control"
                            />
                        </p>
                        <input
                            onclick="filter()"
                            type="button"
                            id="btn-dashboard-filter"
                            class="btn btn-primary btn-sm"
                            value="Lọc kết quả"
                        />
                    </div>
                    <div class="col-md-4">
                        <p>
                            Tên khách hàng:<input
                                type="text"
                                id="tenKhachHang"
                                class="form-control"
                            />
                        </p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="tile">
                            <div class="tile-body">
                                <div class="row element-button">
                                    <div class="col-sm-2">
                                        <a
                                            class="btn btn-add btn-sm"
                                            type="button"
                                            onclick="chuyenTrangThaiNhieu()"
                                            ><i class="fas fa-plus"></i> Xác
                                            nhận nhiều
                                        </a>
                                    </div>
                                    <div class="col-sm-2">
                                        <a
                                            class="btn btn-delete btn-sm print-file"
                                            type="button"
                                            title="In"
                                            onclick="huyTrangThaiNhieu()"
                                            ><i class="fas fa-print"></i> Hủy
                                            nhiều
                                        </a>
                                    </div>
                                    <!-- <div class="col-sm-2">
                                        <a
                                            class="btn btn-delete btn-sm pdf-file"
                                            type="button"
                                            title="In"
                                            onclick="myFunction(this)"
                                            ><i class="fas fa-file-pdf"></i>
                                            Xuất PDF</a
                                        >
                                    </div>
                                    <div class="col-sm-2">
                                        <a
                                            class="btn btn-delete btn-sm"
                                            type="button"
                                            title="Xóa"
                                            onclick="myFunction(this)"
                                            ><i class="fas fa-trash-alt"></i>
                                            Xóa tất cả
                                        </a>
                                    </div> -->
                                </div>

                                <table
                                    class="table table-hover table-bordered"
                                    id="sampleTable"
                                >
                                    <thead>
                                        <tr>
                                            <th width="10">
                                                <input
                                                    type="checkbox"
                                                    id="all"
                                                />
                                            </th>
                                            <th>ID đơn hàng</th>
                                            <th>ID khách hàng</th>
                                            <th>Tên khách hàng</th>
                                            <th>Ngày tạo</th>
                                            <th>Tổng tiền</th>
                                            <th>Tình trạng</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tdContainer">
                                        <!-- <tr> -->
                                        <!-- <td width="10"><input type="checkbox" name="check1" value="1"></td>
                    <td>MD0837</td>
                    <td>Triệu Thanh Phú tat ca</td>
                    <td>Ghế làm việc Zuno, Bàn ăn gỗ Theresa</td>
                    <td>2</td>
                    <td>9.400.000 đ</td>
                    <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa">
                        Chờ xác nhận
                      </button>
                      <button class="btn btn-primary btn-sm edit" type="button" title="Sửa">
                        Hủy đơn hàng
                        </i></button>
                    </td> -->
                                        <!-- </tr> -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- <div class="tab-pane">
      <div class="row">
        <div class="col-md-4">
          <p>Tên khách hàng:<input type="text" id="datepicker" class="form-control"></p>
          <input type="button" id="btn-dashboard-filter" class="btn btn-primary btn-sm" value="Lọc kết quả">
        </div>
        <div class="col-md-4">
          <p>Tên sản phẩm:<input type="text" id="datepicker" class="form-control"></p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <div class="row element-button">
                <div class="col-sm-2">

                  <a class="btn btn-add btn-sm" href="form-add-don-hang.html" title="Thêm"><i class="fas fa-plus"></i>
                    Tạo mới đơn hàng</a>
                </div>
                <div class="col-sm-2">
                  <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()"><i
                      class="fas fa-print"></i> In dữ liệu</a>
                </div>
                <div class="col-sm-2">
                  <a class="btn btn-delete btn-sm pdf-file" type="button" title="In" onclick="myFunction(this)"><i
                      class="fas fa-file-pdf"></i> Xuất PDF</a>
                </div>
                <div class="col-sm-2">
                  <a class="btn btn-delete btn-sm" type="button" title="Xóa" onclick="myFunction(this)"><i
                      class="fas fa-trash-alt"></i> Xóa tất cả </a>
                </div>
              </div>

              <table class="table table-hover table-bordered" id="sampleTable">

                <thead>
                  <tr>
                    <th width="10"><input type="checkbox" id="all"></th>
                    <th>ID đơn hàng</th>
                    <th>Khách hàng</th>
                    <th>Đơn hàng</th>
                    <th>Số lượng</th>
                    <th>Tổng tiền</th>
                    <th>Tình trạng</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td width="10"><input type="checkbox" name="check1" value="1"></td>
                    <td>MD0837</td>
                    <td>Triệu Thanh Phú chờ xác nhận</td>
                    <td>Ghế làm việc Zuno, Bàn ăn gỗ Theresa</td>
                    <td>2</td>
                    <td>9.400.000 đ</td>
                    <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa">
                        Chờ xác nhận
                      </button>
                      <button class="btn btn-primary btn-sm edit" type="button" title="Sửa">
                        Hủy đơn hàng
                        </i></button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div> -->
            <!-- <div class="tab-pane">
      <div class="row">
        <div class="col-md-4">
          <p>Tên khách hàng:<input type="text" id="datepicker" class="form-control"></p>
          <input type="button" id="btn-dashboard-filter" class="btn btn-primary btn-sm" value="Lọc kết quả">
        </div>
        <div class="col-md-4">
          <p>Tên sản phẩm:<input type="text" id="datepicker" class="form-control"></p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <div class="row element-button">
                <div class="col-sm-2">

                  <a class="btn btn-add btn-sm" href="form-add-don-hang.html" title="Thêm"><i class="fas fa-plus"></i>
                    Tạo mới đơn hàng</a>
                </div>
                <div class="col-sm-2">
                  <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()"><i
                      class="fas fa-print"></i> In dữ liệu</a>
                </div>
                <div class="col-sm-2">
                  <a class="btn btn-delete btn-sm pdf-file" type="button" title="In" onclick="myFunction(this)"><i
                      class="fas fa-file-pdf"></i> Xuất PDF</a>
                </div>
                <div class="col-sm-2">
                  <a class="btn btn-delete btn-sm" type="button" title="Xóa" onclick="myFunction(this)"><i
                      class="fas fa-trash-alt"></i> Xóa tất cả </a>
                </div>
              </div>

              <table class="table table-hover table-bordered" id="sampleTable">

                <thead>
                  <tr>
                    <th width="10"><input type="checkbox" id="all"></th>
                    <th>ID đơn hàng</th>
                    <th>Khách hàng</th>
                    <th>Đơn hàng</th>
                    <th>Số lượng</th>
                    <th>Tổng tiền</th>
                    <th>Tình trạng</th>

                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td width="10"><input type="checkbox" name="check1" value="1"></td>
                    <td>MD0837</td>
                    <td>Triệu Thanh Phú</td>
                    <td>Ghế làm việc Zuno, Bàn ăn gỗ Theresa</td>
                    <td>2</td>
                    <td>9.400.000 đ</td>
                    <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa">
                        Giao hàng thành công
                      </button>
                      <button class="btn btn-primary btn-sm edit" type="button" title="Sửa">
                        Giao hàng không thành công
                        </i></button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div> -->
        </main>
        <script
            type="text/javascript"
            src="<c:url value='/resources/js/admin/hoaDon.js'/>"
        ></script>
        <script src="${pageContext.request.contextPath}/resources/js/admin/main.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/resources/js/admin/pace.min.js"></script>
        <!--===============================================================================================-->
        <script
            type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/admin/chart.js"
        ></script>
        <!--===============================================================================================-->
        <script src="src/jquery.table2excel.js"></script>

        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script
            type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/admin/jquery.dataTables.min.js"
        ></script>
        <script
            type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/admin/dataTables.bootstrap.min.js"
        ></script>
        <script type="text/javascript">
            $("#sampleTable").DataTable();
        </script>
        <script>
            function deleteRow(r) {
                var i = r.parentNode.parentNode.rowIndex;
                document.getElementById("myTable").deleteRow(i);
            }
            jQuery(function () {
                jQuery(".trash").click(function () {
                    swal({
                        title: "Cảnh báo",

                        text: "Bạn có chắc chắn là muốn xóa đơn hàng này?",
                        buttons: ["Hủy bỏ", "Đồng ý"],
                    }).then((willDelete) => {
                        if (willDelete) {
                            swal("Đã xóa thành công.!", {});
                        }
                    });
                });
            });
            oTable = $("#sampleTable").dataTable();
            $("#all").click(function (e) {
                $("#sampleTable tbody :checkbox").prop(
                    "checked",
                    $(this).is(":checked")
                );
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
                    dd = "0" + dd;
                }
                if (mm < 10) {
                    mm = "0" + mm;
                }
                today = day + ", " + dd + "/" + mm + "/" + yyyy;
                tmp =
                    '<span class="date"> ' +
                    today +
                    " - " +
                    nowTime +
                    "</span>";
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
            var myApp = new (function () {
                this.printTable = function () {
                    var tab = document.getElementById("sampleTable");
                    var win = window.open("", "", "height=700,width=700");
                    win.document.write(tab.outerHTML);
                    win.document.close();
                    win.print();
                };
            })();
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
                $("#ModalUP").modal({ backdrop: false, keyboard: false });
            });
        </script>

        <script>
            const $ = document.querySelector.bind(document);
            const $$ = document.querySelectorAll.bind(document);

            const tabs = $$(".tab-item");
            const panes = $$(".tab-pane");

            tabs.forEach((tab, index) => {
                const pane = panes[index];

                tab.onclick = function () {
                    $(".tab-item.active").classList.remove("active");
                    $(".tab-pane.active").classList.remove("active");

                    this.classList.add("active");
                    pane.classList.add("active");
                };
            });
        </script>
    </body>
</html>
