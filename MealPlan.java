public class MealPlan{
    
    private String studentName, studentID, schoolName;
    private double mealPlan, dailybudget; // mealPlan - total balance.
    private int length; //duration of your meal plan in days (is it per term or year ?).
    private double totalSpent, spentPerDay;
    private int currentDay; //relatively to the starting day of using the meal plan.

    /* Constructor method.
        @param amount - total balance on your meal plan.
        @param days - duration of the meal plan.
    */
    public MealPlan(String school, String name, String ID, double amount, int days){
        schoolName = school;
        studentName = name;
        studentID = ID;
        mealPlan = amount;
        length = days;
        dailybudget = mealPlan/length;
        totalSpent = 0;
        spentPerDay = 0;
        currentDay = 0;
    }

    // Several accessor methods
    public String getSchoolName(){
        return schoolName;
    }

    public String getName(){
        return studentName;
    }

    public String getID(){
        return studentID;
    }

    public double getTotalBalance(){
        return mealPlan;
    }

    public double getDailyBudget(){
        return dailybudget;
    }

    public double getTotalAmountSpent(){
        return totalSpent;
    }

    public double getAmountSpentToday(){
        return spentPerDay;
    }

    public double getRemainingPerDay(){
        return dailybudget - spentPerDay;
    }

    public double getRemainingAmount(){
        return mealPlan - totalSpent;
    }

    /*Mutator method to change type of the meal plan with a different balance.
    @param amount - new total balance of the meal plan.
    */
    public void changeMealPlan(double amount){
        mealPlan = amount;
        dailybudget = amount/length;
    }

    /* Executed when a student buys a meal.
       @param price - price of the meal bought.
    */
    public void buyMeal(double price){
        spentPerDay += price;
        totalSpent += price;
        if (spentPerDay >= dailybudget){    // Notification to the user when the daily budget spent totally.
            System.out.println("YOU HAVE USED YOUR ENTIRE BUDGET FOR THE DAY!!!");
        }
        else if (spentPerDay >= 0.8*dailybudget){ //Notification to the user when 20% of daily budget left.
            System.out.println("LOW DAILY BALANCE!!!");
            displayRemainingForDay();
        }
    }

    // Shows general information about the meal plan.
    public void display(){
        System.out.printf ("%s - %s [%s] - Type: %.2f $ %n", schoolName, studentName, studentID, mealPlan);
    }

    // Shows the remaining balance left for the day.
    public void displayRemainingForDay(){
        if (spentPerDay > dailybudget){
            System.out.printf ("You exceeded daily budget by %.2f $ %n",Math.abs(getRemainingPerDay()));
        }
        else System.out.printf ("Remaining daily balance is %.2f $ %n", getRemainingPerDay());
    }

    // Shows the remaining total balance on the meal plan.
    public void displayTotalAmountRemaining(){
        if (totalSpent > mealPlan){
            System.out.printf ("You exceeded your total balance by %.2f $ %n", Math.abs(getRemainingAmount()));
        }
        else System.out.printf ("Remaining total balance is %.2f $ %n",getRemainingAmount());
    }

    // Executed when the next day comes.
    // Ideally should be synchronized with the calander.
    public void nextDay(){
        if (currentDay > length){
            System.out.println("Your meal plan ended");
        }
        currentDay ++;
        spentPerDay = 0;
        
    }
}