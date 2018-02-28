package linchange.com.kotlinmvp.view

/**
 * Created by lkmc2 on 2018/2/28.
 * 登陆界面接口（View层）
 */
interface LoginView {
    fun showProgress() //展示进度条
    fun hideProgress() //隐藏进度条
    fun setUsernameError() //设置用户名错误
    fun setPasswordError() //设置密码错误
    fun navigateToHome() //导航到桌面
}