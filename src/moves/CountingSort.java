package moves;

import utils.ChessUtils;

import java.util.*;

public class CountingSort implements AlgorithmMove {
    @Override
    public void sort(List<String> list, int speed) {
        // Crear un mapa de conteo para las cadenas completas
        Map<String, Integer> countMap = new HashMap<>();
        for (String text : list) {
            countMap.put(text, countMap.getOrDefault(text, 0) + 1);
        }

        // Ordenar las cadenas en función de su valor
        List<String> sortedStrings = new ArrayList<>(countMap.keySet());
        Collections.sort(sortedStrings);

        // Reconstruir la lista ordenada basándose en el conteo
        List<String> sortedList = new ArrayList<>();
        for (String string : sortedStrings) {
            int count = countMap.get(string);
            for (int i = 0; i < count; i++) {
                sortedList.add(string);
            }
        }

        // Reemplazar la lista original por la lista ordenada
        list.clear();
        list.addAll(sortedList);

        ChessUtils.printOrderAndPause(list, speed);
    }
}
