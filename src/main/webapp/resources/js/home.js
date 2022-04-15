$(document).ready(function () {
    $(".categories__nav__item__level1").click(function () {
        const id = this.id;
        // $(`#${id}_items`).toggle();
        $('#'+id+'_items').toggle();
    });
});
