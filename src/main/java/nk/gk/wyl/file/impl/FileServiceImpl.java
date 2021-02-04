package nk.gk.wyl.file.impl;

import nk.gk.wyl.file.api.FileService;
import nk.gk.wyl.file.util.FileUtil;
import nk.gk.wyl.file.util.file.FileUtilCommon;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadOnlyOne(MultipartFile file) throws Exception {
        // 开始上传
        return FileUtil.uploadFile(file);
    }

    /**
     * 下载文件
     *
     * @param path       文件名称
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    public void download(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        FileUtilCommon.download(request,response,FileUtil.getUploadFile(),path);
    }
}
