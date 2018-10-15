/**
   A line item in an invoice.
*/
public interface LineItem
{
   /**
      Gets the price of this line item.
      @return the price
   */
   double getPrice();
   /**
      Gets the description of this line item.
      @return the description
   */   
   String toString();
   /**
    * get the quantity of line item
    * @return the quantity
    */
   int getQuantity();
   /**
    * increase the quantity
    */
   void increaseQuantity();
   
}
