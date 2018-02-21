package pattern.obsevable.com.observablepattern.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import pattern.obsevable.com.observablepattern.ChangeTemp;
import pattern.obsevable.com.observablepattern.R;

public class StatusFragment extends Fragment implements Observer{
    private Observable changeTempObserver;
    private TextView mTextViewStatus;

    public StatusFragment() {
    }

    public static StatusFragment newInstance(int i, String s) {
        StatusFragment statusFragment = new StatusFragment();
        return statusFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        mTextViewStatus = (TextView)view.findViewById(R.id.text_view_status);

        return  view;
    }

    @Override
    public void onAttach(Context context) {
        changeTempObserver = ChangeTemp.getInstance();
        changeTempObserver.addObserver(this);
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        changeTempObserver.deleteObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof ChangeTemp ){
            mTextViewStatus.setText(o.toString());
        }
    }
}
