package lijingqian.example.lenovo.gwc_myselfe_dexv.model;

import lijingqian.example.lenovo.gwc_myselfe_dexv.bean.ShopBean;

/**
 * Created by lenovo on 2017/11/22.
 */

public interface MainModelCallBack {

    public void success(ShopBean bean);
    public  void  failure(Exception e);


}
