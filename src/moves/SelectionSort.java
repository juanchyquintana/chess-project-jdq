package moves;

import utils.ChessUtils;

import java.util.Collections;
import java.util.List;

public class SelectionSort implements AlgorithmMove {
    @Override
    public void sort(List<String> list, int speed) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(list, i, minIndex);
            ChessUtils.printOrderAndPause(list, speed);
        }
    }
}
