package ticTacToe;

public class Board {

	private char board[][];
	private int boardSize= 3;
	private char player1,player2;
	private int count;
	private static final char Empty = ' ';
	public static final int PLAYER1WINS = 1;
	public static final int PLAYER2WINS = 2;
	public static final int DRAW = 3;
	public static final int INCOMPLETE = 4;
	public static final int INVALID = 5;
	
	public Board(char player1, char player2)
	{
		board = new char[boardSize][boardSize];
		for( int i = 0;i< boardSize;i++)
		{
			for(int j=0;j< boardSize;j++)
			{
				board[i][j]=Empty;
			}
		}
		this.player1=player1;
		this.player2=player2;
		
	}
	public int move(char symbol,int x , int y)
	{
//		check invalid
		if(x >= boardSize || x < 0 || y >= boardSize || y < 0 || board[x][y] != Empty)
		{	
			return INVALID;
		}
//		make move
		board[x][y] = symbol;
		count++;
//		row
		if(board[x][0] == board[x][1] && board[x][0] == board[x][2] && board[x][1] == board[x][2])
		{
			System.out.println("row");
			return symbol == player1 ? PLAYER1WINS:PLAYER2WINS;
		}
//		col
		if(board[0][y] == board[1][y] && board[0][y] == board[2][y] && board[1][y] == board[2][y])
		{
			System.out.println("col");
			return symbol == player1 ? PLAYER1WINS:PLAYER2WINS;
		}
//		diagonal right
		if(board[0][0]!=Empty && board[0][0] == board[1][1] &&board[0][0] == board[2][2])
		{
			return symbol == player1 ? PLAYER1WINS:PLAYER2WINS;
		}
//		diagonal left;
		if(board[0][2]!=Empty && board[0][2] == board[1][1] &&board[0][0] == board[2][0])
		{
			return symbol == player1 ? PLAYER1WINS:PLAYER2WINS;
		}
		if(count == boardSize * boardSize)
		{
			return DRAW;
		}
		
		return INCOMPLETE;
		
	}
	public void print(){
		for(int i = 0 ;i < boardSize;i++)
		{
			for( int j = 0; j < boardSize ; j++)
			{
				System.out.print("| "+ board[i][j]+ " |");
			}
			System.out.println();System.out.println();
		}
		System.out.println();
		System.out.println("---------------------------------");;
	}
	
}
