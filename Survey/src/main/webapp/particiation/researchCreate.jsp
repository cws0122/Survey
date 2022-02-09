<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>서울학교급식포털</title>
<link href="../css/base.css" rel="stylesheet" type="text/css" />
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>

<script type="text/javascript" >

	$(function(){
		
		var today = new Date().toISOString().substring(0, 10);
		
		$('#start_date').attr("min" , today);
		$('#end_date').attr("min" , today);
		
		$('#ques_cnt_btn').click(function(){
			var count = $('#ques_cnt').val();
			var newRow = $('.1rows').eq(0);
			if(count > 15 || count < 0){
				alert("문항수는 1~15 사이로 입력해주세요.");
				$('#ques_cnt').focus();
			}else if(count == ''){
				alert("문항수를 입력해주세요.");
				$('#ques_cnt').focus();
			}else{
				for(var i = 1; i <= count; i++){
					var plz = "<tr class='1rows'> " + 
			           " <td colspan='6' class='tl'> " + 	 
			  		 "<div class='research'> " + 
		     		  "<label>" + i + "." + "질문 제목</label> <span id='warn" + i + "' style='color: red;'></span>" +
		      		 "<p> <input type='text' id='question" + i + "' name='question' class='inp'  title='1. 위생불량 납품단절 편함' /></p>" +
		      			  "<ul>" +
			                 "<li>항목1<input type='text' id='answer1_" + i + "' name='answer1' class='inp'  title='매우그렇다' /></li>" +
			                 "<li>항목2<input type='text' id='answer2_" + i + "' name='answer2' class='inp'  title='매우그렇다' /></li>" + 
			                 "<li>항목3<input type='text' id='answer3_" + i + "' name='answer3' class='inp'  title='매우그렇다' /></li>" + 
			                 "<li>항목4<input type='text' id='answer4_" + i + "' name='answer4' class='inp' title='매우그렇다' /></li>" + 
			                 "<li>항목5<input type='text' id='answer5_" + i + "' name='answer5' class='inp'  title='매우그렇다' /></li>" + 
		      		 	 "</ul>" + 
						"</div>" + 
				  		"</td>" + 
				 		"</tr>";
					$('#box tbody').append(plz);
				}
				$('#ques_cnt').prop('readonly', true);
			}
		});
		
		$('#clean').click(function(){
		 		$('.1rows').remove();
		 		$('#ques_cnt').val('');
		 		$('#ques_cnt').prop('readonly', false);
		});
		
	$('#send').click(function(){
		var title = $('#title').val();
		var start_date = $('#start_date').val();
		var end_date = $('#end_date').val();
		var count = $('#ques_cnt').val();
		var chk = 0;
		var chk2 = 0;
		
		for(var i=1; i<=count; i++){	
			if($.trim($('#question'+i).val()) == ''){
				chk += 1;
				$('#warn' + i).text("질문을 입력해주세요. (질문에 빈칸만 삽입은 불가능합니다.)");
				if(chk >= 1){
					alert('질문을 확인하고 다시 시도해주세요.');
				}
			}else{
				$('#warn' + i).text("");
			}	
		} 
		
		for(var i=1; i<=count; i++){
			var chk3 = 0;
			for(var j=1; j <= 5; j++){
				if($.trim($('#answer' + j + '_' + i).val()) == ''){
					chk3 += 1;
					chk2 += 1;
				}
			}
			if(chk3 > 2){
				alert('질문별 항목을 최소 두개는 입력해주세요.');
				console.log(chk3);
			}
		}
		
		if(title == ''){
			alert('제목을 입력하세요.');
		}else if(start_date == '' || end_date == ''){
			alert("시작일 혹은 종료일을 선택해주세요.");
		}else if(count == ''){
			alert("문항 개수를 입력해주세요.");
		}else if(chk >= 1 && chk2 >= 1){
			console.log('둘다만족?');
		}else{
			//$('#surbeyForm').submit();
		}
	});
		
	
	});
	
	function changeDate(obj){
		var start = $('#start_date').val();
		console.log(start);
	}

</script>
</head>
<body>
<div id="wrap"> 
  <!--skip S-->
  <ul id="skipnavi">
    <li><a href="#gnb">주메뉴 바로가기</a></li>
    <li><a href="#contents">메인내용 바로가기</a></li>
    <li><a href="#footer">하단 바로가기</a></li>
  </ul>
  <!--skip E--> 
  
  <!-- header-->
  <div id="header">
    <h1><img src="../images/header/common/logo.gif" alt="서울학교급식포털" /></h1>
    <div class="topmenu">
      <ul>
        <li class="bn"><a href="main.do">HOME</a></li>
        <li><a href="#">SITEMAP</a></li>
        <c:choose>
        	<c:when test="${member == null}">
        	 	 <li class="bn"> <a href="loginForm.do"><img src="images/header/common/btn_login.gif" alt="로그인" /></a></li>
        	</c:when>
        	<c:otherwise>
        		 <li class="bn">${member.username}님 반갑습니다.</li>
        		 <li class="bn"><a href="logout.do"><input type="button" value="로그아웃"></a></li>
        	</c:otherwise>
        </c:choose>
      </ul>
    </div>
    <div id="gnb">
      <h2>주메뉴</h2>
      <ul class="MM">
        <li class="mainMenu first"><a href="#"><img src="../images/header/common/mm_infoOff.gif" id="sel1" alt="서울학교급식소개" /></a>
         <div class="subMenu" id="sub01" style="display:none;">
            <div class="boxSR">
              <ul class="boxSM">
                <li class="left_bg"></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_info01Off.gif" alt="인사말" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_info02Off.gif" alt="학교급식기본방향" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_info03Off.gif" alt="학교급식현황" /></a></li>
                <li class="last subMenu"><a href="#"><img src="../images/header/common/sm_info04Off.gif" alt="학교급식 담당부서" /></a></li>
                <li class="right_bg"></li>
              </ul>
            </div>
          </div>
        </li>
        <li class="mainMenu"><a href="#"><img src="../images/header/common/mm_safetyOff.gif" alt="학교급식위생안전" /></a>
          <div class="subMenu" id="sub02" style="display:none;">
            <div class="boxSR">
              <ul class="boxSM">
                <li class="left_bg"></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_safety01Off.gif" alt="학교급식 위생관리" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_safety02Off.gif" alt="식중독 대처요령" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_safety03Off.gif" alt="안전사고예방" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_safety04Off.gif" alt="안전사고 대처요령" /></a></li>
                <li class="last subMenu"><a href="#"><img src="../images/header/common/sm_safety05Off.gif" alt="위생.안전성 검사결과" /></a></li>
                <li class="right_bg"></li>
              </ul>
            </div>
          </div>
        </li>
        <li class="mainMenu"><a href="#"><img src="../images/header/common/mm_factoryOff.gif" alt="학교급식시설관리" /></a>
          <div class="subMenu" id="sub03" style="display:none;">
            <div class="boxSR">
              <ul class="boxSM">
                 <li class="left_bg"></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_factory01Off.gif" alt="급식환경개선사업" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_factory01Off.gif" alt="급식시설개선사례" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_factory01Off.gif" alt="급식기구관리전환" /></a></li>
                <li class="last subMenu"><a href="#"><img src="../images/header/common/sm_factory01Off.gif" alt="컨설팅신청안내" /></a></li>
                <li class="right_bg"></li>
              </ul>
            </div>
          </div>
        </li>
        <li class="mainMenu"><a href="#"><img src="../images/header/common/mm_foodOff.gif" alt="학교급식식재료" /></a>
          <div class="subMenu" id="sub04" style="display:none;">
            <div class="boxSR">
              <ul class="boxSM">
                 <li class="left_bg"></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_food01Off.gif" alt="식재료 구매·관리" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_food02Off.gif" alt="식재료 시장조사" /></a></li>
                <li class="last subMenu"><a href="#"><img src="../images/header/common/sm_food03Off.gif" alt="부적합 납품 업체" /></a></li>
                <li class="right_bg"></li>
              </ul>
            </div>
          </div>
        </li>
        <li class="mainMenu"><a href="#"><img src="../images/header/common/mm_eduOff.gif" alt="영양,교육" /></a>
          <div class="subMenu" id="sub05" style="display:none;">
            <div class="boxSR">
              <ul class="boxSM">
                <li class="left_bg"></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_edu01Off.gif" alt="영양·식생활교육" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_edu02Off.gif" alt="추천식단" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_edu03Off.gif" alt="추천레시피" /></a></li>
                <li class="last subMenu"><a href="#"><img src="../images/header/common/sm_edu04Off.gif" alt="학교급식특색활동" /></a></li>
                <li class="right_bg"></li>
              </ul>
            </div>
          </div>
        </li>
        <li class="mainMenu"><a href="#"><img src="../images/header/common/mm_partOff.gif" alt="알림마당" /></a>
          <div class="subMenu" id="sub06" style="display:none;">
            <div class="boxSR">
              <ul class="boxSM">
                <li class="left_bg"></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_part01Off.gif" alt="학교급식인력풀" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_part02Off.gif" alt="영양(교)사이야기" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_part03Off.gif" alt="조리(원)사이야기" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_part04Off.gif" alt="자유게시판" /></a></li>
                <li class="last subMenu"><a href="surveyListForm.do"><img src="../images/header/common/sm_part04Off.gif" alt="설문조사" /></a></li>
                <li class="right_bg"></li>
              </ul>
            </div>
          </div>
        </li>
        <li class="mainMenu last"><a href="#"><img src="../images/header/common/mm_noticeOff.gif" alt="정보마당" /></a>
          <div class="subMenu" id="sub07" style="display:none;">
            <div class="boxSR">
              <ul class="boxSM">
                <li class="left_bg"></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_notice01Off.gif" alt="급식소식" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_notice01Off.gif" alt="연수·행사" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_notice01Off.gif" alt="업무자료실" /></a></li>
                <li class="subMenu"><a href="#"><img src="../images/header/common/sm_notice01Off.gif" alt="관련법규" /></a></li>
                <li class="last subMenu"><a href="#"><img src="../images/header/common/sm_notice01Off.gif" alt="FAQ" /></a></li>
                <li class="right_bg"></li>
              </ul>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
  <!-- //header--> 
  
  <!-- container-->
  <div id="container">
    <div id="contents">
      <h2>메인내용</h2>
      <p><img src="../images/sub/info/sub_vimg_01.jpg" alt="건강한 급식 행복한 학교" /></p>
      <ul class="lnb">
        <li><img src="../images/sub/particiation/sub_title_01.gif" alt="알림마당" /></li>
        <li><a href="#"><img src="../images/sub/particiation/sub_stitle_01Off.gif" alt="학교급식인력풀" /></a></li>
        <li><a href="#"><img src="../images/sub/particiation/sub_stitle_02Off.gif" alt="영양(교)사이야기" /></a></li>
        <li><a href="#"><img src="../images/sub/particiation/sub_stitle_03Off.gif" alt="조리(원)사이야기" /></a></li>
        <li><a href="#"><img src="../images/sub/particiation/sub_stitle_04Off.gif" alt="자유게시판" /></a></li>
        <li><a href="surveyListForm.do"><img src="../images/sub/particiation/sub_stitle_05On.gif" alt="설문조사" /></a></li>
      </ul>
      <div class="right_box">
        <h3><img src="../images/sub/particiation/title_04.gif" alt="급식기구관리전환" /></h3>
        <p class="history"><img src="../images/sub/history_home.gif" alt="home" /> 알림마당 <img src="../images/sub/history_arrow.gif" alt="다음" /> <strong>설문조사</strong></p>
        <p class="pt30"></p>
        
       <form id="surbeyForm" action="insertSurvey.do" method="post">
       <input type="hidden" id="writer" name="writer" value="${member.username}">
        <div class="tbl_box">
          <table id="box" width="100%" border="0" cellspacing="0" cellpadding="0" class="tbl_type01" summary="설문조사">
            <caption>
            설문조사
            </caption>
            <colgroup>
            <col width="15%"/>
            <col width="20%"/>
            <col width="15%"/>
            <col width="20%"/>
            <col width="15%"/>
            <col width="%"/>
            </colgroup>
            <tbody>
              <tr>
                <th>제목</th>
                <td colspan="5" class="tl"><input type="text" id="title" name="title" class="inp" /></td>
                </tr>
              <tr>
                <th>시작일</th>
                <td class="tl"><input type="date" id="start_date" name="start_date" class="inp" style="width:100px;" onchange="changeDate(this)"/></td>
                <th>종료일</th>
                <td class="tl"><input type="date" id="end_date" name="end_date" class="inp" style="width:100px;" /></td>
              </tr>
              <tr>
                <th>문항수</th>
                <td colspan="5" class="tl">
                <input type="text" id="ques_cnt" name="qcount" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                <input type="button" id="ques_cnt_btn" value="확인">
                <input type="button" id="clean" value="문항수 초기화">
                </td>
              </tr>
                <!-- 이부분부터 -->
              
              <!-- 이부분까지 추가해야함. -->
            </tbody>
          </table>
          
          <p class="pt40"></p>
          <!-- btn--> 
          <span class="bbs_btn"> 

          <span class="wte_l"><a href="surveyListForm.do" class="wte_r">목록</a></span>
          <span class="per_l"><a id="send" class="pre_r">등록</a></span>
          

          </span> 
          <!-- //btn--> 
          
        </div>
        </form>
      </div>
      
      <p class="bottom_bg"></p>
    </div>
  </div>
  <!-- //container-->
  
  <div id="footer">
    <h2>하단</h2>
    <address>
    110-781) 서울특별시 종로구 송월길 48(신문로 2-77)
    </address>
    <p>COPYRIGHT(C) 2013 <b>SEOUL metropolitan office of education</b> ALL RIGHT RESERVED</p>
    <ul>
      <li class="bn"><a href="#">개인정보보호정책</a></li>
      <li><a href="#">이메일 무단수집거부</a></li>
      <li><a href="#">뷰어프로그램</a></li>
      <li><a href="#">저작권보호</a></li>
      <li><a href="#">서울학교급식 배너다운로드</a></li>
    </ul>
  </div>
</div>
</body>
</html>