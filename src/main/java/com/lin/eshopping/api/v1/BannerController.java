package com.lin.eshopping.api.v1;

import com.lin.eshopping.exception.http.ForbiddenException;
import com.lin.eshopping.exception.http.NotFoundException;
import com.lin.eshopping.model.Banner;
import com.lin.eshopping.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="BannerController")
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation(value = "获取Banner", response =  Banner.class, tags = "getByName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code=404, message = "not found!!!")
    })
    @GetMapping("/name/{name}")
    public Banner getByName(@PathVariable String name) {
        return bannerService.getByName(name);
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("test");
        throw new ForbiddenException(10001);
    }
}
