public class FilaArray_Reversao implements Fila{

    private int inicio_reverso;
    private int fim_reverso;
    private int capacidade;
    private int crescimento;
    private Object[] arr;

    public FilaArray_Reversao(int capacidade; int crescimento){
        arr = new Object[capacidade];
        this.capacidade = capacidade;
        this.crescimento = crescimento;
        this.inicio_reverso = 0;
        this.fim_reverso = 0;
    }


    public void enqueue(Object o){
        if (size() == capacidade - 1){
            grow();
        }

        arr[fim_reverso] = o;
        fim_reverso = (fim_reverso - 1 + capacidade) % capacidade;

        if (size() < capacidade / 3){
            shrink();
        }

    }

    public Object dequeue() throws FilaVazia{
        if (isEmpty()){
            throw new FilaVazia("Fila está vazia!");
        }

        Object RetiradoReverso_pop = arr[inicio_reverso];
        inicio_reverso = (inicio_reverso - 1 + capacidade) % capacidade;

        if (size() < capacidade / 3){
            shrink();
        }

        return RetiradoReverso_pop;
    }

    public int size(){
        return (capacidade - inicio_reverso + fim_reverso) % capacidade;
    }

    public boolean isEmpty(){
        return fim_reverso == inicio_reverso;
    }

    public void grow(){
        int nova_capacidade = capacidade * 2; //vai crescer indepentemente;
        Object[] novo_arr = new Object [nova_capacidade];
        int novo_inicio_reverso = inicio_reverso; //uso temporário

        for (int i = 0; i < size(); i++){
            novo_arr[i] = arr[novo_inicio_reverso];
            novo_inicio_reverso = (novo_inicio_reverso - 1 + capacidade) % capacidade; //será a velha capacidade por conta da lista velha da fila

        }


        capacidade = nova_capacidade;
        arr = novo_arr;
        inicio_reverso = 0;
        fim_reverso = size(); //precisarei analisar
    }

    public void shrink(){
        int capacidade_reduzida = capacidade / 2;
        Object[] novo_arr = new Object[capacidade_reduzida];
        int novo_inicio_reverso = inicio_reverso;

        for (int i = 0; i < size(); i++){
            novo_arr[i] = arr[novo_inicio_reverso];
            novo_inicio_reverso = (novo_inicio_reverso - 1 + capacidade) % capacidade;
    
        }

        arr = novo_arr;
        capacidade = capacidade_reduzida;
        inicio_reverso = 0;
        fim_reverso = size();
    }
    //lembra a logica de pilha preta
}