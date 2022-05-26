/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radixsort;

import java.util.Scanner;

/**
 *
 * @author mpeht
 */
public class RadixSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int num = 0;
        System.out.println("Enter the size of vector:");
        num = sc.nextInt();

        int vector[] = new int[num];
        System.out.print("Enter the values for vector fill: ");

        for (int i = 0; i < num; i++) {
            vector[i] = sc.nextInt();
        }

        radixSort(vector, num);
        toPrint(vector, num);
    }

    public static void radixSort(int[] vector, int num) {

        float num02 = getMaxNumber(vector, num);
        for (int pot = 1; (num02 / pot) > 0; pot *= 10) {
            countSort(vector, num, pot);
        }

    }

    public static int getMaxNumber(int[] vector, int num01) {
        int max = 0;
        for (int i = 0; i < vector.length - 1; i++) {
            if (max < vector[i]) {
                max = vector[i];
            }
        }
        return max;

    }

    public static void countSort(int[] vector, int num01, int pot) {

        int[] vector01 = new int[num01];
        int j;
        int[] bucket = new int[10];
        for (j = 0; j < num01; j++) {
            bucket[(vector[j] / pot) % 10]++;
        }
        for (j = 1; j < 10; j++) {
            bucket[j] += bucket[j - 1];
        }
        for (j = num01 - 1; j >= 0; j--) {
            vector01[bucket[(vector[j] / pot) % 10] - 1] = vector[j];
            bucket[(vector[j] / pot) % 10]--;
        }
        for (j = 0; j < num01; j++) {
            vector[j] = vector01[j];
        }
    }
    static void toPrint(int [] vector, int num)    {
    
        for (int i = 0; i < num; i++)
            System.out.print(vector[i] + " ");
    }
}

