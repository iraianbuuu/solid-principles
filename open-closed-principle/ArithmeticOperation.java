public interface ArithmeticOperation {
    double calculate(double a , double b);
}

class Addition implements ArithmeticOperation {
    @Override
    public double calculate(double a , double b){
        return a + b;
    }
}

class Subtraction implements ArithmeticOperation {
    @Override
    public double calculate(double a , double b){
        return a - b;
    }
}

class Multiplication implements ArithmeticOperation { 
    @Override
    public double calculate(double a , double b){
        return a * b;
    }
}