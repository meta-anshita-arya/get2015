package prg2;

import java.util.Arrays;

public class Students {
	private int top = -1;
	private int rear = -1;
	String[] NameList;
	int[] rankList;

	// constructor to initialize limit of list
	Students(int limit) {
		this.NameList = new String[limit];
		this.rankList = new int[limit];
	}

	// to add student
	public void enqueue(String name, int rank) {
		
			if (top == -1 && rear == -1) {
				top++;
				rear++;

			} else {
				rear++;
			}
			rankList[rear] = rank;
			NameList[rear] = name;
		

	}

	// to remove student
	public String dequeue() {
		String name;
		if (rear != -1) {
			name = NameList[top];
			top++;
		} else {
			System.out.println("queue empty");
			name = "";
		}
		return name;
	}

	// to clear list
	void makeEmpty() {
		NameList = null;
		top = -1;
		rear = -1;
		rankList = null;
	}

	// to get name at top of queue
	String getFront() {
		return NameList[top];
	}

	// for sorting
	void sorting() {
		String forName = "";
		int forRank;

		for (int i = 0; i < (NameList.length); i++) {
			for (int j = i; j < NameList.length - 1; j++) {
				if (rankList[j] > rankList[j + 1]) {
					forName = NameList[j + 1];
					NameList[j + 1] = NameList[j];
					NameList[j] = forName;

					forRank = rankList[j + 1];
					rankList[j + 1] = rankList[j];
					rankList[j] = forRank;
				}

			}

		}

	}
}
