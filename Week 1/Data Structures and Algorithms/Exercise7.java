
public class Exercise7 {
    public static double calculateFutureValue(double presentValue,double growthRate,int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, growthRate, years - 1)
                * (1 + growthRate);
    }

    public static void main(String[] args) {

        double presentValue = 20000;
        double growthRate = 0.10;
        int years = 5;

        double futureValue = calculateFutureValue(presentValue,growthRate,years);

        System.out.println("Future Value after " + years + " years = " + futureValue);
    }
}
