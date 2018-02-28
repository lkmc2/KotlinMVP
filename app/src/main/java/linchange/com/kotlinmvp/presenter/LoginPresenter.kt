package linchange.com.kotlinmvp.presenter

/**
 * Created by lkmc2 on 2018/2/28.
 * 登陆Presenter（Presenter层）
 */
interface LoginPresenter {
    /**
     * 验证用户信息
     * @param username
     * @param password
     */
    fun validateUserInfo(username:String,password:String)

    fun onDestroy() //销毁view
}