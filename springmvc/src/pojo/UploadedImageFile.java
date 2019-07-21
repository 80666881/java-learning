package pojo;

import org.springframework.web.multipart.MultipartFile;

public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getSuffix(){
        String filename = image.getOriginalFilename();
//        获取后缀名
        String suffix =  filename.substring(filename.lastIndexOf(".")).toLowerCase();
        return suffix;
    }
}
