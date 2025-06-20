public class MathOperation {
    /**
     * This method violates the Open-Closed Principle.
     * To add new operations like multiplication, we would need to modify
     * the existing switch statement, making the code open for modification
     * rather than extension.
     */
    public double calculate(double a , double b , String operations){
        switch(operations){
            case "+" :
                return a + b ;
            case "-" : 
                return a - b;
            default : 
                throw new IllegalArgumentException("Invalid operations!!!");
        }
    }
}