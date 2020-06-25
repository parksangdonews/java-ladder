package step4.domain;

public final class LadderGame {

    public static final int SINGLE_PLAYER_STATUS = 1;

    private Players players;
    private WinningPrizes winningPrizes;
    private Ladders ladders = new Ladders();

    private LadderGame() {
        // block
    }

    private LadderGame(Players players, WinningPrizes winningPrizes, int laddersHeight) {
        if (laddersHeight < SINGLE_PLAYER_STATUS) {
            throw new IllegalArgumentException();
        }
        if (players.size() != winningPrizes.size()) {
            throw new IllegalArgumentException("Unmatched with player and winningPrize count.");
        }
        
        this.players = players;
        this.winningPrizes = winningPrizes;
        
        // 사다리 세팅
        
        ladders.setLadders(laddersHeight, players);
        
        
        
        
        
    }

    public static LadderGame createLadder(Players players, WinningPrizes winningPrizes, int laddersHeight) {
        return new LadderGame(players, winningPrizes, laddersHeight);
    }

    public MatchingResult calculateWinningPrizeLine() {
        // result
        CalculateLadder calculateLadder = new CalculateLadder(ladders);
        String[] winningPrize = calculateLadder.calculateWinningPrizeLine(winningPrizes);
        return MatchingResult.map(players, winningPrize);
    }

    public Players getPlayers() {
        return players;
    }

    public WinningPrizes getWinningPrizes() {
        return winningPrizes;
    }

    public Ladders getLadders() {
        return ladders;
    }

}
