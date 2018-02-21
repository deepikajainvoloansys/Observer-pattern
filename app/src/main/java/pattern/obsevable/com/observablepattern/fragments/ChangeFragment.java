package pattern.obsevable.com.observablepattern.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;

import pattern.obsevable.com.observablepattern.ChangeTemp;
import pattern.obsevable.com.observablepattern.R;

public class ChangeFragment extends Fragment {
    private ChangeTemp changeTemp;
    private Button mButtonChange;
    private TextView mTextViewTemp;
    private int i = 0;

    public ChangeFragment() {
    }

    public static ChangeFragment newInstance(int i, String s) {
        ChangeFragment changeFragment = new ChangeFragment();

        return changeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeTemp = ChangeTemp.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change, container, false);

        mButtonChange = (Button) view.findViewById(R.id.button_increase);
        mTextViewTemp = (TextView) view.findViewById(R.id.text_view_temp);

        mButtonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                mTextViewTemp.setText(i + "");
                if (i > 20) {
                    changeTemp.changeTempStatus("High");
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
