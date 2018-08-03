import java.util.Scanner;

public class JavaWeekTwo {
    public static void main ( String args [] ) {
        /*
        // 第一題
        expression();

        // 第二題
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Please enter a postive num : " );
        int num = scanner.nextInt();
        scanner.close();

        printFac ( num , factor ( num ) ) ;

        //題數間的分隔換行
        System.out.println( " " );

        // 第三題
        perfectNum ();

        // 第四題
        amstrongNum ();

        // 第五題
        primeNum ();

        // 第六題
        ropeDays();

        // 第七題
        rabbitCounts ( );

        // 第八題
        password ( );

        // 第九題
        stars ( );

        // 第十題
        nineNine () ;

        // 第十一題
        interest ( );
        */
    }

    private static void expression (){
        int start = 1 , end = 50;
        int result = 0 ;

        for ( int i = start ; i <= end ; i++ ){
            if ( i % 2 == 1 )
                result += Math.pow ( i , 2 ) ;
            else
                result -= Math.pow ( i , 2 ) ;
        }

        System.out.println(result);

    }

    private static boolean[] factor ( int num ){
        boolean[] storeFac = new boolean[num + 1];
        storeFac [1] = true;
        for ( int i = 2 ; i <= num ; i++ )
            if ( num % i == 0 )
                storeFac[i] = true;

        return storeFac;
    }

    private static void printFac ( int num , boolean [] storeFac ){
        System.out.printf( "Factor(s) of %d : " , num );
        for ( int i = 1 ; i <= num ; i++ ) {
            if ( i == 1 )
                System.out.printf("1 ", i);
            else if (storeFac[i] == true)
                System.out.printf(", %d ", i);
        }
        System.out.print("\n");
    }

    private static boolean facSum ( int num , boolean [] storeFac ){
        int result = 0;
        for ( int i = 1 ; i < num ; i++ )
            if ( storeFac [i] == true )
                result += i;

        if ( result == num )
            return true;
        else
            return false;
    }

    private static void perfectNum (){
        final int PERFECT_NUM_MAX_INTERVAL = 100;

        for ( int i = 2 ; i <= PERFECT_NUM_MAX_INTERVAL ; i++ ) {
            if (facSum(i, factor(i))) {
                boolean[] storePerFacs = factor(i);
                printFac(i, storePerFacs);
                System.out.printf("%d = 1", i);
                for (int i2 = 2; i2 < i; i2++)
                    if (storePerFacs[i2] == true)
                        System.out.printf(" + %d", i2);
                System.out.printf(" , so %d is a perfect number.\n\n", i);
            }
        }
    }

    private static void amstrongNum (){
        final int three_digit_start = 100 , three_digit_end = 999;

        for ( int i = three_digit_start ; i <= three_digit_end ; i++ )
            if ( Math.pow ( i / 100  , 3 ) + Math.pow ( ( ( i % 100 ) / 10 ) , 3 ) + Math.pow ( i % 10 , 3 ) == i )
                System.out.println( i );

    }

    private static void primeNum (){
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Please enter a postive num to find all prime numbers inside : " );
        int num = scanner.nextInt();
        scanner.close();

        System.out.printf( "Prime numbers between 1 - %d : " , num );
        for ( int i = 2 ; i <= num ; i++ )
            if ( primeJudge ( i , factor ( i ) ) == true )
                System.out.printf( "%d " , i );

        System.out.println( " " );
    }

    private static boolean primeJudge ( int num , boolean [] storeFac ){
        for ( int i = 2 ; i < num ; i++ )
            if ( storeFac [ i ] == true )
                return false;

        return true;
    }


    private static void ropeDays ( ){
        final int rope_Min = 5 , rope_length = 3000;
        double ropeChange = (double)rope_length;
        int dayCount = 0;

        while ( ropeChange >= rope_Min ){
            ropeChange /= 2.0;
            dayCount++;
        }

        System.out.printf( "Need %d days for a %d rope less then %d." , dayCount , rope_length , rope_Min );
    }

    private static void rabbitCounts ( ){
        final int [] dividers   = { 0 , 3 , 5 , 7 };
        final int [] remainders = { 0 , 1 , 3 , 2 };

        final int [] p1 = { 0 , dividers[2] * dividers[3] , dividers[1] * dividers[3] , dividers[1] * dividers[2] };
        int [] p2 = { 0 , 1 , 1 , 1 };

        for ( int i = 1 ; i <= 3 ;i++ )
            while ( true ){
                if ( ( p1 [ i ] * p2 [ i ] ) % dividers [ i ] == remainders[ i ] )
                    break;
                p2[ i ] += 1;
            }

        int realNum = ( ( p1[1] * p2[1] ) + ( p1[2] * p2[2] ) + ( p1[3] * p2[3] ) ) % ( dividers[1] * dividers[2] * dividers[3] );

        System.out.println( realNum );
    }

    private static void password ( ){
        final int tryNum = 3;
        final String correctPass = "123pass" ;
        boolean correctCheck = false;

        Scanner scanner = new Scanner(System.in);

        for ( int i = 1 ; i <= tryNum ; i++ ) {
            System.out.print("Please enter password : ");
            String storeInput = scanner.nextLine();

            if ( storeInput.equals( correctPass ) ) {
                System.out.println("Correct password!! Welcome to use this system!!");
                correctCheck = true;
                break;
            }
        }

        scanner.close();

        if ( correctCheck == false )
            System.out.printf("over %d times trying to enter !!\n" , tryNum );
    }

    private static void stars ( ) {
        final int layers = 5;
        final int oddNum = 9;

        for ( int i = 1 ; i <= layers ; i++ ) {
            for (int i2 = 1; i2 <= i; i2++)
                System.out.printf("*");
            System.out.println(" ");
        }

        System.out.println(" ");

        for ( int i = layers ; i >= 1 ; i-- ) {
            for (int i2 = 1; i2 <= i; i2++ )
                System.out.printf("*");
            System.out.println(" ");
        }

        System.out.println(" ");

        for ( int i = 1 ; i <= oddNum ; i = i + 2 ) {
            for (int i2 = 1 ; i2 <= ( ( oddNum - i ) / 2 ) ; i2++)
                System.out.printf(" ");

            for (int i3 = 1; i3 <= i; i3++)
                System.out.printf("*");
            System.out.println(" ");
        }
    }

    private static void nineNine ( ) {
        final int tableNum = 9;

        System.out.printf("%4s","|");
        for ( int i = 1 ; i <= tableNum ; i++ )
            System.out.printf("%4d", i);


        System.out.printf("\n--------------------------------------------\n");

        for ( int i = tableNum ; i >= 1 ; i-- ) {
            for ( int i2 = 0 ; i2 <= i ; i2++ ) {
                if ( i2 == 0 ) {
                    System.out.printf("%2d", i);
                    System.out.printf(" |");
                }
                else
                    System.out.printf( "%4d", ( i * i2 ) );
            }
            System.out.println( "\n" );
        }
    }

    private static void interest ( ) {
        final int p1 = 100000 , p2 = 100000 ;
        final double i1 = 0.1 , i2 = 0.05;
        int p1_temp = p1 , p2_temp = p2 ;
        int yearCount = 1;

        while ( true ){
            if ( ( p1_temp * ( 1.0 + ( i1 * yearCount ) ) ) < ( p2_temp * Math.pow( 1.0 + i2 , yearCount ) ) )
                break;
            yearCount++;
        }
        System.out.println( yearCount );
    }
}
