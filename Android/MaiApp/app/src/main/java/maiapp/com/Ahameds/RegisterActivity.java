package maiapp.com.Ahameds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText Email,P1,P2;
    Button SignUp;
    TextView Progress;

    FirebaseAuth FireBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Email = findViewById(R.id.email1);
        P1 = findViewById(R.id.pswd2);
        P2 = findViewById(R.id.pswdc);
        Progress = findViewById(R.id.tv);

        SignUp = (Button) findViewById(R.id.sup2);

        FireBase = FirebaseAuth.getInstance();

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ProEmail = Email.getText().toString().trim();
                String ProP1 = P1.getText().toString().trim();
                String ProP2 = P2.getText().toString().trim();

                if(TextUtils.isEmpty(ProEmail)){
                    Toast.makeText(RegisterActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                    return ;
                }

                if(TextUtils.isEmpty(ProP1)){
                    Toast.makeText(RegisterActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return ;
                }

                if(TextUtils.isEmpty(ProP2)){
                    Toast.makeText(RegisterActivity.this, "Confirm Password", Toast.LENGTH_SHORT).show();
                    return ;
                }

                if(ProP1.length()<6){
                    Toast.makeText(RegisterActivity.this, "Password Too Short", Toast.LENGTH_SHORT).show();
                    return ;
                }

                if(!ProP1.equals(ProP2)){
                    Toast.makeText(RegisterActivity.this, "Password Doesn't Match", Toast.LENGTH_SHORT).show();
                    return ;
                }

                if(ProP1.equals(ProP2)){

                    FireBase.createUserWithEmailAndPassword(ProEmail,ProP1).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {


                                startActivity(new Intent(RegisterActivity.this,LogInActivity.class));
                                // Sign in success, update UI with the signed-in user's information

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterActivity.this, "Sign Up unsuccessfull! Try Again! :(", Toast.LENGTH_SHORT).show();
                              
                            }
                        }
                    });




                }

            }
        });



    }
}
