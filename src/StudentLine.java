/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Recitation: 01
 */

/**
 * a fully-documented class named StudentLine which implements an ArrayLst-like data structure based on the final int CAPACITY
 */
public class StudentLine {

    private static final int CAPACITY = 20;

    private Student[] students;

    private int studentCount;

    /**
     * Default constructor which initializes this object to an empty list of Students.
     * PostCondition :
     *              The array students has been initialized, and studentCount has been set to 0
     */
    public StudentLine(){
        students = new Student[CAPACITY];
        studentCount = 0;
    }

    /**
     * This is a getter method that gets the CAPACITY of the StudentLine
     * @return : the capacity of the student line
     */
    public static int getCAPACITY() {
        return CAPACITY;
    }

    /**
     * This is a getter method that gets the number of students on the line
     * @return : the number of students on the line
     */
    public int getStudentCount() {
        return studentCount;
    }

    /**
     * This is a getter method that gets the students on the line
     * @return : an array of the students on the line
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * This is a setter method that sets the number of students
     * @param studentCount :
     *             The name of the student
     */
    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    /**
     * This is a setter method that sets the student line
     * @param students :
     *             The name of the student
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     *
     * @return : Returns the total number of Students in the list.
     * Special Note :
     *            This method should run in O(1) time
     */
    public int numStudents(){
        return studentCount;
    }

    /**
     * This method gets the Student at the given index
     * @param index :
     *              Gets the reference to the Student at the given index
     * @return : Return the Student object at the given index
     * @throws ArrayIndexOutOfBoundsException
     *      Indicating that the given index is invalid
     * Special Note:
     *            The list should remain unchanged
     */
    public Student getStudent(int index) throws ArrayIndexOutOfBoundsException{
        if (index > (studentCount - 1))
            throw new ArrayIndexOutOfBoundsException();
        return students[index];
    }

    /**
     * This method removes the student at a specific index and move all students after this index forward by one index
     * @param index :
     *            Gets the reference to the Student at the given index
     * @return : The student that is being removed
     * @throws ArrayIndexOutOfBoundsException
     *           Indicating that the given index is invalid
     * @throws EmptyLineException
     *          Indicating that there's no student on the line
     */
    public Student removeStudent(int index) throws ArrayIndexOutOfBoundsException, EmptyLineException {

        if (index >= studentCount)
            throw new ArrayIndexOutOfBoundsException();
        if (studentCount  == 0)
            throw new EmptyLineException();

        Student removingStudent = students[index];
        for (int i = index; i < studentCount; i++)
            students[i] = students[i + 1];

        studentCount--;
        return removingStudent;
    }

    /**
     * This method adds a student at the given index, moving all other students behind the current student back one index
     * @param index :
     *              The index of which the students is to be added to
     * @param student :
     *               The student that is being added to the line
     * @throws InvalidArgumentException
     *          Indicating that the index is too high and will create a hole in the array
     * @throws DeanException
     *          Indicating that the lunch line is full
     */
    public void addStudent(int index, Student student)  throws InvalidArgumentException, DeanException {
        if(index > studentCount || index < 0)
            throw new InvalidArgumentException();
        if (studentCount == 20)
            throw new DeanException();

        for (int i = studentCount; i > index; i--)
            students[i] = students[i-1];

        students[index] = student;
        studentCount++;

    }

    /**
     * This method swaps the two students at the given indices
     * @param index1 :
     *               The index of one of the students that is doing the swap
     * @param index2 :
     *               The index of the other student that is doing the swap
     * PreCondition  :
     *               The two indices must be valid
     * @throws ArrayIndexOutOfBoundsException
     *          Indicates that at least one of the given index is invalid
     * Special Note :
     *          The list should be unchanged if either index was invalid
     */
    public void swapStudents(int index1, int index2){
        if (index1 > (studentCount-1) | index2 > (studentCount-1))
            throw new ArrayIndexOutOfBoundsException();

        Student tempStudent = students[index1];
        students[index1] = students[index2];
        students[index2] = tempStudent;
    }

    /**
     * This method creates a deep copy of this StudentLine object
     * @return : A copy of the student line
     * Special Note :
     *          If the copy is modified, the object should remain unmodified
     *          All the students inside the array should be deep copied as well
     */
    public StudentLine clone(){
        StudentLine newStudentLine = new StudentLine();



        newStudentLine.setStudents(this.students);

        for (int i = 0; i < studentCount; i++){
            try {
                newStudentLine.addStudent(i,getStudent(i).clone());
            } catch (InvalidArgumentException | DeanException e) {
                e.getMessage();
            }
        }

//        newStudentLine.setStudentCount(this.studentCount);
        return newStudentLine;

    }

    /**
     * This method compares if two student lines are equal
     * @param line :
     *             The student line that is being compared to this line
     * @return :
     *          True if the two lines are the same
     *          False if the lines are not hte same
     */

    private boolean lineComparison(Student[] line){
        for(int i = 0; i < studentCount; i++){
            boolean bool = this.students[i].equals(line[i]);
            if (!bool)
                return false;
        }
        return true;
    }

    /**
     * This method checks if this StudentLine is equal to another object
     * @param o :
     *          The object that is being compared to this student line
     * @return :
     *          True if the two StudentLine are equal to each other
     *          False if the two StudentLine are not equal to each other
     *  Special Note :
     *          If the o is not of the type StudentLine, the method should return false
     */
    public boolean equals(Object o){
        if(o instanceof StudentLine){
            StudentLine comparedLine = (StudentLine) o;
            if (studentCount == comparedLine.getStudentCount()){
                return this.lineComparison(comparedLine.getStudents());
            }
            else{
                return false;
            }
        }
        else
            return false;
    }

    /**
     * The method converts the StudentLine object to string
     * @return : A string representation of the StudentLine object
     */
    public String toString(){
        StringBuilder studentLine = new StringBuilder();
        for (int i = 0; i < studentCount; i++){
            studentLine.append(String.format("%s. %s        $%.2f \n", i+1, students[i].getName(),students[i].getMoney()));
        }
        return studentLine.toString();
    }
}
