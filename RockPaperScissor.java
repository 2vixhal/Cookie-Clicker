import java.util.*;

public class RockPaperScissor {
    public int getPlayerScore() {
        return playerScore;
    }
    private int  playerScore;
    public void playRockPaperScissor(String playerChoice) {
        if(playerChoice.equals("Reset")){
            playerScore=0;
        }
        else{
            playerScore++;
        }
        
        
    }
}
