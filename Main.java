package praktikum7;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static int[] queue = new int[8];
    private static int counters = 0;

    private static boolean dataLimit() {
        if(counters < queue.length) {
            return true;
        }
        else {
            return false;
        }
    }

    private static void enQueue() {
        int loopX = 0;
        int alpha = 0;
        while(loopX == 0) {
            System.out.print("Masukkan Data (type angka): ");
            Scanner alphaX = new Scanner(System.in);
            try {
                alpha = alphaX.nextInt();
                loopX = 1;
            }
            catch(InputMismatchException e) {
                System.out.println("Masukan harus berupa Angka!");
                loopX = 0;
            }
        }
        queue[counters] = alpha;
        counters++;
    }

    private static void deQueue() {
        counters--;
        for(int i = 0; i < counters; i++) {
            queue[i] = queue[i + 1];
        }
        System.out.println("Data pertama dalam queue sudah dikeluarkan");
    }

    private static void displayDataQueue() {
        System.out.print("Data dalam Queue: ");
        for(int i = 0; i < counters; i++) {
            System.out.print(" ["+i+" => "+queue[i]+"]" );
        }
        System.out.println("");
    }

    private static void clearQueue() {
        counters = 0;
    }

    private static void quitApp() {
        String quitss = "y";
        System.out.print("Keluar dari Program? (Y/T): ");
        quitss = new Scanner(System.in).nextLine();
        if(quitss.equalsIgnoreCase("y")) {
            System.exit(0);
        }
        else {
            menuProgram();
        }
    }

    private static void menuChooser(int inputMenu) {
        switch(inputMenu) {
            case 1:
                boolean check = dataLimit();
                if(check) {
                    enQueue();
                }
                else {
                    System.out.println("Antrian Penuh!, kosongkan data satu terlebih dahulu!");
                }
                break;
            case 2:
                deQueue();
                break;
            case 3:
                System.out.println("Status Storage: ");
                System.out.println("Kapasitas: " + queue.length);
                System.out.println("Terisi   : " + counters);
                break;
            case 4:
                displayDataQueue();
                break;
            case 5:
                clearQueue();
                break;
            case 6:
                quitApp();
                break;
        }
        menuProgram();
    }

    static void menuProgram() {
        int loopX = 0;
        int choosenMenu = 0;
        while(loopX == 0) {
            System.out.println("\nProgram Queue dengan Java");
            System.out.println("Menu: ");
            System.out.println("1. Tambah Queue (enQueue)");
            System.out.println("2. Hapus data terdepan dari Queue (deQueue)");
            System.out.println("3. Status Queue");
            System.out.println("4. Tampilkan data dalam Queue");
            System.out.println("5. Bersihkan Queue");
            System.out.println("6. Keluar dari Program");
            System.out.print("Pilihan Menu (1 - 6) >>> ");
            Scanner menuOption = new Scanner(System.in);
            try {
                choosenMenu = menuOption.nextInt();
                loopX = 1;
            }catch(InputMismatchException e) {
                System.out.println("Masukan harus Angka!");
            }
        }
        System.out.println("");
        menuChooser(choosenMenu);
    }

    public static void main(String[] args) {
        menuProgram();
    }
}