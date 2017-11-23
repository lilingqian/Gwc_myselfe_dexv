package lijingqian.example.lenovo.gwc_myselfe_dexv.presenter;

import lijingqian.example.lenovo.gwc_myselfe_dexv.bean.ShopBean;
import lijingqian.example.lenovo.gwc_myselfe_dexv.model.MainModel;
import lijingqian.example.lenovo.gwc_myselfe_dexv.model.MainModelCallBack;
import lijingqian.example.lenovo.gwc_myselfe_dexv.view.MainViewListener;

/**
 * Created by lenovo on 2017/11/22.
 */

public class MainPresenter {

    //实例化这个listener
    private MainViewListener listener;
    //model传过来
    private MainModel mainModel;
    public MainPresenter(MainViewListener listener ){
        this.listener=listener;
        this.mainModel= new MainModel();
    }

    public  void  getData(){
     mainModel.getData(new MainModelCallBack() {

         @Override
         public void success(ShopBean bean) {
         if (listener!=null){
             listener.success(bean);
         }
         }

         @Override
         public void failure(Exception e) {

             if(listener != null){
                 listener.failure(e);
             }
         }
     });
    }

    //消除内存泄漏
    public  void detach(){
        listener=null;

    }

}
