package rdm.firstandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView firstTextView = (TextView) findViewById(R.id.textView);

//        Button firstButton = (Button)findViewById(R.id.createContactButton);
//
//        firstButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                //Intent getCreateContactScreen = new  Intent(  view , CreateContactScreen.class  );
//                final int result = 1;
//                /* firstTextView.setText("You clicked"); */
//            }
//        });
    }


    public void onClickCreateContact(View view) {
        Intent getCreateContactScreen = new Intent(this, CreateContactScreen.class);
        final int result = 1;
        getCreateContactScreen.putExtra("callingActivity" , "MainActivity");
        startActivityForResult(getCreateContactScreen, result);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            TextView contactNameTextBox = (TextView) findViewById(R.id.contactNameTextBox);

            ContactInfo contactReturned = (ContactInfo) data.getSerializableExtra("UserFromCreateContact");

            contactNameTextBox.setText(contactReturned.AltToString());
        }
    }
}

