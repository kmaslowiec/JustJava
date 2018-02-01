package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quan = 0;
    int price = 5;
    //CheckBox box = findViewById(R.id.checkbox);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    /**
     * This method displays the given text on the screen.
     */


   /* private int calculatePrice(int quantity){

        int result = quantity * price;

        return result;
    }

    private int calculatePrice(int quantity, int price){

        this.price = price;
        this.quan = quan;

        int result = quantity * price;

        return result;
    }*/
    ///////////// MY METHODS


    /**
     * @param CheckBox id
     * @return true or false when the param box is clicked
     */
    private boolean checked(int i) {
        CheckBox box = findViewById(i);

        return box.isChecked();

    }


    /**
     * This calculates the price based on quantity.
     *
     * @return price of the order
     */

    private int calculatePrice() {

        int price = quan * this.price;

        return price;
    }

    /**
     * @param price
     * @return the String message
     */
    private String createOrderSummary(int price) {

        String priceMsg = "Name: Konrad Maslowiec\n";
        priceMsg += "Whipped cream? " + checked(R.id.checkbox) + "\n";
        priceMsg += "Quantity: " + quan + "\n";
        priceMsg += "Total: " + price + "\n";
        priceMsg += "Thank you";


        return priceMsg;

    }


    //////////////// END OF MY METHOD

    /**
     * Displays the message on the screen under price_text_view.xml
     *
     * @param message
     */

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();

        String msg = createOrderSummary(price);
        displayMessage(msg);
    }

    /**
     * This method is called when the increase button is clicked
     */
    public void increase(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);


        quan++;

        displayQuantity(quan);

    }

    public void decrease(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        if (quan > 0) {
            quan--;
        }


        displayQuantity(quan);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int shit) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + shit);
    }
}