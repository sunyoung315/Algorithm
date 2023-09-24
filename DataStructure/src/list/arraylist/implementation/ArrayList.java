package list.arraylist.implementation;

public class ArrayList {
	//몇개의 데이터가 이 리스트에 들어가 있는지
	private int size = 0;
	private Object[] elementData = new Object[100];
	
	public boolean addFirst(Object element) {
		return add(0, element);
	}

	public boolean addLast(Object element) {
		elementData[size++] = element;
		return true;
	}
	
	public boolean add(int idx, Object element) {
		for(int i = size-1; i >= idx; i--) {
			elementData[i+1] = elementData[i];
		}
		elementData[idx] = element;
		size++;
		return true;
	} 
	
	public String toString() {
		String str = "[";
		for(int i = 0; i < size; i++) {
			str += elementData[i];
			if(i < size-1) {
				str += ", ";				
			}
		}
		return str + "]";
	}

	public Object remove(int idx) {
		Object removed = elementData[idx];
		for(int i = idx; i < size; i++) {
			elementData[i] = elementData[i+1];
		}
		elementData[size--] = null;
		return removed;
	}
	
	public Object removeFirst() {
		return remove(0);
	}
	
	public Object removeLast() {
		return remove(size-1);
	}

	public Object get(int idx) {
		return elementData[idx];
	}

	public int size() {
		return size;
	}

	public int indexOf(Object o) {
		for(int i = 0; i < size; i++) {
			if(o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	class ListIterator{
		
		private int nextIndex = 0;
		
		public Object next() {
			return elementData[nextIndex++];
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}

		public Object previous() {
			return elementData[--nextIndex];
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		public void add(Object element) {
			ArrayList.this.add(nextIndex++, element);
		}

		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
				
	}
	
	
	
	
	
}
