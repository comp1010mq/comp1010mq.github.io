public class GoalScoringRecord {
	private int shotsTaken, goalsScored;

	public int getShotsTaken() {
		return shotsTaken;
	}

	public void setShotsTaken(int s) {
		shotsTaken = Math.max(0, s);
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(int g) {
		goalsScored = Math.max(0, g);
	}
	
	public GoalScoringRecord(int s, int g) {
		setShotsTaken(s);
		setGoalsScored(g);
	}
	
	/**
	 * 
	 * @return conversion rate in percentage
	 */
	public double conversionRate() {
		return 100 * goalsScored / shotsTaken;
	}
	
	/**
	 * 
	 * @param other
	 * @return 1 if conversion rate of calling object is more than conversion rate of parameter object
	 * -1 if conversion rate of calling object is less than conversion rate of parameter object
	 * 0 if conversion rate of calling object is equal to conversion rate of parameter object
	 */
	public int compareTo(GoalScoringRecord other) {
		return 0; //to be completed
	}
}
	
