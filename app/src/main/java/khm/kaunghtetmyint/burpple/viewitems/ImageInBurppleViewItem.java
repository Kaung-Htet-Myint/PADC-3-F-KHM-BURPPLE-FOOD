package khm.kaunghtetmyint.burpple.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import khm.kaunghtetmyint.burpple.R;

/**
 * Created by User on 1/4/2018.
 */

public class ImageInBurppleViewItem extends FrameLayout{
    @BindView(R.id.iv_burpple_background)
    ImageView ivBurppleBackground;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public ImageInBurppleViewItem(@NonNull Context context) {
        super(context);
    }

    public ImageInBurppleViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageInBurppleViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(String imageUrl){

        Glide.with(ivBurppleBackground.getContext())
                .load(imageUrl)
                .into(ivBurppleBackground);

    }
}
