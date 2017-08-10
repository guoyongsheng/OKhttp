package demo.wesley.com.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.shaohui.advancedluban.Luban;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

       /* OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Request request = new Request
                .Builder()
                .url("")
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

            }
        });*/


        init();

    }

    private void init() {

        final ImageView imageView = (ImageView) findViewById(R.id.iv);
        String path = "/storage/emulated/0/Pictures/Screenshots/Screenshot_2017-07-25-18-25-05.jpeg";
        File file = new File(path);


        Observable.timer(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

        Luban.compress(this, file)
                .putGear(Luban.CUSTOM_GEAR)
                .asObservable()                             // 生成Observable
                .subscribe(new Consumer<File>() {
                    @Override
                    public void accept(File file) throws Exception {
                        Glide.with(MainActivity.this).load(file).into(imageView);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });


    }
}
