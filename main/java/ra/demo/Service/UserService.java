package ra.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.demo.Model.dto.UserLoginDTO;
import ra.demo.Model.dto.UserRegisterDTO;
import ra.demo.Model.entity.User;
import ra.demo.Model.entity.UserLogin;
import ra.demo.Repository.UserRepository;

@Service
public class UserService {
        @Autowired
        private UserRepository userRepository;

        @Autowired
        private CloudinaryService cloudinaryService;

        @Transactional
        public boolean checkUsernameExisted (String userName){
            return userRepository.findByUsername(userName) != null;
        }

        @Transactional
        public User login(UserLoginDTO userLogin){
            User user = userRepository.login(userLogin.getUsername(), userLogin.getPassword());
            if(user != null){
                    UserLogin.user=user;
            }
            return user;
        }

        @Transactional
        public User register(UserRegisterDTO userRegisterDTO){
                User user = User
                        .builder()
                                .email(userRegisterDTO.getEmail())
                                        .userName(userRegisterDTO.getUserName())
                                                .password(userRegisterDTO.getPassword())
                        .build();
                if (userRegisterDTO.getAvatar()!=null && !userRegisterDTO.getAvatar().isEmpty()){
                        String urlImage = cloudinaryService.upload(userRegisterDTO.getAvatar());
                        user.setAvatar(urlImage);
                }
                return userRepository.register(user);
        }

        public void logout(){
                UserLogin.user=null;
        }
}
