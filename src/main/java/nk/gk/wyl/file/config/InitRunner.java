package nk.gk.wyl.file.config;

import nk.gk.wyl.file.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class InitRunner {
    @Value("${uploadFilePath}")
    private String uploadFile;

    @Bean
    public int run(){
        FileUtil.setUploadFile(uploadFile);
        return 0;
    }

}
