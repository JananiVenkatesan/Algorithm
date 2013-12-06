public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target){
	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	if(num == null || num.length < 4)
		return lists;

	Arrays.sort(num);
	for(int i = 0; i < num.length; i ++){
		// Skip duplicates
		if(i > 0 && num[i - 1] == num[i])
			continue;
		for(int j = i + 1; j < num.length - 1; j ++){
			// Skip duplicates
			if(j > i + 1 && num[j - 1] == num[j])
				continue;
			int left = j + 1, right = num.length - 1;
			while(left < right){
				int sum = num[i] + num[j] + num[left] + num[right];
				if(sum < target){
					left ++;
				}
				else if(sum > target){
					right --;
				}
				else{
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(num[left]);
					list.add(num[right]);
					lists.add(list);

					left ++;
					while(left < right && num[left - 1] == num[left]){
						left ++;
					}

					right --;
					while(left < right && num[right + 1] == num[right]){
						right --;
					}
				}	
			}
		}
	}
	return lists;
}