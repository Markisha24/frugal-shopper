/**
 * The Frugal Shopper program allows a user to input prices and
 * weights (in lbs and oz) of up to 3 similar products. The app
 * returns which product offers the lowest unit price. The user
 * must input at least one product, with every product required
 * to have a price and weight (either in pounds, ounces, or both).
 * If all three products have the same unit price, the app will
 * display all three as the best buy. If two products have the
 * same unit price the app will display the second item as the
 * best buy.
 *
 * @author  Markisha Fuller
 * @since   2022-02-04
 */

package edu.uga.cs.frugalshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "FrugalShopper";

    //Prices ($)
    private double priceA;
    private double priceB;
    private double priceC;

    //Pounds (lbs)
    private int poundsA;
    private int poundsB;
    private int poundsC;

    //Ounces (oz)
    private int ouncesA;
    private int ouncesB;
    private int ouncesC;

    //Unit Prices
    private double unitPriceA;
    private double unitPriceB;
    private double unitPriceC;

    //Prices EditTexts
    private EditText priceEditTextA;
    private EditText priceEditTextB;
    private EditText priceEditTextC;

    //Pounds EditTexts
    private EditText poundsEditTextA;
    private EditText poundsEditTextB;
    private EditText poundsEditTextC;

    //Ounces EditTexts
    private EditText ouncesEditTextA;
    private EditText ouncesEditTextB;
    private EditText ouncesEditTextC;

    //displays best item to buy
    private TextView bestBuyEditText;

    //button used to start computation of best item to buy
    private Button   compute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(DEBUG_TAG, "MainActivity.onCreate()" );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceEditTextA = findViewById( R.id.editTextNumberDecimal );
        priceEditTextB = findViewById( R.id.editTextNumberDecimal2 );
        priceEditTextC = findViewById( R.id.editTextNumberDecimal3 );

        poundsEditTextA = findViewById( R.id.editTextNumber  );
        poundsEditTextB = findViewById( R.id.editTextNumber3 );
        poundsEditTextC = findViewById( R.id.editTextNumber5 );

        ouncesEditTextA = findViewById( R.id.editTextNumber2 );
        ouncesEditTextB = findViewById( R.id.editTextNumber4);
        ouncesEditTextC = findViewById( R.id.editTextNumber6 );

        bestBuyEditText = findViewById( R.id.textView4 );
        compute = findViewById( R.id.button );

        // set the compute Button's listener
        compute.setOnClickListener( new ButtonClickListener() );
    }

    /**
     * This method is run when the user presses the "Compare" button in the app.
     * The program will check if the user's input is correct and respond accordingly.
     * If user input is correct, the app will display the product with the best
     * unit price.
     *
     * Correct input: At least one product is provided with it's price and weight, either
     * pounds, ounces, or both. One of the weights can be left empty but not both, and the
     * price cannot be left empty. An empty weight will be treated as a value of 0.
     *
     * Incorrect inputs: No products provided, no price provided for an item,
     */
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            /*--------------------------------------ROW A CALCULATIONS-------------------------------------------*/
            //nothing provided in row A
            if ((priceEditTextA.getText().toString().trim().equals(""))
                    && (poundsEditTextA.getText().toString().trim().equals(""))
                    && (ouncesEditTextA.getText().toString().trim().equals(""))) {

                unitPriceA = 0;
            }

            //weights given but no price given
            else if ((priceEditTextA.getText().toString().trim().equals(""))) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "A price must be entered for product A",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //price given but no weights given
            else if (!(priceEditTextA.getText().toString().trim().equals(""))
                    && (poundsEditTextA.getText().toString().trim().equals(""))
                    && (ouncesEditTextA.getText().toString().trim().equals(""))) {

                unitPriceA = 0;
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Weights must be given for product A",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //input is valid
            else {
                //weight given in pounds but not ounces
                if (!(poundsEditTextA.getText().toString().trim().equals(""))
                        && (ouncesEditTextA.getText().toString().trim().equals(""))) {

                    priceA = Double.parseDouble(priceEditTextA.getText().toString());
                    poundsA = Integer.parseInt(poundsEditTextA.getText().toString());
                    ouncesA = 0;
                }

                //weight given in ounces but not pounds
                else if ((poundsEditTextA.getText().toString().trim().equals(""))
                        && !(ouncesEditTextA.getText().toString().trim().equals(""))) {

                    priceA = Double.parseDouble(priceEditTextA.getText().toString());
                    poundsA = 0;
                    ouncesA = Integer.parseInt(ouncesEditTextA.getText().toString());
                }

                //all fields provided
                else {

                    priceA = Double.parseDouble(priceEditTextA.getText().toString());
                    poundsA = Integer.parseInt(poundsEditTextA.getText().toString());
                    ouncesA = Integer.parseInt(ouncesEditTextA.getText().toString());
                }

                //a price is given, but weight is given as 0
                if (priceA != 0 && poundsA == 0 && ouncesA == 0) {
                    unitPriceA = 0;
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Weights cannot equal 0 for product A",
                            Toast.LENGTH_SHORT);
                    toast.show();
                    bestBuyEditText.setText("Best Buy: ");
                    return;
                }

                //calculating unit price for product A
                else {
                    unitPriceA = priceA / ((poundsA * 16) + ouncesA);
                    unitPriceA = Math.round(unitPriceA * 100.0) / 100.0;
                }
            }

            /*--------------------------------------ROW B CALCULATIONS-------------------------------------------*/
            //nothing provided in row B
            if ((priceEditTextB.getText().toString().trim().equals(""))
                    && (poundsEditTextB.getText().toString().trim().equals(""))
                    && (ouncesEditTextB.getText().toString().trim().equals(""))) {

                unitPriceB = 0;
            }

            //weights given but no price given
            else if ((priceEditTextB.getText().toString().trim().equals(""))) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "A price must be entered for product B",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //price given but no weights given
            else if (!(priceEditTextB.getText().toString().trim().equals(""))
                    && (poundsEditTextB.getText().toString().trim().equals(""))
                    && (ouncesEditTextB.getText().toString().trim().equals(""))) {

                unitPriceB = 0;
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Weights must be given for product B",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //input is valid
            else {

                //weight given in pounds but not ounces
                if (!(poundsEditTextB.getText().toString().trim().equals(""))
                        && (ouncesEditTextB.getText().toString().trim().equals(""))) {

                    priceB = Double.parseDouble(priceEditTextB.getText().toString());
                    poundsB = Integer.parseInt(poundsEditTextB.getText().toString());
                    ouncesB = 0;
                }

                //weight given in ounces but not pounds
                else if ((poundsEditTextB.getText().toString().trim().equals(""))
                        && !(ouncesEditTextB.getText().toString().trim().equals(""))) {

                    priceB = Double.parseDouble(priceEditTextB.getText().toString());
                    poundsB = 0;
                    ouncesB = Integer.parseInt(ouncesEditTextB.getText().toString());
                }

                //all fields provided
                else {

                    priceB = Double.parseDouble(priceEditTextB.getText().toString());
                    poundsB = Integer.parseInt(poundsEditTextB.getText().toString());
                    ouncesB = Integer.parseInt(ouncesEditTextB.getText().toString());
                }

                //a price is given, but weight is given as 0
                if (priceB != 0 && poundsB == 0 && ouncesB == 0) {
                    unitPriceB = 0;
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Weights cannot equal 0 for product B",
                            Toast.LENGTH_SHORT);
                    toast.show();
                    bestBuyEditText.setText("Best Buy: ");
                    return;
                }

                //calculating unit price for product B
                else {
                    unitPriceB = priceB / ((poundsB * 16) + ouncesB);
                    unitPriceB = Math.round(unitPriceB * 100.0) / 100.0;
                }
            }

            /*--------------------------------------ROW C CALCULATIONS-------------------------------------------*/
            //nothing provided in row C
            if ((priceEditTextC.getText().toString().trim().equals(""))
                    && (poundsEditTextC.getText().toString().trim().equals(""))
                    && (ouncesEditTextC.getText().toString().trim().equals(""))) {

                unitPriceC = 0;
            }

            //weights given but no price given
            else if ((priceEditTextC.getText().toString().trim().equals(""))) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "A price must be entered for product C",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //price given but no weights given
            else if (!(priceEditTextC.getText().toString().trim().equals(""))
                    && (poundsEditTextC.getText().toString().trim().equals(""))
                    && (ouncesEditTextC.getText().toString().trim().equals(""))) {

                unitPriceC = 0;
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Weights must be given for product C",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //input is valid
            else {
                //weight given in pounds but not ounces
                if (!(poundsEditTextC.getText().toString().trim().equals(""))
                        && (ouncesEditTextC.getText().toString().trim().equals(""))) {

                    priceC = Double.parseDouble(priceEditTextC.getText().toString());
                    poundsC = Integer.parseInt(poundsEditTextC.getText().toString());
                    ouncesC = 0;
                }

                //weight given in ounces but not pounds
                else if ((poundsEditTextC.getText().toString().trim().equals(""))
                        && !(ouncesEditTextC.getText().toString().trim().equals(""))) {

                    priceC = Double.parseDouble(priceEditTextC.getText().toString());
                    poundsC = 0;
                    ouncesC = Integer.parseInt(ouncesEditTextC.getText().toString());
                }

                //all fields provided
                else {

                    priceC = Double.parseDouble(priceEditTextC.getText().toString());
                    poundsC = Integer.parseInt(poundsEditTextC.getText().toString());
                    ouncesC = Integer.parseInt(ouncesEditTextC.getText().toString());
                }

                //a price is given, but weight is given as 0
                if (priceC != 0 && poundsC == 0 && ouncesC == 0) {
                    unitPriceC = 0;
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Weights cannot equal 0 for product C",
                            Toast.LENGTH_SHORT);
                    toast.show();
                    bestBuyEditText.setText("Best Buy: ");
                    return;
                }

                //calculating unit price for product C
                else {
                    unitPriceC = priceC / ((poundsC * 16) + ouncesC);
                    unitPriceC = Math.round(unitPriceC * 100.0) / 100.0;
                }
            }

            /*------------------------------------INPUT CHECK-------------------------------------------*/
            //check if at least product is entered
            if ((unitPriceA <= 0) && (unitPriceB <= 0) && (unitPriceC <= 0)) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "At least one product must be entered",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            /*---------------------------------COMPARING UNIT PRICES-------------------------------------------*/
            //unit price of all products is the same
            if (unitPriceA == unitPriceB && unitPriceA == unitPriceC
                    && unitPriceB == unitPriceA && unitPriceB == unitPriceC
                    && unitPriceC == unitPriceB && unitPriceC == unitPriceA) {

                bestBuyEditText.setText("Best Buy: A, B, or C");
                //resetting unit prices
            }

            //comparing and finding minimum unit price
            else {
                double[] unitPrices = new double[]{unitPriceA, unitPriceB, unitPriceC};
                double minUnitPrice = Double.MAX_VALUE;
                int index = 0;  //used to save the index of an item from the array unitPrices

                for (int i = 0; i < unitPrices.length; i++) {
                    if ((minUnitPrice >= unitPrices[i]) && (unitPrices[i] != 0.0)) {
                        minUnitPrice = unitPrices[i];
                        index = i;
                    }
                }

                /*-----------------------------------DISPLAYING BEST BUY-------------------------------------------*/
                //displaying best buy
                switch (index) {
                    case 0:
                        bestBuyEditText.setText("Best Buy: A");
                        break;
                    case 1:
                        bestBuyEditText.setText("Best Buy: B");
                        break;
                    case 2:
                        bestBuyEditText.setText("Best Buy: C");
                        break;
                    default:
                        bestBuyEditText.setText("Best Buy: ");
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Something went wrong! Please check inputs and try again.",
                                Toast.LENGTH_SHORT);
                        toast.show();
                }

            }

            //resetting unit prices
            unitPriceA = 0;
            unitPriceB = 0;
            unitPriceC = 0;
        }
    }
}