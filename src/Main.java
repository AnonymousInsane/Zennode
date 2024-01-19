import java.util.Objects;
import java.util.Scanner;
public class Main {
    //Declared important variables as static
    static int product_A = 20;
    static int product_B = 40;
    static int product_C = 50;
    static int quantity_A = 0;
    static int quantity_B = 0;
    static int quantity_C = 0;
    static String wrap_gift = "";
    static Scanner sc= new Scanner(System.in);
    //Method for flat 10 discount
    static int flat_10_discount(int total_cart_amount){
        System.out.println("Flat 10 discount applicable and discount amount is : $"+ 10);
        return total_cart_amount-10;
    }
    //Method for bulk 5 discount
    static int bulk_5_discount(int amount){
        int discounted_5_amount = amount-(amount * 5/100);
        System.out.println("Bulk 5 discount applicable and discounted amount is : $" + discounted_5_amount);
        return discounted_5_amount;
    }
    //Method for bulk 10 discount
    static int bulk_10_discount(int amount){
        int discounted_10_amount = amount-(amount * 10/100);
        System.out.println("Bulk 10 discount applicable and discounted amount is : $" + discounted_10_amount);
        return discounted_10_amount;
    }
    //Method for tiered 50 discount
    static int tiered_50_discount(){
        int discounted_amount_A = 0;
        int discounted_amount_B = 0;
        int discounted_amount_C = 0;
        if (quantity_A > 15) {
            int extra_quantity_A = quantity_A - 15;
            int amount_A = product_A * extra_quantity_A;
            discounted_amount_A = amount_A-(amount_A * 50/100);
            System.out.println("Tiered 50 discount applicable and discounted amount of A is : $" + discounted_amount_A);
        }
        if (quantity_B > 15) {
            int extra_quantity_B = quantity_B - 15;
            int amount_B = product_B * extra_quantity_B;
            discounted_amount_B = amount_B-(amount_B * 50/100);
            System.out.println("Tiered 50 discount applicable and discounted amount of B is : $" +discounted_amount_B);

        }
        if (quantity_C > 15) {
            int extra_quantity_C = quantity_C - 15;
            int amount_C = product_C * extra_quantity_C;
            discounted_amount_C = amount_C-(amount_C * 50/100);
            System.out.println("Tiered 50 discount applicable and discounted amount of C is : $" +discounted_amount_C);
        }
        return discounted_amount_A+discounted_amount_B+discounted_amount_C;
    }
    //Method for calculating cart amount
    static int cart_amount(){
        int amount_A = product_A * quantity_A;
        int amount_B = product_B * quantity_B;
        int amount_C = product_C * quantity_C;
        int total_cart_amount = amount_A+amount_B+amount_C;
        int total_quantity = quantity_A + quantity_B+quantity_C;
        int amount_with_flat_10_discount = 0;
        int amount_with_bulk_5_discount = 0;
        int amount_with_bulk_10_discount = 0;
        int total_amount_with_tiered_50_discount = 0;
        System.out.println("Product name is A and quantity is "+quantity_A+" and total amount of A is : $"+amount_A);
        System.out.println("Product name is B and quantity is "+quantity_B+" and total amount of B is : $"+amount_B);
        System.out.println("Product name is C and quantity is "+quantity_C+" and total amount of C is : $"+amount_C);
        System.out.println("Subtotal amount is : $"+total_cart_amount);
        if (total_cart_amount>200){
            amount_with_flat_10_discount  = flat_10_discount(total_cart_amount);
        }
        if (quantity_A > 10 && quantity_A <= 20){
           amount_with_bulk_5_discount = amount_with_bulk_5_discount +  bulk_5_discount(amount_A);
        }
        if (quantity_B > 10 && quantity_B <= 20){
            amount_with_bulk_5_discount = amount_with_bulk_5_discount +  bulk_5_discount(amount_B);
        }
        if (quantity_C > 10 && quantity_C <= 20){
            amount_with_bulk_5_discount = amount_with_bulk_5_discount +  bulk_5_discount(amount_C);
        }
        if (quantity_A > 20) {
            amount_with_bulk_10_discount = amount_with_bulk_10_discount + bulk_10_discount(amount_A);
        }
        if (quantity_B > 20) {
            amount_with_bulk_10_discount = amount_with_bulk_10_discount + bulk_10_discount(amount_B);
        }
        if (quantity_C > 20) {
            amount_with_bulk_10_discount = amount_with_bulk_10_discount +  bulk_10_discount(amount_C);
        }
        if (total_quantity > 30 && quantity_A > 15 || quantity_B > 15 || quantity_C > 15){
            total_amount_with_tiered_50_discount = tiered_50_discount();
        }
        return discount_applied(amount_with_flat_10_discount,amount_with_bulk_5_discount,amount_with_bulk_10_discount,total_amount_with_tiered_50_discount);
    }
    //Method for calculating which discount is best for applicable
    static int discount_applied(int amount_with_flat_10_discount,int amount_with_bulk_5_discount,int amount_with_bulk_10_discount,int total_amount_with_tiered_50_discount){
        if (amount_with_bulk_5_discount > amount_with_bulk_10_discount && amount_with_bulk_5_discount>total_amount_with_tiered_50_discount) {
            System.out.println("Discount applicable is bulk 5");
            return amount_with_flat_10_discount - amount_with_bulk_5_discount;
        } else if (amount_with_bulk_10_discount > amount_with_bulk_5_discount && amount_with_bulk_10_discount > total_amount_with_tiered_50_discount) {
            System.out.println("Discount applicable is bulk 10");
            return amount_with_flat_10_discount - amount_with_bulk_10_discount;
        }
        System.out.println("Discount applicable is tiered 50");
        return amount_with_flat_10_discount - total_amount_with_tiered_50_discount;
    }
    //Method for wrap_gift_amount
    static int wrap_gift(){
        int total_gift_wrap_fee = quantity_A+quantity_B+quantity_C;
        System.out.println("Total gift wrapping fee is : $"+total_gift_wrap_fee);
        return total_gift_wrap_fee;
    }
    //Method for shipping fee amount
    static long shipping_fee(){
        int total_quantity = quantity_A+quantity_B+quantity_C;
        long total_shipping_fee = 5*(Math.round(total_quantity/10.0)*10);
        System.out.println("Shipping fee: $"+total_shipping_fee);
        return total_shipping_fee;
    }
    //Method which calculates the total amount
    static void zennode(){
        int cart_amount = cart_amount();
        long total_gift_wrap_fee = 0;
        long total_shipping_fee = 0;
        if (Objects.equals(wrap_gift, "Y")){
            total_gift_wrap_fee = wrap_gift();
        }
        total_shipping_fee = shipping_fee();
        int total_amount  = (int) (cart_amount+total_shipping_fee+total_gift_wrap_fee);
        System.out.println("Total amount is : $"+total_amount);
    }
    public static void main(String[] args) {
        System.out.println("Enter the quantity for Product A : ");
        quantity_A = sc.nextInt();
        System.out.println("Enter the quantity for Product B : ");
        quantity_B = sc.nextInt();
        System.out.println("Enter the quantity for Product C : ");
        quantity_C = sc.nextInt();
        System.out.println("Want to wrap as a gift ? Y for Yes, N for No");
        wrap_gift = sc.next();
        zennode();
    }
}