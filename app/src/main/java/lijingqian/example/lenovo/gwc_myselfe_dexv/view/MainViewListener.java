package lijingqian.example.lenovo.gwc_myselfe_dexv.view;

import lijingqian.example.lenovo.gwc_myselfe_dexv.bean.ShopBean;

/**
 * Created by lenovo on 2017/11/22.
 */

public interface MainViewListener {


    public void success(ShopBean bean);
    public  void  failure(Exception e);

}
