package kr.ac.yeonsung.seoj.mobile1project_1107_03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    ArrayList<String> arrList = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        Button btnAdd = findViewById(R.id.btn_add);
        ListView list = findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrList);
        list.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrList.add(edit1.getText().toString());
                adapter.notifyDataSetChanged(); //갱신
            }
        });
        //항목 삭제
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("정말로 삭제하시겠습니까?");
                dialog.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrList.remove(itemIndex); //어래이리스트에 들어있는 항목을 삭제한다.
                        adapter.notifyDataSetChanged(); //41,42 삭제 실행시키기 1114
                    }
                });
                dialog.setNegativeButton("취소",null); //화면만 닫히게 함 = null
                dialog.show();
                return false;
            }
        });

    }
}