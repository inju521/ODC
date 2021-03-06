package user.service.face;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.AskBoard;
import dto.ClassFile;
import dto.ClassInfo;
import dto.Classwish;
import dto.Donation;
import dto.ReviewBoard;
import dto.UserInfo;

public interface UserService {
	public int idCheck(String id);

	public void insertUser(UserInfo user);

	public boolean userLogin(String id, String pw);

	public int selectUserIdByEN(String email, String name);

	public String getIdByEN(String email, String name);

	public int selectUserPwByEN(String email, String name, String id);

	public String getPwByEN(String email, String name, String id);

	public List<Map<String, Object>> getDetailReview(int classno);

	public void insertReview(ReviewBoard board);

	public int getUsernoBy(String id);

	public void insertAskBoard(AskBoard a);

	public List<AskBoard> selectAskByClassno(int classno);

	public int insertWish(Classwish c);

	public List<Map<String, Object>> getAskAndComm(int classno);

	public List<Map<String, Object>> getClassList(int artno);

	public int insertDonation(Donation d);

	public ArrayList<Map<String, Object>> getReviewbyClassno(int classno);

	public List<ClassFile> selectDetailFileByClassno(int classno);
}
