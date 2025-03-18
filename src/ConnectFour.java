
public class ConnectFour {

	  public static void main(String[] args) {

	        if (args.length == 0) {
	            System.err.println("Welcome to \"Connect Four \". You can start with your first move now!");
	            return;
	            
	        }
	        
	        char[][] playground = new char[6][7];
	        
	        System.out.println("Your Move: ");
	  		printGrid(playground);
	        
	  }	
//	public int createPlayground() {
//		char[][] playground = new char[6][7];
//		return 1;
//	}
	
	private static void printGrid(char[][] playground) {
		for (char[] row : playground) {
			System.out.println();
			for (int element : row) {
				System.out.print(element + " ");
			}
	
		}	
	}
}
