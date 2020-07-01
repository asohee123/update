package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.dto.QuestionDto;
import semi.util.ConnectionUtil;
import semi.util.QueryUtil;
import semi.vo.Question;

public class QuestionDao {
	public void insertQuestion(Question question) throws SQLException{
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.insertQuestion"));
		pstmt.setInt(1, question.getProductNo());
		pstmt.setString(2, question.getContent());
		pstmt.setString(3, question.getUserId());
		pstmt.setString(4, question.getTitle());
		
		pstmt.executeUpdate();
		pstmt.close();
		connection.close();
	}
	
	public void modifyQuestion(Question question) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.modifyQuestion"));
		pstmt.setString(1, question.getTitle());
		pstmt.setString(2, question.getContent());
		pstmt.setInt(3, question.getProductNo());
		pstmt.setInt(4, question.getNo());
		
		pstmt.executeUpdate();	
		
		pstmt.close();
		connection.close();
	}
	
	public void deleteQuestion(Question question) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.deleteQuestion"));
		pstmt.setInt(1, question.getProductNo());
		pstmt.setInt(2, question.getNo());
		
		pstmt.executeUpdate();	
		
		pstmt.close();
		connection.close();
	}
	
	public List<QuestionDto> getAllQuestion(int productNo, int begin, int end) throws SQLException {
		List<QuestionDto> questions = new ArrayList<QuestionDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.getAllQuestion"));
		pstmt.setInt(1, productNo);
		pstmt.setInt(2, begin);
		pstmt.setInt(3, end);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			QuestionDto qnaDto = new QuestionDto();
			qnaDto.setQuestionNo(rs.getInt("question_no"));
			qnaDto.setQuestionTitle(rs.getString("question_title"));
			qnaDto.setQuestionContent(rs.getString("question_content"));
			qnaDto.setUserName(rs.getString("user_name"));
			
			questions.add(qnaDto);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return questions;
	}
	
	public int getQuestionTotalRows (int productNo) throws SQLException {
		int totalRows = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt;
		pstmt = connection.prepareStatement(QueryUtil.getSQL("question.getQuestionTotalRows"));
		pstmt.setInt(1, productNo);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		totalRows = rs.getInt("cnt");
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return totalRows;
	}
}
