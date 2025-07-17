import javax.swing.*;
import java.util.ArrayList;

class Order {
    String id;
    double total;
    boolean discountApplied = false;
    boolean freeShipping = false;

    public Order(String id, double total) {
        this.id = id;
        this.total = total;
    }

    public void applyDiscount() {
        // Apply 10% discount
        this.total *= 0.9;
        this.discountApplied = true;
    }

    public void offerFreeShipping() {
        this.freeShipping = true;
    }
}

public class OrderProcess {
    public static void main(String[] args) {
        // Step 1: Create 10 orders
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order("ORD001", 120.00));
        orders.add(new Order("ORD002", 60.00));
        orders.add(new Order("ORD003", 30.00));
        orders.add(new Order("ORD004", 200.00));
        orders.add(new Order("ORD005", 75.00));
        orders.add(new Order("ORD006", 45.00));
        orders.add(new Order("ORD007", 99.00));
        orders.add(new Order("ORD008", 110.00));
        orders.add(new Order("ORD009", 55.00));
        orders.add(new Order("ORD010", 80.00));

        // Step 2: Show all orders
        StringBuilder listMessage = new StringBuilder("List of Orders:\n");
        for (Order order : orders) {
            listMessage.append(order.id).append(" - $").append(order.total).append("\n");
        }
        JOptionPane.showMessageDialog(null, listMessage.toString());

        // Step 3: First pass – apply discounts
        for (Order order : orders) {
            if (order.total > 100) {
                order.applyDiscount();
            }
        }

        // Step 4: Show message after applying discounts
        JOptionPane.showMessageDialog(null, "All discounts have been applied.");

        // Step 5: Second pass – offer free shipping
        ArrayList<String> shippingOrders = new ArrayList<>();
        for (Order order : orders) {
            if (!order.discountApplied && order.total >= 50 && order.total <= 99) {
                order.offerFreeShipping();
                shippingOrders.add(order.id);
            }
        }

        // Step 6: Show message after offering free shipping
        String shippingMsg = shippingOrders.isEmpty()
            ? "No orders qualified for free shipping."
            : "Free shipping offered to orders: " + String.join(", ", shippingOrders);
        JOptionPane.showMessageDialog(null, shippingMsg);

        // Step 7: Ask for payment method
        String payment = JOptionPane.showInputDialog(
            null,
            "Choose a payment method:\ncredit card, cash, or voucher"
        );

        // Optional: validate input (basic)
        if (payment == null || payment.isEmpty()) {
            payment = "unspecified";
        }

        JOptionPane.showMessageDialog(null, "Payment method selected: " + payment);

        // Step 8: Final message
        JOptionPane.showMessageDialog(null, "Shipment has been placed.\nThank you!");

        // End of program
    }
}
