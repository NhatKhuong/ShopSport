// Change quantity item
function quantityPluss(e, quantityTotal) {
  var quantityCurrent = e.parentElement.querySelector(".quantity-number");

  if (!quantityTotal) {
    quantityTotal = document.getElementById("soLuongTon").innerText;
  }

  if (+quantityCurrent.innerText < +quantityTotal) {
    quantityCurrent.innerText = +quantityCurrent.innerText + 1;
  }
  updateTotalPrice(e);
  updateTotalPriceWhenChangeQuanityItem();
  updateQutityInDB(quantityCurrent);
}

// upadate total price item when change quantity

function updateTotalPrice(e) {
  var card_item_info = e.parentElement.parentElement;
  var quantitynumber =
    card_item_info.getElementsByClassName("quantity-number")[0];
  var card_item_info_price = card_item_info.getElementsByClassName(
    "card_item_info_price"
  )[0];
  // =========== t sua cho nay ==============p
  if (!card_item_info_price) {
    return;
  }
  // =====================
  var card_item_info_total = card_item_info.getElementsByClassName(
    "card_item_info_total"
  )[0];

  var itemQuatityNum = +quantitynumber.innerText;
  var card_item_info_priceNum = +card_item_info_price.innerText
    .replace(".", "")
    .replace("₫", "");
  card_item_info_total.innerText = formatCurrency(
    itemQuatityNum * card_item_info_priceNum
  );
}

//update quantity when change

function updateQutityInDB(e) {
  var soLuong = e.innerText;
  // console.log(
  //   e.parentElement.parentElement.parentElement.getElementsByClassName(
  //     "maSanPhamTrongGioHang"
  //   )
  // );
  var maSanPham =
    e.parentElement.parentElement.parentElement.getElementsByClassName(
      "maSanPhamTrongGioHang"
    )[0].innerText;
  // console.log(maSanPham);

  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: `${contextPath}/gio-hang/update_quatity`,
    dataType: "json",
    data: {
      maSanPham,
      soLuong,
    },
    timeout: 100000,

    success: function (data) {
      console.log("thanhcong");
    },
    error: function (e) {},
  });
}

// Change quantity item

function quantityPrivate(e) {
  var quantityCurrent = e.parentElement.querySelector(".quantity-number");

  if (quantityCurrent.innerText > 0) {
    quantityCurrent.innerText = +quantityCurrent.innerText - 1;
  }
  updateTotalPrice(e);
  updateTotalPriceWhenChangeQuanityItem();
  updateQutityInDB(quantityCurrent);
}

// format cast

function formatCurrency(number) {
  // if (isNaN(number)) return number;
  return new Intl.NumberFormat("vi-VN", {
    style: "currency",
    currency: "VND",
  }).format(number);
}

// update subtotal price when change in checkbox

function updateCheckItemPrice(e) {
  var price = e.parentElement.parentElement;

  var card_item_info = price.querySelector(".card_item_info");
  var card_item_info_price_item = card_item_info.querySelector(
    ".card_item_info_price_item"
  );
  var card_item_info_total = card_item_info_price_item.querySelector(
    ".card_item_info_total"
  );

  var subtotal_price = document.getElementsByClassName("Subtotal_price")[0];
  var subtotal_price_num = +subtotal_price.innerText
    .replace(".", "")
    .replace("₫", "");
  var price_item_num = +card_item_info_total.innerText
    .replace(".", "")
    .replace("₫", "");

  if (e.checked) {
    subtotal_price_num = subtotal_price_num + price_item_num;
  } else {
    console.log(subtotal_price_num, price_item_num);
    subtotal_price_num = subtotal_price_num - price_item_num;
  }
  subtotal_price.innerText = formatCurrency(subtotal_price_num);
}

const checkItem = (e) => {
  updateCheckItemPrice(e);
};

const updateTotalPriceWhenChangeQuanityItem = () => {
  var a = document.getElementsByClassName("Subtotal_price")[0];
  a.innerText = 0;
  var listCheckItem = document.getElementsByClassName("check_item_input");
  for (var item of listCheckItem) {
    if (item.checked) {
      updateCheckItemPrice(item);
    }
  }
};

(() => {
  document
    .getElementsByClassName("check_all")[0]
    .addEventListener("change", (e) => {
      var a = document.getElementsByClassName("Subtotal_price")[0];
      a.innerText = 0;
      var listCheckItem = document.getElementsByClassName("check_item_input");
      if (e.target.checked) {
        for (var item of listCheckItem) {
          item.checked = true;
          updateCheckItemPrice(item);
        }
      } else {
        for (var item of listCheckItem) {
          item.checked = false;
          // updateCheckItemPrice(e);
        }
      }
    });
})();

async function loadDuLieuGioHang() {
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + `/gio-hang/san-pham`,

    dataType: "json",
    success: function (data) {
      console.log("SUCCESS: ", data);
      loadDataCard(data);
    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
  });
}

// detele card item product

function deleteCardItem(e) {
  var maSanPhamTrongGioHang = e.parentElement.getElementsByClassName(
    "maSanPhamTrongGioHang"
  )[0].innerText;

  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + `/gio-hang/delete`,
    dataType: "json",
    data: {
      maSanPhamTrongGioHang,
    },

    timeout: 100000,
    success: function (data) {
      loadDuLieuGioHang();
    },
    error: function (e) {
      console.log("ERROR: ", e);
      loadDuLieuGioHang();
    },
  });
}

// Load data card product form db to card

function loadDataCard(data) {
  document.getElementsByClassName("Subtotal_price price")[0].innerText = 0;
  var id = document.getElementById("cardProducts");
  id.innerHTML = data
    .map((e) => {
      return ` <div class="card_product">
        
            <div class="maSanPham" hidden>${
              e.chiTietSanPham.sanPham.maSanPham
            }</div> 
            <div class="maSanPhamTrongGioHang" hidden>${
              e.maSanPhamTrongGioHang
            }</div>
        <div class="check_item">
            <input type="checkbox" class="check_item_input" onchange="checkItem(this)">
        </div>
        <div class="card_item_img">
            <img
                src='${contextPath}/resources/images/${
        e.chiTietSanPham.sanPham.danhSachHinhAnhSanPham[0].hinhAnh
      }'>
        </div>
        <div class="card_item_info">
            <div class="card_item_info_name break_text">
                ${e.chiTietSanPham.sanPham.tenSanPham}</div>
            <small> Kích thước <small class='tenKichThuoc'> M </small> </small>
            <!-- <div class="card_item_info_quatity">1</div> -->
            <div class="quantity">

                <button class="btn ml-2 " onclick='quantityPrivate(this)'> <i
                        class="fa fa-minus" aria-hidden="true"></i></button>
                <span class="item_quantity quantity-number">${e.soLuong}</span>
                <button class="btn mr-2 "
                    onclick='quantityPluss(this,${
                      e.chiTietSanPham.soLuongTon
                    })'> <i
                        class="fa fa-plus" aria-hidden="true"></i></button>

            </div>
            <div class="card_item_info_price_item">
                <div class="card_item_info_price price" onchange = "updateTotalPriceWhenChangeQuanityItem()">
                    ${formatCurrency(
                      e.chiTietSanPham.sanPham.giaTien -
                        (e.chiTietSanPham.sanPham.giaTien *
                          e.chiTietSanPham.sanPham.chietKhau) /
                          100
                    )}
                </div>
                <div class="card_item_info_total price">
                    ${formatCurrency(
                      e.soLuong *
                        (e.chiTietSanPham.sanPham.giaTien -
                          (e.chiTietSanPham.sanPham.giaTien *
                            e.chiTietSanPham.sanPham.chietKhau) /
                            100)
                    )}</div>
            </div>
        </div>
        <button type="button" class="close delete_item" onclick="deleteCardItem(this)">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
`;
    })
    .join(" ");
}

//  price * quantity when chang quantity
(() => {
  document.querySelectorAll(".quantity button").forEach((e) => {
    e.addEventListener("click", (e) => {
      var info = e.target.parentElement.parentElement.parentElement;
      var price = info.querySelector(".card_item_info_price");
      var total = info.querySelector(".card_item_info_total");
      // =========== t sua cho nay ==============
      if (!total) {
        return;
      }
      var quantity = info.querySelector(".quantity-number");
      total.innerText = formatCurrency(
        price.innerText.replace(".", "").replace("₫", "") * quantity.innerText
      );
    });
  });
})();

(() => {
  var formCard = document.getElementById("form-card");
  var valueForm = document.getElementById("value-form-hidden");
  var parent;

  formCard.addEventListener("submit", (e) => {
    var productsCheck = document.querySelectorAll(
      ".card_product input:checked"
    );
    var soLuong,
      tenKichThuoc,
      maSanPham,
      i = 0;
    if (!productsCheck.length) {
      alert("Bạn chưa chọn sản phẩm");
      e.preventDefault();
    }
    valueForm.innerHTML = Array.from(productsCheck)
      .map((e) => {
        parent = e.parentElement.parentElement;

        soLuong = parent.querySelector(".quantity-number").innerText;
        tenKichThuoc = parent.querySelector(".tenKichThuoc").innerText;
        maSanPham = parent.querySelector(".maSanPham").innerText;
        return `

      <input id="hidden-maSanPham"
      name="danhSachChiTietDonHang[${i}].chiTietSanPham.sanPham.maSanPham"
      value="${maSanPham}" readonly="true" />

      <input id="hidden-tenKichThuoc" 
      name="danhSachChiTietDonHang[${i}].chiTietSanPham.kichThuoc.tenKichThuoc"
      value="${tenKichThuoc}"
      readonly="true" />

     <input id="hidden-soLuong" name="danhSachChiTietDonHang[${i++}].soLuongMua"
     value="${soLuong}"
      readonly="true" />
        `;
      })
      .join(" ");
  });
})();
