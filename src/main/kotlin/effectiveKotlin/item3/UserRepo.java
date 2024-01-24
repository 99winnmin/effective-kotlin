package effectiveKotlin.item3;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class UserRepo {
    public @NotNull User getUser() {
        return new User();
    }

    public List<User> getUsers() {
        return Arrays.asList(new User(), new User());
    }

    public List<List<User>> getGroupedUsers() {
        return Arrays.asList(
                Arrays.asList(new User(), new User()),
                Arrays.asList(new User(), new User()));
    }
}
