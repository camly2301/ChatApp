package com.project.event;

import com.project.model.Model_Login;
import com.project.model.Model_Register;

public interface EventLogin {

    // các hàm để xử lý sự kiện
    public void login(Model_Login data);

    public void register(Model_Register data, EventMessage message);

    public void goLogin();

    public void goRegister();
}
