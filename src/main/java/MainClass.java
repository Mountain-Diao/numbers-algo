import logic.CheckMultiplicand;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String args[]){
        var randomizer = new Random();

        {
            /**First Implementation*/
            var array1 = new int[10];

            Arrays.setAll(array1, i -> randomizer.nextInt(500) );

            var appendedInt1 = Arrays.stream(array1)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println("Integers in first array: " + appendedInt1);

            int firstMax = 0;
            int secondMax = 0;

            for(int i : array1){
                if(i > firstMax){
                    firstMax = i;
                }
            }

            for(int i : array1){
                if(i != firstMax){
                    if(i > secondMax)
                        secondMax = i;
                }
            }

            System.out.printf("Sum of %d + %d = %d%n", firstMax, secondMax, firstMax + secondMax);
        }

        System.out.printf("%n");

        {
            /**Second implementation*/
            var array2 = new int[10];

            Arrays.setAll(array2, i -> randomizer.nextInt(500) );

            var appendedInt2 = Arrays.stream(array2)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println("Integers in second array: " + appendedInt2);

            var minValue = array2[0];

            for(int i : array2){
                if(i < minValue){
                    minValue = i;
                }
            }

            System.out.printf("Smallest integer in second array is %d", minValue);
            System.out.printf("%n");
        }

        System.out.printf("%n");

        {
            /**Third implementation*/
            var two = 2;
            var three = 3;
            var five = 5;

            var logic = new CheckMultiplicand();

            var loopCounter = 0;
            var counter = 1;

            while(loopCounter < 1500){
                var multiplicandArray = logic.divideByMultiplicand(new ArrayList<Integer>(), counter);
                if(!multiplicandArray.isEmpty()){
                    var product = multiplicandArray.stream()
                            .reduce(1, (x, y) -> x * y);
                    var appendedString = multiplicandArray.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", "));

                    System.out.printf("No. %d -> %d: %s%n", loopCounter, product, "[" + appendedString + "]");
                    loopCounter ++;
                }
                counter ++;
            }
        }

    }
}
