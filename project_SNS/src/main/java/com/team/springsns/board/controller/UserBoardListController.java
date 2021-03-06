package com.team.springsns.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.board.model.Board;
import com.team.springsns.board.model.BoardListView;
import com.team.springsns.board.service.BoardListService;
import com.team.springsns.board.service.BoardReportService;
import com.team.springsns.isgood.model.CountIsGoodDTO;
import com.team.springsns.isgood.sevice.GetIsGoodCountAllService;

@Controller
public class UserBoardListController {

	@Autowired
	private BoardListService service;
	
	@Autowired
	private GetIsGoodCountAllService getIsGoodCountAllService;
	
	@Autowired
	private BoardReportService boardReportService;
	
	@RequestMapping(value="board/boardList", method = RequestMethod.GET)
	public ModelAndView getBoardList(HttpServletRequest request) {
		System.out.println("@@@s");
		String pageNumberStr = request.getParameter("page");
		String userId = request.getParameter("userId");
//		String result = request.getParameter("result");

		List<CountIsGoodDTO> isGoodList = new ArrayList<CountIsGoodDTO>();
		List<Board> reOk = new ArrayList<Board>();
		
		isGoodList = getIsGoodCountAllService.getIsGoodCountAll();
		reOk = boardReportService.reportCom(userId);
		
		
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		BoardListView viewData = service.getBoardList(pageNumber, userId);
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("board/boardList");
		modelAndView.addObject("viewData", viewData);
		/*modelAndView.addObject("result", result);*/
		//modelAndView.addObject("userId", userId);
		modelAndView.addObject("isGoodList", isGoodList);
		modelAndView.addObject("reportOk", reOk);

		return modelAndView;
	}


}
