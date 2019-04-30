package com.thriftyApp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

public class scanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_scan);

        ImageView imageView = (ImageView) findViewById (R.id.image_view);
        Bitmap bitmap;
        TextView txtView = (TextView) findViewById (R.id.txtView);
        // To get bitmap from resource folder of the application.
        bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.billshop);
// Starting Text Recognizer
        TextRecognizer txtRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
        if (!txtRecognizer.isOperational())
        {
            // Shows if your Google Play services is not up to date or OCR is not supported for the device
            txtView.setText("Detector dependencies are not yet available");
        }
        else
        {
            // Set the bitmap taken to the frame to perform OCR Operations.
            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray items = txtRecognizer.detect(frame);
            StringBuilder strBuilder = new StringBuilder();
            // The following Process is used to show how to use lines & elements as well
            for (int i = 0; i < items.size(); i++) {
                TextBlock item = (TextBlock) items.valueAt(i);
                strBuilder.append(item.getValue());
                strBuilder.append("/");
                for (Text line : item.getComponents()) {
                    //extract scanned text lines here
                    Log.v("lines", line.getValue());
                    for (Text element : line.getComponents()) {
                        //extract scanned text words here
                        Log.v("element", element.getValue());
                    }
                }
            }

            txtView.setText(strBuilder.toString());
        }
    }
}
