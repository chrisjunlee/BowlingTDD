package bowling;

public class BowlingGame {
    private static final int MAX_ROLLS = 20;
    private static final int PINS = 10;
    private int rolls[] = new int[MAX_ROLLS + 1];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < MAX_ROLLS/2; frame++) {
            if (isStrike(frameIndex)) {
                score += PINS + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += PINS + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += frameScore(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    // helpers
    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == PINS;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == PINS;
    }

    private int frameScore(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }
}
