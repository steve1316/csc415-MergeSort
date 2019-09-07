/*
Name: Steve Tu
Class: CSC415-01
Date: 09/05/19
*/

interface MergeSort<T>
{
    void sort(T[] items);
}

class MergeSortImpl<T extends Comparable<T>> implements MergeSort<T>
{
    public void sort(Comparable[] myArray)
    {
        Comparable[] tempArray = new Comparable[myArray.length];

        //Begin the process of recursively calling sort for the left and right halves of tempArray.
        sort(myArray, tempArray, 0, myArray.length - 1);
    }

    public void sort(Comparable[] myArray, Comparable[] tempArray, int left, int right)
    {
        //Condition to exit out of recursion. myArray is now sorted from least to greatest.
        if(right <= left)
        {
            return;
        }

        //Get midpoint of myArray.
        int midpoint = (left + right) / 2;

        //Recursively call for the left half of myArray.
        sort(myArray, tempArray, left, midpoint);

        //Recursively call for the right half of myArray.
        sort(myArray, tempArray, midpoint + 1, right);

        //Call merge to begin merging the left and right halves while sorting them.
        merge(myArray, tempArray, left, midpoint, right);
    }

    public void merge(Comparable[] myArray, Comparable[] tempArray, int left, int midpoint, int right)
    {
        //Copy over myArray to tempArray.
        copyArray(myArray, tempArray);

        int i = left;
        int j = midpoint + 1;

        //Begin sorting and merging of the half that called merge() back into myArray.
        for(int k = left; k <= right; k++)
        {
            //If index i is greater than midpoint, put element j of tempArray into myArray at position k.
            if(i > midpoint)
            {
                myArray[k] = tempArray[j++];
            }
            //If index j is greater than myArray's size, put element i of tempArray into myArray at position k.
            else if(j > right)
            {
                myArray[k] = tempArray[i++];
            }
            //Else if element i of tempArray is less than element j of the same array, put element i of tempArray
            // into myArray at position k.
            else if(tempArray[i].compareTo(tempArray[j]) <= 0)
            {
                myArray[k] = tempArray[i++];
            }
            //Otherwise, put element j of tempArray into myArray at position k.
            else
            {
                myArray[k] = tempArray[j++];
            }
        }
    }

    //This method will copy over the elements in myArray over to tempArray.
    public void copyArray(Comparable[] myArray, Comparable[] tempArray)
    {
        for(int i = 0; i < myArray.length; i++)
        {
            tempArray[i] = myArray[i];
        }
    }
}

public class Tester
{
    public static void main(String args[])
    {
        System.out.println("\nWelcome to my Merge Sort Program! This program is designed to sort generic data types from least to greatest.");
        System.out.println("----------------");

        //Array of any data types to be sorted. This program is using array of Integers as an example but a String
        // array is also provided. You can add your own, just make sure to name your array "myArray".

        Integer[] myArray = new Integer[] {1, 5, 2, 7, 9, 6, 4, 8, 10, 3};
        //String[] myArray = new String[] {"Extreme", "Berries", "Fair", "Copper", "Apple", "Deer"};

        //Print the unsorted array first.
        printArray(myArray, false);

        //Create an instance of MergeSortImpl.
        MergeSortImpl mergeSort = new MergeSortImpl();

        //Sort the array.
        mergeSort.sort(myArray);

        //Then print out the sorted array.
        printArray(myArray, true);

        System.exit(0);
    }

    static public void printArray(Comparable[] myArray, boolean isSorted)
    {
        if(!isSorted)
        {
            System.out.println("Unsorted Array:\n");
            System.out.print("{");
            for (int i = 0; i < myArray.length; i++)
            {
                if(i == myArray.length - 1)
                {
                    System.out.print(myArray[i].toString() + "}");
                }
                else
                {
                    System.out.print(myArray[i].toString() + ", ");
                }
            }
        }
        else
        {
            System.out.println("\n----------------");
            System.out.println("Sorted Array:\n");
            System.out.print("{");
            for (int i = 0; i < myArray.length; i++)
            {
                if(i == myArray.length - 1)
                {
                    System.out.print(myArray[i].toString() + "}");
                }
                else
                {
                    System.out.print(myArray[i].toString() + ", ");
                }
            }
        }
    }
}