package rdm.firstandroid;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


/**
 * Created by Owner on 9/26/2016.
 */
public class CreateContactScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the view
        setContentView(R.layout.contact_entry);

        //Get the intent that called the activity
        Intent activityThatCalled = getIntent();

        //
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        //
//        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text);
//        callingActivityMessage.append(" " + previousActivity);

        final TextView textPreviousActivity = (TextView) findViewById(R.id.textPreviousActivity);

        //Text box for samples. Could be removed
        textPreviousActivity.setText(previousActivity);

        //Create phone watcher to monitor format of number coming in.  Locale is used to get current country code
        PhoneNumberFormattingTextWatcher phoneWatcher = new PhoneNumberFormattingTextWatcher(Locale.getDefault().getCountry());
        //text box is created so it can be watched
        EditText contactPhone = (EditText) findViewById(R.id.contactPhoneTextBox);
        //listener is connected to textbox
        contactPhone.addTextChangedListener(phoneWatcher);





    }

    public void onSaveContactInfo(View view) {


        EditText contactName = (EditText) findViewById(R.id.contactNameEditTextBox);
        EditText contactPhone = (EditText) findViewById(R.id.contactPhoneTextBox);
        EditText contactAddress = (EditText) findViewById(R.id.contactAddressTextBox);
        EditText contactEmail = (EditText) findViewById(R.id.contactEmailTextBox);
        EditText contactOther = (EditText) findViewById(R.id.contactOtherTextBox);


        String contactNameString = String.valueOf(contactName.getText());
        //Integer contactPhoneInt = Integer.valueOf(Integer.parseInt(contactPhone.getText().toString()));
        Integer contactPhoneInt =  (!contactPhone.getText().toString().equals("")) ? Integer.parseInt(contactPhone.getText().toString()) : 0;
        String contactAddressString = String.valueOf(contactAddress.getText());
        String contactEmailString = String.valueOf(contactEmail.getText());
        String contactOtherString = String.valueOf(contactOther.getText());

        if(contactNameString.isEmpty()){
            Toast.makeText(getApplicationContext(), "Enter a name.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(contactEmailString).matches()){  // ||  contactEmailString.isEmpty()
            Toast.makeText(getApplicationContext(), "Email invalid. Please enter email address", Toast.LENGTH_SHORT).show();
            return;
        }

            ContactInfo theUserToSend = new ContactInfo( contactNameString, contactAddressString, contactPhoneInt, contactEmailString, contactOtherString );

            Intent goingBack = new Intent();

            goingBack.putExtra("UserFromCreateContact" , theUserToSend);

            setResult(RESULT_OK, goingBack);

            finish();
    }

    public void onCancelContactInfo(View view) {
        Intent goingBack = new Intent();
        setResult(RESULT_CANCELED, goingBack);
        finish();
    }
}
