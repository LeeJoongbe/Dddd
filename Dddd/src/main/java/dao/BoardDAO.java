package dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.BoardVO;

public class BoardDAO {

	private static SqlSessionFactory sessionFactory;
	
	public static SqlSessionFactory getinstance() {
		
		if (sessionFactory == null) {
			try {
				
				String resource = "config/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				
				reader.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
	}
	
	public static List<BoardVO> selectAllBoardList(){
		if (sessionFactory == null) {
			sessionFactory = getinstance();
		}
		
		
		SqlSession session = sessionFactory.openSession();
		List<BoardVO> boardList = null;
		boardList = session.selectList("a.selectAll");
		
		
		return boardList;
	}
	
	public BoardVO selectOne(int num){
		if (sessionFactory == null) {
			sessionFactory = getinstance();
		}
		SqlSession session = sessionFactory.openSession();
		BoardVO board = session.selectOne("a.selectOne", num);

		return board;
	}
	
	public int regist(BoardVO boardVO) {
		if (sessionFactory == null) {
			sessionFactory = getinstance();
		}
		System.out.println(boardVO);
		SqlSession session = sessionFactory.openSession();
		int  result = session.insert("a.register", boardVO);

		session.commit();
		return result;
	}
	
	public int update(BoardVO boardVO) {
		if (sessionFactory == null) {
			sessionFactory = getinstance();
		}
		System.out.println(boardVO);
		SqlSession session = sessionFactory.openSession();
		int  result = session.insert("a.update", boardVO);

		session.commit();
		return result;
	}
	public int totalelement() {
		if (sessionFactory == null) {
			sessionFactory = getinstance();
		}
		SqlSession session = sessionFactory.openSession();
		int  result = session.selectOne("a.total");

		return result;
	}
	
	public int del(int num) {
		if (sessionFactory == null) {
			sessionFactory = getinstance();
		}
		System.out.println(num);
		SqlSession session = sessionFactory.openSession();
		int  result = session.insert("a.del", num);

		session.commit();
		return result;
	}
	
}
