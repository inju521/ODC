package user.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.AskBoardComm;
import util.Paging;

public interface UserBoardService {

	int getUserNoById(String userid);

	Paging getPagingReviewByUserNo(HttpServletRequest req, int userno);

	List<Map<String, Object>> selectReviewByUserNo(Paging paging, int userno);

	Paging getPagingAskByUserNo(HttpServletRequest req, int userno);

	List<Map<String, Object>> selectAskByUserNo(Paging paging, int userno);

	void reviewListDeleteByUserNo(String names, int userno);

	void askListDeleteByUserNo(String names, int userno);

	Map<String, Object> selectAskByAskNo(int askno);

	List<AskBoardComm> selectCommByAskNo(int askno);

	Map<String, Object> selectReviewByReviewNo(int reviewno);

}
