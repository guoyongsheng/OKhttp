package demo.wesley.com.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

/**
 * @author wesley
 * @date: 2017-7-25
 * @Description:
 */

public class SecondActivity extends AppCompatActivity {

    private ViewStub viewStub;
    private Button btn_show;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        initView();
    }

    private void initView() {
        viewStub = (ViewStub) findViewById(R.id.view_stub);
        btn_show = (Button) findViewById(R.id.show);
    }

    public void show(View view) {
        int tag = Integer.parseInt(btn_show.getTag().toString());
        if (tag == 0) {
            View views = viewStub.inflate();
            Button btn_view_stub = (Button) views.findViewById(R.id.btn);
            btn_show.setTag("1");
            btn_view_stub.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        } else {
            viewStub.setVisibility(View.VISIBLE);
        }
    }

    public void hide(View view) {
        viewStub.setVisibility(View.INVISIBLE);
    }
}
