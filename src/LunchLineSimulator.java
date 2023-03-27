/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Recitation: 01
 */

import java.util.Scanner;

/**
 * a fully-documented class named LunchLineSimulator which creates two instances of the StudentLine object
 * and provides an interface for a user to manipulate the list.
 */
public class LunchLineSimulator {

    private static StudentLine realityA;
    private static StudentLine realityB;

    private static final String[] menu = new String[] {
            "A) Add a student to the line at the end.",
            "C) Have a new student cut a friend.",
            "T) Have two students trade places.",
            "B) Have the bully remove a student.",
            "U) Update a student's money amount.",
            "S) Serve a student.",
            "P) Print the current reality's lunch line.",
            "O) Switch to the other reality.",
            "E) Check if the realities are equal.",
            "D) Duplicate this reality into the other reality.",
            "Q) Quit middle school and move on to real life."
    };

    /**
     * This is a getter method that gets student line reality A
     * @return : the student line in reality A
     */
    public StudentLine getRealityA() {
        return realityA;
    }

    /**
     * This is a getter method that gets student line reality B
     * @return : the student line in reality B
     */
    public StudentLine getRealityB() {
        return realityB;
    }


    /**
     * This is a setter method that sets the student line in reality B
     * @param realityB :
     *             The student line in reality B
     */
    public void setRealityB(StudentLine realityB) {
        this.realityB = realityB;
    }


    /**
     * This is a setter method that sets the student line in reality A
     * @param realityA :
     *             The student line in reality A
     */

    public void setRealityA(StudentLine realityA) {
        this.realityA = realityA;
    }
    public static void displayMenu(String[] menu){
        for (int i = 0; i < menu.length; i++){
            System.out.println(menu[i]);
        }
    }
    /**
     * The main method executes the entire program, allowing users to manipulate the lunch line.
     */
    public static void main(String[] args) throws DeanException, InvalidArgumentException, EmptyLineException {

        realityA = new StudentLine();
        realityB = new StudentLine();

        String reality = "A";

        System.out.println(
                "Welcome to the Middle School where you are the master of the lunch line, " +
                        "and you may subject your angsty kids to whatever form of culinary torture best fits your mood. " +
                        "You are in Reality " + reality
        );
        System.out.println();

        String option;
        do {
            displayMenu(menu);
            Scanner input = new Scanner(System.in);
            System.out.println("Please select an option: ");
            option = input.nextLine();

            switch (option.toUpperCase()) {
                case "A":
                    try{
                        System.out.println("Please enter student name: ");
                        String name = input.nextLine();
                        System.out.println("Please enter money amount: ");
                        double money = input.nextDouble();
                        while(money < 0) {
                            System.out.println("You can't be in debt, please enter a positive number: ");
                            money = input.nextDouble();
                        }
                        Student newStudent = new Student(name, money);
                        if (reality.equals("A")){
                            realityA.addStudent(realityA.getStudentCount(), newStudent);

                            System.out.println(name +
                                    " has been added to the line in position " +
                                    realityA.getStudentCount() +
                                    ", " +
                                    newStudent.toString()
                            );
                        }
                        else{
                            realityB.addStudent(realityB.getStudentCount(), newStudent);

                            System.out.println(name +
                                    " has been added to the line in position " +
                                    realityB.getStudentCount() +
                                    ", " +
                                    newStudent.toString()
                            );
                        }

                    }

                    catch(InvalidArgumentException | DeanException a){
                        System.out.println(a.getMessage());
                    }

                    break;

                case "C":
                    try{
                        System.out.println("Please enter student name: ");
                        String name = input.nextLine();
                        System.out.println("Please enter money amount: ");
                        double money = Double.parseDouble(input.nextLine());
                        System.out.println("Please enter position: ");
                        int position = input.nextInt();


                        Student newStudent = new Student(name, money);
                        if (reality.equals("A")){
                            realityA.addStudent(position - 1, newStudent);

                        }
                        else{
                            realityB.addStudent(position - 1, newStudent);

                        }
                        System.out.println(name +
                                " has been added to the line in position " +
                                position +
                                ", " +
                                newStudent.toString()
                        );
                    }

                    catch(InvalidArgumentException | DeanException a){
                        System.out.println(a.getMessage());
                    }

                    break;
                case "T":
                    try{
                        System.out.println("Please enter student1 position: ");
                        int index1 = input.nextInt();
                        System.out.println("Please enter student2 position: ");
                        int index2 = input.nextInt();

                        if (reality.equals("A")){
                            realityA.swapStudents(index1 - 1, index2 - 1);
                            System.out.println(
                                    realityA.getStudent(index1 - 1) + "at position " + index1 +
                                            " has traded places with " +
                                            realityA.getStudent(index2 - 1) + "at position " + index2
                            );
                        }
                        else {
                            realityB.swapStudents(index1 - 1, index2 - 1);
                            System.out.println(
                                    realityB.getStudent(index1 - 1) + "at position " + index1 +
                                            " has traded places with " +
                                            realityB.getStudent(index2 - 1) + "at position " + index2
                            );
                        }
                    }catch(ArrayIndexOutOfBoundsException a){
                        System.out.println(a.getMessage());
                    }
                    break;
                case "B":
                    try{
                        System.out.println("Please enter student position: ");
                        int index = input.nextInt() - 1;
                        if (reality.equals("A")) {
                            System.out.println("The bully removed " + realityA.removeStudent(index).getName() + "at position " + (index+1) + " from the line.");
                        }
                        else {
                            System.out.println("The bully removed " + realityB.removeStudent(index).getName() + "at position " + (index+1) + " from the line.");
                        }
                    }

                    catch (ArrayIndexOutOfBoundsException | EmptyLineException a){
                        System.out.println(a.getMessage());
                    }

                    break;
                case "U":
                    System.out.println("Please enter student position: ");
                    int index = input.nextInt() - 1;
                    System.out.println("Please enter money amount: ");
                    double updatingMoney = input.nextDouble();

                    Student updatingStudent;

                    if (updatingMoney > 0){

                        if (reality.equals("A")){
                            updatingStudent = realityA.getStudent(index);
                        }
                        else {
                            updatingStudent = realityB.getStudent(index);
                        }

                        System.out.println("your balance has been updated to " + updatingMoney);
                        updatingStudent.setMoney(updatingMoney);

                    }
                    else{
                        System.out.println("You can't have debt in middle school. The lunch line was not updated");
                    }
                    break;
                case "S":
                    try{
                        if (reality.equals("A")){
                            System.out.println(
                                    realityA.removeStudent(0) +
                                            " has been served lunch, We hope he lives to see another day!"
                            );
                        }
                        else{
                            System.out.println(
                                    realityB.removeStudent(0) +
                                            "has been served lunch, We hope he lives to see another day!"
                            );
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException | EmptyLineException a){
                        System.out.println(a.getMessage());
                    }

                    break;
                case "P":
                    if (reality.equals("A")){
                        System.out.println("Lunch line in reality A");
                        System.out.println(realityA.toString());
                    }
                    else{
                        System.out.println("Lunch line in reality B");
                        System.out.println(realityB.toString());
                    }
                    break;
                case "O":
                    if (reality.equals("A"))
                        reality = "B";
                    else
                        reality = "A";

                    System.out.println("You are now in reality " + reality);
                    break;
                case "E":
                    if (realityA.equals(realityB) )
                        System.out.println("The realities are equal.");
                    else
                        System.out.println("The realities are not equal.");
                    break;
                case "D":
                    if (reality.equals("A"))
                        realityB = realityA.clone();
                    else
                        realityA = realityB.clone();
                    break;
                case "Q":
                    System.out.println(
                            "You are now leaving the Middle School Lunch Line Simulator. " +
                            "We congratulate you on your decision to do something more productive with your time."
                    );
            }
        } while (!option.equalsIgnoreCase("Q"));
    }
}
