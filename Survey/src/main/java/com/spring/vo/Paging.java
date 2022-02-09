package com.spring.vo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class Paging {
	public void paging(HttpServletRequest request, String path, 
			List<SurveyVO> BoardList, int totalPage, int cPage, int numPerPage) {
		
		String pageBar = "";
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize) * pageBarSize + 1;
		int pageEnd = pageNo + pageBarSize - 1;

		 if(pageNo==1) {
			 	if(cPage != 1) {
			 		pageBar += "<a href='" + request.getContextPath() + path + (1) + "&numPerPage=" + numPerPage + "'>[FIRST] </a>";
			 	} else {
			 	}	
	        } else {
	        	pageBar += "<a href='" + request.getContextPath() + path + (1) + "&numPerPage=" + numPerPage + "'>[FIRST] </a>";
	        	pageBar += "<a href='" + request.getContextPath() + path + (pageNo-1) + "&numPerPage=" + numPerPage + "'>[PREV] </a>";
	        }
	        while(!(pageNo>pageEnd || pageNo>totalPage)) {
	        	if(cPage==pageNo) {
		        	pageBar += "<span class='cPage'>[" + pageNo + "] </span>";
		        } else {
		        	pageBar += "<a href='" + request.getContextPath() + path + (pageNo) + "&numPerPage=" + numPerPage + "'>[" + pageNo + "]</a>";
		        }
	        	pageNo++;
	        }
	        if(pageNo>totalPage) {
	        }else {
	            pageBar +="<a href='" + request.getContextPath() + path + (pageNo) + "&numPerPage=" + numPerPage + "'> [NEXT] </a>";
	            pageBar +="<a href='" + request.getContextPath() + path + (totalPage) + "&numPerPage=" + numPerPage + "'> [END] &nbsp;</a>";
	        }
	        
	        
	        request.setAttribute("surList", BoardList);
			request.setAttribute("cPage", cPage);
			request.setAttribute("numPerPage", numPerPage);
			request.setAttribute("pageBar", pageBar);
	}
}
