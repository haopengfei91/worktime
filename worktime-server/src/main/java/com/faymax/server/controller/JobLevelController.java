package com.faymax.server.controller;


import com.faymax.server.entity.JobLevel;
import com.faymax.server.entity.RespBean;
import com.faymax.server.service.JobLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Faymax
 * @since 2021-03-24
 */

@Api(tags = "JobLevelController")
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    private JobLevelService jobLevelService;

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        jobLevel.setCreateDate(LocalDateTime.now());
        if (jobLevelService.save(jobLevel)) {
            return RespBean.success("添加成功");
        }
        return RespBean.fail("添加失败");
    }

    @ApiOperation(value = "更新职称信息")
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateById(jobLevel)) {
            return RespBean.success("更新成功");
        }
        return RespBean.fail("更新失败");
    }

    @ApiOperation(value = "删除职称")
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        if (jobLevelService.removeById(id)) {
            return RespBean.success("删除成功");
        }
        return RespBean.fail("删除失败");
    }

    @ApiOperation(value = "批量删除职称")
    @DeleteMapping("/")
    public RespBean deleteJobLevelByIds(Integer[] ids) {
        if (jobLevelService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success("批量删除成功");
        }
        return RespBean.fail("批量删除失败");
    }
}
