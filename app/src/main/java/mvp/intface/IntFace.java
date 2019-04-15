package mvp.intface;

import java.util.List;

import bean.UserBean;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/4/15 9:40
 * @Description：描述信息
 */
public class IntFace {
    //接口    Model
    public  interface  ModelInterFace{

    }
    //View
    public  interface ModelViewInterFace{
       //   void success(data);
       //   void  faild(error);

    }
    //Presenter
    public  interface  ModelPresenterInterFace{
        void toshow(List<UserBean> list);

    }
}
