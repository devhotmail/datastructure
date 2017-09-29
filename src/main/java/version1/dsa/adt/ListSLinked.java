package version1.dsa.adt;

import version1.dsa.exception.OutOfBoundaryException;
import version1.dsa.strategy.Strategy;
import version1.dsa.strategy.DefaultStrategy;

public class ListSLinked implements List {
	private Strategy strategy;	//����Ԫ�رȽϲ���
	private SLNode head;		//�������׽������
	private int size;			//���Ա�������Ԫ�صĸ���
	
	public ListSLinked() {
		this(new DefaultStrategy());
	}
	public ListSLinked(Strategy strategy) {
		this.strategy = strategy;
		head = new SLNode();
		size = 0;
	}
	
	//��������
	//��ȡ����Ԫ��e���ڽ���ǰ�����
	private SLNode getPreNode(Object e){
		SLNode p = head;
		while (p.getNext()!=null)
			if (strategy.equal(p.getNext().getData(),e)) return p;
			else	p = p.getNext();
		return null;
	}
	//��ȡ���Ϊ0<=i<size��Ԫ�����ڽ���ǰ�����
	private SLNode getPreNode(int i){
		SLNode p = head;
		for (; i>0; i--)	p = p.getNext();
		return p;
	}
	//��ȡ���Ϊ0<=i<size��Ԫ�����ڽ��
	private SLNode getNode(int i){
		SLNode p = head.getNext();
		for (; i>0; i--)	p = p.getNext();
		return p;
	}
	
	//�������Ա�Ĵ�С��������Ԫ�صĸ�����
	public int getSize() {
		return size;
	}

	//������Ա�Ϊ�շ���true�����򷵻�false��
	public boolean isEmpty() {
		return size==0;
	}

	//�ж����Ա��Ƿ��������Ԫ��e
	public boolean contains(Object e) {
		SLNode p = head.getNext();
		while (p!=null)
			if (strategy.equal(p.getData(),e)) return true;
			else	p = p.getNext();
		return false;
	}

	//��������Ԫ��e�����Ա��е����
	public int indexOf(Object e) {
		SLNode p = head.getNext();
		int index = 0;
		while (p!=null)
			if (strategy.equal(p.getData(),e)) return index;
			else	{index++; p = p.getNext();}
		return -1;
	}

	//������Ԫ��e���뵽���Ա���i��λ��
	public void insert(int i, Object e) throws OutOfBoundaryException {
		if (i<0||i>size)
			throw new OutOfBoundaryException("����ָ���Ĳ������Խ�硣");
		SLNode p = getPreNode(i);
		SLNode q = new SLNode(e,p.getNext());
		p.setNext(q);
		size++;
		return;
	}

	//������Ԫ��e���뵽Ԫ��obj֮ǰ
	public boolean insertBefore(Object obj, Object e) {
		SLNode p = getPreNode(obj);
		if (p!=null){
			SLNode q = new SLNode(e,p.getNext());
			p.setNext(q);
			size++;
			return true;
		}
		return false;
	}

	//������Ԫ��e���뵽Ԫ��obj֮��
	public boolean insertAfter(Object obj, Object e) {
		SLNode p = head.getNext();
		while (p!=null)
			if (strategy.equal(p.getData(),obj)){
				SLNode q = new SLNode(e,p.getNext());
				p.setNext(q);
				size++;
				return true;
			}
			else	p = p.getNext();
		return false;
	}

	//ɾ�����Ա������Ϊi��Ԫ��,������֮
	public Object remove(int i) throws OutOfBoundaryException {
		if (i<0||i>=size)
			throw new OutOfBoundaryException("����ָ����ɾ�����Խ�硣");
		SLNode p = getPreNode(i);
		Object obj = p.getNext().getData();
		p.setNext(p.getNext().getNext());
		size--;
		return obj;
	}

	//ɾ�����Ա��е�һ����e��ͬ��Ԫ��
	public boolean remove(Object e) {
		SLNode p = getPreNode(e);
		if (p!=null){
			p.setNext(p.getNext().getNext());
			size--;
			return true;
		}
		return false;
	}

	//�滻���Ա������Ϊi������Ԫ��Ϊe������ԭ����Ԫ��
	public Object replace(int i, Object e) throws OutOfBoundaryException {
		if (i<0||i>=size)
			throw new OutOfBoundaryException("����ָ�������Խ�硣");
		SLNode p = getNode(i);
		Object obj = p.getData();
		p.setData(e);
		return obj;
	}

	//�������Ա������Ϊi������Ԫ��
	public Object get(int i) throws OutOfBoundaryException {
		if (i<0||i>=size)
			throw new OutOfBoundaryException("����ָ�������Խ�硣");
		SLNode p = getNode(i);
		return p.getData();
	}
}
