package linchange.com.kotlinmvp.model

import android.os.Handler
import android.text.TextUtils

/**
 * Created by lkmc2 on 2018/2/28.
 * 登陆模型实现类（延迟2秒后登陆，用户名和密码非空则登陆成功）
 */
class LoginModelImpl : LoginModel {
    override fun login(username: String, password: String, listener: OnLoginFinishedListener) {
        Handler().postDelayed({
            var error = false //登陆失败标记
            if (TextUtils.isEmpty(username)) { //用户名为空
                listener.onUsernameError() //用户名输入错误
                error = true
            }
            if (TextUtils.isEmpty(password)) { //密码为空
                listener.onPasswordError() //密码输入错误
                error = true
            }
            if (!error) {
                listener.onSuccess() //登陆成功
            }
        }, 2000)
    }

}