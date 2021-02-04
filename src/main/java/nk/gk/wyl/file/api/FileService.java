package nk.gk.wyl.file.api;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 文件接口
 */
public interface FileService {
    /**
     * 单个下载
     * @param file
     * @return
     * @throws Exception
     */
    String uploadOnlyOne(MultipartFile file) throws Exception;

    /**
     * 下载文件
     * @param id 文件名称
     * @param request
     * @param response
     * @throws Exception
     */
    void download(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;


}
