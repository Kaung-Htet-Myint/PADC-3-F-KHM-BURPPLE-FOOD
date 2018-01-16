package khm.kaunghtetmyint.burpple.adpaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import khm.kaunghtetmyint.burpple.R;
import khm.kaunghtetmyint.burpple.data.vo.PromotionVO;
import khm.kaunghtetmyint.burpple.viewholder.BurpplePromotionsViewHolder;

/**
 * Created by User on 1/5/2018.
 */

public class BurpplePromotionsAdpater extends RecyclerView.Adapter{

    private List<PromotionVO> mPromotionList;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View burpplePromotionView = inflater.inflate(R.layout.imgae_in_burpple_promotions,parent,false);
        BurpplePromotionsViewHolder burpplePromotionsViewHolder= new BurpplePromotionsViewHolder(burpplePromotionView);

        return burpplePromotionsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public void setData(List<PromotionVO> promotionsList){
        mPromotionList = promotionsList;
        notifyDataSetChanged();
    }
}
