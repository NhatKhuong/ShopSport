
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Danh sách đơn hàng | Quản trị Admin</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Main CSS-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/main.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
  <!-- or -->
  <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

  <!-- Font-icon css-->
  <link rel="stylesheet" type="text/css"
    href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
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
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
      aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-na v">


      <!-- User Menu-->
      <li><a class="app-nav__item" href="/index.html"><i class='bx bx-log-out bx-rotate-180'></i> </a>

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
        <li class="breadcrumb-item active"><a href="#"><b>Danh sách người dùng</b></a></li>
      </ul>
      <div id="clock"></div>
    </div>

    <div class="tabs">
      <button class="tab-item active">
        <i class="tab-icon fas fa-code"></i>
        Tất cả người dùng
      </button>

      <button class="tab-item">
        <i class="tab-icon fas fa-cog"></i>
        Danh sách người dùng bị chặn
      </button>

      <button class="tab-item">
        <i class="tab-icon fas fa-plus-circle"></i>
        Danh sách người dùng muốn chặn
      </button>
    </div>

    <div class="tab-pane active">
      <div class="row">
        <div class="col-md-4">
          <p>Họ và tên:<input type="text" id="datepicker" class="form-control"></p>
          <input type="button" id="btn-dashboard-filter" class="btn btn-primary btn-sm" value="Lọc kết quả">
        </div>
        <div class="col-md-4">
          <p>Giới tính:
            <select class="dashboard-filter form-control">
              <option>-- Chọn --</option>
              <option value="Nam">Nam</option>
              <option value="Nữ">Nữ</option>
            </select>
          </p>
        </div>

        <div class="col-md-4">
          <p>Địa chỉ:<select class="dashboard-filter form-control">
              <option>-- Chọn --</option>
              <option value="TPHCM">TPHCM</option>
              <option value="Hà Nội">Hà Nội</option>
            </select></p>
        </div>

      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <div class="row element-button">
                <div class="col-sm-2">

                  <a class="btn btn-add btn-sm" href="form-add-nguoi-dung.html" title="Thêm"><i class="fas fa-plus"></i>
                    Thêm người dùng</a>
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
                    <th>Mã người dùng</th>
                    <th>Họ và tên</th>
                    <th>Ảnh</th>
                    <th>Giới tính</th>
                    <th>Trạng thái</th>
                    <th>Địa chỉ chi tiết</th>
                    <th>Mật khẩu</th>
                    <th>Đơn hàng thành công</th>
                    <th>Đơn hàng bị hủy</th>
                    <th>Chức năng</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td width="10"><input type="checkbox" name="check1" value="1"></td>
                    <td>71309005</td>
                    <td>Nguyễn Văn A</td>
                    <td><img src="/img-sanpham/theresa.jpg" alt="" width="100px;"></td>
                    <td>Nam</td>
                    <td><span class="badge bg-success">Sa thải</span></td>
                    <td>146 Lý Thường Kiệt</td>
                    <td>23242wr53g3</td>
                    <td>54</td>
                    <td>3</td>
                    <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"
                        onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
                      </button>
                      <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp"
                        data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i></button>

                      <button class="btn btn-danger btn-sm block type=" button" title="Chặn"
                        onclick="myFunction(this)">Chặn
                      </button>


                    </td>

                    </td>
                  </tr>

                  <tr>
                    <td width="10"><input type="checkbox" name="check1" value="1"></td>
                    <td>71309005</td>
                    <td>Trần Văn B</td>
                    <td><img src="/img-sanpham/theresa.jpg" alt="" width="100px;"></td>
                    <td>Nữ</td>
                    <td><span class="badge bg-success">Sa thải</span></td>
                    <td>146 Lý Thường Kiệt</td>
                    <td>23242wr53g3</td>
                    <td>34</td>
                    <td>60</td>
                    <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"
                        onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
                      </button>
                      <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp"
                        data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i></button>
                      <button class="btn btn-danger btn-sm noblock" type="button" title="Chặn"
                        onclick="myFunction(this)">Bỏ chặn
                      </button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>
    <div class="tab-pane">
      <div class="row">
        <div class="col-md-4">
          <p>Họ và tên:<input type="text" id="datepicker" class="form-control"></p>
          <input type="button" id="btn-dashboard-filter" class="btn btn-primary btn-sm" value="Lọc kết quả">
        </div>
        <div class="col-md-4">
          <p>Giới tính:
            <select class="dashboard-filter form-control">
              <option>-- Chọn --</option>
              <option value="Nam">Nam</option>
              <option value="Nữ">Nữ</option>
            </select>
          </p>
        </div>

        <div class="col-md-4">
          <p>Địa chỉ:<select class="dashboard-filter form-control">
              <option>-- Chọn --</option>
              <option value="TPHCM">TPHCM</option>
              <option value="Hà Nội">Hà Nội</option>
            </select></p>
        </div>

      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <div class="row element-button">
                <div class="col-sm-2">
                  <a class="btn btn-delete btn-sm pdf-file" type="button" title="In" onclick="myFunction(this)"><i
                      class="fas fa-file-pdf"></i>Bỏ chặn</a>
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
                    <th>Mã người dùng</th>
                    <th>Họ và tên</th>
                    <th>Ảnh</th>
                    <th>Giới tính</th>
                    <th>Trạng thái</th>
                    <th>Địa chỉ chi tiết</th>
                    <th>Mật khẩu</th>
                    <th>Đơn hàng thành công</th>
                    <th>Đơn hàng bị hủy</th>
                    <th>Chức năng</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td width="10"><input type="checkbox" name="check1" value="1"></td>
                    <td>71309005</td>
                    <td>Trần Văn B</td>
                    <td><img src="/img-sanpham/theresa.jpg" alt="" width="100px;"></td>
                    <td>Nữ</td>
                    <td><span class="badge bg-success">Sa thải</span></td>
                    <td>146 Lý Thường Kiệt</td>
                    <td>23242wr53g3</td>
                    <td>12</td>
                    <td>3</td>
                    <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"
                        onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
                      </button>
                      <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp"
                        data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i></button>
                      <button class="btn btn-danger btn-sm noblock" type="button" title="Chặn"
                        onclick="myFunction(this)">Bỏ chặn
                      </button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="tab-pane">
      <div class="row">
        <div class="col-md-4">
          <p>Họ và tên:<input type="text" id="datepicker" class="form-control"></p>
          <input type="button" id="btn-dashboard-filter" class="btn btn-primary btn-sm" value="Lọc kết quả">
        </div>
        <div class="col-md-4">
          <p>Giới tính:
            <select class="dashboard-filter form-control">
              <option>-- Chọn --</option>
              <option value="Nam">Nam</option>
              <option value="Nữ">Nữ</option>
            </select>
          </p>
        </div>

        <div class="col-md-4">
          <p>Địa chỉ:<select class="dashboard-filter form-control">
              <option>-- Chọn --</option>
              <option value="TPHCM">TPHCM</option>
              <option value="Hà Nội">Hà Nội</option>
            </select></p>
        </div>

      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <div class="row element-button">
                <div class="col-sm-2">
                  <a class="btn btn-delete btn-sm pdf-file" type="button" title="In" onclick="myFunction(this)"><i
                      class="fas fa-file-pdf"></i>Chặn</a>
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
                    <th>Mã người dùng</th>
                    <th>Họ và tên</th>
                    <th>Ảnh</th>
                    <th>Giới tính</th>
                    <th>Trạng thái</th>
                    <th>Địa chỉ chi tiết</th>
                    <th>Mật khẩu</th>
                    <th>Đơn hàng thành công</th>
                    <th>Đơn hàng bị hủy</th>
                    <th>Chức năng</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td width="10"><input type="checkbox" name="check1" value="1"></td>
                    <td>71309005</td>
                    <td>Trần Văn B</td>
                    <td><img src="/img-sanpham/theresa.jpg" alt="" width="100px;"></td>
                    <td>Nữ</td>
                    <td><span class="badge bg-success">Sa thải</span></td>
                    <td>146 Lý Thường Kiệt</td>
                    <td>23242wr53g3</td>
                    <td>2</td>
                    <td>1</td>
                    <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"
                        onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
                      </button>
                      <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp"
                        data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i></button>
                      <button class="btn btn-danger btn-sm noblock" type="button" title="Chặn"
                        onclick="myFunction(this)">chặn
                      </button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>


  </main>

  <!--MODAL-->
  <div class="modal fade" id="ModalUP" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
    data-keyboard="false">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">

        <div class="modal-body">
          <div class="row">
            <div class="form-group  col-md-12">
              <span class="thong-tin-thanh-toan">
                <h5>Chỉnh sửa thông tin người dùng</h5>
              </span>
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md-6">
              <label class="control-label">Mã người dùng </label>
              <input class="form-control" type="number" value="71309005">
            </div>
            <div class="form-group col-md-6">
              <label class="control-label">Họ và tên</label>
              <input class="form-control" type="text" required value="Bàn ăn gỗ Theresa">
            </div>
            <div class="form-group col-md-6 ">
              <label for="exampleSelect1" class="control-label">Giới tính</label>
              <select class="form-control" id="exampleSelect1">
                <option>Nam</option>
                <option>Nữ</option>
              </select>
            </div>
            <div class="form-group col-md-6 ">
              <label for="exampleSelect1" class="control-label">Trạng thái</label>
              <select class="form-control" id="exampleSelect1">
                <option>Đang làm việc</option>
                <option>Sa thải</option>
              </select>
            </div>
            <div class="form-group col-md-6">
              <label class="control-label">Địa chỉ chi tiết</label>
              <input class="form-control" type="text" value="146 Lý Thường Kiệt">
            </div>

            <div class="form-group col-md-6">
              <label class="control-label">Mật khẩu</label>
              <input class="form-control" type="password" value="5.600.000">
            </div>
          </div>
          <BR>
          <a href="#" style="    float: right;
    font-weight: 600;
    color: #ea0000;">Chỉnh sửa sản phẩm nâng cao</a>
          <BR>
          <BR>
          <button class="btn btn-save" type="button">Lưu lại</button>
          <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
          <BR>
        </div>
        <div class="modal-footer">
        </div>
      </div>
    </div>
  </div>
  <!-- Essential javascripts for application to work-->
   <script src="${pageContext.request.contextPath}/resources/js/admin/main.js"></script>
  <!--===============================================================================================-->
    <script src="${pageContext.request.contextPath}/resources/js/admin/pace.min.js"></script>
  <!--===============================================================================================-->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/admin/chart.js"></script>
  <!--===============================================================================================-->
  <!-- The javascript plugin to display page loading on top-->
  <!-- Data table plugin-->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/admin/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/admin/dataTables.bootstrap.min.js"></script>
  
  <!-- Page specific javascripts-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

  <script type="text/javascript">$('#sampleTable').DataTable();</script>
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