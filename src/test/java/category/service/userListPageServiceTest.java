package category.service;

import category.user.UserRepository;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import category.user.User;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class userListPageServiceTest {

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Mock
    UserRepository userRepository;


//    @Test
//    public void 전체(){
//        User user1 =  new User();
//        user1.setEmail("ly91@nave.com");
//        user1.setId(1L);
//        user1.setName("ㅇㅇ");
//        user1.setPassword("1");
//        user1.setUserId("1");
//        when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));
//        System.out.println("********"+pageService.test(user1.getId()));
//
//        Long b = pageService.maxAll();
//
//        softly.assertThat(b).isEqualTo(1);
//
//    }


    @Test
    public void 전체페이지(){

    }
}