package Atividade;
public interface Fila {
    public void enqueue(Object o);
    public Object dequeue() throws FilaVazia;
    public int size();
    public boolean isEmpty();
    public void grow_invertido();
    public void grow_normal();
    public void shrink_invertido();
    public void shrink_normal();
    public void botao_reverso();
}