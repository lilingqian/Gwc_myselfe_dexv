package lijingqian.example.lenovo.gwc_myselfe_dexv.model;

import lijingqian.example.lenovo.gwc_myselfe_dexv.bean.ShopBean;
import lijingqian.example.lenovo.gwc_myselfe_dexv.okhttp.AbstractUiCallBack;
import lijingqian.example.lenovo.gwc_myselfe_dexv.okhttp.OkhttpUtils;

/**
 * Created by lenovo on 2017/11/22.
 */

public class MainModel {

    public  void getData(final MainModelCallBack callBack){

        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=100", new AbstractUiCallBack<ShopBean>() {
            @Override
            public void success(ShopBean bean) {

                callBack.success(bean);

            }

            @Override
            public void failure(Exception e) {

                callBack.failure(e);
            }
        });


    }

}
