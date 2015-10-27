package in.lucasdup.bringtofront;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.app.PendingIntent;
import android.util.Log;

/**
 * This class echoes a string called from JavaScript.
 */
public class BringToFront extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    Log.d("Bring", "action is:" + action);
    if (action.equals("bringToFront")) {
      Log.d("Bring", "I see you baby");
      Intent notificationIntent = new Intent(cordova.getActivity(), cordova.getActivity().getClass());
      notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
      PendingIntent pendingIntent = PendingIntent.getActivity(cordova.getActivity(), 0, notificationIntent, 0);
      try 
      {
        pendingIntent.send();
      }
      catch (PendingIntent.CanceledException e) 
      {
        e.printStackTrace();
      }
      return true;
    }
    return false;
  }
}
