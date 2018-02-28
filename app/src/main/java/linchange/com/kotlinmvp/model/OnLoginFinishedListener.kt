package linchange.com.kotlinmvp.model

/**
 * Created by lkmc2 on 2018/2/28.
 * 登陆结束监听器
 */
interface OnLoginFinishedListener {
    fun onUsernameError() //用户名输入错误
    fun onPasswordError() //密码输入错误
    fun onSuccess() //登陆成功
}