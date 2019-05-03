package top.linxixiangxin.userinterface;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class myAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> ListItems;
    private LayoutInflater listContainer;
    public Map<Integer, Boolean>cbxFlag = null;
    public class ViewHolder{
        public ImageView image;
        public TextView name;
        public TextView msg;
        public CheckBox cbx;
        public Button detail;
    }
    public myAdapter(Context context,List<Map<String,Object>>listItems){
    this.context = context;
    listContainer = LayoutInflater.from(context);
    this.ListItems = listItems;
    cbxFlag = new HashMap<Integer, Boolean>();
    init();
    }

    private void init() {
        for(int i = 0;i<ListItems.size();i++){
            cbxFlag.put(i,false);
        }

    }


    @Override
    public int getCount() {
        return ListItems.size();
    }

    @Override
    public Object getItem(int i) {// means position
        return ListItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public boolean hasChecked(int position){
        return cbxFlag.get(position);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int selectID = i;
        ViewHolder holder = null;
        if(view ==null){
            holder = new ViewHolder();
            view = listContainer.inflate(R.layout.friend_list_item_layout,null);
            holder.image = view.findViewById(R.id.iv_friend);
            holder.name = view.findViewById(R.id.tv_friend_name);
            holder.msg = view.findViewById(R.id.tv_friend_msg);
            holder.cbx = view.findViewById(R.id.cbx_friend);
            holder.detail = view.findViewById(R.id.btn_friend_detail);
            view.setTag(holder);
        }else{
            holder =(ViewHolder) view.getTag();
        }
        if (i % 2 == 0) {
            view.setBackgroundColor(Color.parseColor("#CAFFFF"));
        }else{
            view.setBackgroundColor(Color.parseColor("#B3FAFAFA"));
        }
        holder.image.setImageResource((Integer)ListItems.get(i).get("image"));
        holder.name.setText((String) ListItems.get(i).get("name"));
        holder.msg.setText((String)ListItems.get(i).get("msg"));
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setIcon((Integer) ListItems.get(selectID).get("image"))
                        .setTitle((String)ListItems.get(selectID).get("name"))
                        .setMessage((String)ListItems.get(selectID).get("info"))
                        .setPositiveButton("确定",null)
                        .create()
                        .show();
            }
        });
        holder.cbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbxFlag.put(selectID,true);
                }else{
                    cbxFlag.put(selectID,false);
                }
            }
        });
        holder.cbx.setChecked(cbxFlag.get(selectID));
        return view;
    }
}
