public interface Fila {
    public void enqueue();
    public Object dequeue(Object o) throws FilaVazia;
    public int size();
    public boolean isEmpty();
    public void grow();
    public void shrink();
}