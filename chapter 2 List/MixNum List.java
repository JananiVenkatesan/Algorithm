public int sumList(List<MixNum> list){
	if(list == null || list.size() == 0)
		return Integer.MIN_VALUE;
	return sumListHelper(list, 1);
}

private int sumListHelper(List<MixNum> list, int length){
	int sum = 0;
	for(MixNum n : list){
		if(isInteger(n)){
			sum = sum + getInteger(n) * length;
		}
		else{
			sum += sumListHelper(getList(n), length + 1);
		}
	}
	return sum;
}