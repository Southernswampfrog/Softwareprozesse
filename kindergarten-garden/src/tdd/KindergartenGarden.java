package tdd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KindergartenGarden {
	private char[] firstRowString;
	private char[] secondRowString;
    private ArrayList<Plant> firstRow = new ArrayList<Plant>();
    private ArrayList<Plant> secondRow = new ArrayList<Plant>();
    private ArrayList<String> children;

	public KindergartenGarden(String plants) {
	    children =  new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"));
        firstRowString = plants.split("\n")[0].toCharArray();
        secondRowString = plants.split("\n")[1].toCharArray();
        initPlants();
    }

    private void initPlants() {
        for (char c : firstRowString) {
            switch (c) {
                case 'V' : firstRow.add(Plant.VIOLETS);
                    break;
                case 'R' : firstRow.add(Plant.RADISHES);
                    break;
                case 'C' : firstRow.add(Plant.CLOVER);
                    break;
                default  : firstRow.add(Plant.GRASS);
                    break;
            }
        }
        for (char c : secondRowString) {
            switch (c) {
                case 'V' : secondRow.add(Plant.VIOLETS);
                    break;
                case 'R' : secondRow.add(Plant.RADISHES);
                    break;
                case 'C' : secondRow.add(Plant.CLOVER);
                    break;
                default  : secondRow.add(Plant.GRASS);
                    break;
            }
        }
    }

    public KindergartenGarden(String plants, String[] names) {
	    String[] namesToSort = names;
        Arrays.sort(namesToSort);
        children =  new ArrayList<String>(Arrays.asList(namesToSort));
        firstRowString = plants.split("\n")[0].toCharArray();
        secondRowString = plants.split("\n")[1].toCharArray();
        initPlants();
	}

	public List<Plant> getPlantsOfStudent(String name) {
        int index = children.indexOf(name);
        if(index == -1){
            return null;
        }
        ArrayList<Plant> plantsOfStudent = new ArrayList<Plant>();
        plantsOfStudent.add(firstRow.get(2 * index));
        plantsOfStudent.add(firstRow.get(2 * index + 1));
        plantsOfStudent.add(secondRow.get(2 * index));
        plantsOfStudent.add(secondRow.get(2 * index + 1));
		return plantsOfStudent;
	}

}
