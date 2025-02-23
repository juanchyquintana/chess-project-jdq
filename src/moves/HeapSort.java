package moves;

import utils.ChessUtils;

import java.util.Collections;
import java.util.List;

public class HeapSort implements AlgorithmMove {
    @Override
    public void sort(List<String> list, int speed) {
        int sizeList = list.size();

        for(int i = sizeList / 2 - 1; i >= 0; i--) {
            heapify(list, sizeList, i, speed);
        }

        for(int i = sizeList - 1; i >= 0; i--) {
            Collections.swap(list, 0, i);
            heapify(list, i, 0, speed);
        }
    }

    private void heapify(List<String> list, int n, int i, int speed) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && list.get(left).compareTo(list.get(largest)) > 0) {
            largest = left;
        }
        if (right < n && list.get(right).compareTo(list.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            Collections.swap(list, i, largest);
            heapify(list, n, largest, speed);
        }

        ChessUtils.printOrderAndPause(list, speed);
    }
}
