package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import connect.four.board.*;
import connect.four.player.*;

public class BoardTest {
	@Test 
	public void testConstructor() {
		Board board = new Board(7,6);
		
		assertTrue(board.getWidth() == 7);
		assertTrue(board.getHeight() == 6);
	}
	
	@Test
	public void testWhoPlayed() {
		Board board = new Board(6,7);
		
		Player player1 = new ConsolePlayer("P1");
		Player player2 = new ConsolePlayer("p2");
		
		board.play(1, player1);
		board.play(1, player2);
		board.play(1, player1);
		board.play(1, player2);
		board.play(2, player1);
		board.play(5, player2);
		
		assertTrue(board.whoPlayed(1, 0).getName().equals("P1"));
		assertTrue(board.whoPlayed(1, 1).getName().equals("p2"));
		assertTrue(board.whoPlayed(1, 2).getName().equals("P1"));
		assertTrue(board.whoPlayed(1, 3).getName().equals("p2"));
		assertTrue(board.whoPlayed(2, 0).getName().equals("P1"));
		assertTrue(board.whoPlayed(5, 0).getName().equals("p2"));
	}
	
	@Test 
	public void testCopy() {
		Board board = new Board(8,9);
		Board newBoard = new Board(board);
		
		assertTrue(board.getWidth() == newBoard.getWidth());
		assertTrue(board.getHeight() == newBoard.getHeight());
	}
	
	@Test 
	public void testGetWidth() {
		Board board = new Board(6,7);
		assertTrue(board.getWidth() == 6);
		
		board = new Board(0,2);
		assertTrue(board.getWidth() == 0);
	}

	@Test
	public void testGetHeight() {
		Board board = new Board(6,7);
		assertTrue(board.getHeight() == 7);
		
		board = new Board(6,0);
		assertTrue(board.getHeight() == 0);
	}
	
	@Test
	public void testGetColumnHeight() {
		Board board = new Board(6,7);
		
		Player player = new ConsolePlayer("Player");
		board.play(1, player);
		board.play(2, player);
		board.play(4, player);
		board.play(1, player);
		
		assertTrue(board.getColumnHeight(1) == 2);
		assertTrue(board.getColumnHeight(2) == 1);
		assertTrue(board.getColumnHeight(4) == 1);
	}
	
	@Test
	public void testClear() {
		Board board = new Board(6,7);
		Player player1 = new ConsolePlayer("P1");
		Player player2 = new ConsolePlayer("p2");
		
		board.play(3, player1);
		board.clear();
		board.play(3, player2);
		
		assertTrue(board.whoPlayed(3, 0).getName().equals("p2"));
	}
	
	@Test
	public void testGetMoveCount() {
		Board board = new Board(6,8);
		Player player = new ConsolePlayer("Player");
		
		assertTrue(board.getMoveCount() == 0);
		
		board.play(2, player);
		board.play(2, player);
		board.play(2, player);
		board.play(5, player);
		
		assertTrue(board.getMoveCount() == 4);
	}
}