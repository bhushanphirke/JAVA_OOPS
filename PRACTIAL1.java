
import java.io.*;

class DiscountBilling {
 String Names;
 int Quan;
 int price;
 int subtotals;

 public void add() {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   System.out.println("Enter Name:");
   Names = br.readLine();

   System.out.println("Enter Quantity:");
   Quan = Integer.parseInt(br.readLine());

  System.out.println("Enter Price:");
  price = Integer.parseInt(br.readLine());


  if(price > 0)
  {
     subtotals = Quan * price;
   }
 }
  catch (Exception e) {
   System.out.println("Invalid input.");
 }
 }

public void display() {
  System.out.println("Item Name: " + Names);
  System.out.println("Item Quantity: " + Quan);
  System.out.println("Item Price: " + price);
  System.out.println("Subtotal: " + subtotals);
       
 }
  
  public void displaydiscount()
 {
      int discount =0;
  if(price > 5000)
       {
      discount = price * 10 / 100;
     price = price - discount;
       }
  else if(price > 2000 && price < 5000)
 {
   discount = price * 5 / 100;
 }     
  System.out.println("Item Name: " + Names);
  System.out.println("Item Quantity: " + Quan);
  System.out.println("Item Price: " + price);
     
 }

   
}
public class PRACTIAL1 {
    public static void main(String args[]) throws Exception {
        int i = 0;

 DiscountBilling[] x = new DiscountBilling[10];

 BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

 System.out.println("Enter number of items you want to add (max 10):");
 int item = Integer.parseInt(br.readLine());

if (item > 10 || item < 1) {
 System.out.println("Please enter a number between 1 and 10.");
  return;
 }

for (i = 0; i < item; i++) {
 x[i] = new DiscountBilling();
  x[i].add();
 }


 for (i = 0; i < item; i++) {
     x[i].displaydiscount();
 }
    }
}