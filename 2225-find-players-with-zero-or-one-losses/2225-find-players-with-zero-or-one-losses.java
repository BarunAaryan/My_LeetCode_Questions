class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winners = new TreeMap<Integer, Integer>();
        Map<Integer, Integer> losers = new TreeMap<Integer, Integer>();
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0;i<matches.length;i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            winners.put(winner, winners.getOrDefault(winner, 0) + 1);
            losers.put(loser, losers.getOrDefault(loser, 0) + 1);
        }
        Set<Integer> winnersList = new HashSet<Integer>();
        Set<Integer> losersList = new HashSet<Integer>();
        for(int i=0;i<matches.length;i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            if(losers.getOrDefault(winner, 0) == 0) {
                winnersList.add(winner);
            }
            if(losers.getOrDefault(loser, 0) == 1) {
                losersList.add(loser);
            }
        }
        answer.add(convertSetToList(winnersList));
        answer.add(convertSetToList(losersList));
        return answer;
    }
    public List<Integer> convertSetToList(Set<Integer> set) {
        List<Integer> answer = new ArrayList<Integer>();
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            answer.add(iter.next());
        }
        Collections.sort(answer);
        return answer;
    }
}