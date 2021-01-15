function loginCheck() {
    if (document.loginFrm.id.value === "") {
        alert("id");
        document.loginFrm.id.focus();
        return false;
    }
    if (document.loginFrm.pwd.value === "") {
        alert("pwd");
        document.loginFrm.pwd.focus();
        return false;
    }
    return true;
};

function go_next() {
    if (document.contractFrm.okon1[0].checked === true) {
    	document.contractFrm.action = "shop.do?command=joinForm";
    	document.contractFrm.submit();
    } else {
    	alert("약관에 동의하셔야 회원가입이 가능합니다.");
    }
};

function idcheck() {
    if (document.joinForm.id.value === "") {
        alert("id");
        document.joinForm.id.focus();
        return;
    } 
    var url = "shop.do?command=idCheckForm&id=" + document.joinForm.id.value;
    var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250";
    window.open(url, "IdCheck", opt);
};

function post_zip() {
    var url = "shop.do?command=findZipNum";
    var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=550, height=300, top=300, left=300";
    window.open(url, "Find zip num", opt);
};

function go_save() {
    if (document.joinForm.id.value === "") {
        alert("id");
        document.joinForm.id.focus();
    } else if (document.joinForm.reid.value === "") {
        alert("id 중복확인을 해주세요");
        document.joinForm.reid.focus();
    } else if (document.joinForm.pwd.value === "") {
        alert("pwd");
        document.joinForm.pwd.focus();
    } else if (document.joinForm.pwd.value !== document.joinForm.pwdCheck.value) {
        alert("pwdCheck");
        document.joinForm.pwd.focus();
    } else if (document.joinForm.name.value === "") {
        alert("name");
        document.joinForm.name.focus();
    } else if (document.joinForm.email.value === "") {
        alert("id 중복확인을 해주세요");
        document.joinForm.email.focus();
    } else {
        document.joinForm.action = "shop.do";
        document.joinForm.submit();
    }
};

function go_update() {
    if (document.joinForm.id.value === "") {
        alert("id");
        document.joinForm.id.focus();
    }
    else if (document.joinForm.pwd.value !== document.joinForm.pwdCheck.value) {
        alert("pwd");
        document.joinForm.pwd.focus();
    }
    else if (document.joinForm.pwdCheck.value === "") {
        alert("pwdCheck");
        document.joinForm.pwdCheck.focus();
    }
    else if (document.joinForm.name.value === "") {
        alert("name");
        document.joinForm.name.focus();
    }
    else if (document.joinForm.email.value === "") {
        alert("email");
        document.joinForm.email.focus();
    } else {
        document.joinForm.action = "shop.do";
        document.joinForm.submit();
    }
}

function move_Pw() {
    document.frm.action = "shop.do?command=findPwForm";
    document.frm.submit();
}

function move_Id() {
    document.frm.action = "shop.do?command=findId";
    document.frm.submit();
}

function find_id() {
    var url = "shop.do?command=findIdPwd";
    var op = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=700, ";
    opt += "height=500, top=300, left=300";
    window.open(url, "Find Id/Pw", opt);
}