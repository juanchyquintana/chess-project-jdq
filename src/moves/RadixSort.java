package moves;

import utils.ChessUtils;

import java.util.ArrayList;
import java.util.List;

public class RadixSort implements AlgorithmMove {
    @Override
    public void sort(List<String> list, int speed) {
        int maxLenght = list.stream().mapToInt(String::length).max().orElse(0);

        for(int i = 0; i <= maxLenght; i++) {
            countingSortByDigit(list, i, speed);
        }
    }

    private void countingSortByDigit(List<String> list, int exp, int speed) {
        List<String> output = new ArrayList<>(list.size());
        int[] count = new int[10];

        for(String string : list) {
            int digit = exp <= string.length() ? string.charAt(string.length() - exp) - '0' : 0;
            count[digit]++;
        }

        for(int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for(int i = list.size() - 1; i >= 0; i--) {
            String text = list.get(i);
            int digit = exp <= text.length() ? text.charAt(text.length() - exp) - '0' : 0;

            output.add(count[digit] - 1, text);
            count[digit]--;
        }

        list.clear();
        list.addAll(output);

        ChessUtils.printOrderAndPause(list, speed);
    }
}
