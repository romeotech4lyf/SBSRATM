package com.tech4lyf.SBSRATM;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText editBCID;
    private TextInputEditText editPassword;
    private CardView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editBCID = findViewById(R.id.edit_bcid);
        editPassword = findViewById(R.id.edit_password);
        signIn = findViewById(R.id.sign_in);
        signIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in:
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, DashBoardActivity.class));
                LoginActivity.this.finish();
                break;
            default:
                break;
        }
    }
}
