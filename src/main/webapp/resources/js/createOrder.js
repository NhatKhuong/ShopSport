const tinhThanhPho = document.getElementById("tinhThanhPho");
const quanHuyen = document.getElementById("quanHuyen");
const phuongXa = document.getElementById("phuongXa");

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

// validation form
$("#form-save-order").on("submit", (e) => {
  var status = true;
  if (quanHuyen.selectedIndex == 0) {
    status = false;
    document.getElementById("helpQuanHuyen").classList.remove("d-none");
  }
  if (tinhThanhPho.selectedIndex == 0) {
    status = false;
    document.getElementById("helpTinhThanhPho").classList.remove("d-none");
  }
  if (quanHuyen.selectedIndex == 0) {
    status = false;
    document.getElementById("helpPhuongXa").classList.remove("d-none");
  }
  alert(status);

  if (!status) e.preventDefault();
});
