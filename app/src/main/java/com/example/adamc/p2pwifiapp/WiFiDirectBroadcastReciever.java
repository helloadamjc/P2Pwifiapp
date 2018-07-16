package com.example.adamc.p2pwifiapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.widget.Toast;

public class WiFiDirectBroadcastReciever extends BroadcastReceiver {
   private WifiP2pManager mManager;
   private WifiP2pManager.Channel mChannel;
   private MainActivity mActivity;


   public WiFiDirectBroadcastReciever(WifiP2pManager mManager,WifiP2pManager.Channel mChannel, MainActivity mActivity ){
       this.mActivity = mActivity;
       this.mChannel = mChannel;
       this.mManager = mManager;
   }


    @Override
    public void onReceive(Context context, Intent intent) {
       String action = intent.getAction();


       if(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)){
           int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);

           if(state == WifiP2pManager.WIFI_P2P_STATE_ENABLED){
               Toast.makeText(context, "WIFI is ON", Toast.LENGTH_SHORT).show();

           }
           else{
               Toast.makeText(context, "WIFI is OFF", Toast.LENGTH_SHORT).show();

           }
       }
       else if(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)){
           if(mManager!= null){
               mManager.requestPeers(mChannel, mActivity.peerListListener);
           }
       }
       else if(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)){

       }
       else if(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)){

       }

    }
}
