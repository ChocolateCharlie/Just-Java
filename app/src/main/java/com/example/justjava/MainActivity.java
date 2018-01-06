/**
 * MainActivity.java
 * By : ChocolateCharlie
 * Last Updates : 06 - 01 - 2018
 */

package com.example.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;



/**
 * MainActivity class
 * @author ChocolateCharlie
 *
 * Display an order form to order coffee :
 * - choose number of cups with two buttons (+ and -)
 * - show price each time the order button is pressed
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;   /* The number of cups */

/**
 * onCreate
 * @param savedInstanceState
 *
 * This method is called at the creation of the class.
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

/**
 * submitOrder
 * @param view
 *
 * This method is called when the order button is clicked.
 * Display :
 *      - the customer's name
 *      - if whipped cream must be added
 *      - if chocolate must be added
 *      - the number of desired cups
 *      - the price
 *      - a thanking message
 */
    public void submitOrder(View view) {
        displayMessage(createOrderSummary(calculatePrice()));
    }

/**
 *  calculatePrice
 *
 *  Calculates the price of the order.
 */
    private int calculatePrice() {
        return (quantity * 5);
    }

/**
 * createOrderSummary
 * @param price
 * @return a String with :
 *      - the customer's name
 *      - if whipped cream must be added
 *      - if chocolate must be added
 *      - the number of desired cups (quantity global variable)
 *      - the price
 *      - a thanking message
 */
    private String createOrderSummary (int price) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);

        return "Name : Kaptain Koffee\nAdd whipped cream ? " + whippedCreamCheckBox.isChecked() + "\nAdd chocolate ? " + chocolateCheckBox.isChecked() + "\nQuantity : " + quantity + "\nTotal : $" + price + "\nThank you !";
    }

/**
 * displayQuantity
 * @param quantity
 *
 * This method displays the given quantity value on the screen.
 */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

/**
 * displayMessage
 * @param message
 *
 * This method displays the given text on the screen.
 */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

/**
 * increment
 * @param view
 *
 * This method is called when the plus button is clicked.
 * Increment quantity (global variable for the number of cups).
 */
    public void increment(View view) {
        quantity = quantity + 1;

        displayQuantity(quantity);
    }

/**
 * decrement
 * @param view
 *
 * This method is called when the minus button is clicked.
 * Decrement quantity (global variable for the number of cups).
 */
    public void decrement(View view) {
        if (quantity != 0)
        {
            quantity = quantity - 1;
        }

        displayQuantity(quantity);
    }
}