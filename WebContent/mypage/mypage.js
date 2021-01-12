function go_cart() {
    if (document.formm.quantity.value === "") {
        alert("수량을 입력하세요.");
        document.formm.quantity.focus();
    } else {
        document.formm.action = "shop.do?command=cartInsert";
        document.formm.submit();
    }
};

function go_order() {
    if (document.formm.quantity.value === "") {
        alert("수량을 입력하세요.");
        document.formm.quantity.focus();
    } else {
        document.formm.action = "shop.do?command=directOrderInsert";
        document.formm.submit();
    }
};

function go_cart_delete() {
    // checkbox든 radio든 동일한 이름의 여러개로 구성된 입력란들은 같은 이름의 개체의 갯수를 저장하는
    // length라는 속성이 있습니다.
    // 웹페이지에서 같은 이름으로 구성된 체크박스의 갯수가 1개라면 체크박스 배열의 length는 undefined가 됩니다.
    // 또한 전달된 체크박스의 갯수가 2개이상이면 length는 그 갯수를 숫자로 저장

    // 아래 코드는 체크박스(name:cseq) 의 갯수가 한개일 때와 두개이상일때를 구분하여 각각체크된 checkbox가
    // 몇개인지 갯수를 세고 value값을 얻는 코드입니다.

    var count = 0; // 체크된 체크박스의 갯수를 카운트하기위한 변수
    
    if (document.formm.cseq.length === undefined) { /* 체크박스의 갯수가 하나라면 */
        if (document.formm.cseq.checked === true) {
            count++;
        }
    } else { /* 체크박스가 두개 이상이라면 */
        for (var i = 0; i < document.formm.cseq.length; i++) {
            if (document.formm.cseq[i].checked === true) {
                count++;
            }
        }
    }

    if (count === 0) {
        alert("삭제할 항목을 선택해주세요.");
    } else {
        document.formm.action = "shop.do?command=cartDelete";
        document.formm.submit();
    }

};

function go_order_insert() {
    document.formm.action = "shop.do?command=orderInsert";
    document.formm.submit();
};