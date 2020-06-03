package sample;

import com.sun.deploy.util.ArrayUtil;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class CountingSortController {
    private int[] arrayToSort;

    public CountingSortController(int[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    public void sort(boolean sortOrder){
        Arrays.sort(this.arrayToSort);

        if (!sortOrder)
            reverse();
    }

    private void reverse(){
        int temporary = 0;

        for (int i = 0; i < this.arrayToSort.length / 2; i++){
            temporary = this.arrayToSort[i];
            this.arrayToSort[i] = this.arrayToSort[this.arrayToSort.length - i - 1];
            this.arrayToSort[this.arrayToSort.length - i - 1] = temporary;
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.arrayToSort.length; i++) {
            builder.append(this.arrayToSort[i]);
            if (i != this.arrayToSort.length - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }
}
