
function registerCheck(){
    var idTxt = document.registerForm.userId;
    var pwTxt = document.registerForm.userPw;
    var pwConfirmTxt = document.registerForm.userPwConfirm;
    var genderTxt = document.registerForm.gender;
    var hobbyTxt = document.registerForm.hobby;
    var locationTxt = document.registerForm.location;

    if(idTxt.value == ""){
        alert("아이디 입력란을 채워주세요");
        return false;
    }
    if(idTxt.value.length > 10 || idTxt.value.length < 5){
        alert("아이디는 5자 이상 10자 이하");
        idTxt = "";
        idTxt.focus();
        return false;
    }

    if(pwTxt.value == ""){
        alert("비밀번호 입력란을 채워주세요");
        pwTxt.focus();
        return false;
    }
    if(pwConfirmTxt == ""){
        alert("비밀번호 확인란을 채워주세요");
        pwConfirmTxt.focus();
        return false;
    }
    if(pwTxt.value != pwConfirmTxt.value){
        alert("동일한 비밀번호를 입력하세요");
        pwTxt = "";
        pwConfirmTxt = "";
        pwTxt.focus();
        return false;
    }

    var isGenderTxt = true;
    for(i=0; i<genderTxt.length; i++){
        
    }
}