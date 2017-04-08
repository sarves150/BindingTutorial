package sarvesh.auth.com.binderothersample;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class AIDLUsingBindService extends Service {
    public AIDLUsingBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");


//        return messenger.getBinder();
        return myAIDLDemoService;
    }


    MyAIDLDemoService.Stub myAIDLDemoService = new MyAIDLDemoService.Stub() {


        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }


    };

    class MessageHandler extends Handler{


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            switch (msg.what){

            }

        }
    }


    Messenger messenger = new Messenger(new MessageHandler());

}
