public class FinancialForecast {
    /**
     
     * @param initialValue
     * @param growthRate 
     * @param periods 
     * @return 
     */
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        }
        return calculateFutureValue(initialValue, growthRate, periods - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05; // 5% growth per period
        int periods = 10;

        double futureValue = calculateFutureValue(initialValue, growthRate, periods);
        System.out.printf("Future value after %d periods: %.2f\n", periods, futureValue);
    }
}
