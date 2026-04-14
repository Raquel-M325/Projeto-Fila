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
        execute.botao();

        execute.dequeue();
        execute.dequeue();        


    } 
}