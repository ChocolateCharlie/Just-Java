/**
 * MainActivity.java
 * By : ChocolateCharlie
 * Last Updates : 06 - 01 - 2018
 */

package com.example.justjava;



import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);

        displayMessage(createOrderSummary(whippedCreamCheckBox.isChecked(), chocolateCheckBox.isChecked(), calculatePrice(whippedCreamCheckBox.isChecked(), chocolateCheckBox.isChecked())));
    }

/**
 *  calculatePrice
 *  @param hasWhippedCream
 *  @param hasChocolate
 *
 *  Calculates the price of the order.
 */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int price = quantity * 5;

        if (hasWhippedCream)
        {
            price += 1;
        }

        if (hasChocolate)
        {
            price += 2;
        }

        return (price);
    }

/**
 * createOrderSummary
 * @param hasWhippedCream
 * @param hasChocolate
 * @param price
 * @return a String with :
 *      - the customer's name
 *      - if whipped cream must be added
 *      - if chocolate must be added
 *      - the number of desired cups (quantity global variable)
 *      - the price
 *      - a thanking message
 */
    private String createOrderSummary (boolean hasWhippedCream, boolean hasChocolate, int price) {
        EditText customersName = (EditText) findViewById(R.id.name_edit_text);

        return "Name : " + customersName.getText().toString() + "\nAdd whipped cream ? " + hasWhippedCream + "\nAdd chocolate ? " + hasChocolate + "\nQuantity : " + quantity + "\nTotal : $" + price + "\nThank you !";
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
        if (quantity < 100)
        {
            quantity = quantity + 1;
        }
        else    /* Notify user with a toast */
        {
            Toast toast = Toast.makeText(getApplicationContext(), "You cannot order more than 100 cups.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }

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
        if (quantity > 0)
        {
            quantity = quantity - 1;
        }
        else    /* Notify user with a toast */
        {
            Toast toast = Toast.makeText(getApplicationContext(), "You cannot order less than 1 cup.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }

        displayQuantity(quantity);
    }
}