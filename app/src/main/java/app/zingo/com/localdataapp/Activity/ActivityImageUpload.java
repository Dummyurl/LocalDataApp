package app.zingo.com.localdataapp.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import app.zingo.com.localdataapp.R;
import app.zingo.com.localdataapp.Utils.Permission;

public class ActivityImageUpload extends AppCompatActivity {

    private ImageView image;
    TextView upload;
    private String userChoosenTask;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;

    private Bitmap thumbnail;
    private String imgString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);

        getSupportActionBar().setHomeAsUpIndicator((int)R.drawable.ic_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Upload Image");

        image = (ImageView)findViewById(R.id.image_activity); 
        upload = (TextView)findViewById(R.id.button_upload); 
        selectImage();
    }

    private void selectImage() {
        final CharSequence[] items = {"Choose from Library",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityImageUpload.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result= Permission.checkPermission(ActivityImageUpload.this);
                if (items[item].equals("Choose from Library")) {
                    userChoosenTask="Choose from Library";
                    //if(result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            
        }
    }

    private void onSelectFromGalleryResult(Intent data) {

        thumbnail=null;
        if (data != null) {
            try {
                thumbnail = MediaStore.Images.Media.getBitmap(ActivityImageUpload.this.getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        image.setImageBitmap(thumbnail);
        try {
            imageConvrt(thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
//            imageView2.setImageBitmap(bm);
    }

    public String imageConvrt(Bitmap bitmap) {
        System.out.println("Bitmap==2"+bitmap);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        // get the base 64 string
        imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);
        System.out.println("bitmap===3"+imgString);
        return imgString;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case android.R.id.home:
                ActivityImageUpload.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
