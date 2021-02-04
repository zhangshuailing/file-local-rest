package nk.gk.wyl.file.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nk.gk.wyl.file.api.FileService;
import nk.gk.wyl.file.entity.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 实现层
 */
@RestController
@RequestMapping("/upload")
@Api(tags = "文件上传文档",value = "文件上传文档")
public class FileRestController {

    @Autowired
    private FileService fileService;

    @PostMapping(value = "one",consumes = "multipart/*",headers = "content-type=multipart/form-data")
    @ApiOperation(value = "文件上传")
    public @ResponseBody
    Response uploadTxt(MultipartFile file){
        try {
            return new Response().success(fileService.uploadOnlyOne(file));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response().error(e.getMessage());
        }
    }

    /**
     * 下载
     * @param path 文件
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "download")
    @ApiOperation(value = "下载文件")
    public @ResponseBody Response download(@RequestParam("path") String path, HttpServletRequest request, HttpServletResponse response){
        try {
            fileService.download(path,request,response);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return new Response().error(e.getMessage());
        }
    }
}
