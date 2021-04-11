package akeen.app.SpotApp.Login;

import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import akeen.app.SpotApp.BarraNavegacionInferior.BottomNavigationVw;
import akeen.app.SpotApp.R;
import core.Kernel;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class LoginActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener, View.OnClickListener{

    private static final String TAG = "LoginActivity";
    public static final int SIGN_IN_CODE = 777;

    private FirebaseAuth _oAuth;
    private FirebaseAuth.AuthStateListener _oFirebaseAuthListener;
    private SignInButtonImpl _btnSignIn;
    private GoogleApiClient _mGoogleApiClient;
    private ProgressBar _oProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Configuración de inicio de sesión con Google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.
                DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        _mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        //Incialización UI Components y modificamos sus propiedades
        _btnSignIn = (SignInButtonImpl) findViewById(R.id.sign_in_button);
        _oProgressBar = (ProgressBar) findViewById(R.id.progressBar);



        _btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(_mGoogleApiClient);
                startActivityForResult(intent, SIGN_IN_CODE);
            }
        });

        //Referencia a objeto FirebaseAuth
        _oAuth = FirebaseAuth.getInstance();

        _oFirebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null)
                {
                    goMainScreen();
                }
            }
        };

        //Inicializamos la configuracion de la BBDD interna
        Realm.init(this);
        final RealmConfiguration migrationConfig = new RealmConfiguration.Builder()
                .build();
        Realm.setDefaultConfiguration(migrationConfig);
        Realm.getInstance(migrationConfig);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            firebaseAuthWithGoogle(result.getSignInAccount());
        } else {
            Log.e( "handleSignInResult:", result.getStatus().toString());
            Toast.makeText(this, "Error en Login", Toast.LENGTH_SHORT).show();
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount signInAccount) {

        _oProgressBar.setVisibility(View.VISIBLE);
        _btnSignIn.setVisibility(View.GONE);

        AuthCredential credential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(),
                null);
        _oAuth.signInWithCredential(credential).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                _oProgressBar.setVisibility(View.GONE);
                _btnSignIn.setVisibility(View.VISIBLE);

                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Error de inicio de Sesion",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Añadimos el listener
        _oAuth.addAuthStateListener(_oFirebaseAuthListener);
    }

    /**
     * Lanzamos la App a la vista principal
     */
    private void goMainScreen()
    {
        Intent intent = new Intent(LoginActivity.this, BottomNavigationVw.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();

        //En caso de pausar el proceso eliminamos el Listener
        if (_oFirebaseAuthListener != null) {
            _oAuth.removeAuthStateListener(_oFirebaseAuthListener);
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
