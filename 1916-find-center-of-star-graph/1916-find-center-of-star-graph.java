
class Solution {
    public int findCenter(int[][] edges) {
        int n = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i][0],map.getOrDefault(edges[i][0],0)+1);
            map.put(edges[i][1],map.getOrDefault(edges[i][1],0)+1);
            n = Math.max(edges[i][0], n);
            n = Math.max(edges[i][1], n);
        }

        System.out.println(map);
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() == n-1){
                return e.getKey();
            }
        }
        return 0;
    }
}