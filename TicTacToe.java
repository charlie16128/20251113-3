public class TicTacToe {
    private char[][] board;
    private int moves;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        moves = 0;
    }

    // 玩家下棋
    public boolean set(int row, int col, char player) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (player != 'O' && player != 'X') {
            return false;
        }
        if (board[row][col] != ' ') {
            return false; // 已經有棋子
        }

        board[row][col] = player;
        moves++;
        return true;
    }

    // 判斷勝負
    public String evaluate() {
        // 判斷橫排與直排
        for (int i = 0; i < 3; i++) {
            // 橫排
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return String.valueOf(board[i][0]);
            }

            // 直排
            if (board[0][i] != ' ' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                return String.valueOf(board[0][i]);
            }
        }

        // 判斷斜線
        if (board[1][1] != ' ') {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return String.valueOf(board[1][1]);
            }
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                return String.valueOf(board[1][1]);
            }
        }

        // 平手
        if (moves == 9) {
            return "Draw";
        }

        return "Pending"; // 尚未結束
    }

    // 提供給測試使用
    public char get(int row, int col) {
        return board[row][col];
    }
}
