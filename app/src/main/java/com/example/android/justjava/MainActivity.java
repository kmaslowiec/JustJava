package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quan = 1;
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
     *
     * @param i the id of EditBox (R.id.name)
     * @return
     */

    private Editable name(int i){

        EditText txt = findViewById(i);

        return txt.getText();

    }

    /**
     * @param i the id of CheckBox (R.id.name)
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

        int creamPrice = (checked(R.id.cream))? 1 : 0;
        int chocoPrice = (checked(R.id.choco))? 2 : 0;

        int price = (creamPrice + chocoPrice + this.price ) * quan ;

        return price;
    }

    /**
     * @param price
     * @return the String message
     */
    private String createOrderSummary(int price) {

        String priceMsg = "Name: " + name(R.id.text_field) +"\n";
        priceMsg += "Whipped cream? " + checked(R.id.cream) + "\n";
        priceMsg += "Chocolate? " + checked(R.id.choco) + "\n";
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



        if(quan==100){

            Toast.makeText(this, "You cannot have less than 100 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quan++;

        displayQuantity(quan);

    }

    public void decrease(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        if (quan == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();

            return;
        }
        quan--;

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