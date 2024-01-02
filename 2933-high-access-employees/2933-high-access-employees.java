import java.util.*;

public class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        // name -> access times
        Map<String, List<Integer>> map = new HashMap<>();

        for (List<String> entry : access_times) { 
            int time = Integer.parseInt(entry.get(1)); // convert to int
            map.computeIfAbsent(entry.get(0), k -> new ArrayList<>()).add(time); // store in map
        }

        // sort each employee access times
        for (List<Integer> entry : map.values()) {
            Collections.sort(entry);
        }

        // Scan sorted access times to check if accessed >=3 times
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            // to store required employees
            List<Integer> times = entry.getValue();

            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) < 100) {
                    // store employee in result and move to another employee
                    result.add(entry.getKey());
                    break;
                }
            }
        }

        return result;
    }
}
