package khm.kaunghtetmyint.burpple.adpaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import khm.kaunghtetmyint.burpple.R;
import khm.kaunghtetmyint.burpple.data.vo.GuidesVO;
import khm.kaunghtetmyint.burpple.viewholder.BurppleGuidesViewHolder;

/**
 * Created by User on 1/5/2018.
 */

public class BurppleGuidesAdapter extends RecyclerView.Adapter{

    private List<GuidesVO> mGuidesList;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View burppleGuidesView = inflater.inflate(R.layout.image_in_burpple_guides,parent,false);
        BurppleGuidesViewHolder burppleGuidesViewHolder = new BurppleGuidesViewHolder(burppleGuidesView);
        return burppleGuidesViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public void setData(List<GuidesVO> guidesList){
        mGuidesList = guidesList;
        notifyDataSetChanged();
    }
}
