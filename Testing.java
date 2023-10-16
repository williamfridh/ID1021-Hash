public class Testing {

    public static void main(String[] args) {

        ZipFour z = new ZipFour("postnummer.csv");

        //Zip.Node t = z.linearSearch("164 46");
        //if (t != null)
        //    System.out.println(t.stringify());

        /*ZipFour.Node tt = z.lookup(16446);
        if (tt != null)
            System.out.println(tt.stringify());
        ZipFour.Node ttt = z.lookup(98499);
        if (ttt != null)
            System.out.println(ttt.stringify());*/

        Integer[] zips = {11115, 98499};
        int tries = 200000;
        benchmarkThree(z, zips, tries);

        ZipFive zz = new ZipFive("postnummer.csv");
        benchmarkFour(zz, zips, tries);

    }



    static void benchmarkOne(ZipTwo z, Integer[] zips, int tries) {

        System.out.printf("Zip\t\tLinear\t\tBinary\t\tRatio\n");

        for (Integer zip : zips) {

            System.gc();
            
            double best_linear = Double.MAX_VALUE;
            double best_binary = Double.MAX_VALUE;
            double n0,n1,n;

            // Warm up.
            for (int i = 0; i < 100; i++) {
                z.linearSearch(zip);
                z.binarySearch(zip);
            }

            // Meassuring.
            for (int j = 0; j < tries; j++) {

                n0 = System.nanoTime();
                z.linearSearch(zip);
                n1 = System.nanoTime();
                n = n1 - n0;
                if (n < best_linear)
                    best_linear = n;

                n0 = System.nanoTime();
                z.binarySearch(zip);
                n1 = System.nanoTime();
                n = n1 - n0;
                if (n < best_binary)
                    best_binary = n;

            }
            System.out.printf("%s\t&\t%.0f\t&\t%.0f\t&\t%.2f\n", zip, best_linear, best_binary, best_linear/best_binary);
        }

    }



    static void benchmarkTwo(ZipThree z, String[] zips, int tries) {

        System.out.printf("Zip\t\tLookup\n");

        for (String zip : zips) {

            //System.gc();
            
            double best_lookup = Double.MAX_VALUE;
            double n0,n1,n;

            // Warm up.
            for (int i = 0; i < 100; i++) {
                z.lookup(zip);
            }

            // Meassuring.
            for (int j = 0; j < tries; j++) {

                n0 = System.nanoTime();
                z.lookup(zip);
                n1 = System.nanoTime();
                n = n1 - n0;
                if (n < best_lookup)
                    best_lookup = n;

            }
            System.out.printf("%s\t&\t%.0f\n", zip, best_lookup);
        }

    }



    static void benchmarkThree(ZipFour z, Integer[] zips, int tries) {

        System.out.printf("Zip\t\tLookup\n");

        for (Integer zip : zips) {

            //System.gc();
            
            double best_lookup = Double.MAX_VALUE;
            double n0,n1,n;

            // Warm up.
            for (int i = 0; i < 100; i++) {
                z.lookup(zip);
            }

            // Meassuring.
            for (int j = 0; j < tries; j++) {

                n0 = System.nanoTime();
                for (int k = 0; k < 1000; k++)
                    z.lookup(zip);
                n1 = System.nanoTime();
                n = n1 - n0;
                if (n < best_lookup)
                    best_lookup = n;

            }
            System.out.printf("%s\t&\t%.0f\n", zip, best_lookup);
        }

    }



    static void benchmarkFour(ZipFive z, Integer[] zips, int tries) {

        System.out.printf("Zip\t\tLookup\n");

        for (Integer zip : zips) {

            //System.gc();
            
            double best_lookup = Double.MAX_VALUE;
            double n0,n1,n;

            // Warm up.
            for (int i = 0; i < 100; i++) {
                z.lookup(zip);
            }

            // Meassuring.
            for (int j = 0; j < tries; j++) {

                n0 = System.nanoTime();
                for (int k = 0; k < 1000; k++)
                    z.lookup(zip);
                n1 = System.nanoTime();
                n = n1 - n0;
                if (n < best_lookup)
                    best_lookup = n;

            }
            System.out.printf("%s\t&\t%.0f\n", zip, best_lookup);
        }

    }
    
}

