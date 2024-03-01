import java.util.*;

public class StatsCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        
        // Taking input
        System.out.println("Enter " + n + " numbers:");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        
        // Calculating statistics
        double mean = calculateMean(numbers);
        double standardDeviation = calculateStandardDeviation(numbers, mean);
        double median = calculateMedian(numbers);
        int mode = calculateMode(numbers);
        
        // Displaying results
        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + standardDeviation);
        System.out.println("Median: " + median);
        System.out.println("Mode: " + mode);
        
        scanner.close();
    }
    
    // Method to calculate mean
    public static double calculateMean(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.size();
    }
    
    // Method to calculate standard deviation
    public static double calculateStandardDeviation(List<Integer> numbers, double mean) {
        double sumSquaredDiff = 0;
        for (int num : numbers) {
            sumSquaredDiff += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sumSquaredDiff / numbers.size());
    }
    
    // Method to calculate median
    public static double calculateMedian(List<Integer> numbers) {
        Collections.sort(numbers);
        int size = numbers.size();
        if (size % 2 == 0) {
            return (double) (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2;
        } else {
            return numbers.get(size / 2);
        }
    }
    
    // Method to calculate mode
    public static int calculateMode(List<Integer> numbers) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : numbers) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = 0;
        int mode = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }
}
