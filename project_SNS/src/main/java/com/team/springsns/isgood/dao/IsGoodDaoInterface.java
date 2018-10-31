package com.team.springsns.isgood.dao;

import com.team.springsns.model.CountIsGoodDTO;
import com.team.springsns.model.IsGoodDTO;

public interface IsGoodDaoInterface {

	public IsGoodDTO selectIsGood(IsGoodDTO isGoodDTO);
	public void insertIsGood(IsGoodDTO isGoodDTO);
	public int deleteIsGood(IsGoodDTO isGoodDTO);
	public CountIsGoodDTO getCountIsGood(int boardNo);
	//public List<Board> getBoardAll();
	public void deleteIsGoodAll(int boardNo);
}