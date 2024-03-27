package Java;

import java.util.ArrayList;
import java.util.List;

public class JD_JavaProgram {

    public static void main(String[] args) {
        List<List<Integer>> orders = new ArrayList<>();
        orders.add(List.of(50,5));
        orders.add(List.of(20,2));
        orders.add(List.of(10,1));
        orders.add(List.of(30,8));
        int result = solution(orders);
        System.out.println(result);
    }

    private static int solution(List<List<Integer>> orders) {
        int count = 0;
        for (List<Integer> order : orders) {
            int orderAmount = order.get(0);
            int units = order.get(1);
    
            // Calculate delivery cost
            int deliveryCost = units * 1; // Assuming delivery cost per unit is 1
    
            
            if (deliveryCost <= 0.10 * orderAmount) {
                count++;
            }
        }
        return count;
    }
    
}
