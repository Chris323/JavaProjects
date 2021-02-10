package monsterMonitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import monsterMonitor.AttackMonitor;
import monsterMonitor.MonsterAttack;

public class TextMonsterPersister implements MonsterInterface {

	
	@Override
	public void saveMonsterAttacks(File newFileIn, ArrayList<MonsterAttack> newAttack) {
		java.io.File File = new java.io.File("textFile.csv");
		File = newFileIn;
		if (File.exists()) {
			System.out.println("File already exists");
		}

		try {

			PrintWriter save = new PrintWriter(File);
			for (MonsterAttack newfile : newAttack) {

				for (int counter = 0; counter < newAttack.size(); counter++) {
					save.print(newAttack.get(counter).getAttackID() + ",");
					save.print(newAttack.get(counter).getMonstername() + ",");
					save.print(newAttack.get(counter).getLocation() + ",");
					save.print(newAttack.get(counter).getReporter() + ",");
					save.print(newAttack.get(counter).getDate());

					save.println();
					save.close();
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("Not a proper input");
		}

		System.out.print("File has been Saved!");
		
	}

	@Override
	public void readMonsterAttacks(File newFileIn, ArrayList<MonsterAttack> newAttack) {
			newAttack.clear();
		
		try {
			File inFile = new File("textFile"); 
			Scanner filereader = new Scanner(inFile);

			filereader.nextLine(); 

			String newAttackIn;
			String [] newArray; 
			int attackID;
			String date;
			String monstername;
			String location;
			String reporter;

			while (filereader.hasNextLine()) {
				newAttackIn = filereader.nextLine();
				newArray = newAttackIn.split(",");
				attackID = Integer.parseInt(newArray[0]);
				date = newArray[1];
				monstername = newArray[2];
				location = newArray[3];
				reporter = newArray[4];
				
				newAttack.add(new MonsterAttack(attackID, date, monstername, location, reporter));
			}
	
			filereader.close(); 
//			in.close();
			
		} 
		
		catch (IOException error) {
			System.err.println(error);
			System.exit(1);
		}
		}
		
	}

