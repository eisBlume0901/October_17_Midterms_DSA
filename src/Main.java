//import java.util.*;
//public class Main{
//    static Scanner sc = new Scanner(System.in);
//    static Stack<Person> stack01 = new Stack<>();
//    static Stack<Person> stack02 = new Stack<>();
//    public static void main(String[] args) {
//        getUserDetails();
//    }
//    public static void getUserDetails(){
//        System.out.println("Enter the number of people you would be adding:");
//        String n = sc.nextLine();
//
//        while(!n.matches("[0-9]+")){
//            System.out.println("Only input numbers");
//            n = sc.nextLine();
//        }
//        int numOfPeople = Integer.parseInt(n);
//
//        for(int i = 0; i < numOfPeople; i++){
//            System.out.println("Enter the name of person " + (i + 1) + " :");
//            String name = sc.nextLine();
//            System.out.println("Please enter your age:");
//            int age = sc.nextInt();
//            if(name.trim().isEmpty()){
//                System.out.println("Name cannot be empty. Pls try again");
//                i--;
//            }
//            char firstLetter = name.trim().charAt(0);
//
//            if((firstLetter >= 'A' && firstLetter <= 'M') || (firstLetter >= 'a' && firstLetter <= 'm')){
//                stack01.push(new Person(name, age));
//            }else{
//                stack02.push(new Person(name, age));
//            }
//        }
//        System.out.println("\nPeople whose names start with the first 13 letters of the alphabet:");
//        while(!stack01.isEmpty()){
//            System.out.println(stack01.pop());
//        }
//        System.out.println("\nPeople whose names start with the last 13 letters of the alphabet:");
//        while(!stack02.isEmpty()){
//            System.out.println(stack02.pop());
//        }
//    }