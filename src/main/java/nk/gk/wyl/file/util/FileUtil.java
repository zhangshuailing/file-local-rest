package nk.gk.wyl.file.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件工具
 */
public class FileUtil {

    private static String uploadFile;

    public static String getUploadFile() {
        return uploadFile;
    }

    public static void setUploadFile(String uploadFile) {
        FileUtil.uploadFile = uploadFile;
    }

    /**
     * 非空校验
     * @param file
     * @return
     * @throws Exception
     */
    public static void checkFile(MultipartFile file) throws Exception {
        if(file==null){
            throw new Exception("file不能为null");
        }
        long size = file.getSize();
        if (size == 0L) {
            throw new Exception("上传的文件为空");
        }
    }

    /**
     * 文件上传
     * @param file
     * @return
     * @throws Exception
     */
    public static String uploadFile(MultipartFile file) throws Exception{
        checkFile(file);
        String name = file.getOriginalFilename();
        String f_path = Util.getStrPath();
        File file1 = new File(uploadFile+f_path);
        if(!file1.exists()){
            file1.mkdirs();
        }
        File file_ = new File(uploadFile+f_path+name);
        file.transferTo(file_);
        return f_path+name;
    }
}
