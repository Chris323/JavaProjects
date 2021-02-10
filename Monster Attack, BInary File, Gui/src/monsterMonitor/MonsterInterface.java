package monsterMonitor;

import java.io.File;
import java.util.ArrayList;

public interface MonsterInterface {

	public void saveMonsterAttacks(File newFileIn, ArrayList<MonsterAttack> newAttack);

	public void readMonsterAttacks(File newFileIn, ArrayList<MonsterAttack> newAttack);

}
