class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0) {
            return arr;
        }
        int[] temp = arr.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for(int num : temp) {
            if(!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }
        int[] rankorg = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            rankorg[i] = rankMap.get(arr[i]);
        }

        return rankorg;
        // int[] rank = new int[temp.length];
        // for(int i=0; i<temp.length; i++) {
        //     rank[i] = i+1;
        // }
        // for(int i=0; i<temp.length-1; i++) {
        //     if(temp[i+1]==temp[i]) {
        //         rank[i+1] = rank[i];
        //         if(i+1<temp.length-1) {
        //             for(int j=i+2; j<temp.length; j++) {
        //                 rank[j] = rank[j]-1;
        //             }
        //         }
        //     }
        // }
        // int[] rankorg = new int[rank.length];
        // for(int i=0; i<arr.length; i++) {
        //     for(int j=0; j<temp.length; j++) {
        //         if(arr[i]==temp[j]) {
        //             rankorg[i] = rank[j];
        //         }
        //     }
        // }
        // return rankorg;
    }
}