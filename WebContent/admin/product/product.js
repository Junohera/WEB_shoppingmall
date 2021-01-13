function go_save() {
    if (document.frm.kind.value === "") {
        alert("상품분류를 선택하세요");
        document.frm.kind.focus();
    } else if (document.frm.kind.value === "") {
        alert("kind");
        document.frm.kind.focus();
    }
    else if (document.frm.name.value === "") {
        alert("name");
        document.frm.name.focus();
    }
    else if (document.frm.price1.value === "") {
        alert("price1");
        document.frm.price1.focus();
    }
    else if (document.frm.price2.value === "") {
        alert("price2");
        document.frm.price2.focus();
    }
    else if (document.frm.price3.value === "") {
        alert("price3");
        document.frm.price3.focus();
    }
    else if (document.frm.content.value === "") {
        alert("content");
        document.frm.content.focus();
    }
    else if (document.frm.image.value === "") {
        alert("image");
        document.frm.image.focus();
    } else {
        document.frm.action = "shop.do?command=adminProductWrite";
        document.frm.submit();
    }
};

function go_wrt() {
    document.frm.action = "shop.do?command=adminProductWriteForm";
    document.frm.submit();
};

function go_detail(pseq) {
    document.frm.action = "shop.do?command=adminProductDetail&pseq=" + pseq;
    document.frm.submit();
};

function go_mov() {
    document.frm.action = "shop.do?command=adminProductList";
    document.frm.submit();
};