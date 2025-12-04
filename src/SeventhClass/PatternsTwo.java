package SeventhClass;

public class PatternsTwo {
    public static void hellow_rectangle(int totRows, int totCols){
        for (int i=1; i<=totRows; i++){
            for (int j=1; j<=totCols; j++){
                //cell-(i,j)
                if (i==1||i==totRows||j==1||j==totCols){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void half_pyramid(int n){
        for (int i=1; i<=n; i++){
            //spaces
            for (int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            //stars
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void half_pyramid_with_number(int n){
        for (int i=1; i<=n; i++){
            //numbers
            for (int j=1; j<=n-i+1; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void floyds_triangle(int n){
        //counter
        int counter=1;
        for(int i=1; i<=n; i++){
            //inner-how many times will counter be printed
            for (int j=1;j<=i; j++){
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void zero_oneTriangle(int n){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){
                if ((i+j)%2==0){
                    System.out.print("1");
                }else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void butterflyPattern(int n){
        //1st half
        for (int i=1; i<=n; i++){
            //stars - i
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            //spaces - 2*(n-i)
            for (int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            //stars - i
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //2nd half
        for (int i=n; i>=1; i--){
            //stars - i
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            //spaces - 2*(n-i)
            for (int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            //stars - i
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n){
        for (int i=1; i<=n; i++){
            //spaces
            for (int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            //stars
            for (int j=1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void hollow_rhombus(int n){
        for (int i=1; i<=n; i++){
            //spaces
            for (int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            //stars
            for (int j=1; j<=n; j++){
                //cell-(i,j)
                if (i==1||i==n||j==1||j==n){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond_pattern(int n){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for (int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=n; i>=1; i--){
            for (int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for (int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //print hello rectangle pattern
//        hellow_rectangle(4,5);

        //inverted & rotated half-pyramid
//        half_pyramid(7);

        //inverted half-pyramid with numbers
//        half_pyramid_with_number(5);

        //floyd's triangle
//        floyds_triangle(5);

        //0-1 triangle
//        zero_oneTriangle(5);

        //butterfly pattern
//        butterflyPattern(4);

        //solid rhombus
//        solid_rhombus(5);


//        hollow_rhombus(5);

        diamond_pattern(4);
    }
}
