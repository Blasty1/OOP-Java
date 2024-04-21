public class App {
    public static void main(String[] args) throws Exception {
        Letters t = new Letters("bruno");

        for(Object s : t)
        {
            Character c = (Character) s;
            System.out.println(c);
        }
        System.out.println("Hello, World!");
    }
}
