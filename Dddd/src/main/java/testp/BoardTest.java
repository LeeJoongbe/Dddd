package testp;

import java.util.Arrays;
import java.util.List;

import dao.BoardDAO;
import vo.BoardVO;

public class BoardTest {

	public static void main(String[] args) {
		
		BoardDAO boardDAO= new BoardDAO();
		
//		boardDAO.del(1032);
//		
		List<BoardVO> boardVOs  =boardDAO.selectAllBoardList();
		boardVOs.forEach(boardVO -> System.out.println(boardVO));
		
//	    BoardVO boardVO = boardDAO.selectOne(8888);
//	    System.out.println(boardVO);
//		
		BoardVO  boardVO = new BoardVO();
		boardVO.setNum(1033);
		boardVO.setTitle("dddd");
		boardVO.setContent("ddd");
		boardVO.setWriter("홍길동");
		int result =  boardDAO.regist(boardVO);
		System.out.println(result);
//		
//		boardDAO.update(boardVO);
		
		//현재 개시물수의 총합을 구하시오
		
//		System.out.println(boardDAO.totalelement());
		
	}
}
