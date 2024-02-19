import java.util.*;
public class randomNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter range from 1 to: ");
        int n=sc.nextInt();
        int turn=1;
        int won=0;
        do{
            int random=(int)(Math.random() * n) + 1; 
            System.out.println("\nturn: "+turn);
            System.out.print("enter your guess: ");
            int guess=sc.nextInt();
            if(guess==random){
                System.out.println("Congrats you guessed it right");
                won++;
            }else if(guess<random){
                System.out.println("OOPS wrong guess it's too low");
            }else{
                System.out.println("OOPS wrong guess it's too high");
            }
            System.out.println("random num is: "+random);
            turn++;
        }while(turn<6);
        System.out.println("turn over\n");
        System.out.println("Result:");
        System.out.println("Num of turns: "+(turn-1));
        System.out.println("winning streak: "+won);
    }
}
