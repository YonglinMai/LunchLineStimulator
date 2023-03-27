/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Recitation: 01
 */

/**
 * a fully-documented class named Student which contains the name of the student (String),
 * and how much lunch money the student has brought (double).
 */
public class Student {

    private String name;
    private double money;

    /**
     * This is a constructor that creates a new student object with the name and money initialized
     * @param name :
     *             The name of the new student
     * @param money :
     *              The lunch money balance of the student
     * PostCondition :
     *              This student has been initialized a name and a lunch money balance
     */
    public Student(String name, double money){
        this.name = name;
        this.money = money;
    }

    /**
     * This is a getter method that gets the name of the Student
     * @return : the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * This is a getter method that gets the lunch money balance of the Student
     * @return : the lunch money balance of the student
     */
    public double getMoney() {
        return money;
    }

    /**
     * This is a setter method that sets the name of the student
     * @param name :
     *             The name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a setter method that sets the name of the student
     * @param money :
     *             The lunch money balance of the student
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * This is a method that compares two students to see if they are the same student
     * @param obj :
     *            The student that is being compared to this student
     * Precondition :
     *            The parameter is a student object
     * PostConditions :
     *            Return true if the two students are the same
     *            Return false if the two students are not the same
     * Special Note :
     *            Return false if obj is null or is not a Student object
     */
    public boolean equals(Object obj){
        if (obj instanceof Student){
            Student student = (Student) obj;
            return (student.getName().equals(name)) &&
                    (student.getMoney() == money);

        }
        else
            return false;
    }

    /**
     * Generates a copy of this student
     * @return : The return value is a copy of this student
     * Special Note :
     *              The return value must be typecast to a student object
     */
    public Student clone(){
        Student newStudent = new Student(this.getName(), this.getMoney());
        return newStudent;
    }

    /**
     * This method generates a string representation of this Student object
     * @return : A string representation of this Student object
     */
    public String toString(){
        return name + " has " + "$" + money;
    }
}
