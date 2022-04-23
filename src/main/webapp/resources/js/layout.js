function quantityPluss(e, quantityTotal) {
    var quantityCurrent = e.parentElement.querySelector(".quantity-number");

    if (!quantityTotal) {
        quantityTotal = document.getElementById("soLuongTon").innerText;
        console.log(document.getElementById("soLuongTon").innerText);
    }
    console.log({ quantityTotal });
    if (+quantityCurrent.innerText < +quantityTotal) {
        quantityCurrent.innerText = +quantityCurrent.innerText + 1;
    }
}

function quantityPrivate(e) {
    var quantityCurrent = e.parentElement.querySelector(".quantity-number");

    if (quantityCurrent.innerText > 0) {
        quantityCurrent.innerText = +quantityCurrent.innerText - 1;
    }
}

function formatCurrency(number) {
    console.log(number);
    // if (isNaN(number)) return number;
    return new Intl.NumberFormat("vi-VN", {
        style: "currency",
        currency: "VND",
    }).format(number);
}

function updateCheckItemPrice(e) {
    var price = e.parentElement.parentElement;
    var card_item_info = price.querySelector(".card_item_info");
    var card_item_info_price_item = card_item_info.querySelector(
        ".card_item_info_price_item"
    );
    var card_item_info_total = card_item_info_price_item.querySelector(
        ".card_item_info_total"
    );

    console.log(card_item_info_total);

    var subtotal_price = document.getElementsByClassName("Subtotal_price")[0];
    var subtotal_price_num = +subtotal_price.innerText
        .replace(".", "")
        .replace("₫", "");
    var price_item_num = +card_item_info_total.innerText
        .replace(".", "")
        .replace("₫", "");
    console.log({ subtotal_price_num, price_item_num });

    if (e.checked) {
        subtotal_price_num = subtotal_price_num + price_item_num;
    } else {
        subtotal_price_num = subtotal_price_num - price_item_num;
    }
    subtotal_price.innerText = formatCurrency(subtotal_price_num);
}

(() => {
    document.querySelectorAll(".check_item_input").forEach((e) => {
        e.addEventListener("change", (click) => {
            updateCheckItemPrice(click.target);
        });
    });
})();

(() => {
    document
        .getElementsByClassName("check_all")[0]
        .addEventListener("change", (e) => {
            var a = document.getElementsByClassName("Subtotal_price")[0];
            a.innerText = 0;
            var listCheckItem =
                document.getElementsByClassName("check_item_input");
            if (e.target.checked) {
                for (var item of listCheckItem) {
                    console.log(item);
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
        url: `${contextPath}/gio-hang/san-pham`,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS: ", data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
    });
}

//  price * quantity when chang quantity
(() => {
    document.querySelectorAll(".quantity button").forEach((e) => {
        e.addEventListener("click", (e) => {
            var info = e.target.parentElement.parentElement.parentElement;
            var price = info.querySelector(".card_item_info_price");
            var total = info.querySelector(".card_item_info_total");
            var quantity = info.querySelector(".quantity-number");
            total.innerText = formatCurrency(
                price.innerText.replace(".", "").replace("₫", "") *
                    quantity.innerText
            );
        });
    });
})();
