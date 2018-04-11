
public class Array_Iterator<E> implements Iterator_Interface<E> {
	private E[] elems;
	private int counter;
	private int current;

	public Array_Iterator(E[] elems, int counter) {
		this.elems = elems;
		this.counter = counter;
		init();
	}

	public void init() {
		current = 0;
	}

	public boolean hasNext() {
		return current < counter;
	}

	public E next() {
		return elems[current++];
	}
}
