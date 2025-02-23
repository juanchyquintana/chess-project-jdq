package moves;

import utils.ChessUtils;

import java.util.Collections;
import java.util.List;

public class BubbleSort implements AlgorithmMove {
    @Override
    public void sort(List<String> list, int speed) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    Collections.swap(list, j, j + 1);
                }
            }
            ChessUtils.printOrderAndPause(list, speed);
        }
    }
}
