package module3week2;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ihar_Chekan on 3/18/2015.
 */
public class Module3Task2SpeedTest {

   // private static ArrayList arrayList = new ArrayList();
   // private static LinkedList linkedList = new LinkedList();

    //creating lists
//    private static void generateLists(Integer listsLength) {
//        for (int n=0; n<listsLength ; n++) {
//            String tempString = RandomStringUtils.randomAlphabetic(7);
//            arrayList.add(n, tempString);
//            linkedList.add(n, tempString);
//        }
//    }

    //testing adding element to lists
    public static String testAddElement (Integer listsLength) {
        //generateLists(listsLength);
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int n=0; n<listsLength ; n++) {
            String tempString = RandomStringUtils.randomAlphabetic(7);
            arrayList.add(n, tempString);
            linkedList.add(n, tempString);
        }

        String stringForInsert = RandomStringUtils.randomAlphabetic(7);

        //testing array speed
        long arrayStartTime = System.nanoTime();
        arrayList.add(stringForInsert);
        long arrayEndTime = System.nanoTime();
        long arrayDifference = arrayEndTime - arrayStartTime;

        //testing linked speed
        long linkedStartTime = System.nanoTime();
        linkedList.add(stringForInsert);
        long linkedEndTime = System.nanoTime();
        long linkedDifference = linkedEndTime - linkedStartTime;

        if (arrayDifference < linkedDifference) {
            long diff = linkedDifference - arrayDifference;
            return "Array added element faster than Linked by " + diff + " nanoseconds";
        }
        else if (linkedDifference < arrayDifference){
            long diff = arrayDifference - linkedDifference;
            return "Linked added element faster than Array by " + diff + " nanoseconds";
        }
        else {
            return "They ware equal...with time in nanoseconds = " + arrayDifference + "" ;
        }
    }

    //testing get object from list
    public static String testGetElement (Integer listsLength) {
        //generateLists(listsLength);
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int n = 0; n < listsLength; n++) {
            String tempString = RandomStringUtils.randomAlphabetic(7);
            arrayList.add(n, tempString);
            linkedList.add(n, tempString);
        }

        Integer indexGetString = ThreadLocalRandom.current().nextInt(1, listsLength);

        //testing array get speed
        long arrayStartTime = System.nanoTime();
        arrayList.get(indexGetString);
        long arrayEndTime = System.nanoTime();
        long arrayDifference = arrayEndTime - arrayStartTime;

        //testing linked get speed
        long linkedStartTime = System.nanoTime();
        linkedList.get(indexGetString);
        long linkedEndTime = System.nanoTime();
        long linkedDifference = linkedEndTime - linkedStartTime;

        if (arrayDifference < linkedDifference) {
            long diff = linkedDifference - arrayDifference;
            return "Array get element #" + indexGetString + " faster than Linked by " + diff + " nanoseconds";
        }
        else if (linkedDifference < arrayDifference){
            long diff = arrayDifference - linkedDifference;
            return "Linked get element #" + indexGetString + " faster than Array by " + diff + " nanoseconds";
        }
        else {
            return "They ware equal in element #" + indexGetString + "...with time in nanoseconds = " + arrayDifference + "" ;
        }

    }

    //testing deleting object from list
    public static String testDelElement (Integer listsLength) {
        //generateLists(listsLength);
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int n = 0; n < listsLength; n++) {
            String tempString = RandomStringUtils.randomAlphabetic(7);
            arrayList.add(n, tempString);
            linkedList.add(n, tempString);
        }

        Integer indexGetString = ThreadLocalRandom.current().nextInt(1, listsLength);

        //testing array del speed
        long arrayStartTime = System.nanoTime();
        arrayList.remove(indexGetString);
        long arrayEndTime = System.nanoTime();
        long arrayDifference = arrayEndTime - arrayStartTime;

        //testing linked del speed
        long linkedStartTime = System.nanoTime();
        linkedList.remove(indexGetString);
        long linkedEndTime = System.nanoTime();
        long linkedDifference = linkedEndTime - linkedStartTime;

        if (arrayDifference < linkedDifference) {
            long diff = linkedDifference - arrayDifference;
            return "Array deleted element #" + indexGetString + " faster than Linked by " + diff + " nanoseconds";
        }
        else if (linkedDifference < arrayDifference){
            long diff = arrayDifference - linkedDifference;
            return "Linked deleted element #" + indexGetString + " faster than Array by " + diff + " nanoseconds";
        }
        else {
            return "They ware equal in element #" + indexGetString + "...with time in nanoseconds = " + arrayDifference + "" ;
        }

    }

}