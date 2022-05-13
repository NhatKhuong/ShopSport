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

loadDanhSachHoaDon("TTDH00001", "", "");

function lickAndLoad(maTrangThai, e) {
    document.getElementById("maKhachHang").value = "";
    document.getElementById("tenKhachHang").value = "";
    activeButton(e);
    loadDanhSachHoaDon(maTrangThai, maKhachHang, tenKhachHang);
}

function filter() {
    var activebtn = document.getElementsByClassName("active_btn")[0].innerText;
    var maKhachHang = document.getElementById("maKhachHang").value;
    var tenKhachHang = document.getElementById("tenKhachHang").value;
    var maTrangThai = "";
    if (activebtn === "Chờ xác nhận") {
        maTrangThai = "TTDH00001";
    } else if (activebtn === "Chờ lấy hàng") {
        maTrangThai = "TTDH00002";
    } else if (activebtn === "Đang giao") {
        maTrangThai = "TTDH00003";
    } else if (activebtn === "Đã giao") {
        maTrangThai = "TTDH00004";
    } else if (activebtn === "Đã hủy") {
        maTrangThai = "TTDH00004";
    }
    console.log(
        "maTrangThai" +
            maTrangThai +
            "maKhachHang" +
            maKhachHang +
            "tenKhachHang" +
            tenKhachHang
    );
    loadDanhSachHoaDon(maTrangThai, maKhachHang, tenKhachHang);
}

function formatCurrency(number) {
    console.log(number);
    // if (isNaN(number)) return number;
    return new Intl.NumberFormat("vi-VN", {
        style: "currency",
        currency: "VND",
    }).format(number);
}

function activeButton(e) {
    clearActiveButton();
    e.classList.add("active_btn");
}

function clearActiveButton() {
    var listBtn = document.querySelectorAll(".btnStatus");
    listBtn.forEach((el) => {
        el.classList.remove("active_btn");
    });
}

function custom(maDonHang) {
    result = "";
    if (maDonHang === "") {
        result = `<td>${e.trangThaiDonHang.tenTrangThaiDonHang}</td>`;
    } else if (maDonHang === "TTDH00001" || maDonHang === "TTDH00002") {
        result = `
        <td><button class="btn btn-primary btn-sm trash accept" type="button" title="Xóa" onclick="chuyenTrangThai(this)">
        Xác nhận
      </button>
      <button class="btn btn-primary btn-sm edit fail" type="button" title="Sửa" onclick="huyTrangThai(this)">
        Hủy đơn hàng
        </i></button>
    </td>
        `;
    } else if (maDonHang === "TTDH00003") {
        result = `
        <td><button class="btn btn-primary btn-sm trash accept" type="button" title="Xóa" onclick="chuyenTrangThai(this)">
        Giao thành công
      </button>
      <button class="btn btn-primary btn-sm edit fail" type="button" title="Sửa" onclick="huyTrangThai(this)">
        Giao thất bại
        </i></button>
    </td>
        `;
    } else if (maDonHang === "TTDH00004") {
        result = `
        <td>
        Giao thành công
    </td>
        `;
    } else if (maDonHang === "TTDH00005") {
        result = `
        <td><div>
        Giao thất bại
      </div>
      <button class="btn btn-primary btn-sm edit accept" type="button" title="Sửa" onclick="chuyenTrangThai(this)">
        Giao lại
        </i></button>
    </td>
        `;
    }
    console.log(result);
    return result;
}

async function getTongTien(maHoaDon) {
    console.log(maHoaDon);
    var a = await fetch(
        contextPath +
            `/admin/hoa-don/tong-tien?` +
            new URLSearchParams({
                maHoaDon: maHoaDon,
            })
    );
    return await a.json();
}

async function chuyenTrangThai(e) {
    var maHoaDon =
        e.parentElement.parentElement.getElementsByClassName("maHoaDon")[0]
            .innerText;
    var a = await fetch(
        contextPath +
            `/admin/hoa-don/chuyen-trang-thai?` +
            new URLSearchParams({
                maHoaDon: maHoaDon,
            })
    );

    var trangThai = await a.json();
    console.log(trangThai.trangThaiCu);
    loadDanhSachHoaDon(trangThai.trangThaiCu, "", "");
}

async function huyTrangThai(e) {
    var maHoaDon =
        e.parentElement.parentElement.getElementsByClassName("maHoaDon")[0]
            .innerText;
    var a = await fetch(
        contextPath +
            `/admin/hoa-don/huy-trang-thai?` +
            new URLSearchParams({
                maHoaDon: maHoaDon,
            })
    );

    var trangThai = await a.json();
    console.log(trangThai.trangThaiCu);
    loadDanhSachHoaDon(trangThai.trangThaiCu, "", "");
}

async function chuyenTrangThaiNhieu() {
    var listInputCheck = document.getElementsByClassName("checkInput");
    for (var item of listInputCheck) {
        if (item.checked) {
            var buttonAccept =
                item.parentElement.parentElement.getElementsByClassName(
                    "accept"
                )[0];
            chuyenTrangThai(buttonAccept);
        }
    }
}

async function huyTrangThaiNhieu() {
    var listInputCheck = document.getElementsByClassName("checkInput");
    for (var item of listInputCheck) {
        if (item.checked) {
            var buttonAccept =
                item.parentElement.parentElement.getElementsByClassName(
                    "fail"
                )[0];
            huyTrangThai(buttonAccept);
        }
    }
}

async function loadDanhSachHoaDon(maTrangThai, maKhachHang, tenKhachHang) {
    // var maKhachHang = document.getElementById("maKhachHang").innerText;
    // var tenKhachHang = document.getElementById("tenKhachHang").innerText;
    document.getElementById("all").checked = false;
    console.log(1);
    var a = await fetch(
        contextPath +
            `/admin/hoa-don/load?` +
            new URLSearchParams({
                maTrangThai: maTrangThai,
                maKhachHang: maKhachHang,
                tenKhachHang: tenKhachHang,
            })
    );
    var result = await a.json();
    console.log(result);

    var tdContainer = document.getElementById("tdContainer");
    // console.log(tdContainer);

    var promise = await Promise.all(
        result.map(async (e) => {
            var tongTien = await getTongTien(e.maDonHang);
            // console.log("tongTien==========================" + tongTien);
            return `
        <tr>
        <td width="10"><input class="checkInput" type="checkbox" name="check1" value="1"></td>
        <td class="maHoaDon">${e.maDonHang}</td>
        <td>${e.nguoiDung.maNguoiDung}</td>
        <td>${e.nguoiDung.hoTen}</td>
        <td>${new Date(e.ngayTao).toGMTString()}</td>
        <td>${formatCurrency(tongTien)}</td>
        ${custom(e.trangThaiDonHang.maTrangThaiDonHang)}
        </tr>
        `;
        })
    );

    tdContainer.innerHTML = promise.join(" ");
    console.log(tdContainer);
}
