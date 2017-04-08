package sarvesh.auth.com.binderothersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;


/**
 * Created by vikalp on 3/19/2017.
 */


@EActivity(R.layout.activity_main) // Sets content view to R.layout.translate
public class BindingLayout extends FragmentActivity{


    @ViewById(R.id.firstValueEdit)
    EditText userNameEdit;
//
    @ViewById(R.id.secValueEdit)
    EditText passwordEdit;

    @ViewById(R.id.resultText)
    TextView resultText;

    @ViewById(R.id.countBtn)
    Button countBtn;

    @ViewById(R.id.countBtn1)
    Button countBtn1;

    @AfterViews
    void afterViews() {
        // TODO: Do something after the views are injected
//        resultText.setText("Hello World!");
    }
//
//
//
    @Click({R.id.countBtn,R.id.countBtn1})
    void onMyButtonClick(View view) {
        // TODO: My button clicked. Do something

        switch (view.getId()){
            case R.id.countBtn:

                Toast.makeText(BindingLayout.this,"Click on count btn...",Toast.LENGTH_SHORT).show();
                translateInBackground("coming soon");
                break;
            case R.id.countBtn1:

                Toast.makeText(BindingLayout.this,"Click on count btn 1...",Toast.LENGTH_SHORT).show();
                translateInBackground("coming soon");
                break;
        }
    }

    @Background
        // Executed in a background thread
    void translateInBackground(String textToTranslate) {
        String translatedText = callGoogleTranslate(textToTranslate);
//        showResult(translatedText);
    }


    @UiThread // Executed in the ui thread
    void showResult(String translatedText) {
        resultText.setText(translatedText);
    }

    private String callGoogleTranslate(String textToTranslate) {

        return "resultResponse ";

    }
}
