import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class QuicksortComplexity {
    static final int MAX=10000;
    static int[] a=new int[MAX];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        System.out.println("enter the np of array elements");
       int  n=sc.nextInt();
       for(int i=0;i<n;i++){
        a[i]=r.nextInt(1000);
       }
       System.out.println("input array");
       for(int i=0;i<n;i++){
        System.out.println(a[i]+" ");
       }
       long startTime=System.nanoTime();
       Quicksort(0,n-1);
       long stopTime=System.nanoTime();
       long elapsedTime=stopTime-startTime;
       System.out.println("sorted array");
       for(int i=0;i<n;i++){
        System.out.println(a[i]+" ");
       }
       System.out.println("time complexity for n="+n+"is"+(double)elapsedTime/1000000.0+"ms");
    }
    public static void Quicksort(int p,int r ){
        if(p<r){
            int q=partition(p,r);
            Quicksort(p, q-1);
            Quicksort(q+1, r);
        }
    }
    public static int partition(int p,int r){
        int pivot=a[p];
        int i=p;
        int j=r+1;
        while(true){
            do{
                i++;
            }while(i<=r&&a[i]<=pivot);
            do{
                j--;
            }while(a[j]>pivot);
            if(i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }else{
                break;
            }
        }
        a[p]=a[j];
        a[j]=pivot;
        return j;
    }
    
}