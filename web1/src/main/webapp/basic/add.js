/**
 * add.html 사용자 입력값 검증
 * num1, num2 숫자인지 확인하기
 * 
 * submit 버튼이기 때문에 무조건 폼 전송됨 ==> 폼 전송 못하게 막기
 * num1, num2 숫자인지 확인
 * 둘중 하나라도 숫자가 아니라면 경고창 띄우기
 * 둘 다 숫자라면 form submit 시키기 
 * 
 * 
 */

const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	//submit막기
	e.preventDefault();
	
	const num1 = document.querySelector("#num1");
	const num2 = document.querySelector("#num2");
	
	if(isNaN(num1.value) || num1.value == "" ) {
		alert("num1 입력값을 확인해 주세요");
		num1.select();
		return;
	} else if (isNaN(num2.value) || num2.value == "" ){
		alert("num2 입력값을 확인해 주세요");
		num2.select();
		return;
	}
	
	form.submit();
});