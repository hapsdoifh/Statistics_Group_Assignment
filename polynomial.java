import java.util.Arrays;

public class Polynomial{

    public double[] array;
    Polynomial(double[] userInput){
    array = userInput;
  }
    public String polynomial = "";
  
    public int arrayLength(double[] userArray){
        return userArray.length;
    }

    //getters

    public String getPolynomial() {
      for (int i = 0; i < array.length; i++) {
        if (i <= array.length - 2) {
          polynomial = polynomial + array[i] + "x^" + (array.length - (i + 1)) + "+ ";
        } else {
          polynomial = polynomial + array[i] + "x^" + (array.length - (i + 1));
        }
      }
        return polynomial;
  }
}
