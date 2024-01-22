class Solution {
    record Pt(int x, int y) {}
    Map<Pt, Integer> costs = new HashMap<>();

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Pt targetPt = new Pt(target[0],target[1]);
        Pt startPt = new Pt(start[0],start[1]);
        
        Queue<Object[]> q = new LinkedList<>();
        
        costs.put(startPt,0);
        q.add(new Object[]{startPt,0});
        
        int shortestPath = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            Object[] o = q.remove();
            Pt point = (Pt)o[0];
            int costToThisPoint = (int)o[1];
            
            if(costToThisPoint > costs.get(point)) continue;
            
            costs.put(point, costToThisPoint);
            shortestPath = Math.min(shortestPath, costToThisPoint + distance(point,targetPt));
 
            for(int[] road:specialRoads) {
                int roadCost=road[4];
                Pt startOfRoad = new Pt(road[0],road[1]);
                Pt endOfRoad = new Pt(road[2],road[3]);
                int costToEndOfRoad = costToThisPoint + distance(point, startOfRoad) + roadCost;
                if(costToEndOfRoad >= costs.getOrDefault(endOfRoad, Integer.MAX_VALUE)) continue;
                costs.put(endOfRoad, costToEndOfRoad);
                q.add(new Object[]{endOfRoad,costToEndOfRoad});
            }
        }
        
        return shortestPath;
    }
    
    int distance(Pt from, Pt to) {
        return Math.abs(to.x()-from.x()) + Math.abs(to.y()-from.y());
    }
}