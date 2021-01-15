function go_mov() {
    location.href="shop.do?command=adminProductList";
};

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

function go_mod(pseq) {
    document.frm.action = "shop.do?command=adminProductUpdateForm&pseq=" + pseq;
    document.frm.submit();
};

function go_mod_save() {
    if (document.frm.kind.value === "") {
        alert("상품분류를 선택하세요");
        document.frm.kind.focus();
    } else if (document.frm.name.value === "") {
        alert("상품명을 입력하세요");
        document.frm.name.focus();
    } else if (document.frm.price1.value === "") {
        alert("원가를 입력하세요");
        document.frm.price1.focus();
    } else if (document.frm.price2.value === "") {
        alert("판매가를 입력하세요");
        document.frm.price2.focus();
    } else if (document.frm.content.value === "") {
        alert("상품상세를 입력하세요");
        document.frm.content.focus();
    } else {
        if (confirm("수정하시겠습니까?")) {
            document.frm.action = "shop.do?command=adminProductUpdate";
            document.frm.submit();
        }
    }
};

function go_order_save() {
    var count = 0;

    if (document.frm.result.length === undefined) { /* 체크박스의 갯수가 하나라면 */
        if (document.frm.result.checked === true) {
            count++;
        }
    } else { /* 체크박스가 두개 이상이라면 */
        for (var i = 0; i < document.frm.result.length; i++) {
            if (document.frm.result[i].checked === true) {
                count++;
            }
        }
    }

    if (count === 0) {
        alert("주문할 항목을 선택해주세요")
    } else {
        document.frm.action = "shop.do?command=adminOrderSave";
        document.frm.submit();
    }
};

function go_view(qseq) {
    document.frm.action = "shop.do?command=adminQnaDetail&qseq=" + qseq;
    document.frm.submit();
};

function go_rep() {
    document.frm.action = "shop.do?command=adminQnaAttachAnswer";
    document.frm.submit();
};

function go_list() {
    document.frm.action = "shop.do?command=adminQnaList";
    document.frm.submit();
};