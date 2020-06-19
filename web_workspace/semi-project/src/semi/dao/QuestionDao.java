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
		
		pstmt.executeUpdate();
		pstmt.close();
		connection.close();
	}
	
	public List<QuestionDto> getQuestionsByProdNo(int productNo) throws SQLException {
		List<QuestionDto> questions = new ArrayList<QuestionDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.getQuestionsByProdNo"));
		pstmt.setInt(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			QuestionDto questionDto = new QuestionDto();
			questionDto.setProductNo(rs.getInt("question_no"));
			questionDto.setContent(rs.getString("question_content"));
			questionDto.setUserName(rs.getString("user_name"));
			
			questions.add(questionDto);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return questions;
	}
	
}
