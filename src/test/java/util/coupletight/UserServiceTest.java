package util.coupletight;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @Test
    void getUser() {
        // Arrange
        UserDB mockUserDb = mock(UserDB.class);
        UserService userService = new UserService();
        String expected = "John Brook";
        // Act
        when(mockUserDb.getUserFromDB(any())).thenReturn(expected);
        String response = userService.getUser("anyIdWillDo");
        // Assert
        assertEquals(expected, response);
    }
}

