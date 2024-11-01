package com.example.uicomponents;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity {
    private Context context;

    public DialogActivity(Context context) {
        this.context = context;
    }

    // 显示自定义的 AlertDialog
    public void showLoginDialog() {
        // 使用 LayoutInflater 加载自定义布局
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.layout_dialog, null);

        // 创建 AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 获取输入的用户名和密码
                        EditText usernameInput = dialogView.findViewById(R.id.username);
                        EditText passwordInput = dialogView.findViewById(R.id.password);
                        String username = usernameInput.getText().toString();
                        String password = passwordInput.getText().toString();

                        // 验证并显示
                        if (username.isEmpty() || password.isEmpty()) {
                            Toast.makeText(context, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "用户名: " + username + "\n密码: " + password, Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
