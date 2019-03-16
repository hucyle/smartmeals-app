import java.util.Scanner;

public class MealPlanTester{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        // User entering their person info during registration.
        System.out.println("Enter your meal plan information:");
        System.out.print("Your school: ");
        String school = in.nextLine();
        System.out.print("Your name: ");
        String name = in.nextLine();
        System.out.print("Your student ID: ");
        String ID = in.next();
        System.out.print("Enter your total meal plan amount: ");
        double mealplanprice = in.nextDouble();
        System.out.print("Duration in days: ");
        int duration = in.nextInt();
        
        //Creating MealPlan object of the user with the information entered. 
        MealPlan myMealPlan = new MealPlan(school, name, ID, mealplanprice, duration);
        
        //Commands that can be entered.
        while (in.hasNext()){
            switch (in.next()){
                case "SHOW": 
                    //displays general information, remaining balance for the day, and total remaining balance.
                    myMealPlan.display();
                    myMealPlan.displayRemainingForDay();
                    myMealPlan.displayTotalAmountRemaining();
                    break;
                case "BUY": 
                    //Imitates user buying a meal.
                    myMealPlan.buyMeal(in.nextDouble());
                    break;
                case "NEXT": 
                    //Called when the next day comes.
                    myMealPlan.nextDay();
                    break;
                case "Q": 
                    //Quits the program.
                    return;
                default:
                    //Better error handling should be used.
                    System.out.println("Invalid input");
                    break;
            }    
        }
        in.close();
    }

    
}