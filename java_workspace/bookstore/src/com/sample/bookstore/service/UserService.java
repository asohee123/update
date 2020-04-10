package com.sample.bookstore.service;

import java.util.Arrays;

import com.sample.bookstore.vo.User;


public class UserService {

	private User[] db = new User[100];
	private int position = 0;
	private int userSequence = 10001;
	
	public UserService() {
		
		User u1 = new User(userSequence++, "홍길동", "010-1111-1234", 100, false);
		User u2 = new User(userSequence++, "주몽", "010-1212-6238", 100, false);
		User u3 = new User(userSequence++, "김유신", "010-1313-9384", 100, false);
		User u4 = new User(userSequence++, "백두산", "010-1412-6332", 100, false);
		User u5 = new User(userSequence++, "류관순", "010-1617-1254", 100, false);
		
		db[position++] = u1;
		db[position++] = u2;
		db[position++] = u3;
		db[position++] = u4;
		db[position++] = u5;
		
	}
	//회원등록 기능
	//회원정보를 전달받아서 db배열에 저장한다.
	public void insertUser(User user) {
		user.no = userSequence;
		
		db[position] = user;
		position++;
		userSequence++;
	}
	
	//회원정보 조회 기능
	//회원번호를 전달받아서 db배열에서 회원정보를 찾아 반환한다.
	public User findUserByNo(int no) {
		User result = null;
		
		for(int i = 0; i<position; i++) {
			if(no == db[i].no) {
				result = db[i];
				break;
			}
		}
		
		return result;
	}
	
	// 회원정보 수정 기능
	// 회원정보를 전달받아서 회원번호에 해당하는 회원의 정보를 db에서 검색해서 회원정보를 수정한다.
	public void updateUser(User user) {
	
			User user1 = findUserByNo(user.no);
			
			if(user1 == null) {
				System.out.println("잘못입력했습니다.");
			} else {
				user1.name = user.name;
				user1.no = user.no;
			}
			
		
	}
	
	// 전체 회원정보 조회기능
	// 전체 회원정보를 반환한다.
	public User[] getAllUsers() {
		return Arrays.copyOfRange(db, 0, position);
		
		//User[] result = Arrays.copyOfRange(db, 0, position);
		//return result;
	}
	
	//회원탈퇴 기능
	//회원번호를 전달받아서 db베열에서 회원정보를 찾아 탈퇴처리한다.
	public void disabledUser(int no) {
		
			
	}
}
