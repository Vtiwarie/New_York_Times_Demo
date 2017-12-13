package demo.nytimes.vishaan.com.newyorktimesdemo.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by vishaantiwarie on 12/12/17.
 */

public class ImageUtil {
    public static void loadImage(Context context, ImageView imageView, String url) {
        if (imageView == null || TextUtils.isEmpty(url)) {
            return;
        }
        Picasso
                .with(context)
                .load(url)
                .into(imageView);
    }
}
