package com.madla.madlaherrellwaynelabact4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] aVersion, aName, aDate, aApi;
    ListView aList;
    int[] cLogo = {R.drawable.a1, R.drawable.b2, R.drawable.c3, R.drawable.d4, R.drawable.e5, R.drawable.f6, R.drawable.g7, R.drawable.h8, R.drawable.i9, R.drawable.j10, R.drawable.k11, R.drawable.l12, R.drawable.m13, R.drawable.n14, R.drawable.o15, R.drawable.p16, R.drawable.q17 };
    String[] aInfo;
    ArrayList<AndroidVer> aMainList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ANDROID VERSIONS");
        aVersion = getResources().getStringArray(R.array.android_Ver);
        aName = getResources().getStringArray(R.array.android_Str);
        aDate = getResources().getStringArray(R.array.android_Date);
        aApi = getResources().getStringArray(R.array.android_Api);
        aInfo = getResources().getStringArray(R.array.android_Desc);
        for (int i=0; i<aName.length; i++){
            aMainList.add(new AndroidVer(cLogo[i], aName[i], aVersion[i], aDate[i], aApi[i]));
        }
        aList = findViewById(R.id.lvAndroid);
        AndroidAdapter aAdapter = new AndroidAdapter(this, R.layout.activity_lvcontent, aMainList);
        aList.setAdapter(aAdapter);
        aList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        myDialog.setTitle(aMainList.get(i).getName());
        myDialog.setIcon(aMainList.get(i).getLogo());
        myDialog.setMessage(aInfo[i]);
        myDialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        myDialog.create().show();
    }
}
