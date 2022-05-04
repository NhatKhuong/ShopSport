
function getDanhSachNguoiDung() {
  var hoTen = "";
  var trangThai = "0";
 //var gioiTinh = "0";
  hoTen += document.getElementById('locTenNguoiDung').value;
 //gioiTinh = document.getElementById('selectLoaiSanPham').value;
  trangThai = document.getElementById('mySelect').value;
  getDanhSachNguoiDungTheoTen(hoTen, trangThai);
}
getDanhSachNguoiDung();
function getDanhSachNguoiDungTheoTen(hoTen, trangThai) {
	
  jQuery.ajax({
    type: "GET",
    contentType: 'application/json',
    url: contextPath+'/quan-ly/quan-ly-nguoi-dung-loc',
   /* url: contextPath +'/quan-ly/quan-ly-nguoi-dung-load',*/
    data: {
      hoTen,
      trangThai,
     
    },
    dataType: 'json',
    timeout: 100000,
    success: function (data) {
      let perPage = 10;
      let currentPage = 1;
      let start = 0;
      let end = perPage;
      const totalPage = Math.ceil(data.length / perPage);
      const btnNext = document.querySelector('.btn-next');
      const btnPrev = document.querySelector('.btn-prev');
      let trangThai = "";
      let gioiTinh  = "";
      function getCurretPage(currentPage) {
        start = (currentPage - 1) * perPage;
        end = currentPage * perPage;
      }
      
  		 function pageNguoiDung() {
		
        let temp = "";
        const content = data.map((v, index) => {
         trangThai = v.trangThai=="Chặn"?"<td><span class='badge bg-success'>"+ v.trangThai + "</span></td>":"<td><span class='badge bg-warning'>"+ v.trangThai + "</span></td>";
         gioiTinh = v.gioiTinh=="Nữ"?"<td><span class='badge bg-success'>"+ v.gioiTinh + "</span></td>":"<td><span class='badge bg-warning'>"+ v.gioiTinh + "</span></td>";

          if (index >= start && index < end) {
           //let sl = 0;
            /*v.danhSachChiTietSanPham.forEach(function myFunction(element) {
              sl = sl + element.soLuongTon;
            });*/
            
            temp +=   "<tr> <td width='10'><input type='checkbox' name='check1' value='1'></td>" +
              "  <td>" + v.maNguoiDung + "</td>" +
              "  <td>" + v.hoTen + "</td>"
              + "  <td>" +v.diaChiChiTiet + "</td>" +
              "<td>" +v.diaChi.phuongXa+" "+ v.diaChi.quanHuyen+" "+ v.diaChi.tinhThanhPho + "</td>" +
               "<td>" + v.email + "</td>" +gioiTinh +trangThai +
               "<td>" + v.matKhau + "</td>" +
              "<td><button class='btn btn-primary btn-sm trash' type='button' title='Xóa'><i class='fas fa-trash-alt'></i></button></button></td></tr>"
              
              return temp;;
          }
        })
       
        document.getElementById("danhSachNguoiDung").innerHTML = temp;
        deleteNguoiDungListener();
      }
      pageNguoiDung();
      renderListPage();

      function renderListPage() {
		let html = '';
        html += `<li class="active"><a>${1}</a></li>`;
        for (let i = 2; i <= totalPage; i++) {
         html += `<li><a>${i}</a></li>`;
        }
        document.getElementById("number-page").innerHTML = html;
        if(totalPage==1){
          jQuery('.btn-prev').addClass('btn-active');
          jQuery('.btn-next').addClass('btn-active');
        }
      }
     
     function clickButtomListener(){
      let currentPage1 = document.querySelectorAll('.number-page li');
      currentPage1.forEach((item, index)=> {
        currentPage1[index].addEventListener('click', () => {
          let value = index + 1;
          currentPage = value;
          jQuery('.number-page li').removeClass('active');
          currentPage1[index].classList.add('active');
          if(currentPage>1&&currentPage<totalPage){
            jQuery('.btn-next').removeClass('btn-active');
            jQuery('.btn-prev').removeClass('btn-active');
          }
          if(currentPage===1)
          {
            jQuery('.btn-prev').addClass('btn-active');
            jQuery('.btn-next').removeClass('btn-active');
          }
          if(currentPage===totalPage){
            jQuery('.btn-prev').removeClass('btn-active');
            jQuery('.btn-next').addClass('btn-active');
          }
          getCurretPage(currentPage);
          pageSanPham();
        });
    });
    }
    clickButtomListener();
    
    
      btnNext.addEventListener('click', () => {
        currentPage++;

        if (currentPage > totalPage) {
          currentPage = totalPage;
        }
        if(currentPage==totalPage){
          jQuery('.btn-next').addClass('btn-active');
        }
        jQuery('.btn-prev').removeClass('btn-active');
        jQuery('.number-page li').removeClass('active');
        jQuery('.number-page li:eq(${currentPage-1})').addClass('active');
        getCurretPage(currentPage);
        pageSanPham();
      })
      btnPrev.addEventListener('click', () => {
        currentPage--;

        if (currentPage <= 1) {
          currentPage = 1;
        }
        if(currentPage==1){
          jQuery('.btn-prev').addClass('btn-active');
        }
        jQuery('.btn-next').removeClass('btn-active');
        jQuery('.number-page li').removeClass('active');
        jQuery('.number-page li:eq(${currentPage-1})').addClass('active');
        getCurretPage(currentPage);
        pageSanPham();
      })
    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
  });


}

function deleteNguoiDung(maNguoiDung) {
  jQuery.ajax({
    type: "GET",
    contentType: 'application/json',
    url: contextPath+'/quan-ly/quan-ly-nguoi-dung-xoa',
    data: {
      maNguoiDung,
    },
    dataType: 'json',
    timeout: 100000,
    success: function (data) {
      console.log("SUCCESS: ", data);
    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
  });
}
function deleteRow(r) {
var i = r.parentNode.parentNode.rowIndex;
  deleteNguoiDung(document.getElementById("tableListNguoiDung").rows[i].cells[1].innerHTML);
  document.getElementById("tableListNguoiDung").deleteRow(i);
}

function deleteNguoiDungListener() {
  jQuery(function () {
    jQuery(".trash").click(function () {
      swal({
        title: "Cảnh báo",
        text: "Bạn có chắc chắn là muốn xóa người dùng này?",
        buttons: ["Hủy bỏ", "Đồng ý"],
      })
        .then((willDelete) => {
          if (willDelete) {
            deleteRow(this);
            swal("Đã xóa thành công.!", {
            });

          }
        });
    });
  });
 
  
}

