
function registerCheck() {
    var idTxt = document.regForm.userId;
    var passwordTxt = document.regForm.userPass;
    var passConfirmTxt = document.regForm.pass_confirm;
    var passConfirmTxt = document.regForm.pass_confirm;
    var genderTxt = document.regForm.gender;
    var hobbyTxt = document.regForm.hobby;
    var locTxt = document.regForm.loc;

    if (idTxt.value == "") {
        alert("아이디는 빈공란이 존재합니다.");
        return false;
    }
    if (idTxt.value.length > 10 || idTxt.value.length < 5) {
        alert("아이디는 5자 이상 10자이하이어야 합니다");
        idTxt.value = "";
        idTxt.focus();
        return false;
    }
    if (passwordTxt.value == "") {
        alert("패스워드는 빈공란이 존재합니다.");
        return false;
    }
    if (passConfirmTxt.value == "") {
        alert("패스워드확인란은 빈공란이 존재합니다.");
        return false;
    }

    if (passConfirmTxt.value != passwordTxt.value) {
        alert("비밀번호가 일치하지 않습니다.");
        passConfirmTxt.value = "";
        passwordTxt.value = "";
        passwordTxt.focus();
        return false;
    }

    var flag = true;
    for (i = 0; i < genderTxt.length; i++) {
        if (genderTxt[i].checked) {
            flag = false;
            break;
        }
    }
    if (flag) {
        alert("성별을 입력하세요");
        return false;
    }

    var flag1 = true;
    for (i = 0; i < hobbyTxt.length; i++) {
        if (hobbyTxt[i].checked) {
            flag1 = false;
            break;
        }
    }
    if (flag1) {
        alert("취미을 입력하세요");
        return false;
    }
    if (locTxt.value == "") {
        alert("지역을 선택하세요");
        return false;
    }

}