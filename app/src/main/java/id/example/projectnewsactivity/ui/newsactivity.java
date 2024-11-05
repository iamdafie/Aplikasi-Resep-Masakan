package id.example.projectnewsactivity.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;

import id.example.projectnewsactivity.R;
import id.example.projectnewsactivity.util.Constans;

public class newsActivity extends AppCompatActivity {
    private WebView mWebView;
    private ImageView imgDetail;
    private TextView txtTitleDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgDetail = findViewById(R.id.imgDetail);
        txtTitleDetail = findViewById(R.id.txtTitleDetail);
        mWebView = findViewById(R.id.webData);

        //load title
        txtTitleDetail.setText(Constans.TITLE);
        //load image
        Picasso.get().load(Constans.IMAGE).into(imgDetail);

        //load description
        mWebView.loadDataWithBaseURL(null, "<head><style>img{max-width: 90%; width:auto; height: auto;}</style></head>" + Constans.DESCRIPTION, "text/html", "UTF-8", null);
}
}