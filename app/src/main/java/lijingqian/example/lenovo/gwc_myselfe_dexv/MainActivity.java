package lijingqian.example.lenovo.gwc_myselfe_dexv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lijingqian.example.lenovo.gwc_myselfe_dexv.bean.ShopBean;
import lijingqian.example.lenovo.gwc_myselfe_dexv.presenter.MainPresenter;
import lijingqian.example.lenovo.gwc_myselfe_dexv.view.MainViewListener;

public class MainActivity extends AppCompatActivity implements MainViewListener{

    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    CheckBox checkBoxAll;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)

    LinearLayout thirdPayLinear;
    private MainPresenter presenter;
    private ShopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //将presenter new出来
         presenter=new MainPresenter(this);
        //调取数据
         presenter.getData();
        //adapter
        adapter=new ShopAdapter(this);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        thirdRecyclerview.setLayoutManager(manager);
        thirdRecyclerview.setAdapter(adapter);

        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num,boolean allCheck) {

                checkBoxAll.setChecked(allCheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);
            }
        });


    }

    @Override
    public void success(ShopBean bean) {
        Log.i("bean",bean.toString());
        adapter.add(bean);
    }

    @Override
    public void failure(Exception e) {

        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        presenter.detach();
    }

    @OnClick(R.id.third_allselect)
    public void onViewClicked() {

        adapter.selectAll(checkBoxAll.isChecked());

    }
}
