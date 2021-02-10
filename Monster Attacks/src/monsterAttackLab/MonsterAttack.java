package monsterAttackLab;

public class MonsterAttack {
	private int attackID;
	private int day;
	private int month;
	private int year;
	private String monstername;
	private String location;
	private String reporter;

	public MonsterAttack(int attackIDIn, String dateIn, String monsternameIn, String locationIn, String reporterIn) {
		attackID = attackIDIn;
		String[] date = dateIn.split("/");
		month = Integer.parseInt(date[0]);
		day = Integer.parseInt(date[1]);
		year = Integer.parseInt(date[2]);
		monstername = monsternameIn;
		location = locationIn;
		reporter = reporterIn;

	}

	public int getAttackID() {
		return attackID;
	}

	public void setAttackID(int attackID) {
		this.attackID = attackID;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDate() {
		return month + "/" + day + "/" + year;
	}

	public String getMonstername() {
		return monstername;
	}

	public void setMonstername(String monstername) {
		this.monstername = monstername;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String toString() {
		if (attackID == 0) {
			return "\nerror value not assigned";
		}

		return "\nAttack #" + attackID + " : " + monstername + " Attacked " + location + " on " + getDate() + ". "
				+ "Reported By " + reporter;
	}

}
