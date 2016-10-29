package bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    private BowlingGame game;
    private static final int MAX_ROLLS = 20;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    @Test
    public void gutterGameTest() throws Exception {
        rollMany(MAX_ROLLS, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void allOnesTest() throws Exception {
        rollMany(MAX_ROLLS, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void oneSpareTest() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17,0);
        assertEquals(16, game.score());
    }

    @Test
    public void oneStrikeTest() throws Exception {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    public void perfectGameTest() throws Exception {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    // helpers
    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
    }
}