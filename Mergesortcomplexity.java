import java.util.Scanner;
import java.util.Random;

public class Mergesortcomplexity {

    static final int MAX = 10000;
    static int[] a = new int[MAX];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        // Generate random elements
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(1000);
        }

        // Print input array
        System.out.println("\nInput Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        long startTime = System.nanoTime();

        mergeSort(0, n - 1);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;

        // Print sorted array
        System.out.println("\n\nSorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\n\nTime taken: " + (elapsedTime / 1000000.0) + " ms");

        input.close();
    }
public static void mergeSort(int low,int high){
    if(low<high){
      int   mid=(high+low)/2;
        mergeSort(low, mid);
        mergeSort(mid+1, high);
        merge(low,mid,high);
    }
}
public static void merge(int low,int mid,int high){
    int[] b=new int[MAX];
    int i=low;
    int j=mid+1;
    int k=low;
    while (i<=mid&&j<=high) {
        if(a[i]<a[j]){
            b[k++]=a[i++];
        }else{
            b[k++]=a[j++];
        }
    }
    while (i<=mid) {
        b[k++]=a[i++];
    }
    while(j<=high){
        b[k++]=a[j++];
    }
    for (int x = low; x <= high; x++) {
            a[x] = b[x];
        }
}
}