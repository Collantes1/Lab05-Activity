package com.example.lab05_activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.editTextTextPersonName2);
    }

    public void on_dialog_click(View v)
    {
        String s = txt.getText().toString();
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("abc", s);
        startActivityForResult(i, 555);
    }

    public void on_exit_click(View v)
    {
        // Создание диалогового окна для выхода из приложения
        AlertDialog.Builder dialog = new AlertDialog.Builder(this); // Создание окна
        dialog.setTitle("Выход из приложения"); // Оглавнение окна
        dialog.setIcon(android.R.drawable.ic_dialog_info); // Добавление иконки в диалоговое окно
        dialog.setCancelable(true);
        dialog.setMessage("Вы действительно хотите выйти из приложения?"); // Сообщение о выходе из приложеемя
        dialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                return;
            }
        });
        dialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                dialog.cancel();
            }
        });
        dialog.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode == 555)
        {
            if (data != null)
            {
                String s = data.getStringExtra("qwe");
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}