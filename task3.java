public class task3 {
    public static void printBoard(char[][] board) {
        int n = board.length;
        System.out.println("Вариант: \n_________________");
        for (int i= 0; i<n; i++){            
             System.out.print("|");
            for(int j=0; j<n; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println("\n----------------");
        }
    }
    public static void logikBoard(int row, int col, boolean[][] logical) {

        int n = logical.length;


        for (int j = 0; j < n; j++) {
          logical[row][j] = false;
        }

        for (int j = 0; j < n; j++) {
          logical[j][col] = false;
        }


        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
          logical[r][c] = false;
          r--;
          c--;
        }


        r = row;
        c = col;
        while (r >= 0 && c < 8) {
          logical[r][c] = false;
          r--;
          c++;
        }

        r = row;
        c = col;
        while (r < 8 && c < 8) {
          logical[r][c] = false;
          r++;
          c++;
        }

        r = row;
        c = col;
        while (r < 8 && c >= 0) {
          logical[r][c] = false;
          r++;
          c--;
        }


      }
      public static char[][] nextArray(char[][] original) {
        char[][] copy = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
          copy[i] = original[i].clone();
          
        }
        return copy;
      }

      public static boolean[][] nextArray(boolean[][] original) {
        boolean[][] copy = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
          copy[i] = original[i].clone();
        }
        return copy;
      }

      public static void arrangeQueens(char[][] board, boolean[][] logicalBoard, int rowNumber) {
        
        if (rowNumber == 8) {
            
            printBoard(board);
                      return;
        }

        int n = board.length;
        
        for (int column = 0; column < n; column++) {
          if (logicalBoard[rowNumber][column]) {
            
            char[][] newBoard = nextArray(board);
            boolean[][] newLogicalBoard = nextArray(logicalBoard);
            newBoard[rowNumber][column] = 'Q';
            newLogicalBoard[rowNumber][column] = false;
            logikBoard(rowNumber, column, newLogicalBoard);
            arrangeQueens(newBoard, newLogicalBoard, rowNumber + 1);      

          }
          
        }
      }

      public static void arrangeQueens() {
        int N = 8;
        char[][] board = new char[8][8];
        boolean[][] logicalBoard = new boolean[8][8];
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            board[i][j] = ' ';
            logicalBoard[i][j] = true;
          }
       
        }
        arrangeQueens(board, logicalBoard, 0);
        
      }

      public static void main(String[] args){
        arrangeQueens();
      }
}

