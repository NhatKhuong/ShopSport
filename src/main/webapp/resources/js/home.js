$(document).ready(function () {
  $(".categories__nav__item__level1").click(function () {
    const id = this.id;
    // $(`#${id}_items`).toggle();
    $("#" + id + "_items").toggle();
  });
});
//  Format Currency in all elemeny have class = price
(() => {
  document.querySelectorAll(".price").forEach((e) => {
    e.innerText = formatCurrency(e.innerText);
  });
})();
// Format Currency
function formatCurrency(number) {
  console.log(number);
  // if (isNaN(number)) return number;
  return new Intl.NumberFormat("vi-VN", {
    style: "currency",
    currency: "VND",
  }).format(number);
}
//  part int number in all elemeny have class = percent
(() => {
  document.querySelectorAll(".percent").forEach((e) => {
    e.innerText = parseInt(e.innerText) + "%";
  });
})();

$(document).ready(function () {
  $(".items-product-suggest.owl-carousel").owlCarousel({
    items: 5,
    animateOut: "fadeOut",
    nav: true,
    responsiveClass: true,
    loop: true,
    margin: 10,
    autoplay: true,
    autoplayTimeout: 3000,
    autoplayHoverPause: true,
    responsive: {
      300: {
        items: 3,
        nav: false,
      },

      600: {
        items: 4,
        nav: true,
      },
    },
  });
});

$(document).ready(function () {
  $(".slider.owl-carousel").owlCarousel({
    items: 1,
    animateOut: "fadeOut",
    nav: true,
    responsiveClass: true,
    loop: true,
    margin: 10,
    autoplay: true,
    autoplayTimeout: 3000,
    autoplayHoverPause: true,
  });
});
