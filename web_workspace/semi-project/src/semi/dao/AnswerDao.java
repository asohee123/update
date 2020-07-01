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
import semi.vo.Answer;

public class AnswerDao {
	public void insertAnswer(Answer answer) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.insertAnswer"));
		pstmt.setInt(1, answer.getQuestionNo());
		pstmt.setString(2, answer.getAnswerContent());
		pstmt.setString(3, answer.getAnswerTitle());
		
		pstmt.executeUpdate();
		pstmt.close();
		connection.close();
	}
	
	public List<Answer> getAllAnswer(int productNo) throws SQLException {
		List<Answer> answers = new ArrayList<Answer>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.getAllAnswer"));
		pstmt.setInt(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Answer answer = new Answer();
			answer.setQuestionNo(rs.getInt("question_no"));
			answer.setAnswerNo(rs.getInt("answer_no"));
			answer.setAnswerTitle(rs.getString("answer_title"));
			answer.setAnswerContent(rs.getString("answer_content"));
			
			answers.add(answer);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return answers;
	}
	
	public void modifyAnswer(Answer answer) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.modifyAnswer"));
		pstmt.setString(1, answer.getAnswerTitle());
		pstmt.setString(2, answer.getAnswerContent());
		pstmt.setInt(3, answer.getQuestionNo());
		pstmt.setInt(4, answer.getAnswerNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void deleteAnswer(Answer answer) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.deleteAnswer"));
		pstmt.setInt(1, answer.getQuestionNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
