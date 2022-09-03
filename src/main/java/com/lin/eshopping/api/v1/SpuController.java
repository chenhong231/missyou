package com.lin.eshopping.api.v1;

import com.lin.eshopping.exception.http.NotFoundException;
import com.lin.eshopping.model.Spu;
import com.lin.eshopping.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive Long id) {
        Spu spu = spuService.getSpu(id);
        if(spu == null) {
            throw new NotFoundException(30003);
        }

        return spu;
    }

    @GetMapping("/latest")
    public List<Spu> getLatestSpuList() {
        return this.spuService.getLatestPagingSpu();
    }
}
