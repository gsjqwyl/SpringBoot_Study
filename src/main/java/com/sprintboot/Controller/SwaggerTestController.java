package com.sprintboot.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Api：描述Controller
 * @ApiIgnore：忽略该Controller，指不对当前类做扫描
 * @ApiOperation：描述Controller类中的method接口
 * @ApiParam：单个参数描述，与@ApiImplicitParam不同的是，他是写在参数左侧的。如（@ApiParam(name = "username",value = "用户名") String username）
 * @ApiModel：描述POJO对象
 * @ApiProperty：描述POJO对象中的属性值
 * @ApiImplicitParam：描述单个入参信息
 * @ApiImplicitParams：描述多个入参信息
 * @ApiResponse：描述单个出参信息
 * @ApiResponses：描述多个出参信息
 * @ApiError：接口错误所返回的信息
 */
@RestController
@Api(value = "Swagger测试API")
@RequestMapping("/swagger")
public class SwaggerTestController {

    @RequestMapping("/create")
    @ApiOperation(value = "创建实体")
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(name = "name", value = "姓名")
    )
    public String getSwaggerEntity(String name) {
        return name;
    }
}
