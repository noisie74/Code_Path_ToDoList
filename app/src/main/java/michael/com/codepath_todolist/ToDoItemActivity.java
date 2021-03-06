package michael.com.codepath_todolist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToDoItemActivity extends AppCompatActivity {

    @BindView(R.id.fab)
    public FloatingActionButton mFabButton;
    @BindView(R.id.header)
    public TextView mItemTitle;
    @BindView(R.id.editText)
    public EditText mEditText;
    @BindView(R.id.list_view)
    public ListView mListView;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_item);
        ButterKnife.bind(this);

        String itemText = getIntent().getStringExtra(MainActivity.ITEM_DATA);
        position = getIntent().getIntExtra(MainActivity.POSITION, 0);
        mItemTitle.setText(itemText);

        editText();
    }


    private void editText() {
        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEditText.getText().toString().isEmpty()) {
                    String getItemsDescription = mEditText.getText().toString();
                    mEditText.setText("");
                    mItemTitle.setText(getItemsDescription);
                    onEditItem();
                }

            }
        });
    }


    public void onEditItem() {
        Intent data = new Intent();
        data.putExtra(MainActivity.EDITED_TEXT, mItemTitle.getText().toString());
        data.putExtra(MainActivity.POSITION, position);
        setResult(RESULT_OK, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
