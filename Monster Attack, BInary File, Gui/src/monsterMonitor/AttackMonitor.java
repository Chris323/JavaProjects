package monsterMonitor;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import monsterMonitor.MonsterAttack;

public class AttackMonitor {
	protected ArrayList<MonsterAttack> attacks = new ArrayList<>();
	protected boolean choice = true;
	Scanner sc = new Scanner(System.in);
	BinaryMonsterPersister bin = new BinaryMonsterPersister();
	TextMonsterPersister text = new TextMonsterPersister();
	public void monitor(String choices) {

			switch (choices) {
			case "Input Attack":
				input();
				break;
			case "Show Attack":
				show();
				break;
			case "Delete Attack":
				delete();
				break;
			case "Binary Save":
				binarySave();
				break;
			case "Binary Read":
				binaryRead();
			case "Text Save":
				textSave();
				break;
			case "Text Read":
				textRead();
				break;
			case "Quit":
				quit();
				break;
			}
			}
//	}

//	private void menu() {
//		System.out.println("(1) Add Monster Attack ");
//		System.out.println("(2) Show Monster Attacks ");
//		System.out.println("(3) Delete Monster Attack ");
//		System.out.println("(4) Save to CSV file ");
//		System.out.println("(5) Add Monster Attack from saved CSV file");
//		System.out.println("(6) Quit Monitor ");
//	}

	public void add(int attackID, String monstername, String date, String location, String reportername) {
		MonsterAttack m1 = new MonsterAttack(attackID, date, monstername, location, reportername);
		attacks.add(m1);
	}

	public void input() {
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

	private void delete() {
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
	public void binarySave(){
		bin.saveMonsterAttacks(new File("binary"), attacks);
	}
	
	public void binaryRead(){
		bin.saveMonsterAttacks(new File("binary"), attacks);
	}
	
	public void textSave(){
		text.saveMonsterAttacks(new File("textFile"), attacks);
	}
	
	public void textRead(){
		text.saveMonsterAttacks(new File("textFile"), attacks);
	}
	
	public void quit() {
		System.exit(0);
	}
}

