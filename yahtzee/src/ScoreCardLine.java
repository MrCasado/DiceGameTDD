import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreCardLine {
	
	private String name;
	private String description;
	private Category category;
	private int score = 0;
	private boolean hasBeenScored = false;
	
	public boolean hasBeenScored() {
		return hasBeenScored;
	}
	public void setHasBeenScored(boolean hasBeenScored) {
		this.hasBeenScored = hasBeenScored;
	}
	public ScoreCardLine(Category category, String name, String description) {
		super();
		this.setCategory(category);
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score=score;
    }
    @Deprecated
    public void score (Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5){
        score(new YahtzeeDice(dice1,dice2,dice3,dice4,dice5));
    }
    public void score (YahtzeeDice dice){
        setHasBeenScored(true);
        if (!isValid(dice))
            return;
        switch (category){
            case CHANCE:
            case ONE_PAIR:
                score += dice.getTotal();
        }
	}

    public boolean isValid (YahtzeeDice yahtzeeDice)
    {
        switch (category){
            case CHANCE:
                return true;
            case ONE_PAIR:
                Integer[] map = new Integer[7];

                for(int i=1;i<=6;i++)
                {
                    map[i]=0;
                }
                List<Dice> dice = yahtzeeDice.getDice();
                for (Dice die: dice)
                {
                    map[die.getFaceValue()]++;
                }
                for(int i=1;i<=6;i++)
                {
                    if (map[i]>1)
                        return true;
                }
                return false;
        }
        return false;
    }
}
