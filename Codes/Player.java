package player;

import java.util.*;

public class Player {
    String name;
    String number;
    String email;
    String address;
    int age;

    public void setPlayerDetails(String name, String address, String number, String email, int age) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.address = address;
        this.email = email; 
    }

    public void setPlayerName (String name) {
        this.name = name;
    }

    public String getplayername() {
      return this.name;
   }


    public void getplayerdetails() {
    System.out.println("Player name: " + this.name);
    System.out.println("Player age: " + this.age);
    System.out.println("Player contactNo. : " + this.number);
    System.out.println("Player emailId: "  + this.email);
    System.out.println("Player address: " + this.address);
    }


    public  void  setdetails(Player p){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter player details:");
        System.out.println("Enter the player name: ");
        String name= sc.nextLine();
        System.out.println("Enter the player contact number:");
        String number=sc.nextLine();
        System.out.println("Enter the player address:");
        String address=sc.nextLine();
        System.out.println("Enter the player email id:");
        String email=sc.nextLine();
        System.out.println("Enter the player age");
        int age=sc.nextInt();
        
        
        p.setPlayerDetails(name, address, number, email, age);
        

    }

}
