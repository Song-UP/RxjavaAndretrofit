package dialersms.xiake.com.dialersmsapp.adapter.baseRc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by wusong on 2018/1/16.
 *
 */

public class BaseRCViewHold extends RecyclerView.ViewHolder {
    SparseArray<View> viewSpare;
    View itemView;
    Context context;

    public static BaseRCViewHold get(Context context, View itemView){
        return new BaseRCViewHold(context, itemView);
    }

    public static BaseRCViewHold get(Context context, int itemId, ViewGroup viewGroup){
        View itemView = LayoutInflater.from(context).inflate(itemId, viewGroup,false);
        return new BaseRCViewHold(context, itemView);
    }

    public BaseRCViewHold(Context context, View itemView) {
        super(itemView);
        this.context = context;
        this.itemView = itemView;
        viewSpare = new SparseArray<>();
    }




    public View getContentView(){
        return this.itemView;
    }

    public <T extends View> T getView(int viewId){
        View view = viewSpare.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            viewSpare.put(viewId, view);
        }
        return (T) view;
    }


    public void setViesible(int viewId, int isVisible){
        getView(viewId).setVisibility(isVisible);

    }

    /**
     * 点击事件监听
     * @param viewId
     * @param onClickListener
     * @return
     */

    public BaseRCViewHold setOnClickLister(int viewId , View.OnClickListener onClickListener){
        getView(viewId).setOnClickListener(onClickListener);
        return this;
    }
    public BaseRCViewHold setOnLongClickLister(int viewId , View.OnLongClickListener onLongClickListener){
        getView(viewId).setOnLongClickListener(onLongClickListener);
        return this;
    }

    /**
     * 图片
     */
    public BaseRCViewHold setImageResource(int viewId, int iconId){
        ImageView imageView = getView(viewId);
        imageView.setImageResource(iconId);
        return this;
    }

    public BaseRCViewHold setImageGlide(Context context, int viewId, String url, int errorId){

        ImageView imageView = getView(viewId);
        Glide.with(context)
                .load(url)
                //.transition(new DrawableTransitionOptions().crossfade(500))
                .apply(new RequestOptions()
//                    .placeholder(errorId)
                    .error(errorId))
                .into(imageView);

        return this;

    }

    /**
     * 文字
     */

    public BaseRCViewHold setText(int viewId, int strId){
        setText(viewId, context.getString(strId));
        return this;
    }
    public BaseRCViewHold setText(int viewId, String str){
        TextView textView = getView(viewId);
        textView.setText(str);
        return this;
    }

    public BaseRCViewHold setTextColor(Context context, int viewId, int colorReId){
        TextView textView = getView(viewId);
        textView.setTextColor(context.getResources().getColor(colorReId));
        return this;
    }

    /**
     * 复选框
     */
    public void checkBox(int id, boolean isCheck){
        CheckBox checkBox = getView(id);
        checkBox.setClickable(isCheck);
    }
    public void setOnCheckBoxListener(int id, CompoundButton.OnCheckedChangeListener onCheckedChangeListener){
        CheckBox checkBox = getView(id);
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);

    }


}
