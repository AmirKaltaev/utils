package org.ailuna;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.util.Log;

public class AppIntentUtil {

    public static void openBrowser(Context context, String url){
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public static void openPhoneApp(Context context, String phoneNumber){
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber.trim(), null));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(callIntent);
    }

    public static void openEmailApp(Context context, String email, String subject){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:" + email + "?subject=" + subject);
        intent.setData(data);
        context.startActivity(intent);
    }

    public static void openWhatsApp(Context context, String phoneNumber) {
        try {
            phoneNumber = phoneNumber.replace(" ", "").replace("+", "");

            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(phoneNumber)+"@s.whatsapp.net");
            context.startActivity(sendIntent);

        } catch(Exception e) {
            Log.e("AppsIntentUtil", "ERROR_OPEN_WHATS_APP " + e.toString());
            openPhoneApp(context, phoneNumber);
        }
    }
}
