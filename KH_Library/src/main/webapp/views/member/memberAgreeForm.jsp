<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
		String contextPath = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .outer{
            margin-top: 50px;
            
        }

        .enroll-area{
            border: 1px solid cadetblue;
            width: 800px;
            height: 650px;
            border-radius: 12px;
        }

    </style>
</head>
<body>

<%
	pageContext.setAttribute("scope", "page Scope");
	%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
<div class="outer" align="center">
        <br>
        <h1>회원가입</h1 align="center">


        <div class="enroll-area">
            <br>    
            <fieldset>
              <legend>약관동의</legend>
              <h5 align="left">이용약관 동의(필수) </h5>
              <textarea cols="100" rows="12" disabled>
제1장 총 칙
제 1조 목적
이 약관은 마포구립도서관이 제공하는 모든 서비스의 이용조건 및 절차에 관한 사항과 기타 필요한 사항을 규정함을 목적으로 한다.

제 2조 약관의 효력과 변경
이 약관은 서비스 화면에 게시하거나 기타의 방법으로 이용자에게 공시되며, 이를 동의한 이용자가 서비스에 가입함으로써 효력이 발생한다.
도서관은 운영상 중요 사유가 있을 때 약관을 변경할 수 있으며, 변경된 약관은 전항과 같은 방법으로 효력을 발생한다
제 3조 용어의 정의
이 약관에서 사용하는 용어의 정의는 다음과 같다.

이용자 : 서비스에 접속하여 마포구립도서관이 제공하는 서비스를 받는 회원 및 비회원
준회원 : 서비스에 접속하여 이 약관에 동의하고, 본인확인 절차를 거친 후, ID(아이디)와 PASSWORD(비밀번호)를 발급 받은 자
비회원 : 회원가입을 하지 않고 마포구립도서관 홈페이지에서 제공하는 서비스를 이용하는 자
ID(아이디) : 회원 식별과 회원의 서비스 이용을 위하여 이용자가 선정하고 마포구립도서관 홈페이지에서 승인하는 영문자와 숫자의 조합(하나의 주민등록번호에 하나의 ID만 발급, 이용 가능)
PASSWORD(비밀번호) : 회원의 정보 보호를 위해 이용자 자신이 설정한 문자와 숫자의 조합
이용해지 : 마포구립도서관 홈페이지의 이용을 종료시키는 의사표시
이 약관에서 사용하는 용어의 정의를 제외하고는 관계법령 및 서비스별 안내에서 정하는 바에 의한다.

제 4조 약관 외 준칙
이 약관에 명시되지 않은 사항이 관계 법령에 규정되어 있을 경우에는 그 규정에 의한다.

제 2장 회원 가입과 서비스 이용
제 1조 서비스 이용 계약의 성립
이용 계약은 이용자의 이용 신청에 대한 도서관의 이용 승낙과 이용자의 약관 내용에 대한 동의로 성립된다.
회원에 가입하여 서비스를 이용하고자 하는 희망자는 도서관에서 요청하는 개인 신상정보를 제공해야 한다.
도서관은 다음 각 호에 해당하는 이용계약 신청에 대하여는 이를 승낙하지 아니한다.
가. 다른 사람의 명의를 사용하여 신청하였을 때
나. 본인의 실명으로 신청하지 않았을 때
다. 이용 계약 신청서의 내용을 허위로 기재하였을 때
라. 사회의 안녕과 질서 혹은 미풍양속을 저해할 목적으로 신청하였을 때
회원은 회원정보관리를 통해 언제든지 자신의 정보를 열람하고 수정할 수 있다. 회원은 이용신청 시 기재한 사항이 변경된 경우에는 수정을 하여야 하며, 수정하지 아니하여 발생하는 문제의 책임은 회원에게 있다.
제 2조 서비스 이용 및 제한
서비스 이용은 도서관 업무상 또는 기술상 특별한 지장이 없는 한 연중무휴, 1일 24시간을 원칙으로 한다.
전항의 서비스 이용시간은 시스템 정기점검 등 도서관이 필요한 경우, 회원에게 사전 통지 없이, 제한할 수도 있다.
회원에 가입한 후에도 일부 서비스 이용 시 서비스 제공자의 요구에 따라 특정 회원에게만 서비스를 제공할 수도 있으며, 서비스를 일정범위로 분할하여 각 범위별로 이용가능 시간을 별도로 정할 수 있다. 이 경우 그 내용을 사전에 공지한다.
제 3조 서비스 이용신청의 승낙
이 약관에서 사용하는 용어의 정의는 다음과 같다.

회원이 게시하거나 등록하는 서비스 내의 모든 내용물이 다음 각 호의 경우에 해당된다고 판단되는 경우 사전 통지 없이 삭제할 수 있으며, 이에 대해 본 홈페이지 관리 책임 부서는 어떠한 책임도 지지 않는다.
가. 다른 회원 또는 제3자를 비방하거나 중상모략으로 명예를 손상시키는 내용인 경우
나. 공공질서 및 미풍양속에 위반되는 내용인 경우
다. 범죄적 행위에 결부된다고 인정되는 내용일 경우
라. 제3자의 저작권 등 기타 권리를 침해하는 내용인 경우
마. 서비스 성격에 부합하지 않는 정보의 경우
바. 기타 관계 법령 및 규정 등에 위배되는 경우
서비스에 게시된 내용을 사전 통지된 지 3일 이후 편집, 이동, 삭제할 수 있는 권리를 갖으며, 게시된 내용이 이 약관에 위배되거나 상용 또는 비합법적, 불건전한 내용일 경우 및 해지 회원이 게시한 게시물은 사전 통보 없이 삭제할 수 있다. 게시된 내용이 일정기간 이상 경과되어, 게시물로서의 효력을 상실하여 그 존치 목적이 불분명한 경우 공지사항 발표 후 1주일간의 통지기간을 거쳐 해당 게시물을 삭제할 수 있다.

제 4조 게시물의 저작권
회원이 서비스 내에 게시한 게시물의 저작권은 회원에게 있으며, 본 홈페이지 관리 책임 부서에서는 다른 서비스에서의 게재 등으로 이를 활용할 수 있다.회원의 게시물이 타인의 저작권, 프로그램 저작권 등을 침해함으로써 발생하는 민·형사상의 책임은 전적으로 회원이 부담하여야 한다. 회원은 서비스를 이용하여 얻은 정보를 가공, 판매하는 행위 등 서비스에 게재된 자료를 상업적으로 사용할 수 없다.

제 3장 의무
제 1조 도서관의 의무
마포구립도서관 홈페이지는 서비스 제공과 관련해서 알고 있는 회원의 신상 정보를 본인의 승낙 없이 제3자에게 누설/배포하지 않습니다. 단, 전기통신기본법 등 법률의 규정에 의해 국가기관의 요구가 있는 경우, 범죄에 대한 수사상의 목적이 있거나 또는 기타 관계법령에서 정한 절차에 의한 요청이 있을 경우에는 그러하지 아니합니다.

도서관은 특별한 사정이 없는 한 회원이 신청한 서비스 제공 게시일에 서비스를 이용할 수 있도록 한다.
도서관은 이 약관에서 정한 바에 따라 계속적, 안정적으로 서비스를 제공할 의무가 있다.
도서관은 회원으로부터 소정의 절차에 의해 제기되는 의견에 대해서는 적법한 절차를 거쳐 지원할 수 있다.
도서관은 회원의 정보를 철저히 보안 유지하며, 양질의 서비스를 운영하거나 개선하는 데에만 사용하고, 이외의 다른 목적으로 타 기관 및 개인에게 양도하지 않는다.
제 2조 회원의 의무
ID(아이디)와 PASSWORD(비밀번호)에 관한 모든 관리의 책임은 회원에게 있다.
자신의 ID(아이디)가 부정하게 사용된 경우, 회원은 반드시 도서관에게 그 사실을 통보해야 한다.
회원은 이 약관 및 관계 법령에서 규정한 사항을 준수하여야 한다.
제 3조 개인정보보호정책
이 약관에서 사용하는 용어의 정의는 다음과 같다.
본 홈페이지 관리 책임 부서는 이용 신청 시 회원이 제공하는 정보를 통하여 회원에 관한 정보를 수집하며, 회원의 개인 정보는 본 이용계약의 이행과 본 이용계약상의 서비스제공을 위한 목적으로 이용한다. 서비스 제공과 관련하여 취득한 회원의 정보를 본인의 승낙 없이 제3자에게 누설 또는 배포할 수 없으며 상업적 목적으로 사용할 수 없다. 다만, 다음의 각 호의 경우에는 그러하지 아니한다.

가. 관계 법령에 의하여 수사상의 목적으로 관계기관으로부터 요구가 있는 경우
나. 정보통신윤리위원회의 요청이 있는 경우
다. 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우
제 4장 계약 해지 및 서비스 이용제한
제 1조 계약 해지 및 이용제한
회원이 이용 계약을 해지하고자 하는 때에는 회원 본인이 직접 도서관 해지서비스를 이용하여 서비스 해지 신청을 요청해야 합니다.
이용 해지 여부는 기존의 ID(아이디)와 PASSWORD(비밀번호)로 로그인이 되지 않으면 해지된 것입니다.
도서관은 회원이 다음 사항에 해당하는 행위를 하였을 경우, 사전 통지 없이 이용계약을 해지하거나 또는 서비스 이용을 중지할 수 있습니다.
가. 공공질서 및 미풍양속에 반하는 경우
나. 범죄적 행위에 관련되는 경우
다. 국익 또는 사회적 공익을 저해할 목적으로 서비스 이용을 계획 또는 실행할 경우
라. 타인의 ID(아이디) 및 PASSWORD(비밀번호)를 도용한 경우
마. 타인의 명예를 손상시키거나 불이익을 주는 경우
바. 같은 사용자가 다른 ID(아이디)로 이중 등록을 한 경우
사. 서비스에 해를 가하는 등 건전한 이용을 저해하는 경우
아. 기타 관련 법령이나 도서관이 정한 이용조건에 위배되는 경우
도서관은 긴급하게 이용을 중지해야 할 필요가 있을 경우 그 사유에 대한 통지절차 없이 서비스 이용을 제한할 수 있습니다.
제 2조 회원의 게시물 관리
도서관은 서비스에 회원이 게시하거나 등록한 내용물이 다음 사항에 해당된다고 판단되는 경우에 사전 통지 없이 삭제할 수 있습니다.
(1) 타인을 비방하거나 중상모략으로 개인 및 단체의 명예를 손상시키는 내용인 경우
(2) 공공질서 및 미풍양속에 위반되는 내용인 경우
(3) 범죄적 행위에 부합된다고 인정되는 내용인 경우
(4) 타인의 저작권 등 기타의 권리를 침해하는 내용인 경우
(5) 기타 관계 법령이나 도서관에서 정한 규정에 위배되는 내용인 경우
제 5장 손해배상 등
제 2조 면책조항
천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 관한 책임이 면제된다.
회원의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않는다.
회원이 서비스를 이용하여 기대하는 이익이나 서비스를 통하여 얻은 자료로 인한 손해에 관하여 책임을 지지 않는다.
회원이 서비스에 게재한 정보, 자료, 사실의 신뢰도, 정확성 등의 내용에 관하여는 책임을 지지 않는다.

제 3조 관할법원
서비스를 이용하여 해킹, 음란사이트 링크, 상용S/W 불법배포 등의 행위를 하여서는 아니되며, 이를 위반으로 인해 발생한 영업활동의 결과 및 손실, 관계기관에 의한 법적 조치 등에 관하여는 마포구립도서관 홈페이지는 책임을 지지 않습니다.

제16조(서비스 제공의 중지)
서비스 이용과 관련하여 본 홈페이지 관리 책임 부서와 회원 사이에 분쟁이 발생한 경우, 관리 책임 부서와 회원은 발생한 분쟁을 원만하게 해결하기 위하여 필요한 모든 노력을 기울여야 한다.서비스 이용으로 발생한 분쟁에 대하여 소송이 제기될 경우 마포구립도서관 소재지를 관할하는 법원을 관할법원으로 한다.

(부칙)이 약관은 2012년 4월 10일부터 시행합니다.
                
                
              </textarea><br>
              <input type="radio" name="a" id=""><label for="">동의합니다.</label>
              <input type="radio" name="a" id=""checked><label for="">동의하지 않습니다.</label>    
        
              <br>
            
                <h5 align="left">개인정보 수집 및 이용에 대한 안내(필수) </h5>
                    <table border="1">
                        <thead>
                            <th width="200px">수집·이용 항목</th>
                            <th width="300px">수집·이용 목적</th>
                            <th width="200px">보유기간</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>성명, 생년월일, 아이디, 비밀번호, 주소, 핸드폰</td>
                                <td>홈페이지 서비스 이용,
                                    고지사항 전달,
                                    도서대출·반납,
                                    도서대출·반납관련정보 제공,
                                    도서연체통보,
                                    마마플 체험신청,
                                    프로그램 신청</td>
                                <td rowspan="2" align="center"> 회원탈퇴 시까지(3년마다 재동의) </td>
                            </tr>
                            <tr>
                                <td>최초 회원가입일시,
                                    마지막 접속일시</td>
                                <td>개인정보 동의기간 확인</td>
                            </tr>
                        </tbody>

                    </table>
                
                <input type="radio" name="b" id=""><label for="">동의합니다.</label>
                <input type="radio" name="b" id=""checked><label for="">동의하지 않습니다.</label>    
          
              </fieldset>
             
        </div>
        <br><br>
        <div align="center">
            <button type="button" onclick="enrollForm();">다음</button>
        </div>
        <script>
        	function enrollForm(){
        		
        		location.href="${contextPath}/insert.me";
        		
        	}
        
        
        </script>  

    </div>

</body>
</html>