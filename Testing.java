public class Testing {

    public static void main(String[] args) {

        Zip z = new Zip("postnummer.csv");

        Zip.Node t = z.linearSearch("164 46");
        if (t != null)
            System.out.println(t.stringify());

    }
    
}

