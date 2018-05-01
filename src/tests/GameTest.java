package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import connect.four.Game;
import connect.four.board.Board;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;

public class GameTest {
	@Test 
	public void testDetectWinner() {
		Player player1 = new ConsolePlayer("P1");
		Player player2 = new ConsolePlayer("p2");

		Board board = new Board(6,7);
		
		board.play(1, player1);
		board.play(1, player1);
		board.play(3, player2);
		board.play(1, player1);
		board.play(1, player1);
		
		assertTrue(Game.detectWinner(board, 4).equals(player1));
	}
}
