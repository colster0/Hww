package hw4;



import java.math.BigInteger;


public class BigIntt {
    private BigInteger value;
//constructor
    public BigIntt(BigInteger value) {
    	//check if null if not throw exception
        if (value == null) {
        	
        	// thro illegal argument exception if 
            throw new IllegalArgumentException("BigInteger value cannot be null");
        }
        this.value = value;
    }

  //accept input
    public BigIntt(int value) {
        this.value = BigInteger.valueOf(value);
    }

  //convert into to BigInt
    public BigIntt add(BigIntt other) {
        if (other == null) {
            throw new IllegalArgumentException("Other BigInteger cannot be null");
        }
        return new BigIntt(this.value.add(other.value));
    }

   //mod method
    public BigIntt mod(BigIntt other) {
        if (other == null) {
        	// check if null
            throw new IllegalArgumentException("Other BigInteger cannot be null");
        }
        // if thry try to divide by zero
        if (other.value.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return new BigIntt(this.value.mod(other.value));
    }

    //toString with override
    @Override
    public String toString() {
        return this.value.toString();
    }

    public static void main(String[] args) {
        // Example to show usage
    	
        BigIntt num1 = new BigIntt(100);
        BigIntt num2 = new BigIntt(7);

        BigIntt sum = num1.add(num2);
        BigIntt modAnswer = num1.mod(num2);

        System.out.println("Sum: " + sum);
        System.out.println("Modulus: " + modAnswer);
    }
}