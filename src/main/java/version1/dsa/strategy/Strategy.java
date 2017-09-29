package version1.dsa.strategy;


public interface Strategy {
	//�ж���������Ԫ���Ƿ����
	public boolean equal(Object obj1, Object obj2);
	
	/**
	 * �Ƚ���������Ԫ�صĴ�С
	 * ���obj1 < obj2 ����-1
	 * ���obj1 = obj2 ����0
	 * ���obj1 > obj2 ����1
	 */
	public int compare(Object obj1, Object obj2);
}
