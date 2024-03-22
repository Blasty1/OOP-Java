package primo;

public class Contatore {

    private int valore = 0;

    public Contatore inc() {
        valore++;
        new Operazione('+');
        return this;
    }

    public int valore() {
        return valore;
    }

    public Contatore dec() {
        valore--;
        new Operazione('-');
        return this;
    }

    Operazione[] ops = new Operazione[100];
    int top = -1;

    class Operazione{
        final char op;
        public Operazione(char op)
        {
            this.op = op;
            ops[++top] = this;
        }

        public void undo()
        {
            //pesca l'ultima operazione dalla cima dello stack delle operazioni passate
            // applica al contrario l'operazione
            switch(op)
            {
                case '+': valore--;
                    break;
                case '-': valore++;
                    break;
            }
            top--;
        }
    }
}
