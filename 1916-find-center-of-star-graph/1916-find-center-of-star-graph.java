class Solution {
    public int findCenter(int[][] edges) {
        // 최대 시간에 발생하는 정점이 중심이므로 정점을 발생 횟수와 함께 저장하는 해시맵 생성
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < edges.length;i++) {
            for(int j=0; j<edges[0].length; j++){
                if(!map.containsKey(edges[i][j])) {
                    map.put(edges[i][j], 1);
                }
                int of=map.get(edges[i][j]);
                of=of+1;
                map.put(edges[i][j], of);
            }
        }

        int center = 0;
        int max = Integer.MIN_VALUE;
        for(int key:map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
                center=key;
            }
        }

        return center;
    }
}