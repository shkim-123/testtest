// 매개변수로 들어온 데이터가 비어있거나 공백으로 구성되어 있으면 
// true 리턴, 아니면 false 리턴하는 함수 선언
// 매개변수: str (문자열이 저장되는 매개변수)
function isEmpty(str) {
	var flag = false;   // true/false 변수로 많이 사용한다.
	if( str.split(" ").join("") == "" ) {
		flag = true;
	} 
	return flag;
	// flag 안의 데이터를 리턴한다
}

// 한글 이름 유효성 체크
// 한글 2자 ~ 20자 입력
// 유효성 체크 통과 시 true, 아니면 false 리턴
function isMem_name(mem_name){
	var regExp = new RegExp(/^[가-힣]{2,20}$/);
	return regExp.test(mem_name);
}


// 아이디 유효성 체크
// 첫글자는 영소문자 입력하고, 이후 영소문자 숫자 _ 만 입력가능. 5자~10자 입력
// 유효성 체크 통과 시 true, 아니면 false 리턴
function isUid(uid) {
	var regExp = new RegExp(/^[a-z][a-z0-9_]{4,9}$/);
	return regExp.test(uid);
}

// 비밀번호 유효성 체크
// 영소문자, 숫자, _ 만 입력, 5 ~ 8자 입력
// 유효성 체크 통과 시 true, 아니면 false 리턴
function isPwd(pwd) {
	var regExp = new RegExp(/^[a-z0-9_]{5,8}$/);
	return regExp.test(pwd);
}

// 이메일 체크 함수 선언
// 매개변수로 들어온 이메일 문자가 이메일 문자 패턴에 맞으면 true 리턴
// 틀리면 false 리턴하기
// 매개변수 : email (검사할 문자열, 즉 이메일 문자열이 저장되는 매개변수)
function isValidEmail(email) {
	var regExp = new RegExp(/^([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/);
	return regExp.test(email);
}

// 문자열의 패턴 체크 함수 선언
// 매개변수로 들어온 RegExp 객체와 검사 문자열을 이용하여
// 검사 문자열의 RegExp 객체가 관리하는 문자 패턴에 맞으면 true 리턴
// 틀리면 false 리턴하기
// 매개변수: regExpObj (RegExp 객체의 메모리 위치 주소값이 저장되는 매개변수)
// 			targetStr (패턴을 검사할 문자열이 저장되는 매개변수)
function isValidPattern(regExpObj, targetStr) {
	console.log("isValidPattern!!")
	// RegExp 객체의 test() 메서드 호출하여 받은 리턴값
	return regExpObj.test(targetStr);
}