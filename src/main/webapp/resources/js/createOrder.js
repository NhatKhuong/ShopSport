const tinhThanhPho = document.getElementById("tinhThanhPho");
const quanHuyen = document.getElementById("quanHuyen");
const phuongXa = document.getElementById("phuongXa");
const soDienThoai = document.getElementById("soDienThoai");
const diaChiCuThe = document.getElementById("diaChiCuThe");

(async function loadDataTinh() {
    const optionDefault = `  <option selected disabled>Chọn tỉnh / thành phố</option>`;
    const url = "/dia-chi/danh-sach-tinh-thanh-pho";
    const data = await fetchGetData(url);
    addDataInSelect(data, optionDefault, tinhThanhPho);
})();
async function loadDataQuanHuyen() {
    phuongXa.setAttribute("disabled", "disabled");
    quanHuyen.removeAttribute("disabled");
    const param = `?tinhThanhPho=${tinhThanhPho.value}`;
    const optionDefault = `  <option selected disabled>Chọn Quận / Huyện</option>`;
    const url = "/dia-chi/danh-sach-quan-huyen-theo-thanh-pho";
    const data = await fetchGetData(url, param);
    console.table(data);
    addDataInSelect(data, optionDefault, quanHuyen);
}
async function loadDataPhuongXa() {
    phuongXa.removeAttribute("disabled");
    const param = `?tinhThanhPho=${tinhThanhPho.value}&quanHuyen=${quanHuyen.value}`;
    const optionDefault = `  <option selected disabled>Chọn Phường / xã</option>`;
    const url = "/dia-chi/danh-sach-phuong-xa-theo-quan-huyen";
    const data = await fetchGetData(url, param);
    console.table(data);
    addDataInSelect(data, optionDefault, phuongXa);
}

// add event when select tinhthanhPho change
(() => {
    tinhThanhPho.addEventListener("change", (e) => {
        loadDataQuanHuyen();
    });
})();
// add event when select quanHuyen change
(() => {
    quanHuyen.addEventListener("change", (e) => {
        loadDataPhuongXa();
    });
})();

async function fetchGetData(url, params) {
    const respone = await fetch(`${contextPath}${url}${params || ""}`);
    return await respone.json();
}

async function addDataInSelect(data, optionDefault, selectElement) {
    var result = data.map((e) => {
        return ` <option value='${e}'>${e}</option>`;
    });
    selectElement.innerHTML = optionDefault + result;
}
function checkError(check, idHelp) {
    if (check) {
        document.getElementById(idHelp).classList.add("d-none");
        return 0;
    } else {
        document.getElementById(idHelp).classList.remove("d-none");
        return 1;
    }
}

// validation form
$("#form-save-order").on("submit", async (e) => {
    var errorNumber = 0;
    errorNumber += checkError(quanHuyen.selectedIndex != 0, "helpQuanHuyen");
    errorNumber += checkError(
        tinhThanhPho.selectedIndex != 0,
        "helpTinhThanhPho"
    );
    errorNumber += checkError(phuongXa.selectedIndex != 0, "helpPhuongXa");
    errorNumber += checkError(diaChiCuThe.value, "helpDiaChiCuThe");
    errorNumber += checkError(
        new RegExp(
            "^([+]?[s0-9]+)?(d{3}|[(]?[0-9]+[)])?([-]?[s]?[0-9])+$"
        ).test(soDienThoai.value),
        "helpSoDienThoai"
    );

    if (errorNumber == 0) {
        Swal.fire({
            title: "Đặt hàng thành công!",
            text: "Cảm ơn bạn",
            icon: "success",
            confirmButtonText: "Đồng ý",
        });
    } else {
        e.preventDefault();
    }
});

//detete product in card when check out

async function deleteProductInCardWhenCheckout() {
    var elementlistMaSanPhamThanhToan =
        document.getElementsByClassName("maSanPhamThanhToan");
    var listMaSanPhamThanhToan = [];
    for (var i = 0; i < elementlistMaSanPhamThanhToan.length; i++) {
        console.log(elementlistMaSanPhamThanhToan[i]);
        listMaSanPhamThanhToan.push(elementlistMaSanPhamThanhToan[i].innerText);
    }
    console.log(listMaSanPhamThanhToan);
    var a = await fetch(
        contextPath +
            `/don-hang/xoa-san-pham-gio-hang?` +
            new URLSearchParams({
                listMaSanPhamThanhToan: listMaSanPhamThanhToan,
            })
    );
}

function notifySuccess(){
	Swal.fire({
			title: "Cập nhật thành công!",
			text: "Cảm ơn bạn",
			icon: "success",
			confirmButtonText: "Đồng ý",
		});
}
