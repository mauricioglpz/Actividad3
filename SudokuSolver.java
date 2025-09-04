package actividad3;

public class SudokuSolver {

    // esta seria la función principal para resolver Sudoku
    public static boolean solveSudoku(int[][] board) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                // Si la celda está vacía
                if (board[fila][col] == 0) {
                    // Probar números del 1 al 9
                    for (int num = 1; num <= 9; num++) {
                        if (esSeguro(board, fila, col, num)) {
                            board[fila][col] = num;

                            // Llamada recursiva
                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[fila][col] = 0;
                        }
                    }
                    return false; // esto es en caso de que no cabe ningún número
                }
            }
        }
        return true; // Sudoku resuelto
    }

    // verifica si un número puede colocarse en la celda
    private static boolean esSeguro(int[][] board, int fila, int col, int num) {
        // Revisar fila
        for (int x = 0; x < 9; x++) {
            if (board[fila][x] == num) return false;
        }
        // Revisar columna
        for (int x = 0; x < 9; x++) {
            if (board[x][col] == num) return false;
        }
        // Revisar subcuadro 3x3
        int startRow = fila - fila % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) return false;
            }
        }
        return true;
    }

    // Imprimir Sudoku
    public static void imprimirSudoku(int[][] board) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[fila][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };

        if (solveSudoku(board)) {
            System.out.println("Sudoku resuelto:");
            imprimirSudoku(board);
        } else {
            System.out.println("No se puede resolver este Sudoku.");
        }
    }
}

