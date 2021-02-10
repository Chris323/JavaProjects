package monsterAttackLab;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class AttackMonitor {
	private ArrayList<MonsterAttack> attacks = new ArrayList<>();
	private boolean choice = true;

	public void monitor() {
		int choices = 0;
		Scanner sc = new Scanner(System.in);
		while (choice) {
			menu();
			System.out.println("Choose From Above : ");
			choices = sc.nextInt();
			switch (choices) {
			case 1:
				input(sc);
				break;
			case 2:
				show();
				break;
			case 3:
				delete(sc);
				break;
			case 4:
				saveFile();
				break;
			case 5:
				readFile();
				break;
			case 6:
				quit();
				break;
			}
		}
	}

	private void menu() {
		System.out.println("(1) Add Monster Attack ");
		System.out.println("(2) Show Monster Attacks ");
		System.out.println("(3) Delete Monster Attack ");
		System.out.println("(4) Save to CSV file ");
		System.out.println("(5) Add Monster Attack from saved CSV file");
		System.out.println("(6) Quit Monitor ");
	}

	public void add(int attackID, String monstername, String date, String location, String reportername) {
		MonsterAttack m1 = new MonsterAttack(attackID, date, monstername, location, reportername);
		attacks.add(m1);
	}

	public void input(Scanner sc) {
		int id;
		String date;
		String name;
		String loc;
		String repName;
		System.out.println("Enter the new Id");
		id = sc.nextInt();
		System.out.println("Enter the monster name");
		name = sc.next();
		System.out.println("Enter the date");
		date = sc.next();
		System.out.println("Enter the location");
		loc = sc.next();
		System.out.println("Enter the reporter name");
		repName = sc.next();

		add(id, name, date, loc, repName);
	}

	private void show() {
		if (attacks.isEmpty()) {
			System.out.println("The List Is Empty");
			return;
		}
		System.out.println("----------------------- Here Is The Monster Attcks --------------------");
		for (int i = 0; i < attacks.size(); i++) {
			System.out.println(attacks.get(i));
		}
	}

	private void delete(Scanner sc) {
		if (attacks.isEmpty()) {
			System.out.println("The List Is Empty");
			return;
		}
		show();
		int id;
		System.out.println("Enter the Id to delete ");
		id = sc.nextInt();
		for (int i = 0; i < attacks.size(); i++) {
			if (attacks.get(i).getAttackID() == id) {
				attacks.remove(i);
			}
		}
	}

	public void saveFile() {
		java.io.File File = new java.io.File("attacks.csv");

		if (File.exists()) {
			System.out.println("File already exists");
		}

		try {

			PrintWriter save = new PrintWriter(File);
			for (MonsterAttack newfile : attacks) {

				for (int counter = 0; counter < attacks.size(); counter++) {
					save.print(attacks.get(counter).getAttackID() + ",");
					save.print(attacks.get(counter).getMonstername() + ",");
					save.print(attacks.get(counter).getLocation() + ",");
					save.print(attacks.get(counter).getReporter() + ",");
					save.print(attacks.get(counter).getDate());

					save.println();
					save.close();
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("Not a proper input");
		}

		System.out.print("File has been Saved!");
	}

	public void readFile() {
		attacks.clear();
	
		try {
			System.out.println("Enter a filepath to read from ");
			Scanner in = new Scanner(System.in);
			File inFile = new File(in.next()); 
			Scanner filereader = new Scanner(inFile);

			filereader.nextLine(); 

			String newAttack;
			String [] newArray; 
			int attackID;
			String date;
			String monstername;
			String location;
			String reporter;

			while (filereader.hasNextLine()) {
				newAttack = filereader.nextLine();
				newArray = newAttack.split(",");
				attackID = Integer.parseInt(newArray[0]);
				date = newArray[1];
				monstername = newArray[2];
				location = newArray[3];
				reporter = newArray[4];
				
				attacks.add(new MonsterAttack(attackID, date, monstername, location, reporter));
			}
	
			filereader.close(); 
			in.close();
			
		} 
		
		catch (IOException error) {
			System.err.println(error);
			System.exit(1);
		}
		}

	public void quit() {
		choice = false;
	}
}
