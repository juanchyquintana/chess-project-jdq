package moves;

import utils.ChessUtils;

import java.util.Collections;
import java.util.List;

public class QuickSort implements AlgorithmMove {
    @Override
    public void sort(List<String> list, int speed) {
        quickSortHelper(list, speed, 0, list.size() - 1);
    }

    private void quickSortHelper(List<String> list, int speed, int low, int high) {
        if(low < high) {
            int pi = partition(list, low, high);

            quickSortHelper(list, speed, low, pi - 1);
            quickSortHelper(list, speed, pi + 1, high);
        }
    }

    private int partition(List<String> list, int low, int high) {
        String pivot = list.get(high);
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(list.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }
}
