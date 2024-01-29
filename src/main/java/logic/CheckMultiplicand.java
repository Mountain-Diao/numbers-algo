package logic;

import java.util.ArrayList;

public class CheckMultiplicand {
    private ArrayList<Integer> integerArrayList;

    private static final Integer TWO = 2;
    private static final Integer THREE = 3;
    private static final Integer FIVE = 5;

    public ArrayList<Integer> divideByMultiplicand(ArrayList<Integer> integerArrayList, Integer integer){
        this.integerArrayList = integerArrayList;
        while (integer % TWO == 0){
            this.addMultiplicandIntoArray(TWO);
            integer /= TWO;
        }
        while (integer % THREE == 0){
            this.addMultiplicandIntoArray(THREE);
            integer /= THREE;
        }
        while (integer % FIVE == 0){
            this.addMultiplicandIntoArray(FIVE);
            integer /= FIVE;
        }

        if(integer % TWO != 0 && integer % THREE != 0 && integer % FIVE != 0 && integer != 1){
            return new ArrayList<>();
        } else {
            return this.integerArrayList;
        }
    }

    public void addMultiplicandIntoArray(Integer integer){
        this.integerArrayList.add(integer);
    }

}
