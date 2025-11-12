package ra.demo.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {
@Autowired
    private Cloudinary cloudinary;

    public String upload(MultipartFile file) {
        try{
            Map<String,Object> rs = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return rs.get("url").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
