package com.wangzhigang.springstudy.springbootstudy.controller;

import com.wangzhigang.springstudy.springbootstudy.model.UserInfo;
import com.wangzhigang.springstudy.springbootstudy.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /*nihaouser*/

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

    @PostMapping("/createuserbymap")
    public void createUserByMap(@RequestBody Map<String,Object> requestMap){

        String tel = requestMap.get("tel").toString();
        String pwd = requestMap.get("pwd").toString();

        userService.createUser(tel,pwd);
    }

    @PostMapping("/createuserbyentry")
    @ApiOperation(value = "创建用户",notes = "使用手机和密码创建用户，传入为用户实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userInfo",value = "用户实体",required = true,dataType = "UserInfo")
    })
    public String createUserByEntry(@Valid UserInfo userInfo, BindingResult bindingResult){

        LOGGER.info("电话" + userInfo.getTel());
        LOGGER.info("密码" + userInfo.getPassword());

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
    @ApiOperation(value = "更新用户",notes = "更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id",value = "用户ID",required = true,dataType = "String"),
            @ApiImplicitParam(name = "nickName",value = "用户名",required = true,dataType = "String")
    })
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
