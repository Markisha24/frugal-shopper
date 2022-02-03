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

    private double priceA;
    private double priceB;
    private double priceC;

    //Pounds
    private int poundsA;
    private int poundsB;
    private int poundsC;

    //Ounces
    private int ouncesA;
    private int ouncesB;
    private int ouncesC;

    //Unit Prices
    private double unitPriceA;
    private double unitPriceB;
    private double unitPriceC;

    //Prices
    private EditText priceEditTextA;
    private EditText priceEditTextB;
    private EditText priceEditTextC;

    //Pounds (lbs)
    private EditText poundsEditTextA;
    private EditText poundsEditTextB;
    private EditText poundsEditTextC;

    //Ounces (oz)
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

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

    /*--------------------------------------ROW A CALCULATIONS-------------------------------------------*/
            //nothing provided in row A
            if ((priceEditTextA.getText().toString().trim().equals(""))
                    && (poundsEditTextA.getText().toString().trim().equals(""))
                    && (ouncesEditTextA.getText().toString().trim().equals(""))){

                unitPriceA = 0;
            }

            //weights given but no price given
            else if((priceEditTextA.getText().toString().trim().equals(""))) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "A price must be entered for product A",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //price given but no weights given
            else if(!(priceEditTextA.getText().toString().trim().equals(""))
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
                if(!(poundsEditTextA.getText().toString().trim().equals(""))
                        && (ouncesEditTextA.getText().toString().trim().equals(""))) {

                    priceA = Double.parseDouble(priceEditTextA.getText().toString());
                    poundsA = Integer.parseInt(poundsEditTextA.getText().toString());
                    ouncesA = 0;
                }

                //weight given in ounces but not pounds
                else if((poundsEditTextA.getText().toString().trim().equals(""))
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

                //calculating unit price for product A
                unitPriceA = priceA / ((poundsA * 16) + ouncesA);
                unitPriceA = Math.round(unitPriceA * 100.0) / 100.0;
            }

    /*--------------------------------------ROW B CALCULATIONS-------------------------------------------*/
            //nothing provided in row B
            if ((priceEditTextB.getText().toString().trim().equals(""))
                    && (poundsEditTextB.getText().toString().trim().equals(""))
                    && (ouncesEditTextB.getText().toString().trim().equals(""))){

                unitPriceB = 0;
            }

            //weights given but no price given
            else if((priceEditTextB.getText().toString().trim().equals(""))) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "A price must be entered for product B",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //price given but no weights given
            else if(!(priceEditTextB.getText().toString().trim().equals(""))
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
                if(!(poundsEditTextB.getText().toString().trim().equals(""))
                        && (ouncesEditTextB.getText().toString().trim().equals(""))) {

                    priceB = Double.parseDouble(priceEditTextB.getText().toString());
                    poundsB = Integer.parseInt(poundsEditTextB.getText().toString());
                    ouncesB = 0;
                }

                //weight given in ounces but not pounds
                else if((poundsEditTextB.getText().toString().trim().equals(""))
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

                //calculating unit price for product A
                unitPriceB = priceB / ((poundsB * 16) + ouncesB);
                unitPriceB = Math.round(unitPriceB * 100.0) / 100.0;
            }

    /*--------------------------------------ROW C CALCULATIONS-------------------------------------------*/
            //nothing provided in row C
            if ((priceEditTextC.getText().toString().trim().equals(""))
                    && (poundsEditTextC.getText().toString().trim().equals(""))
                    && (ouncesEditTextC.getText().toString().trim().equals(""))){

                unitPriceC = 0;
            }

            //weights given but no price given
            else if((priceEditTextC.getText().toString().trim().equals(""))) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "A price must be entered for product C",
                        Toast.LENGTH_SHORT);
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //price given but no weights given
            else if(!(priceEditTextC.getText().toString().trim().equals(""))
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
                if(!(poundsEditTextC.getText().toString().trim().equals(""))
                        && (ouncesEditTextC.getText().toString().trim().equals(""))) {

                    priceC = Double.parseDouble(priceEditTextC.getText().toString());
                    poundsC = Integer.parseInt(poundsEditTextC.getText().toString());
                    ouncesC = 0;
                }

                //weight given in ounces but not pounds
                else if((poundsEditTextC.getText().toString().trim().equals(""))
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

                //calculating unit price for product A
                unitPriceC = priceC / ((poundsC * 16) + ouncesC);
                unitPriceC = Math.round(unitPriceC * 100.0) / 100.0;
            }



            //check if at least product is entered
            if((unitPriceA <= 0) && (unitPriceB <= 0) && (unitPriceC <= 0)) {
                Toast toast = Toast.makeText( getApplicationContext(),
                        "At least one product must be entered",
                        Toast.LENGTH_SHORT );
                toast.show();
                bestBuyEditText.setText("Best Buy: ");
                return;
            }

            //comparing and finding minimum unit price
            double[] unitPrices = new double[]{unitPriceA, unitPriceB, unitPriceC};
            double minUnitPrice = Double.MAX_VALUE;
            int index = 0;

            for(int i = 0; i < unitPrices.length; i++)
            {
                if((minUnitPrice >= unitPrices[i]) && (unitPrices[i] != 0.0)) {
                    minUnitPrice = unitPrices[i];
                    index = i;
                }
            }

            //displaying best buy
            switch(index) {
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
                    Toast toast = Toast.makeText( getApplicationContext(),
                            "Something went wrong! Please check inputs and try again.",
                            Toast.LENGTH_SHORT );
                    toast.show();
            }
            unitPriceA = 0;
            unitPriceB = 0;
            unitPriceC = 0;

        }
    }
}