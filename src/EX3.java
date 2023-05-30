import java.util.Random;

public class EX3 {
    private static final int NUM_EXPERIMENTS = 10000; // Количество игр
    private static final int COUNT_SHOTS = 1000; // Количество бросков кубика в одной игре

    private static int player1Win = 0;
    private static int player2Win = 0;
    private static int draws = 0;

    public static void main(String[] args) {
        int[] player1Sequence = {4, 2, 4};
        int[] player2Sequence = {4, 4, 4};

        calculate(player1Sequence, player2Sequence);

        double player1Probability = (double) player1Win / NUM_EXPERIMENTS;
        double player2Probability = (double) player2Win / NUM_EXPERIMENTS;
        double drawProbability = (double) draws / NUM_EXPERIMENTS;

        System.out.printf("Player1 Probability:   %,.8f\n", player1Probability);
        System.out.printf("Player2 Probability:   %,.8f\n", player2Probability);
        System.out.printf("Draw Probability:      %,.8f\n", drawProbability);
    }

    private static void calculate(int[] player1Sequence, int[] player2Sequence) {
        for (int j = 0; j < NUM_EXPERIMENTS; j++) {
            int index1 = -3;
            int index2 = -3;

            int player1Score = 0;
            int player2Score = 0;

            int[] setCubes = new int[COUNT_SHOTS];

            Random random = new Random();
            int n = 0;
            for (; n < 3; n++) {
                setCubes[n] = random.nextInt(6) + 1;
            }

            for (int i = 0; i < COUNT_SHOTS; i++) {
                if (n < COUNT_SHOTS) setCubes[n++] = random.nextInt(6) + 1;

                if (i + 2 >= COUNT_SHOTS) break;

                int[] threeCurrentCubes = new int[3];
                System.arraycopy(setCubes, i, threeCurrentCubes, 0, 3);

                if (isSequenceMatch(player1Sequence, threeCurrentCubes)) {
                    if (i - index1 >= 3) {
                        player1Score++;
                        index1 = i;
                    }
                } else if (isSequenceMatch(player2Sequence, threeCurrentCubes)) {
                    if (i - index2 >= 3) {
                        player2Score++;
                        index2 = i;
                    }
                }
            }

            pickWinner(player1Score, player2Score);
        }
    }

    private static void pickWinner(int score1, int score2) {
        if (score1 > score2) {
            player1Win++;
        } else if (score1 < score2) {
            player2Win++;
        } else {
            draws++;
        }
    }

    private static boolean isSequenceMatch(int[] sequence, int[] rolls) {
        for (int i = 0, j = 0; i < sequence.length; i++, j++) {
            if (sequence[i] != rolls[j]) {
                return false;
            }
        }
        return true;
    }
}
