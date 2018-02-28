package linchange.com.kotlinmvp.presenter

import linchange.com.kotlinmvp.model.LoginModel
import linchange.com.kotlinmvp.model.LoginModelImpl
import linchange.com.kotlinmvp.model.OnLoginFinishedListener
import linchange.com.kotlinmvp.view.LoginView

/**
 * Created by lkmc2 on 2018/2/28.
 * 登陆Presenter实现类
 */

class LoginPresenterImpl(private var loginView: LoginView?) : LoginPresenter, OnLoginFinishedListener {
    //loginView是登陆界面

    private val loginModel : LoginModel //登陆模型

    init {
        this.loginModel = LoginModelImpl() //实例化登陆模型
    }

    override fun validateUserInfo(username: String, password: String) {
        loginView?.showProgress() //显示进度条
        loginModel.login(username,password, this) //使用用户名和密码登陆
    }

    override fun onDestroy() {
        this.loginView = null //销毁登陆界面
    }

    override fun onUsernameError() {
        loginView?.apply { //登陆界面非空，操作loginView中的方法
            setUsernameError() //设置用户名错误
            hideProgress() //隐藏进度条
        }
    }

    override fun onPasswordError() {
        loginView?.apply { //登陆界面非空，操作loginView中的方法
            setPasswordError() //设置密码错误
            hideProgress() //隐藏进度条
        }
    }

    override fun onSuccess() {
        loginView?.apply { //登陆界面非空，操作loginView中的方法
            navigateToHome() //回到主界面
            hideProgress() //隐藏进度条
        }
    }

}