import java.util.Iterator;

public class Letters implements Iterable {
    private char[] chars;

    public Letters(String s)
    {
        chars = s.toCharArray();
    }
    @Override
    public Iterator iterator() {
        return new Iterator(){
            private int charc=0;

            @Override
            public boolean hasNext()
            {
                return chars.length > charc;
            }

            @Override
            public Object next()
            {  
                return chars[charc++];
            }

        };
    }
}
