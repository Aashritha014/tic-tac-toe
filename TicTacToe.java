import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();


	public static void main(String[] args){
	
		char[][] tttBoard = { 
		{' ' , '|', ' ', '|', ' '},
		{'-' , '+', '-', '+', '-'}, 
		{' ' , '|', ' ', '|', ' '},
		{'-' , '+', '-', '+', '-'},
		{' ' , '|', ' ', '|', ' '}};
        
        
        
        System.out.println("INSTRUCTIONS: ");
        System.out.println("1) User is 'x' ");
        System.out.println("2) Computer is 'o' ");

        printtttBoard(tttBoard);
        
     
				 //LOOPING
        while (true){
         Scanner  scan = new Scanner(System.in);
         System.out.println("Enter your placement[1-9]");
         int playerPos = scan.nextInt();

        while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
			System.out.println("Position taken! Enter a correct position");
			playerPos = scan.nextInt();
		}
       
        
	      placements(tttBoard,playerPos,"player");
		  String result = checkWin();
		  if(result.length()>0){
			   System.out.println(result);
			   break;
		   }
		  
	      Random rand = new Random();
	      int cpuPos = rand.nextInt(9) + 1;
		  while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
			cpuPos = rand.nextInt(9) + 1;
		  }
	      placements(tttBoard,cpuPos,"cpu");
	      
          printtttBoard(tttBoard);
        
           result = checkWin();
		   if(result.length()>0){
			   System.out.println(result);
			   break;
		   }
		  
        
        }
        
    }//MAIN
    
    
//METHOD TO PRINT THE BOARD     
public static void printtttBoard(char[][] tttBoard){
		for (char[] row: tttBoard) {
				for (char c: row){
					System.out.print(c);
				}
				System.out.println();
				
	  }
}
    
//METHOD TO PRINT THE PLACEMENT OF KEYS 
public static void placements(char[][]tttBoard, int pos, String user){
        char symbol = ' ';
        
        if (user.equals("player")){
	        symbol = 'x';
			playerPositions.add(pos);
        }
        else if (user.equals("cpu")){
			      symbol = 'o';
				  cpuPositions.add(pos);  
	        }
        
        switch (pos){
	        case 1:
			        tttBoard[0][0] = symbol;
				        break;
		       case 2:
			        tttBoard[0][2] = symbol;
				        break;
		       case 3:
			        tttBoard[0][4] = symbol;
				        break;
		       case 4:
			        tttBoard[2][0] = symbol;
				        break;
		        case 5:
			        tttBoard[2][2] = symbol;
				        break;
		        case 6:
			        tttBoard[2][4] = symbol;
				        break;
		        case 7:
			        tttBoard[4][0] = symbol;
				        break;
		        case 8:
			        tttBoard[4][2] = symbol;
				        break;
		        case 9:
			        tttBoard[4][4] = symbol;
				        break;
			       default: 
				       break;
        }
			}
			
	//METHOD TO CHECK WINNER 
		public static String checkWin(){
			List topRow = Arrays.asList(1,2,3);
			List midRow = Arrays.asList(4,5,6);
			List botRow = Arrays.asList(7,8,9);
			List leftCol = Arrays.asList(1,4,7);
			List midCol = Arrays.asList(2,5,8);
			List rightCol = Arrays.asList(3,6,9);
			List oneCross = Arrays.asList(1,5,9);
			List twoCross = Arrays.asList(7,5,3);
			
			List<List> winning = new ArrayList<List>();
			winning.add(topRow);
			winning.add(midRow);
			winning.add(botRow);
			winning.add(leftCol);
			winning.add(midCol);
			winning.add(rightCol);
			winning.add(oneCross);
			winning.add(twoCross);
			
			for(List l: winning) {
				if(playerPositions.containsAll(l)){
					return " YOU WIN :) ";
				}
				else if (cpuPositions.containsAll(l)){
					return "YOU LOSE :( ";
				}else if (cpuPositions.size() + playerPositions.size() == 9){
					return "TIE -_- ";
				}
			}
			
			return "";	
		
		}	
			
}//CLASS
