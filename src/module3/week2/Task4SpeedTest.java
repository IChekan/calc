package module3.week2;

import module3.week3.Task1Exceptions.FindByModelException;
import module3.week3.Task1Exceptions.SpeedTestException;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ihar_Chekan on 3/18/2015.
 */
public class Task4SpeedTest {

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
    public static String testAddElement (Integer listsLength) throws SpeedTestException{
        //Added Exception
        if(listsLength < 3 ) {
            throw new SpeedTestException();
        }

        //generateLists(listsLength);
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int n=0; n<listsLength ; n++) {
            String tempString = RandomStringUtils.randomAlphabetic(7);
            arrayList.add(n, tempString);
            linkedList.add(n, tempString);
        }

        String stringForInsert = RandomStringUtils.randomAlphabetic(7);
        Integer indexAddString = ThreadLocalRandom.current().nextInt(1, listsLength);

        //testing array speed
        long arrayStartTime = System.nanoTime();
        arrayList.add(indexAddString, stringForInsert);
        long arrayEndTime = System.nanoTime();
        long arrayDifference = arrayEndTime - arrayStartTime;

        //testing linked speed
        long linkedStartTime = System.nanoTime();
        linkedList.add(indexAddString, stringForInsert);
        long linkedEndTime = System.nanoTime();
        long linkedDifference = linkedEndTime - linkedStartTime;

        if (arrayDifference < linkedDifference) {
            long diff = linkedDifference - arrayDifference;
            float diffTimes = linkedDifference * 100 / arrayDifference;
            return "Array added element #" + indexAddString + " faster than Linked by " + diff + " nanoseconds or " + diffTimes + " persents.";
        }
        else if (linkedDifference < arrayDifference){
            long diff = arrayDifference - linkedDifference;
            float diffTimes = arrayDifference * 100 / linkedDifference;
            return "Linked added element #" + indexAddString + " faster than Array by " + diff + " nanoseconds or " + diffTimes + " persents.";
        }
        else {
            return "They were equal in element #" + indexAddString + "...with time in nanoseconds = " + arrayDifference + "";
        }
    }

    //testing get object from list
    public static String testGetElement (Integer listsLength) throws SpeedTestException{
        //Added Exception
        if(listsLength < 3 ) {
            throw new SpeedTestException();
        }

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
            float diffTimes = linkedDifference * 100 / arrayDifference;
            return "Array get element #" + indexGetString + " faster than Linked by " + diff + " nanoseconds or " + diffTimes + " persents.";
        }
        else if (linkedDifference < arrayDifference){
            long diff = arrayDifference - linkedDifference;
            float diffTimes = arrayDifference * 100 / linkedDifference;
            return "Linked get element #" + indexGetString + " faster than Array by " + diff + " nanoseconds or " + diffTimes + " persents.";
        }
        else {
            return "They were equal in element #" + indexGetString + "...with time in nanoseconds = " + arrayDifference + "" ;
        }
    }

    //testing deleting object from list
    public static String testDelElement (Integer listsLength) throws SpeedTestException{
        //Added Exception
        if(listsLength < 3 ) {
            throw new SpeedTestException();
        }

        //generateLists(listsLength);
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int n = 0; n < listsLength; n++) {
            String tempString = RandomStringUtils.randomAlphabetic(7);
            arrayList.add(n, tempString);
            linkedList.add(n, tempString);
        }

        Integer indexDelString = ThreadLocalRandom.current().nextInt(1, listsLength);

        //testing array del speed
        long arrayStartTime = System.nanoTime();
        arrayList.remove(indexDelString);
        long arrayEndTime = System.nanoTime();
        long arrayDifference = arrayEndTime - arrayStartTime;

        //testing linked del speed
        long linkedStartTime = System.nanoTime();
        linkedList.remove(indexDelString);
        long linkedEndTime = System.nanoTime();
        long linkedDifference = linkedEndTime - linkedStartTime;

        if (arrayDifference < linkedDifference) {
            long diff = linkedDifference - arrayDifference;
            float diffTimes = linkedDifference * 100 / arrayDifference;
            return "Array deleted element #" + indexDelString + " faster than Linked by " + diff + " nanoseconds or " + diffTimes + " persents.";
        }
        else if (linkedDifference < arrayDifference){
            long diff = arrayDifference - linkedDifference;
            float diffTimes = arrayDifference * 100 / linkedDifference;
            return "Linked deleted element #" + indexDelString + " faster than Array by " + diff + " nanoseconds or " + diffTimes + " persents.";
        }
        else {
            return "They were equal in element #" + indexDelString + "...with time in nanoseconds = " + arrayDifference + "" ;
        }
    }

}
