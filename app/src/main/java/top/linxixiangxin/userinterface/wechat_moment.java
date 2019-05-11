package top.linxixiangxin.userinterface;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class wechat_moment extends BaseAdapter {
    private Context context; //上下文
    private List<Map<String, Object>> listItems;
    private LayoutInflater listContainer;

    public class ViewHolder {
        public ImageView image;
        public TextView user_name;
        public TextView user_content;
        public TextView sendTime;
        public ImageView header_img,gimg1,gimg2,gimg3,gimg4,gimg5,gimg6;
    }

    public wechat_moment(Context context, List<Map<String, Object>> listItems) {
        this.context = context;
        listContainer = LayoutInflater.from(context);
        this.listItems = listItems;
    }

    @Override
    public int getItemViewType(int position) { //查得只支持两种Type故弃用
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        ViewHolder holder1 = null;
        view = null;
        if (view == null) {
            switch (i) {
                case 0://头秃（图）
                    //通过这种方法来设置不同的View
                    view = LayoutInflater.from(context).inflate(R.layout.wechat_header, null);
                    holder1 = new ViewHolder();
                    view = listContainer.inflate(R.layout.wechat_header, null);
                    holder1.header_img = view.findViewById(R.id.wechat_header_img);
                    view.setTag(holder1);
                    break;
                default:
                    holder = new ViewHolder();
                    view = listContainer.inflate(R.layout.wechat_moment, null); //设置布局
                    holder.image = view.findViewById(R.id.friend_head_img);
                    holder.user_name = view.findViewById(R.id.moment_Name);
                    holder.user_content = view.findViewById(R.id.moment_content);
                    holder.sendTime = view.findViewById(R.id.moment_sendtime);
                    holder.img_display = view.findViewById(R.id.grid_pic);
                    view.setTag(holder);
                    break;
            }

        } else {
            switch (i) {
                case 0:
                    holder1 = (ViewHolder) view.getTag();
                    break;
                default:
                    holder = (ViewHolder) view.getTag();
                    break;
            }

        }
        switch (i){
            case 0:
                holder1.header_img.setImageResource(R.drawable.head_pic);
                break;
                default:
                    holder.image.setImageResource((Integer) listItems.get(i).get("image"));
                    holder.user_name.setText((String) listItems.get(i).get("username"));
                    holder.user_content.setText((String) listItems.get(i).get("usercontent"));
                    holder.sendTime.setText((String) listItems.get(i).get("sendtime"));
                    holder.img_display.;
                    break;
        }

        return view;
    }
}
