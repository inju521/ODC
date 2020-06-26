package user.service.face;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.ClassBooking;

public interface UserMyPageClassService {

	/**
	 * 현재 날짜 가져오기
	 * @return
	 */
	public Date nowday();

	/**
	 * 사용자 예약 리스트  전체 조회
	 * @param userid
	 * @param nowday
	 * @return
	 */
	public ArrayList<Map<String, Object>> userbooking(String userid, Date nowday);

	/**
	 * 삭제할  bookingno 파람에서 뽑기
	 * @param req
	 * @return
	 */
	public int bookingnoparam(HttpServletRequest req);

	/**
	 * 사용자 예약 리스트  선택 삭제
	 * @param userid
	 * @param bookingno
	 * @return
	 */
	public int bookingcancel(int bookingno);

	/**
	 * 사용자 아이디별 장바구니 전체 조회
	 * @param userid
	 * @return
	 */
	public ArrayList<Map<String, Object>> userwish(String userid);

	/**
	 * wishno param 빼오기
	 * @param req
	 * @return
	 */
	public int wishnoparam(HttpServletRequest req);

	/**
	 * wishno 삭제
	 * @param userid
	 * @param wishno
	 */
	public void wishcancel(int wishno);

	/**
	 * 결제 정보 불러오기
	 * @param userid
	 * @param wishno
	 * @return
	 */
	public Map<String, Object> classpayment(String userid, int wishno);
	
	/**
	 * userno 가져오기
	 * @param userid
	 * @return
	 */
	public int userno(String userid);
	
	/**
	 * classbookingno 가져오기
	 * @return
	 */
	public int classbookingno();

	/**
	 * ajax가 보낸 파라미터값 뽑기 - wish에서 payment
	 * @param req
	 * @return
	 */
	public Map<String,Object> paymentparam(HttpServletRequest req);

	/**
	 * classbookingno에 결제된 클래스 insert
	 * @param classbookingno
	 * @param userno
	 * @param paymentparam
	 */
	public void insertclassbooking(int classbookingno, int userno, Map<String, Object> paymentparam);

	

	



}