// https://leetcode.com/problems/majority-element-ii
class Solution {
  
    // Brute Force - Iterate through the array to count and check for >n/3 and add to list
    // T.C: Near to O(n^2), S.C: O(1)
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ls = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            if (ls.size() == 0 || ls.get(0) != nums[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) {
                        cnt++;
                    }
                }
                if (cnt > (n / 3))
                    ls.add(nums[i]);
            }

            if (ls.size() == 2) break;
        }

        return ls;
    }

    // Better - Using HashMap - O(n^2)
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(); 
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    // Better than Better -O(nlogn)
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length; 
        List<Integer> ls = new ArrayList<>();

        HashMap<Integer, Integer> mpp = new HashMap<>();

        int mini = (int)(n / 3) + 1;
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], value + 1);
            if (mpp.get(nums[i]) == mini) {
                ls.add(nums[i]);
            }
            if (ls.size() == 2) break;
        }

        return ls;
    }

    // Optimal - Using Extended Booyer Moore's Voting Algorithm
    // T.C: O(2*n), S.C: O(1)
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length; 
        List<Integer> list = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i]!=el2){
                cnt1 = 1;
                el1 = nums[i];
            }else if(cnt2==0 && nums[i]!=el1){
                cnt2 = 1;
                el2 = nums[i];
            }else if(el1==nums[i]){
                cnt1++;
            }else if(el2==nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++;
            if (nums[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) list.add(el1);
        if (cnt2 >= mini) list.add(el2);

        return list;
    }
}
