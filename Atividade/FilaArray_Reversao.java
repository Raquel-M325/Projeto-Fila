public class FilaArray_Reversao implements Fila {

    private int inicio_reverso;
    private int fim_reverso;
    private int capacidade;
    private Object[] arr;
    private int botao;

    public FilaArray_Reversao(int capacidade) {
        this.capacidade = capacidade;
        this.inicio_reverso = 0;
        this.fim_reverso = 0;
        this.botao = 0;
        arr = new Object[capacidade];
    }

    public void enqueue(Object o) {
        if (botao == 1) {
            if (size() == capacidade - 1) {
                grow_invertido();
            }

            arr[fim_reverso] = o;
            fim_reverso = (fim_reverso - 1 + capacidade) % capacidade;

            if (size() < capacidade / 3) {
                shrink_invertido();
            }

        } else {
            if (size() == capacidade - 1) {
                grow_normal();
            }

            arr[fim_reverso] = o;
            fim_reverso = (fim_reverso + 1) % capacidade;

            if (size() < capacidade / 3) {
                shrink_normal();
            }
        }
    }

    public Object dequeue() throws FilaVazia {
        if (isEmpty()) {
            throw new FilaVazia("Fila está vazia!");
        }

        if (botao == 1) {
            Object RetiradoInverso_pop = arr[inicio_reverso];
            inicio_reverso = (inicio_reverso - 1 + capacidade) % capacidade;

            if (size() < capacidade / 3) {
                shrink_invertido();
            }

            return RetiradoInverso_pop;

        } else {
            Object Retirado_pop = arr[inicio_reverso];
            inicio_reverso = (inicio_reverso + 1) % capacidade;

            if (size() < capacidade / 3) {
                shrink_normal();
            }

            return Retirado_pop;
        }
    }

    public int size() {
        if (botao == 1) {
            return (capacidade - fim_reverso + inicio_reverso) % capacidade;
        } else {
            return (capacidade - inicio_reverso + fim_reverso) % capacidade;
        }
    }

    public boolean isEmpty() {
        return fim_reverso == inicio_reverso;
    }

    public void grow_invertido() {
        int nova_capacidade = capacidade * 2;
        Object[] novo_arr = new Object[nova_capacidade];
        int tamanho_atual = size(); //salva ANTES de modificar qualquer coisa
        int novo_fim_reverso = fim_reverso;

        for (int i = 0; i < tamanho_atual; i++) {
            novo_arr[i] = arr[novo_fim_reverso];
            novo_fim_reverso = (novo_fim_reverso + 1) % capacidade;
        }

        capacidade = nova_capacidade;
        arr = novo_arr;
        inicio_reverso = tamanho_atual - 1;   //usa valor salvo
        fim_reverso = capacidade - 1;         //era `capacidade` (fora dos limites!)
    }

    public void grow_normal() {
        int nova_capacidade = capacidade * 2;
        Object[] novo_arr = new Object[nova_capacidade];
        int tamanho_atual = size(); //salva ANTES de modificar qualquer coisa
        int novo_inicio = inicio_reverso;

        for (int i = 0; i < tamanho_atual; i++) {
            novo_arr[i] = arr[novo_inicio];
            novo_inicio = (novo_inicio + 1) % capacidade;
        }

        arr = novo_arr;
        capacidade = nova_capacidade;
        inicio_reverso = 0;
        fim_reverso = tamanho_atual; //usa valor salvo
    }

    public void shrink_invertido() {
        int capacidade_reduzida = capacidade / 2;
        Object[] novo_arr = new Object[capacidade_reduzida];
        int tamanho_atual = size(); //salva ANTES de modificar qualquer coisa
        int novo_fim_reverso = fim_reverso;

        for (int i = 0; i < tamanho_atual; i++) {
            novo_arr[i] = arr[novo_fim_reverso];
            novo_fim_reverso = (novo_fim_reverso + 1) % capacidade;
        }

        arr = novo_arr;
        capacidade = capacidade_reduzida;
        inicio_reverso = tamanho_atual - 1;   // usa valor salvo
        fim_reverso = capacidade - 1;         // era capacidade (fora dos limites!)
    }

    public void shrink_normal() {
        int capacidade_reduzida = capacidade / 2;
        Object[] novo_arr = new Object[capacidade_reduzida];
        int tamanho_atual = size(); //salva ANTES de modificar qualquer coisa
        int novo_inicio_reverso = inicio_reverso;

        for (int i = 0; i < tamanho_atual; i++) {
            novo_arr[i] = arr[novo_inicio_reverso];
            novo_inicio_reverso = (novo_inicio_reverso + 1) % capacidade;
        }

        arr = novo_arr;
        capacidade = capacidade_reduzida;
        inicio_reverso = 0;
        fim_reverso = tamanho_atual; //usa valor salvo
    }

    public void botao_reverso() {
        botao = (botao + 1) % 2;
        int novo_inicio = inicio_reverso; // salva o valor original

        inicio_reverso = fim_reverso;     
        fim_reverso = novo_inicio;        
    
    }
}