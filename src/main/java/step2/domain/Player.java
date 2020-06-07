package step2.domain;

public class Player {

    private String playerName;
    private String gameResult;

    public static final int PLAYER_NAME_LENGTH_LIMIT = 5;

    private Player() {
        // blocks
    }

    public Player(String playerName) {

        if (playerName.length() > PLAYER_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }

        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%7s", playerName));
        stringBuilder.append(" : ");
        stringBuilder.append(String.format("%-7s", gameResult));

        return stringBuilder.toString();

    }

}
