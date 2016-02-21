package com.vatsal.android.newcarx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static  int RC_SIGN_IN ;
    private static  String TAG ;
    /**
     * Id to identity READ_CONTACTS permission request.
     */

    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build();
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
   // private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button mLiveMaps;
    private GoogleApiClient mGoogleApiClient;
    private Button sign_in;
    private TextView mStatusTextView;
    private Button mDriverScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDriverScore = (Button) findViewById(R.id.DriverScore);
        mDriverScore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, DriverScoreActivity.class);
                startActivity(i);
            }


        });

       /* mLiveMaps = (Button)findViewById(R.id.LiveMaps);
        mLiveMaps.setOnClickListener(new View.OnClickListener() {
            protected String TAG;

            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MapsActivity.class);
                startActivity(i);
*/
                mGoogleApiClient = new GoogleApiClient.Builder(this)
                        .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                        .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                        .build();
                sign_in = (Button) findViewById(R.id.sign_in);
                sign_in.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {

                        switch (v.getId()) {
                            case R.id.sign_in:
                                signIn();
                                break;


                        }
                    }
                });
            }
                        


                    private void signIn() {
                        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                        startActivityForResult(signInIntent,RC_SIGN_IN );
                    }


                    @Override
                    public void onActivityResult(int requestCode, int resultCode, Intent data) {
                        super.onActivityResult(requestCode, resultCode, data);

                        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
                        if (requestCode == RC_SIGN_IN) {
                            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                            handleSignInResult(result);
                        }
                    }


                    private void handleSignInResult(GoogleSignInResult result) {
                        
                        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
                        if (result.isSuccess()) {

                            Intent i = new Intent(LoginActivity.this, MapsActivity.class);
                            startActivity(i);
                            // Signed in successfully, show authenticated UI.
                            // GoogleSignInAccount acct = result.getSignInAccount();
                            // mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
                            //updateUI(true);
                        } else {
                            // Signed out, show unauthenticated UI.
                            System.out.println("Not Signed in: ");
                        }
                    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        
    }
}



                
