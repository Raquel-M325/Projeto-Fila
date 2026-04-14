package Atividade;
public class TesteFilaReversao{
    public static void main(String[] args){
        FilaArray_Reversao execute = new FilaArray_Reversao(5);

        System.out.println(execute.size());
        execute.enqueue(2);
        execute.enqueue(3);
        execute.enqueue(4);
        execute.enqueue(5);

        System.out.println(execute.size());
        execute.botao_reverso();

        execute.enqueue(7);
        execute.enqueue(8);

        execute.dequeue();
        execute.dequeue();
        
        
        System.out.println(execute.size());
        execute.botao_reverso();

        execute.dequeue();
        execute.dequeue();

    } 
}