package linchange.com.kotlinmvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import linchange.com.kotlinmvp.presenter.LoginPresenter
import linchange.com.kotlinmvp.presenter.LoginPresenterImpl
import linchange.com.kotlinmvp.view.LoginView
import org.jetbrains.anko.toast

/**
 * 主界面Activity（View层）
 */
class MainActivity : AppCompatActivity(),
        LoginView, View.OnClickListener { //实现Login和OnClickListener接口

    private lateinit var  presenter: LoginPresenter //登陆Presenter（延迟初始化）

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this) //为按钮设置点击事件监听器

        presenter = LoginPresenterImpl(this) //初始化presenter
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE //显示进度条
    }

    override fun hideProgress() {
        progress.visibility = View.GONE //隐藏进度条
    }

    override fun setUsernameError() {
        username.error = "用户名错误" //给用户名输入框设置错误信息
    }

    override fun setPasswordError() {
        password.error = "密码错误" //给密码输入框设置错误信息
    }

    override fun navigateToHome() {
        toast("登陆成功") //提示登陆成功
    }

    override fun onClick(v: View?) {
        //验证用户信息
        presenter.validateUserInfo(username.text.toString(), password.text.toString())
    }
}
