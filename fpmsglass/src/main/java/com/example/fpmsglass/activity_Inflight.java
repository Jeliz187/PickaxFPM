package com.example.fpmsglass;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: document your custom view class.
 */
public class activity_Inflight extends Activity {

    private List<CardBuilder> mCards;
    private CardScrollView mCardScrollView;
    private ExampleCardScrollAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createCards();

        mCardScrollView = new CardScrollView(this);
        mAdapter = new ExampleCardScrollAdapter();
        mCardScrollView.setAdapter(mAdapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    private void createCards() {
        mCards = new ArrayList<CardBuilder>();

        mCards.add(new CardBuilder(this, CardBuilder.Layout.TEXT)
                .setText("Flight Plan\nManagement System")
                .setFootnote("Pickax FPMS"));

        mCards.add(new CardBuilder(this, CardBuilder.Layout.COLUMNS)
                .setText("Speed:\n\nRm Fuel:")
                .setFootnote("Pickax FPMS"));

        mCards.add(new CardBuilder(this, CardBuilder.Layout.COLUMNS)
                .setText("Heading:\n\nAltitude")
                .setFootnote("Pickax FPMS"));

        mCards.add(new CardBuilder(this, CardBuilder.Layout.COLUMNS)
                .setText("ETA:\n\nRTA:")
                .setFootnote("Pickax FPMS"));

        mCards.add(new CardBuilder(this, CardBuilder.Layout.COLUMNS)
                .setText("Weather:")
                .setFootnote("Pickax FPMS"));
    }

    private class ExampleCardScrollAdapter extends CardScrollAdapter {

        @Override
        public int getPosition(Object item) {
            return mCards.indexOf(item);
        }

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public Object getItem(int position) {
            return mCards.get(position);
        }

        @Override
        public int getViewTypeCount() {
            return CardBuilder.getViewTypeCount();
        }

        @Override
        public int getItemViewType(int position){
            return mCards.get(position).getItemViewType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return mCards.get(position).getView(convertView, parent);
        }
    }
}
