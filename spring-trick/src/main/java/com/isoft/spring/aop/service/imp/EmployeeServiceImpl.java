package com.isoft.spring.aop.service.imp;

import com.isoft.spring.aop.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

    @Override
    public void someLogic() {
        System.out.println("do something");
    }


}
