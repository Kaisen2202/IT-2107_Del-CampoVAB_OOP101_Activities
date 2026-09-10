
import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        
        System.out.println("======= MENU ========");
        System.out.println("| 1. Burger   - $45 |");
        System.out.println("| 2. Siomai   - $50 |");
        System.out.println("| 3. Hotdog   - $35 |");
        System.out.println("| 4. Pizza    - $225|");
        System.out.println("| 5. Milktea  - $79 |");
        System.out.println("| 6. Takoyaki - $100|");
        System.out.println("| 7. Noodles  - $55 |");
        System.out.println("| 8. Palamig  - $20 |");
        System.out.println("| 9. Water    - $15 |");
        System.out.println("=====================");

        int itemQuantity = 0;
        double Subtotal = 0;

        boolean isStudent = false;
        boolean askedStudent = false;

        char orderAgain = 'Y';

        while (orderAgain == 'Y' || orderAgain == 'y') {

            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

         
            if (itemNumber < 1 || itemNumber > 9) {

                System.out.println("Invalid item number!");
                System.out.println("Order skipped.");

            }
            else if (quantity < 1 || quantity > 10) {

                System.out.println("Invalid quantity!");
                System.out.println("Order skipped.");

            }
            else {

                
                if (!askedStudent) {
                    System.out.print("Are you a student? (Y/N): ");
                    char student = input.next().charAt(0);

                    if (student == 'Y' || student == 'y') {
                        isStudent = true;
                    }

                    askedStudent = true;
                }

                double price = 0;

                
                if (itemNumber == 1) {
                    price = 45;
                }
                else if (itemNumber == 2) {
                    price = 50;
                }
                else if (itemNumber == 3) {
                    price = 35;
                }
                else if (itemNumber == 4) {
                    price = 225;
                }
                else if (itemNumber == 5) {
                    price = 79;
                }
                else if (itemNumber == 6) {
                    price = 100;
                }
                else if (itemNumber == 7) {
                    price = 55;
                }
                else if (itemNumber == 8) {
                    price = 20;
                }
                else if (itemNumber == 9) {
                    price = 15;
                }

                double orderAmount = price * quantity;

               
                itemQuantity += quantity;
                Subtotal += orderAmount;

                System.out.println("Order accepted!");
                System.out.println("Order amount: $" + orderAmount);
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().charAt(0);
        }

        
        double discountRate = 0;

        if (isStudent && Subtotal >= 500) {
            discountRate = 0.15;
        }
        else if (isStudent) {
            discountRate = 0.10;
        }
        else if (Subtotal >= 500) {
            discountRate = 0.05;
        }

        double Discount = Subtotal * discountRate;
        double Total = Subtotal - Discount;

        
        System.out.println("\n=========================");
        System.out.println("|     FINAL SUMMARY     |");
        System.out.println("=========================");
        System.out.println("|Item quantity: " + itemQuantity + "\t|");
        System.out.println("|Subtotal: $" + Subtotal + "\t|");
        System.out.println("|Discount: $" + Discount + "\t\t|");
        System.out.println("|Total Amount: $" + Total + "\t|");
        System.out.println("=========================");
        
        input.close();
    }
}

