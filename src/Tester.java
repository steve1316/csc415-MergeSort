/*
Name: Steve Tu
Class: CSC415-01
Date: 09/05/19
*/


interface MergeSort<T>
{
    void sort(T[] items, int left, int middle, int right);
}

class MergeSortImpl<T extends Comparable<T>> implements MergeSort<T>
{
    public void sort(Comparable[] myArray, int left, int middle, int right)
    {
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;

        Comparable[] leftArray = new Comparable[myArray.length];
        Comparable[] rightArray = new Comparable[myArray.length];

        for(int i = 0; i < leftArraySize; i++)
        {
            leftArray[i] = myArray[left + i];
        }

        for(int i = 0; i < rightArraySize; i++)
        {
            rightArray[i] = myArray[middle + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < leftArraySize && j < rightArraySize)
        {
            if(leftArray[i].compareTo(rightArray[j]) <= 0)
            {
                myArray[k] = leftArray[i];
                i++;
            }
            else
            {
                myArray[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while(i < leftArraySize)
        {
            myArray[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < rightArraySize)
        {
            myArray[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void mergeSort(Comparable[] myArray, int left, int right)
    {
        if(left < right)
        {
            int middle = left + (right - left) / 2;

            mergeSort(myArray, left, middle);
            mergeSort(myArray, middle + 1, right);

            sort(myArray, left, middle, right);
        }
    }

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
        System.out.println("\nWelcome to my Merge Sort Program!");
        System.out.println("----------------");

        //Array of data types to be sorted. I'm using Integer objects as an example.
        Integer[] myArray = new Integer[] {1, 5, 2, 7, 9, 6, 4, 8, 10, 3};
        //String[] myArray = new String[] {"Extreme", "Berries", "Fair", "Copper", "Apple", "Deer"};

        System.out.println("Unsorted Array:");
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i].toString());
        }

        //Create an instance of MergeSortImpl
        MergeSortImpl mergeSort = new MergeSortImpl();

        int left = 0;
        int right = myArray.length - 1;
        int middle = (left + right) / 2;

        //Sort the array of unknown data types.
        mergeSort.mergeSort(myArray, left, right);

        System.out.println("\n----------------");
        System.out.println("Sorted Array:");
        //Then print out the resultant array.
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i].toString());
        }

        System.exit(0);
    }
}