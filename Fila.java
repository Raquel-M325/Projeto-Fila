public interface Fila {
    public void enqueue();
    public Object dequeue(Object o) throws FilaVazia;
    public int size();
    public boolean isEmpty();
}