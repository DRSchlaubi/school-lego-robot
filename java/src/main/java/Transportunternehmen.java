public class Transportunternehmen {
    public static void main(String[] args) {
        final Transport transport1 = new Transport(1);
        final Transport transport2 = new Transport(new int[]{1, 2, 3});
        transport1.print();
        System.out.println("********************************");
        transport2.print();
    }
}
