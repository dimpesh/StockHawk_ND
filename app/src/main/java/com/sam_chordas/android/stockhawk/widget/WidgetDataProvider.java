package com.sam_chordas.android.stockhawk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.test.suitebuilder.annotation.Suppress;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMPESH : ${month}
 */

@SuppressLint("NewApi")
public class WidgetDataProvider implements RemoteViewsFactory
{

    List mCollections=new ArrayList();

    Context mContext=null;

    public WidgetDataProvider(Context context, Intent intent)
    {
        mContext=context;

    }
    @Override
    public int getCount()
    {
        return mCollections.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public RemoteViews getViewAt(int position)
    {
        RemoteViews mView=new RemoteViews(mContext.getPackageName(),android.R.layout.simple_list_item_1);

        mView.setTextViewText(android.R.id.text1, (CharSequence) mCollections.get(position));
        mView.setTextColor(android.R.id.text1, Color.BLUE);

        return mView;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }
    @Override
    public boolean hasStableIds() {
        return true;
    }


    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    private void initData()
    {
        mCollections.clear();
        for(int i=0;i<10;i++)
        {
            mCollections.add("List Item "+i);
        }
    }

    @Override
    public void onDestroy() {

    }

}
