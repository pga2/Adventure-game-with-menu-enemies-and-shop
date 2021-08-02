package com.myfirstgame.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class FileOpener{
	private int listSize;
	

	public ArrayList<String> open(String path) {
		Path datatxtFile = Paths.get(path);
		ArrayList<String> tempList = new ArrayList<>();
		try {
			Files.readAllLines(datatxtFile).forEach(e -> tempList.add(e));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}
	public void sortAndSave(String path, int score) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();
		Path datatxtFile = Paths.get(path);
		try {
			Files.readAllLines(datatxtFile).forEach(e -> list.add(e));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i<list.size(); i++) {
			intList.add(Integer.valueOf(list.get(i)));
		}
		
		intList.add(score);
		Collections.sort(intList, Collections.reverseOrder());
		if(intList.size() >= 6) {
			intList.remove(5);
		}
		listSize = list.size();
		for(int i = 0; i < listSize; i++) {	
			list.remove(0);
		}
		for(int i = 0; i<intList.size(); i++) {
			list.add(intList.get(i).toString());
		}
		
		listSize = intList.size();
		for(int i = 0; i < listSize; i++) {	
			intList.remove(0);
		}
		try {
			Files.write(datatxtFile, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
