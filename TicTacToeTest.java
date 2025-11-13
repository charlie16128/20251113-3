import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {

    @Test
    void testOWin() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'O');
        game.set(1, 0, 'O');
        game.set(2, 0, 'O');

        assertEquals("O", game.evaluate());
    }

    @Test
    void testXWinDiagonal() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'X');
        game.set(1, 1, 'X');
        game.set(2, 2, 'X');

        assertEquals("X", game.evaluate());
    }

    @Test
    void testDraw() {
        TicTacToe game = new TicTacToe();
        game.set(0,0,'X');
        game.set(0,1,'O');
        game.set(0,2,'X');
        game.set(1,0,'O');
        game.set(1,1,'X');
        game.set(1,2,'O');
        game.set(2,0,'O');
        game.set(2,1,'X');
        game.set(2,2,'O');

        assertEquals("Draw", game.evaluate());
    }

    @Test
    void testPending() {
        TicTacToe game = new TicTacToe();
        game.set(0,0,'X');

        assertEquals("Pending", game.evaluate());
    }
}
