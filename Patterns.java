class Pattern {
    public static void main(String[] args) {
        int n = 4;
        // pattern1(n);
        // pattern7(n);
        // pattern8(n);
        // pattern9(n);
        // pattern10(n);
        // pattern11(n);
        // pattern12(n);
        // pattern13(n);
        // pattern14(n);
        // pattern15(n);
        // pattern16(n);
        // patter17Upper(n);
        // pattern17Lower(n);
        // pattern19(n);
        pattern20(n);

    }

    public static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern7(int n) {
        for (int i = 0; i <= i; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("|");
            }
            for (int l = 0; l < (2 * n - (2 * i)); l++) {
                System.out.print("*");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern9(int n) {
        for (int i = 0; i < n; i++) {
            int start = i % 2 == 0 ? 1 : 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
    }

    public static void pattern10(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for (int l = 0; l < 2 * n - (2 * i); l++) {
                System.out.print(" ");
            }

            for (int k = i; k >= 1; k--) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    public static void pattern11(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num);
                num++;
            }
            System.out.println();
        }
    }

    public static void pattern12(int n) {
        for (int i = 0; i < n; i++) {
            char character = 'A';

            for (int j = 0; j <= i; j++) {
                System.out.print(character);
                character++;
            }
            System.out.println();
        }
    }

    public static void pattern13(int n) {
        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j <= 'A' + (n - 1 - i); j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        /*
        Output:
        A B C D
        A B C
        A B
        A
         */
    }

    public static void pattern14(int n) {
        char ch = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(ch);
            }
            ch++;
            System.out.println();
        }
        /*
        Output:
        A
        B B
        C C C
        D D D D
        E E E E E

         */
    }

    public static void pattern15(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            char ch = 'A';

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(ch);
                if (k < i) {
                    ch++;
                } else {
                    ch--;
                }
            }

            for (int l = 0; l < n - i; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        /*
        Output:
             A
           A B A
         A B C B A
         */
    }

    public static void pattern16(int n) {
        for (int i = 0; i < n; i++) {
            char character = (char) ('A' + (n - 1));
            for (char ch = (char) (character - i); ch <= character; ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }

        /*
        Output:
        E
        D E
        C D E
        B C D E
        A B C D E
         */
    }

    public static void patter17Upper(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }

            for(int l=0;l<2*i;l++){
                System.out.print(" ");
            }


            for(int k=0;k<n-i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern17Lower(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }

            for (int l = 0; l < (2 * n - 2) - (2 * i); l++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern19(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n-1) {
                    System.out.print("*");
                } else {
                    if(j==0 || j==n-1){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }

                }
            }
            System.out.println();
        }
    }

    public static void pattern20(int n){
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
                int top = i;
                int left=j;
                int right=(2*n-2)-j;
                int bottom =(2*n-2)-j;
                int min = Math.min(Math.min(top,bottom),Math.min(left,right));
                System.out.print(min+" ");
            }
            System.out.println();
        }
    }
}