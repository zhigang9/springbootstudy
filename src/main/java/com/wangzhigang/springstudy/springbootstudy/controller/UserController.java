package com.wangzhigang.springstudy.springbootstudy.controller;

import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import com.wangzhigang.springstudy.springbootstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    @RequestParam：一般我们使用该注解来获取多个参数，
    在（）内写入需要获取参数的参数名即可，一般在PUT，POST中比较常用。
     */

    /*
    @RequestBody：该注解和@RequestParam殊途同归，我们使用该注解将所有参数转换，
    在代码部分在一个个取出来，也是目前我使用到最多的注解来获取参数（
    因为前端不愿意一个一个接口的调试）例如下代码：
    @PostMapping("/createUserByMap")
    public void createUserByMap(@RequestBody Map<String,Object> reqMap){
    String tel = reqMap.get("tel").toString();
    String pwd = reqMap.get("pwd").toString();
    userService.createUser(tel,pwd);
    }
     */
    /*@PostMapping("/createuser")
    public void createUser(@RequestParam("tel") String tel,@RequestParam("pwd") String password){

        userService.createUser(tel,password);
    }

    请求参数：{"tel":"11111111111111111","pwd":"1111111111111111"}

    */

    @PostMapping("/createuser")
    public void createUser(@RequestBody Map<String,Object> reqMap){

        String tel = reqMap.get("tel").toString();
        String pwd = reqMap.get("pwd").toString();

        userService.createUser(tel,pwd);
    }

    @PostMapping("/createuserbyentry")

    public String createUserByEntry(@Valid UserInfo userInfo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){

            return bindingResult.getFieldError().getDefaultMessage();
        }

        userService.createUser(userInfo.getTel(),userInfo.getPassword());
        return "OK";
    }


    /*
    @PathVariable：一般我们使用URI template样式映射使用，
    即url/{param}这种形式，也就是一般我们使用的GET，
    DELETE，PUT方法会使用到的，我们可以获取URL后所跟的参数
     */
    @PutMapping("/updateuser/{id}")
    public int updateUser(@PathVariable("id") String user_id,@RequestParam("nickName") String nickName){

        return userService.updateUser(user_id,nickName);

    }

    @GetMapping("/getuser/{id}")
    public UserInfo getUser(@PathVariable("id") Integer id){

        return userService.getUser(id);
    }

    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable("id") Integer id){

        userService.deleteUser(id);
    }
}
