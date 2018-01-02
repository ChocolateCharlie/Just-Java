/**
 * MainActivity.java
 * By : ChocolateCharlie
 * Last Updates : 02 - 01 - 2018
 */

package com.example.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
 * Display the price.
 */
    public void submitOrder(View view) {
        String priceMessage = "$" + (quantity * 5);
        displayMessage(priceMessage);
    }

/**
 * display
 * @param number
 *
 * This method displays the given quantity value on the screen.
 */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

/**
 * displayPrice
 * @param number
 *
 * This method displays the given price on the screen.
 */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

/**
 * displayMessage
 * @param message
 *
 * This method displays the given text on the screen.
 */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
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

        display(quantity);
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

        display(quantity);
    }
}