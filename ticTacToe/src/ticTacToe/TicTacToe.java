package ticTacToe;
import java.util.*;
public class TicTacToe {
	
	private Player player1,player2;
	private Board board;
	
	public static void main(String args[])
	{
		TicTacToe t = new TicTacToe();
		t.startGame();
	}

	private void startGame() {
		Scanner s = new Scanner(System.in);
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		while(player2.getSymbol() ==player1.getSymbol())
		{
			System.out.println("Symbol already taken ReEnter symbol ");
			player2.setSymbol(s.next().charAt(0));
		}
//		create board
		board = new Board(player1.getSymbol(),player2.getSymbol());
//		play game
		boolean playerTurn = true;
		int status = Board.INCOMPLETE;
		while(status == Board.INCOMPLETE || status == Board.INVALID) {
			if(playerTurn == true)
			{
				System.out.println(player1.getName() + "'s turn ");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status= board.move(player1.getSymbol(),x,y);
				if(status  == Board.INVALID)
				{
					System.out.println("Invalid move!!");
				}else {
					playerTurn = false;
					board.print();
				}
			}else {
				System.out.println(player2.getName() + "'s turn ");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status= board.move(player2.getSymbol(),x,y);
				if(status  == Board.INVALID)
				{
					System.out.println("Invalid move!!");
				}else {
					playerTurn = true;
					board.print();
				}
			}
		}
		if(status == Board.PLAYER1WINS)
		{
			System.out.println(player1.getName() +" "+ "WINS!!!");
		}else if(status == Board.PLAYER2WINS)
		{
			System.out.println(player2.getName() +" "+ "WINS!!!");
		}else {
			System.out.println("Its a DRAW!!!");
		}
		
	}
	private Player takePlayerInput(int num)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter player "+ num + " name: ");
		String name = s.nextLine();
		System.out.println("Enter Player "+ num + " Symbol");
		char symbol = s.next().charAt(0);
		Player p = new Player(name,symbol);
		return p;
	}

}
