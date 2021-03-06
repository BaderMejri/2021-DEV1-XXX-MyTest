import java.util.*;

public class TicTacToe {
	
	static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
	static ArrayList<Integer> player2Positions = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		
		
		String P="Player1";
	    
		char [][] gameBoard = {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},{' ','|',' ','|',' '},
				{'-','+','-','+','-'},{' ','|',' ','|',' '}};
		printgameBoard(gameBoard);
		
		while(player2Positions.size()+player1Positions.size() <= 9) {
			
		Scanner scan1 = new Scanner (System.in);
		System.out.println("Player 1, Enter your placement (1-9):");
		int player1Pos = scan1.nextInt();
		while ((player1Positions.contains(player1Pos))||(player2Positions.contains(player1Pos))) {
			System.out.println("Player 1, Positon Taken! Enter a correct Position");
			player1Pos = scan1.nextInt();
		}
		
		
		placePiece(gameBoard,player1Pos,P);
		
		printgameBoard(gameBoard);
		
		String result = checkWinner();
		if (result.length()>0){
			System.out.println(result);
			break;
		}
		
		
		Scanner scan2 = new Scanner (System.in);
		System.out.println("Player 2, Enter your placement (1-9):");
		int player2Pos = scan2.nextInt();
		while ((player1Positions.contains(player2Pos))||(player2Positions.contains(player2Pos))) {
			System.out.println("Player 2, Positon Taken! Enter a correct Position");
			player2Pos = scan2.nextInt();
		}
		placePiece(gameBoard,player2Pos,"Player2");
		
		
		printgameBoard(gameBoard);
		
		result = checkWinner();
		if (result.length()>0){
			System.out.println(result);
			break;
		}
		System.out.println(result);
		
		}
				
	}
	
	public static void printgameBoard(char [][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
			System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void placePiece(char [][] gameBoard, int pos, String user) {
		
		char symbol= ' ';
		
		if (user.equals("Player1")){
			symbol='X';
			player1Positions.add(pos);
			} else if (user.equals("Player2")){
			symbol='O';
			player2Positions.add(pos);
			}
		
switch(pos) {
		
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
			
            }
		
	}

	public static String checkWinner() {
		 
		 String result= "";
		 
	      List topRow = Arrays.asList(1,2,3);
	      List midRow = Arrays.asList(4,5,6);
	      List botRow = Arrays.asList(7,8,9);
	      List leftCol = Arrays.asList(1,4,7);
	      List midCol = Arrays.asList(2,5,8);
	      List rightCol = Arrays.asList(3,6,9);
	      List cross1 = Arrays.asList(1,5,9);
	      List cross2 = Arrays.asList(3,5,7);
	      
	      
	      List<List> winning = new ArrayList<List>();
	      winning.add(topRow);
	      winning.add(midRow);
	      winning.add(botRow);
	      winning.add(leftCol);
	      winning.add(midCol);
	      winning.add(rightCol);
	      winning.add(cross1);
	      winning.add(cross2);
	      
	      
	      for(List l : winning) {
			if (player1Positions.containsAll(l)) {
				result = "Congratulations Player 1 won!";
			}
			else if (player2Positions.containsAll(l)) {
				result = "Congratulations Player 2 won!";
			}
			
			else if (player2Positions.size()+player1Positions.size() == 9) {
				result = "The result of the game is a draw!";
			}
			
	      }
	      
	      return result;
		 
	 }
}
