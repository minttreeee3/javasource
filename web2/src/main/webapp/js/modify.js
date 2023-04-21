/**
 * newaddr, newmobile 둘중에 하나 이상 값이 있어야함
 * 
 * 둘 다 빈칸일때 submit 막고, 메세지 띄우기
 * 
 * 
 */

 const addr = document.querySelector("#newaddr");
 const mobile = document.querySelector("#newmobile");
 
 
 document.querySelector("[type='submit']").addEventListener("click", (e) => {
 	if(addr.value!="" || mobile.value!="") {
		 form.submit();
 	} else {
	 	alert("회원정보를 수정해 주세요");
		e.preventDefault(); 
	}
	
	
	
	 
	 
 })
 
 
 