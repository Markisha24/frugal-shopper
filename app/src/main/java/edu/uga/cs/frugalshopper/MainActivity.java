package edu.uga.cs.frugalshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceEditTextA = findViewById( R.id.editTextNumberDecimal );
        priceEditTextB = findViewById( R.id.editTextNumberDecimal2 );
        priceEditTextC = findViewById( R.id.editTextNumberDecimal3 );

        poundsEditTextA = findViewById( R.id.editTextNumberDecimal4 );
        poundsEditTextB = findViewById( R.id.editTextNumberDecimal5 );
        poundsEditTextC = findViewById( R.id.editTextNumberDecimal6 );

        ouncesEditTextA = findViewById( R.id.editTextNumberDecimal7 );
        ouncesEditTextB = findViewById( R.id.editTextNumberDecimal8 );
        ouncesEditTextC = findViewById( R.id.editTextNumberDecimal9 );

        bestBuyEditText = findViewById( R.id.textView4 );
        compute = findViewById( R.id.button );

        // set the compute Button's listener
        compute.setOnClickListener( new ButtonClickListener() );
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //Prices
            double priceA;
            double priceB;
            double priceC;

            //Pounds
            double poundsA;
            double poundsB;
            double poundsC;

            //Ounces
            double ouncesA;
            double ouncesB;
            double ouncesC;

            //Unit Prices
            double unitPriceA;
            double unitPriceB;
            double unitPriceC;

            //best item to buy
            String bestBuy;

            try {
                //Prices
                priceA = Double.parseDouble( priceEditTextA.getText().toString() );
                priceB = Double.parseDouble( priceEditTextB.getText().toString() );
                priceC = Double.parseDouble( priceEditTextC.getText().toString() );

                //Pounds
                poundsA = Double.parseDouble( poundsEditTextA.getText().toString() );
                poundsB = Double.parseDouble( poundsEditTextB.getText().toString() );
                poundsC = Double.parseDouble( poundsEditTextC.getText().toString() );

                //Ounces
                ouncesA = Double.parseDouble( ouncesEditTextA.getText().toString() );
                ouncesB = Double.parseDouble( ouncesEditTextB.getText().toString() );
                ouncesC = Double.parseDouble( ouncesEditTextC.getText().toString() );
           }

            catch( NumberFormatException nfe ) {
                // This check is just a precaution, since the user will be able to enter only numbers
                // into the EditText, as currently included in the layout (note the
                // android:inputType="numberDecimal" attribute).
                // However, we should have this check in case someone changes
                // the layout and uses a more general EditTexts accepting any chars as input.

                // Toast is a short message displayed to the user
                Toast toast = Toast.makeText( getApplicationContext(),
                        "Enter positive decimal values",
                        Toast.LENGTH_SHORT );
                toast.show();
                bestBuyEditText.setText( "Best buy: " );
                return;
            }

            //check if at least one product is entered
            if(((priceA <= 0.0) & (poundsA <= 0.0) & (ouncesA <= 0.0))
                    & ((priceB <= 0.0) & (poundsB <= 0.0) & (ouncesB <= 0.0))
                    & ((priceC <= 0.0) & (poundsC <= 0.0) & (ouncesC <= 0.0)))
            {
                Toast toast = Toast.makeText( getApplicationContext(),
                        "Enter at least one product",
                        Toast.LENGTH_SHORT );
                toast.show();
                bestBuyEditText.setText( "Best buy: " );
                return;
            }

            //No weight given, but price given
            if(((priceA > 0.0) & (poundsA <= 0.0) & (ouncesA <= 0.0))
                    || ((priceB > 0.0) & (poundsB <= 0.0) & (ouncesB <= 0.0))
                    || ((priceC > 0.0) & (poundsC <= 0.0) & (ouncesC <= 0.0)))
            {
                Toast toast = Toast.makeText( getApplicationContext(),
                        "Weights cannot be 0.00 for given price",
                        Toast.LENGTH_SHORT );
                toast.show();
                bestBuyEditText.setText( "Best buy: " );
                return;
            }

            //No price given, but weight given
            if(((priceA <= 0.0) & (poundsA >= 0.0) & (ouncesA >= 0.0))
                    || ((priceB <= 0.0) & (poundsB >= 0.0) & (ouncesB >= 0.0))
                    || ((priceC <= 0.0) & (poundsC >= 0.0) & (ouncesC >= 0.0)))
            {
                Toast toast = Toast.makeText( getApplicationContext(),
                        "Price cannot be $0.00 for given weights",
                        Toast.LENGTH_SHORT );
                toast.show();
                bestBuyEditText.setText( "Best buy: " );
                return;
            }

            //computing unit prices of each item

        }
    }
}