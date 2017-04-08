package sarvesh.auth.com.binderothersample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    MyAIDLDemoService aidlUsingBindService;

    Messenger _messenger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // AIDL Binding using service
        Intent callServiceIntent = new Intent(this,AIDLUsingBindService.class);
        bindService(callServiceIntent,serviceConnection, Context.BIND_AUTO_CREATE);


        // AIDL Binding using Messenger
//        Intent callMessengerIntent = new Intent(this,AIDLUsingBindService.class);
//        bindService(callMessengerIntent,serviceConnection, Context.BIND_AUTO_CREATE);


    }

    public void count(View v) throws RemoteException {


        TextView showTxt = (TextView) findViewById(R.id.showTxt);
        EditText firstValueEdit = (EditText) findViewById(R.id.firstValueEdit);
        EditText secValueEdit = (EditText) findViewById(R.id.secValueEdit);

        int _firstVal = Integer.parseInt(firstValueEdit.getText().toString());
        int _secVal = Integer.parseInt(secValueEdit.getText().toString());
        int value = aidlUsingBindService.add(_firstVal,_secVal);

        Message msgg=new Message();
        msgg.arg1=1;
        msgg.what=2;
        _messenger.send(msgg);

        showTxt.setText(""+value);

    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {


            aidlUsingBindService = MyAIDLDemoService.Stub.asInterface(service);

            _messenger = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            aidlUsingBindService = null;
            _messenger = null;
        }
    };
}
