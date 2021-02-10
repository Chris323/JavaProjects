package monsterMonitor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BinaryMonsterPersister implements MonsterInterface{
//	AttackMonitor list = new AttackMonitor();
	
	public void saveMonsterAttacks(File newFileIn, ArrayList<MonsterAttack> newAttack) {
		ObjectOutputStream output = null;
		
		try {
			output = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(newFileIn)));
			output.writeObject(newAttack);
			output.close();
			
		} catch (Exception error) {
			error.printStackTrace();
		}
		
	}
	
	public void readMonsterAttacks(File newFileIn, ArrayList<MonsterAttack> newAttack) {
		ObjectInputStream input = null;
		ArrayList<MonsterAttack> newAttackIn = null;
		
		try {
			input = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(newFileIn)));
			newAttackIn = (ArrayList<MonsterAttack>) input.readObject();
			input.close();
			
		} catch (Exception error) {
			error.printStackTrace();
		}

//		return newAttackIn;
	}


}
