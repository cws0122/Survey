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
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
google.charts.load("current", {packages:["corechart"]});
		
	  $(document).ready(function(){
		  $('#back').click(function(){
			  window.history.back();
		  });
	  });
      
    </script>
</head>
<body>
<!-- w100% h545px -->
<div class="pop">
  <div class="pop_box">
  	<h1>결과보기</h1>
    <div class="pop_list">
    	<h2>${survey.title } <span class="rearch_end"><c:if test="${survey.state == 'X'}" >투표 진행중</c:if><c:if test="${survey.state == 'O'}" >투표 종료</c:if></span></h2>
    	<c:set var="num" value="1" />
        <c:forEach var="surques" items="${surquesList}">
        <script type="text/javascript">
          		google.charts.setOnLoadCallback(drawChart${num});
	        	function drawChart${num}() {
	                var data = google.visualization.arrayToDataTable([
	                  ['Task', 'Hours per Day'],
	                  ["${surques.answer1}",     ${surques.an1cnt}],
	                  ["${surques.answer2}",      ${surques.an2cnt}],
	                  ["${surques.answer3}",  ${surques.an3cnt}],
	                  ["${surques.answer4}", ${surques.an4cnt}],
	                  ["${surques.answer5}",    ${surques.an5cnt}]
	                ]);
	                var options = {
	                  title: '${surques.question}',
	                  is3D: false,
	                };
	                var chart = new google.visualization.PieChart(document.getElementById('piechart_${num}'));
	                chart.draw(data, options);
	              }
        	</script>
        <input id="answer1_${num}" type="hidden" value="${surques.answer1}">
        <input id="answer2_${num}" type="hidden" value="${surques.answer2}">
        <input id="answer3_${num}" type="hidden" value="${surques.answer3}">
        <input id="answer4_${num}" type="hidden" value="${surques.answer4}">
        <input id="answer5_${num}" type="hidden" value="${surques.answer5}">
        <input id="cnt1_${num}" type="hidden" value="${surques.an1cnt}">
        <input id="cnt2_${num}" type="hidden" value="${surques.an2cnt}">
        <input id="cnt3_${num}" type="hidden" value="${surques.an3cnt}">
        <input id="cnt4_${num}" type="hidden" value="${surques.an4cnt}">
        <input id="cnt5_${num}" type="hidden" value="${surques.an5cnt}">
        	<span>${surques.question}</span>
        	<c:if test="${surques.answer1 != null}" > <p>${surques.answer1} : ${surques.an1cnt}</p> </c:if>
        	<c:if test="${surques.answer2 != null}" > <p>${surques.answer2} : ${surques.an2cnt}</p> </c:if>
        	<c:if test="${surques.answer3 != null}" > <p>${surques.answer3} : ${surques.an3cnt}</p> </c:if>
        	<c:if test="${surques.answer4 != null}" > <p>${surques.answer4} : ${surques.an4cnt}</p> </c:if>
        	<c:if test="${surques.answer5 != null}" > <p>${surques.answer5} : ${surques.an5cnt}</p> </c:if>
	        <div class="rearch_box">
	        	 <div id="piechart_${num}" style="width: 900px; height: 300px; margin: 0 auto;"></div> 
	        	
	        </div>
	    <c:set var="num" value="${num + 1}" />
	    </c:forEach>
        
    </div>
	<p class="pt20"></p>
    <div class="pop_btn">
    	<span class="blue_l"><a id="back" class="blue_r">돌아가기</a></span>
    </div>
  </div>
  
  </div>
</body>
</html>