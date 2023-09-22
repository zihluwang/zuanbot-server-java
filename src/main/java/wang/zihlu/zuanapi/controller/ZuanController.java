package wang.zihlu.zuanapi.controller;

import com.mybatisflex.core.activerecord.query.OrderByBuilder;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.zihlu.zuanapi.service.ZuanService;

import java.util.Objects;

import static wang.zihlu.zuanapi.entity.table.ZuanTableDef.ZUAN;

/**
 * ZuanController
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
@Slf4j
@RestController
@RequestMapping("/zuan")
public class ZuanController {

    private final ZuanService zuanService;

    @Autowired
    public ZuanController(ZuanService zuanService) {
        this.zuanService = zuanService;
    }

    @GetMapping("/")
    public ResponseEntity<String> randomOne(@RequestParam(required = false) String level) {
        return ResponseEntity.ok(zuanService.getRandomOne(level).getText());
    }

}
