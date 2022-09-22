package com.boot.mvc20220916youri.repository;

import com.boot.mvc20220916youri.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("a") //빈으로 등록하는 어노테이션
// @Autowired와 연관된 기능
public class UserRepositoryImpl implements UserRepository {
    private final List<User> userData; //final이 들어간 이유?

    public UserRepositoryImpl() {
        userData = new ArrayList<User>();
        // 사용자 현재 정보

        for(int i = 0; i < 5; i++) {
            int index = i + 1;

            User user = User.builder()
                    .user_code(index)
                    .user_id("junil" + index)
                    .user_password("1234")
                    .user_name("김준" + index)
                    .user_email("a" + index + "@gmail.com")
                    .build();

            userData.add(user); // user를 userData에 추가한다.
        }
    }


    @Override
    public int save(User user) {
        try {
            int maxCode = 0;
            for(User u : userData){ //userData 리스트를 다 돌린다. u가 for문의 i 같은거
                if(u.getUser_code() > maxCode) {
                    maxCode = u.getUser_code();
                    // userData속 usercode 마지막번호 찾기
                }
            }
            maxCode++; //마지막 번호에서 +1 한다.

            user.setUser_code(maxCode);
            userData.add(user);
        }catch (Exception e) {
            return 0; //문제 없으니 넘겨라!
        }
        return 1; // 이거 용도가 뭐지?
    }


    @Override
    public User findUserByUserId(String userId) {
        User user = null;

        for(User userObj: userData) {
            if (userObj.getUser_id().equals(userId)) {
                user = userObj;
            }
        }
        return user;
    }

    @Override
    public User findUserByUserCode(int userCode) {
        User user = null;

        for(User userObj: userData) {
            if (userObj.getUser_code() == userCode) {
                user = userObj;
            }
        }

        return user;
    }

    @Override
    public int modify(User user) {
        return 0;
    }

    @Override
    public int remove(int userCode) {
        return 0;
    }
}