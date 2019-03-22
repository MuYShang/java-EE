package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;
import service.UserService;

import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user;
    @Override
    public User getModel() {
        return user;
    }
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String findAllUser(){
        List<User> list = this.userService.findAllUser();
        ActionContext.getContext().getSession().put("list",list);
        return "list";
    }
}
