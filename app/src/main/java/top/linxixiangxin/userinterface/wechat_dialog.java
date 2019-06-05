package top.linxixiangxin.userinterface;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class wechat_dialog extends Dialog {
    public wechat_dialog(@androidx.annotation.NonNull Context context) {
        super(context);
    }

    public wechat_dialog(@androidx.annotation.NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected wechat_dialog(@androidx.annotation.NonNull Context context, boolean cancelable, @androidx.annotation.Nullable DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
