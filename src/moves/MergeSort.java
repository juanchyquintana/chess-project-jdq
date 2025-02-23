package moves;

import utils.ChessUtils;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements AlgorithmMove {
    @Override
    public void sort(List<String> list, int speed) {
        mergeSortHelper(list, speed, 0, list.size() - 1);
    }

    private void mergeSortHelper(List<String> list, int speed, int left, int right) {
        if(left < right) {
            int middle = left + (right - left) / 2;

            mergeSortHelper(list, speed, left, middle);
            mergeSortHelper(list, speed, middle + 1, right);

            merge(list, speed, left, middle, right);
        }
    }

    private void merge(List<String> list, int speed, int left, int middle, int right) {
        List<String> leftList = new ArrayList<>(list.subList(left, middle + 1));
        List<String> rightList = new ArrayList<>(list.subList(middle + 1, right + 1));

        int i = 0;
        int j = 0;
        int k = left;
        while(i < leftList.size() && j < rightList.size()) {
            if(leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }

        while (i < leftList.size()) list.set(k++, leftList.get(i++));
        while (j < rightList.size()) list.set(k++, rightList.get(j++));

        ChessUtils.printOrderAndPause(list, speed);
    }
}
