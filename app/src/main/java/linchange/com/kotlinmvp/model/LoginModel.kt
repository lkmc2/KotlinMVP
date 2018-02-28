package linchange.com.kotlinmvp.model

/**
 * Created by lkmc2 on 2018/2/28.
 * 登陆模型（Model层）
 */
interface LoginModel {
    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @param listener 登陆结束监听器
     */
    fun login(username: String, password: String, listener: OnLoginFinishedListener)
}