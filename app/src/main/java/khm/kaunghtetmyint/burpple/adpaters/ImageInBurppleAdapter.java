package khm.kaunghtetmyint.burpple.adpaters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import khm.kaunghtetmyint.burpple.R;
import khm.kaunghtetmyint.burpple.viewitems.ImageInBurppleViewItem;

import static android.os.Build.VERSION_CODES.O;

/**
 * Created by User on 1/4/2018.
 */

public class ImageInBurppleAdapter extends PagerAdapter {

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
            return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImageInBurppleViewItem viewItem = (ImageInBurppleViewItem) layoutInflater.inflate
                                                                        (R.layout.item_burpple_image,container,false);
        container.addView((viewItem));
        return viewItem;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }
}
