package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import connect.four.board.*;
import connect.four.player.*;

public class ComputerPlayerTest {

	@Test
	public void getNameTest() {
		Player aPlayer = new ComputerPlayer(3);
		assertTrue(aPlayer.getName().equals("Computer"));
	}
	
	@Test
	public void performPlayTest() {
		Board board = new Board(6,7);
		Player player = new ConsolePlayer("Human");
		Player computer = new ComputerPlayer();
		
		board.play(1, player);
		computer.performPlay(board);
		assertTrue(board.getMoveCount() == 2);
		
		board.clear();
		computer.performPlay(board);
		assertTrue(board.getMoveCount() == 1);
		
		player = new ComputerPlayer();
		
		board.clear();
		player.performPlay(board);
		computer.performPlay(board);
		player.performPlay(board);
		assertTrue(board.getMoveCount() == 3);
	}
}
