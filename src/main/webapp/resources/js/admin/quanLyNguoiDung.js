(() => {
    var checkAll = document.getElementById("all");

    var listInputCheck = document.getElementsByClassName("checkInput");
    checkAll.addEventListener("change", (e) => {
        if (checkAll.checked) {
            for (var item of listInputCheck) {
                item.checked = true;
            }
        } else {
            for (var item of listInputCheck) {
                item.checked = false;
            }
        }
    });
})();

function getDanhSachNguoiDung() {
    var hoTen = "";
    var trangThai = "0";
    //var gioiTinh = "0";
    hoTen += document.getElementById("locTenNguoiDung").value;
    //gioiTinh = document.getElementById('selectLoaiSanPham').value;
    trangThai = document.getElementById("mySelect").value;
    getDanhSachNguoiDungTheoTen(hoTen, trangThai);
}
getDanhSachNguoiDung();
async function getDanhSachNguoiDungTheoTen(hoTen, trangThai) {
    jQuery.ajax({
        type: "GET",
        contentType: "application/json",
        url: contextPath + "/quan-ly/quan-ly-nguoi-dung-loc",
        /* url: contextPath +'/quan-ly/quan-ly-nguoi-dung-load',*/
        data: {
            hoTen,
            trangThai,
        },
        dataType: "json",
        timeout: 100000,
        success: function (data) {
            let perPage = 10;
            let currentPage = 1;
            let start = 0;
            let end = perPage;
            const totalPage = Math.ceil(data.length / perPage);
            const btnNext = document.querySelector(".btn-next");
            const btnPrev = document.querySelector(".btn-prev");
            let trangThai = "";
            let gioiTinh = "";
            function getCurretPage(currentPage) {
                start = (currentPage - 1) * perPage;
                end = currentPage * perPage;
            }

            async function pageNguoiDung() {
                let temp = "";
                const content = data.map(async (v, index) => {
                    trangThai =
                        v.trangThai == "Truy Cập"
                            ? "<td>" + v.trangThai + "</td>"
                            : "<td>" + v.trangThai + "</td>";
                    gioiTinh =
                        v.gioiTinh == "Nữ"
                            ? "<td>" + v.gioiTinh + "</td>"
                            : "<td>" + v.gioiTinh + "</td>";

                    if (index >= start && index < end) {
                        return (
                            "<tr> <td width='10'><input class='checkInput' type='checkbox' name='check1' value='1'></td>" +
                            "  <td class='maNguoiDung'>" +
                            v.maNguoiDung +
                            "</td>" +
                            "  <td>" +
                            v.hoTen +
                            "</td>" +
                            "  <td>" +
                            v.diaChiChiTiet +
                            "</td>" +
                            "<td>" +
                            v.diaChi.phuongXa +
                            ", " +
                            v.diaChi.quanHuyen +
                            ", " +
                            v.diaChi.tinhThanhPho +
                            "</td>" +
                            "<td>" +
                            v.email +
                            "</td>" +
                            gioiTinh +
                            trangThai +
                            "<td><button class='btn btn-primary btn-sm trash' type='button' title='Xóa'><i class='fa fa-refresh fa-spin' aria-hidden='true'></i></button></button></td></tr>"
                        );
                    }
                });
                temp = await Promise.all(content);
                document.getElementById("danhSachNguoiDung").innerHTML =
                    temp.join(" ");
                deleteNguoiDungListener();
            }
            pageNguoiDung();
            renderListPage();

            function renderListPage() {
                let html = "";
                html += `<li class="active"><a>${1}</a></li>`;
                for (let i = 2; i <= totalPage; i++) {
                    html += `<li><a>${i}</a></li>`;
                }
                document.getElementById("number-page").innerHTML = html;
                if (totalPage == 1) {
                    jQuery(".btn-prev").addClass("btn-active");
                    jQuery(".btn-next").addClass("btn-active");
                }
            }

            function clickButtomListener() {
                let currentPage1 = document.querySelectorAll(".number-page li");
                currentPage1.forEach((item, index) => {
                    currentPage1[index].addEventListener("click", () => {
                        let value = index + 1;
                        currentPage = value;
                        jQuery(".number-page li").removeClass("active");
                        currentPage1[index].classList.add("active");
                        if (currentPage > 1 && currentPage < totalPage) {
                            jQuery(".btn-next").removeClass("btn-active");
                            jQuery(".btn-prev").removeClass("btn-active");
                        }
                        if (currentPage === 1) {
                            jQuery(".btn-prev").addClass("btn-active");
                            jQuery(".btn-next").removeClass("btn-active");
                        }
                        if (currentPage === totalPage) {
                            jQuery(".btn-prev").removeClass("btn-active");
                            jQuery(".btn-next").addClass("btn-active");
                        }
                        getCurretPage(currentPage);
                        pageSanPham();
                    });
                });
            }
            clickButtomListener();

            btnNext.addEventListener("click", () => {
                currentPage++;

                if (currentPage > totalPage) {
                    currentPage = totalPage;
                }
                if (currentPage == totalPage) {
                    jQuery(".btn-next").addClass("btn-active");
                }
                jQuery(".btn-prev").removeClass("btn-active");
                jQuery(".number-page li").removeClass("active");
                jQuery(".number-page li:eq(${currentPage-1})").addClass(
                    "active"
                );
                getCurretPage(currentPage);
                pageSanPham();
            });
            btnPrev.addEventListener("click", () => {
                currentPage--;

                if (currentPage <= 1) {
                    currentPage = 1;
                }
                if (currentPage == 1) {
                    jQuery(".btn-prev").addClass("btn-active");
                }
                jQuery(".btn-next").removeClass("btn-active");
                jQuery(".number-page li").removeClass("active");
                jQuery(".number-page li:eq(${currentPage-1})").addClass(
                    "active"
                );
                getCurretPage(currentPage);
                pageSanPham();
            });
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
    });
}

function deleteNguoiDung(maNguoiDung) {
    jQuery.ajax({
        type: "GET",
        contentType: "application/json",
        url: contextPath + "/quan-ly/quan-ly-nguoi-dung-xoa",
        data: {
            maNguoiDung,
        },
        dataType: "json",
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
    console.log(i);
    deleteNguoiDung(
        document.getElementById("tableListNguoiDung").rows[i].cells[1].innerHTML
    );
    document.getElementById("tableListNguoiDung").deleteRow(i);
}

function deleteNguoiDungListener() {
    jQuery(function () {
        jQuery(".trash").click(function () {
            swal({
                title: "Cảnh báo",
                text: "Bạn có chắc chắn là muốn xóa người dùng này?",
                buttons: ["Hủy bỏ", "Đồng ý"],
            }).then((willDelete) => {
                if (willDelete) {
                    deleteRow(this);
                    swal("Đã xóa thành công.!", {});
                }
            });
        });
    });
}
async function chuyenTrangThaiNhieu() {
    var listInputCheck = document.getElementsByClassName("checkInput");
    for (var item of listInputCheck) {
        if (item.checked) {
            var buttonAccept =
                item.parentElement.parentElement.getElementsByClassName(
                    "trash"
                )[0];
            deleteRowMany(buttonAccept);
        }
    }
}
async function deleteRowMany(e) {
    var maNguoiDung =
        e.parentElement.parentElement.getElementsByClassName("maNguoiDung")[0]
            .innerText;

    var a = await fetch(
        contextPath +
            `/quan-ly/quan-ly-nguoi-dung/chuyen-trang-thai?` +
            new URLSearchParams({
                maNguoiDung: maNguoiDung,
            })
    );
    getDanhSachNguoiDung();
}

async function huyTrangThai(e) {
    var maNguoiDung =
        e.parentElement.parentElement.getElementsByClassName("maNguoiDung")[0]
            .innerText;
    var a = await fetch(
        contextPath +
            `/quan-ly/quan-ly-nguoi-dung/huy-trang-thai?` +
            new URLSearchParams({
                maNguoiDung: maNguoiDung,
            })
    );
    getDanhSachNguoiDung();
}

async function huyTrangThaiNhieu() {
    var listInputCheck = document.getElementsByClassName("checkInput");
    for (var item of listInputCheck) {
        if (item.checked) {
            var buttonAccept =
                item.parentElement.parentElement.getElementsByClassName(
                    "trash"
                )[0];
            huyTrangThai(buttonAccept);
        }
    }
}

function tableSearch() {
    let input, fiter, table, tr, td, txtValue;

    input = document.getElementById("locTenNguoiDung");
    fiter = input.value.toUpperCase();
    table = document.getElementById("tableListNguoiDung");
    tr = table.getElementsByTagName("tr");

    for (let i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[2];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(fiter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

/*function fiterClick(){
	let input, fiter,table, tr,td,txtValue;
	
	fiter=input.value;
	table=document.getElementById("tableListNguoiDung");
	tr=table.getElementsByTagName("tr");
	var e=document.getElementById("mySelect");
	var value=e.options[e.selectedIndex].value;
	var colValue;
	if(value=='Truy Cập'){
		colValue=2;
	}
	else if(value=='Bị Chặn'){
		colValue=3;
	}
	for(let i=0; i<tr.length;i++){
		debugger;
		td=tr[i].getElementsByTagName("td")[colValue];
		if(td){
			txtValue=td.textContent||td.innerText;
			if(txtValue.indexOf(fiter)>-1){
				tr[i].style.display="";
			}
			else{
				tr[i].style.display='none';
			}
		}
	}
	
}*/
