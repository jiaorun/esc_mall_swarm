package com.esc.mall.controller;

import com.esc.mall.domain.CommonResult;
import com.esc.mall.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 用户ribbon 控制层
 *
 * @author jiaorun
 * @date 2022/1/6 17:02
 **/
@RestController
@RequestMapping("/user")
public class UserRibbonController {

    @Value("${service-url.consul-user-service}")
    private String userServiceUrl;

    private RestTemplate restTemplate;

    @Autowired
    public UserRibbonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/create", user, CommonResult.class);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", user, CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult<User> getById(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return restTemplate.postForObject(userServiceUrl + "/user/{1}", null, CommonResult.class, id);
    }

    @GetMapping("/getUserByUsername")
    public CommonResult getByIds(@RequestParam String username) {
        return restTemplate.getForObject(userServiceUrl + "/user/getByUsername?username={1}", null, CommonResult.class, username);
    }

    @GetMapping("/getEntityByUsername")
    public CommonResult getEntityByUsername(@RequestParam String username) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(userServiceUrl + "/user/getByUsername?username={1}", CommonResult.class, username);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return new CommonResult(500, "操作失败");
    }
}
