package top.linxixiangxin.userinterface;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class wechat_moment extends BaseAdapter {
    private Context context; //上下文
    private List<Map<String,Object>>listItems;
    private LayoutInflater listContainer;
    public class ViewHolder{
        public ImageView image;
        public TextView user_name;
        public TextView user_content;
        public TextView sendTime;
    }
    public wechat_moment(Context context,List<Map<String,Object>>listItems){
        this.context = context;
        listContainer = LayoutInflater.from(context);
        this.listItems = listItems;
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
        final int selectId = i;
        ViewHolder holder = null;
        if(view == null){
            holder = new ViewHolder();
            view = listContainer.inflate(R.layout.wechat_moment,null);
            holder.image = view.findViewById(R.id.friend_head_img);
            holder.user_name = view.findViewById(R.id.moment_Name);
            holder.user_content = view.findViewById(R.id.moment_content);
            holder.sendTime = view.findViewById(R.id.moment_sendtime);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.image.setImageResource((Integer) listItems.get(i).get("image"));
        holder.user_name.setText((String) listItems.get(i).get("username"));
        holder.user_content.setText((String) listItems.get(i).get("usercontent"));
        holder.sendTime.setText((String) listItems.get(i).get("sendtime"));
        return view;
    }
}
