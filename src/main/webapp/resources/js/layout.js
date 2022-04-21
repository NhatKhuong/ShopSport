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






